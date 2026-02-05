package com.qatar22.qatar22.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }

    @GetMapping("/{path:[^\\.]*}")
    public String forward() {
        return "forward:/index.html";
    }
}