package com.adalbertosn1982.applicationmanagementsystem.repository;

import com.adalbertosn1982.applicationmanagementsystem.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {}