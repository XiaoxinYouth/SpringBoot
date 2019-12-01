package xin.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    Account account;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(account);
        System.out.println("-----------xiaoxin-----------HelloController.hello()方法执行了");
        return "Hello World!";
    }

    @RequestMapping("/world")
    public String world() {
        System.out.println("-----------xiaoxin-----------HelloController.world()方法执行了");
        return "World!";
    }
}
