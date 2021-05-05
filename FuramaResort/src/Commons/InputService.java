package Commons;

import Models.*;
import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static Controllers.ServiceController.*;

public class InputService {
    List<Customer> customers = new ArrayList<>();


    private static Scanner scanner = new Scanner(System.in);

    public static void inputVilla() {
        System.out.println("enter id");
        String id = scanner.nextLine();

        while (!Pattern.matches(Vadidate.ID_VILLA_REGEX, id)) {
            System.out.println("enter id SVVL-YYYY");
            id = scanner.nextLine();
        }

        System.out.println("enter name");
        String name = scanner.nextLine();
        while (!Pattern.matches(Vadidate.SERVICE_NAME_REGEX, name)) {
            System.out.println("enter name FIRST IS UPPERCASE");
            name = scanner.nextLine();
        }
        System.out.println("enter area use");
        String area = scanner.nextLine();
        while (!Pattern.matches(Vadidate.AREA_REGEX, area)) {
            System.out.println("enter area >30");
            area = scanner.nextLine();
        }
        System.out.println("enter cost");
        String cost = scanner.nextLine();
        while (!Pattern.matches(Vadidate.COST_REGEX, cost)) {
            System.out.println("enter cost just number");
            cost = scanner.nextLine();
        }
        System.out.println("enter people");
        String people = scanner.nextLine();
        while (!Pattern.matches(Vadidate.PEOPLE_REGEX, people)) {
            System.out.println("enter area 0< && <30");
            people = scanner.nextLine();
        }
        System.out.println("enter rent type");
        String rentType = scanner.nextLine();
        while (!Pattern.matches(Vadidate.RENT_REGEX, rentType)) {
            System.out.println("enter rent type: day || month || year");
            rentType = scanner.nextLine();
        }
        System.out.println("enter standard room");
        String standardRoom = scanner.nextLine();
        System.out.println("enter description");
        String description = scanner.nextLine();
        System.out.println("enter floors");
        String floors = scanner.nextLine();


        while (!Pattern.matches(Vadidate.FLOORS_REGEX, floors)) {
            System.out.println("enter floors just number");
            floors = scanner.nextLine();
        }
        System.out.println("enter pool areas");
        String poolArea = scanner.nextLine();

        while (!Pattern.matches(Vadidate.AREA_REGEX, poolArea)) {
            System.out.println("enter area 0< && <30");
            poolArea = scanner.nextLine();
        }
        Villa villa = new Villa(id, name, area, cost, people, rentType, standardRoom, description, floors, poolArea);
        villas.add(villa);

    }

    public static void inputHouse() {
        System.out.println("enter id");
        String id = scanner.nextLine();
        while (!Pattern.matches(Vadidate.ID_VILLA_REGEX, id)) {
            System.out.println("enter id SVVL-YYYY");
            id = scanner.nextLine();
        }
        System.out.println("enter name");
        String name = scanner.nextLine();
        while (!Pattern.matches(Vadidate.SERVICE_NAME_REGEX, name)) {
            System.out.println("enter name FIRST IS UPPERCASE");
            name = scanner.nextLine();
        }
        System.out.println("enter area use");
        String area = scanner.nextLine();
        while (!Pattern.matches(Vadidate.AREA_REGEX, area)) {
            System.out.println("enter area >30");
            area = scanner.nextLine();
        }
        System.out.println("enter cost");
        String cost = scanner.nextLine();
        while (!Pattern.matches(Vadidate.COST_REGEX, cost)) {
            System.out.println("enter cost just number");
            cost = scanner.nextLine();
        }
        System.out.println("enter people");
        String people = scanner.nextLine();
        while (!Pattern.matches(Vadidate.PEOPLE_REGEX, people)) {
            System.out.println("enter area 0< && <30");
            people = scanner.nextLine();
        }
        System.out.println("enter rent type");
        String rentType = scanner.nextLine();
        while (!Pattern.matches(Vadidate.RENT_REGEX, rentType)) {
            System.out.println("enter rent type: day || month || year");
            rentType = scanner.nextLine();
        }
        System.out.println("enter standard room");
        String standardRoom = scanner.nextLine();
        System.out.println("enter description");
        String description = scanner.nextLine();
        System.out.println("enter floors");
        String floors = scanner.nextLine();
        while (!Pattern.matches(Vadidate.FLOORS_REGEX, floors)) {
            System.out.println("enter floors just number");
            floors = scanner.nextLine();
        }
        House house = new House(id, name, area, cost, people, rentType, standardRoom, description, floors);
        houses.add(house);

    }


    public static void inputRoom() {

            System.out.println("enter idRoom");
            String idRoom = scanner.nextLine();
            while (!Pattern.matches(Vadidate.ID_VILLA_REGEX, idRoom)) {
                System.out.println("enter idRoom SVVL-YYYY");
                idRoom = scanner.nextLine();
            }
            System.out.println("enter nameRoom ");
            String nameRoom = scanner.nextLine();
            while (!Pattern.matches(Vadidate.SERVICE_NAME_REGEX, nameRoom)) {
                System.out.println("enter nameRoom  FIRST IS UPPERCASE");
                nameRoom = scanner.nextLine();
            }
            System.out.println("enter areaRoom use");
            String areaRoom = scanner.nextLine();
            while (!Pattern.matches(Vadidate.AREA_REGEX, areaRoom)) {
                System.out.println("enter areaRoom >30");
                areaRoom = scanner.nextLine();
            }
            System.out.println("enter costRoom");
            String costRoom = scanner.nextLine();
            while (!Pattern.matches(Vadidate.COST_REGEX, costRoom)) {
                System.out.println("enter costRoom just number");
                costRoom = scanner.nextLine();
            }
            System.out.println("enter peopleRoom");
            String peopleRoom = scanner.nextLine();
            while (!Pattern.matches(Vadidate.PEOPLE_REGEX, peopleRoom)) {
                System.out.println("enter areaRoom 0< && <30");
                peopleRoom = scanner.nextLine();
            }
            System.out.println("enter rent type");
            String rentTypeRoom = scanner.nextLine();
            while (!Pattern.matches(Vadidate.RENT_REGEX, rentTypeRoom)) {
                System.out.println("enter rent type: day || month || year");
                rentTypeRoom = scanner.nextLine();
            }
//            System.out.println("enter free service");
//            String freeService = scanner.nextLine();
//            while (!Pattern.matches(Vadidate.FREE_SERVICE_REGEX, freeService)) {
//                System.out.println("enter areaRoom 0< && <30");
//                freeService = scanner.nextLine();
//            }
            System.out.println("enter extraService");
            String extraService = scanner.nextLine();
            Room room = new Room(idRoom, nameRoom, areaRoom, costRoom, peopleRoom, rentTypeRoom, extraService);

            rooms.add(room);
            FuncReadAndWriteFile.writeFile("House.csv", (List<Services>) room, true);
        }



    public static void inputCustomer(){

        System.out.println("Enter name: ");
        String nameOfCustomer = scanner.nextLine();

        System.out.println("Enter Date of Birth: ");
        String dateOfBirth = scanner.nextLine();

        System.out.println("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.println("Enter Number of identity Card: ");
        String idCard = scanner.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter type of customer: ");
        String typeOfCustomer = scanner.nextLine();

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Enter address: ");
        String address = scanner.nextLine();

        System.out.println("Enter services: ");
        String services = scanner.nextLine();

        Customer customer = new Customer(nameOfCustomer, dateOfBirth,  gender,  idCard,
                phoneNumber,  typeOfCustomer,  email, address,  services);
        customer.add(customer);
    }
}

