package com.example.record;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //모든 일기 조회
    @GetMapping
    public List<RecordResponseDTO> getAllRecords() {
        return recordService.getAllRecords();
    }

    //특정 일기 조회
    @GetMapping("/{id}")
    public RecordResponseDTO getRecord(@PathVariable Long id) {
        return recordService.getRecord(id);
    }

    //일기 수정
    @PutMapping("/{id}")
    public RecordResponseDTO updateRecord(@PathVariable Long id, @RequestBody RecordRequestDTO recordRequestDTO) {
        return recordService.updateRecord(id, recordRequestDTO);
    }

    //일기 삭제
    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
    }
}
