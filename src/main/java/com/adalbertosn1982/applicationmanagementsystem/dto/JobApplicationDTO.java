package com.adalbertosn1982.applicationmanagementsystem.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class JobApplicationDTO {
    private Long id;
    private LocalDate appliedAt;
    private Long jobId;
    private String jobTitle;
}
