package com.adalbertosn1982.applicationmanagementsystem.service;

import com.adalbertosn1982.applicationmanagementsystem.entity.Applicant;
import com.adalbertosn1982.applicationmanagementsystem.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
    private final ApplicantRepository repository;

    public ApplicantService(ApplicantRepository repository) {
        this.repository = repository;
    }

    public List<Applicant> findAll() { return repository.findAll(); }

    public Optional<Applicant> findById(Long id) { return repository.findById(id); }

    public Applicant save(Applicant applicant) { return repository.save(applicant); }

    public void deleteById(Long id) { repository.deleteById(id); }
}
