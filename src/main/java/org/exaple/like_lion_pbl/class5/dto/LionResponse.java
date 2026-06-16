package org.exaple.like_lion_pbl.class5.dto;

import org.exaple.like_lion_pbl.class5.role.Lion;

public class LionResponse {
    String name;
    String major;
    int generation;
    String part;
    String roleName;
    int student_id;

    public LionResponse(String name, String major, int generation, String part, String roleName, int student_id) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
        this.student_id = student_id;
    }
    public static LionResponse from(Lion lion){
        return new LionResponse(lion.name, lion.major, lion.generation, lion.part,"아기사자",lion.student_id);
    }
}
