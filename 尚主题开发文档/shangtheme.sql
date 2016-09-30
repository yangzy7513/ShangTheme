/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : shangtheme

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-09-30 20:07:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `administrator`
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `m_id` int(10) NOT NULL AUTO_INCREMENT,
  `m_user_name` varchar(255) NOT NULL,
  `m_password` varchar(255) NOT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('8', 'cc', 'c81e728d9d4c2f636f067f89cc14862c');
INSERT INTO `administrator` VALUES ('9', 'yangzy', '7907a846f09f9ea9f97336f994b175f6');

-- ----------------------------
-- Table structure for `assets`
-- ----------------------------
DROP TABLE IF EXISTS `assets`;
CREATE TABLE `assets` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资产表自由id',
  `s_id` int(11) NOT NULL,
  `t_id` int(11) DEFAULT NULL,
  `a_buydate` varchar(255) NOT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assets
-- ----------------------------
INSERT INTO `assets` VALUES ('501', '76', '3001', '2016/9/11');

-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_enname` varchar(255) NOT NULL,
  `b_brandname` varchar(255) NOT NULL,
  `b_registetime` date NOT NULL,
  `b_company` varchar(255) NOT NULL,
  `b_briefintroduce` varchar(255) NOT NULL,
  `b_logo` varchar(255) DEFAULT NULL COMMENT '品牌信息表',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES ('1001', 'xiaomi', '小米', '2010-04-01', '北京小米科技有限责任公司 ', '北京小米科技有限责任公司成立2010年4月，是一家专注于智能硬件和电子产品研发的移动互联网公司。“为发烧而生”是小米的产品概念。小米公司首创了用互联网模式开发手机操作系统、发烧友参与开发改进的模式。', null);
INSERT INTO `brand` VALUES ('1002', 'meizu', '魅族', '2003-03-01', '魅族科技有限公司', '魅族科技，是智能手机厂商魅族科技有限公司的简称，成立于2003年3月，是一家国内外知名智能手机厂商，总部位于中国广东省珠海市。公司致力于向消费者提供国际一流性能和品质的电子产品，并立足于中高端市场。', null);

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) NOT NULL,
  `t_id` int(11) NOT NULL,
  `c_createtime` varchar(255) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4046 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('4041', '76', '3003', '2016/09/22 08:42:22');
INSERT INTO `collection` VALUES ('4042', '76', '3002', '2016/09/24 10:01:35');
INSERT INTO `collection` VALUES ('4043', '76', '3004', '2016/09/25 09:11:41');
INSERT INTO `collection` VALUES ('4044', '76', '4', '2016/09/26 10:21:51');
INSERT INTO `collection` VALUES ('4045', '76', '5', '2016/09/27 08:04:58');

-- ----------------------------
-- Table structure for `msg`
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg` (
  `msg_id` int(10) NOT NULL AUTO_INCREMENT,
  `sendname` varchar(255) NOT NULL,
  `s_id` int(10) NOT NULL,
  `msgtitle` varchar(255) NOT NULL,
  `msgcontent` varchar(255) NOT NULL,
  `totime` varchar(255) NOT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2016091114 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg
-- ----------------------------
INSERT INTO `msg` VALUES ('20160911', 'admin', '67', '站内信', '您好', '2016/9/15 08:12:13');
INSERT INTO `msg` VALUES ('20160915', 'admin', '0', 'heh', '呵呵', '2016/8/7 12:00:23');
INSERT INTO `msg` VALUES ('20160916', 'admin', '0', '站内信', '卧槽', '2016/9/10 13:22:56');
INSERT INTO `msg` VALUES ('20160917', 'admin', '0', '中秋祝福', '尚主题祝所有员工中秋快乐，阖家欢乐', '2016/9/15 16:17:00');
INSERT INTO `msg` VALUES ('20161950', 'admin', '76', '欢迎来到尚主题', '尊敬的会员：尚主题成立于2016年7月，现有多达2名成员，我们秉承为您提供最优质的手机主题的原则，尊重每一位用户。网站现在处于试运期间，多数主题未能上架，后续会跟进，感谢您的关注！  --ShangTheme ', '2016/7/6 12:18:00');
INSERT INTO `msg` VALUES ('2016091113', 'admin', '76', '【反馈】', '我们已经收到您的建议，感谢您对尚主题的支持！', '2016/9/15 23:57:22');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) DEFAULT NULL,
  `t_id` int(11) DEFAULT NULL,
  `o_createtime` varchar(255) NOT NULL,
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20015 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('20007', '76', '3002', '2016/09/11 14:26:28');
INSERT INTO `order` VALUES ('20012', '76', '3003', '2016/09/22 21:55:57');
INSERT INTO `order` VALUES ('20013', '76', '3004', '2016/09/24 22:04:40');
INSERT INTO `order` VALUES ('20014', '76', '5', '2016/09/27 20:32:32');

