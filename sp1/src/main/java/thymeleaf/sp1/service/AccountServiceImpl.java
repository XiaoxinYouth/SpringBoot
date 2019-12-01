package thymeleaf.sp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thymeleaf.sp1.dao.AccountDao;
import thymeleaf.sp1.domain.Account;

import java.util.List;

/**
 * @author : 小新青年
 * @date : 2019-11-23  22:12
 * 描述 : 账户 Service 层接口的实现类
 **/
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;

    @Override
    public List<Account> getAllAccount() {
        return dao.getAllAccount();
    }

    @Override
    public Account getAccountById(Integer id) {
        this.inspect(id);
        return dao.getAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        if (dao.getAccountById(account.getId()) != null) {
            throw new RuntimeException("id 为 "+account.getId()+" 的账户已经存在,请重新选择!");
        }
        dao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        this.inspect(account.getId());
        dao.updateAccount(account);
    }

    @Override
    public void deleteAccountById(Integer id) {
        this.inspect(id);
        dao.deleteAccountById(id);
    }


    /**
     * 检查账户是否存在
     *
     * @param id 账户id
     */
    private void inspect(Integer id) {
        if (dao.getAccountById(id) == null) {
            throw new RuntimeException("id 为 " + id + " 的账户不存在,请仔细核对后再来");
        }
    }

}
