/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.5.28 : Database - yidu_product_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yidu_product_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yidu_product_db`;

/*Table structure for table `yidu_address` */

DROP TABLE IF EXISTS `yidu_address`;

CREATE TABLE `yidu_address` (
  `address_id` varchar(100) NOT NULL COMMENT '收货地址ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `province` varchar(100) DEFAULT NULL COMMENT '省份',
  `city` varchar(100) DEFAULT NULL COMMENT '城市',
  `county` varchar(100) DEFAULT NULL COMMENT '县区域',
  `detail_address` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `address_people` varchar(100) DEFAULT NULL COMMENT '收货人',
  `address_phone` varchar(100) DEFAULT NULL COMMENT '收货人电话',
  `isva` int(11) DEFAULT NULL COMMENT '是否有效',
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货地址';

/*Data for the table `yidu_address` */

/*Table structure for table `yidu_comments` */

DROP TABLE IF EXISTS `yidu_comments`;

CREATE TABLE `yidu_comments` (
  `comment_id` varchar(100) NOT NULL COMMENT '评论ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `pro_id` varchar(100) DEFAULT NULL COMMENT '产品ID',
  `comment_grad` int(11) DEFAULT NULL COMMENT '评论等级',
  `comment_content` varchar(200) DEFAULT NULL COMMENT '评论内容',
  `comment_date` varchar(100) DEFAULT NULL COMMENT '评论时间',
  `isva` int(11) DEFAULT NULL COMMENT '是否有效',
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

/*Data for the table `yidu_comments` */

/*Table structure for table `yidu_coupon` */

DROP TABLE IF EXISTS `yidu_coupon`;

CREATE TABLE `yidu_coupon` (
  `COUPON_ID` varchar(100) NOT NULL COMMENT '优惠券ID',
  `users_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `COUPON_CODE` varchar(100) DEFAULT NULL COMMENT '优惠券编码',
  `COUPON_MONEY` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '使用说明备注',
  `COUPON_MIN_MONEY` decimal(10,2) DEFAULT NULL COMMENT '最小起点金额',
  `START_TIME` varchar(100) DEFAULT NULL COMMENT '开始时间',
  `END_TIME` varchar(100) DEFAULT NULL COMMENT '结束时间',
  `CALC` varchar(100) DEFAULT NULL COMMENT '计算规则',
  `ISVA` int(11) DEFAULT '1' COMMENT '是否有效',
  `OPTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  `OPER` varchar(100) DEFAULT NULL COMMENT '操作人',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`COUPON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券';

/*Data for the table `yidu_coupon` */

/*Table structure for table `yidu_orders` */

DROP TABLE IF EXISTS `yidu_orders`;

