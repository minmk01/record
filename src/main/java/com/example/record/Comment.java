package com.example.record;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Long authorId;

    @Column(nullable = false)
    private Long recordId;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recordId")
    private Record record;

}
