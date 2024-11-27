package com.practice.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.practice.model.DeviceRecord;
import com.practice.repository.RecordRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecordService {
    private final RecordRepository repository;

    public RecordService(RecordRepository repository) {
        this.repository = repository;
    }

    public DeviceRecord saveRecord(DeviceRecord record) {
        log.info("Saving the record: " , record);
        return repository.save(record);
    }

    public Optional<DeviceRecord> getRecord(Long id) {
        log.info("Fetching the record with id:", id);
        return repository.findById(id);
    }

    public List<DeviceRecord> getAllRecords(){
        log.info("Fetching all records");
        return repository.findAll();
    }
}

