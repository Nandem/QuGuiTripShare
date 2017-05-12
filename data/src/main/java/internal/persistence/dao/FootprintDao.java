package internal.persistence.dao;

import internal.persistence.model.Footprint;
import internal.persistence.model.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author Nandem on 2017-05-08.
 */
@MapperScan
public interface FootprintDao extends BaseDao<Footprint>
{
    List<Footprint> getFootprintListByUser(@Param("affiliationUser") String affiliationUser);

    User getAffiliationUser(@Param("footprintID") String footprintID);

    List<Footprint> getSearchResult(@Param("key") String key);
}
