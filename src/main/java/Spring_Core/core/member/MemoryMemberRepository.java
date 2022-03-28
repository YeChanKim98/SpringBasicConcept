package Spring_Core.core.member;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
// MemberRepository의 구현체
// 해당 구현체는 메모리 저장소를 위한 구현체이므로, 추후 저장소 방식 변경에 따른 코드 정정이 가능
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
