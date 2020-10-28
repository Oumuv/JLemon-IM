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
 * 朋友申请信息表
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@TableName("friends_apply_info")
public class FriendsApplyInfo extends Model<FriendsApplyInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 被申请用户id
     */
	@TableField("applied_user_id")
	private Long appliedUserId;
    /**
     * 申请用户id
     */
	@TableField("apply_user_id")
	private Long applyUserId;
    /**
     * 申请信息
     */
	@TableField("application_information")
	private String applicationInformation;
    /**
     * 添加状态：0-申请中 1-接受  2-拒绝 3- 忽略
     */
	private Integer operate;
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

	public Long getAppliedUserId() {
		return appliedUserId;
	}

	public void setAppliedUserId(Long appliedUserId) {
		this.appliedUserId = appliedUserId;
	}

	public Long getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getApplicationInformation() {
		return applicationInformation;
	}

	public void setApplicationInformation(String applicationInformation) {
		this.applicationInformation = applicationInformation;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
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
		return "FriendsApplyInfo{" +
			", id=" + id +
			", appliedUserId=" + appliedUserId +
			", applyUserId=" + applyUserId +
			", applicationInformation=" + applicationInformation +
			", operate=" + operate +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			", isDeleted=" + isDeleted +
			"}";
	}
}
