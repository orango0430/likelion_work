public class Lion extends role implements Submit_assignment {
    int student_id;

    @Override
    public boolean getsubmit() {
        return true;
    }

    public Lion(String name, String major, int generation, String part, int student_id) {
        super(name, major, generation,part);
        this.student_id = student_id;
    }

    @Override
    public String getrole() {
        return "역할: 아기사자\n" +
                "이름: " + name + " | 전공: " + major + " | 기수: " + generation + " | 파트: " + part + "\n" +
                "학번: " + student_id + "\n" +
                "과제 제출 가능 여부: " + (getsubmit() ? "✅ 가능" : "❌ 불가능");
    }
}