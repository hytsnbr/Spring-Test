package com.hytsnbr.spring_test.app.todo.dto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Table(name = "todo_data")
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
