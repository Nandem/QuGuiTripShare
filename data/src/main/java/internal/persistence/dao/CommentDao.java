package internal.persistence.dao;

import internal.persistence.model.Comment;
import internal.persistence.model.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Nandem on 2017-05-08.
 */
@MapperScan
public interface CommentDao extends BaseDao<Comment>
{

}
