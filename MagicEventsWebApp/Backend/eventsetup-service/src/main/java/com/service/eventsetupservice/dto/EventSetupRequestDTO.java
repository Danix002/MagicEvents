package com.service.eventsetupservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventSetupRequestDTO {
    @NotNull(message = "Title is required")
    @NotBlank(message = "Title cannot be blank")
    private String title;
    
    @NotNull(message = "Description is required")
    @NotBlank(message = "Description cannot be blank")
    private String description;
    
    @NotNull(message = "Starting date is required")
    private LocalDateTime starting;
    
    @NotNull(message = "Ending date is required")
    private LocalDateTime ending;
    
    @NotNull(message = "Location is required")
    private String location;
    
    @NotNull(message = "Creator email is required")
    @NotBlank(message = "Creator email cannot be blank")
    private String creatorEmail;
    
    @NotNull(message = "Creator Magic Events Tag is required")
    private Long creatorMagicEventsTag;
    
    @NotNull(message = "Participants list is required")
    private ArrayList<String> participants;
    
    @NotNull(message = "Admins list is required")
    private ArrayList<String> admins;

    private String image;
    
    @NotNull(message = "game enabled flag is required")
    private Boolean gameEnabled;
    
    @NotNull(message = "Gallery enabled flag is required")
    private Boolean galleryEnabled;
    
    @NotNull(message = "Board enabled flag is required")
    private Boolean boardEnabled;
   
    private String galleryTitle;
    
    private String boardTitle;
    
    private String boardDescription;

    private String gameDescription;

    public EventSetupRequestDTO() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getStarting() { return starting; }
    public void setStarting(LocalDateTime starting) { this.starting = starting; }

    public LocalDateTime getEnding() { return ending; }
    public void setEnding(LocalDateTime ending) { this.ending = ending; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCreatorEmail() { return creatorEmail; }
    public void setCreatorEmail(String creatorEmail) { this.creatorEmail = creatorEmail; }

    public Long getCreatorMagicEventsTag() { return creatorMagicEventsTag; }
    public void setCreatorMagicEventsTag(Long creatorMagicEventsTag) { this.creatorMagicEventsTag = creatorMagicEventsTag; }

    public ArrayList<String> getParticipants() { return participants; }
    public void setParticipants(ArrayList<String> participants) { this.participants = participants; }

    public ArrayList<String> getAdmins() { return admins; }
    public void setAdmins(ArrayList<String> admins) { this.admins = admins; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Boolean getGalleryEnabled() { return galleryEnabled; }
    public void setGalleryEnabled(Boolean galleryEnabled) { this.galleryEnabled = galleryEnabled; }

    public Boolean getBoardEnabled() { return boardEnabled; }
    public void setBoardEnabled(Boolean boardEnabled) { this.boardEnabled = boardEnabled; }

    public Boolean getGameEnabled() { return gameEnabled; }
    public void setGameEnabled(Boolean gameEnabled) { this.gameEnabled = gameEnabled; }

    public String getGalleryTitle() { return galleryTitle; }
    public void setGalleryTitle(String galleryTitle) { this.galleryTitle = galleryTitle; }

    public String getBoardTitle() { return boardTitle; }
    public void setBoardTitle(String boardTitle) { this.boardTitle = boardTitle; }

    public String getGameDescription() {return gameDescription;}
    public void setGameDescription(String gameDescription) { this.gameDescription = gameDescription; }

    public String getBoardDescription() { return boardDescription; }
    public void setBoardDescription(String boardDescription) { this.boardDescription = boardDescription; }
}
