import java.util.ArrayList;

public class Process {
    private final String process_ID;
    private State state;
    private Registers<Double> temp;
    private Registers<Double> accumulator;
    private Registers<String> instruction_register;
    private int pc;
    private ArrayList<Instructions> instructions;


    public Process(String process_ID, State state) {
        this.process_ID = process_ID;
        this.state = state;
        temp = new Registers<>(0.0);
        accumulator = new Registers<>(0.0);
        instruction_register = new Registers<>("");
        pc = 0;
        instructions = new ArrayList<>();
    }

    public ArrayList<Instructions> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instructions> instructions) {
        this.instructions = instructions;
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

    public Registers<Double> getTemp() {
        return temp;
    }

    public void setTemp(Registers<Double> temp) {
        this.temp = temp;
    }

    public Registers<Double> getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(Registers<Double> accumulator) {
        this.accumulator = accumulator;
    }

    public Registers<String> getInstruction_register() {
        return instruction_register;
    }

    public void setInstruction_register(Registers<String> instruction_register) {
        this.instruction_register = instruction_register;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }
}

