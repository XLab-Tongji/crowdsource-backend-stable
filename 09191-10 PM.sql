# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.16)
# Database: crowdsource-angular
# Generation Time: 2018-09-19 05:10:14 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `account_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` text,
  `name` text,
  `icon` text,
  `password` text,
  `mobile` text,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `email` text,
  `ext_params` text,
  `dev_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table account_login_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account_login_log`;

CREATE TABLE `account_login_log` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `ip` text,
  `token` text,
  `create_time` datetime DEFAULT NULL,
  `expire_time` datetime DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `plat` text,
  `username` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table attach
# ------------------------------------------------------------

DROP TABLE IF EXISTS `attach`;

CREATE TABLE `attach` (
  `attach_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `attach_url` text,
  `attach_name` text,
  `size` int(11) DEFAULT NULL,
  `attach_type` text,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `meta_data` text,
  `username` text,
  `is_del` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`attach_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table dev_enroll_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `dev_enroll_info`;

CREATE TABLE `dev_enroll_info` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` char(20) DEFAULT '',
  `project_id` bigint(20) DEFAULT NULL,
  `enroll_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`,`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table developer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `developer`;

CREATE TABLE `developer` (
  `dev_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` text,
  `account_id` bigint(20) DEFAULT NULL,
  `dev_domain` text,
  `dev_intro` text,
  `enroll_date` datetime DEFAULT NULL,
  `ext_param` text,
  PRIMARY KEY (`dev_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table developing_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `developing_info`;

CREATE TABLE `developing_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` text,
  `project_id` bigint(20) DEFAULT NULL,
  `confirm_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table mart_git_connection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mart_git_connection`;

CREATE TABLE `mart_git_connection` (
  `mart_account_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `git_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`mart_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table project
# ------------------------------------------------------------

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `cost` double DEFAULT NULL,
  `delivery_cycle` int(11) DEFAULT NULL,
  `warranty_cycle` int(11) DEFAULT NULL,
  `address` text,
  `description` text,
  `username` text,
  `project_type` text,
  `create_date` datetime DEFAULT NULL,
  `project_name` text,
  `enroll_stop_time` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
