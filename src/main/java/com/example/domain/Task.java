package com.example.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    @Column(name = "dataTime")
    private LocalDateTime dateTime;
}