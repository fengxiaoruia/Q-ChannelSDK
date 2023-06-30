package com.feng.model.domain;

import com.alibaba.fastjson2.annotation.JSONField;
import com.feng.config.FieldDescription;
import com.feng.model.Thread;
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
public class ThreadsModel implements Serializable {

    private static final long serialVersionUID = 1L;


    @JSONField(name = "threads")
    @FieldDescription("帖子列表对象（返回值里面的content字段，可参照RichText结构）")
    private List<Thread> threads;

    @JSONField(name = "is_finish")
    @FieldDescription("是否拉取完毕(0:否；1:是)")
    private int isFinish;

}
