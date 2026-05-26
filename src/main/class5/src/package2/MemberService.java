package package2;

import package2.MemberRepository;
import role.role;
import java.util.List;

public class MemberService {
    private MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void register(role member) {
        if (repository.existsByName(member.name)) {
            System.out.println("이미 등록된 이름입니다.");
            return;
        }
        repository.save(member);
        System.out.println("등록완료: " + member.name);
    }

    public void findAll() {
        List<role> members = repository.findAll();
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        int i = 1;
        for (role r : members) {
            System.out.println(i + ". " + r.getrole());
            i++;
        }
    }

    public void findByName(String name) {
        role member = repository.findByName(name);
        if (member == null) {
            System.out.println("해당 멤버가 없습니다.");
            return;
        }
        System.out.println(member.getrole());
    }
}