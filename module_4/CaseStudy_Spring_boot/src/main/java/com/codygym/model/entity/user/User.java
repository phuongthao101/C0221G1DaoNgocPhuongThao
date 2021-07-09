package com.codygym.model.entity.user;

import com.codygym.model.entity.employee.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    private String userName;
    private String password;
    @OneToOne(mappedBy = "user")
    private Employee employee;
    @OneToMany(mappedBy = "user")
    List<UserRole> userRoles;

    public User(String userName, String password, Employee employee, List<UserRole> userRoles) {
        this.userName = userName;
        this.password = password;
        this.employee = employee;
        this.userRoles = userRoles;
    }

    public User() {
    }
}
