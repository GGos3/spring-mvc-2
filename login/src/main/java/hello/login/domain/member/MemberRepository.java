package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("saved member = {}", member);

        store.put(member.getId(), member);

        return member;
    }

    public Optional<Member> findByLoginId(String Id) {
        return findAll().stream()
                .filter(a -> a.getLoginId().equals(Id))
                .findFirst();
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
