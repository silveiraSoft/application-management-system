package com.adalbertosn1982.applicationmanagementsystem.service;

import com.adalbertosn1982.applicationmanagementsystem.entity.Skill;
import com.adalbertosn1982.applicationmanagementsystem.exception.SkillIllegalArgumentException;
import com.adalbertosn1982.applicationmanagementsystem.repository.SkillRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillService {
    private final SkillRepository repository;

    public SkillService(SkillRepository repository) {
        this.repository = repository;
    }

    public List<Skill> findAll() { return repository.findAll(); }

    public Optional<Skill> findById(Long id) { return repository.findById(id); }

    public Skill save(Skill skill) {
        if (skill.getName() == null || skill.getName().trim().isEmpty()) {
            throw new SkillIllegalArgumentException("Skill name cannot be blank");
        }
        return repository.save(skill);
    }

    public void deleteById(Long id) { repository.deleteById(id); }
}
