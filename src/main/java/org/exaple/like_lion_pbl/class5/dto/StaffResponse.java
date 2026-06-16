package org.exaple.like_lion_pbl.class5.dto;

import org.exaple.like_lion_pbl.class5.role.Staff;

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
    public static StaffResponse from(Staff staff){
        return new StaffResponse(staff.name, staff.major, staff.generation, staff.part, "운영진", staff.position);

    }
}
