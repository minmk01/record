package com.example.record;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
public class RecordResponseDTO {

    private final String feeling;
    private final String contents;
    private final String oneSentence;
    private final LocalDateTime updatedDate;

    public RecordResponseDTO(String feeling, String contents, String oneSentence, LocalDateTime updatedDate) {
        this.feeling = feeling;
        this.contents = contents;
        this.oneSentence = oneSentence;
        this.updatedDate = updatedDate;
    }

    public static RecordResponseDTO toDTO(Record record) {
        return RecordResponseDTO.builder()
                .feeling(record.getFeeling())
                .contents(record.getContents())
                .oneSentence(record.getOneSentence())
                .updatedDate(record.getUpdatedDate())
                .build();
    }

}
