/*
SQLyog Ultimate v8.32 
MySQL - 5.6.26-log : Database - ssm2016
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm2016` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssm2016`;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) NOT NULL COMMENT '商品名,要求唯一',
  `count` int(10) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品表';

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(32) NOT NULL COMMENT '用户名,要求唯一',
  `PASSWORD` varchar(32) NOT NULL COMMENT '登录密码,md5加密',
  `email` varchar(32) DEFAULT NULL COMMENT '邮件,要求唯一',
  `mobile` varchar(11) DEFAULT NULL COMMENT '绑定的手机号,不要求唯一',
  `sex` smallint(1) DEFAULT '0' COMMENT '性别: 0女,1男',
  `age` int(10) DEFAULT '0' COMMENT '年龄',
  `address` varchar(32) DEFAULT NULL COMMENT '地址',
  `image` varchar(50) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
