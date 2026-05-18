abstract public class role implements Submit_assignment {
    public String part;
    public String name;
    public String major;
    public int generation;
    public role(String name, String major, int generation, String part){
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }
    public abstract boolean cansubmit();
    public abstract String getrole();

}

