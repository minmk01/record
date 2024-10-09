package com.example.record;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Table
public class User extends BaseEntity {

    private String username;

    private String password;

    private String email;

}
