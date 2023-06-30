package com.feng.enums;

public enum HttpCodeEnum {
    SUCCESS(200, "成功"),
    SUCCESS_NO_BODY(204, "成功，但是无包体，一般用于删除操作"),
    ASYN_SUCCTESS_201(201, "异步操作成功，虽然说成功，但是会返回一个 error body，需要特殊处理"),
    ASYN_SUCCTESS_202(202, "异步操作成功，虽然说成功，但是会返回一个 error body，需要特殊处理"),
    UNAUTHORIZED(401, "认证失败"),
    NO_API(404,"未找到 API"),
    METHOD_NOT_ALLOW(405,""),
    LIMIT(429,"频率限制"),
    ERROR_500(500,"处理失败"),
    ERROR_504(504,"处理失败");


    private final int code;
    private final String info;

    private HttpCodeEnum(int code, String info) {
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

    public static HttpCodeEnum getEnumByKey(Integer code) {
        for (HttpCodeEnum temp : HttpCodeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (HttpCodeEnum temp : HttpCodeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}
