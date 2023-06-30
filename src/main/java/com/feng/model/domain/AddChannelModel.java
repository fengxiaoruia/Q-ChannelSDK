package com.feng.model.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.model.Channel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddChannelModel extends Channel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "private_user_ids")
    private String[] privateUserIds;

    private String guildId;

}
