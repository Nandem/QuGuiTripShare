package internal.persistence.dao;

import internal.persistence.model.User;
import internal.persistence.model.UserRelationship;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Nandem on 2017-05-08.
 */
@MapperScan
public interface UserRelationshipDao extends BaseDao<UserRelationship>
{

}
