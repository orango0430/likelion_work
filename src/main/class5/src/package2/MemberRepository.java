package package2;
import role.role;
import java.util.List;

public interface MemberRepository {
    void save(role member);
    List<role> findAll();
    role findByName(String name);
    boolean existsByName(String name);
}