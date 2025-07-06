package com.adalbertosn1982.applicationmanagementsystem.mapper;

import com.adalbertosn1982.applicationmanagementsystem.dto.*;
import com.adalbertosn1982.applicationmanagementsystem.entity.*;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {
    //ApplicantDTO toDTO(Applicant applicant);
    //Applicant toEntity(ApplicantDTO applicantDTO);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "resume", source = "resume")
    @Mapping(target = "skills", source = "skills")
    ApplicantDTO toDTO(Applicant applicant);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "resume", source = "resume")
    @Mapping(target = "skills", source = "skills")
    Applicant toEntity(ApplicantDTO applicantDTO);

    @Mapping(target = "id", source = "id")
    @Mapping( target = "filePath", source = "filePath")
    ResumeDTO toResumeDTO(Resume resume);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "filePath", source = "filePath")
    Resume toResumeEntity(ResumeDTO resumeDTO);

    //SkillDTO toSkillDTO(Skill skill);
    //Skill toSkillEntity(SkillDTO skillDTO);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    Skill toSkillEntity(SkillDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    SkillDTO toSkillDTO(Skill entity);

    @BeforeMapping
    default void validateSkillDTO(SkillDTO dto) {
        if (dto.getName() != null) {
            dto.setName(dto.getName().trim());
        }
    }


    JobDTO toJobDTO(Job job);
    Job toJobEntity(JobDTO jobDTO);

    default JobApplicationDTO toJobApplicationDTO(JobApplication app) {
        JobApplicationDTO dto = new JobApplicationDTO();
        dto.setId(app.getId());
        dto.setAppliedAt(app.getAppliedAt());
        if (app.getJob() != null) {
            dto.setJobId(app.getJob().getId());
            dto.setJobTitle(app.getJob().getTitle());
        }
        return dto;
    }

    default JobApplication toJobApplicationEntity(JobApplicationDTO dto) {
        JobApplication entity = new JobApplication();
        entity.setId(dto.getId());
        entity.setAppliedAt(dto.getAppliedAt());
        Job job = new Job();
        job.setId(dto.getJobId());
        entity.setJob(job);
        return entity;
    }
}
