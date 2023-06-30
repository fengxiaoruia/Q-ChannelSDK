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
public class SessionStartLimit implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "total")
    @FieldDescription("每 24 小时可创建 Session 数")
    private int total;

    @JSONField(name = "remaining")
    @FieldDescription("目前还可以创建的 Session 数")
    private int remaining;

    @JSONField(name = "reset_after")
    @FieldDescription("重置计数的剩余时间(ms)")
    private int resetAfter;

    @JSONField(name = "max_concurrency")
    @FieldDescription("每 5s 可以创建的 Session 数")
    private int maxConcurrency;

}
