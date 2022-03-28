package Spring_Core.core.discount;

import Spring_Core.core.member.Grade;
import Spring_Core.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements  DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //Enum형은 ==을 사용
            return discountFixAmount;
        }else
            return 0;
    }
}
