package quan_ly_so_thu;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    Scanner scanner = new Scanner(System.in);
    private int roomNo;
    ArrayList<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void removeAnimal(String name) {
        System.out.println("nhâp con vật cần xóa ");
        String deleteAnimal = scanner.nextLine();
        for (Animal item : animalList) {
            if (deleteAnimal.equals(item.getName())) {
                animalList.remove(item);
            }

        }

    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã chuồng:");
        int roomNo = scanner.nextInt();
    }

    public void display() {
        System.out.println("Thông tin mã chuồng : " + "danh sách động vật: " + animalList);
    }


    public Room() {
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    public Room(Scanner scanner, int roomNo, ArrayList<Animal> animalList) {
        this.scanner = scanner;
        this.roomNo = roomNo;
        this.animalList = animalList;
    }

    public static Animal createAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Động vật cần khởi tạo: ");
        System.out.println("1. Tiger" +"\n2. Dog"+ "\n3. Cat " );
        Animal animal = null;
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                animal = new Tiger();
                break;
            case 2:
                animal = new Dog();
                break;
            case 3:
                animal = new Cat();
                break;
            default:
                System.out.println("Nhập lại option: ");

        }
        animal.input();
        return animal;

    }

}

