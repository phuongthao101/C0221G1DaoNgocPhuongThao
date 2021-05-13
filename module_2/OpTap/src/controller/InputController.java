package controller;

import common.Validate;

import java.io.IOException;
import java.util.Scanner;

public class InputController {
    static Scanner scanner = new Scanner(System.in);

    public static String inputPalateCar() {
        String palateCar = null;
        while (true){
            try {

                System.out.println("Nhap bien kiem soat ");
                palateCar = scanner.nextLine();
                Validate.checkPalateCar(palateCar);
                return palateCar;
            } catch (Validate validate) {
                validate.printStackTrace();
            }
        }
    }
    public static String inputPalateTruck() {
        String palateTruck = null;
        while (true){
            try {

                System.out.println("Nhap bien kiem soat ");
                palateTruck = scanner.nextLine();
                Validate.checkPalateTruck(palateTruck);
                return palateTruck;
            } catch (Validate validate) {
                validate.printStackTrace();
            }
        }
    }
    public static String inputPalateBike() {
        String palateBike = null;
        while (true){
            try {

                System.out.println("Nhap bien kiem soat ");
                palateBike = scanner.nextLine();
                Validate.checkPalateBike(palateBike);
                return palateBike;
            } catch (Validate validate) {
                validate.printStackTrace();
            }
        }
    }
    public static String inputProduction(){
        System.out.println("Nhap hang san xuat");
        String production = scanner.nextLine();

        return production;
    }

    public static String inputYear(){
        System.out.println("Nhap nam san xuat");
        String year = scanner.nextLine();

        return year;
    }
    public static String inputOwner(){
        System.out.println("Nhap chu so huu");
        String owner = scanner.nextLine();

        return owner;
    }
    public static String inputWeight(){
        System.out.println("Nhap tai trong");
        String weight = scanner.nextLine();

        return weight;
    }
}

