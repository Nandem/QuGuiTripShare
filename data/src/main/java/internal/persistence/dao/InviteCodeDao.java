package internal.persistence.dao;

import internal.persistence.model.InviteCode;
import internal.persistence.model.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Nandem on 2017-05-08.
 */
@MapperScan
public interface InviteCodeDao extends BaseDao<InviteCode>
{
    int retrieveRemainingTimes(@Param("inviteCode") String inviteCode);
    void decreaseTimes(@Param("inviteCode") String inviteCode);
}
