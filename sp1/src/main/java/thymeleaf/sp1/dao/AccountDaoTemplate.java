package thymeleaf.sp1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thymeleaf.sp1.domain.Account;

import java.util.List;
import java.util.Map;

/**
 * @author : 小新青年
 * @date : 2019-11-24  22:00
 * 描述 : JDBC Template 方式操作数据库
 **/
@Repository
public class AccountDaoTemplate {
    @Autowired
    private JdbcTemplate template;

    public List<Account> getAllAccount() {
        return template.query("select * from springboot.account",
                new BeanPropertyRowMapper<>(Account.class));
    }

    public Account getAccountById(Integer id) {
        Map<String, Object> map;
        try {
            map = template.queryForMap("select * from springboot.account where id = ?", id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("id 为 " + id + " 的账户不存在,请仔细核对后再来");
        }
        Integer id1 = (Integer)map.get("id");
        String name = (String) map.get("name");
        Double money = (Double) map.get("money");

        return new Account(id1,name,money);
    }

    public void saveAccount(Account account) {
        template.update("insert into springboot.account values(?,?,?)",
                account.getId(), account.getName(), account.getMoney());
    }

    public void updateAccount(Account account) {
        template.update("update springboot.account set name = ?,money = ? where id = ?",
                account.getName(), account.getMoney(), account.getId());
    }

    public void deleteAccountById(Integer id) {
        template.update("delete from springboot.account where id = ?", id);
    }
}
