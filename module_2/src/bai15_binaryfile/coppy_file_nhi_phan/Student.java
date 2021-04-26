package bai15_binaryfile.coppy_file_nhi_phan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student<E> implements Serializable {
    private int id;
    private String name;
    private String address;

    public Student(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.address = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + address + '\'' +
                '}';
    }


    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Nam", " Đà Nẵng"));
        studentList.add(new Student(2, "Nam2", " Sài gòn"));

   WriteFile<Student> writeFile = new WriteFile();

   writeFile.writeToFile("src\\bai15_binaryfile\\coppy_file_nhi_phan\\test.csv", studentList);
        System.out.println(writeFile. readFromFile("src\\bai15_binaryfile\\coppy_file_nhi_phan\\test.csv", studentList));
    }

}