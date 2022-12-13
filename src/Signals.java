import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Signals {
    public static Process create_process(String address,String ID){
        Process process=new Process(ID,State.ready);
        try {
            File f = new File(address);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                process.getInstructions().add(new Instructions(data.split(" ")[0],Integer.parseInt(data.split(" ")[1])));
            }
            myReader.close();
        }catch (IOException io){
            System.out.println(io.getStackTrace());
            System.out.println(io.getMessage());
        }

        return process;


    }
//    public Process run_process(Process process){
//
//    }
//    public Process block_process(){
//
//    }
//    public Process unblock_process(){
//
//    }
//    public Process show_context(){
//
//    }
//    public Process kill_process(){
//
//    }



}
