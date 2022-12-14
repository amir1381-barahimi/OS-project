import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Signals {
    public static void create_process(String address,String ID){
        Process process=new Process(ID,State.ready);
        try {
            File f = new File(address);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                process.getInstructions().add(new Instructions(data.split(" ")[0],Integer.parseInt(data.split(" ")[1])));
            }
            myReader.close();
        }catch (IOException io){
            System.out.println(io.getStackTrace());
            System.out.println(io.getMessage());
        }


        Main.processes.put(process.getProcess_ID(),process);


    }
    public static void run_process(Process process){


        if(process.getState().equals(State.blocked)){
            System.out.println("this process is blocked");
        }else {

            if ((Main.processes.size()-1)==process.getPc()){
                process.setPc(0);
            }
            if(process.getPc()==0){
                
            }
            process.setState(State.ready);
            String type = process.getInstructions().get(process.getPc()).getType();
            int value = process.getInstructions().get(process.getPc()).getValue();
            process.getInstruction_register().setVal(type+" "+value);
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
        }
    }
    public static void block_process(Process process){
        process.setState(State.blocked);
    }
    public static void unblock_process(Process process){
        process.setState(State.ready);
    }
    public static void show_context(Process process){
        if(process!=null) {
            System.out.println("process ID: " + process.getProcess_ID());
            System.out.println("instruction register: " + process.getInstruction_register().getVal());
            System.out.println("accumulator : " + process.getAccumulator().getVal());
            System.out.println("temp: " + process.getTemp().getVal());
            System.out.println("state: " + process.getState());
            System.out.println("program counter: " + process.getPc());
        }else{
            System.out.println("process dose not exist");
        }
    }
    public static void kill_process(Process process){
        Main.processes.put(process.getProcess_ID(),null);
    }



}
