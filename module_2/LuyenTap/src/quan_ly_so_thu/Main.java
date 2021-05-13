package quan_ly_so_thu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;

        Zoo zoo = new Zoo();
        do {
            zoo.showMenu();
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }

        }while (choose != 6);
    }
}
