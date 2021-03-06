/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.3.166_3307_MySQL5.7.25
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.3.166:3307
 Source Schema         : mooc_one

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 22/03/2019 03:18:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item_info
-- ----------------------------
DROP TABLE IF EXISTS `item_info`;
CREATE TABLE `item_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `price` decimal(15, 2) NULL DEFAULT NULL COMMENT '销售价',
  `is_active` int(11) NULL DEFAULT 1 COMMENT '是否有效（1=是；0=否）',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_code`(`code`) USING BTREE COMMENT '商品编码唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item_info
-- ----------------------------
INSERT INTO `item_info` VALUES (1, '10010', 'Java编程思想', 58.50, 1, '2019-01-13 14:07:58', NULL);
INSERT INTO `item_info` VALUES (2, '10011', '由浅入深实战分布式中间件', 45.50, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (3, '10012', 'Dubbo实战教程', 68.00, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (4, '10013', 'JVM深入实战指南', 38.50, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (5, '10014', 'SpringBoot实战', 56.50, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (6, '10015', 'SpringCloud实战', 64.00, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (7, '10017', 'Mysql实战指南', 75.50, 1, '2019-01-13 14:07:59', NULL);

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` int(11) UNSIGNED NOT NULL COMMENT '商品id',
  `total` int(11) UNSIGNED NOT NULL COMMENT '数量',
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户姓名',
  `order_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '下单时间',
  `is_active` smallint(1) UNSIGNED NULL DEFAULT 1 COMMENT '是否有效|是否已下架',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
