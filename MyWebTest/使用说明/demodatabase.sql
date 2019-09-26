/*
 Navicat Premium Data Transfer

 Source Server         : Mylink
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : demodatabase

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 27/05/2019 17:21:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for statsinfo
-- ----------------------------
DROP TABLE IF EXISTS `statsinfo`;
CREATE TABLE `statsinfo`  (
  `ids` int(255) NOT NULL AUTO_INCREMENT,
  `picsum` int(255) NOT NULL,
  `videosum` int(255) NOT NULL,
  PRIMARY KEY (`ids`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of statsinfo
-- ----------------------------
INSERT INTO `statsinfo` VALUES (1, 9, 3);

-- ----------------------------
-- Table structure for uploadinfo
-- ----------------------------
DROP TABLE IF EXISTS `uploadinfo`;
CREATE TABLE `uploadinfo`  (
  `ids` int(255) NOT NULL AUTO_INCREMENT,
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ids`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uploadinfo
-- ----------------------------
INSERT INTO `uploadinfo` VALUES (1, '1', '2019-05-09 21:14:53', '/1/1.jpg', '太好吃了', '广州', '图片');
INSERT INTO `uploadinfo` VALUES (2, '2', '2019-05-09 21:15:34', '/2/2.jpg', '无法形容', '上海', '图片');
INSERT INTO `uploadinfo` VALUES (3, '3', '2019-05-09 21:16:33', '/3/3.jpg', '大家好', '北京', '图片');
INSERT INTO `uploadinfo` VALUES (4, '4', '2019-05-09 23:53:28', '/4/4.jpg', '第一次吃', '广州', '图片');
INSERT INTO `uploadinfo` VALUES (5, '5', '2019-05-10 11:45:22', '/5/1.jpg#/5/2.jpg', '分享一波', '北京', '图片');
INSERT INTO `uploadinfo` VALUES (6, '5', '2019-05-10 13:24:33', '/5/1234.mp4#', '临摹美食', '深圳', '视频');
INSERT INTO `uploadinfo` VALUES (7, '1', '2019-05-15 10:32:25', '/1/11.jpg#/1/2.jpg', '1234', '广州市', '图片');
INSERT INTO `uploadinfo` VALUES (8, '4', '2019-05-15 11:18:27', '/4/123.mp4#', '机长', '广州市', '视频');
INSERT INTO `uploadinfo` VALUES (9, 'asd', '2019-05-24 21:45:21', '/1/800005083.jpg#/1/800005637.jpg#', 'sdh', '广州市', '图片');
INSERT INTO `uploadinfo` VALUES (10, 'asd', '2019-05-24 21:47:59', '/asd/ba62296525d4eb08ffa5cb48c0aa6260.mp4#', '宿舍', '广州市  天河区  东区一路', '视频');
INSERT INTO `uploadinfo` VALUES (11, 'asd', '2019-05-25 09:04:12', '/asd/mmexport1558618071682.jpg#/asd/mmexport1556725707877.jpg#', '十二', '广州市  天河区  华山路', '图片');
INSERT INTO `uploadinfo` VALUES (12, 'asd', '2019-05-25 09:27:04', '/asd/mmexport1558618016098.jpg#', '啥时间', '广州市  天河区  紫薇西路', '图片');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `ids` int(255) NOT NULL AUTO_INCREMENT,
  `uid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `upw` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ids`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, '1', '12');
INSERT INTO `userinfo` VALUES (2, '2', '12');
INSERT INTO `userinfo` VALUES (3, '3', '12');
INSERT INTO `userinfo` VALUES (4, '4', '12');
INSERT INTO `userinfo` VALUES (5, '5', '12');
INSERT INTO `userinfo` VALUES (6, 'asd', '12');

SET FOREIGN_KEY_CHECKS = 1;
