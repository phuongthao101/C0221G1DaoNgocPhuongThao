package Model;

public class Phone {
    private String phone;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String birthday;
    private String email;



    public Phone(String phone, String group, String name, String gender, String address, String birthday, String email) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public Phone(String[] strings) {
    }
    //Làm chổ ni để đọc ghi cho tiện thôi thảo


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return phone+","+group+","+name+","+gender+","+address+","+birthday+","+email;
        //lỗi ở đây nhé
    }
}
