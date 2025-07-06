package com.adalbertosn1982.applicationmanagementsystem.dto;

//import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SkillDTO implements Serializable {
    private Long id;
    @NotBlank(message = "Skill name is required")
    private String name;
}
