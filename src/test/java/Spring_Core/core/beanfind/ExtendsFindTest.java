package Spring_Core.core.beanfind;

import Spring_Core.core.discount.DiscountPolicy;
import Spring_Core.core.discount.FixDiscountPolicy;
import Spring_Core.core.discount.RateDiscountPolicy;
import Spring_Core.core.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtendsFindTest {
    // 부모타입으로 검색시, 상속받은 자식까지 같이 반환됨. 해당사항 테스트
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("Type Duplicate Cuz Search With Parents Type")
    void findPtypeDupl(){
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("Type Duplicate When Search With Parents Type : Search With Bean Name")
    void findPtypeBeanName(){
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("Search All With Parents Type")
    void findAllPType(){
        Map<String, DiscountPolicy> bean = ac.getBeansOfType(DiscountPolicy.class);
        for (String Key : bean.keySet()){
            System.out.println("Key = " + Key + "Value = " + bean.get(Key));
        }
    }

    @Configuration
    static class TestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
