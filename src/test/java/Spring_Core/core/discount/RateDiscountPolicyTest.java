package Spring_Core.core.discount;
import Spring_Core.core.member.Grade;
import Spring_Core.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP Must Have Discount 10%-!")
    void vip_success(){
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("None VIP Can Not Discount-!")
    void vip_fail(){
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isNotEqualTo(1000);
        // Alt + Enter 단축키를 통해서 Static Import를 구현하며, 코드를 간결하게 할 수 있다
    }

}