package Spring_Core.core.beanfind;
import Spring_Core.core.AppConfig;
import Spring_Core.core.discount.DiscountPolicy;
import Spring_Core.core.member.MemberRepository;
import Spring_Core.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class beanSearchDuplicateType {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DuplConfig.class);

    @Test
    @DisplayName("Duplicate Error Cuz Result SameTypeBean When Search By Type")
    void findByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("Avoid Type Duplication Error Use Name")
    void findByTypeAvoidDupl(){
        MemberRepository memberRepository = ac.getBean("mr1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);

    }

    @Test
    @DisplayName("Print All Result That Find With Type")
    void findBeanAllType(){
        Map<String, MemberRepository> beanAll = ac.getBeansOfType(MemberRepository.class);
        for (String key : beanAll.keySet() ){
            System.out.println("Key = " + key + "Value = " + beanAll.get(key));
        }
        System.out.println("Print All Bean = " + beanAll);
        assertThat(beanAll.size()).isEqualTo(2);
    }

    // 에러 유도를 위한 같은 타입의 빈 두개 생성
    @Configuration
    static class DuplConfig{
        @Bean
        public MemberRepository mr1(){ return new MemoryMemberRepository(); }

        @Bean
        public MemberRepository mr2(){ return new MemoryMemberRepository(); }
    }
}
