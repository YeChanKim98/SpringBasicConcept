package Spring_Core.core.discount;
import Spring_Core.core.annotation.MainDiscountPolicy;
import Spring_Core.core.member.Grade;
import Spring_Core.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    int dcost;

    @Override
    public int discount(Member member, int price) {
        // 메소드 이름에 커서를 올린 상태에서 Ctrl + Shift + T를 하면 자동으로 테스트 클레스를 작성할 수 있다.
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
