package com.chupinadventure.hackathon.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ViewController {


    @RequestMapping(value = {"/", "/collect/**", "/edit/**", "/complete"})
    public String get(final HttpServletResponse response) {

        response.setHeader("Cache-Control", "no-cache");
        response.addHeader("Cache-Control", "no-store");

        return "index.html";
    }


}
