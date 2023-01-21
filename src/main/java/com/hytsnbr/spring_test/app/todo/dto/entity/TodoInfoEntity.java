package com.hytsnbr.spring_test.app.todo.dto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Entity
@Table(name = "todo_data")
public class TodoInfoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "process", nullable = false)
    private Integer process;
    
    @Column(name = "text", nullable = false)
    private String text;
    
    @Column(name = "create_at", updatable = false)
    private Timestamp createAt;
    
    @Column(name = "update_at")
    private Timestamp updateAt;
    
    public void setProcess(Integer process) {
        this.process = process;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @PrePersist
    public void onPrePersist() {
        final var timestamp = Timestamp.from(Instant.now());
        createAt = timestamp;
        updateAt = timestamp;
    }
    
    @PreUpdate
    public void onPreUpdate() {
        final var timestamp = Timestamp.from(Instant.now());
        updateAt = timestamp;
    }
}
