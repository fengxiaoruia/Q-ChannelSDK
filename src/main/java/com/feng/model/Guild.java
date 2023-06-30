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
public class Guild implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "icon")
    private String icon;

    @JSONField(name = "owner_id")
    private String ownerId;

    @JSONField(name = "owner")
    private boolean owner;

    @JSONField(name = "member_count")
    private int memberCount;

    @JSONField(name = "max_members")
    private int maxMembers;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "joined_at")
    private String joinedAt;

}
