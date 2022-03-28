package Spring_Core.core.autowired;

import Spring_Core.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    @DisplayName("선택적 오토와이어드와 널값")
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        // 테스트용으로, 아무 Bean이나 사용하면 되므로, 내용없이 동록되는 자신으로(TestBean) 테스트실시

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){ // Member는 스프링이 관리하고 있지 않아서 오토와이어드로 등록할 수 없음
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ // @Nullable로 인해서 맞는 타입의 인자가 없을경우, Null값 입력
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){ // Optional<Member>타입 : 주입 대상이 없을시, empty값입력
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
