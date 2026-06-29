package org.exaple.like_lion_pbl.class5.assignment.repository;

import org.exaple.like_lion_pbl.class5.assignment.domain.Assignment;
import org.exaple.like_lion_pbl.class5.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByMemberId(Long memberId);
}
