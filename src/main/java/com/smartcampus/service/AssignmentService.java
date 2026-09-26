package com.smartcampus.service;

import com.smartcampus.entity.Assignment;
import com.smartcampus.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public List<Assignment> getByDifficulty(String difficulty) {
        return assignmentRepository.findByDifficulty(difficulty);
    }

    public List<Assignment> getByTopic(String topic) {
        return assignmentRepository.findByTopic(topic);
    }

    public Assignment updateAssignment(Long id, Assignment updatedAssignment) {
        Assignment existing = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        existing.setTitle(updatedAssignment.getTitle());
        existing.setDescription(updatedAssignment.getDescription());
        existing.setDifficulty(updatedAssignment.getDifficulty());
        existing.setTopic(updatedAssignment.getTopic());
        existing.setMaxScore(updatedAssignment.getMaxScore());
        existing.setGeneratedBy(updatedAssignment.getGeneratedBy());
        existing.setSkill(updatedAssignment.getSkill());

        return assignmentRepository.save(existing);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}