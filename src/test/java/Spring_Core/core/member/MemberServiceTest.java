package Spring_Core.core.member;
import Spring_Core.core.AppConfig;
import Spring_Core.core.member.Grade;
import Spring_Core.core.member.Member;
import Spring_Core.core.member.MemberService;
import Spring_Core.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach // 파일 시작전 먼저 실행
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {

        // given : 주어져서
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : 상황이 올 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : 해당 동작을 한다
        Assertions.assertThat(member).isEqualTo(findMember); // Assertion을 이용한 결과 비교
        
    }

}
