package org.exaple.like_lion_pbl.class5.package1;

import org.exaple.like_lion_pbl.class5.role.role;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<role> roles = new ArrayList<>();

    public void save(role member) {
        roles.add(member);
    }

    public List<role> findAll() {
        return roles;
    }

    public role findByName(String name) {
        for (role r : roles) {
            if (r.name.equals(name)) {
                return r;
            }
        }
        return null;
    }
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}