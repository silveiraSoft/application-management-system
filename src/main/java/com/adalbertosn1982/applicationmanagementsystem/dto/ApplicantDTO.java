package com.adalbertosn1982.applicationmanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ApplicantDTO {
    private Long id;
    private String name;
    private ResumeDTO resume;
    private Set<SkillDTO> skills;
    private List<JobApplicationDTO> applications;
}
