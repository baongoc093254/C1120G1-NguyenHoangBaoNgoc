package CaseStudy.Commons.ReadAndWriteService_Customer;

import CaseStudy.Models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntils_Villa {
    static final String PATH_VILLA = "Module 2/src/CaseStudy/Data/Villa.csv";
    static File file = new File(PATH_VILLA);

    public static void writeVilla(List<Villa> villaList, boolean selection) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Villa villa: villaList) {
                bufferedWriter.write(villa.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Villa> readVilla() {
        List<Villa> villaList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arrVilla = null;
            while ((line = bufferedReader.readLine()) != null) {
                arrVilla = line.split(",");
                Villa villa = new Villa(arrVilla[0], arrVilla[1], Float.parseFloat(arrVilla[2]),
                        Double.parseDouble(arrVilla[3]), Integer.parseInt(arrVilla[4]), arrVilla[5],
                        arrVilla[6], Float.parseFloat(arrVilla[7]),
                        Integer.parseInt(arrVilla[8]), arrVilla[9]);
                villaList.add(villa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villaList;
    }
}
