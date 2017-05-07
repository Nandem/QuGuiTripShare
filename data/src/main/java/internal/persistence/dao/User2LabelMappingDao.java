package internal.persistence.dao;

import internal.persistence.model.User;
import internal.persistence.model.User2LabelMapping;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Nandem on 2017-05-08.
 */
@MapperScan
public interface User2LabelMappingDao extends BaseDao<User2LabelMapping>
{

}
