package Controllers;

import Commons.FuncReadAndWriteFile;
import Commons.InputService;
import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

import java.util.*;


public class ServiceController {

    private static Scanner scanner = new Scanner(System.in);

    public static List<Services> servicesList = new ArrayList();



    public static void addNewServices() {
        while (true) {
            System.out.println("1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to Menu\n" +
                    "5.Exit");
            switch (scanner.nextLine()) {
                case "1":
                    addVilla();
                    break;
                case "2":
                    addHouse();
                    break;
                case "3":
                    addRoom();
                    break;
                case "4":
                    MainController.displayMainMenu();
                    break;
                case "5":
                    System.exit(0);
            }
        }
    }

    private static void addRoom() {
//String idRoom, String nameRoom, String areaRoom, String costRoom, String peopleRoom, String rentTypeRoom, String extraService) {
        String id = InputService.inputId();
        String name = InputService.inputnameService();
        String area = InputService.inputAreaUse();
        String cost = InputService.inputRentalCost();
        String people = InputService.inputPeople();
        String rentType = InputService.inputTypeOfRent();
        String extraService = InputService.inputExtraService();

        List<Services> servicesList = new ArrayList<>();
        Services room = new Room(id, name, area, id, name, area, cost, people, rentType, extraService);
        servicesList.add(room);
        FuncReadAndWriteFile.writeFile("Room.csv", servicesList, true);


    }

    private static void addHouse() {
        String id = InputService.inputId();
        String name = InputService.inputnameService();
        String area = InputService.inputAreaUse();
        String cost = InputService.inputRentalCost();
        String people = InputService.inputPeople();
        String rentType = InputService.inputTypeOfRent();

        String standard = InputService.inputStandardRoom();
        String description = InputService.inputDescription();
        String floors = InputService.inputFloors();

        List<Services> servicesList = new ArrayList<>();
        Services house = new Room(id, name, area, cost, people, rentType, standard, description, floors);
        servicesList.add(house);
        FuncReadAndWriteFile.writeFile("House.csv", servicesList, true);

    }

    public static void addVilla() {
        String id = InputService.inputId();
        String name = InputService.inputnameService();
        String area = InputService.inputAreaUse();
        String cost = InputService.inputRentalCost();
        String people = InputService.inputPeople();
        String rentType = InputService.inputTypeOfRent();

        String standard = InputService.inputStandardRoom();
        String description = InputService.inputDescription();
        String floors = InputService.inputFloors();
        String poolArea = InputService.inputAreaUse();

        List<Services> servicesList = new ArrayList<>();
        Services villa = new Room(id, name, area, cost, people, rentType, standard, description, floors, poolArea);
        servicesList.add(villa);
        FuncReadAndWriteFile.writeFile("Villa.csv", servicesList, true);
    }


    public static void showServices() {
        while (true) {
            System.out.println("" +
                    "1.Show all Villa\n" +
                    "2.Show all House\n" +
                    "3.Show all Room\n" +
                    "4.Show all Name Villa not Duplicate\n" +
                    "5.Show all Name House not Duplicate\n" +
                    "6.Show all Name Room not Duplicate\n" +
                    "7.Back to Menu\n" +
                    "8.Exit");
            switch (scanner.nextLine()) {
                case "1":
                    showAllVilla();
                    break;
                case "2":
                    showAllHouse();
                    break;
                case "3":
                    showAllRoom();
                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    MainController.displayMainMenu();
                    break;
                case "8":
                    System.exit(0);
            }
        }

    }

    public static List<Villa> showAllVilla() {
        List<Services> list = FuncReadAndWriteFile.readFile("src\\Data\\Service.csv");
        List<Villa> villaList = new ArrayList<>();
        for (Services services : list) {
            if (services instanceof Villa) {
                villaList.add((Villa) services);
                System.out.println(services);
            }
        }
        return villaList;
    }


    public static List<House> showAllHouse() {
        List<Services> list = FuncReadAndWriteFile.readFile("src\\Data\\Service.csv");
        List<House> houseList = new ArrayList<>();
        for (Services services : list) {
            if (services instanceof House) {
                houseList.add((House) services);
                System.out.println(services);
            }
        }
        return houseList;
    }

    public static List<Room> showAllRoom() {
        List<Services> list = FuncReadAndWriteFile.readFile("src\\Data\\Service.csv");
        List<Room> roomList = new ArrayList<>();
        for (Services services : list) {
            if (services instanceof Room) {
                roomList.add((Room) services);
                System.out.println(services);
            }
        }
        return roomList;
    }

    public static void showAllServicesNotDuplicate(String fileName) {
        Set<String> setOfServices = new TreeSet<>();
        System.out.println("--------------------");
        System.out.println("List service not duplicate name");

    }

}


