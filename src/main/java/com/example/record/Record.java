package com.example.record;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table
public class Record extends BaseEntity {

    private String feeling;

    private String contents;

    private String oneSentence;

    private Boolean isShared;

    private Integer likes;

    private Integer cheerUp;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User user;

    @Builder
    public Record(String feeling, String contents, String oneSentence) {
        this.feeling = feeling;
        this.contents = contents;
        this.oneSentence = oneSentence;
    }

    public static Record toEntity(RecordRequestDTO recordRequestDTO) {
        return Record.builder()
                .feeling(recordRequestDTO.getFeeling())
                .contents(recordRequestDTO.getContents())
                .oneSentence(recordRequestDTO.getOneSentence())
                .build();
    }

}


