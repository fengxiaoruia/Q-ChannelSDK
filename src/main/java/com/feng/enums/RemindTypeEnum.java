package com.feng.enums;

public enum RemindTypeEnum {

    NO_REMIND(0, "不提醒"),
    START_REMIND(1, "开始时提醒"),

    START_5_REMIND(2, "开始前 5 分钟提醒"),
    START_15_REMIND(3, "开始前 15 分钟提醒"),

    START_30_REMIND(4, "开始前 30 分钟提醒"),
    START_60_REMIND(5, "开始前 60 分钟提醒");



    private final int code;
    private final String info;

    private RemindTypeEnum(int code, String info) {
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

    public static RemindTypeEnum getEnumByKey(Integer code) {
        for (RemindTypeEnum temp : RemindTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (RemindTypeEnum temp : RemindTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
