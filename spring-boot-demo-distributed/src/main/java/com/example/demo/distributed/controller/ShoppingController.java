package com.example.demo.distributed.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xg
 * @date 2022-09-02 16:14
 */
@RestController
@RequestMapping("/goods")
public class ShoppingController {

    @Resource
    private StringRedisTemplate redisTemplate;

    private Lock lock = new ReentrantLock();


    @RequestMapping("/shopping")
    public String shopping() {
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "1");
        while (! lock) {
            lock = redisTemplate.opsForValue().setIfAbsent("lock", "1");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            handleShopping();
        } finally {
            redisTemplate.delete("lock");
        }

        return "购物成功。";
    }

    private void handleShopping() {
        String key = "good_count";

        String countStr = redisTemplate.opsForValue().get(key);
        if (null == countStr) {
            return;
        }
        int count = Integer.parseInt(countStr);
        if (count == 0) {
            return;
        }
        count--;
        redisTemplate.opsForValue().set(key, count + "");
    }

}
