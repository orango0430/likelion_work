package package1;

public class Lion {
    public String name;
    String major;
    private int generation;

    public int getGeneration() {
        return generation;
    }
    public Lion(String name, String major, int generation){
        this.name = name;
        this.major = major;
        this.generation = generation;

        System.out.println("입력값 검증을 진행합니다.");

        if(name.isEmpty()){
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        } else if (major.isEmpty()) {
            throw new IllegalArgumentException("전공은 비어 있을 수 없습니다.");
        } else if (generation < 1) {
            throw new IllegalArgumentException("기수는 1보다 작을 수 없습니다.");
        }
        System.out.println("입력값 검증을 통과했습니다. 객체를 생성합니다.");
    }
}

