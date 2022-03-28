package Spring_Core.core.order;

import Spring_Core.core.AppConfig;
import Spring_Core.core.member.Grade;
import Spring_Core.core.member.Member;
import Spring_Core.core.member.MemberService;
import Spring_Core.core.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "Member-A", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "Item-A", 120000);
        System.out.println("order = " + order);
    }
}
