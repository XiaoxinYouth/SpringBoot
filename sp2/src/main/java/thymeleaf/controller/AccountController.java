package thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thymeleaf.mapper1.AccountDaoOne;
import thymeleaf.mapper2.AccountDaoTwo;
import thymeleaf.domain.Account;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : 小新青年
 * @date : 2019-11-25  16:32
 * 描述 :
 **/
@RestController
public class AccountController {
    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;
    @Resource(name = "jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;

    @Autowired
    private AccountDaoOne daoOne;
    @Autowired
    private AccountDaoTwo daoTwo;

    @RequestMapping("/template")
    public String template() {
        List<Account> list1 = jdbcTemplateOne.query("select * from `chapter05-1`.account",
                new BeanPropertyRowMapper<>(Account.class));
        List<Account> list2 = jdbcTemplateTwo.query("select * from `chapter05-2`.account",
                new BeanPropertyRowMapper<>(Account.class));
        String result = list1.toString() + list2.toString();
        System.out.println(result);
        return "我是 template"+result;
    }

    @RequestMapping("/mybatis")
    public String mybatis(){
        List<Account> list1 = daoOne.getAllAccounts();
        List<Account> list2 = daoTwo.getAllAccounts();

        String result = list1.toString() + list2.toString();
        System.out.println(result);
        return result;
    }
}
