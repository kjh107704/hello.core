package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest  {
    MemberService memberService;
    // 테스트가 실행되기 전에 무조건 돌아가는 것
    // 테스트가 두개 있으면 두번 돌아감!
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join() {
        //given
        Member newMember = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(newMember);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertEquals(newMember, findMember) ;

    }
}
