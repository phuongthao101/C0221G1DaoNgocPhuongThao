package bai_1_java_introduction.thuc_hanh.chi_so_can_nang;

import java.util.FormatFlagsConversionMismatchException;
import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float height;
        float weight;
        System.out.println("Enter height");
        height = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter weight");
        weight = Float.parseFloat(scanner.nextLine());


        float bmi;
        bmi = (float) (weight / Math.pow(height, 2));
        System.out.println("BMI is:" + bmi);
        if(bmi<18.5){
            System.out.printf("Underweight");
        }
        else if (bmi < 25.0)
            System.out.printf( "Normal");
        else if (bmi < 30.0)
            System.out.printf("Overweight");
        else
            System.out.printf( "Obese");

    }
}
