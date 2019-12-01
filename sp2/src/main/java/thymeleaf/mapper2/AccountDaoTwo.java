package thymeleaf.mapper2;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import thymeleaf.domain.Account;

import java.util.List;

/**
 * @author : 小新青年
 * @date : 2019-11-25  17:18
 * 描述 : 2
 **/
@Repository
public interface AccountDaoTwo {
    @Select("select * from account")
    List<Account> getAllAccounts();
}
