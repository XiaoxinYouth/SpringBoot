package thymeleaf.sp1.service;

import thymeleaf.sp1.domain.Account;

import java.util.List;

/**
 * @author : 小新青年
 * @date : 2019-11-24  17:20
 * 描述 : Account 服务层接口
 **/

public interface AccountService {

    /**
     * 查询所有
     *
     * @return 账户集合
     */
    List<Account> getAllAccount();

    /**
     * 根据 id 查询账户
     *
     * @param id 要查询的账户 id
     * @return 要查询的账户
     */
    Account getAccountById(Integer id);

    /**
     * 增加账户
     *
     * @param account 要增加的账户
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     *
     * @param account 更新后的账户
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     *
     * @param id 要删除的账户 id
     */
    void deleteAccountById(Integer id);
}
