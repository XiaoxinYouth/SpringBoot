package thymeleaf.sp1.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import thymeleaf.sp1.domain.Account;

import java.util.List;

/**
 * @author : 小新青年
 * @date : 2019-11-23  22:09
 * 描述 : Mybatis 方式操作数据库
 **/
@Repository
@Mapper
public interface AccountDao {
    /**
     * 查询所有
     *
     * @return 账户集合
     */
    @Select("select * from account")
    List<Account> getAllAccount();

    /**
     * 根据 id 查询账户
     *
     * @param id 要查询的账户 id
     * @return 要查询的账户
     */
    @Select("select * from account where id = #{id}")
    Account getAccountById(Integer id);

    /**
     * 增加账户
     *
     * @param account 要增加的账户
     */
    @Insert("insert into account values(#{id},#{name},#{money})")
    void saveAccount(Account account);

    /**
     * 更新账户
     *
     * @param account 更新后的账户
     */
    @Update("update account set name = #{name},money = #{money} where id = #{id}")
    void updateAccount(Account account);

    /**
     * 删除账户
     *
     * @param id 要删除的账户 id
     */
    @Delete("delete from account where id = #{id}")
    void deleteAccountById(Integer id);
}
