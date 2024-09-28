package com.example.record;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RecordService {

    private final RecordRepository recordRepository;

    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    public Optional<Record> readRecord(int id) {
        return recordRepository.findById(id);
    }

//    @Transactional
//    public int updateRecord(int id, RecordRequestDTO recordRequestDTO) {
//        Optional<Record> record = recordRepository.findById(id);
//        return record;
//    }

}
