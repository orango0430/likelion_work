import java.util.Scanner;

class likelion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("아기사자 수를 입력하세요!");
            int baby_lions = sc.nextInt();
            if (baby_lions >= 5) {
                System.out.println("이름을 입력하세요!");
                String[] names = new String[baby_lions];

                for(int i = 0; i < names.length; ++i) {
                    names[i] = sc.next();
                }

                for(int j = 0; j < names.length; ++j) {
                    System.out.println("아기사자 번호 : " + (j + 1) + " 이름 명단 : " + names[j]);
                }

                return;
            }

            System.out.println("Error");
        }
    }
}
