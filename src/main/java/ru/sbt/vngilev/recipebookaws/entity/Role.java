package ru.sbt.vngilev.recipebookaws.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rolename")
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    List<User> users = new ArrayList<User>();

}