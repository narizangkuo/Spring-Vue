/*
Navicat MySQL Data Transfer

Source Server         : localMySQL
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : spring_exam

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2023-10-14 09:44:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ibatis_department
-- ----------------------------
DROP TABLE IF EXISTS `ibatis_department`;
CREATE TABLE `ibatis_department` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_TIME` datetime NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `MANAGER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `MANAGER_ID` (`MANAGER_ID`),
  CONSTRAINT `ibatis_department_ibfk_1` FOREIGN KEY (`MANAGER_ID`) REFERENCES `ibatis_login_user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ibatis_department
-- ----------------------------
INSERT INTO `ibatis_department` VALUES ('1', '2023-03-07 14:51:36', 'DP1', 'Department for test', '1');
INSERT INTO `ibatis_department` VALUES ('2', '2023-03-07 14:51:37', 'DP2', 'Department for test', '2');
INSERT INTO `ibatis_department` VALUES ('3', '2023-09-24 22:57:42', 'DP-new', 'Department for update', '1');
INSERT INTO `ibatis_department` VALUES ('6', '2023-09-24 23:02:08', 'DP4', 'Department for test 4', '1');
INSERT INTO `ibatis_department` VALUES ('7', '2023-09-24 23:02:08', 'DP4', 'Department for test 4', null);

-- ----------------------------
-- Table structure for ibatis_login_user
-- ----------------------------
DROP TABLE IF EXISTS `ibatis_login_user`;
CREATE TABLE `ibatis_login_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_TIME` datetime DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `RGRENDER` varchar(255) DEFAULT NULL,
  `LOGIN_NAME` varchar(255) DEFAULT NULL,
  `MOBILE` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `DEPARTMENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LOGIN_NAME` (`LOGIN_NAME`),
  KEY `DEPARTMENT_ID` (`DEPARTMENT_ID`),
  CONSTRAINT `ibatis_login_user_ibfk_1` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `ibatis_department` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ibatis_login_user
-- ----------------------------
INSERT INTO `ibatis_login_user` VALUES ('1', '2023-03-07 16:22:29', null, null, 'peter', null, 'peter', '123', '1');
INSERT INTO `ibatis_login_user` VALUES ('2', '2023-03-07 16:22:29', null, null, 'peter1', null, 'peter1', '123', '1');
INSERT INTO `ibatis_login_user` VALUES ('3', '2023-03-08 11:07:51', '', '', 'peter2', '', 'peter2', '123', '2');
INSERT INTO `ibatis_login_user` VALUES ('4', '2023-03-08 11:07:51', '', '', 'admin', '', 'admin', 'admin.2023', '2');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(1024) DEFAULT NULL,
  `IS_DELETE` int(11) DEFAULT '0',
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('32', '电气工程及其自动化', '2023-09-30 00:00:00', '电气工程及其自动化是一个....', '0', '2023-10-01 15:49:24');
INSERT INTO `major` VALUES ('33', '通信工程', '2023-10-03 00:00:00', '通信工程简介', '0', '2023-10-01 16:03:43');
INSERT INTO `major` VALUES ('34', '自动化', '2023-10-02 00:00:00', '自动化专业简介', '1', '2023-10-01 16:04:02');
INSERT INTO `major` VALUES ('35', '软件工程', '2023-09-25 00:00:00', '软件工程简介', '0', '2023-10-01 16:04:16');
INSERT INTO `major` VALUES ('36', '计算机科学与技术', '2023-09-30 00:00:00', '计算机科学与技术主要研究计算机的设计与制造，包含计算机软件、硬件的基本理论、技能与方法，进行计算机系统和软件的开发与维护、硬件的组装等。例如：Windows系统的维护，手机APP的开发，台式电脑的整机装配等。相较于网络工程、软件工程，计算机科学与技术专业所学范围更广。 关键词：计算机 Windows 软件 电脑主机。', '0', '2023-10-05 15:13:03');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(1024) DEFAULT NULL,
  `IS_DELETE` int(11) DEFAULT '0',
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '软件学院', '2020-01-01 00:00:00', '西北工业大学软件学院是经教育部和原国家发展计划委员会于2001年12月批准成立的首批35所国家级示范性软件学院之一。2011年首批获得教育部软件工程一级学科博士点，2019年软件工程专业入选首批国家级一流本科专业建设点，2021年入选国家“首批特色化示范性软件学院”。', '0', '2023-10-05 15:11:20');
INSERT INTO `school` VALUES ('2', '软件与微电子学院', '2010-01-01 00:00:00', '软件与微电子学院xxxx', '1', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('3', '数学学院', '2010-01-01 00:00:00', '数学学院xxxx', '0', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('4', '计算机学院', '2010-01-01 00:00:00', '计算机学院xxxx', '0', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('5', '电气学院', '2010-01-01 00:00:00', '电气学院xxxxxxxxxx', '0', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('6', '经管学院', '2023-01-01 00:00:00', '经管学院xxxxxxxxxx', '0', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('7', '食品学院', '2010-01-01 00:00:00', '食品学院xxxxxxxxxx', '0', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('8', '航天学院', '2018-01-01 00:00:00', '航天学院sssssssssssss', '1', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('9', '航海学院', '2020-02-03 00:00:00', '航海学院xxxx', '0', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('27', '航天学院', '2023-10-01 00:00:00', '航天学院xxxxx', '0', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('28', '旅游管理学院', '2023-10-04 00:00:00', '旅游学院XXXX', '0', '2023-10-01 11:25:58');
INSERT INTO `school` VALUES ('30', '水电学院', '2023-10-04 00:00:00', '水电学院简介', '0', '2023-10-01 16:04:55');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `ID_CARD` bigint(20) NOT NULL,
  `SEX` bigint(20) NOT NULL,
  `S_CLASS` bigint(20) NOT NULL,
  `S_TYPE` bigint(20) NOT NULL,
  `ROLL_TIME` datetime DEFAULT NULL,
  `MOBILE` varchar(50) NOT NULL,
  `IS_DELETE` int(11) DEFAULT '0',
  `UPDATE_TIME` datetime DEFAULT NULL,
  `MAJOR_ID` bigint(20) NOT NULL,
  `SCHOOL_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_STUDENT_MAJOR_ID` (`MAJOR_ID`),
  KEY `FK_STUDENT_SCHOOL_ID` (`SCHOOL_ID`),
  CONSTRAINT `FK_STUDENT_MAJOR_ID` FOREIGN KEY (`MAJOR_ID`) REFERENCES `major` (`ID`),
  CONSTRAINT `FK_STUDENT_SCHOOL_ID` FOREIGN KEY (`SCHOOL_ID`) REFERENCES `school` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2023001', '臧阔', '4123', '0', '1', '2', '2023-09-30 00:00:00', '13598', '1', '2023-10-02 16:55:02', '32', '5');
INSERT INTO `student` VALUES ('2023002', 'zk', '110', '0', '2', '1', '2023-09-23 00:00:00', '222233', '1', '2023-10-02 20:23:07', '33', '5');
INSERT INTO `student` VALUES ('2023003', '臧003', '2222', '0', '2', '2', '2023-09-24 00:00:00', '112222', '0', '2023-10-05 15:13:28', '36', '4');
INSERT INTO `student` VALUES ('2023004', '测试1', '222', '1', '3', '1', '2023-10-10 00:00:00', '2222', '1', '2023-10-02 20:29:56', '33', '5');
INSERT INTO `student` VALUES ('2023005', '测试2', '2222', '0', '2', '2', '2023-09-24 00:00:00', '2222', '0', '2023-10-02 20:23:00', '35', '1');
INSERT INTO `student` VALUES ('2023006', '测试3', '333', '0', '1', '1', '2023-10-15 00:00:00', '3333', '1', '2023-10-02 20:32:24', '35', '1');
INSERT INTO `student` VALUES ('2023007', '测试4', '222', '0', '2', '1', '2023-10-09 00:00:00', '222', '0', '2023-10-02 20:32:17', '35', '1');
INSERT INTO `student` VALUES ('2023101', 'zack-2', '41230001', '1', '6', '3', '2023-08-31 00:00:00', '13814176885', '1', '2023-10-02 20:24:59', '35', '1');
