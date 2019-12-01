package xin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.domain.Account;

/**
 * @author : 小新青年
 * @date : 2019-11-26  21:34
 * 描述 :
 **/
@RestController
public class HelloController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    // StringRedisTemplate 是 RedisTemplate 的子类

    @RequestMapping("/test1")
    public String hello() {
        System.out.println("-----------xiaoxin-----------HelloController.hello()方法执行了");
        ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        // ops1.set("name", "三国演义");
        System.out.println(ops1.get("name"));

        ValueOperations ops2 = redisTemplate.opsForValue();
        Account account = new Account(2, "bbb", 34567.7);
        ops2.set("b", account);
        System.out.println(ops2.get("b"));

        return "测试服务器的 redis 成功";
    }


}
