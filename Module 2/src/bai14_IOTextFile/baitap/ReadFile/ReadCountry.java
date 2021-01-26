package bai14_IOTextFile.baitap.ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCountry {
    public static void main(String[] args) {
        String path = "/Users/tynguyen/IdeaProjects/C1120G1-NguyenHoangBaoNgoc/Module 2/src/bai14_IOTextFile/baitap/ReadFile/Country.csv";
        String line = " ";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("Start ip: " + values[0] + " Country name: " + values[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
