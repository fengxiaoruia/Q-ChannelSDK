package com.feng.enums;

public enum EmojiTypeEnum {
    SYSTEM(1, "系统表情"),  //需替换user_id
    EMOJI(2, "emoji表情");



    private final int code;
    private final String info;

    private EmojiTypeEnum(int code, String info) {
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

    public static EmojiTypeEnum getEnumByKey(Integer code) {
        for (EmojiTypeEnum temp : EmojiTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (EmojiTypeEnum temp : EmojiTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
