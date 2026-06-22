package org.exaple.like_lion_pbl.class5.dto;

public class StaffResponse {
    String name;
    String major;
    int generation;
    String part;
    String roleName;
    String position;

    public StaffResponse(String name, String major, int generation, String part, String roleName, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
        this.position = position;
    }
}
