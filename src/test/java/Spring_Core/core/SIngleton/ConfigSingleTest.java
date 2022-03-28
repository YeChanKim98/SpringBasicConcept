package Spring_Core.core.SIngleton;

import Spring_Core.core.AppConfig;
import Spring_Core.core.member.MemberRepository;
import Spring_Core.core.member.MemberService;
import Spring_Core.core.member.MemberServiceImpl;
import Spring_Core.core.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigSingleTest {

    @Test
    @DisplayName("싱글톤 중복 콜")
    // 싱글톤 패턴에서 Config파일내에 같은 생성자를 인자로 하는 서로다른 Bean이 실행 될 때, 인자로 생성 된 객체는 하나로 관리 될 까, 아니면 두개로 생성 되어 싱글톤이 깨질까
    void configTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // 싱글톤 지원
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository_1 = memberService.getMemberRepository();
        MemberRepository memberRepository_2 = orderService.getMemberRepository();
        System.out.println("\nmemberService -> memberRepository_1 = " + memberRepository_1);
        System.out.println("orderService -> memberRepository_2 = " + memberRepository_2);
        // 결과 : memberService와 orderService의 생성으로 인해 코드상 MemberRepository객체가 두번 생성되었지만, 객체 출력결과, 동일 객체이다. -> 스프링이 싱글톤을 위해서, 이미 있는 객체의 생성을 요청 시, 이미 있는 객체라면 해당 객체를 연결해준다

        MemberRepository memberRepository = ac.getBean("memberRepository",MemberRepository.class);
        System.out.println("Direct Create -> memberRepository = " + memberRepository);
        // 추가로 멤버 리포지토리를 직접 생성하고 확인한 결과, 역시나 같은 객체임을 확인
    }

    @Test
    void configDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
        // 빈으로 등록된 Appconfig파일을 bean변수에 넣고 정보를 확인하면 CGLIB이라는 정보가 추가되었다. 이는 스프링 컨테이너에서 싱글톤을 보장하기 위해서 CGLIB라이브러리를 이용해 바이트코드를 변경했기 때문이다.
    }
}