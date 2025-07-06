package com.adalbertosn1982.applicationmanagementsystem.controller;

import com.adalbertosn1982.applicationmanagementsystem.dto.SkillDTO;
import com.adalbertosn1982.applicationmanagementsystem.entity.Skill;
import com.adalbertosn1982.applicationmanagementsystem.mapper.ApplicantMapper;
import com.adalbertosn1982.applicationmanagementsystem.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService service;
    private final ApplicantMapper mapper;

    public SkillController(SkillService service, ApplicantMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<SkillDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toSkillDTO)
                .collect(Collectors.toList());
    }

    /*
    @Operation(
            summary = "Create new skill",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Skill created successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SkillDTO.class))
                    )
            }
    )*/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    //@PostMapping
    public ResponseEntity<SkillDTO> create(@RequestBody @Valid SkillDTO dto) {
        Skill saved = service.save(mapper.toSkillEntity(dto));
        //return mapper.toSkillDTO(saved);
        return ResponseEntity.status(HttpStatus.CREATED)
                //.contentType(MediaType.APPLICATION_JSON)
                .body(mapper.toSkillDTO(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
