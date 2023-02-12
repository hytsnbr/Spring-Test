package com.hytsnbr.todo.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.sql.Timestamp;

@StaticMetamodel(TodoInfoEntity.class)
public abstract class TodoInfoEntity_ {
    
    public static final String PROCESS = "process";
    
    public static final String UPDATE_AT = "updateAt";
    
    public static final String ID = "id";
    
    public static final String TEXT = "text";
    
    public static final String CREATE_AT = "createAt";
    
    public static volatile SingularAttribute<TodoInfoEntity, Integer> process;
    
    public static volatile SingularAttribute<TodoInfoEntity, Timestamp> updateAt;
    
    public static volatile SingularAttribute<TodoInfoEntity, Long> id;
    
    public static volatile SingularAttribute<TodoInfoEntity, String> text;
    
    public static volatile SingularAttribute<TodoInfoEntity, Timestamp> createAt;
}

