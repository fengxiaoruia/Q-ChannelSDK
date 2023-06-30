package com.feng.model.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.FieldDescription;
import com.feng.model.Emoji;
import com.feng.model.ReactionTarget;
import com.feng.model.User;
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
public class EmojiUserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "users")
    @FieldDescription("用户对象")
    private List<User> users;

    @JSONField(name = "cookie")
    @FieldDescription("分页参数，用于拉取下一页")
    private String cookie;

    @JSONField(name = "limit")
    @FieldDescription("分页参数，用于每一次拉去多少个")
    private int limit;

    @JSONField(name = "is_end")
    @FieldDescription("是否已拉取完成到最后一页，true代表完成")
    private boolean isEnd;
}
