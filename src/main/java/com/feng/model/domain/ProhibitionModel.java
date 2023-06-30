package com.feng.model.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.FieldDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProhibitionModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "mute_end_timestamp")
    @FieldDescription("禁言到期时间戳，绝对时间戳，单位：秒（与 mute_seconds 字段同时赋值的话，以该字段为准） 解除传 0")
    private String muteEndTimestamp;

    @JSONField(name = "mute_seconds")
    @FieldDescription("禁言多少秒（两个字段二选一，默认以 mute_end_timestamp 为准）解除传 0")
    private String muteSeconds;


    @JSONField(name = "user_ids")
    @FieldDescription("禁言成员的user_id列表，即User的id")
    private List<String> userIds;
}
