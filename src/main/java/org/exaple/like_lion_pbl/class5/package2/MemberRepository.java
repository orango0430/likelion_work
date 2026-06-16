package org.exaple.like_lion_pbl.class5.package2;

import org.exaple.like_lion_pbl.class5.role.role;

import java.util.List;

public interface MemberRepository {
    void save(role member);
    List<role> findAll();
    role findByName(String name);
    boolean existsByName(String name);
    void updateByName(String name, role member);
    boolean deleteByName(String name);
}