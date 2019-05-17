package file;

import java.io.*;
import java.util.*;

public class File {

    public static void fileInput(String fileName, String words) {
                List<String> l = null;
                Writer writer = null;
                try {
                    writer = new FileWriter(fileName + ".txt", true);
                    writer.write(words);
                    writer.append("\n");
                    writer.flush();
                }catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    try{
                        writer.close();
                    }
                    catch (IOException e) {e.printStackTrace();}
                }
    }

    public static Set<String> fileOutput(String fileName) {
        Set<String> buf = new HashSet<String>();
        Reader reader = null;
        try {
            reader = new FileReader(fileName + ".txt");
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()) {
                    buf.add(scanner.nextLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buf;
    }
}
