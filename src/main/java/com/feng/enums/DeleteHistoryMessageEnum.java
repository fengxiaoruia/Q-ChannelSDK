package com.feng.enums;

public enum DeleteHistoryMessageEnum {

    DELETE_ALL(-1, "撤回全部消息"),
    DELETE_3(3, "撤回1天前的消息"),
    DELETE_7(7, "撤回7天前的消息"),
    DELETE_15(15, "撤回15天前的消息"),
    DELETE_30(30, "撤回30天前的消息");



    private final int code;
    private final String info;

    private DeleteHistoryMessageEnum(int code, String info) {
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

    public static DeleteHistoryMessageEnum getEnumByKey(Integer code) {
        for (DeleteHistoryMessageEnum temp : DeleteHistoryMessageEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (DeleteHistoryMessageEnum temp : DeleteHistoryMessageEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
