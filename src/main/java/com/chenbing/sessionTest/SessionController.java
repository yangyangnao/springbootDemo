package com.chenbing.sessionTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("session")
public class SessionController {

    @RequestMapping(value="getSessionId")
    @ResponseBody
    public String getSessionId(HttpServletRequest request){

        Object o = request.getSession().getAttribute("springboot");
        if(o == null){
            o = "spring boot有端口"+request.getLocalPort()+"生成";
            request.getSession().setAttribute("springboot", o);
        }

        return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>"+o;
    }

}
