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
 * 用户和群组关联表
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@TableName("user_group")
public class UserGroup extends Model<UserGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 群组创建人id
     */
	@TableField("creator_user_id")
	private Long creatorUserId;
    /**
     * 群组id
     */
	@TableField("group_id")
	private Long groupId;
    /**
     * 0:我的好友,1:普通群组,2:超级群组
     */
	private Integer type;
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

	public Long getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Long creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
		return "UserGroup{" +
			", id=" + id +
			", creatorUserId=" + creatorUserId +
			", groupId=" + groupId +
			", type=" + type +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			", isDeleted=" + isDeleted +
			"}";
	}
}
