package org.exaple.like_lion_pbl.class5.package2;

import org.exaple.like_lion_pbl.class5.role.role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
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
    @Override
    public boolean existsByName(String name){
        for(role r : roles){
            if(r.name.equals(name)) return true;
        }
        return false;
    }
    @Override
    public void updateByName(String name, role member){
        for(int i = 0; i < roles.size(); i++){
            if(roles.get(i).name.equals(name)){
                roles.set(i,member);
                return;
            }
        }
    }
    @Override
    public boolean deleteByName(String name) {
        return roles.removeIf(r -> r.name.equals(name));
    }
}
