package bai_9_stack_queue.bai_tap.to_chuc_du_lieu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("hai", "10/1/95", "nam"));
        personList.add(new Person("thao", "10/1/94", "nu"));
        Collections.sort(personList, new ComparatorBirthDay());
        for (Person item : personList) {
            System.out.println(item + "\n");
        }

        Queue<Person> queueNu = new LinkedList<>();
        Queue<Person> queueNam = new LinkedList<>();
        while (!personList.isEmpty()) {
            Person item = personList.remove(0);
            if (item.equals("girl")) {
                queueNu.add(item);                     //  đưa vào queue NU.
            } else if (item.equals("men")) {
                queueNam.add(item);
            }
        }
        while (!queueNu.isEmpty()) {
            personList.add(queueNu.remove());
        }
        while (!queueNam.isEmpty()) {
            personList.add(queueNam.remove());
        }
        for (Person item : personList) {
            System.out.println(item);
        }
    }


}


