package com.feng.enums;

public enum FormatEnum {

    FORMAT_TEXT(1, "普通文本"),
    FORMAT_HTML(2, "HTML"),
    FORMAT_MARKDOWN(3, "Markdown"),
    FORMAT_JSON(4, "JSON（content参数可参照RichText结构）");



    private final int code;
    private final String info;

    private FormatEnum(int code, String info) {
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

    public static FormatEnum getEnumByKey(Integer code) {
        for (FormatEnum temp : FormatEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (FormatEnum temp : FormatEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
