package com.hospital;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;
    private LocalDateTime appointmentDate;
}
