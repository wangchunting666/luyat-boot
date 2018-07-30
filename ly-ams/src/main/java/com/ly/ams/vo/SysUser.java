package com.ly.ams.vo;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 */
@TableName("sys_user")
public class SysUser implements Serializable{

    private static final long serialVersionUID = 1L;
    public static final int _0 = 0;
    public static final int _1 = 1;
    /**
     * 主键
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户状态,1-启用,-1禁用
     */
    private Integer userState;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 描述
     */
    private String userDesc;
    /**
     * 头像
     */
    private String userImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        ", id=" + id +
        ", userName=" + userName +
        ", password=" + password +
        ", userState=" + userState +
        ", createTime=" + createTime +
        ", userDesc=" + userDesc +
        ", userImg=" + userImg +
        "}";
    }
}
