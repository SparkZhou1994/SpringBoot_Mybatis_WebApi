/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : studentscoremanagement

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-05-28 09:50:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_no` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`class_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '软件');
INSERT INTO `class` VALUES ('2', '旅游');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_no` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `course_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`course_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '高数');
INSERT INTO `course` VALUES ('2', '宏观经济');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `stu_no` int(10) unsigned NOT NULL DEFAULT '0',
  `course_no` int(10) unsigned NOT NULL DEFAULT '0',
  `score` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`stu_no`,`course_no`),
  KEY `course_no` (`course_no`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`stu_no`) REFERENCES `student` (`stu_no`),
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`course_no`) REFERENCES `course` (`course_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', '100');
INSERT INTO `score` VALUES ('1', '2', '90');
INSERT INTO `score` VALUES ('2', '1', '90');
INSERT INTO `score` VALUES ('2', '2', '100');
INSERT INTO `score` VALUES ('3', '1', '80');
INSERT INTO `score` VALUES ('3', '2', '70');
INSERT INTO `score` VALUES ('4', '1', '70');
INSERT INTO `score` VALUES ('4', '2', '80');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_no` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(20) DEFAULT NULL,
  `class_no` int(10) unsigned DEFAULT NULL,
  `role` char(1) DEFAULT NULL,
  PRIMARY KEY (`stu_no`),
  KEY `class_no` (`class_no`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_no`) REFERENCES `class` (`class_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '周炬辉', '1', 'm');
INSERT INTO `student` VALUES ('2', '颜雨婷', '2', 'm');
INSERT INTO `student` VALUES ('3', '周清闻', '1', 's');
INSERT INTO `student` VALUES ('4', '王慧敏', '2', 's');
