package com.example.record;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String feeling;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String oneSentence;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Record toEntity(RecordRequestDTO recordRequestDTO) {
        return Record.builder()
                .feeling(recordRequestDTO.getFeeling())
                .contents(recordRequestDTO.getContents())
                .oneSentence(recordRequestDTO.getOneSentence())
                .build();
    }
}


