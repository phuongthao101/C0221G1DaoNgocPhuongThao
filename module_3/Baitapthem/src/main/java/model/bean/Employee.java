package model.bean;

public class Employee {
//    mã nhân viên, tên nhân viên, ngày sinh.

    private int employeeId;
    private String name;
    private String birthday;

    public Employee() {
    }

    public Employee(int employeeId, String name, String birthday) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthday = birthday;
    }

    public Employee(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