-- ----------------------------
-- Table structure for `status`
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `code` int(11) NOT NULL DEFAULT '0',
  `msg` varchar(100) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('0', '成功', '0');
INSERT INTO `status` VALUES ('1', '6', '0');
INSERT INTO `status` VALUES ('301', '用户名占用', '0');
INSERT INTO `status` VALUES ('302', '手机号已注册', '0');
INSERT INTO `status` VALUES ('303', '用户不存在', '0');
INSERT INTO `status` VALUES ('304', '密码错误', '0');
INSERT INTO `status` VALUES ('305', '文件上传失败', '0');
INSERT INTO `status` VALUES ('306', '服务器发生异常，稍后再试', '0');
INSERT INTO `status` VALUES ('307', '验证失败，请重新获取验证码。', '0');
INSERT INTO `status` VALUES ('308', '该手机号尚未注册', '0');
INSERT INTO `status` VALUES ('309', '删除操作失败', '0');
INSERT INTO `status` VALUES ('310', '您已收藏该主题', '0');
INSERT INTO `status` VALUES ('311', '非VIP不能购买此商品', '0');
INSERT INTO `status` VALUES ('312', '此商品已在您的购物车', '0');
INSERT INTO `status` VALUES ('313', '您有新的消息,点击查收', '0');
INSERT INTO `status` VALUES ('501', '服务繁忙，稍后重试', '0');
INSERT INTO `status` VALUES ('502', '您选择的主题已经处于上架状态', '0');
INSERT INTO `status` VALUES ('503', '您选择的主题已经处于下架状态', '0');

-- ----------------------------
-- Table structure for `suser`
-- ----------------------------
DROP TABLE IF EXISTS `suser`;
CREATE TABLE `suser` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_username` varchar(100) NOT NULL,
  `s_password` varchar(50) NOT NULL,
  `s_headphoto` varchar(50) DEFAULT NULL,
  `s_sex` varchar(50) DEFAULT NULL,
  `s_birthday` varchar(50) DEFAULT NULL,
  `s_checkvip` int(11) DEFAULT NULL,
  `s_phonenum` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of suser
-- ----------------------------
INSERT INTO `suser` VALUES ('76', 'yangzy', 'ecf016650411fdbd090dfe0890afd986', 'database/head/yangzy.png', '男', '19931215', '0', 'MTM4KioqKjQ3NDE=');
INSERT INTO `suser` VALUES ('79', 'cc', 'c81e728d9d4c2f636f067f89cc14862c', 'database/head/cc', '男', '19930613', '0', 'MTgzNDY2NjE0NTI=');

-- ----------------------------
-- Table structure for `theme`
-- ----------------------------
DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_themename` varchar(255) NOT NULL,
  `t_author` varchar(255) DEFAULT NULL,
  `t_category` varchar(255) NOT NULL,
  `b_id` int(11) NOT NULL,
  `t_firmware` varchar(255) NOT NULL,
  `t_registerdate` varchar(255) DEFAULT NULL,
  `t_downloadnum` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `t_price` double NOT NULL,
  `t_discount` double DEFAULT NULL,
  `t_picpath` varchar(255) DEFAULT NULL,
  `t_status` int(11) NOT NULL,
  `t_vip` int(11) NOT NULL,
  `t_downloadpath` varchar(255) DEFAULT NULL,
  `t_abstract` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of theme
-- ----------------------------
INSERT INTO `theme` VALUES ('5', '小6', '66', 'MI', '1001', 'MI', '2016/09/27 19:52:23', '00000000000', '6', '0', 'database/theme/picture/6/f3ccdd27d2000e3f9255a7e3e2c48800.jpg&database/theme/picture/6/09dd8c2662b96ce14928333f055c5580.png&database/theme/picture/6/10fb15c77258a991b0028080a64fb42d.png&database/theme/picture/6/8266e4bfeda1bd42d8f9794eb4ea0a13.png', '0', '0', 'database/theme/themePackage/6/9312ea9fa5a6c137ba21a75a9d251103.zip', '我就是这么6');

