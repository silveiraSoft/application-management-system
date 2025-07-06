package com.adalbertosn1982.applicationmanagementsystem.mapper;

import com.adalbertosn1982.applicationmanagementsystem.dto.SkillDTO;
import com.adalbertosn1982.applicationmanagementsystem.entity.Skill;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SkillMapper {

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
}
