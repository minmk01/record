package com.example.record;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/record")
public class RecordController {

    private final RecordService recordService;

    @PostMapping
    public RecordResponseDTO createRecord(@RequestBody RecordRequestDTO recordRequestDTO) {
        Record record = Record.toEntity(recordRequestDTO);
        Record savedRecord = recordService.createRecord(record);
        return RecordResponseDTO.toDTO(savedRecord);
    }
}
