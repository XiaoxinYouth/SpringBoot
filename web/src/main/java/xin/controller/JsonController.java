package xin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.bean.Account;

/**
 * @author : 小新青年
 * @date : 2019-11-26  13:14
 * 描述 : 返回 json 数据
 **/
@RestController
public class JsonController {

    @RequestMapping("/account")
    public Account account(){
        return new Account(2,"gqx",190000000.0);
    }
}
