package CaseStudy.Commons.ReadAndWriteService_Customer;

import CaseStudy.Models.Room;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntil_Room {
    static final String PATH_ROOM = "Module 2/src/CaseStudy/Data/Room.csv";
    static File file = new File(PATH_ROOM);
    public static void writeRoom(List<Room> roomList,boolean selection) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Room room: roomList) {
                bufferedWriter.write(room.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error input file !");
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Room> readRoom() {
        List<Room> roomList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arrRoom = null;
            while ((line = bufferedReader.readLine()) != null) {
                arrRoom = line.split(",");
                Room room = new Room(arrRoom[0],arrRoom[1],Float.parseFloat(arrRoom[2]),
                        Double.parseDouble(arrRoom[3]),Integer.parseInt(arrRoom[4]),
                        arrRoom[5],arrRoom[6]);
                roomList.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomList;
    }
}
