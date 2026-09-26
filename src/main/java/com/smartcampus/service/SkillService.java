package com.smartcampus.service;

import com.smartcampus.entity.Skill;
import com.smartcampus.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Optional<Skill> getSkillById(Long id) {
        return skillRepository.findById(id);
    }

    public Optional<Skill> getSkillByName(String name) {
        return skillRepository.findByName(name);
    }

    public Skill updateSkill(Long id, Skill updatedSkill) {
        Skill existingSkill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        existingSkill.setName(updatedSkill.getName());
        existingSkill.setCategory(updatedSkill.getCategory());
        existingSkill.setDescription(updatedSkill.getDescription());

        return skillRepository.save(existingSkill);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}