import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        {
            System.out.println("아기사자 정보입력");

            System.out.println("아기사자 이름을 입력주세요.");
            String name = sc.nextLine();

            System.out.println("전공을 입력주세요.");
            String major = sc.nextLine();

            System.out.println("기수를 입력주세요.");
            int generation = sc.nextInt();
            sc.nextLine();

            System.out.println("파트를 입력주세요.");
            String part = sc.nextLine();

            System.out.println("학번를 입력주세요.");
            int student_id = sc.nextInt();
            sc.nextLine();

            role lion = new Lion(name, major, generation, part, student_id);
            System.out.println(lion.getrole());
        }
        {
            System.out.println("운영진 정보입력");

            System.out.println("운영진 이름을 입력주세요.");
            String name = sc.nextLine();

            System.out.println("전공을 입력주세요.");
            String major = sc.nextLine();

            System.out.println("기수를 입력주세요.");
            int generation = sc.nextInt();
            sc.nextLine();

            System.out.println("파트를 입력주세요.");
            String part = sc.nextLine();

            System.out.println("직책을 입력주세요.");
            String position = sc.nextLine();

            role staff = new Staff(name, major, generation, part, position);
            System.out.println(staff.getrole());
        }
    }

}
