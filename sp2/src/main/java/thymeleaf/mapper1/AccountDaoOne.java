package thymeleaf.mapper1;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import thymeleaf.domain.Account;

import java.util.List;

/**
 * @author : 小新青年
 * @date : 2019-11-25  17:18
 * 描述 : 1
 **/
@Repository
public interface AccountDaoOne {

    @Select("select * from account")
    List<Account> getAllAccounts();
}
