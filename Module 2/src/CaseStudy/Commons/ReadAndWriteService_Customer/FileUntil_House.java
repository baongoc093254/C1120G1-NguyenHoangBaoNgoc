package CaseStudy.Commons.ReadAndWriteService_Customer;

import CaseStudy.Models.House;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntil_House {
    static final String PATH_HOUSE = "Module 2/src/CaseStudy/Data/House.csv";
    static File file = new File(PATH_HOUSE);

    public static void writeHouse(List<House> houseList, boolean selection) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (House house : houseList) {
                bufferedWriter.write(house.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error input file !");
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<House> readHouse() {
        List<House> houseList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arrHouse = null;
            while ((line = bufferedReader.readLine()) != null) {
                arrHouse = line.split(",");
                House house = new House(arrHouse[0], arrHouse[1], Float.parseFloat(arrHouse[2]),
                        Double.parseDouble(arrHouse[3]), Integer.parseInt(arrHouse[4]), arrHouse[5],
                        arrHouse[6], arrHouse[7], Integer.parseInt(arrHouse[8]));
                houseList.add(house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }
}
