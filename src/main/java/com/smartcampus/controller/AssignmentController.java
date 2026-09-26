package com.smartcampus.controller;

import com.smartcampus.entity.Assignment;
import com.smartcampus.service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(
            @RequestBody Assignment assignment) {
        return ResponseEntity.ok(
                assignmentService.createAssignment(assignment)
        );
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        return ResponseEntity.ok(
                assignmentService.getAllAssignments()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(
            @PathVariable Long id) {

        return assignmentService.getAssignmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Assignment>> getByDifficulty(
            @PathVariable String difficulty) {

        return ResponseEntity.ok(
                assignmentService.getByDifficulty(difficulty)
        );
    }

    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<Assignment>> getByTopic(
            @PathVariable String topic) {

        return ResponseEntity.ok(
                assignmentService.getByTopic(topic)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(
            @PathVariable Long id,
            @RequestBody Assignment assignment) {

        return ResponseEntity.ok(
                assignmentService.updateAssignment(id, assignment)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(
            @PathVariable Long id) {

        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}