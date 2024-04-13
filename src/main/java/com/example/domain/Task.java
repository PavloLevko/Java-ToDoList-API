package com.example.domain;


import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

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

}
