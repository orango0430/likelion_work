package org.exaple.like_lion_pbl.class5.dto;

public class LionCreateRequest {
    public String name;
    public String major;
    public int generation;
    public String part;
    public String studentId;

    public LionCreateRequest(String name, String major, int generation, String part, String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }
}
