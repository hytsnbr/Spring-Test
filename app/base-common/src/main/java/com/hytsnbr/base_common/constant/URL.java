package com.hytsnbr.base_common.constant;

public final class URL {
    
    /**
     * Todo List
     */
    public static final String URL_TODO_INDEX = "/todo";
    
    public static final String URL_TODO_NEW = "/todo/new";
    
    public static final String URL_TODO_NEW_CONFIRM = "/todo/new/confirm";
    
    public static final String URL_TODO_EDIT = "/todo/edit";
    
    public static final String URL_TODO_EDIT_CONFIRM = "/todo/edit/confirm";
    
    public static final String URL_TODO_DETAIL = "/todo/detail";
    
    public static final String URL_TODO_LIST = "/todo/list";
    
    public static final String URL_TODO_SEARCH = "/todo/search";
    
    private URL() {
        throw new IllegalStateException("Utility class");
    }
}
