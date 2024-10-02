package com.example.record;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class SelfInterview extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String question;

    @Column
    private String answer;

    @Column
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
}
