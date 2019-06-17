-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: newlibrary
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auditrecord`
--

DROP TABLE IF EXISTS `auditrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `auditrecord` (
  `auditid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(45) NOT NULL,
  `auditmsg` varchar(45) NOT NULL,
  `auditdate` datetime NOT NULL,
  `audituser` varchar(45) NOT NULL,
  PRIMARY KEY (`auditid`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditrecord`
--

LOCK TABLES `auditrecord` WRITE;
/*!40000 ALTER TABLE `auditrecord` DISABLE KEYS */;
INSERT INTO `auditrecord` VALUES (2,'Wings of fire','Book added successfully','2019-06-17 11:50:45','admin'),(3,'Wings of fire','Book added successfully','2019-06-17 11:52:26','admin'),(4,'Wings of fire','Book added successfully','2019-06-17 11:55:31','admin'),(5,'Wings of fire','Book added successfully','2019-06-17 11:57:49','admin'),(6,'Wings of fire on road','Book updated successfully','2019-06-17 11:59:03','admin'),(7,'prisha','Book added successfully','2019-06-17 12:16:50','admin'),(8,'prisha','Book deleted successfully','2019-06-17 12:17:36','admin'),(11,'Wings of fire','Book requested by the user','2019-06-17 12:37:59','user id=36'),(12,'Wings of fire','Book requested by the user','2019-06-17 12:44:23','user id=36'),(13,'Wings of fire','Book not issued to user','2019-06-17 12:48:52','admin'),(14,'Wings of fire','Book issued to user','2019-06-17 12:49:16','admin'),(15,'tiger','Book added successfully','2019-06-17 12:54:31','admin'),(16,'prisha','Book added successfully','2019-06-17 12:55:21','admin'),(17,'Tiger','Book requested by the user','2019-06-17 13:01:15','user id=36'),(18,'Wings of fire','Book requested by the user','2019-06-17 13:02:04','user id=36'),(19,'Tiger','Book issued to user','2019-06-17 13:02:53','admin'),(20,'Wings of fire','Book not issued to user','2019-06-17 13:06:15','admin'),(21,'Tiger','Book requested by the user','2019-06-17 13:10:05','user id=36'),(22,'tiger','Book requested by the user','2019-06-17 13:10:23','user id=36'),(23,'Wings of fire','Book added successfully','2019-06-17 13:41:39','admin'),(24,'Wings of fire','Book added successfully','2019-06-17 13:42:09','admin'),(25,'Wings of fire','Book added successfully','2019-06-17 13:43:51','admin'),(26,'Wings of fire','Book added successfully','2019-06-17 13:51:46','admin'),(27,'Wings of fire','Book requested by the user','2019-06-17 14:03:06','user id=36'),(28,'prisha','Book requested by the user','2019-06-17 14:16:18','user id=36'),(29,'Tiger','Book issued to user','2019-06-17 14:18:47','admin'),(30,'Tiger','Book returned by user','2019-06-17 14:21:18','user id=36'),(31,'Tiger','Book requested by the user','2019-06-17 14:22:35','user id=36'),(32,'Tiger','Book issued to user','2019-06-17 14:23:16','admin'),(33,'Tiger','Book returned by user','2019-06-17 14:23:57','user id=36'),(34,'Wings of fire','Book issued to user','2019-06-17 14:25:56','admin'),(35,'Wings of fire','Book returned by user','2019-06-17 14:26:41','user id=36'),(36,'Testing','Book added successfully','2019-06-17 14:30:52','admin'),(37,'Testing','Book updated successfully','2019-06-17 14:33:10','admin'),(38,'Testing','Book updated successfully','2019-06-17 14:33:20','admin'),(39,'Testing','Book deleted successfully','2019-06-17 14:33:54','admin'),(40,'tiger','Book issued to user','2019-06-17 14:34:22','admin'),(41,'prisha','Book not issued to user','2019-06-17 14:34:26','admin'),(42,'Tiger','Book requested by the user','2019-06-17 15:12:36','user id=36'),(43,'Wings of fire','Book requested by the user','2019-06-17 15:12:41','user id=36'),(44,'prisha','Book requested by the user','2019-06-17 15:12:46','user id=36'),(45,'tiger','Book requested by the user','2019-06-17 15:12:52','user id=36'),(46,'Tiger','Book issued to user','2019-06-17 15:13:56','admin'),(47,'Wings of fire','Book issued to user','2019-06-17 15:14:00','admin'),(48,'tiger','Book issued to user','2019-06-17 15:25:14','admin'),(49,'prisha','Book not issued to user','2019-06-17 15:30:06','admin'),(50,'tiger','Book returned by user','2019-06-17 15:31:59','user id=36'),(51,'Tiger','Book returned by user','2019-06-17 15:32:07','user id=36'),(52,'Wings of fire','Book returned by user','2019-06-17 15:32:09','user id=36'),(53,'Tiger','Book updated successfully','2019-06-17 15:46:09','admin'),(54,'Wings of fire','Book added successfully','2019-06-17 17:05:01','admin'),(55,'Wings of fire','Book updated successfully','2019-06-17 17:24:01','admin'),(56,'Wings of fire','Book updated successfully','2019-06-17 17:26:36','admin'),(57,'Wings of fire','Book updated successfully','2019-06-17 17:30:50','admin'),(58,'Wings of fire','Book updated successfully','2019-06-17 17:37:03','admin'),(59,'Wings of fire','Book updated successfully','2019-06-17 17:37:17','admin'),(60,'Wings of fire','Book updated successfully','2019-06-17 17:44:37','admin'),(61,'Wings of fire','Book updated successfully','2019-06-17 17:46:18','admin'),(62,'Wings of fire','Book updated successfully','2019-06-17 17:48:13','admin'),(63,'efrsa','Book added successfully','2019-06-17 17:49:39','admin'),(64,'Preethi','Book updated successfully','2019-06-17 17:50:42','admin'),(65,'Wings of fire','Book requested by the user','2019-06-17 17:51:32','user id=36'),(66,'Preethi','Book requested by the user','2019-06-17 17:54:21','user id=36'),(67,'tiger','Book requested by the user','2019-06-17 17:59:34','user id=36'),(68,'Wings of fire','Book issued to user','2019-06-17 18:00:32','admin'),(69,'Preethi','Book not issued to user','2019-06-17 18:00:53','admin'),(70,'Preethi','Book deleted successfully','2019-06-17 18:02:19','admin'),(71,'Wings of fire','Book updated successfully','2019-06-17 18:02:29','admin'),(72,'tiger','Book not issued to user','2019-06-17 18:02:49','admin'),(73,'Wings of fire','Book requested by the user','2019-06-17 18:06:53','user id=36'),(74,'prisha','Book requested by the user','2019-06-17 18:06:57','user id=36'),(75,'Wings of fire','Book requested by the user','2019-06-17 18:07:02','user id=36'),(76,'Wings of fire','Book returned by user','2019-06-17 18:09:06','user id=36'),(77,'Wings of fire','Book issued to user','2019-06-17 18:10:36','admin'),(78,'Wings of fire','Book issued to user','2019-06-17 18:12:57','admin'),(79,'prisha','Book not issued to user','2019-06-17 18:13:09','admin'),(80,'Wings of fire','Book returned by user','2019-06-17 18:13:39','user id=36'),(81,'Tiger','Book requested by the user','2019-06-17 18:13:55','user id=36'),(82,'Wings of fire','Book requested by the user','2019-06-17 18:15:12','user id=36');
/*!40000 ALTER TABLE `auditrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `bookid` int(10) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `noofcopies` int(11) NOT NULL,
  `available` int(11) NOT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Tiger','life of tiger','Preethi',150,'sangam',2,2),(63,'Wings of fire','geeni book','Preethi',450,'SANGAM',4,3),(68,'tiger','geeni book','Preethi',450,'SANGAM',2,2),(69,'prisha','asfsafsah','Preethi',120,'sangam',2,2),(74,'Wings of fire','sdfs','hgjhkh',10,'sfsf',2,2);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_issued`
--

DROP TABLE IF EXISTS `book_issued`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book_issued` (
  `issueid` int(10) NOT NULL AUTO_INCREMENT,
  `iuserid` int(10) NOT NULL,
  `ibookid` int(10) NOT NULL,
  PRIMARY KEY (`issueid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_issued`
--

LOCK TABLES `book_issued` WRITE;
/*!40000 ALTER TABLE `book_issued` DISABLE KEYS */;
INSERT INTO `book_issued` VALUES (22,36,63);
/*!40000 ALTER TABLE `book_issued` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_request`
--

DROP TABLE IF EXISTS `book_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book_request` (
  `requestid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) NOT NULL,
  `bookid` int(10) NOT NULL,
  PRIMARY KEY (`requestid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_request`
--

LOCK TABLES `book_request` WRITE;
/*!40000 ALTER TABLE `book_request` DISABLE KEYS */;
INSERT INTO `book_request` VALUES (39,36,1),(40,36,63);
/*!40000 ALTER TABLE `book_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookstatus`
--

DROP TABLE IF EXISTS `bookstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bookstatus` (
  `statusid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `bookname` varchar(45) NOT NULL,
  `bookstatus` varchar(45) NOT NULL,
  `statusdate` datetime NOT NULL,
  `updatedby` varchar(45) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookstatus`
--

LOCK TABLES `bookstatus` WRITE;
/*!40000 ALTER TABLE `bookstatus` DISABLE KEYS */;
INSERT INTO `bookstatus` VALUES (1,68,'tiger','Book issued by admin','2019-06-17 15:25:14','admin',36),(2,69,'prisha','Book rejected by admin..not issued','2019-06-17 15:30:06','admin',36),(3,74,'Wings of fire','Book issued by admin','2019-06-17 18:00:32','admin',36),(4,75,'Preethi','Book rejected by admin..not issued','2019-06-17 18:00:53','admin',36),(5,68,'tiger','Book rejected by admin..not issued','2019-06-17 18:02:49','admin',36),(6,74,'Wings of fire','Book issued by admin','2019-06-17 18:10:35','admin',36),(7,63,'Wings of fire','Book issued by admin','2019-06-17 18:12:56','admin',36),(8,69,'prisha','Book rejected by admin..not issued','2019-06-17 18:13:09','admin',36);
/*!40000 ALTER TABLE `bookstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registration` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `contact` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (1,'preethi','preethi@gmail.com','preethi','7829573723','admin'),(3,'prisha','prisha@gmail.com','prisha','7829573723','user'),(4,'avi','avi@gmail.com','avi','9738873983','user'),(5,'avi','avi@gmail.com','avi','9738873983','user'),(28,'prishaj','fsafdf@gmail.com','preethi','7829573723','user'),(29,'7878','tina@centelon.com','123456','dfgffgf','user'),(30,'preethi avinash','preethi@gmail.com','pre','7829573723','user'),(31,'prisha','preethi11@gmail.com','pre','9738873983','user'),(32,'prisha','prisha111@gmail.com','pre','345','user'),(33,'preethi avinash','preet1hi@gmail.com','pre','111','user'),(34,'preethi avinash','preethi1811@gmail.com','pre','5428545854','user'),(35,'preethi avinash','preesdfdsthi@gmail.com','pre','43','user'),(36,'preethi avinash','prisha@gmail.com','pre','4353585478','user'),(37,'sfsdfsd','sdfs@gmail.com','sdfs','7829573723','user');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-17 18:43:39
