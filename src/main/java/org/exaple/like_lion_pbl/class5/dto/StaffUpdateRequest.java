package org.exaple.like_lion_pbl.class5.dto;

public class StaffUpdateRequest {
    public String major;
    public int generation;
    public String part;
    public String position;

    public StaffUpdateRequest(String major, int generation, String part, String position) {
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }
}
