package package2;

import role.Lion;
import role.Staff;
import role.role;
import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private List<role> roles = new ArrayList<>();

    public MockMemberRepository() {
        roles.add(new Lion("김사자", "컴퓨터공학", 14, "백엔드", 20231234));
        roles.add(new Lion("박사자", "전자공학", 14, "프론트엔드", 20231235));
        roles.add(new Staff("홍사자", "경영학", 13, "백엔드", "회장"));
    }

    @Override
    public void save(role member) {
        roles.add(member);
    }

    @Override
    public List<role> findAll() {
        return roles;
    }

    @Override
    public role findByName(String name) {
        for (role r : roles) {
            if (r.name.equals(name)) return r;
        }
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}