package com.smartcampus.service;

import com.smartcampus.entity.Hackathon;
import com.smartcampus.repository.HackathonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HackathonService {

    private final HackathonRepository hackathonRepository;

    public HackathonService(HackathonRepository hackathonRepository) {
        this.hackathonRepository = hackathonRepository;
    }

    public Hackathon createHackathon(Hackathon hackathon) {
        return hackathonRepository.save(hackathon);
    }

    public List<Hackathon> getAllHackathons() {
        return hackathonRepository.findAll();
    }

    public Optional<Hackathon> getHackathonById(Long id) {
        return hackathonRepository.findById(id);
    }

    public List<Hackathon> getByPlatform(String platform) {
        return hackathonRepository.findByPlatform(platform);
    }

    public List<Hackathon> getByStatus(String status) {
        return hackathonRepository.findByStatus(status);
    }

    public Hackathon updateHackathon(Long id, Hackathon updatedHackathon) {
        Hackathon existing = hackathonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hackathon not found"));

        existing.setTitle(updatedHackathon.getTitle());
        existing.setDescription(updatedHackathon.getDescription());
        existing.setOrganizer(updatedHackathon.getOrganizer());
        existing.setPlatform(updatedHackathon.getPlatform());
        existing.setLocation(updatedHackathon.getLocation());
        existing.setRegistrationUrl(updatedHackathon.getRegistrationUrl());
        existing.setStartDate(updatedHackathon.getStartDate());
        existing.setEndDate(updatedHackathon.getEndDate());
        existing.setRegistrationDeadline(updatedHackathon.getRegistrationDeadline());
        existing.setSkillsRequired(updatedHackathon.getSkillsRequired());
        existing.setStatus(updatedHackathon.getStatus());

        return hackathonRepository.save(existing);
    }

    public void deleteHackathon(Long id) {
        hackathonRepository.deleteById(id);
    }
}