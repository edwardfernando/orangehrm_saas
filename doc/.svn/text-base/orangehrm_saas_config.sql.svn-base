/*
SQLyog Ultimate v8.82 
MySQL - 5.5.27 : Database - orangehrm_saas_config
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`orangehrm_saas_config` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `orangehrm_saas_config`;

/*Table structure for table `db_connection` */

DROP TABLE IF EXISTS `db_connection`;

CREATE TABLE `db_connection` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `SERVER_INSTANCE_ID` int(11) DEFAULT NULL,
  `TENANTS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_DB_CONNECTION_SERVER_INSTANCE1_idx` (`SERVER_INSTANCE_ID`),
  KEY `fk_DB_CONNECTION_TENANTS1_idx` (`TENANTS_ID`),
  CONSTRAINT `fk_DB_CONNECTION_SERVER_INSTANCE1` FOREIGN KEY (`SERVER_INSTANCE_ID`) REFERENCES `server_instance` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DB_CONNECTION_TENANTS1` FOREIGN KEY (`TENANTS_ID`) REFERENCES `tenants` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `db_connection` */

insert  into `db_connection`(`ID`,`URL`,`USERNAME`,`PASSWORD`,`SERVER_INSTANCE_ID`,`TENANTS_ID`) values (1,'jdbc:mysql://localhost:3306/orangehrm_saas_gramedia?characterEncoding=UTF-8','root','',1,2),(2,'jdbc:mysql://localhost:3306/orangehrm_saas_chevron?characterEncoding=UTF-8','root','',1,3);

/*Table structure for table `encryption_key` */

DROP TABLE IF EXISTS `encryption_key`;

CREATE TABLE `encryption_key` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ENCRYPTION_KEY` text,
  `TENANTS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ENCRYPTION_KEY_TENANTS1_idx` (`TENANTS_ID`),
  CONSTRAINT `fk_ENCRYPTION_KEY_TENANTS1` FOREIGN KEY (`TENANTS_ID`) REFERENCES `tenants` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `encryption_key` */

insert  into `encryption_key`(`ID`,`ENCRYPTION_KEY`,`TENANTS_ID`) values (1,'key',2),(2,'key_chevron',3);

/*Table structure for table `server_instance` */

DROP TABLE IF EXISTS `server_instance`;

CREATE TABLE `server_instance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `DB_INSTANCE_MAX` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `server_instance` */

insert  into `server_instance`(`ID`,`NAME`,`DB_INSTANCE_MAX`) values (1,'Server 1',5),(2,'Server 2',5);

/*Table structure for table `tenants` */

DROP TABLE IF EXISTS `tenants`;

CREATE TABLE `tenants` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `ADRESS` varchar(255) DEFAULT NULL,
  `PHONE` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `FAX` varchar(45) DEFAULT NULL,
  `L10N_ID` int(11) DEFAULT NULL,
  `ALIAS` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tenants` */

insert  into `tenants`(`ID`,`NAME`,`ADRESS`,`PHONE`,`EMAIL`,`FAX`,`L10N_ID`,`ALIAS`) values (1,'DEFAULT_TENANT',NULL,NULL,NULL,NULL,NULL,'demo'),(2,'Tenant 1',NULL,NULL,NULL,NULL,NULL,'gramedia'),(3,'Tenant 2',NULL,NULL,NULL,NULL,NULL,'chevron');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
