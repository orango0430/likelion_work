package package2;

import package2.MemberService;
import package1.print_info;
import package2.MemberRepository;
import package2.MemoryMemberRepository;
import package2.MockMemberRepository;
import role.Lion;
import role.Staff;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("저장소를 선택하세요");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        int choice = sc.nextInt();
        sc.nextLine();

        MemberRepository repository;
        if (choice == 1) {
            repository = new MemoryMemberRepository();
        } else {
            repository = new MockMemberRepository();
        }

        MemberService service = new MemberService(repository);

        while (true) {
            print_info.menu();

            int select = sc.nextInt();
            sc.nextLine();

            if (select == 1) {
                System.out.println("역할선택 : 1. 아기사자, 2. 운영진");
                int num = sc.nextInt();
                sc.nextLine();

                System.out.print("이름: ");
                String name = sc.nextLine();
                System.out.print("전공: ");
                String major = sc.nextLine();
                System.out.print("기수: ");
                int generation = sc.nextInt();
                sc.nextLine();
                System.out.print("파트: ");
                String part = sc.nextLine();

                if (num == 1) {
                    System.out.print("학번: ");
                    int student_id = sc.nextInt();
                    sc.nextLine();
                    service.register(new Lion(name, major, generation, part, student_id));
                } else {
                    System.out.print("직책: ");
                    String position = sc.nextLine();
                    service.register(new Staff(name, major, generation, part, position));
                }

            } else if (select == 2) {
                service.findAll();

            } else if (select == 3) {
                System.out.print("검색할 이름: ");
                String name = sc.nextLine();
                service.findByName(name);

            } else if (select == 4) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}