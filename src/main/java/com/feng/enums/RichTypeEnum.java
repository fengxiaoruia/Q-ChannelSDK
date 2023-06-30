package com.feng.enums;

public enum RichTypeEnum {

    TEXT(1, "普通文本"),
    AT(2, "at信息"),
    URL(3, "url信息"),
    EMOJI(4, "表情"),
    CHANNEL(5, "#子频道"),
    VIDEO(10, "视频"),
    IMAGE(11, "图片");


    private final int code;
    private final String info;

    private RichTypeEnum(int code, String info) {
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

    public static RichTypeEnum getEnumByKey(Integer code) {
        for (RichTypeEnum temp : RichTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (RichTypeEnum temp : RichTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
