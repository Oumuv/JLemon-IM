/*

https://gitee.com/wuweixiang/zhuoan-im/blob/master/im-server/src/main/resources/mybatis/zhuoan_im.sql#
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : zhuoan_im

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-18 00:30:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for friends_apply_info
-- ----------------------------
DROP TABLE IF EXISTS friends_apply_info;
CREATE TABLE friends_apply_info (
                                      id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
                                      applied_user_id bigint(20) NOT NULL COMMENT '被申请用户id',
                                      apply_user_id bigint(20) NOT NULL COMMENT '申请用户id',
                                      application_information varchar(200) DEFAULT NULL COMMENT '申请信息',
                                      operate int(10) DEFAULT '0' COMMENT '添加状态：0-申请中 1-接受  2-拒绝 3- 忽略',
                                      gmt_create datetime DEFAULT NULL COMMENT '创建时间',
                                      gmt_modified timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                      is_deleted tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除：1-删除，0-未删除',
                                      PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='朋友申请信息表';

-- ----------------------------
-- Records of friends_apply_info
-- ----------------------------
INSERT INTO friends_apply_info VALUES ('1', '12', '11', '申请信息', '0', '2018-10-17 18:51:48', '2018-10-17 20:57:18', '0');
INSERT INTO friends_apply_info VALUES ('2', '12', '11', '申请信息', '0', '2018-10-17 20:31:42', '2018-10-17 20:57:18', '0');
INSERT INTO friends_apply_info VALUES ('3', '12', '11', '申请信息', '0', '2018-10-17 20:42:56', '2018-10-17 20:57:18', '0');
INSERT INTO friends_apply_info VALUES ('4', '11', '12', '申请信息', '0', '2018-10-17 21:06:58', '2018-10-17 21:06:58', '0');

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS groups;
CREATE TABLE groups (
                          id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '群聊id',
                          group_name varchar(66) NOT NULL COMMENT '群聊名称',
                          group_avatar varchar(255) DEFAULT NULL COMMENT '群头像',
                          notice varchar(10) DEFAULT NULL COMMENT '群公告',
                          QR_core varchar(10) DEFAULT NULL COMMENT '二维码',
                          online bigint(10) DEFAULT '1' COMMENT '在线人数',
                          gmt_create datetime DEFAULT NULL COMMENT '创建时间',
                          gmt_modified timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          is_deleted tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除：1-删除，0-未删除',
                          PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='群组表';

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO groups VALUES ('11', '我的好友', 'http://images.rednet.cn/articleimage/2013/01/23/1403536948.jpg', null, null, null, '2018-10-15 20:30:52', '2018-10-15 20:30:51', '0');
INSERT INTO groups VALUES ('12', '我的好友', 'http://images.rednet.cn/articleimage/2013/01/23/1403536948.jpg', null, null, '1', '2018-10-15 23:15:36', '2018-10-15 23:15:35', '0');
INSERT INTO groups VALUES ('13', '我的好友', 'http://images.rednet.cn/articleimage/2013/01/23/1403536948.jpg', null, null, '1', '2018-10-16 16:32:40', '2018-10-16 16:32:40', '0');
INSERT INTO groups VALUES ('14', '我的好友', 'http://images.rednet.cn/articleimage/2013/01/23/1403536948.jpg', null, null, '1', '2018-10-17 18:46:13', '2018-10-17 18:46:13', '0');

-- ----------------------------
-- Table structure for group_member
-- ----------------------------
DROP TABLE IF EXISTS group_member;
CREATE TABLE group_member (
                                id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
                                group_id bigint(20) DEFAULT NULL COMMENT '群组id',
                                in_group_user_id bigint(20) NOT NULL COMMENT '对应的用户id',
                                remark varchar(200) DEFAULT NULL COMMENT '对应的备注',
                                gmt_create datetime DEFAULT NULL COMMENT '创建时间',
                                gmt_modified timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                is_deleted tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除：1-删除，0-未删除',
                                PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='组内成员表';

-- ----------------------------
-- Records of group_member
-- ----------------------------
INSERT INTO group_member VALUES ('32', '11', '1', null, null, '2018-10-15 20:57:30', '0');
INSERT INTO group_member VALUES ('33', '11', '34', null, null, '2018-10-15 20:58:55', '0');
INSERT INTO group_member VALUES ('34', '11', '32', null, null, '2018-10-15 20:58:59', '0');
INSERT INTO group_member VALUES ('35', '12', '1', null, null, '2018-10-16 00:27:31', '0');

-- ----------------------------
-- Table structure for group_message
-- ----------------------------
DROP TABLE IF EXISTS group_message;
CREATE TABLE group_message (
                                 id int(11) NOT NULL,
                                 message_sender varchar(255) DEFAULT NULL COMMENT '发送者',
                                 group_id int(11) DEFAULT NULL COMMENT '群组id',
                                 gmt_create datetime DEFAULT NULL COMMENT '创建时间',
                                 gmt_modified timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 message_type varchar(255) DEFAULT NULL COMMENT '消息类型',
                                 message_content varchar(255) DEFAULT NULL COMMENT '消息内容',
                                 PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_message
-- ----------------------------

-- ----------------------------
-- Table structure for private_message
-- ----------------------------
DROP TABLE IF EXISTS private_message;
CREATE TABLE private_message (
                                   id int(11) NOT NULL AUTO_INCREMENT,
                                   message_sender varchar(255) DEFAULT NULL COMMENT '发送者',
                                   message_recipient varchar(255) DEFAULT NULL COMMENT '接收者',
                                   gmt_create datetime DEFAULT NULL COMMENT '创建时间',
                                   gmt_modified timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                   message_type varchar(255) DEFAULT NULL COMMENT '消息类型',
                                   message_content varchar(255) DEFAULT NULL COMMENT '消息内容',
                                   status varchar(255) DEFAULT NULL COMMENT '消息状态 1 在线发送 2 离线消息',
                                   PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of private_message
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS user;
CREATE TABLE user (
                        id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                        username varchar(50) DEFAULT NULL COMMENT '用户名',
                        password varchar(100) DEFAULT NULL COMMENT '密码',
                        nick varchar(50) DEFAULT NULL COMMENT '昵称',
                        salt varchar(50) DEFAULT NULL COMMENT '盐值',
                        block_addr varchar(100) DEFAULT NULL COMMENT '区块地址',
                        referral_code varchar(100) DEFAULT NULL COMMENT '推荐码',
                        avatar varchar(100) DEFAULT NULL COMMENT '用户头像',
                        status int(50) DEFAULT NULL COMMENT '在线状态 1-在线 2-离线',
                        sign varchar(200) DEFAULT NULL COMMENT '个性签名',
                        address varchar(200) DEFAULT NULL COMMENT '地址',
                        sex int(10) DEFAULT NULL COMMENT '性别',
                        email varchar(50) DEFAULT NULL COMMENT '邮箱',
                        date_of_birth datetime DEFAULT NULL COMMENT '出生日期',
                        phone varchar(20) DEFAULT NULL COMMENT '电话',
                        remark varchar(200) DEFAULT NULL COMMENT '备注',
                        gmt_create datetime DEFAULT NULL COMMENT '创建时间',
                        gmt_modified timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        is_deleted tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除：1-删除，0-未删除',
                        PRIMARY KEY (id),
                        UNIQUE KEY index_username (username) USING BTREE COMMENT '保证用户名唯一'
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('2', 'AAAASAD', null, null, null, 'ghfhfjfjfjas', null, null, null, 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-16 16:32:31', '0');
INSERT INTO user VALUES ('3', 'c', null, null, null, 'ghfhfjfjfj1', null, null, null, 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-15 21:26:04', '0');
INSERT INTO user VALUES ('4', 'd', null, null, null, 'ghfhfjfjfj4', null, null, null, 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-15 21:26:04', '0');
INSERT INTO user VALUES ('10', '111', null, null, null, '123', null, null, '0', 'sign', 'address', '0', 'emaill', null, null, null, '2018-08-27 00:00:00', '2018-10-15 21:26:04', '0');
INSERT INTO user VALUES ('11', 'B', '2131231', '123123', '1231231', 'ghfhfjfjfj3', '123123123', '123123123', '0', 'sign', 'address', '0', 'emaill', '2018-10-17 21:26:09', '15102119909', 'remark', '2018-10-17 21:26:21', '2018-10-16 16:30:21', '0');
INSERT INTO user VALUES ('12', '有好友', '123', 'wph777', '123', '2e37b8b3596d476da66d140ea33d1d48', 'RA8K33', 'http://192.168.201.1/null', '0', 'sign', 'address', '0', 'emaill', '2018-10-16 16:29:07', 'phone', 'remark', '2018-08-27 00:00:00', '2018-10-17 20:43:21', '0');
INSERT INTO user VALUES ('22', '1爱的', null, null, null, '111', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-16 16:33:31', '0');
INSERT INTO user VALUES ('23', 'zhangsan', null, null, null, '2', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-17 18:46:11', '0');
INSERT INTO user VALUES ('24', '3', null, null, null, '3', null, null, '2', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-15 21:26:04', '0');
INSERT INTO user VALUES ('25', '4', null, null, null, '4', null, null, '2', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-15 21:26:04', '0');
INSERT INTO user VALUES ('26', '5', null, null, null, '5', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-15 21:26:04', '0');
INSERT INTO user VALUES ('27', '6', null, null, null, '6', null, null, '2', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-15 21:26:04', '0');
INSERT INTO user VALUES ('28', '7', '123', null, null, '7', null, null, null, 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-15 21:26:04', '0');
INSERT INTO user VALUES ('29', '1阿萨德', '123', null, null, '1', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-16 16:33:32', '0');
INSERT INTO user VALUES ('30', '1爱爱', '123', null, null, '1', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-16 16:33:34', '0');
INSERT INTO user VALUES ('31', '2让人', '123', null, null, '2', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-16 16:33:39', '0');
INSERT INTO user VALUES ('32', '李四', '123', null, null, '2', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-17 20:38:10', '0');
INSERT INTO user VALUES ('33', '23', '123', null, null, '2', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-16 16:33:36', '0');
INSERT INTO user VALUES ('34', '王五', '123', null, null, '2', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-17 20:38:18', '0');
INSERT INTO user VALUES ('35', '1啊', '123', null, null, '1', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-16 16:33:35', '0');
INSERT INTO user VALUES ('36', '1', '123', null, null, '1', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-15 21:26:04', '0');
INSERT INTO user VALUES ('37', '1536731462593', '123', null, null, '1536731462593', null, null, '1', 'sign', 'address', '0', 'emaill', null, null, null, null, '2018-10-15 21:26:04', '0');

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS user_group;
CREATE TABLE user_group (
                              id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
                              creator_user_id bigint(20) NOT NULL COMMENT '群组创建人id',
                              group_id bigint(20) NOT NULL COMMENT '群组id',
                              type int(11) DEFAULT NULL COMMENT '0:我的好友,1:普通群组,2:超级群组',
                              gmt_create datetime DEFAULT NULL COMMENT '创建时间',
                              gmt_modified timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              is_deleted tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除：1-删除，0-未删除',
                              PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户和群组关联表';

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO user_group VALUES ('7', '12', '11', '0', '2018-10-15 20:30:56', '2018-10-15 20:30:55', '0');
INSERT INTO user_group VALUES ('8', '1', '12', '0', '2018-10-15 23:15:36', '2018-10-15 23:15:35', '0');
INSERT INTO user_group VALUES ('9', '11', '13', '0', '2018-10-16 16:32:40', '2018-10-16 16:32:40', '0');
INSERT INTO user_group VALUES ('10', '23', '14', '0', '2018-10-17 18:46:13', '2018-10-17 18:46:13', '0');

-- ----------------------------
-- Table structure for user_login_history
-- ----------------------------
DROP TABLE IF EXISTS user_login_history;
CREATE TABLE user_login_history (
                                      id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
                                      user_id bigint(20) NOT NULL COMMENT '用户id',
                                      ip varchar(50) DEFAULT NULL COMMENT 'IP地址',
                                      region varchar(100) DEFAULT NULL COMMENT '地理位置',
                                      gmt_create datetime DEFAULT NULL COMMENT '创建时间',
                                      gmt_modified timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                      is_deleted tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除：1-删除，0-未删除',
                                      PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8 COMMENT='用户登录历史表';

-- ----------------------------
-- Records of user_login_history
-- ----------------------------
INSERT INTO user_login_history VALUES ('5', '12', null, null, '2018-10-15 20:11:55', '2018-10-15 20:11:55', '0');
INSERT INTO user_login_history VALUES ('6', '12', null, null, '2018-10-15 20:16:14', '2018-10-15 20:16:14', '0');
INSERT INTO user_login_history VALUES ('7', '12', null, null, '2018-10-15 21:26:27', '2018-10-15 21:26:26', '0');
INSERT INTO user_login_history VALUES ('8', '12', null, null, '2018-10-15 21:29:12', '2018-10-15 21:29:11', '0');
INSERT INTO user_login_history VALUES ('9', '12', null, null, '2018-10-15 21:32:30', '2018-10-15 21:32:29', '0');
INSERT INTO user_login_history VALUES ('10', '12', null, null, '2018-10-15 21:46:10', '2018-10-15 21:46:10', '0');
INSERT INTO user_login_history VALUES ('11', '12', null, null, '2018-10-15 22:15:12', '2018-10-15 22:15:11', '0');
INSERT INTO user_login_history VALUES ('12', '12', null, null, '2018-10-15 22:18:44', '2018-10-15 22:18:53', '0');
INSERT INTO user_login_history VALUES ('13', '12', null, null, '2018-10-15 22:38:15', '2018-10-15 22:38:14', '0');
INSERT INTO user_login_history VALUES ('14', '12', null, null, '2018-10-15 22:42:19', '2018-10-15 22:42:19', '0');
INSERT INTO user_login_history VALUES ('15', '12', null, null, '2018-10-15 22:46:23', '2018-10-15 22:46:23', '0');
INSERT INTO user_login_history VALUES ('16', '12', null, null, '2018-10-15 22:53:16', '2018-10-15 22:53:15', '0');
INSERT INTO user_login_history VALUES ('17', '12', null, null, '2018-10-15 22:54:09', '2018-10-15 22:54:09', '0');
INSERT INTO user_login_history VALUES ('18', '12', null, null, '2018-10-15 23:03:44', '2018-10-15 23:03:44', '0');
INSERT INTO user_login_history VALUES ('19', '12', null, null, '2018-10-15 23:15:31', '2018-10-15 23:15:30', '0');
INSERT INTO user_login_history VALUES ('20', '1', null, null, '2018-10-15 23:20:30', '2018-10-15 23:20:29', '0');
INSERT INTO user_login_history VALUES ('21', '12', null, null, '2018-10-15 23:20:34', '2018-10-15 23:20:34', '0');
INSERT INTO user_login_history VALUES ('22', '12', null, null, '2018-10-15 23:21:56', '2018-10-15 23:21:56', '0');
INSERT INTO user_login_history VALUES ('23', '1', null, null, '2018-10-15 23:22:01', '2018-10-15 23:22:00', '0');
INSERT INTO user_login_history VALUES ('24', '12', null, null, '2018-10-15 23:28:31', '2018-10-15 23:28:30', '0');
INSERT INTO user_login_history VALUES ('25', '1', null, null, '2018-10-15 23:28:35', '2018-10-15 23:28:34', '0');
INSERT INTO user_login_history VALUES ('26', '1', null, null, '2018-10-15 23:32:57', '2018-10-15 23:32:56', '0');
INSERT INTO user_login_history VALUES ('27', '1', null, null, '2018-10-15 23:33:43', '2018-10-15 23:33:43', '0');
INSERT INTO user_login_history VALUES ('28', '12', null, null, '2018-10-15 23:34:11', '2018-10-15 23:34:10', '0');
INSERT INTO user_login_history VALUES ('29', '1', null, null, '2018-10-15 23:34:14', '2018-10-15 23:34:14', '0');
INSERT INTO user_login_history VALUES ('30', '1', null, null, '2018-10-15 23:47:15', '2018-10-15 23:47:14', '0');
INSERT INTO user_login_history VALUES ('31', '12', null, null, '2018-10-15 23:54:45', '2018-10-15 23:54:45', '0');
INSERT INTO user_login_history VALUES ('32', '1', null, null, '2018-10-15 23:54:50', '2018-10-15 23:54:49', '0');
INSERT INTO user_login_history VALUES ('33', '1', null, null, '2018-10-15 23:58:23', '2018-10-15 23:58:23', '0');
INSERT INTO user_login_history VALUES ('34', '12', null, null, '2018-10-15 23:59:08', '2018-10-15 23:59:08', '0');
INSERT INTO user_login_history VALUES ('35', '1', null, null, '2018-10-16 00:05:03', '2018-10-16 00:05:03', '0');
INSERT INTO user_login_history VALUES ('36', '1', null, null, '2018-10-16 00:05:47', '2018-10-16 00:05:46', '0');
INSERT INTO user_login_history VALUES ('37', '12', null, null, '2018-10-16 00:05:56', '2018-10-16 00:05:55', '0');
INSERT INTO user_login_history VALUES ('38', '12', null, null, '2018-10-16 00:11:17', '2018-10-16 00:11:16', '0');
INSERT INTO user_login_history VALUES ('39', '1', null, null, '2018-10-16 00:13:23', '2018-10-16 00:13:23', '0');
INSERT INTO user_login_history VALUES ('40', '12', null, null, '2018-10-16 00:14:04', '2018-10-16 00:14:04', '0');
INSERT INTO user_login_history VALUES ('41', '12', null, null, '2018-10-16 00:14:37', '2018-10-16 00:14:36', '0');
INSERT INTO user_login_history VALUES ('42', '12', null, null, '2018-10-16 00:17:10', '2018-10-16 00:17:09', '0');
INSERT INTO user_login_history VALUES ('43', '1', null, null, '2018-10-16 00:17:49', '2018-10-16 00:17:48', '0');
INSERT INTO user_login_history VALUES ('44', '1', null, null, '2018-10-16 00:22:24', '2018-10-16 00:22:24', '0');
INSERT INTO user_login_history VALUES ('45', '12', null, null, '2018-10-16 00:24:58', '2018-10-16 00:24:57', '0');
INSERT INTO user_login_history VALUES ('46', '1', null, null, '2018-10-16 00:25:22', '2018-10-16 00:25:22', '0');
INSERT INTO user_login_history VALUES ('47', '1', null, null, '2018-10-16 00:27:45', '2018-10-16 00:27:45', '0');
INSERT INTO user_login_history VALUES ('48', '12', null, null, '2018-10-16 00:28:10', '2018-10-16 00:28:10', '0');
INSERT INTO user_login_history VALUES ('49', '1', null, null, '2018-10-16 00:28:15', '2018-10-16 00:28:15', '0');
INSERT INTO user_login_history VALUES ('50', '1', null, null, '2018-10-16 00:28:32', '2018-10-16 00:28:31', '0');
INSERT INTO user_login_history VALUES ('51', '12', null, null, '2018-10-16 00:28:54', '2018-10-16 00:28:54', '0');
INSERT INTO user_login_history VALUES ('52', '12', null, null, '2018-10-16 00:29:34', '2018-10-16 00:29:33', '0');
INSERT INTO user_login_history VALUES ('53', '1', null, null, '2018-10-16 00:29:44', '2018-10-16 00:29:43', '0');
INSERT INTO user_login_history VALUES ('54', '12', null, null, '2018-10-16 10:03:16', '2018-10-16 10:03:15', '0');
INSERT INTO user_login_history VALUES ('55', '12', null, null, '2018-10-16 10:18:05', '2018-10-16 10:18:05', '0');
INSERT INTO user_login_history VALUES ('56', '12', null, null, '2018-10-16 10:18:41', '2018-10-16 10:18:40', '0');
INSERT INTO user_login_history VALUES ('57', '1', null, null, '2018-10-16 10:19:11', '2018-10-16 10:19:11', '0');
INSERT INTO user_login_history VALUES ('58', '1', null, null, '2018-10-16 10:20:50', '2018-10-16 10:20:50', '0');
INSERT INTO user_login_history VALUES ('59', '12', null, null, '2018-10-16 10:20:54', '2018-10-16 10:20:53', '0');
INSERT INTO user_login_history VALUES ('60', '12', null, null, '2018-10-16 10:23:34', '2018-10-16 10:23:34', '0');
INSERT INTO user_login_history VALUES ('61', '12', null, null, '2018-10-16 10:35:32', '2018-10-16 10:35:31', '0');
INSERT INTO user_login_history VALUES ('62', '1', null, null, '2018-10-16 10:35:35', '2018-10-16 10:35:35', '0');
INSERT INTO user_login_history VALUES ('63', '12', null, null, '2018-10-16 10:40:44', '2018-10-16 10:40:44', '0');
INSERT INTO user_login_history VALUES ('64', '12', null, null, '2018-10-16 10:49:07', '2018-10-16 10:49:07', '0');
INSERT INTO user_login_history VALUES ('65', '12', null, null, '2018-10-16 10:50:46', '2018-10-16 10:50:46', '0');
INSERT INTO user_login_history VALUES ('66', '1', null, null, '2018-10-16 10:50:54', '2018-10-16 10:50:54', '0');
INSERT INTO user_login_history VALUES ('67', '12', null, null, '2018-10-16 10:50:59', '2018-10-16 10:50:59', '0');
INSERT INTO user_login_history VALUES ('68', '12', null, null, '2018-10-16 13:50:17', '2018-10-16 13:50:17', '0');
INSERT INTO user_login_history VALUES ('69', '12', null, null, '2018-10-16 13:52:07', '2018-10-16 13:52:06', '0');
INSERT INTO user_login_history VALUES ('70', '12', null, null, '2018-10-16 14:14:27', '2018-10-16 14:14:26', '0');
INSERT INTO user_login_history VALUES ('71', '12', null, null, '2018-10-16 14:16:26', '2018-10-16 14:16:25', '0');
INSERT INTO user_login_history VALUES ('72', '1', null, null, '2018-10-16 14:17:02', '2018-10-16 14:17:02', '0');
INSERT INTO user_login_history VALUES ('73', '1', null, null, '2018-10-16 14:22:50', '2018-10-16 14:22:50', '0');
INSERT INTO user_login_history VALUES ('74', '12', null, null, '2018-10-16 14:23:05', '2018-10-16 14:23:04', '0');
INSERT INTO user_login_history VALUES ('75', '12', null, null, '2018-10-16 14:36:53', '2018-10-16 14:36:53', '0');
INSERT INTO user_login_history VALUES ('76', '1', null, null, '2018-10-16 14:38:12', '2018-10-16 14:38:11', '0');
INSERT INTO user_login_history VALUES ('77', '1', null, null, '2018-10-16 14:38:55', '2018-10-16 14:38:54', '0');
INSERT INTO user_login_history VALUES ('78', '1', null, null, '2018-10-16 14:39:24', '2018-10-16 14:39:24', '0');
INSERT INTO user_login_history VALUES ('79', '12', null, null, '2018-10-16 14:39:37', '2018-10-16 14:39:36', '0');
INSERT INTO user_login_history VALUES ('80', '12', null, null, '2018-10-16 14:54:49', '2018-10-16 14:54:48', '0');
INSERT INTO user_login_history VALUES ('81', '12', null, null, '2018-10-16 14:57:08', '2018-10-16 14:57:08', '0');
INSERT INTO user_login_history VALUES ('82', '1', null, null, '2018-10-16 14:57:16', '2018-10-16 14:57:16', '0');
INSERT INTO user_login_history VALUES ('83', '1', null, null, '2018-10-16 14:58:29', '2018-10-16 14:58:28', '0');
INSERT INTO user_login_history VALUES ('84', '12', null, null, '2018-10-16 14:58:52', '2018-10-16 14:58:52', '0');
INSERT INTO user_login_history VALUES ('85', '12', null, null, '2018-10-16 15:00:46', '2018-10-16 15:00:45', '0');
INSERT INTO user_login_history VALUES ('86', '1', null, null, '2018-10-16 15:00:56', '2018-10-16 15:00:55', '0');
INSERT INTO user_login_history VALUES ('87', '12', null, null, '2018-10-16 15:01:38', '2018-10-16 15:01:38', '0');
INSERT INTO user_login_history VALUES ('88', '1', null, null, '2018-10-16 15:02:51', '2018-10-16 15:02:50', '0');
INSERT INTO user_login_history VALUES ('89', '1', null, null, '2018-10-16 15:44:38', '2018-10-16 15:44:37', '0');
INSERT INTO user_login_history VALUES ('90', '1', null, null, '2018-10-16 15:48:45', '2018-10-16 15:48:44', '0');
INSERT INTO user_login_history VALUES ('91', '12', null, null, '2018-10-16 15:59:08', '2018-10-16 15:59:08', '0');
INSERT INTO user_login_history VALUES ('92', '1', null, null, '2018-10-16 15:59:37', '2018-10-16 15:59:36', '0');
INSERT INTO user_login_history VALUES ('93', '12', null, null, '2018-10-16 15:59:58', '2018-10-16 15:59:58', '0');
INSERT INTO user_login_history VALUES ('94', '1', null, null, '2018-10-16 16:01:21', '2018-10-16 16:01:20', '0');
INSERT INTO user_login_history VALUES ('95', '12', null, null, '2018-10-16 16:02:02', '2018-10-16 16:02:01', '0');
INSERT INTO user_login_history VALUES ('96', '12', null, null, '2018-10-16 16:05:58', '2018-10-16 16:05:57', '0');
INSERT INTO user_login_history VALUES ('97', '12', null, null, '2018-10-16 16:06:18', '2018-10-16 16:06:17', '0');
INSERT INTO user_login_history VALUES ('98', '12', null, null, '2018-10-16 16:07:16', '2018-10-16 16:07:16', '0');
INSERT INTO user_login_history VALUES ('99', '1', null, null, '2018-10-16 16:07:32', '2018-10-16 16:07:32', '0');
INSERT INTO user_login_history VALUES ('100', '1', null, null, '2018-10-16 16:12:35', '2018-10-16 16:12:35', '0');
INSERT INTO user_login_history VALUES ('101', '12', null, null, '2018-10-16 16:12:38', '2018-10-16 16:12:38', '0');
INSERT INTO user_login_history VALUES ('102', '12', null, null, '2018-10-16 16:15:12', '2018-10-16 16:15:12', '0');
INSERT INTO user_login_history VALUES ('103', '1', null, null, '2018-10-16 16:15:25', '2018-10-16 16:15:24', '0');
INSERT INTO user_login_history VALUES ('104', '1', null, null, '2018-10-16 16:15:47', '2018-10-16 16:15:46', '0');
INSERT INTO user_login_history VALUES ('105', '12', null, null, '2018-10-16 16:16:21', '2018-10-16 16:16:21', '0');
INSERT INTO user_login_history VALUES ('106', '1', null, null, '2018-10-16 16:16:32', '2018-10-16 16:16:31', '0');
INSERT INTO user_login_history VALUES ('107', '12', null, null, '2018-10-16 16:27:25', '2018-10-16 16:27:25', '0');
INSERT INTO user_login_history VALUES ('108', '11', null, null, '2018-10-16 16:32:40', '2018-10-16 16:32:40', '0');
INSERT INTO user_login_history VALUES ('109', '11', null, null, '2018-10-16 16:35:50', '2018-10-16 16:35:49', '0');
INSERT INTO user_login_history VALUES ('110', '12', null, null, '2018-10-16 16:36:13', '2018-10-16 16:36:13', '0');
INSERT INTO user_login_history VALUES ('111', '12', null, null, '2018-10-16 16:39:33', '2018-10-16 16:39:33', '0');
INSERT INTO user_login_history VALUES ('112', '11', null, null, '2018-10-16 16:39:43', '2018-10-16 16:39:43', '0');
INSERT INTO user_login_history VALUES ('113', '11', null, null, '2018-10-16 16:43:10', '2018-10-16 16:43:09', '0');
INSERT INTO user_login_history VALUES ('114', '12', null, null, '2018-10-16 16:43:15', '2018-10-16 16:43:14', '0');
INSERT INTO user_login_history VALUES ('115', '11', null, null, '2018-10-16 17:00:47', '2018-10-16 17:00:46', '0');
INSERT INTO user_login_history VALUES ('116', '12', null, null, '2018-10-16 17:00:49', '2018-10-16 17:00:49', '0');
INSERT INTO user_login_history VALUES ('117', '12', null, null, '2018-10-16 17:32:14', '2018-10-16 17:32:13', '0');
INSERT INTO user_login_history VALUES ('118', '11', null, null, '2018-10-16 17:32:30', '2018-10-16 17:32:30', '0');
INSERT INTO user_login_history VALUES ('119', '11', '120.37.152.64', '福建省泉州市', '2018-10-17 14:55:13', '2018-10-17 14:55:17', '0');
INSERT INTO user_login_history VALUES ('120', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 14:58:56', '2018-10-17 14:58:56', '0');
INSERT INTO user_login_history VALUES ('121', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 16:39:13', '2018-10-17 16:39:14', '0');
INSERT INTO user_login_history VALUES ('122', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 17:26:36', '2018-10-17 17:26:37', '0');
INSERT INTO user_login_history VALUES ('123', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 17:26:49', '2018-10-17 17:26:49', '0');
INSERT INTO user_login_history VALUES ('124', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 18:21:12', '2018-10-17 18:21:12', '0');
INSERT INTO user_login_history VALUES ('125', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 18:46:13', '2018-10-17 18:46:14', '0');
INSERT INTO user_login_history VALUES ('126', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 18:46:18', '2018-10-17 18:46:18', '0');
INSERT INTO user_login_history VALUES ('127', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 18:47:32', '2018-10-17 18:47:33', '0');
INSERT INTO user_login_history VALUES ('128', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 18:51:40', '2018-10-17 18:51:40', '0');
INSERT INTO user_login_history VALUES ('129', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 18:52:56', '2018-10-17 18:52:55', '0');
INSERT INTO user_login_history VALUES ('130', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 18:58:56', '2018-10-17 18:58:56', '0');
INSERT INTO user_login_history VALUES ('131', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 20:31:15', '2018-10-17 20:31:16', '0');
INSERT INTO user_login_history VALUES ('132', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 20:31:26', '2018-10-17 20:31:25', '0');
INSERT INTO user_login_history VALUES ('133', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 20:32:57', '2018-10-17 20:32:57', '0');
INSERT INTO user_login_history VALUES ('134', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 20:34:39', '2018-10-17 20:34:39', '0');
INSERT INTO user_login_history VALUES ('135', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 20:41:45', '2018-10-17 20:41:45', '0');
INSERT INTO user_login_history VALUES ('136', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 20:44:22', '2018-10-17 20:44:23', '0');
INSERT INTO user_login_history VALUES ('137', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 20:45:35', '2018-10-17 20:45:35', '0');
INSERT INTO user_login_history VALUES ('138', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 20:55:46', '2018-10-17 20:55:45', '0');
INSERT INTO user_login_history VALUES ('139', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 20:57:28', '2018-10-17 20:57:28', '0');
INSERT INTO user_login_history VALUES ('140', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 21:02:48', '2018-10-17 21:02:47', '0');
INSERT INTO user_login_history VALUES ('141', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 21:02:52', '2018-10-17 21:02:51', '0');
INSERT INTO user_login_history VALUES ('142', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 21:04:03', '2018-10-17 21:04:03', '0');
INSERT INTO user_login_history VALUES ('143', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 21:04:57', '2018-10-17 21:04:57', '0');
INSERT INTO user_login_history VALUES ('144', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 21:05:41', '2018-10-17 21:05:41', '0');
INSERT INTO user_login_history VALUES ('145', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 21:05:44', '2018-10-17 21:05:44', '0');
INSERT INTO user_login_history VALUES ('146', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 21:05:53', '2018-10-17 21:05:55', '0');
INSERT INTO user_login_history VALUES ('147', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 21:06:37', '2018-10-17 21:06:37', '0');
INSERT INTO user_login_history VALUES ('148', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 21:08:38', '2018-10-17 21:08:38', '0');
INSERT INTO user_login_history VALUES ('149', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 21:09:21', '2018-10-17 21:09:20', '0');
INSERT INTO user_login_history VALUES ('150', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 21:10:26', '2018-10-17 21:10:26', '0');
INSERT INTO user_login_history VALUES ('151', '23', '120.37.152.64', '福建省泉州市', '2018-10-17 21:11:59', '2018-10-17 21:11:59', '0');
INSERT INTO user_login_history VALUES ('152', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 21:12:05', '2018-10-17 21:12:05', '0');
INSERT INTO user_login_history VALUES ('153', '12', '120.37.152.64', '福建省泉州市', '2018-10-17 22:07:04', '2018-10-17 22:14:37', '0');
