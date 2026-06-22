package org.exaple.like_lion_pbl.class5.dto;
import org.exaple.like_lion_pbl.class5.domain.Member;

public class MemberResponse {
    public Long id;
    public String name;
    public String major;
    public int generation;
    public String part;
    public String roleName;
    public String studentId;
    public String position;

    public MemberResponse(Long id, String name, String major, int generation, String part, String roleName, String studentId, String position) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
        this.studentId = studentId;
        this.position = position;
    }
    public static MemberResponse from(Member member){
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getMajor(),
                member.getGeneration(),
                member.getPart(),
                member.getRoleType().getDisplayName(), // enum의 displayName 사용
                member.getStudentId(), // Staff면 null
                member.getPosition()   // Lion이면 null
        );
    }
}
