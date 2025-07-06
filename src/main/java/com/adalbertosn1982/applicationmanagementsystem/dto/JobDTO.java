package com.adalbertosn1982.applicationmanagementsystem.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class JobDTO {
    private Long id;
    private String title;
    private String description;
}
