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
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "guild_id")
    private String guildId;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "type")
    private int type;

    @JSONField(name = "sub_type")
    private int subType;

    @JSONField(name = "position")
    private int position;

    @JSONField(name = "parent_id")
    private String parentId;

    @JSONField(name = "owner_id")
    private String ownerId;

    @JSONField(name = "private_type")
    private int privateType;

    @JSONField(name = "speak_permission")
    private int speakPermission;

    @JSONField(name = "application_id")
    private String applicationId;

    @JSONField(name = "permissions")
    private String permissions;

}
