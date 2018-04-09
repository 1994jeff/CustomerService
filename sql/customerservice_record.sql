-- MySQL dump 10.13  Distrib 5.6.33, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: customerservice
-- ------------------------------------------------------
-- Server version	5.6.33-0ubuntu0.14.04.1

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
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `record_no` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `user_no` varchar(45) NOT NULL,
  `apply_name` varchar(45) NOT NULL,
  `apply_mobile` varchar(45) NOT NULL,
  `reason` text NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(45) DEFAULT '',
  PRIMARY KEY (`id`,`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,'1','1','1','Jeff','30','NO REASON','0','2018-03-08 22:13:25','2018-04-08 22:13:25','2018-03-12'),(2,'2','0','1','Jeff','18557522805','haha,I like','1','2018-04-08 22:13:25','2018-04-08 22:13:25',''),(3,'3','1','2','deng','10086','nonono','1','2018-04-08 22:13:25','2018-04-08 22:13:25',''),(4,'4','0','1','jeff','dasd','dsds','0','2018-04-09 20:28:56','2018-04-09 20:28:56',''),(5,'RN2018040922112900001','0','1','Jeff','','试一试','1','2018-04-09 22:11:29',NULL,NULL),(6,'RN2018040922140000002','0','1','Jeff','','试一试','0','2018-04-09 22:14:00',NULL,NULL),(7,'RN2018040922140300003','0','1','Jeff','','试一试','0','2018-04-09 22:14:03',NULL,NULL),(8,'RN2018040922142400004','0','1','Jeff','','试一试','0','2018-04-09 22:14:24',NULL,NULL),(9,'RN2018040922143300005','0','1','Jeff','','试一试','0','2018-04-09 22:14:33',NULL,NULL),(10,'RN2018040922143500006','0','1','Jeff','','试一试','0','2018-04-09 22:14:35',NULL,NULL),(11,'RN2018040922164900007','0','1','Jeff','','试一试','0','2018-04-09 22:16:49',NULL,NULL),(12,'RN2018040922165200008','0','1','Jeff','','试一试','0','2018-04-09 22:16:52',NULL,NULL),(13,'RN2018040922171600009','0','1','Jeff','','试一试','0','2018-04-09 22:17:16',NULL,NULL),(14,'RN2018040922171800010','0','1','Jeff','','试一试','0','2018-04-09 22:17:18',NULL,NULL),(15,'RN2018040922171900011','0','1','Jeff','','试一试','0','2018-04-09 22:17:20',NULL,NULL),(16,'RN2018040922172100012','0','1','Jeff','','试一试','0','2018-04-09 22:17:21',NULL,NULL),(17,'RN2018040922562700001','0','1','Jeff','','额度','0','2018-04-09 22:56:27',NULL,NULL),(18,'RN2018040922564900002','0','1','Jeff','','12','0','2018-04-09 22:56:49',NULL,NULL),(19,'RN2018040922570200003','0','1','Jeff','','，，，','0','2018-04-09 22:57:02',NULL,NULL);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-09 23:07:28
