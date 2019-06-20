package com.chenbing.redisTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static final String MY__KEY = "TEST_STRING";
    @RequestMapping("save")
    @ResponseBody
    public String save(@RequestParam(value = "name",required = false) String name,
                       @RequestParam(value = "address",required = false)String address){
        //保存字符串
        stringRedisTemplate.opsForValue().set(MY__KEY,"name:"+name+",address:"+address);
        //保存字符串并设置超时时长及时长单位
        stringRedisTemplate.opsForValue().set(MY__KEY+"1","李思思",30, TimeUnit.SECONDS);
        //根据key获取存储的数据
        System.out.println(stringRedisTemplate.opsForValue().get(MY__KEY));
        //根据key获取过期时间
        System.out.println(stringRedisTemplate.getExpire(MY__KEY+"1"));
        //
        stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合
        stringRedisTemplate.opsForSet().isMember("red_123", "1");//根据key查看集合中是否存在指定数据
        stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合
        return "";
    }


}
