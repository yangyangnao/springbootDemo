package com.chenbing.base.controller;

import com.chenbing.base.entity.AccountEntity;
import com.chenbing.base.param.UserListReqParam;
import com.chenbing.base.service.UserService;
import com.chenbing.utils.PageModel;
import com.chenbing.utils.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/base/login");
        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }

    @RequestMapping("list")
    public Result<PageModel<AccountEntity>> getList(UserListReqParam reqParam){
        PageModel<AccountEntity> list = userService.getList(reqParam);

        logger.info("共查询到了"+list.getTotal()+"条信息");
        return new Result<>(list);
    }
}
