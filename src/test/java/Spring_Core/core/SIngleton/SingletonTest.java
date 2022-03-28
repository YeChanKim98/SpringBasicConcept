package Spring_Core.core.SIngleton;
import Spring_Core.core.AppConfig;
import Spring_Core.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링없는 순수 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        // 객체를 부를 때마다 새로 생성하는 것을 확인할 수 있다.
        // 이를 해결하기 위해, 하나의 서비스를 만든 후, 모두가 공유할 수 있도록 만드는 패턴이 바로, 싱글톤 패턴이다
        MemberService memberService_1 = appConfig.memberService();
        MemberService memberService_2 = appConfig.memberService();

        System.out.println("memberService_1 = " + memberService_1);
        System.out.println("memberService_2 = " + memberService_2);

        // SameAs는 같은 '객체'인지 비교한다
        // EqualTo는 값이 같은지 비교한다
        // 만일 같은 인터페이스로 생성된 두 객체에 들어간 값이 같으면, EqualTo는 통과하지만, SameAs는 통과하지 못한다.

        Assertions.assertThat(memberService_1).isNotSameAs(memberService_2);
    }

    @Test
    @DisplayName("싱글톤 적용 테스트")
    void singletonServiceTest(){
        SingletonService instance_1 = SingletonService.getInstance();
        SingletonService instance_2 = SingletonService.getInstance();
        System.out.println("instance_1 = " + instance_1);
        System.out.println("instance_2 = " + instance_2);
        Assertions.assertThat(instance_1).isSameAs(instance_2);
    }
}
