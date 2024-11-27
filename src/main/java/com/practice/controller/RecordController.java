package com.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practice.model.DeviceRecord;
import com.practice.service.RecordService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class RecordController {
    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    @GetMapping("/nocontent")
    public ResponseEntity<Void> handleNoContent() {
        log.info("Request recieved for No content");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/echo")
    public ResponseEntity<DeviceRecord> echoPayload(@Valid @RequestBody DeviceRecord payload) {
        log.info("Request recieved for Echo");
        return ResponseEntity.ok(payload);
    }

    @PostMapping("/device")
    public ResponseEntity<String> returnDeviceId(@Valid @RequestBody DeviceRecord payload) {
        log.info("Request recieved for DeviceId", payload);
        DeviceRecord saved = service.saveRecord(payload);
        return new ResponseEntity(saved.getId(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<DeviceRecord>> getAllDevices(){
        log.info("Request recieved for All Devices");
        List<DeviceRecord> allRecords = service.getAllRecords();
        return ResponseEntity.ok(allRecords);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<DeviceRecord> getDeviceById(@PathVariable Long  id) {
        log.info("Request recieved for Id", id);
        Optional<DeviceRecord> record = service.getRecord(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
