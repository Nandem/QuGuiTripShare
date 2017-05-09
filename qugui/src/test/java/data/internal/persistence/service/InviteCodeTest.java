package data.internal.persistence.service;

import internal.persistence.model.InviteCode;
import internal.persistence.service.InviteCodeService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author Nandem on 2017-05-09.
 */
public class InviteCodeTest extends BaseTest
{
    @Resource
    private InviteCodeService inviteCodeService;

    @Test
    public void add()
    {
        InviteCode inviteCode = new InviteCode();
        inviteCode.setInviteCode("ABCDEDCBA");
        inviteCode.setRemainingTimes(16);

        System.out.println(inviteCodeService.add(inviteCode));
    }

    @Test
    public void retrieveRemainingTimes()
    {
        System.out.println(inviteCodeService.retrieveRemainingTimes("ABCDEDCBA"));
    }

    @Test
    public void decreaseTimes()
    {
        inviteCodeService.decreaseTimes("ABCDEDCBA");
        System.out.println(inviteCodeService.retrieveRemainingTimes("ABCDEDCBA"));
    }
}
