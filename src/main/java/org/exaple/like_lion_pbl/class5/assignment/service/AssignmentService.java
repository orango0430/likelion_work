package org.exaple.like_lion_pbl.class5.assignment.service;

import org.exaple.like_lion_pbl.class5.assignment.dto.AssignmentUpdateRequest;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.exaple.like_lion_pbl.class5.assignment.domain.Assignment;
import org.exaple.like_lion_pbl.class5.assignment.dto.AssignmentCreateRequest;
import org.exaple.like_lion_pbl.class5.assignment.dto.AssignmentResponse;
import org.exaple.like_lion_pbl.class5.assignment.repository.AssignmentRepository;
import org.exaple.like_lion_pbl.class5.domain.Member;
import org.exaple.like_lion_pbl.class5.package2.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public AssignmentResponse create(Long memberId, AssignmentCreateRequest request){
        Member member = memberRepository.findById(memberId).orElse(null);
        if(member == null) return null;
        Assignment assignment = new Assignment(request.getTitle(), request.getDescription(),member);
        Assignment saved = assignmentRepository.save(assignment);
        return AssignmentResponse.from(saved);
    }
    public List<AssignmentResponse> findByMemberId(Long memberId){
        return assignmentRepository.findByMemberId(memberId).stream().map(AssignmentResponse::from).collect(Collectors.toList());
    }
    public AssignmentResponse findById(Long Id) {
        Assignment assignment = assignmentRepository.findById(Id).orElse(null);
        if (assignment == null) return null;
        return AssignmentResponse.from(assignment);
    }
    @Transactional
    public AssignmentResponse update(Long Id, AssignmentUpdateRequest request){
        Assignment assignment = assignmentRepository.findById(Id).orElse(null);
        if(assignment == null) return null;
        assignment.updateInfo(request.getTitle(), request.getDescription());
        Assignment saved = assignmentRepository.save(assignment);
        return AssignmentResponse.from(saved);
    }
    @Transactional
    public boolean delete(Long id){
        if(!assignmentRepository.existsById(id)) return false;
        assignmentRepository.deleteById(id);
        return true;
    }
}
