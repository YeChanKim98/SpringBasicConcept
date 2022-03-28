package Spring_Core.core;
import Spring_Core.core.member.Grade;
import Spring_Core.core.member.Member;
import Spring_Core.core.member.MemberService;
import Spring_Core.core.member.MemberServiceImpl;
import Spring_Core.core.order.Order;
import Spring_Core.core.order.OrderService;
import Spring_Core.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "Member-A", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "Item-A", 10000);
        System.out.println("order = " + order);
    }
}
