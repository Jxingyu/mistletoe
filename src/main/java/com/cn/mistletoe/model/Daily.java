package com.cn.mistletoe.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
public class Daily implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String username;

    private String dailyTitle;

    private String coach;

    private String assistant;

    private String dailyContent;

    private String harvest;

    private String shortage;

    private String submitDate;

    /**
     * 状态0-草稿  1-已提交  2-已查看
     */
    private String status;

}
