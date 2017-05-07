package internal.persistence.dao;

import internal.persistence.model.ScenicSpot;
import internal.persistence.model.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Nandem on 2017-05-08.
 */
@MapperScan
public interface ScenicSpotDao extends BaseDao<ScenicSpot>
{

}
