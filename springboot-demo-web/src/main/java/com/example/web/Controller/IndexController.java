package com.example.web.Controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author xg
 * @date 2022-03-16 18:18
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "hello, web";
    }

    @PostMapping("/post")
    public String post(@RequestBody String hello) {
        return hello;
    }

}
