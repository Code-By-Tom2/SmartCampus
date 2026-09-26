package com.smartcampus.repository;

import com.smartcampus.entity.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HackathonRepository extends JpaRepository<Hackathon, Long> {

    List<Hackathon> findByPlatform(String platform);

    List<Hackathon> findByStatus(String status);
}