package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberWithGuildID extends Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "guild_id")
    private String guildId;



}
