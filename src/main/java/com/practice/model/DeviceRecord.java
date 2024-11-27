package com.practice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class DeviceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String recordType;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private LocalDateTime eventDateTime;

    private int fieldA;
    private String fieldB;
    private double fieldC;


}

