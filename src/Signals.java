import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Signals {
    public static void create_process(String address, String ID) {
        Process process = new Process(ID, State.ready);
        try {
            File f = new File(address);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                process.getInstructions().add(new Instructions(data.split(" ")[0], Double.parseDouble(data.split(" ")[1])));
            }
            myReader.close();
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
        Main.processes.put(process.getProcess_ID(), process);
    }

    public static void run_process(Process process) {
        if (process.getState().equals(State.blocked)) {
            System.out.println("this process is blocked");
        } else {
            if (Main.processes.size() == process.getPc()) {
                process.setPc(0);
            }

            process.setState(State.running);
            String type = process.getInstructions().get(process.getPc()).getType();
            double value = process.getInstructions().get(process.getPc()).getValue();
            process.getInstruction_register().setVal(type + " " + value);
            switch (type) {
                case "load": {
                    Instructions.load(process, value);
                    break;
                }
                case "sub": {
                    Instructions.sub(process, value);
                    break;
                }
                case "add": {
                    Instructions.add(process, value);
                    break;
                }
                case "mul": {
                    Instructions.mul(process, value);
                    break;
                }
            }
            process.setPc(process.getPc() + 1);
            process.setState(State.ready);
        }
    }

    public static void block_process(Process process) {
        process.setState(State.blocked);
    }

    public static void unblock_process(Process process) {
        process.setState(State.ready);
    }

    public static void show_context(Process process) {
        if (process != null) {
            System.out.println("----------------------------------------------");
            System.out.println("Process ID : " + process.getProcess_ID());
            System.out.println("Instruction Register : " + process.getInstruction_register().getVal() + "\n");
            System.out.println("Accumulator : " + process.getAccumulator().getVal());
            System.out.println("Temp : " + process.getTemp().getVal());
            System.out.println("State : " + process.getState());
            System.out.println("Program Counter : " + process.getPc());
            System.out.println("----------------------------------------------");
        } else {
            System.out.println("process doesn't exist");
        }
    }

    public static void kill_process(Process process) {
        Main.processes.put(process.getProcess_ID(), null);
    }
}
