import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static LinkedHashMap<String,Process> processes=new LinkedHashMap<>();
    public static void main(String[] args){
        try {
            File f = new File("testcase.txt");
            Scanner myReader = new Scanner(f);
            int index=0;
            while (myReader.hasNextLine()) {
                System.out.println("loop : "+index);
                String data = myReader.nextLine();
                System.out.println(data);
                String[] all_data=data.split(" ");
                switch (all_data[0]){
                    case "create_process":{
                        Signals.create_process(all_data[2],all_data[1]);
                        break;
                    }
                    case "run_process":{

                        Signals.run_process(processes.get(all_data[1]));
                        break;
                    }
                    case "show_context":{
                        Signals.show_context(processes.get(all_data[1]));
                        break;
                    }
                    case "block_process":{
                        Signals.block_process(processes.get(all_data[1]));
                        break;
                    }
                    case "unblock_process":{
                        Signals.unblock_process(processes.get(all_data[1]));
                        break;
                    }
                    case "kill_process":{
                        Signals.kill_process(processes.get(all_data[1]));
                        break;
                    }
                }
                index++;
            }
            myReader.close();
        }catch (IOException io){
            System.out.println(io.getStackTrace());
            System.out.println(io.getMessage());
        }
    }
}

