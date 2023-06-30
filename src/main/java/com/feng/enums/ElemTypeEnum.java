package com.feng.enums;

public enum ElemTypeEnum {

    ELEM_TYPE_TEXT(1, "文本"),
    ELEM_TYPE_IMAGE(2, "图片"),
    ELEM_TYPE_VIDEO(3, "视频"),

    ELEM_TYPE_URL(4, "URL");


    private final int code;
    private final String info;

    private ElemTypeEnum(int code, String info) {
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

    public static ElemTypeEnum getEnumByKey(Integer code) {
        for (ElemTypeEnum temp : ElemTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (ElemTypeEnum temp : ElemTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
