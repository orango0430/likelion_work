package org.exaple.like_lion_pbl.class5.dto;

public class LionCreateRequest {
    public String name;
    public String major;
    public int generation;
    public String part;
    public int student_id;

    public LionCreateRequest(String name, String major, int generation, String part, int student_id) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.student_id = student_id;
    }
}
