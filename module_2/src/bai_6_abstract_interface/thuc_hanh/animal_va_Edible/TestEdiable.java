package bai_6_abstract_interface.thuc_hanh.animal_va_Edible;

import bai_6_abstract_interface.thuc_hanh.animal_va_Edible.Apple;
import bai_6_abstract_interface.thuc_hanh.animal_va_Edible.Fruit;
import bai_6_abstract_interface.thuc_hanh.animal_va_Edible.Orange;

public class TestEdiable {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
