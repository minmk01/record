package com.example.record;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/record")
public class RecordController {

    private final RecordService recordService;

    //일기 생성하기
    @PostMapping
    public RecordResponseDTO createRecord(@RequestBody RecordRequestDTO recordRequestDTO) {
        Record record = Record.toEntity(recordRequestDTO);
        Record savedRecord = recordService.createRecord(record);
        return RecordResponseDTO.toDTO(savedRecord);
    }

    //일기 기록 가져오기
    @GetMapping("/{id}")
    public Optional<Record> getRecord(@PathVariable Long id) {
        return recordService.getRecord(id);
    }

    //일기 수정하기
//    @PutMapping("/{id}")
//    public int update(@PathVariable int id, @RequestBody RecordRequestDTO recordRequestDTO) {
//        return recordService.updateRecord(id, recordRequestDTO);
//    }

}
