package org.exaple.like_lion_pbl.class5.package2;

import org.exaple.like_lion_pbl.class5.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
    Optional<Member> findByName(String name);

}