package org.exaple.like_lion_pbl.class5.dto;

public class LionUpdateRequest {
    public String major;
    public int generation;
    public String part;
    public int student_id;
    public String studentId;

    public LionUpdateRequest(String major, int generation, String part, String studentId) {
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }
}
