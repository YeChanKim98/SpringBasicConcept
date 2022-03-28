package Spring_Core.core.order;
import Spring_Core.core.annotation.MainDiscountPolicy;
import Spring_Core.core.discount.DiscountPolicy;
import Spring_Core.core.discount.FixDiscountPolicy;
import Spring_Core.core.discount.RateDiscountPolicy;
import Spring_Core.core.member.Member;
import Spring_Core.core.member.MemberRepository;
import Spring_Core.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor final변수를 통해서 생성자를 알아서 생성해주는 어노테이션
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy; // 의존성 제거를 위해 Final제거 후 구현체를 설정하지 않음 : 인터페이스에 의존하므로 , 구현체가 정정되어도 해당 파일은 수정이 필요없음
    // rivate final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
