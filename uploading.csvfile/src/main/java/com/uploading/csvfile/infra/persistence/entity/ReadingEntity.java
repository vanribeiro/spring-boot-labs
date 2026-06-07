package com.uploading.csvfile.infra.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reading")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReadingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private SensorEntity sensor;
    
    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private SensorLocationEntity location;

}