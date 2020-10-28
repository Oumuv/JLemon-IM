package com.jim.server.project.entity;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 群组表
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
public class Groups extends Model<Groups> {

    private static final long serialVersionUID = 1L;

    /**
     * 群聊id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 群聊名称
     */
	@TableField("group_name")
	private String groupName;
    /**
     * 群头像
     */
	@TableField("group_avatar")
	private String groupAvatar;
    /**
     * 群公告
     */
	private String notice;
    /**
     * 二维码
     */
	@TableField("QR_core")
	private String QRCore;
    /**
     * 在线人数
     */
	private Long online;
    /**
     * 创建时间
     */
	@TableField("gmt_create")
	private Date gmtCreate;
    /**
     * 更新时间
     */
	@TableField("gmt_modified")
	private Date gmtModified;
    /**
     * 是否逻辑删除：1-删除，0-未删除
     */
	@TableField("is_deleted")
	private Integer isDeleted;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupAvatar() {
		return groupAvatar;
	}

	public void setGroupAvatar(String groupAvatar) {
		this.groupAvatar = groupAvatar;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getQRCore() {
		return QRCore;
	}

	public void setQRCore(String QRCore) {
		this.QRCore = QRCore;
	}

	public Long getOnline() {
		return online;
	}

	public void setOnline(Long online) {
		this.online = online;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Groups{" +
			", id=" + id +
			", groupName=" + groupName +
			", groupAvatar=" + groupAvatar +
			", notice=" + notice +
			", QRCore=" + QRCore +
			", online=" + online +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			", isDeleted=" + isDeleted +
			"}";
	}
}
