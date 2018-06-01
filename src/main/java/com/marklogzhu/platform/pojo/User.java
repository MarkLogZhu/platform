package com.marklogzhu.platform.pojo;

import java.util.Date;

public class User {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
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
     * 加密后的密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

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

    /**
     *
     * @mbggenerated
     */
    public User(Integer userId, String userName, String telephone, String mail, String password, String salt, Integer status, String remark, String operator, Date operateTime, String operateIp) {
        this.userId = userId;
        this.userName = userName;
        this.telephone = telephone;
        this.mail = mail;
        this.password = password;
        this.salt = salt;
        this.status = status;
        this.remark = remark;
        this.operator = operator;
        this.operateTime = operateTime;
        this.operateIp = operateIp;
    }

    /**
     *
     * @mbggenerated
     */
    public User() {
        super();
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户名称
     * @return user_name 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名称
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 手机号
     * @return telephone 手机号
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 手机号
     * @param telephone 手机号
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 邮箱
     * @return mail 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 邮箱
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * 加密后的密码
     * @return password 加密后的密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 加密后的密码
     * @param password 加密后的密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 盐
     * @return salt 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 状态，1：正常，0：冻结状态，2：删除
     * @return status 状态，1：正常，0：冻结状态，2：删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态，1：正常，0：冻结状态，2：删除
     * @param status 状态，1：正常，0：冻结状态，2：删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 操作者
     * @return operator 操作者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 操作者
     * @param operator 操作者
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 最后一次更新时间
     * @return operate_time 最后一次更新时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 最后一次更新时间
     * @param operateTime 最后一次更新时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 最后一次更新者的ip地址
     * @return operate_ip 最后一次更新者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 最后一次更新者的ip地址
     * @param operateIp 最后一次更新者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }
}