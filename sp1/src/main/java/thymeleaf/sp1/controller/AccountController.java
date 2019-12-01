package thymeleaf.sp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thymeleaf.sp1.domain.Account;
import thymeleaf.sp1.service.AccountService;

import java.util.List;

/**
 * @author : 小新青年
 * @date : 2019-11-24  15:36
 * 描述 : Account 控制器层
 **/
@RestController
public class AccountController {
    @Autowired
    AccountService service;

    @RequestMapping("/getAllAccount")
    public String getAllAccount(){
        List<Account> list = service.getAllAccount();
        {
            // 打印查询结果
            StringBuilder result = new StringBuilder("下面是查询到的 Account:\r\n");
            for (Account account : list) {
                result.append(account.toString()).append(";\r\n");
            }
            System.out.println(result.toString());
        }
        return list.toString();
    }

    @RequestMapping("/getAccountById")
    public String getAccountById(Integer id) {
        Account accountById = service.getAccountById(id);
        if (accountById == null) {
            return "没有账户 id 等于"+id;
        }
        return accountById.toString();
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        service.saveAccount(account);
        return this.getAllAccount();
    }

    @RequestMapping("/updateAccount")
    public String updateAccount(Account account) {
        service.updateAccount(account);
        return this.getAllAccount();
    }

    @RequestMapping("/deleteAccount")
    public String deleteAccount(Integer id) {
        service.deleteAccountById(id);
        return this.getAllAccount();
    }

}
