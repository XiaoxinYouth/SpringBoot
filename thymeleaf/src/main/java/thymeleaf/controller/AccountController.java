package thymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import thymeleaf.domain.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 小新青年
 * @date : 2019-11-25  22:09
 * 描述 :
 **/
@RestController
public class AccountController {
    @RequestMapping("/accounts")
    public ModelAndView accounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, "aaa", 100.0));
        accounts.add(new Account(2, "bbb", 100.0));

        ModelAndView mv = new ModelAndView();
        mv.addObject("accounts",accounts);
        mv.setViewName("accounts");
        return mv;
    }
}
