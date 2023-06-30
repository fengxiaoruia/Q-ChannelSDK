package com.feng.enums;

public enum AlignmentEnum {

    LEFT(0, "左对齐"),
    MIDDLE(1, "居中"),
    RIGHT(2, "右对齐");


    private final int code;
    private final String info;

    private AlignmentEnum(int code, String info) {
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

    public static AlignmentEnum getEnumByKey(Integer code) {
        for (AlignmentEnum temp : AlignmentEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (AlignmentEnum temp : AlignmentEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
