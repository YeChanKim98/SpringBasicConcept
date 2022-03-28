package Spring_Core.core.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// 구현체가 하나있을 때, 이름으로 인터페이스이름 뒤에 Impl을 붙여서 짓는 경우가 많음
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // = ac.getBean(MemberRepository.class)
    // 사용해야 하는 생성자가 있을 시 '오토와이어드'를 사용하면, 등록된 '빈'중에서 타입이 일치하는 인자를 불러와서 의존관계를 자동으로 주입해준다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) { memberRepository.save(member); }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
