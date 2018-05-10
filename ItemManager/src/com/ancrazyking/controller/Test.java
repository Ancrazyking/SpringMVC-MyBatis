package com.ancrazyking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ancrazyking
 * @date 2018/5/10 15:12
 **/
@Controller
public class Test
{
    @RequestMapping("/hello.action")
    public ModelAndView  hello(){

        System.out.println("Hello World!");

        ModelAndView mav=new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/success.jsp");
        return mav;
    }


    @RequestMapping("/test.action")
    public String hello2(){



        return "success";
    }
}
