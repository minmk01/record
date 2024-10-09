package com.example.record;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Table
public class Comment extends BaseEntity {

    private String contents;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recordId")
    private Record record;

}