CREATE TABLE `yidu_orders` (
  `orders_id` varchar(100) NOT NULL COMMENT '订单ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `address_id` varchar(100) DEFAULT NULL COMMENT '收货地址ID',
  `orders_code` varchar(100) DEFAULT NULL COMMENT '订单编号',
  `orders_number` int(11) DEFAULT NULL COMMENT '订单商品数量',
  `orders_date` varchar(100) DEFAULT NULL COMMENT '订单日期',
  `orders_sumMoney` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `orders_state` int(11) DEFAULT NULL COMMENT '订单状态',
  `isva` int(11) DEFAULT NULL COMMENT '是否有效',
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `pro_id` varchar(100) DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`orders_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

/*Data for the table `yidu_orders` */

/*Table structure for table `yidu_product` */

DROP TABLE IF EXISTS `yidu_product`;

CREATE TABLE `yidu_product` (
  `pro_id` varchar(100) NOT NULL COMMENT '产品ID',
  `pro_type_id` varchar(100) DEFAULT NULL COMMENT '产品类型ID',
  `pro_name` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `pro_price` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
  `pro_color` varchar(100) DEFAULT NULL COMMENT '产品颜色',
  `pro_remark` varchar(1500) DEFAULT NULL COMMENT '产品描述',
  `isva` int(11) DEFAULT NULL COMMENT '是否有效',
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';

/*Data for the table `yidu_product` */

insert  into `yidu_product`(`pro_id`,`pro_type_id`,`pro_name`,`pro_price`,`pro_color`,`pro_remark`,`isva`,`optime`,`oper`,`sort`) values 
('1001',NULL,'小米9',2999.00,NULL,'小米最新旗舰级手机',1,'2019-06-09 09:38:06','管理员',NULL);

/*Table structure for table `yidu_product_image` */

DROP TABLE IF EXISTS `yidu_product_image`;

CREATE TABLE `yidu_product_image` (
  `img_id` varchar(100) NOT NULL COMMENT '图片ID',
  `pro_id` varchar(100) DEFAULT NULL COMMENT '产品ID',
  `img_path` varchar(100) DEFAULT NULL COMMENT '图片地址',
  `img_type` int(11) DEFAULT NULL COMMENT '图片类型',
  `img_remark` varchar(1500) DEFAULT NULL COMMENT '图片说明',
  `isva` int(11) DEFAULT NULL COMMENT '是否有效',
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品图片表';

/*Data for the table `yidu_product_image` */

/*Table structure for table `yidu_product_type` */

DROP TABLE IF EXISTS `yidu_product_type`;

CREATE TABLE `yidu_product_type` (
  `pro_type_id` varchar(100) NOT NULL COMMENT '产品类型ID',
  `pro_type_pid` varchar(100) DEFAULT NULL COMMENT '自关联ID',
  `pro_type_name` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `pro_type_remark` varchar(1500) DEFAULT NULL COMMENT '类型描述',
  `isva` int(11) DEFAULT NULL COMMENT '是否有效',
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`pro_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品类型';

/*Data for the table `yidu_product_type` */

/*Table structure for table `yidu_rushorders` */

DROP TABLE IF EXISTS `yidu_rushorders`;

CREATE TABLE `yidu_rushorders` (
  `ROID` varchar(100) NOT NULL COMMENT '秒杀订单主键',
  `ID` varchar(100) DEFAULT NULL COMMENT '主键',
  `users_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `num` int(11) DEFAULT NULL COMMENT '下单数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '下单单价',
  `total` decimal(10,2) DEFAULT NULL COMMENT '合计金额',
  `coupon` varchar(100) DEFAULT NULL COMMENT '优惠券',
  `fact_total` decimal(10,2) DEFAULT NULL COMMENT '实付金额',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `oper` varchar(100) DEFAULT NULL,
  `optime` varchar(100) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`ROID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀订单';

/*Data for the table `yidu_rushorders` */

/*Table structure for table `yidu_rushtobuy` */

DROP TABLE IF EXISTS `yidu_rushtobuy`;

CREATE TABLE `yidu_rushtobuy` (
  `ID` varchar(100) NOT NULL COMMENT '主键',
  `pro_id` varchar(100) DEFAULT NULL COMMENT '产品ID',
  `pro_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `num` int(11) DEFAULT NULL COMMENT '库存数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '秒杀价格',
  `startTime` varchar(100) DEFAULT NULL COMMENT '开始时间',
  `endTime` varchar(100) DEFAULT NULL COMMENT '结束时间',
  `oper` varchar(100) DEFAULT NULL,
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀商品';

/*Data for the table `yidu_rushtobuy` */

/*Table structure for table `yidu_shoppingcar` */

DROP TABLE IF EXISTS `yidu_shoppingcar`;

CREATE TABLE `yidu_shoppingcar` (
  `shoppingCar_id` varchar(100) NOT NULL COMMENT '购物车ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `pro_id` varchar(100) DEFAULT NULL COMMENT '产品ID',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '商品单价',
  `shoppingCar_date` varchar(100) DEFAULT NULL COMMENT '加入购物车时间',
  `product_color` varchar(100) DEFAULT NULL COMMENT '产品颜色',
  `product_capacity` varchar(100) DEFAULT NULL COMMENT '产品容量',
  `isva` int(11) DEFAULT NULL COMMENT '是否有效',
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`shoppingCar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

/*Data for the table `yidu_shoppingcar` */

/*Table structure for table `yidu_users` */

DROP TABLE IF EXISTS `yidu_users`;

CREATE TABLE `yidu_users` (
  `users_id` varchar(100) NOT NULL COMMENT '用户ID',
  `users_name` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `users_password` varchar(100) DEFAULT NULL COMMENT '用户密码',
  `users_image` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `users_phone` decimal(11,0) DEFAULT NULL COMMENT '用户电话',
  `users_sex` varchar(100) DEFAULT NULL COMMENT '用户性别',
  `users_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `business_name` varchar(100) DEFAULT NULL COMMENT '商家名称',
  `full_name` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `users_cardId` varchar(100) DEFAULT NULL COMMENT '用户身份证',
  `isva` int(11) DEFAULT NULL COMMENT '是否有效',
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `yidu_users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
