package package1;

import java.util.Scanner;

public class step1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("아기사자 이름을 입력주세요.");
        String name = sc.nextLine();

        System.out.println("전공을 입력주세요.");
        String major = sc.nextLine();

        System.out.println("기수를 입력주세요.");
        int generation = sc.nextInt();
        try {
            Lion lion = new Lion(name, major, generation);
            System.out.println("아기사자 정보를 출력합니다.");
            System.out.println("이름:" + lion.name + " " + "전공:" + lion.major + " " + "기수:" + lion.getGeneration());
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
