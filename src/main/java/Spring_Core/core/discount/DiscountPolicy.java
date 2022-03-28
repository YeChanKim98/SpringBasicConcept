package Spring_Core.core.discount;
import Spring_Core.core.member.Member;

public interface DiscountPolicy {

    // 할인금액 리턴
    int discount(Member member, int price);

}
