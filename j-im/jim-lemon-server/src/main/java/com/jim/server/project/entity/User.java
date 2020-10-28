package com.jim.server.project.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 昵称
     */
	private String nick;
    /**
     * 盐值
     */
	private String salt;
    /**
     * 区块地址
     */
	@TableField("block_addr")
	private String blockAddr;
    /**
     * 推荐码
     */
	@TableField("referral_code")
	private String referralCode;
    /**
     * 用户头像
     */
	private String avatar;
    /**
     * 在线状态 1-在线 2-离线
     */
	private Integer status;
    /**
     * 个性签名
     */
	private String sign;
    /**
     * 地址
     */
	private String address;
    /**
     * 性别
     */
	private Integer sex;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 出生日期
     */
	@TableField("date_of_birth")
	private Date dateOfBirth;
    /**
     * 电话
     */
	private String phone;
    /**
     * 备注
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getBlockAddr() {
		return blockAddr;
	}

	public void setBlockAddr(String blockAddr) {
		this.blockAddr = blockAddr;
	}

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		return "User{" +
			", id=" + id +
			", username=" + username +
			", password=" + password +
			", nick=" + nick +
			", salt=" + salt +
			", blockAddr=" + blockAddr +
			", referralCode=" + referralCode +
			", avatar=" + avatar +
			", status=" + status +
			", sign=" + sign +
			", address=" + address +
			", sex=" + sex +
			", email=" + email +
			", dateOfBirth=" + dateOfBirth +
			", phone=" + phone +
			", remark=" + remark +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			", isDeleted=" + isDeleted +
			"}";
	}
}
