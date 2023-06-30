package com.feng.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.feng.model.*;
import com.feng.model.domain.*;
import com.feng.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Slf4j
@Configuration
public class ChannelBotClient {
    public static String BOT_OPEN_KEY;
    public static String BOT_API;
    public static String BOT_WS_URL;


    @Value("${bot.botAppId}")
    private String botAppId;

    @Value("${bot.botSecret}")
    private String botSecret;

    @Value("${bot.botToken}")
    private String botToken;

    @Value("${bot.botType}")
    private int botType;


    @Bean
    public ChannelBotInfo botClient(){
        ChannelBotInfo build = new ChannelBotInfo().builder()
                .botAppId(botAppId)
                .botSecret(botSecret)
                .botToken(botToken)
                .botType(botType)
                .build();
        this.BOT_OPEN_KEY = build.getAuthorization();
        this.BOT_API = build.getUrl();
        this.getWsUrl();
        return build;
    }

    public String getWsUrl(){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/gateway");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        JSONObject parse = JSONObject.parseObject(result);
        try {
            String url = parse.get("url").toString();
            log.info(url);
            this.BOT_WS_URL = url;
            log.info("Bot信息初始化完成");
            return url;
        }catch (Exception e){
            log.error("Bot信息配置错误");
            e.printStackTrace();
            return null;
        }
    }

    public ShardWsInfo getShardWsUrl(){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/gateway/bot");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        ShardWsInfo shardWsInfo = JSONObject.parseObject(result,ShardWsInfo.class);
        this.BOT_WS_URL = shardWsInfo.getUrl();
        return shardWsInfo;
    }
    /*
        获取用户详情
     */
    public User getUserInfo(){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/users/@me");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        User user = JSONObject.parseObject(result, User.class);
        log.info(user.toString());
        return user;
    }

    /*
        获取用户频道列表
    */
    public List<Guild> getUserJoinGuild(){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/users/@me/guilds");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        List<Guild> guildList = JSON.parseArray(result, Guild.class);
        log.info(guildList.toString());
        return guildList;
    }

     /*
        获取频道详情
      */
    public Guild getGuildInfo(String guildId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/guilds/" + guildId);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Guild guild = JSON.parseObject(result, Guild.class);
        log.info(guild.toString());
        return guild;
    }
    /*
        获取子频道列表
     */
    public List<Channel> getChannelList(String guildId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/guilds/" + guildId + "/channels");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        List<Channel> channels = JSON.parseArray(result, Channel.class);
        log.info(channels.toString());
        return channels;
    }

    /*
        获取子频道详情
     */
    public Channel getChannelInfo(String channelId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Channel channel = JSON.parseObject(result, Channel.class);
        log.info(channel.toString());
        return channel;
    }

    /*
        创建子频道
     */
    public Channel createChannel(AddChannelModel addChannelModel){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/guilds/" + addChannelModel.getGuildId() + "/channels", JSON.toJSONString(addChannelModel));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Channel channel = JSON.parseObject(result, Channel.class);
        log.info(channel.toString());
        return channel;
    }

    /*
        修改子频道信息
     */
    public Channel updateChannel(AddChannelModel addChannelModel){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/channels/" + addChannelModel.getId(),JSON.toJSONString(addChannelModel));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Channel channel = JSON.parseObject(result, Channel.class);
        log.info(channel.toString());
        return channel;
    }

