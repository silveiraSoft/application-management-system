package com.adalbertosn1982.applicationmanagementsystem.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobApplicationDTO {
    private Long id;
    private LocalDate appliedAt;
    private Long jobId;
    private String jobTitle;
}
