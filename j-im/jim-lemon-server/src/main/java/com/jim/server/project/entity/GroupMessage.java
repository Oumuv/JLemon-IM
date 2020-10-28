package com.jim.server.project.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@TableName("group_message")
public class GroupMessage extends Model<GroupMessage> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 发送者
     */
	@TableField("message_sender")
	private String messageSender;
    /**
     * 群组id
     */
	@TableField("group_id")
	private Integer groupId;
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
     * 消息类型
     */
	@TableField("message_type")
	private String messageType;
    /**
     * 消息内容
     */
	@TableField("message_content")
	private String messageContent;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "GroupMessage{" +
			", id=" + id +
			", messageSender=" + messageSender +
			", groupId=" + groupId +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			", messageType=" + messageType +
			", messageContent=" + messageContent +
			"}";
	}
}
