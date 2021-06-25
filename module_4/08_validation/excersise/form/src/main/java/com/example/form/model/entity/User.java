package com.example.form.model.entity;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Controller
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String age;
    private String email;


}
