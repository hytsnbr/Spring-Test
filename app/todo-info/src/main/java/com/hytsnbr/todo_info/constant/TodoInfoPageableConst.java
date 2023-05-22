package com.hytsnbr.todo_info.constant;

import com.hytsnbr.todo_info.entity.TodoInfoEntity;

public final class TodoInfoPageableConst {
    
    /** 1ページごとの件数 */
    public static final int SIZE_DEFAULT = 20;
    
    /** 1ページごとの最大件数 */
    public static final int SIZE_MAX = 100;
    
    /** ソート対象 */
    public static final String SORT_DEFAULT = TodoInfoEntity.COLUMN_NAME_CREATE_AT;
    
    /** 検索での最大表示件数 */
    public static final int SEARCH_CAN_DISPLAY_COUNT = 1000;
    
    private TodoInfoPageableConst() {
        throw new IllegalStateException("Utility class");
    }
}
