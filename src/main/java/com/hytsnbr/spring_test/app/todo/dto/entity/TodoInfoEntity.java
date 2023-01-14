package com.hytsnbr.spring_test.app.todo.dto.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("todo_data")
public class TodoInfoEntity {
    
    @Id
    private long id;
    
    @Column
    @NotNull
    private Integer process;
    
    @Column
    @NotNull
    private String text;
    
    @Column
    private Timestamp createAt;
    
    @Column
    private Timestamp updateAt;
}
