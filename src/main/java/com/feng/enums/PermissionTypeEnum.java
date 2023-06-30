package com.feng.enums;

public enum PermissionTypeEnum {

    SPECIAL_USER(0, "指定用户可操作"),
    ONLY_MANAGER(1, "仅管理者可操作"),
    ALL(2, "所有人可操作"),
    SPECIAL_ROLE(3, "指定身份组可操作");


    private final int code;
    private final String info;

    private PermissionTypeEnum(int code, String info) {
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

    public static PermissionTypeEnum getEnumByKey(Integer code) {
        for (PermissionTypeEnum temp : PermissionTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (PermissionTypeEnum temp : PermissionTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
