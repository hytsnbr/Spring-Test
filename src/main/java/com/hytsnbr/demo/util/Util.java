package com.hytsnbr.demo.util;

import javax.validation.constraints.NotNull;

public final class Util {

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 数値 桁数取得
     * 
     * @param number 数値
     * @return 桁数
     */
    public static int getDigits(@NotNull Number number) {
        return number.toString().length();
    }
}
