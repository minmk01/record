package com.example.record;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Table
public class SelfInterview extends BaseEntity {

    private String question;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User user;

}
