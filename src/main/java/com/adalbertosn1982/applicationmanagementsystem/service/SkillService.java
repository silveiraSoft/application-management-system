package com.adalbertosn1982.applicationmanagementsystem.service;

import com.adalbertosn1982.applicationmanagementsystem.entity.Skill;
import com.adalbertosn1982.applicationmanagementsystem.exception.RegisterNotFoundException;
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

    //public Optional<Skill> findById(Long id) { return repository.findById(id); }

    public Skill save(Skill skill) {
        if (skill.getName() == null || skill.getName().trim().isEmpty()) {
            throw new SkillIllegalArgumentException("Skill name cannot be blank");
        }
        return repository.save(skill);
    }
    public Skill update(Long id, Skill updatedSkill) {
        return repository.findById(id)
                .map(skill -> {
                    skill.setName(updatedSkill.getName());
                    return repository.save(skill);
                })
                .orElseThrow(() -> new RegisterNotFoundException("Skill not found with id: " + id));
    }

    public Skill findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException("Skill not found with id: " + id));
    }


    public void deleteById(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException("Skill not found with id: " + id));
        repository.deleteById(id);
    }
}
