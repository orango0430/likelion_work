package policy;

import role.role;
import role.Lion;
import role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StaffSubmissionPolicy {
    public static void staffregister(List<role> roles, Map<String, List<role>> part_check, Scanner sc) {
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

            System.out.println("역할: ");
            String position = sc.nextLine();

            roles.add(new Staff(name, major, generation, part, position));
            part_check.computeIfAbsent(part, k -> new ArrayList<>()).add((new Staff(name, major, generation, part, position)));

            System.out.println("등록완료 " + name);

        }
    }

