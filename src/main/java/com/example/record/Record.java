package com.example.record;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "record")
public class Record extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Long authorId;

    @Column(nullable = false)
    private String feeling;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String oneSentence;

    @Column(columnDefinition = "boolean default false")
    private Boolean isShared;

    private Integer like;

    private Integer cheerUp;

    @Convert(converter = StringListConverter.class)
    private List<String> comments;

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


