/*
 Navicat Premium Data Transfer

 Source Server         : loclahost
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : poscash

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 29/10/2020 22:51:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for BUS_GOODS
-- ----------------------------
DROP TABLE IF EXISTS `BUS_GOODS`;
CREATE TABLE `BUS_GOODS`  (
  `GOODS_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `TYPE_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型ID',
  `GOODS_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `BAR_CODE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条码',
  `GOODS_CODE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货号',
  `SPECE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `PINYIN` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拼音',
  `RESERVE` int(11) NULL DEFAULT NULL COMMENT '库存',
  `UNIT_CODE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主单位 对应编码表单位',
  `STOCK_PRICE` decimal(12, 2) NULL DEFAULT NULL COMMENT '进货价',
  `SELL_PRICE` decimal(12, 2) NULL DEFAULT NULL COMMENT '销售价',
  `PLENTY_SELL_PRICE` decimal(12, 2) NULL DEFAULT NULL COMMENT '批发价',
  `MEMBER_PRICE` decimal(12, 2) NULL DEFAULT NULL COMMENT '会员价',
  `IS_MEMBER_REBATE` int(11) NULL DEFAULT NULL COMMENT '是否会员折扣1是0否',
  `SUPPLIER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商ID',
  `PREDUCE_DATE` date NULL DEFAULT NULL COMMENT '生产日期',
  `QUALITY_DAYS` int(11) NULL DEFAULT NULL COMMENT '保质期 单位-天',
  `IS_MULTY_CODE` int(11) NULL DEFAULT NULL COMMENT '一品多码 1是0否',
  `IS_NO_RESERVE` int(11) NULL DEFAULT NULL COMMENT '是否不计库存1是 0 否',
  `IS_AVIABLE` int(11) NULL DEFAULT NULL COMMENT '是否可用 1可用 0不可用',
  `SORT_FLAG` int(11) NULL DEFAULT NULL COMMENT '排序',
  `REMARK` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `CREATE_USER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`GOODS_ID`) USING BTREE,
  INDEX `FK_Reference_2`(`TYPE_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`TYPE_ID`) REFERENCES `BUS_GOODS_TYPE` (`TYPE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for BUS_GOODS_TYPE
-- ----------------------------
DROP TABLE IF EXISTS `BUS_GOODS_TYPE`;
CREATE TABLE `BUS_GOODS_TYPE`  (
  `TYPE_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型ID',
  `TYPE_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `PARENT_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级类型ID',
  `IS_AVIABLE` int(11) NULL DEFAULT NULL COMMENT '是否可用 1可用 0不可用',
  `SORT_FLAG` int(11) NULL DEFAULT NULL COMMENT '排序',
  `CREATE_USER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`TYPE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of BUS_GOODS_TYPE
-- ----------------------------
INSERT INTO `BUS_GOODS_TYPE` VALUES ('23c8b984-1683-11eb-9f8f-0242ac110003', '是是是', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for BUS_SUPPLIER
-- ----------------------------
DROP TABLE IF EXISTS `BUS_SUPPLIER`;
CREATE TABLE `BUS_SUPPLIER`  (
  `SUPPLIER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供货商ID',
  `SUPPLIER_CODE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供货商编号',
  `PINYIN` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拼音',
  `CONTACT` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `CONTACT_NUMBER` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `CONTACT_EMAIL` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  PRIMARY KEY (`SUPPLIER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供货商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ROLE_MENU_REL
-- ----------------------------
DROP TABLE IF EXISTS `ROLE_MENU_REL`;
CREATE TABLE `ROLE_MENU_REL`  (
  `MENU_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单ID',
  `ROLE_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`MENU_ID`, `ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-菜单关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for SYS_CODE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_CODE`;
CREATE TABLE `SYS_CODE`  (
  `CODE_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码ID',
  `CODE_TYPE_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码类型ID',
  `CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码',
  `CODE_TYPE_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码类型编码',
  `CODE_VAL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码值',
  `IS_AVIABLE` int(11) NOT NULL COMMENT '是否可用 1可用 0不可用',
  `SORT_FLAG` int(11) NULL DEFAULT NULL COMMENT '排序',
  `CREATE_USER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`CODE_ID`) USING BTREE,
  INDEX `FK_Reference_3`(`CODE_TYPE_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`CODE_TYPE_ID`) REFERENCES `SYS_CODE_TYPE` (`CODE_TYPE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '编码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of SYS_CODE
-- ----------------------------
INSERT INTO `SYS_CODE` VALUES ('1b737e0e-15f4-11eb-bd5a-0242ac110002', '222a1429-15ee-11eb-bd5a-0242ac110002', '停用', 'YESorNO', '0', 1, 8, NULL, NULL);
INSERT INTO `SYS_CODE` VALUES ('74f7bbf1-1619-11eb-82df-0242ac110003', 'ab790ccb-1618-11eb-82df-0242ac110003', '主菜单', 'MENU_TYPE', '1', 1, 1, NULL, NULL);
INSERT INTO `SYS_CODE` VALUES ('81ed5bda-1619-11eb-82df-0242ac110003', 'ab790ccb-1618-11eb-82df-0242ac110003', '组名', 'MENU_TYPE', '2', 1, 2, NULL, NULL);
INSERT INTO `SYS_CODE` VALUES ('84ace714-15f1-11eb-bd5a-0242ac110002', '222a1429-15ee-11eb-bd5a-0242ac110002', '可用', 'YESorNO', '1', 1, 1, NULL, NULL);
INSERT INTO `SYS_CODE` VALUES ('9432eed0-1619-11eb-82df-0242ac110003', 'ab790ccb-1618-11eb-82df-0242ac110003', '子菜单', 'MENU_TYPE', '3', 1, 3, NULL, NULL);
INSERT INTO `SYS_CODE` VALUES ('bf9359d4-166c-11eb-9f8f-0242ac110003', 'ab790ccb-1618-11eb-82df-0242ac110003', 'test', 'MENU_TYPE', '4', 0, 4, NULL, NULL);

-- ----------------------------
-- Table structure for SYS_CODE_TYPE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_CODE_TYPE`;
CREATE TABLE `SYS_CODE_TYPE`  (
  `CODE_TYPE_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码类型ID',
  `CODE_TYPE_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名称',
  `CODE_TYPE_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型编码',
  `IS_AVIABLE` int(11) NULL DEFAULT NULL COMMENT '是否可用 1可用 0不可用',
  `SORT_FLAG` int(11) NULL DEFAULT NULL COMMENT '排序',
  `CREATE_USER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`CODE_TYPE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '编码类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of SYS_CODE_TYPE
-- ----------------------------
INSERT INTO `SYS_CODE_TYPE` VALUES ('222a1429-15ee-11eb-bd5a-0242ac110002', '是否可用', 'YESorNO', 1, 1, NULL, NULL);
INSERT INTO `SYS_CODE_TYPE` VALUES ('ab790ccb-1618-11eb-82df-0242ac110003', '菜单类型', 'MENU_TYPE', 1, 2, NULL, NULL);

-- ----------------------------
-- Table structure for SYS_MENU
-- ----------------------------
DROP TABLE IF EXISTS `SYS_MENU`;
CREATE TABLE `SYS_MENU`  (
  `MENU_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单ID',
  `PARENT_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级ID',
  `IS_AVIABLE` int(11) NOT NULL COMMENT '是否可用 1可用 0不可用',
  `MENU_TYPE` int(11) NULL DEFAULT NULL COMMENT '菜单类型 1 主菜单  2组  3 子菜单',
  `MENU_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `MENU_URL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `MENU_ICON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单icon',
  `SORT_FLAG` int(11) NOT NULL COMMENT '排序',
  `CREATE_USER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of SYS_MENU
-- ----------------------------
INSERT INTO `SYS_MENU` VALUES ('0bcf495f-1683-11eb-9f8f-0242ac110003', '84d93df7-1673-11eb-9f8f-0242ac110003', 1, 3, '商品分类', '/bus/html/busGoodsType.html', NULL, 2, NULL, NULL);
INSERT INTO `SYS_MENU` VALUES ('0ef90139-1689-11eb-9f8f-0242ac110003', '84d93df7-1673-11eb-9f8f-0242ac110003', 1, 1, '333', NULL, NULL, 3, NULL, NULL);
INSERT INTO `SYS_MENU` VALUES ('1', NULL, 1, 1, '系统设置', NULL, 'layui-icon-set-sm', 9, NULL, NULL);
INSERT INTO `SYS_MENU` VALUES ('2', '1', 1, 3, '菜单设置', '/sys/html/sysMenu.html', NULL, 1, NULL, NULL);
INSERT INTO `SYS_MENU` VALUES ('3', '1', 1, 3, '编码类型', '/sys/html/sysCodeType.html', NULL, 2, NULL, NULL);
INSERT INTO `SYS_MENU` VALUES ('4', '1', 1, 3, '编码设置', '/sys/html/sysCode.html', NULL, 3, NULL, NULL);
INSERT INTO `SYS_MENU` VALUES ('49f76e1f-1677-11eb-9f8f-0242ac110003', '84d93df7-1673-11eb-9f8f-0242ac110003', 1, 3, '商品资料', '/bus/html/busGoods.html', NULL, 1, NULL, NULL);
INSERT INTO `SYS_MENU` VALUES ('84d93df7-1673-11eb-9f8f-0242ac110003', NULL, 1, 1, '商品', NULL, 'layui-icon-list', 1, NULL, NULL);

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE`;
CREATE TABLE `SYS_ROLE`  (
  `ROLE_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `CREATE_USER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `LASTUPT_USER` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `LASTUPT_TIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for SYS_ROLE_MENU_REL
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE_MENU_REL`;
CREATE TABLE `SYS_ROLE_MENU_REL`  (
  `MENU_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单ID',
  `ROLE_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`MENU_ID`, `ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-菜单关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USER`;
CREATE TABLE `SYS_USER`  (
  `USER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `ROLE_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  `USER_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `PWD` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `CREATE_USER_ID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `LASTUPT_USER` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `LASTUPT_TIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`USER_ID`) USING BTREE,
  INDEX `FK_Reference_1`(`ROLE_ID`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `SYS_ROLE` (`ROLE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
