package com.example.record;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class SelfInterview extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Long authorId;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User user;

}
