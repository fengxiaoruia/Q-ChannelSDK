package com.feng.enums;

public enum RenderStyleEnum {

    GREY(0, "灰色线框"),
    BLUE(1, "蓝色线框");


    private final int code;
    private final String info;

    private RenderStyleEnum(int code, String info) {
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

    public static RenderStyleEnum getEnumByKey(Integer code) {
        for (RenderStyleEnum temp : RenderStyleEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (RenderStyleEnum temp : RenderStyleEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
