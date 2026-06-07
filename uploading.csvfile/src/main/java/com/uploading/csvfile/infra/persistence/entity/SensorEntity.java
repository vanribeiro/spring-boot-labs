package com.uploading.csvfile.infra.persistence.entity;

import com.uploading.csvfile.domain.enums.SensorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sensor")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SensorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Boolean active;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SensorType sensor;
    
}
