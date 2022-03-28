package Spring_Core.core.beanfind;
import Spring_Core.core.AppConfig;
import Spring_Core.core.member.MemberService;
import Spring_Core.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class beanSearchTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Search Bean With Name")
    void findByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class); // 타입은 인터페이스가 아닌 실제 리턴값으로 받아오는 impl.class로 해도 된다. 단, 유연성이 떨어짐
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // memberService가 MemberServiceImpl.class형 객체인지 확인
    }

    @Test
    @DisplayName("Search Bean With Type")
    void findByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // memberService가 MemberServiceImpl.class형 객체인지 확인
    }

    @Test
    @DisplayName("Fail Search Bean Test")
    void findByName_Fail(){
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("Fail_Test", MemberService.class));
        // ac.getBean("Fail_Test", MemberService.class) 실행시 기대값으로 NoSuchBeanDefinitionException의 에러가 나와야함을 명시
    }
}
