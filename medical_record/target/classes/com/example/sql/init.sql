/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : medical

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 21/03/2021 19:48:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别，0-男，1-女',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', '123', '管理员', 0, 18);

-- ----------------------------
-- Table structure for t_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE `t_doctor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别，0-男，1-女',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `rid` int(11) NULL DEFAULT NULL COMMENT '科室ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `t_doctor_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `t_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_doctor
-- ----------------------------
INSERT INTO `t_doctor` VALUES (1, '123', '123', '小红', 1, 52, 1);
INSERT INTO `t_doctor` VALUES (2, '5215154', 'jij4234', '张云鹏', 1, 41, 5);
INSERT INTO `t_doctor` VALUES (3, '7841515', 'jfi452jio', '朱里隐', 1, 28, 8);
INSERT INTO `t_doctor` VALUES (4, '1516123', 'fe41w5a863', '飞羽', 0, 29, 5);
INSERT INTO `t_doctor` VALUES (5, '1485545', 'jijfelw34', '利用强', 1, 35, 3);
INSERT INTO `t_doctor` VALUES (6, '7894112', '45fsaef46f', '飞沙关', 1, 45, 9);
INSERT INTO `t_doctor` VALUES (7, '1854215', '156afdsaf', '易流', 0, 31, 2);

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `did` int(11) NULL DEFAULT NULL COMMENT '医生id',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医嘱',
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `date` timestamp(0) NULL DEFAULT NULL COMMENT '就诊时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `did`(`did`) USING BTREE,
  CONSTRAINT `t_record_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_record_ibfk_2` FOREIGN KEY (`did`) REFERENCES `t_doctor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_record
-- ----------------------------
INSERT INTO `t_record` VALUES (1, 3, 3, '者10天前上感后出现出现胸闷、心悸不适，活动后症状加重。病程中无发热、胸痛，无咳嗽咳痰；曾在明珠医院就诊，BCG示室性早搏，予以丹参片2#、Tid 口服，无明显效果，今来我院就诊。', '在诊', '2021-03-10 18:07:48');
INSERT INTO `t_record` VALUES (2, 3, 1, '病毒性心肌炎 频发室性早搏 高血压病（Ⅰ级，高危）', '转院', '2021-03-09 15:08:17');
INSERT INTO `t_record` VALUES (3, 6, 2, 'mp：09.10.16 停经38天 自测尿液妊娠试验（+）', '在诊', '2021-03-04 19:09:06');
INSERT INTO `t_record` VALUES (4, 2, 7, '用骨科鉴别诊断—病历首程必备神器 上肢及上肢带骨骨折锁骨骨折［类病鉴别〕1、肩锁关节脱位 锁骨外端高', '在诊', '2021-03-08 18:10:22');
INSERT INTO `t_record` VALUES (5, 3, 1, '关节脱位 两侧胸锁关节不对称，可有异常活动，锁骨内端可突出或空', '转院', '2021-03-24 18:10:30');
INSERT INTO `t_record` VALUES (6, 2, 7, '骨骨折 伤后胸部疼痛，咳嗽及深呼吸时疼痛加重；挤压胸廊时，骨折部分疼痛加剧；有时可合并气、血胸；X 线片示肋骨骨折', '转院', '2021-03-19 15:11:52');
INSERT INTO `t_record` VALUES (7, 3, 4, '肱骨外科颈骨折 多为传达暴力所致，上臂内侧可见瘀斑，有疼痛、压痛、功能障碍，可触及骨擦感及异常活动。肱骨大结节骨折〔类病鉴别〕l ', '在诊', '2021-02-10 18:12:19');
INSERT INTO `t_record` VALUES (8, 7, 1, '及异位肱骨头，肩关节弹性固定．有时两者常合并存在。2、肩峰骨折 均为肩部肿痛，但压痛点位于肩峰部，被动外展时可有一定的活动度；x 线片可见肩峰骨折。', '在诊', '2020-02-12 18:12:46');
INSERT INTO `t_record` VALUES (9, 1, 3, '肱骨外科颈骨折 症状、体征相似，但本病肿胀及瘀斑较明显，肱骨上端环形压痛，可有异常活动；X 线片见骨折线位于肱骨外颈．亦可两者合并存在。肱骨外科颈骨折〔类病鉴别〕1', '痊愈', '2021-02-18 18:13:29');
INSERT INTO `t_record` VALUES (10, 4, 4, '肩部挫伤 系直接暴力所致．局部皮肤有擦伤、瘀斑，肿胀、压痛局限于着力部位，无环形压痛及纵向叩击痛；X 线片无骨折征象。肱骨干骨折〔类病鉴别〕1', '痊愈', '2021-03-02 18:13:53');
INSERT INTO `t_record` VALUES (11, 7, 1, '肱骨外科颈骨折 肿痛在肩部，肱骨上端压痛；X 线正位片及穿胸位可显示骨折线在肱骨解剖颈下2厘米一3厘米；治疗后骨折', '在诊', '2021-03-30 18:15:42');

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES (1, '妇科');
INSERT INTO `t_room` VALUES (2, '儿科');
INSERT INTO `t_room` VALUES (3, '牙科');
INSERT INTO `t_room` VALUES (4, '眼科');
INSERT INTO `t_room` VALUES (5, '神经科');
INSERT INTO `t_room` VALUES (6, '口腔科');
INSERT INTO `t_room` VALUES (7, '耳鼻喉科');
INSERT INTO `t_room` VALUES (8, '骨科');
INSERT INTO `t_room` VALUES (9, '男科');
INSERT INTO `t_room` VALUES (10, '脑科');
INSERT INTO `t_room` VALUES (11, '皮肤科');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别，0-男，1-女',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '123', '123', '紫罗', 0, 41);
INSERT INTO `t_user` VALUES (2, '4150522', '11fa65e1f5a ', '致力', 1, 21);
INSERT INTO `t_user` VALUES (3, '4185136', 'a1f5e1a35', '李封', 1, 51);
INSERT INTO `t_user` VALUES (4, '1568545', 'f1e5f1s35fa5', '照立', 0, 12);
INSERT INTO `t_user` VALUES (5, '1548415', 'jieji48jfafdsa4', '主义立', 1, 45);
INSERT INTO `t_user` VALUES (6, '4458455', '41853135231', '烈火', 1, 52);
INSERT INTO `t_user` VALUES (7, '1512545', '151215fwea1', '魏丽', 0, 32);

SET FOREIGN_KEY_CHECKS = 1;
