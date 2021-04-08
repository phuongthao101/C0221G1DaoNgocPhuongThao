package bai_6_abstract_interface.bai_tap.Colorable;

public class Main {

        public static void main(String[] args) {
            Square square=new Square(9,"red",true);
            System.out.println(square);
            square.howToColor();

            Circle circle=new Circle(2,"red",false);
            System.out.println(circle);
            circle.howToColor();

            Rectangle rectangle=new Rectangle(6,5,"red",true);
            System.out.println(rectangle);

        }

}
