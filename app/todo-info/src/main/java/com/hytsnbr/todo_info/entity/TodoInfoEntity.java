package com.hytsnbr.todo_info.entity;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

import com.hytsnbr.todo_info.constant.Processing;

@Getter
@Entity
@Table(name = "todo_data")
public class TodoInfoEntity {
    
    public static final String COLUMN_NAME_ID = "id";
    
    public static final String COLUMN_NAME_PROCESS = "process";
    
    public static final String COLUMN_NAME_TEXT = "text";
    
    public static final String COLUMN_NAME_CREATE_AT = "create_at";
    
    public static final String COLUMN_NAME_UPDATE_AT = "update_at";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_NAME_ID)
    private long id;
    
    @Column(name = COLUMN_NAME_PROCESS, nullable = false)
    private Integer process = Processing.NOT_YET_STARTED.getValue();
    
    @Column(name = COLUMN_NAME_TEXT, nullable = false)
    private String text;
    
    @CreationTimestamp
    @Column(name = COLUMN_NAME_CREATE_AT, updatable = false)
    private Timestamp createAt;
    
    @UpdateTimestamp
    @Column(name = COLUMN_NAME_UPDATE_AT)
    private Timestamp updateAt;
    
    public static TodoInfoEntity create(Integer process, String text) {
        var entity = new TodoInfoEntity();
        entity.process = process;
        entity.text = text;
        
        return entity;
    }
    
    public TodoInfoEntity create() {
        return new TodoInfoEntity();
    }
    
    public TodoInfoEntity update(Integer process, String text) {
        this.process = Objects.equals(this.process, process) ? this.process : process;
        this.text = StringUtils.equals(this.text, text) ? this.text : text;
        
        return this;
    }
    
    @PrePersist
    public void onPrePersist() {
    }
    
    @PreUpdate
    public void onPreUpdate() {
    }
}