-- ----------------------------
-- Table structure for `umsg`
-- ----------------------------
DROP TABLE IF EXISTS `umsg`;
CREATE TABLE `umsg` (
  `umsg_id` int(10) NOT NULL AUTO_INCREMENT,
  `msg_id` int(10) NOT NULL,
  `s_id` int(10) NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY (`umsg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=789044 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of umsg
-- ----------------------------
INSERT INTO `umsg` VALUES ('1', '20160916', '67', '0');
INSERT INTO `umsg` VALUES ('789035', '20161950', '76', '2');
INSERT INTO `umsg` VALUES ('789036', '20160916', '76', '1');
INSERT INTO `umsg` VALUES ('789037', '20160915', '76', '1');
INSERT INTO `umsg` VALUES ('789038', '20160917', '76', '1');
INSERT INTO `umsg` VALUES ('789040', '2016091113', '76', '1');
INSERT INTO `umsg` VALUES ('789041', '20160917', '79', '1');
INSERT INTO `umsg` VALUES ('789042', '20160916', '79', '1');
INSERT INTO `umsg` VALUES ('789043', '20160915', '79', '1');

-- ----------------------------
-- Procedure structure for `getmsg`
-- ----------------------------
DROP PROCEDURE IF EXISTS `getmsg`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getmsg`()
BEGIN
	DECLARE Done int DEFAULT 0;
	DECLARE msgid int(10);
	DECLARE sid int(10);

	DECLARE cur CURSOR FOR 
	SELECT 	m.msg_id,m.s_id
		FROM 	msg m
		LEFT   	JOIN umsg u
	        ON  m.msg_id = u.msg_id
         WHERE  u.msg_id is NULL
	AND    m.s_id IN (67,0);
	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET Done = TRUE;

	OPEN cur;
	
	REPEAT
		FETCH next FROM cur INTO msgid,sid;
		IF Done THEN 
			SELECT 1 FROM DUAL;
		ELSE
			SELECT 2 FROM DUAL;
		 INSERT INTO umsg(msg_id,s_id,status)
		 VALUES (msgid,67,0);
		END IF;
	UNTIL Done END REPEAT;
  
  CLOSE cur;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `getnewmsg`
-- ----------------------------
DROP PROCEDURE IF EXISTS `getnewmsg`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getnewmsg`(IN `uid` int)
BEGIN
	DECLARE Done int DEFAULT 0;
	DECLARE msgid int(10);
	DECLARE sid int(10);

	DECLARE cur CURSOR FOR 
	SELECT 	m.msg_id,m.s_id
		FROM 	msg m
		LEFT   	JOIN umsg u
	        ON  m.msg_id = u.msg_id
         WHERE  u.msg_id is NULL
	AND    m.s_id IN (uid,0);
	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET Done = TRUE;

	OPEN cur;
	
	REPEAT
		FETCH next FROM cur INTO msgid,sid;
		IF not Done THEN 
		 INSERT INTO umsg(msg_id,s_id,status)
		 VALUES (msgid,uid,0);
		END IF;
	UNTIL Done END REPEAT;
  
  CLOSE cur;
	
  SELECT *from msg m 
	JOIN umsg u ON m.msg_id = u.msg_id;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `hhh`
-- ----------------------------
DROP PROCEDURE IF EXISTS `hhh`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `hhh`(IN `sid` int)
BEGIN
	#Routine body goes here...
	SELECT * from msg WHERE s_id = sid;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `nsg`
-- ----------------------------
DROP FUNCTION IF EXISTS `nsg`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nsg`(`sid` int) RETURNS varchar(50) CHARSET utf8
BEGIN
	DECLARE Done int DEFAULT 0;
	DECLARE msgid int(10);
	DECLARE sid int(10);
	DECLARE msgidlist VARCHAR(50);

	DECLARE cur CURSOR FOR 
	SELECT 	m.msg_id,m.s_id
		FROM 	msg m
		LEFT   	JOIN umsg u
	        ON  m.msg_id = u.msg_id
         WHERE  u.msg_id is NULL
	AND    m.s_id IN (sid,0);
	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET Done = TRUE;

	OPEN cur;
	
	REPEAT	
		FETCH next FROM cur INTO msgid,sid;
		IF Done THEN 
			SET msgidlist = '0';
		ELSE
			SET msgidlist = '哈哈';
		 INSERT INTO umsg(msg_id,s_id,status)
		 VALUES (msgid,67,0);
		 SET msgidlist = '0';
		END IF;
	UNTIL Done END REPEAT;
  CLOSE cur;

	RETURN msgidlist;
END
;;
DELIMITER ;
