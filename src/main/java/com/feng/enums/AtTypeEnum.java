package com.feng.enums;

public enum AtTypeEnum {

    SPECIAL_USER(1, "at特定人"),
    GROUP_ALL(2, "at角色组所有人"),
    ALL(3, "at频道所有人");


    private final int code;
    private final String info;

    private AtTypeEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }

    public String getCodeToString() {
        return String.valueOf(this.code);
    }

    public static AtTypeEnum getEnumByKey(Integer code) {
        for (AtTypeEnum temp : AtTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (AtTypeEnum temp : AtTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
