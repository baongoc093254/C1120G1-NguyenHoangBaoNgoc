package bai14_IOTextFile.baitap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntils {
    public static void writeFile(String pathfile, String line) {
        try {
            FileWriter fileWriter = new FileWriter(pathfile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    Input file
    public static List<String> readFile(String pathfile) {
        List<String> listLine = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(pathfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLine;
    }
}
