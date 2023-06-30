package com.feng.enums;

public enum DefaultRoleIDEnum {

    ALL(1, "全体成员"),
    MANAGER(2, "管理员"),
    ADMIN(4, "群主/创建者"),
    CHANNEL_MANAGER(5, "子频道管理员");



    private final int code;
    private final String info;

    private DefaultRoleIDEnum(int code, String info) {
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

    public static DefaultRoleIDEnum getEnumByKey(Integer code) {
        for (DefaultRoleIDEnum temp : DefaultRoleIDEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (DefaultRoleIDEnum temp : DefaultRoleIDEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
