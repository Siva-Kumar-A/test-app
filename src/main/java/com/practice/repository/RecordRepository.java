package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.DeviceRecord;

public interface RecordRepository extends JpaRepository<DeviceRecord, Long> {
}