package com.feng.enums;

public enum ActionTypeEnum {

    HTTP(0, "http 或 小程序 客户端识别 schem, data字段为链接"),
    ASYN(1, "回调后台接口, data 传给后台"),
    AT(2, "at机器人, 根据 at_bot_show_channel_list 决定在当前频道或用户选择频道,自动在输入框 @bot data");


    private final int code;
    private final String info;

    private ActionTypeEnum(int code, String info) {
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

    public static ActionTypeEnum getEnumByKey(Integer code) {
        for (ActionTypeEnum temp : ActionTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (ActionTypeEnum temp : ActionTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
