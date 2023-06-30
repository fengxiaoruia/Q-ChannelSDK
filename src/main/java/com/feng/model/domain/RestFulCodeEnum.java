package com.feng.model.domain;

/**
 * @ClassName : CodeEnum
 * @Description : CodeEnum
 * @Author : 疯小瑞
 * @Date: 2022-12-15 11:34
 */

public enum RestFulCodeEnum {

    /**
     * 操作失败
     */
    FAILURE(1, "操作失败"),

    EXPIRE(401, "暂无权限"),
    /**
     * 操作成功
     */
    SUCCESS(0, "操作成功");

    private final int code;
    private final String info;

    RestFulCodeEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }


    public int getCode() {
        return code;
    }


    public String getInfo() {
        return info;
    }


    public String getCodeToString() {
        return String.valueOf(code);
    }


    public static RestFulCodeEnum getEnumByKey(Integer code) {
        for (RestFulCodeEnum temp : RestFulCodeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }


    public static String getEnumInfoByKey(Integer code) {
        for (RestFulCodeEnum temp : RestFulCodeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}