package internal.persistence.dao;

import internal.persistence.model.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Nandem on 2017-05-08.
 */
@MapperScan
public interface UserDao extends BaseDao<User>
{
    String retrievePasswordByAccount(@Param("account") String account);

    User getUserByUserIDAndPassword(@Param("userID") String userID, @Param("password") String password);

    User getUserByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    int getUserAmount();
}
