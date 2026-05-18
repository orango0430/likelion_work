package policy;

import role.role;
import role.Lion;
import role.Staff;

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

                roles.add(new Lion(name, major, generation, part, student_id));
                part_check.computeIfAbsent(part, key -> new ArrayList<>()).add(new Lion(name, major, generation, part, student_id));

                System.out.println("등록완료 " + name);

            }
    }
