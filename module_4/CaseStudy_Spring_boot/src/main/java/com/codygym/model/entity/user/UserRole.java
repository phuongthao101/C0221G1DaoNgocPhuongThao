package com.codygym.model.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String useName;
    @ManyToOne
    @JoinColumn(name = "userName" )
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
