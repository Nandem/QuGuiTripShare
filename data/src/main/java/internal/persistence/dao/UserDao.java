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

    int getUserAmount();
}
