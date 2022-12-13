public class Instructions {
    private String type;
    private int value;

    public Instructions(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public static void load(Process process,int num){
        process.getTemp().setVal(num);
        process.getAccumulator().setVal(num);
        process.setPc(process.getPc()+1);
        process.setState(State.running);
    }

    public static void sub(Process process,int num){
        process.getTemp().setVal(num);
        process.getAccumulator().setVal(process.getAccumulator().getVal() - num);
        process.setPc(process.getPc()+1);
        process.setState(State.running);
    }

    public static void add(Process process,int num){
        process.getTemp().setVal(num);
        process.getAccumulator().setVal(process.getAccumulator().getVal() + num);
        process.setPc(process.getPc()+1);
        process.setState(State.running);
    }

    public static void mul(Process process,int num){
        process.getTemp().setVal(num);
        process.getAccumulator().setVal(process.getAccumulator().getVal() * num);
        process.setPc(process.getPc()+1);
        process.setState(State.running);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
