package bai_1_java_introduction.thuc_hanh.gia_pt_bac_nhat;
import java.util.Scanner;
public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        Scanner scanner = new Scanner(System.in);

        double a;
        double b;
        double c;
        System.out.println("a: ");
        a = Float.parseFloat(scanner.nextLine());
        System.out.println("b: ");
        b = Float.parseFloat(scanner.nextLine());
        System.out.println("b: ");
        c = Float.parseFloat(scanner.nextLine());

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f", answer);
        } else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }

        }
    }
}


