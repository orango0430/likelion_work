package policy;

import role.role;
import role.Lion;
import role.Staff;

import java.util.*;

public class SubmissionPolicy{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<role> roles = new ArrayList<>();
        Map<String, List<role>> part_check = new HashMap<>();
        while (true) {
            print_menu.member_management();
            int select = sc.nextInt();
            sc.nextLine();

            if (select == 1) {
                int num;
                System.out.println("멤버 등록");
                System.out.println("역할선택 : 1. 아기사자 , 2. 운영진");
                num = sc.nextInt();
                sc.nextLine();
                if (num == 1) {
                    LionSubmissionPolicy.lionregister(roles, part_check, sc);
                } else if (num == 2) {
                    StaffSubmissionPolicy.staffregister(roles, part_check, sc);
                } else {
                    System.out.println("error");
                    continue;
                }
            } else if (select == 2) {
                System.out.println("전체 멤버 목록");
                int i = 1;
                for(role r : roles){
                    String roletype = (r instanceof Lion) ? "아기사자" : "운영진";
                    System.out.println(i+ ". " + roletype + " " + r.name + " " + r.generation);
                    i++;
                }
                System.out.println("총" + roles.size() + "명");
            }
            else if (select == 3){
                System.out.println("검색할 이름: ");
                String searchName = sc.nextLine();
                boolean found = false;
                for(role r : roles){
                    if(r.name.equals(searchName)){
                        System.out.println(r.getrole());
                        found = true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("error");
                }
            } else if (select == 4) {
                System.out.println("등록된 파트");
                for(String part : part_check.keySet()){
                    System.out.println(part);
                }
                System.out.println("조회할 파트: ");
                String searchPart = sc.nextLine();
                if(part_check.containsKey(searchPart)){
                    int i = 1;
                   for(role r : part_check.get(searchPart)){
                       String roleType = (r instanceof Lion) ? "아기사자" : "운영진";
                       System.out.println(i + ". " + r.name + " (" + roleType + ") - " + r.generation + "기");
                       i++;
                   }
                }
                else{
                    System.out.println("error");
                }
            } else if (select == 5){
                System.out.println("프로그램을 종료합니다");
                break;
            }
        }
    }
}
