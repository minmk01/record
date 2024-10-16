package com.example.record;

import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecordService {

    private final EntityManager em;
    private final RecordRepository recordRepository;

    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    @Transactional(readOnly = true)
    public List<RecordResponseDTO> getAllRecords() {
        List<Record> records = (List<Record>) recordRepository.findAll();
        return records.stream().map(RecordResponseDTO::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RecordResponseDTO getRecord(Long id) {
        Record record = recordRepository.findById(id).orElseThrow();
        return RecordResponseDTO.toDTO(record);
    }

    @Transactional
    public RecordResponseDTO updateRecord(Long id, RecordRequestDTO recordRequestDTO) {
        Record record = recordRepository.findById(id).orElseThrow();

        record.changeFeeling(recordRequestDTO.getFeeling());
        record.changeContents(recordRequestDTO.getContents());
        record.changeOneSentence(recordRequestDTO.getOneSentence());

        return RecordResponseDTO.toDTO(record);
    }

    @Transactional
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

}
