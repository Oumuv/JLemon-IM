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
 * 组内成员表
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@TableName("group_member")
public class GroupMember extends Model<GroupMember> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 群组id
     */
	@TableField("group_id")
	private Long groupId;
    /**
     * 对应的用户id
     */
	@TableField("in_group_user_id")
	private Long inGroupUserId;
    /**
     * 对应的备注
     */
	private String remark;
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

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getInGroupUserId() {
		return inGroupUserId;
	}

	public void setInGroupUserId(Long inGroupUserId) {
		this.inGroupUserId = inGroupUserId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		return "GroupMember{" +
			", id=" + id +
			", groupId=" + groupId +
			", inGroupUserId=" + inGroupUserId +
			", remark=" + remark +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			", isDeleted=" + isDeleted +
			"}";
	}
}
