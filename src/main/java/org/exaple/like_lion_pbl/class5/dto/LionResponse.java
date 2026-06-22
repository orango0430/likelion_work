package org.exaple.like_lion_pbl.class5.dto;

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
}
