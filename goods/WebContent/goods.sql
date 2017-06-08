/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : goods

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-15 17:55:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `g_name` varchar(20) DEFAULT NULL,
  `g_price` decimal(8,2) DEFAULT NULL,
  `g_nums` int(5) DEFAULT NULL,
  `g_type` int(11) DEFAULT NULL,
  `g_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('4', '茶叶蛋', '1.50', '100000', '2', '中国人都吃得起茶叶蛋');
INSERT INTO `goods` VALUES ('5', '可口可乐', '2.00', '1000', '1', '可口可乐真好喝');
INSERT INTO `goods` VALUES ('6', '农夫山泉', '2.00', '100000', '1', '农夫山泉有点甜');
INSERT INTO `goods` VALUES ('7', '怡宝', '2.00', '110000', '1', '撒打算打算');
INSERT INTO `goods` VALUES ('8', '康师傅', '2.00', '1111', '1', '的说法是否对吃');
