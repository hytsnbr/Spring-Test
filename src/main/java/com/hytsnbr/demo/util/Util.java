package com.hytsnbr.demo.util;

public final class Util {

    /**
     * 数値 桁数取得
     *
     * @param number 数値
     *
     * @return 桁数
     */
    public static int getDigits(Number number) {
        return number.toString().length();
    }
}
