package Spring_Core.core.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
