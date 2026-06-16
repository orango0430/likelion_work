package org.exaple.like_lion_pbl.class5.dto;

public class StaffCreateRequest {
    public String name;
    public String major;
    public int generation;
    public String part;
    public String position;

    public StaffCreateRequest(String name, String major, int generation, String part, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }
}
