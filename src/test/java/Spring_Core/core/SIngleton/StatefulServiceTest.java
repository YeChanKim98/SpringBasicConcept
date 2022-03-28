package Spring_Core.core.SIngleton;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService_1 = ac.getBean(StatefulService.class);
        StatefulService statefulService_2 = ac.getBean(StatefulService.class);

        //주문
        int price_A = statefulService_1.order("userA",9900);
        int price_B = statefulService_1.order("userB",9999999);

        /*
        // 조회
        int price = statefulService_1.getPrice(); // A가 조회하고 싶어하지만, 마지막으로 입력한 것은 B이기 때문에 B가 넣은 값이 출력된다. -> 스테이트풀 싱글톤의 문제점
        System.out.println("price = " + price);
        Assertions.assertThat(statefulService_1.getPrice()).isEqualTo(9999999);
        */

        System.out.println("price_A = " + price_A);
        System.out.println("price_B = " + price_B);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}