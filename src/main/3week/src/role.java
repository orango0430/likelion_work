abstract public class role {
    public String part;
    public String name;
    public String major;
    public int generation;

    public abstract boolean getsubmit();

    public boolean can_submit(){
        return getsubmit();
    }
    public role(String name, String major, int generation, String part){
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public abstract String getrole();

}

