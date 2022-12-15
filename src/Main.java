import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Main {
    public static LinkedHashMap<String, Process> processes = new LinkedHashMap<>();

    public static void main(String[] args) {
        try {
            File file = new File("testcase.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data;
            int index = 0;
            while ((data = br.readLine()) != null) {
                System.out.println("loop : " + index);
                System.out.println(data);
                String[] all_data = data.split(" ");
                switch (all_data[0]) {
                    case "create_process": {
                        Signals.create_process(all_data[2], all_data[1]);
                        break;
                    }
                    case "run_process": {
                        Signals.run_process(processes.get(all_data[1]));
                        break;
                    }
                    case "show_context": {
                        Signals.show_context(processes.get(all_data[1]));
                        break;
                    }
                    case "block_process": {
                        Signals.block_process(processes.get(all_data[1]));
                        break;
                    }
                    case "unblock_process": {
                        Signals.unblock_process(processes.get(all_data[1]));
                        break;
                    }
                    case "kill_process": {
                        Signals.kill_process(processes.get(all_data[1]));
                        break;
                    }
                }
                index++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

