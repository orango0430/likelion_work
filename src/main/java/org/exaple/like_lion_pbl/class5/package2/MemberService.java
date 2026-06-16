package org.exaple.like_lion_pbl.class5.package2;

import org.exaple.like_lion_pbl.class5.dto.*;
import org.exaple.like_lion_pbl.class5.role.Lion;
import org.exaple.like_lion_pbl.class5.role.Staff;
import org.exaple.like_lion_pbl.class5.role.role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService {
    private MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void register(role member) {
        if (repository.existsByName(member.name)) {
            System.out.println("이미 등록된 이름입니다.");
            return;
        }
        repository.save(member);
        System.out.println("등록완료: " + member.name);
    }

    public void findAll() {
        List<role> members = repository.findAll();
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        int i = 1;
        for (role r : members) {
            System.out.println(i + ". " + r.getrole());
            i++;
        }
    }

    public void findByName(String name) {
        role member = repository.findByName(name);
        if (member == null) {
            System.out.println("해당 멤버가 없습니다.");
            return;
        }
        System.out.println(member.getrole());
    }

    public LionResponse createLion(LionCreateRequest request) {
        if (repository.existsByName(request.name)) return null;
        Lion lion = new Lion(request.name, request.major, request.generation, request.part, "아기사자", request.student_id);
        repository.save(lion);
        return LionResponse.from(lion);
    }

    public StaffResponse createStaff(StaffCreateRequest request) {
        if (repository.existsByName(request.name)) return null;
        Staff staff = new Staff(request.name, request.major, request.generation, request.part, request.position);
        repository.save(staff);
        return StaffResponse.from(staff);
    }

    public LionResponse updateLion(String name, LionUpdateRequest request) {
        role member = repository.findByName(name);
        if(member == null || !(member instanceof Lion)) return null;
        Lion lion = (Lion) member;
        lion.major = request.major;
        lion.generation = request.generation;
        lion.part = request.part;
        lion.student_id = request.student_id;
        repository.updateByName(name,member);
        return LionResponse.from(lion);
    }
    public StaffResponse updateStaff(String name, StaffUpdateRequest request){
        role member = repository.findByName(name);
        if(member == null || !(member instanceof Staff)) return null;
        Staff staff = (Staff) member;
        staff.major = request.major;
        staff.generation = request.generation;
        staff.part = request.part;
        staff.position = request.position;
        repository.updateByName(name,member);
        return StaffResponse.from(staff);
    }
    public boolean deleteMemeber(String name){
        return repository.deleteByName(name);
    }
    public Object findMemberByName(String name){
        role member = repository.findByName(name);
        if(member == null) return null;
        if(member instanceof Lion) return LionResponse.from((Lion) member);
        if(member instanceof Staff) return StaffResponse.from((Staff) member);
        return null;
    }
}
