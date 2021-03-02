package com.cn.mistletoe.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Team implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 团队名
     */
    private String name;
    /**
     * 团队编号
     */
    private String number;
    /**
     * 队员人数
     */
    private String count;
    /**
     * 队长
     */
    private String captain;
    /**
     * 助理
     */
    private String assistant;
    /**
     * 教练
     */
    private String coach;

    /**
     * 创建时间
     */
    private String createTime;
}
