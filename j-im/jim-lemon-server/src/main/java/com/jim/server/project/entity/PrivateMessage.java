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
 * 
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@TableName("private_message")
public class PrivateMessage extends Model<PrivateMessage> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 发送者
     */
	@TableField("message_sender")
	private String messageSender;
    /**
     * 接收者
     */
	@TableField("message_recipient")
	private String messageRecipient;
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
    /**
     * 消息状态 1 在线发送 2 离线消息
     */
	private String status;


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

	public String getMessageRecipient() {
		return messageRecipient;
	}

	public void setMessageRecipient(String messageRecipient) {
		this.messageRecipient = messageRecipient;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PrivateMessage{" +
			", id=" + id +
			", messageSender=" + messageSender +
			", messageRecipient=" + messageRecipient +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			", messageType=" + messageType +
			", messageContent=" + messageContent +
			", status=" + status +
			"}";
	}
}
