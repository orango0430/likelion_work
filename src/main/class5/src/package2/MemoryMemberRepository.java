package package2;
import role.role;
import java.util.ArrayList;
import java.util.List;
public class MemoryMemberRepository implements MemberRepository {
    private List<role> roles = new ArrayList<>();

    @Override
    public void save(role member){
        roles.add(member);
    }
    @Override
    public List<role> findAll(){
        return roles;
    }
    @Override
    public role findByName(String name){
        for (role r : roles) {
            if (r.name.equals(name)) {
                return r;
            }
        }
        return null;
    }
    public boolean existsByName(String name){
        return findByName(name) != null;
    }
}
