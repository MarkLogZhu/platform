package com.marklogzhu.platform.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    @NotEmpty(message = "请输入用户名")
    private String userName;

    /**
     * 手机号
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 前端加密后的密码
     */
    @NotEmpty(message = "请输入密码")
    private String password;

    /**
     * 状态，1：正常，0：冻结状态，2：删除
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 操作者
     */
    private String operator;

    /**
     * 最后一次更新时间
     */
    private Date operateTime;

    /**
     * 最后一次更新者的ip地址
     */
    private String operateIp;
}
