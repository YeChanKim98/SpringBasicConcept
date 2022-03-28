package Spring_Core.core;
import Spring_Core.core.member.Grade;
import Spring_Core.core.member.Member;
import Spring_Core.core.member.MemberService;
import Spring_Core.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class); // AppConfig타입의 ac변수에서 MemberService타입의 memberService객체를 반환받는다. 해당 방법을 통해서 appconfig에서 memberService를 받아오는 코드를 대체할 수 있다

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("\nnew member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }

}
