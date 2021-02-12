package com.cn.mistletoe.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author xingyu
 * @since 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;
    /**
     * 角色
     */
    private String role;
    /**
     * sex
     */
    private String sex;
    /**
     * phone
     */
    private String phone;
    /**
     * address
     */
    private String address;

    /**
     * 最后修改时间
     */
    private String editTime;
    /**
     * /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注信息
     */
    private String contend;

    /**
     * 注册时间
     */
    private String createTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;

    /**
     * 验证码(生成Model用)
     */
    private String captcha;

    /**
     * 权限列表(接收getAuthorities()用)
     */
    private List<? extends GrantedAuthority> authorities;


}
