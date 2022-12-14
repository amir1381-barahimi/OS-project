public class Registers<R> {
    private R val;

    public Registers(R val) {
        this.val = val;
    }

    public R getVal() {
        return val;
    }

    public void setVal(R val) {
        this.val = val;
    }
}
