package com.hytsnbr.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Processing {
    
    NOTYETSTARTED(1, "未着手"), // 未着手
    PROCESSING(2, "作業中"), // 作業中
    COMPLETE(3, "完了"); // 完了
    
    private final int value;
    
    private final String name;
}
