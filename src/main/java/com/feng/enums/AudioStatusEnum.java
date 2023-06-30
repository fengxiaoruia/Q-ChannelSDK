package com.feng.enums;

public enum AudioStatusEnum {
    START_PLAY(0, "开始播放操作"),
    PAUSE_PLAY(1, "暂停播放操作"),
    CONTINUE_PLAY(2, "继续播放操作"),

    STOP_PLAY(3, "停止播放操作");



    private final int code;
    private final String info;

    private AudioStatusEnum(int code, String info) {
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

    public static AudioStatusEnum getEnumByKey(Integer code) {
        for (AudioStatusEnum temp : AudioStatusEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (AudioStatusEnum temp : AudioStatusEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
