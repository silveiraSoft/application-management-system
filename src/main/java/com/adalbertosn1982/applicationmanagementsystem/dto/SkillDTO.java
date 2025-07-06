package com.adalbertosn1982.applicationmanagementsystem.dto;

//import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SkillDTO implements Serializable {
    private Long id;
    @NotBlank(message = "Skill name is required")
    @Size(min = 2, max = 65, message = "Skill name must be between 2 and 65 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s.+#-]+$", message = "Skill name can only contain letters, numbers, spaces and basic punctuation")
    private String name;
}
