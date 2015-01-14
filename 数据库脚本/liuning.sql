-- MySQL dump 10.13  Distrib 5.7.3-m13, for Win64 (x86_64)
--
-- Host: localhost    Database: liuning
-- ------------------------------------------------------
-- Server version	5.7.3-m13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `AdminName` varchar(30) NOT NULL,
  `AdminPassword` varchar(20) NOT NULL,
  `IsLock` varchar(2) NOT NULL,
  `AdminType` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','admin','1','administrator'),('admin1','admin1','0','commonadmin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computer`
--

DROP TABLE IF EXISTS `computer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computer` (
  `ComId` int(11) NOT NULL AUTO_INCREMENT,
  `ComNum` varchar(20) NOT NULL,
  `OnUser` varchar(2) NOT NULL,
  `ComType` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ComId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computer`
--

LOCK TABLES `computer` WRITE;
/*!40000 ALTER TABLE `computer` DISABLE KEYS */;
INSERT INTO `computer` VALUES (1,'001','否','高级'),(2,'002','是','高级'),(3,'003','是','高级'),(4,'004','否','高级'),(5,'005','否','高级'),(6,'006','否','高级'),(7,'007','否','高级'),(8,'008','否','高级'),(9,'009','否','高级'),(10,'010','否','高级'),(11,'011','否','普通'),(12,'012','否','普通'),(13,'013','否','普通'),(14,'014','否','普通'),(15,'015','否','普通'),(16,'016','否','普通'),(17,'017','否','普通'),(18,'018','否','普通'),(19,'019','否','普通'),(20,'020','否','普通');
/*!40000 ALTER TABLE `computer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consume`
--

DROP TABLE IF EXISTS `consume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consume` (
  `ConId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `ComId` int(11) NOT NULL,
  `BeginTime` varchar(20) DEFAULT NULL,
  `EndTime` varchar(20) DEFAULT NULL,
  `LeftMoney` float DEFAULT NULL,
  PRIMARY KEY (`ConId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consume`
--

LOCK TABLES `consume` WRITE;
/*!40000 ALTER TABLE `consume` DISABLE KEYS */;
INSERT INTO `consume` VALUES (1,1,1,'22:20','23:20',30);
/*!40000 ALTER TABLE `consume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ln_admin`
--

DROP TABLE IF EXISTS `ln_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ln_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admincard` varchar(20) DEFAULT NULL,
  `adminpass` varchar(10) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `rate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ln_admin`
--

LOCK TABLES `ln_admin` WRITE;
/*!40000 ALTER TABLE `ln_admin` DISABLE KEYS */;
INSERT INTO `ln_admin` VALUES (1,'admin','admin','unlock','3.0'),(4,'liuning','liuning','unlock',NULL),(8,'system','sy','unlock',NULL),(9,'caoheng','caoheng','unlock',NULL);
/*!40000 ALTER TABLE `ln_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ln_backuprecord`
--

DROP TABLE IF EXISTS `ln_backuprecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ln_backuprecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(5) DEFAULT NULL,
  `month` varchar(3) DEFAULT NULL,
  `day` varchar(3) DEFAULT NULL,
  `usercard` varchar(20) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `consume` decimal(10,3) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `duraTime` varchar(20) DEFAULT NULL,
  `overTime` datetime DEFAULT NULL,
  `hostnumber` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ln_backuprecord`
--

LOCK TABLES `ln_backuprecord` WRITE;
/*!40000 ALTER TABLE `ln_backuprecord` DISABLE KEYS */;
INSERT INTO `ln_backuprecord` VALUES (1,'2014','01','01','1','1',14.500,'2014-12-29 13:10:15','01:00','2015-01-04 13:10:26','101'),(2,'2014','02','01','1','1',1.000,'2014-12-30 13:10:52','01:00','2014-12-29 13:11:01','102'),(3,'2014','02','01','1','1',1.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(4,'2014','03','01','1','1',1.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(5,'2014','03','01','1','1',2.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(6,'2014','03','01','1','1',1.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(7,'2014','04','01','1','1',2.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(8,'2014','04','01','1','1',1.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(9,'2014','06','01','1','1',3.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(10,'2014','04','01','1','1',1.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(11,'2014','04','01','1','1',4.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(12,'2014','05','01','1','1',2.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(13,'2014','05','01','1','1',3.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(14,'2014','05','01','1','1',4.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(15,'2014','05','01','1','1',6.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(16,'2014','06','01','1','1',7.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(17,'2014','06','01','1','1',8.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(18,'2014','06','01','1','1',5.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(19,'2014','06','01','1','1',7.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(20,'2014','07','01','1','1',11.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(21,'2014','07','01','1','1',1.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(22,'2014','07','01','1','1',11.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(23,'2014','07','01','1','1',21.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(24,'2014','08','01','1','1',23.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(25,'2014','08','01','1','1',1.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(26,'2014','08','01','1','1',2.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(27,'2014','09','01','1','1',3.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(28,'2014','09','01','1','1',1.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(29,'2014','10','01','1','1',2.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(30,'2014','10','01','1','1',1.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(31,'2014','11','01','1','1',2.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(32,'2014','11','01','1','1',3.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(33,'2014','12','01','1','1',4.000,'2014-12-30 13:11:18','02:00','2014-12-31 13:11:28','103'),(78,'2015','10','1','05006','符文阿飞',0.000,'2015-01-10 23:45:49','00:00:07','2015-01-10 23:45:58','101'),(79,'2015','10','1','05006','符文阿飞',0.012,'2015-01-10 23:46:55','00:00:23','2015-01-10 23:47:20','101'),(80,'2015','10','1','05006','符文阿飞',0.012,'2015-01-10 23:48:12','00:00:23','2015-01-10 23:48:36','101'),(81,'2015','10','1','05006','符文阿飞',0.000,'2015-01-10 23:48:58','00:00:02','2015-01-10 23:49:02','101'),(82,'2015','11','1','05011','曹恒恒',0.018,'2015-01-11 00:04:43','00:00:36','2015-01-11 00:05:21','101'),(83,'2015','11','1','05006','符文阿飞',0.012,'2015-01-11 00:06:04','00:00:23','2015-01-11 00:06:28','101'),(84,'2015','11','1','05002','李海南',0.036,'2015-01-11 11:05:19','00:01:12','2015-01-11 11:06:30','101'),(85,'2015','11','1','05002','李海南',0.018,'2015-01-11 11:08:34','00:00:36','2015-01-11 11:09:10','103');
/*!40000 ALTER TABLE `ln_backuprecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ln_computer`
--

DROP TABLE IF EXISTS `ln_computer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ln_computer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hostnumber` varchar(6) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `usercard` varchar(20) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ln_computer`
--

LOCK TABLES `ln_computer` WRITE;
/*!40000 ALTER TABLE `ln_computer` DISABLE KEYS */;
INSERT INTO `ln_computer` VALUES (1,'101',NULL,NULL,'offline'),(2,'102','赵凯','05007','online'),(3,'103',NULL,NULL,'offline'),(4,'104','','','offline'),(5,'105','','','offline'),(6,'106','','','offline'),(7,'107','','','offline'),(8,'108','黄源','05008','online'),(9,'109','岳文','05009','online'),(10,'110','刘宁','05010','online'),(11,'111',NULL,NULL,'offline'),(12,'112',NULL,NULL,'offline'),(13,'113',NULL,NULL,'offline'),(14,'114','','','offline'),(15,'115','','','offline'),(16,'116',NULL,NULL,'offline'),(17,'117','','','offline'),(18,'118',NULL,NULL,'offline'),(19,'119',NULL,NULL,'offline'),(20,'120',NULL,NULL,'offline'),(21,'121','','','offline'),(22,'122',NULL,NULL,'offline'),(23,'123',NULL,NULL,'offline'),(24,'124',NULL,NULL,'offline'),(25,'125',NULL,NULL,'offline'),(26,'126','','','offline');
/*!40000 ALTER TABLE `ln_computer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ln_currentrecord`
--

DROP TABLE IF EXISTS `ln_currentrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ln_currentrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usercard` varchar(20) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `duratime` varchar(10) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `currentCost` decimal(10,3) DEFAULT NULL,
  `hostnumber` varchar(6) DEFAULT NULL,
  `expectBanlance` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ln_currentrecord`
--

LOCK TABLES `ln_currentrecord` WRITE;
/*!40000 ALTER TABLE `ln_currentrecord` DISABLE KEYS */;
INSERT INTO `ln_currentrecord` VALUES (2,'05007','赵凯','06:34:00','2015-01-05 19:56:38',20.065,'102',63.204),(4,'05008','黄源','06:34:38','2015-01-05 19:57:38',32.065,'108',43.204),(5,'05009','岳文','06:33:12','2015-01-05 20:02:53',3.665,'109',33.204),(6,'05010','刘宁','06:34:12','2015-01-05 21:18:34',2.365,'110',3.204);
/*!40000 ALTER TABLE `ln_currentrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ln_user`
--

DROP TABLE IF EXISTS `ln_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ln_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usercard` varchar(20) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `banlace` decimal(10,3) DEFAULT NULL,
  `licenceNumber` varchar(18) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `phoneNumber` varchar(11) DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  `userState` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ln_user`
--

LOCK TABLES `ln_user` WRITE;
/*!40000 ALTER TABLE `ln_user` DISABLE KEYS */;
INSERT INTO `ln_user` VALUES (1,'05002','123',20.946,'371324199303071522','男','李海南','183','2015-01-05 20:31:18','offline'),(2,'05006','123',0.998,'371324214817248721','男','郭衍序','15165563943','2015-01-06 20:32:35','offline'),(3,'05007','123',80.000,'321341','男','赵凯','18369905103','2015-01-09 22:05:15','online'),(4,'05008','123',60.000,'1244151','男','黄源','183699','2015-01-09 22:06:12','online'),(5,'05009','123',50.000,'371324214124124412','男','岳文','183699','2015-01-09 22:07:03','online'),(6,'05010','123',80.000,'124412435233145124','男','刘宁','18369977312','2015-01-09 22:07:47','online'),(20,'05011','123',109.982,'3251535161523215','男','曹恒恒','18369905139','2015-01-10 23:50:19','offline'),(21,'05012','yiCdKP',100.000,'372941278626412641','女','刘爱红','18369905203','2015-01-11 16:36:17','offline');
/*!40000 ALTER TABLE `ln_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_article`
--

DROP TABLE IF EXISTS `tb_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeId` int(11) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `content` varchar(20000) DEFAULT NULL,
  `phTime` varchar(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_article`
--

LOCK TABLES `tb_article` WRITE;
/*!40000 ALTER TABLE `tb_article` DISABLE KEYS */;
INSERT INTO `tb_article` VALUES (1,1,'无题小记','今天准备敲代码了，做网吧管理系统','2015年1月1日 星期四',0),(2,1,'敲代码1','敲代码2','2015年1月1日 星期四',0),(3,2,'黄源敲代码2','黄源敲代码2','2015年1月1日 星期四',0);
/*!40000 ALTER TABLE `tb_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_articletype`
--

DROP TABLE IF EXISTS `tb_articletype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_articletype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_articletype`
--

LOCK TABLES `tb_articletype` WRITE;
/*!40000 ALTER TABLE `tb_articletype` DISABLE KEYS */;
INSERT INTO `tb_articletype` VALUES (1,'生活日记','记录生活中的点滴'),(2,'周记','一周以内的值得一提的事情'),(3,'大数运算','ACM训练'),(4,'基本算法','基本算法'),(5,'技术类文章','技术类文章'),(6,'数据结构','数据结构中的算法题解'),(7,'图算法','图算法'),(8,'编程代码','编程代码'),(9,'ACM的学习经历','ACM的学习经历'),(10,'学习笔记','学习笔记'),(11,'面试题','面试题'),(12,'C++ practice','C++ practice'),(13,'Linux(1)','Linux(1)'),(14,'Sublime Text','Sublime Text'),(15,'简单搜索(4)','简单搜索(4)'),(16,'数据结构—串(1)','数据结构—串(1)');
/*!40000 ALTER TABLE `tb_articletype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_consumer`
--

DROP TABLE IF EXISTS `tb_consumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_consumer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `QQNumber` varchar(12) DEFAULT NULL,
  `mainPage` varchar(50) DEFAULT NULL,
  `interest` varchar(100) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `manageLevel` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_consumer`
--

LOCK TABLES `tb_consumer` WRITE;
/*!40000 ALTER TABLE `tb_consumer` DISABLE KEYS */;
INSERT INTO `tb_consumer` VALUES (1,'tsoft','12345','刘宁','男','1127746065','lnblog.net','敲代码','ewfaew@QQ.com','高级');
/*!40000 ALTER TABLE `tb_consumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_discuss`
--

DROP TABLE IF EXISTS `tb_discuss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_discuss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discussTitle` varchar(500) DEFAULT NULL,
  `discussContent` varchar(20000) DEFAULT NULL,
  `discussTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_discuss`
--

LOCK TABLES `tb_discuss` WRITE;
/*!40000 ALTER TABLE `tb_discuss` DISABLE KEYS */;
INSERT INTO `tb_discuss` VALUES (1,'实验报告','实验报告必须在周四之前上交，老师要公布成绩','2015年1月1日 星期四'),(2,'元旦放假','元旦从明天开始放假，祝愿大家新年快乐','2015年1月1日 星期四'),(3,'实训','本周周末放假回来之后实训照常进行。','2015年1月1日 星期四'),(4,'网吧管理','网吧管理系统到底怎么做呀！','2015年1月1日 星期四');
/*!40000 ALTER TABLE `tb_discuss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_friend`
--

DROP TABLE IF EXISTS `tb_friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `QQNumber` varchar(20) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_friend`
--

LOCK TABLES `tb_friend` WRITE;
/*!40000 ALTER TABLE `tb_friend` DISABLE KEYS */;
INSERT INTO `tb_friend` VALUES (1,'黄源','1123341231','喜欢敲代码'),(2,'刘爱红','2141323412','爱卖萌2'),(3,'aaa','2141323412','不知道'),(4,'bbb','323141221','不知道too');
/*!40000 ALTER TABLE `tb_friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_photo`
--

DROP TABLE IF EXISTS `tb_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `photoAddress` varchar(50) DEFAULT NULL,
  `photoDescription` varchar(500) DEFAULT NULL,
  `phtoTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_photo`
--

LOCK TABLES `tb_photo` WRITE;
/*!40000 ALTER TABLE `tb_photo` DISABLE KEYS */;
INSERT INTO `tb_photo` VALUES (1,'file/0.jpg','qq��ͼ','2015��1��1�� ������'),(2,'file/1.jpg','qq��ͼ2','2015��1��1�� ������');
/*!40000 ALTER TABLE `tb_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_restore`
--

DROP TABLE IF EXISTS `tb_restore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_restore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) DEFAULT NULL,
  `reAccount` varchar(50) DEFAULT NULL,
  `reTitle` varchar(500) DEFAULT NULL,
  `reContent` varchar(20000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_restore`
--

LOCK TABLES `tb_restore` WRITE;
/*!40000 ALTER TABLE `tb_restore` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_restore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_vote`
--

DROP TABLE IF EXISTS `tb_vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `voteName` varchar(500) DEFAULT NULL,
  `voteNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_vote`
--

LOCK TABLES `tb_vote` WRITE;
/*!40000 ALTER TABLE `tb_vote` DISABLE KEYS */;
INSERT INTO `tb_vote` VALUES (1,'黄源爱卖萌',0),(2,'刘爱红爱卖萌',0),(3,'李海南是明星吗',0);
/*!40000 ALTER TABLE `tb_vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `LogName` varchar(30) DEFAULT NULL,
  `Password` varchar(30) DEFAULT NULL,
  `Account` float DEFAULT NULL,
  `UserName` varchar(30) DEFAULT NULL,
  `IdentityId` varchar(30) DEFAULT NULL,
  `UserLevel` varchar(30) DEFAULT NULL,
  `OpenAccountDate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'zhangsan','zhangsan',30,'张三','236598745852365896','普通会员','2008-9-01 \n\n14:39'),(2,'lisi','lisi',30,'李四','236598745852365896','普通会员','2008-9-01 14:39'),(3,'lisi','lisi',30,'李四','236598745852365896','普通会员','2008-9-01 14:39'),(4,'liuer','liuer',30,'刘二','236598745852365896','高级会员','2008-9-01 14:39');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-11 16:55:20
