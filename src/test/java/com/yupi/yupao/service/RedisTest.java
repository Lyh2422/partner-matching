package com.yupi.yupao.service;

import com.yupi.yupao.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * Redis 测试
 *
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("xunyuString", "dog");
        valueOperations.set("xunyuInt", 1);
        valueOperations.set("xunyuDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("xunyu");
        valueOperations.set("xunyuUser", user);
        // 查
        Object xunyu = valueOperations.get("xunyuString");
        Assertions.assertTrue("dog".equals((String) xunyu));
        xunyu = valueOperations.get("xunyuInt");
        Assertions.assertTrue(1 == (Integer) xunyu);
        xunyu = valueOperations.get("xunyuDouble");
        Assertions.assertTrue(2.0 == (Double) xunyu);
        System.out.println(valueOperations.get("xunyuUser"));
        valueOperations.set("xunyuString", "dog");
        redisTemplate.delete("xunyuString");
    }
}
