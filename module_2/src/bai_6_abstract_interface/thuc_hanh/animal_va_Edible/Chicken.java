package bai_6_abstract_interface.thuc_hanh.animal_va_Edible;

public class Chicken extends Animal implements Edible {

    @Override
    public String makeSound() {

        return "Chicken: cluck-cluck!";

    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}

