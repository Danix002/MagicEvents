package com.service.eventsmanagementservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventDTO {
    @NotNull(message = "Title is required")
    private String title;
    @NotNull(message = "Description is required")
    private String description;
    @NotNull(message = "Starting is required")
    private LocalDateTime starting;
    @NotNull(message = "Ending is required")
    private LocalDateTime ending;
    @NotNull(message = "Location is required")
    private String location;

    @NotNull(message = "Creator Magic Events Tag is required")
    private Long creator;

    @NotNull(message = "Partecipants is required")
    private ArrayList<String> partecipants;

    @NotNull(message = "Admins is required")
    private ArrayList<String> admins;
    
    private String image;

    public EventDTO() {}

    public EventDTO(
            String title,
            String description,
            LocalDateTime start,
            LocalDateTime end,
            String location,
            Long creator,
            ArrayList<String> partecipants,
            ArrayList<String> admins,
            String image
    ) {
        this.title = title;
        this.description = description;
        this.starting = start;
        this.ending = end;
        this.location = location;
        this.creator = creator;
        this.partecipants = partecipants;
        this.admins = admins;
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDateTime getEnding() {
        return this.ending;
    }

    public LocalDateTime getStarting() {
        return this.starting;
    }

    public String getTitle() {
        return this.title;
    }

    public String getLocation() {
        return this.location;
    }

    public Long getCreator() {
        return this.creator;
    }

    public List<String> getPartecipants() {
        return this.partecipants;
    }

    public List<String> getAdmins() {
        return this.admins;
    }

    public String getImage() {
        return this.image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnding(LocalDateTime end) {
        this.ending = end;
    }

    public void setStarting(LocalDateTime start) {
        this.starting = start;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public void setAdmins(ArrayList<String> admins) {
        this.admins = admins;
    }

    public void setPartecipants(ArrayList<String> partecipants) {
        this.partecipants = partecipants;
    }

    public void addPartecipant(String partecipant) {
        this.partecipants.add(partecipant);
    }

    public void setImage(String image) {
        this.image = image;
    }
}

