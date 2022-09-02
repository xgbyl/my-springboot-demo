package com.example.demo.distributed.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xg
 * @date 2022-09-02 15:32
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "hello, spring-boot-demo-distributed";
    }
}
