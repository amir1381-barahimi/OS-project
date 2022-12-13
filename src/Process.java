import java.util.ArrayList;

public class Process {
    private String process_ID;
    private State state;
    private Registers temp;
    private Registers accumulator;
    private Registers instruction_register;
    private int pc;

    public ArrayList<Instructions> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instructions> instructions) {
        this.instructions = instructions;
    }

    private ArrayList<Instructions> instructions;

    public Process(String process_ID, State state) {
        this.process_ID = process_ID;
        this.state = state;
        temp=null;
        accumulator=null;
        instruction_register=null;
        pc=0;
        instructions = new ArrayList<>();
    }

    public String getProcess_ID() {
        return process_ID;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Registers getTemp() {
        return temp;
    }

    public void setTemp(Registers temp) {
        this.temp = temp;
    }

    public Registers getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(Registers accumulator) {
        this.accumulator = accumulator;
    }

    public Registers getInstruction_register() {
        return instruction_register;
    }

    public void setInstruction_register(Registers instruction_register) {
        this.instruction_register = instruction_register;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }
}

