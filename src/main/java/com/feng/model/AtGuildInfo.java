package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.FieldDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtGuildInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "guild_id")
    @FieldDescription("频道ID")
    private String guildId;

    @JSONField(name = "guild_name")
    @FieldDescription("频道名称")
    private String guildName;
}
