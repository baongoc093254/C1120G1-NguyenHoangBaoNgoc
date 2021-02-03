package CaseStudy.Commons.ReadAndWriteService_Customer;

import CaseStudy.Models.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntilTicket {
    public static final String PATH_TICKET = "Module 2/src/CaseStudy/Data/Ticket.csv";
    static File file = new File(PATH_TICKET);
    public static void writeTicket(List<Ticket> ticketList,boolean selection) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Ticket ticket: ticketList) {
                bufferedWriter.write(ticket.showInfo());
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
    public static List<Ticket> readTicket() {
        List<Ticket> ticketList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arrTicket;
            while ((line = bufferedReader.readLine()) != null) {
                arrTicket = line.split(",");
                Ticket ticket = new Ticket(arrTicket[1],Double.parseDouble(arrTicket[2]),arrTicket[3]);
                ticketList.add(ticket);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return  ticketList;
    }
}
