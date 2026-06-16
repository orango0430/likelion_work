package org.exaple.like_lion_pbl.class5.policy;

import org.exaple.like_lion_pbl.class5.role.Lion;
import org.exaple.like_lion_pbl.class5.role.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LionSubmissionPolicy {
    public static void lionregister(List<role> roles, Map<String, List<role>> part_check, Scanner sc) {
                System.out.println("이름: " );
                String name = sc.nextLine();

                for(role r : roles){
                    if(r.name.equals(name)){
                        System.out.println("이미 등록된 이름입니다.");
                        return;
                    }

                }
                System.out.println("전공: ");
                String major = sc.nextLine();

                System.out.println("기수: ");
                int generation = sc.nextInt();
                sc.nextLine();

                System.out.println("파트: ");
                String part = sc.nextLine();

                System.out.println("학번: ");
                int student_id = sc.nextInt();
                sc.nextLine();

                roles.add(new Lion(name, major, generation, part, roleName, student_id));
                part_check.computeIfAbsent(part, key -> new ArrayList<>()).add(new Lion(name, major, generation, part, roleName, student_id));

                System.out.println("등록완료 " + name);

            }
    }
