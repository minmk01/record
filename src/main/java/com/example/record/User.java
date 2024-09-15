package com.example.record;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(nullable = false)
    private String name;

}
