package Spring_Core.core;
import Spring_Core.core.discount.DiscountPolicy;
import Spring_Core.core.discount.FixDiscountPolicy;
import Spring_Core.core.discount.RateDiscountPolicy;
import Spring_Core.core.member.MemberRepository;
import Spring_Core.core.member.MemberService;
import Spring_Core.core.member.MemberServiceImpl;
import Spring_Core.core.member.MemoryMemberRepository;
import Spring_Core.core.order.OrderService;
import Spring_Core.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 해당 파일은 DI 컨테이너
@Configuration // 해당 어노테이션 제거시, 빈 등록은 가능하지만, 싱글톤은 깨지게된다
public class AppConfig {
    // 실제 필요한 구현객체를 해당 클래스에서 생성 / 관리한다
    // Open Close Principle 원칙을 지킴 : 인터페이스에 의지하므로 클라이언트의 동작부는 기능을 바꾸더라도 손을 댈 필요가 없음
    // Dependency Inversion Principle 원칙을 지킴 : 프로그램의 흐름에 대한 컨트롤을 내가 하는 것이 아닌, 설정파일(xml등) 혹은 기타 파일 및 기능을 이용하여 내가 제어를 받는 것
    
    @Bean
    public MemberRepository memberRepository() { return new MemoryMemberRepository(); }
    // memberRepository라는 빈이 MemoryMemberRepository객체임을 등록. 빈 등록을 위해서는 반환값이 꼭 필요함

    @Bean
    public DiscountPolicy discountPolicy() { return new RateDiscountPolicy(); }

    @Bean
    public MemberService memberService() { return new MemberServiceImpl(memberRepository());}// 맴버서비스임플은 이미 맴버서비스형이므로 임플을 반환하며, 동시에 생성자 주입을 통해서 메모리리포지토리를 넘겨서 임플을 생성한다 -> 생성자를 리팩터링을 통해서 빼냄

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());//new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    
    // XML을 통한 컨테이너 구현또한 가능하지만, 현재는 어노테이션을 통한 구현을 더 많이 한다.
    // 파라미터로 들어간 생성자에 커서올리고 Alt + Shift + E 하면 익스텐션 리팩터링 기능으로 빼올 수 있음 -> 인자로 생성자가 들어가 있으면 해당 생성자를 밖으로 빼줌
}
