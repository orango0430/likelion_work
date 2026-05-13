public class Staff extends role implements Submit_assignment {
    String position;

    @Override
    public boolean cansubmit() {
        return false;
    }

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major,generation,part);
        this.position = position;
    }

    @Override
    public String getrole() {
        return "역할: 운영진\n" +
                "이름: " + name + " | 전공: " + major + " | 기수: " + generation + " | 파트: " + part + "\n" +
                "직책: " + position + "\n" +
                "과제 제출 가능 여부: " + (cansubmit() ? "✅ 가능" : "❌ 불가능");
    }
    }

