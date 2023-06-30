package com.feng.enums;

public enum CodeEnum {
    UNKNOWN_ACCOUNT(10001, "账号异常"),
    UNKNOWN_CHANNEL(10003, "子频道异常"),
    UNKNOWN_GUILD(10004, "频道异常");



    private final int code;
    private final String info;

    private CodeEnum(int code, String info) {
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

    public static CodeEnum getEnumByKey(Integer code) {
        for (CodeEnum temp : CodeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (CodeEnum temp : CodeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
