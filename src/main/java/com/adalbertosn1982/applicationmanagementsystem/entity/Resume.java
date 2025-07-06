package com.adalbertosn1982.applicationmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filePath;

    @OneToOne(mappedBy = "resume")
    private Applicant applicant;
}
