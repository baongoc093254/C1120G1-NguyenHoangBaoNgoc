package CaseStudy.Commons.ReadAndWriteService_Customer;

import CaseStudy.Models.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntils_Booking {
    public static final String PATH_BOOKING ="Module 2/src/CaseStudy/Data/Booking.csv";
    public static File file = new File(PATH_BOOKING);
    public static void writeBooking(List<Booking> bookingList, boolean selection) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking: bookingList) {
                bufferedWriter.write(booking.showInfor());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Booking> readBooking() {
        List<Booking> bookingList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line ="";
            String[] arrayBooking;
            while ((line = bufferedReader.readLine()) != null) {
                    arrayBooking = line.split(",");
                    Booking booking = new Booking(Integer.parseInt(arrayBooking[0]),arrayBooking[1],arrayBooking[2]);
                    bookingList.add(booking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bookingList;
    }

}
