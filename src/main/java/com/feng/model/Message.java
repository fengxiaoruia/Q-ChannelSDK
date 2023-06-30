package com.feng.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.FieldDescription;
import com.feng.constant.BotConsts;
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
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "id")
    @FieldDescription("消息 id")
    private String id;

    @JSONField(name = "channel_id")
    @FieldDescription("子频道 id")
    private String channelId;

    @JSONField(name = "guild_id")
    @FieldDescription("频道 id")
    private String guildId;

    @JSONField(name = "content")
    @FieldDescription("消息内容")
    private String content;

    @JSONField(name = "timestamp")
    @FieldDescription("消息创建时间")
    private String timestamp;

    @JSONField(name = "edited_timestamp")
    @FieldDescription("消息编辑时间")
    private String editedTimestamp;

    @JSONField(name = "mention_everyone")
    @FieldDescription("是否是@全员消息")
    private boolean mentionEveryone;

    @JSONField(name = "author")
    @FieldDescription("消息创建者")
    private User author;

    @JSONField(name = "attachments")
    @FieldDescription("附件")
    private List<MessageAttachment> attachments;

    @JSONField(name = "embeds")
    @FieldDescription("嵌入内容")
    private List<MessageEmbed> embeds;

    @JSONField(name = "mentions")
    @FieldDescription("消息中@的人")
    private List<User> mentions;

    @JSONField(name = "member")
    @FieldDescription("消息创建者的member信息")
    private Member member;

    @JSONField(name = "ark")
    @FieldDescription("ark消息")
    private MessageArk ark;

    @JSONField(name = "seq")
    @FieldDescription("用于消息间的排序")
    private int seq;

    @JSONField(name = "seq_in_channel")
    @FieldDescription("子频道消息 seq")
    private String seqInChannel;

    @JSONField(name = "message_reference")
    @FieldDescription("引用消息对象")
    private MessageReference messageReference;

    @JSONField(name = "src_guild_id")
    @FieldDescription("用于私信场景下识别真实的来源频道id")
    private String srcGuildId;
}
