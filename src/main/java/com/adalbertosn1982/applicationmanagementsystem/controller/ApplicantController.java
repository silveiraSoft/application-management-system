package com.adalbertosn1982.applicationmanagementsystem.controller;

import com.adalbertosn1982.applicationmanagementsystem.dto.ApplicantDTO;
import com.adalbertosn1982.applicationmanagementsystem.entity.Applicant;
import com.adalbertosn1982.applicationmanagementsystem.mapper.ApplicantMapper;
import com.adalbertosn1982.applicationmanagementsystem.service.ApplicantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    private final ApplicantService service;
    private final ApplicantMapper mapper;

    public ApplicantController(ApplicantService service, ApplicantMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ApplicantDTO> getAll() {
        return service.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicantDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ApplicantDTO create(@RequestBody ApplicantDTO dto) {
        Applicant saved = service.save(mapper.toEntity(dto));
        return mapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicantDTO> update(@PathVariable Long id, @RequestBody ApplicantDTO dto) {
        return service.findById(id).map(existing -> {
            Applicant updated = mapper.toEntity(dto);
            updated.setId(existing.getId());
            Applicant saved = service.save(updated);
            return ResponseEntity.ok(mapper.toDTO(saved));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
