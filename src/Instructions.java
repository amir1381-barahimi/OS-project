public class Instructions {
    private String type;
    private double value;

    public Instructions(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public static void load(Process process, double num) {
        process.getTemp().setVal(num);
        process.getAccumulator().setVal(num);
    }

    public static void sub(Process process, double num) {
        process.getTemp().setVal(num);
        process.getAccumulator().setVal(process.getAccumulator().getVal() - num);
    }

    public static void add(Process process, double num) {
        process.getTemp().setVal(num);
        process.getAccumulator().setVal(process.getAccumulator().getVal() + num);
    }

    public static void mul(Process process, double num) {
        process.getTemp().setVal(num);
        process.getAccumulator().setVal(process.getAccumulator().getVal() * num);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
