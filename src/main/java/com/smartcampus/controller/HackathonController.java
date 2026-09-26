package com.smartcampus.controller;

import com.smartcampus.entity.Hackathon;
import com.smartcampus.service.HackathonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hackathons")
@CrossOrigin(origins = "*")
public class HackathonController {

    private final HackathonService hackathonService;

    public HackathonController(HackathonService hackathonService) {
        this.hackathonService = hackathonService;
    }

    @PostMapping
    public ResponseEntity<Hackathon> createHackathon(
            @RequestBody Hackathon hackathon) {

        return ResponseEntity.ok(
                hackathonService.createHackathon(hackathon)
        );
    }

    @GetMapping
    public ResponseEntity<List<Hackathon>> getAllHackathons() {

        return ResponseEntity.ok(
                hackathonService.getAllHackathons()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hackathon> getHackathonById(
            @PathVariable Long id) {

        return hackathonService.getHackathonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/platform/{platform}")
    public ResponseEntity<List<Hackathon>> getByPlatform(
            @PathVariable String platform) {

        return ResponseEntity.ok(
                hackathonService.getByPlatform(platform)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Hackathon>> getByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                hackathonService.getByStatus(status)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hackathon> updateHackathon(
            @PathVariable Long id,
            @RequestBody Hackathon hackathon) {

        return ResponseEntity.ok(
                hackathonService.updateHackathon(id, hackathon)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHackathon(
            @PathVariable Long id) {

        hackathonService.deleteHackathon(id);

        return ResponseEntity.noContent().build();
    }
}