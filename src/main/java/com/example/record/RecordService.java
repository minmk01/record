package com.example.record;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RecordService {

    private final RecordRepository recordRepository;

    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }
}
