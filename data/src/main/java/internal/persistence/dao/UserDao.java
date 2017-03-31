package internal.persistence.dao;

import internal.persistence.model.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Nandem on 2017-02-23.
 */
@MapperScan
public interface UserDao
{
    /**
     * 添加用户
     * @param user 用户基础信息封装类
     * @return true：操作成功。false：操作失败。
     */
    boolean addUser(User user);

    /**
     * 删除用户
     * @param ID 用户ID
     * @return true：操作成功。false：操作失败。
     */
    boolean deleteUser(String ID);

    /**
     * 修改用户
     * @param ID 用户ID
     * @param user 需要修改的用户信息封装类（注意，依然是基础信息封装类，只是里面存放的数据是用户提交的最新的数据）
     * @return true：操作成功。false：操作失败。
     */
    boolean updateUser(String ID, User user);

    /**
     * 查找用户
     * @param ID 用户ID
     * @return true：操作成功。false：操作失败。
     */
    User retrieveUser(String ID);

    void selectAll();
}