    /*
        删除子频道
     */
    public boolean deleteChannel(String channelId){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/channels/" + channelId);
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 200){
            return true;
        }
        return false;
    }

    /*
        获取子频道在线人数
     */
    public int getChannelOnlineNums(String channelId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/online_nums");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        JSONObject parse = JSONObject.parseObject(result);
        Object o = parse.get("online_nums");
        return Integer.parseInt(o.toString());
    }


    /*
        获取频道下用户信息, after为上一次最后一位成员的id， limit为多少条， 首次after为0
     */
    public List<Member> getGuildMembers(String guildId,String after, Integer limit){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/guilds/" + guildId + "/members"+ "?after=" + after + "&limit=" + limit);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        List<Member> members = JSON.parseArray(result, Member.class);
        log.info(members.toString());
        return members;
    }

    /*
        获取频道下指定身份组用户信息, startIndex 将上一次回包中next填入， 如果是第一次请求填 0，默认为 0， limit为多少条
     */
    public RolesMemberModel getGuildRolesMembers(String guildId, String roleId, String startIndex, Integer limit){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/guilds/" + guildId + "/roles/" + roleId + "/members" + "?start_index=" + startIndex + "&limit=" + limit);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        RolesMemberModel rolesMemberModel = JSONObject.parseObject(result, RolesMemberModel.class);
        log.info(rolesMemberModel.toString());
        return rolesMemberModel;
    }
    /*
        查询指定频道下指定用户信息
     */
    public Member getGuildMemberInfo(String guildId,String userId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/guilds/" + guildId + "/members"+ "/" + userId);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Member member = JSONObject.parseObject(result, Member.class);
        log.info(member.toString());
        return member;
    }

    /*
        删除频道下指定用户 isBlack是否拉黑， deleteHistoryMessage为是否删除对应用户发出的消息
     */
    public boolean deleteGuildMember(String guildId, String userId, boolean isBlack, int deleteHistoryMessage){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/guilds/" + guildId + "/members"+ "/" + userId + "?add_blacklist=" + isBlack + "&delete_history_msg_days=" + deleteHistoryMessage);
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        获取频道下身分组列表
     */
    public List<RoleModel> getGuildRoleInfo(String guildId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/guilds/" + guildId);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        List<RoleModel> roleModels = JSON.parseArray(result, RoleModel.class);
        log.info(roleModels.toString());
        return roleModels;
    }

    /*
        创建频道身分组
        name	string	名称(非必填)
        color	uint32	ARGB 的 HEX 十六进制颜色值转换后的十进制数值(非必填)
        hoist	int32	在成员列表中单独展示: 0-否, 1-是(非必填
     */
    public AddRoleResultModel createGuildRole(String guildId, AddRoleModel addRoleModel){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/guilds/" + guildId + "/roles", JSONObject.toJSONString(addRoleModel));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        AddRoleResultModel addRoleResultModel = JSONObject.parseObject(result, AddRoleResultModel.class);
        log.info(addRoleResultModel.toString());
        return addRoleResultModel;
    }

    /*
      修改频道身分组
   */
    public UpdateRoleResultModel updateGuildRole(String guildId, String roleId, AddRoleModel addRoleModel){
        HttpResponse httpResponse = HttpUtil.patch(BOT_API + "/guilds/" + guildId + "/roles" + "/" + roleId, JSONObject.toJSONString(addRoleModel));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        UpdateRoleResultModel updateRoleResultModel = JSONObject.parseObject(result, UpdateRoleResultModel.class);
        log.info(updateRoleResultModel.toString());
        return updateRoleResultModel;
    }
    /*
         删除频道身分组
      */
    public boolean deleteGuildRole(String guildId, String roleId){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/guilds/" + guildId + "/roles"+ "/" + roleId);
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        用于将频道guild_id下的用户 user_id 添加到身份组 role_id
     */
    public boolean createGuildRoleMember(String guildId, String roleId, String userId, String channelId){
        JSONObject addModel = new JSONObject();
        addModel.put("id",channelId);

        HttpResponse httpResponse = HttpUtil.put(BOT_API + "/guilds/" + guildId + "/members"+ "/" + userId + "/roles" + roleId, addModel.toJSONString());
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        用于将 用户 user_id 从 频道 guild_id 的 role_id 身份组中移除
     */
    public boolean deleteGuildRoleMember(String guildId, String roleId, String userId, String channelId){
        JSONObject deleteModel = new JSONObject();
        deleteModel.put("id",channelId);
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/guilds/" + guildId + "/members"+ "/" + userId + "/roles" + roleId, deleteModel.toJSONString());
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }
    /*
           用于获取 子频道channel_id 下用户 user_id 的权限
     */
    public ChannelPermissions getChannelUserPermissions(String channelId, String userId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/members/" + userId + "/permissions");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        ChannelPermissions channelPermissions = JSONObject.parseObject(result, ChannelPermissions.class);
        log.info(channelPermissions.toString());
        return channelPermissions;
    }


    /*
       修改子频道channel_id 下用户 user_id 的权限
    */
    public boolean updateChannelUserPermissions(String channelId, String userId, UpdateChannelPermissionsModel updateChannelPermissionsModel){
        HttpResponse httpResponse = HttpUtil.put(BOT_API + "/channels/" + channelId + "/members/" + userId + "/permissions",JSONObject.toJSONString(updateChannelPermissionsModel));
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        获取子频道身分组权限
     */
    public ChannelPermissions getChannelRolePermissions(String channelId, String roleId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/roles/" + roleId + "/permissions");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        ChannelPermissions channelPermissions = JSONObject.parseObject(result, ChannelPermissions.class);
        log.info(channelPermissions.toString());
        return channelPermissions;
    }

    /*
          修改子频道身分组权限
       */
    public boolean updateChannelRolePermissions(String channelId, String roleId, UpdateChannelPermissionsModel updateChannelPermissionsModel){
        HttpResponse httpResponse = HttpUtil.put(BOT_API + "/channels/" + channelId + "/roles/" + roleId + "/permissions", JSONObject.toJSONString(updateChannelPermissionsModel));
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        用于获取子频道 channel_id 下的消息 message_id 的详情
     */
    public Message getChannelMessage(String channelId, String messageId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/messages/" + messageId);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Message message = JSONObject.parseObject(result, Message.class);
        log.info(message.toString());
        return message;
    }

    /*
      向子频道 channel_id 下发送消息
   */
    public Message sendChannelMessage(String channelId, SendMessage sendMessage){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/channels/" + channelId + "/messages", JSONObject.toJSONString(sendMessage));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Message message = JSONObject.parseObject(result, Message.class);
        log.info(result);
        return message;
    }

    /*
        撤回子频道消息
     */
    public boolean rollBackChannelMessage(String channelId, String messageId){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/channels/" + channelId + "/messages" + "/" + messageId + "?hidetip=false");
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        获取频道消息频率设置
     */
    public MessageSetting getMessageSetting(String guildId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/guilds/" + guildId + "/message/setting");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        MessageSetting messageSetting = JSONObject.parseObject(result, MessageSetting.class);
        return messageSetting;
    }

    /*
        创建私信会话
     */
    public DMS createPrivateMessage(CreatePrivateMessageModel createPrivateMessageModel){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/users/@me/dms", JSONObject.toJSONString(createPrivateMessageModel));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        DMS dms = JSONObject.parseObject(result, DMS.class);
        return dms;
    }

    /*
        发送私聊消息
     */
    public Message sendPrivateMessage(String guildId, SendMessage sendMessage){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/dms" + "/" +  guildId + "/messages", JSONObject.toJSONString(sendMessage));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Message message = JSONObject.parseObject(result, Message.class);
        return message;
    }

    /*
        撤回私信消息
     */
    public boolean rollBackPrivateMessage(String guildId, String messageId){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/dms/" + guildId + "/messages" + "/" + messageId + "?hidetip=false");
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        禁言 or 解除
     */
    public boolean prohibitionGuild(String guildId, ProhibitionModel prohibitionModel){
        HttpResponse httpResponse = HttpUtil.patch(BOT_API + "/guilds/" + guildId + "/mute",JSONObject.toJSONString(prohibitionModel));
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
       禁言 or 解除 指定成员
    */
    public boolean prohibitionGuildMember(String guildId, String userId, ProhibitionModel prohibitionModel){
        HttpResponse httpResponse = HttpUtil.patch(BOT_API + "/guilds/" + guildId + "members/" + userId + "/mute",JSONObject.toJSONString(prohibitionModel));
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }


    /*
       禁言 or 解除 批量
    */
    public boolean prohibitionGuildMembers(String guildId, ProhibitionModel prohibitionModel){
        HttpResponse httpResponse = HttpUtil.patch(BOT_API + "/guilds/" + guildId + "/mute",JSONObject.toJSONString(prohibitionModel));
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 200){
            return true;
        }
        return false;
    }


    /*
        创建频道公告
     */
    public Announces createAnnounce(String guildId, Announces announces){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/guilds/" + guildId + "/announces", JSONObject.toJSONString(announces));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Announces announcesResult = JSONObject.parseObject(result, Announces.class);
        return announcesResult;
    }

    /*
        删除频道公告
        用于删除频道 guild_id 下指定 message_id 的全局公告。
        message_id 有值时，会校验 message_id 合法性，若不校验校验 message_id，请将 message_id 设置为 all。
     */
    public boolean deleteAnnounce(String guildId, String messageId){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/guilds/" + guildId + "/announces" + "/" + messageId);
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        创建精华消息
     */
    public PinsMessage createPinsMessage(String channelId, String messageId){
        HttpResponse httpResponse = HttpUtil.put(BOT_API + "/channels/" + channelId + "/pins" + "/" + messageId);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        PinsMessage pinsMessage = JSONObject.parseObject(result, PinsMessage.class);
        return pinsMessage;
    }

    /*
        删除精华消息
     */
    public boolean deletePinsMessage(String channelId, String messageId){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/channels/" + channelId + "/pins" + "/" + messageId);
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        获取精华消息
     */
    public PinsMessage getPinsMessage(String channelId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/pins");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        PinsMessage pinsMessage = JSONObject.parseObject(result, PinsMessage.class);
        return pinsMessage;
    }

    /*
        获取频道日程列表
     */
    public List<Schedule> getSchedule(String channelId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/schedules");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        List<Schedule> schedules = JSON.parseArray(result, Schedule.class);
        return schedules;
    }

    /*
          获取频道当日日程列表
          若带了参数 since，则返回在 since 对应当天的日程列表；若未带参数 since，则默认返回今天的日程列表
          uint64	起始时间戳(ms)
       */
    public List<Schedule> getScheduleSince(String channelId, String since){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/schedules?since=" + since);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        List<Schedule> schedules = JSON.parseArray(result, Schedule.class);
        return schedules;
    }

    /*
        获取日程详情
     */
    public Schedule getScheduleInfo(String channelId, String scheduleId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/schedules/" + scheduleId);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Schedule schedule = JSONObject.parseObject(result, Schedule.class);
        return schedule;
    }

    /*
        创建日程
     */
    public Schedule createSchedule(String channelId, Schedule addSchedule){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/channels/" + channelId + "/schedules", JSONObject.toJSONString(addSchedule));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Schedule schedule = JSONObject.parseObject(result, Schedule.class);
        return schedule;
    }

    /*
        修改日程
     */
    public Schedule updateSchedule(String channelId, Schedule updateSchedule){
        HttpResponse httpResponse = HttpUtil.patch(BOT_API + "/channels/" + channelId + "/schedules/" + updateSchedule.getId(), JSONObject.toJSONString(updateSchedule));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        Schedule schedule = JSONObject.parseObject(result, Schedule.class);
        return schedule;
    }

    /*
        删除日程
     */
    public boolean deleteSchedule(String channelId, String scheduleId){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/channels/" + channelId + "/schedules/" + scheduleId);
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }


    /*
        发表表情表态
     */
    public boolean publishEmojiReaction(MessageReaction messageReaction){
        HttpResponse httpResponse = HttpUtil.put(BOT_API + "/channels/" + messageReaction.getChannelId() + "/messages/" + messageReaction.getMessageId() + "/reactions/" + messageReaction.getEmoji().getType() + "/" + messageReaction.getEmoji().getId());
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }


    /*
        删除表情表态
     */
    public boolean deleteEmojiReaction(MessageReaction messageReaction){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/channels/" + messageReaction.getChannelId() + "/messages/" + messageReaction.getMessageId() + "/reactions/" + messageReaction.getEmoji().getType() + "/" + messageReaction.getEmoji().getId());
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        拉取表情表态用户列表
     */
    public EmojiUserModel getEmojiReactionUser(MessageReaction messageReaction, EmojiUserModel emojiUserModel){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + messageReaction.getChannelId() + "/messages/" + messageReaction.getMessageId()
                + "/reactions/" + messageReaction.getEmoji().getType() + "/" + messageReaction.getEmoji().getId() + "?cookie="
                + emojiUserModel.getCookie() + "&limit=" + emojiUserModel.getLimit());
        String result = HttpUtil.getHttpResponseString(httpResponse);
        EmojiUserModel emojiUserModelResult = JSONObject.parseObject(result, EmojiUserModel.class);
        return emojiUserModelResult;
    }

    /*
        控制音频
     */
    public JSONObject controlAudio(String channelId, AudioControl audioControl){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/channels/" + channelId + "/audio", JSONObject.toJSONString(audioControl));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        JSONObject parse = JSONObject.parse(result);
        return parse;
    }
    /*
        机器人上麦
     */
    public JSONObject BotAudioPerformances(String channelId){
        HttpResponse httpResponse = HttpUtil.put(BOT_API + "/channels/" + channelId + "/mic");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        JSONObject parse = JSONObject.parse(result);
        return parse;
    }

    /*
        机器人下麦
     */
    public JSONObject BotAudioPerformancesEnd(String channelId){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/channels/" + channelId + "/mic");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        JSONObject parse = JSONObject.parse(result);
        return parse;
    }

    /*
        该接口用于获取子频道下的帖子列表。
     */
    public List<ThreadsModel> getThreads(String channelId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/threads");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        List<ThreadsModel> threadsModels = JSON.parseArray(result, ThreadsModel.class);
        return threadsModels;
    }

    /*
        获取帖子详情
     */
    public ThreadInfo getThreadInfo(String channelId, String threadId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/channels/" + channelId + "/threads" + "/" + threadId);
        String result = HttpUtil.getHttpResponseString(httpResponse);
        ThreadInfo threadInfo = JSONObject.parseObject(result, ThreadInfo.class);
        return threadInfo;
    }


    /*
        发布帖子
     */
    public AddThreadResultModel publishThread(String channelId, AddThreadInfoModel addThreadInfoModel){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/channels/" + channelId + "/threads", JSONObject.toJSONString(addThreadInfoModel));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        AddThreadResultModel addThreadResultModel = JSONObject.parseObject(result, AddThreadResultModel.class);
        return addThreadResultModel;
    }

    /*
        删除帖子
     */
    public boolean deleteThread(String channelId, String threadId){
        HttpResponse httpResponse = HttpUtil.delete(BOT_API + "/channels/" + channelId + "/threads" + "/" + threadId);
        int statusCode = 0;
        if (httpResponse != null) {
            statusCode = httpResponse.getStatusLine().getStatusCode();
        }
        if(statusCode == 204){
            return true;
        }
        return false;
    }

    /*
        用于获取机器人在频道 guild_id 内可以使用的权限列表。
     */
    public List<APIPermission> getGuildApiPermission(String guildId){
        HttpResponse httpResponse = HttpUtil.get(BOT_API + "/guilds/" + guildId + "/api_permission");
        String result = HttpUtil.getHttpResponseString(httpResponse);
        List<APIPermission> apiPermissions = JSON.parseArray(result,APIPermission.class);
        return apiPermissions;
    }

    /*
        用于创建 API 接口权限授权链接，该链接指向guild_id对应的频道 。

        需要注意，私信场景中，当需要查询私信来源频道的权限时，应使用src_guild_id，即 message中的src_guild_id

        每天只能在一个频道内发 3 条（默认值）频道权限授权链接
     */
    public APIPermissionDemand createGuildApiPermission(String guildId, APIPermissionDemand addaApiPermissionDemand){
        HttpResponse httpResponse = HttpUtil.post(BOT_API + "/guilds/" + guildId + "/api_permission/demand",JSONObject.toJSONString(addaApiPermissionDemand));
        String result = HttpUtil.getHttpResponseString(httpResponse);
        APIPermissionDemand apiPermissionDemand = JSONObject.parseObject(result,APIPermissionDemand.class);
        return apiPermissionDemand;
    }
}
