package bai10_stack_queue.baitap.ManagementAgency;

import java.util.*;

public class ManagementAgency {
     public static void main(String[] args) {
        ArrayList<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("Khoa","Nam","22/01/1997",23));
        listPerson.add(new Person("Sang","Nu","22/01/1997",25));
        listPerson.add(new Person("Van","Nam","22/05/1996",26));
        listPerson.add(new Person("Tung","Nu","22/07/1997",25));
        Queue<Person> queueNam = new ArrayDeque<>();
        Queue<Person> queueNu = new ArrayDeque<>();
         System.out.println("Pre-sort");
//         Collections.sort(listPerson,new ComparatorByBirthday());
         Collections.sort(listPerson,new ComparatorByAgeAndBirthday());
         for (Person persons: listPerson) {
             System.out.println(persons);
         }
         System.out.println("Sort");
         Collections.sort(listPerson, new ComparatorByAgeAndBirthday());
         for (Person person1: listPerson) {
             if (person1.getGender().equals("Nu")) {
                 queueNu.add(person1);
             } else {
                 queueNam.add(person1);
             }
         }
         List<Person> queuePerson = new ArrayList<>();
         queuePerson.addAll(queueNu);
         queuePerson.addAll(queueNam);

         for (Person personDisplay: queuePerson) {
             System.out.println(personDisplay);
         }
    }
}
