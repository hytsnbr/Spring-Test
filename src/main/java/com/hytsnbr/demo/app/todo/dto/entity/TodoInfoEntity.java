package com.hytsnbr.demo.app.todo.dto.entity;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

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
