package quan_ly_so_thu;

import java.util.Scanner;
import java.util.SortedMap;

public abstract class Animal {
    private String name;
    private int age;
    private String description;

    public Animal() {
    }

    public Animal(String name, int age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        age = scanner.nextInt();
        System.out.println("Nhập mô tả:");
        description = scanner.nextLine();

    }
    public void display(){
        System.out.println(toString());
    }
    public abstract void showSound();

}
