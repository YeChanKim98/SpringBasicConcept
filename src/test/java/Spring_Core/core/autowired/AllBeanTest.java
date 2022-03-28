package Spring_Core.core.autowired;

import Spring_Core.core.AutoAppConfig;
import Spring_Core.core.discount.DiscountPolicy;
import Spring_Core.core.member.Grade;
import Spring_Core.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA",Grade.VIP);
        int disPrice = discountService.discount(member,10000,"fixDiscountPolicy");
        Assertions.assertThat(disPrice).isEqualTo(1000);

    }
    
    // 알고리즘 참고
    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) { // 타입을 통해서 모든 빈을 가져온 뒤, 맵에 매칭 시키고 동적으로 필요한 것을 이용하면, 다형성과 편리를 모두 얻을 수 있다
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member,price);
        }
    }
}