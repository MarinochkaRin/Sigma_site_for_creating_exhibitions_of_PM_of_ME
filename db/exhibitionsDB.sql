-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: exhibitions
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Author 1','Description for Author 1'),(2,'Author 2','Description for Author 2'),(3,'Author 3','Description for Author 3'),(4,'фваф','віак'),(5,'zsdv','Description for Book 3'),(6,'rjg','zvgdxfbfgbhzs');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (3,'Aircraft Carrier'),(6,'awfwaf'),(2,'Helicopter'),(1,'MBT'),(5,'Publisher1'),(8,'zsdv');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exhibitions`
--

DROP TABLE IF EXISTS `exhibitions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exhibitions` (
  `EXHIBITION_ID` int NOT NULL AUTO_INCREMENT,
  `THEME` varchar(256) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `OPENING_HOUR` time NOT NULL,
  `CLOSING_HOUR` time NOT NULL,
  `TICKET_PRICE` decimal(10,2) NOT NULL,
  `IS_ACTIVE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`EXHIBITION_ID`),
  UNIQUE KEY `THEME` (`THEME`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exhibitions`
--

LOCK TABLES `exhibitions` WRITE;
/*!40000 ALTER TABLE `exhibitions` DISABLE KEYS */;
INSERT INTO `exhibitions` VALUES (1,'Space','2022-10-01','2022-10-30','10:00:00','20:00:00',45.00,1),(2,'Earth','2022-11-01','2022-11-30','10:00:00','20:00:00',40.00,0),(3,'Oceans','2022-12-01','2022-12-30','10:00:00','20:00:00',43.00,0),(4,'Forest','2023-01-01','2023-01-31','09:00:00','18:00:00',34.00,0),(5,'Animals','2023-02-01','2023-02-28','09:00:00','18:00:00',30.00,0),(6,'People','2023-03-01','2023-03-31','09:00:00','18:00:00',28.00,0),(7,'Sky','2023-04-01','2023-04-30','09:00:00','18:00:00',50.00,0),(8,'Mountains','2023-05-01','2023-05-31','09:00:00','18:00:00',32.00,0),(9,'Nature','2023-06-01','2023-06-30','09:00:00','18:00:00',31.00,0),(10,'Rivers','2023-07-01','2023-07-31','09:00:00','18:00:00',47.00,0),(11,'Cities','2023-08-01','2023-08-31','09:00:00','18:00:00',20.00,0),(12,'Big Constructions','2023-09-01','2023-09-30','09:00:00','18:00:00',32.00,0),(13,'Cars','2023-10-01','2023-10-31','09:00:00','18:00:00',35.00,1),(14,'mariarty','2023-05-11','2023-05-19','16:08:00','17:11:00',2.00,1),(15,'Transphormer','2023-05-19','2023-05-25','18:19:00','19:19:00',100.00,0),(16,'Andi','2023-05-26','2023-05-28','09:45:00','20:30:00',120.00,0),(17,'Military art ','2023-05-27','2023-05-31','08:00:00','17:00:00',150.00,1),(18,'Transp','2023-05-19','2023-05-06','18:08:00','18:08:00',120.00,1),(19,'Tank','2023-05-16','2023-05-20','08:20:00','17:20:00',0.00,1),(20,'Avia action','2023-05-27','2023-05-31','15:00:00','18:00:00',0.00,1);
/*!40000 ALTER TABLE `exhibitions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exhibitions_locations`
--

DROP TABLE IF EXISTS `exhibitions_locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exhibitions_locations` (
  `EXHIBITION_ID` int NOT NULL,
  `LOCATION_ID` int NOT NULL,
  KEY `EXHIBITION_ID` (`EXHIBITION_ID`),
  KEY `LOCATION_ID` (`LOCATION_ID`),
  CONSTRAINT `exhibitions_locations_ibfk_1` FOREIGN KEY (`EXHIBITION_ID`) REFERENCES `exhibitions` (`EXHIBITION_ID`) ON DELETE CASCADE,
  CONSTRAINT `exhibitions_locations_ibfk_2` FOREIGN KEY (`LOCATION_ID`) REFERENCES `locations` (`LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exhibitions_locations`
--

LOCK TABLES `exhibitions_locations` WRITE;
/*!40000 ALTER TABLE `exhibitions_locations` DISABLE KEYS */;
INSERT INTO `exhibitions_locations` VALUES (1,1),(1,2),(1,4),(2,3),(2,2),(3,4),(3,1),(4,1),(4,3),(4,2),(5,3),(5,1),(6,4),(7,2),(7,1),(8,2),(8,3),(9,3),(10,2),(11,1),(11,2),(11,3),(11,4),(12,2),(12,3),(13,1),(13,4),(13,2),(14,4),(15,4),(16,1),(17,3),(18,5),(19,5),(20,4);
/*!40000 ALTER TABLE `exhibitions_locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exhibitions_modelss`
--

DROP TABLE IF EXISTS `exhibitions_modelss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exhibitions_modelss` (
  `exhibition_id` int NOT NULL,
  `models_id` int NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`exhibition_id`,`models_id`),
  KEY `book_id` (`models_id`),
  CONSTRAINT `exhibitions_modelss_ibfk_1` FOREIGN KEY (`exhibition_id`) REFERENCES `exhibitions` (`EXHIBITION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exhibitions_modelss`
--

LOCK TABLES `exhibitions_modelss` WRITE;
/*!40000 ALTER TABLE `exhibitions_modelss` DISABLE KEYS */;
INSERT INTO `exhibitions_modelss` VALUES (4,4,1);
/*!40000 ALTER TABLE `exhibitions_modelss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `LOCATION_ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(128) NOT NULL,
  PRIMARY KEY (`LOCATION_ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (2,'Kharkiv Time'),(9,'Kyiv Art'),(7,'Kyiv Art Metro'),(5,'Kyiv Art State'),(1,'Kyiv Collage'),(4,'Lviv Zona'),(3,'Poltava Art');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `models` (
  `id` int NOT NULL AUTO_INCREMENT,
  `scale` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) NOT NULL,
  `pub_house` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
INSERT INTO `models` VALUES (4,'1','M1 Abrams Tank','The M1 Abrams is a main battle tank used by the United States Army.','General Dynamics Land Systems'),(8,'100','F-35 Lightning II','The F-35 Lightning II is a fifth-generation multirole fighter aircraft.','Lockheed Martin'),(9,'10','USS Gerald R. Ford','The USS Gerald R. Ford is an aircraft carrier of the United States Navy.','Huntington Ingalls Industries'),(10,'24','Apache Attack Helicopter','The Apache Attack Helicopter is a versatile rotorcraft.','Boeing'),(11,'0','F-16 Fighting Falcon','The F-16 Fighting Falcon is a highly maneuverable multirole fighter jet.','Lockheed Martin'),(12,'123','HMS Queen Elizabeth','HMS Queen Elizabeth is a Royal Navy aircraft carrier.','Babcock International Group'),(15,'15','Tank','Tank','Paper model'),(16,'12','rjg','zvgdxfbfgbhzs','zavgdzb');
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models_authors`
--

DROP TABLE IF EXISTS `models_authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `models_authors` (
  `book_id` int NOT NULL,
  `author_id` bigint NOT NULL,
  PRIMARY KEY (`book_id`,`author_id`),
  KEY `FK_models_authors_authors` (`author_id`),
  CONSTRAINT `FK_models_authors_authors` FOREIGN KEY (`author_id`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE,
  CONSTRAINT `models_authors_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `models` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models_authors`
--

LOCK TABLES `models_authors` WRITE;
/*!40000 ALTER TABLE `models_authors` DISABLE KEYS */;
INSERT INTO `models_authors` VALUES (9,1),(10,1),(11,1);
/*!40000 ALTER TABLE `models_authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models_categories`
--

DROP TABLE IF EXISTS `models_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `models_categories` (
  `book_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`book_id`,`category_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `models_categories_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `models` (`id`) ON DELETE CASCADE,
  CONSTRAINT `models_categories_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models_categories`
--

LOCK TABLES `models_categories` WRITE;
/*!40000 ALTER TABLE `models_categories` DISABLE KEYS */;
INSERT INTO `models_categories` VALUES (15,1),(16,2),(11,3),(12,6);
/*!40000 ALTER TABLE `models_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models_publishers`
--

DROP TABLE IF EXISTS `models_publishers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `models_publishers` (
  `book_id` int NOT NULL,
  `publisher_id` int NOT NULL,
  PRIMARY KEY (`book_id`,`publisher_id`),
  KEY `publisher_id` (`publisher_id`),
  CONSTRAINT `models_publishers_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `models` (`id`) ON DELETE CASCADE,
  CONSTRAINT `models_publishers_ibfk_2` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models_publishers`
--

LOCK TABLES `models_publishers` WRITE;
/*!40000 ALTER TABLE `models_publishers` DISABLE KEYS */;
INSERT INTO `models_publishers` VALUES (8,2),(9,2),(10,2),(11,2);
/*!40000 ALTER TABLE `models_publishers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `ORDER_ID` bigint NOT NULL AUTO_INCREMENT,
  `ORDER_TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `USER_ID` bigint NOT NULL,
  `EXHIBITION_ID` int NOT NULL,
  PRIMARY KEY (`ORDER_ID`),
  KEY `USER_ID` (`USER_ID`),
  KEY `EXHIBITION_ID` (`EXHIBITION_ID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`EXHIBITION_ID`) REFERENCES `exhibitions` (`EXHIBITION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2023-05-11 17:52:47',2,1),(2,'2023-05-11 17:52:47',2,2),(3,'2023-05-11 17:52:47',1,1),(4,'2023-05-11 17:52:47',1,3),(5,'2023-05-14 12:41:50',2,14),(6,'2023-05-15 11:58:47',2,9),(7,'2023-05-15 11:58:47',2,10),(8,'2023-05-15 11:58:47',2,10),(9,'2023-05-15 11:58:47',2,10),(10,'2023-05-21 15:06:01',6,8),(11,'2023-05-24 03:10:36',9,16),(12,'2023-05-24 03:10:36',9,16),(13,'2023-05-24 03:10:36',9,16),(14,'2023-05-24 03:10:36',9,16),(15,'2023-05-24 03:10:36',9,17),(16,'2023-05-24 03:10:36',9,17),(17,'2023-05-24 03:10:36',9,17),(18,'2023-05-25 11:03:44',6,17),(19,'2023-05-25 11:03:44',6,17),(20,'2023-05-25 11:03:44',6,17);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photo` (
  `photo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publishers`
--

DROP TABLE IF EXISTS `publishers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publishers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishers`
--

LOCK TABLES `publishers` WRITE;
/*!40000 ALTER TABLE `publishers` DISABLE KEYS */;
INSERT INTO `publishers` VALUES (2,'Publisher 2'),(3,'Publisher 3'),(4,'rjg');
/*!40000 ALTER TABLE `publishers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `USER_ID` bigint NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(128) NOT NULL,
  `PASSWORD` varchar(256) NOT NULL,
  `ROLE` enum('USER','ADMIN','MODELLER','ORGANIZER') DEFAULT NULL,
  `PHOTO_ID` varchar(256) DEFAULT NULL,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `SECOND_NAME` varchar(45) DEFAULT NULL,
  `LOCATION` varchar(90) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$Rs6OCZ1cq2IVVVU0SqUnL.4s3WMDqAf1TgxVavND/NHzLOZfrgWqO','ADMIN',NULL,'','',NULL,NULL),(2,'user','$2a$10$S6bhKvW538VGJt/1U05s/uIdsgxvA09Rv3RT/5B0Zr4PkYDdvn8N2','USER',NULL,'','',NULL,NULL),(3,'admin2','$2a$10$f.FdBr4fwdXT9o8.IxmOxeKpj1xR3.Kgt1/OSv.Y2eMnBxGe2Co0C','USER',NULL,'','',NULL,NULL),(4,'admin3','$2a$10$lqCZOqkE1771BSjWA.RKj.WNEYYFx2vsB022L6wqLAJt.Z2Dttedy','ADMIN',NULL,'','',NULL,NULL),(5,'Organizer','$2a$10$wuHLimGckpyDt.MolBFafu35dLZuL/HGQ0qrjBxP3tL4uAm2Xk7vS','ORGANIZER',NULL,'','',NULL,NULL),(6,'user2','$2a$10$LlMWaHkNieRujc3CUW/Mz.h/hcPEs36YFTSkN53lO/0/XPPr5YZyq','USER',NULL,'cfw','awcf',NULL,NULL),(7,'Uaer3','$2a$10$D4h5YEWBAS2n1WOWYKHZ0./NXpku.vln54NUzT5FUTKiKoecfOWAe','USER',NULL,'','',NULL,NULL),(8,'Modeller','$2a$10$LubrAohEuNVZF5ZHXBwtHOJUD0LTh7irbJBtxCUgu67Cp92ycWVTK','MODELLER',NULL,NULL,NULL,NULL,NULL),(9,'user4','$2a$10$dy2I/NTQ4wfuvzUuPiIT6Orgfzvwh8P7pMK1pbQlAIc6p9vwNfDl.','USER',NULL,NULL,NULL,NULL,NULL),(10,'Organizer3','$2a$10$xh9d/EJUZdZFRxOLhMSB3OI0CLpEalGF8ZlYEGIapLZbhPqV2n1dS','ORGANIZER',NULL,NULL,NULL,NULL,NULL),(11,'admin4','$2a$10$BD0DT53hskOpMyIpBYByn.EDfupvDVO9WNObTR7XXEmjRS4PSelSy','ADMIN',NULL,NULL,NULL,NULL,NULL),(13,'2','$2a$10$wYcb9.RahyyNyHTMN0dzxOiWNNeHYvouTKx0fJfLZm/2zcBp3I/Ri','USER',NULL,NULL,NULL,NULL,NULL),(14,'3','$2a$10$zoWpoLq59y59Skul/v/Ew.xyfy9EukWSV5se/eTXrPnQnMbg1hSIy','USER',NULL,'3',NULL,NULL,NULL),(15,'4','$2a$10$BwX7brYmW4wDMwiz/U1i5.HjJyDln/u5dUtOKNc2RjKJ1WUesJ6be','USER',NULL,'4','4',NULL,NULL),(16,'5','$2a$10$C.S.v15tFkg0MFzRMbgVQe.YcsMNbPN5jQEQMz56rFZnFSGWZUljS','USER',NULL,'5','5','5',NULL),(17,'6','$2a$10$PU.rphoEMusaEu6Hgy.q7OZ8Z8kNJNJ/2ixMlApomgwYmNl.vvMNK','MODELLER',NULL,'6','6','6',NULL),(18,'8','$2a$10$5A8OfIzu2sA/hivd1evR0.K8TPXXtaJhTlO1hHHsOoTwBU/aL3I2y','ORGANIZER','8','8','8','8',NULL);
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

-- Dump completed on 2023-05-31 13:42:39
