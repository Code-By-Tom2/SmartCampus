package com.smartcampus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "hackathons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hackathon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String organizer;

    private String platform;

    private String location;

    private String registrationUrl;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate registrationDeadline;

    private String skillsRequired;

    private String status;
}