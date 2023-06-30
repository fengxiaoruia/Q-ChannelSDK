package com.feng.enums;

public enum EmbeddedFormatEnum {
    USER(0, "<@user_id>"),  //需替换user_id
    ALL(1, "@everyone"),
    CHANNEL(2, "<#channel_id>"), //需替换 channel_id
    EMOJI(3 , "<emoji:id>"); //需替换 id



    private final int code;
    private final String info;

    private EmbeddedFormatEnum(int code, String info) {
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

    public static EmbeddedFormatEnum getEnumByKey(Integer code) {
        for (EmbeddedFormatEnum temp : EmbeddedFormatEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (EmbeddedFormatEnum temp : EmbeddedFormatEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
