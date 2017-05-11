-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: qg_db
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `qg_comments`
--

DROP TABLE IF EXISTS `qg_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `affiliation_footprint` int(11) DEFAULT NULL,
  `affiliation_user` int(11) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `like` int(11) DEFAULT NULL,
  `unlike` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `affiliation_footprint_idx` (`affiliation_footprint`),
  KEY `affiliation_user_idx` (`affiliation_user`),
  CONSTRAINT `affiliation_footprint6` FOREIGN KEY (`affiliation_footprint`) REFERENCES `qg_footprint` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `affiliation_user7` FOREIGN KEY (`affiliation_user`) REFERENCES `qg_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_comments`
--

LOCK TABLES `qg_comments` WRITE;
/*!40000 ALTER TABLE `qg_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `qg_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qg_footprint`
--

DROP TABLE IF EXISTS `qg_footprint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_footprint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `affiliation_user` int(11) NOT NULL,
  `like_amount` int(11) DEFAULT '0',
  `comments_amount` int(11) DEFAULT '0',
  `read_amount` int(11) DEFAULT '0',
  `name` varchar(30) NOT NULL,
  `country` varchar(50) NOT NULL,
  `province` varchar(30) NOT NULL,
  `state` int(11) DEFAULT '1',
  `describe1` text NOT NULL,
  `describe2` text NOT NULL,
  `describe3` text NOT NULL,
  `describe4` text NOT NULL,
  `describe5` text NOT NULL,
  `describe6` text NOT NULL,
  `image1` text,
  `image2` text,
  `image3` text,
  `image4` text,
  `image5` text,
  `image6` text,
  `start_date` varchar(20) DEFAULT NULL,
  `end_date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`,`start_date`,`end_date`),
  KEY `affiliation_user_idx` (`affiliation_user`),
  CONSTRAINT `affiliation_user1` FOREIGN KEY (`affiliation_user`) REFERENCES `qg_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_footprint`
--

LOCK TABLES `qg_footprint` WRITE;
/*!40000 ALTER TABLE `qg_footprint` DISABLE KEYS */;
INSERT INTO `qg_footprint` VALUES (1,21,321,123,213,'大理','中国','云南',1,'describe1','describe2','describe3','describe4','describe5','describe6','','','','','','','2017-5-11','2017-5-12'),(2,21,0,0,0,'南京','中国','河山',3,'describe1','describe2','describe3','describe4','describe5','describe6','','','','','','','2017/05/11','2017/05/11'),(3,1,0,0,0,'成都','中国','河山',2,'describe1','describe2','describe3','describe4','describe5','describe6','','','','','','','1993/05/11','2017/05/11'),(4,21,0,0,0,'西双版纳','中国','河山',0,'describe1','describe2','describe3','describe4','describe5','describe6','','','','','','','2018/05/11','2019/05/11');
/*!40000 ALTER TABLE `qg_footprint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qg_invite_code`
--

DROP TABLE IF EXISTS `qg_invite_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_invite_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `invite_code` varchar(16) NOT NULL,
  `remaining_times` int(11) NOT NULL DEFAULT '8',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_invite_code`
--

LOCK TABLES `qg_invite_code` WRITE;
/*!40000 ALTER TABLE `qg_invite_code` DISABLE KEYS */;
INSERT INTO `qg_invite_code` VALUES (1,'11111111111',8),(2,'ABCDEDCBA',9);
/*!40000 ALTER TABLE `qg_invite_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qg_label`
--

DROP TABLE IF EXISTS `qg_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `content_UNIQUE` (`content`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_label`
--

LOCK TABLES `qg_label` WRITE;
/*!40000 ALTER TABLE `qg_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `qg_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qg_notifications`
--

DROP TABLE IF EXISTS `qg_notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_notifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `affiliation_user` int(11) NOT NULL,
  `time` varchar(20) NOT NULL,
  `state` int(11) DEFAULT '1',
  `content` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `affiliation_user_idx` (`affiliation_user`),
  CONSTRAINT `affiliation_user8` FOREIGN KEY (`affiliation_user`) REFERENCES `qg_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_notifications`
--

LOCK TABLES `qg_notifications` WRITE;
/*!40000 ALTER TABLE `qg_notifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `qg_notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qg_scenic_spots`
--

DROP TABLE IF EXISTS `qg_scenic_spots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_scenic_spots` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `country` varchar(50) NOT NULL,
  `province` varchar(30) NOT NULL,
  `brief_introduction` text NOT NULL,
  `folk_culture` text NOT NULL,
  `feature` text NOT NULL,
  `official_comments` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`,`country`,`province`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_scenic_spots`
--

LOCK TABLES `qg_scenic_spots` WRITE;
/*!40000 ALTER TABLE `qg_scenic_spots` DISABLE KEYS */;
/*!40000 ALTER TABLE `qg_scenic_spots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qg_scenic_spots2label_mapping`
--

DROP TABLE IF EXISTS `qg_scenic_spots2label_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_scenic_spots2label_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `affiliation_scenic_spots` int(11) NOT NULL,
  `affiliation_label` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `affiliation_scenic_spots` (`affiliation_scenic_spots`,`affiliation_label`),
  KEY `affiliation_label99` (`affiliation_label`),
  CONSTRAINT `affiliation_label99` FOREIGN KEY (`affiliation_label`) REFERENCES `qg_label` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `affiliation_scenic_spots9` FOREIGN KEY (`affiliation_scenic_spots`) REFERENCES `qg_scenic_spots` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_scenic_spots2label_mapping`
--

LOCK TABLES `qg_scenic_spots2label_mapping` WRITE;
/*!40000 ALTER TABLE `qg_scenic_spots2label_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `qg_scenic_spots2label_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qg_user`
--

DROP TABLE IF EXISTS `qg_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(10) NOT NULL,
  `real_name` varchar(20) NOT NULL,
  `email` varchar(320) DEFAULT NULL,
  `phone_number` varchar(11) DEFAULT NULL,
  `id_card_no` varchar(18) DEFAULT NULL,
  `register_time` varchar(20) NOT NULL,
  `register_order` int(11) NOT NULL,
  `meaning_of_trip` varchar(40) DEFAULT NULL,
  `head_icon` varchar(45) DEFAULT '0',
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  UNIQUE KEY `id_card_no_UNIQUE` (`id_card_no`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_user`
--

LOCK TABLES `qg_user` WRITE;
/*!40000 ALTER TABLE `qg_user` DISABLE KEYS */;
INSERT INTO `qg_user` VALUES (1,'木格窗','叶明','nandem@126.com','13551274792','320123199304014811','2017-05-09 03:45:04',0,'你离开我，就是旅行的意义','','nandem123'),(2,'1','1','1','1','1','2017-05-10 01:20:20',1,'1','','1'),(5,'李塔嘛','李刚','tamali@126.com','12312312312','123123123123123123','2017-05-10 01:25:11',2,'离家出走棒棒棒','','litama123'),(21,'我的虚幻岁月','叶明','291025394@qq.com','17628291886','320123199304094811','2017-05-10 02:19:04',3,'向来心是看客心，奈何人是剧中人。','','cjwl19930401'),(22,'你好啊','叶明','menya@126.com','12345678900','320123199303084811','2017-05-10 13:59:53',4,'我是超人','','cjwl19930401'),(23,'a','a','a','a','a','2017-05-10 14:12:14',5,'a','','a');
/*!40000 ALTER TABLE `qg_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qg_user2label_mapping`
--

DROP TABLE IF EXISTS `qg_user2label_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_user2label_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `affiliation_user` int(11) NOT NULL,
  `affiliation_label` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `affiliation_user` (`affiliation_user`,`affiliation_label`),
  KEY `affiliation_label3` (`affiliation_label`),
  CONSTRAINT `affiliation_label3` FOREIGN KEY (`affiliation_label`) REFERENCES `qg_label` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `affiliation_user2` FOREIGN KEY (`affiliation_user`) REFERENCES `qg_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_user2label_mapping`
--

LOCK TABLES `qg_user2label_mapping` WRITE;
/*!40000 ALTER TABLE `qg_user2label_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `qg_user2label_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qg_user_relationship`
--

DROP TABLE IF EXISTS `qg_user_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qg_user_relationship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_follow` int(11) NOT NULL,
  `user_be_followed` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_be_followed` (`user_be_followed`,`user_follow`),
  KEY `user_follow4` (`user_follow`),
  CONSTRAINT `user_be_followed5` FOREIGN KEY (`user_be_followed`) REFERENCES `qg_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_follow4` FOREIGN KEY (`user_follow`) REFERENCES `qg_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qg_user_relationship`
--

LOCK TABLES `qg_user_relationship` WRITE;
/*!40000 ALTER TABLE `qg_user_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `qg_user_relationship` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-11 19:34:58
