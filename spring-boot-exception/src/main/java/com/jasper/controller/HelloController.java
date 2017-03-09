package com.jasper.controller;


import com.jasper.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jasper on 2017/3/8.
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws Exception {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

}
