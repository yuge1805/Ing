/*
SQLyog Ultimate v11.13 (64 bit)
MySQL - 5.7.17-log : Database - ing_business
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ing_business` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `ing_business`;

/*Table structure for table `biz_order` */

DROP TABLE IF EXISTS `biz_order`;

CREATE TABLE `biz_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单号',
  `consignee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人',
  `consignee_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货地址',
  `consignee_mobile` varchar(36) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人手机',
  `delivery_way` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '配送方式',
  `expected_delivery_date` datetime DEFAULT NULL COMMENT '期望送货日期',
  `pay_way` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '付款方式',
  `pay_date` datetime DEFAULT NULL COMMENT '付款时间',
  `order_status` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单状态',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '平台Id',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `crt_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `crt_user_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人姓名',
  `upd_time` datetime DEFAULT NULL COMMENT '更新时间',
  `upd_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `upd_user_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人姓名',
  `deleted` int(1) DEFAULT '0' COMMENT '是否删除，0 未删除， 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单';

/*Table structure for table `biz_order_item` */

DROP TABLE IF EXISTS `biz_order_item`;

CREATE TABLE `biz_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单号',
  `commodity_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品编号',
  `commodity_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `unit_price` decimal(12,2) DEFAULT NULL COMMENT '单价',
  `quantity` decimal(12,2) DEFAULT NULL COMMENT '数量',
  `total_price` decimal(12,2) DEFAULT NULL COMMENT '合计价格',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '平台Id',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `crt_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `crt_user_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人姓名',
  `upd_time` datetime DEFAULT NULL COMMENT '更新时间',
  `upd_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `upd_user_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人姓名',
  `deleted` int(1) DEFAULT '0' COMMENT '是否删除，0 未删除， 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单明细';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
