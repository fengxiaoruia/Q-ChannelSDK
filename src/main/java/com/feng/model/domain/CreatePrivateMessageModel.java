package com.feng.model.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.EmptyValueFilter;
import com.feng.config.FieldDescription;
import com.feng.model.MessageArk;
import com.feng.model.MessageEmbed;
import com.feng.model.MessageMarkdown;
import com.feng.model.MessageReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePrivateMessageModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "recipient_id")
    @FieldDescription("接收者 id")
    private String recipientId;

    @JSONField(name = "source_guild_id")
    @FieldDescription("源频道 id")
    private String sourceGuildId;
}
