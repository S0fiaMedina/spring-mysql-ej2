package com.projectsample.sample.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
// esto es es parra manejar los campos created_at y updated_at de las entidades principales
public class Audit {
    
    @Column( name = "created_at")
    private LocalDateTime createdAt;

    @Column (name = "updated_at")
    private LocalDateTime updatedAt;


    // se llena el campo de created_at cuando el objeto se crea
    @PrePersist
    public void prePersistAudit(){
        this.createdAt = LocalDateTime.now();

    }

    // se llena el campo de updated_at cuando el objeto se modifica
    @PreUpdate
    public void preUpdateAudit(){
        this.updatedAt = LocalDateTime.now();
    }

    public Audit() {
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    


    
}