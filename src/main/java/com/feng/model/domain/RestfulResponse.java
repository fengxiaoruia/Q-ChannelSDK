package com.feng.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestfulResponse<T> implements Serializable {


    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private T data;

    public static RestfulResponse success(Object object) {
        return builder().code(RestFulCodeEnum.SUCCESS.getCode()).msg(RestFulCodeEnum.SUCCESS.getInfo()).data(object).build();
    }

    public static RestfulResponse success() {
        return builder().code(RestFulCodeEnum.SUCCESS.getCode()).msg(RestFulCodeEnum.SUCCESS.getInfo()).data(null).build();
    }

    public static RestfulResponse failure(Object object) {
        return builder().code(RestFulCodeEnum.FAILURE.getCode()).msg(object.toString()).data(object).build();
    }

    public static RestfulResponse failure() {
        return builder().code(RestFulCodeEnum.FAILURE.getCode()).msg(RestFulCodeEnum.FAILURE.getInfo()).data(null).build();
    }

    public static RestfulResponse expire(Object object) {
        return builder().code(RestFulCodeEnum.EXPIRE.getCode()).msg(RestFulCodeEnum.EXPIRE.getInfo()).data(object).build();
    }

    public static RestfulResponse expire() {
        return builder().code(RestFulCodeEnum.EXPIRE.getCode()).msg(RestFulCodeEnum.EXPIRE.getInfo()).data(null).build();
    }
}
