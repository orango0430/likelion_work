package org.exaple.like_lion_pbl.class5.package2;

import org.exaple.like_lion_pbl.class5.domain.Member;
import org.exaple.like_lion_pbl.class5.domain.RoleType;
import org.exaple.like_lion_pbl.class5.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public MemberResponse createLion(LionCreateRequest request) {
        Member member = new Member(request.name, request.major, request.part,
                request.generation, RoleType.LION, request.studentId, null);
        Member saved = repository.save(member);
        return MemberResponse.from(saved);
    }

    public MemberResponse createStaff(StaffCreateRequest request) {
        Member member = new Member(request.name, request.major, request.part,
                request.generation, RoleType.STAFF, null, request.position);
        Member saved = repository.save(member);
        return MemberResponse.from(saved);
    }

    public MemberResponse findById(Long id) {
        Member member = repository.findById(id).orElse(null);
        if (member == null) return null;
        return MemberResponse.from(member);
    }

    public MemberResponse updateLion(Long id, LionUpdateRequest request) {
        Member member = repository.findById(id).orElse(null);
        if (member == null) return null;
        member.updateInfo(request.major, request.part, request.generation);
        member.updateStudentId(request.studentId);
        Member saved = repository.save(member);
        return MemberResponse.from(saved);
    }

    public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {
        Member member = repository.findById(id).orElse(null);
        if (member == null) return null;
        member.updateInfo(request.major, request.part, request.generation);
        member.updatePosition(request.position);
        Member saved = repository.save(member);
        return MemberResponse.from(saved);
    }

    public boolean deleteMember(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}