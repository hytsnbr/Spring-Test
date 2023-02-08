package com.hytsnbr.spring_test.app.todo.constant;

import com.hytsnbr.spring_test.app.todo.entity.TodoInfoEntity_;

public final class TodoInfoPageableConst {
    
    /** 1ページごとの件数 */
    public static final int SIZE_DEFAULT = 20;
    
    /** 1ページごとの最大件数 */
    public static final int SIZE_MAX = 100;
    
    /** ソート対象 */
    public static final String SORT_DEFAULT = TodoInfoEntity_.CREATE_AT;
    
    /** 検索での最大表示件数 */
    public static final int SEARCH_CAN_DISPLAY_COUNT = 1000;
}
