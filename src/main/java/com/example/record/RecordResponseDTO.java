package com.example.record;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class RecordResponseDTO {

    private final String feeling;
    private final String contents;
    private final String oneSentence;

    public RecordResponseDTO(String feeling, String contents, String oneSentence) {
        this.feeling = feeling;
        this.contents = contents;
        this.oneSentence = oneSentence;
    }

    public static RecordResponseDTO toDTO(Record record) {
        return RecordResponseDTO.builder()
                .feeling(record.getFeeling())
                .contents(record.getContents())
                .oneSentence(record.getOneSentence())
                .build();
    }

}
