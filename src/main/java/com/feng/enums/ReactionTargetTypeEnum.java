package com.feng.enums;

public enum ReactionTargetTypeEnum {
    MESSAGE(0, "消息"),
    POST_MESSAGE(1, "帖子"),
    COMMENT(2, "评论"),
    REPLAY(3, "回复");



    private final int code;
    private final String info;

    private ReactionTargetTypeEnum(int code, String info) {
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

    public static ReactionTargetTypeEnum getEnumByKey(Integer code) {
        for (ReactionTargetTypeEnum temp : ReactionTargetTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (ReactionTargetTypeEnum temp : ReactionTargetTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
