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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id_categories` int NOT NULL AUTO_INCREMENT,
  `name_categorii` varchar(125) NOT NULL,
  PRIMARY KEY (`id_categories`),
  KEY `id_categories` (`id_categories`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exhibitions`
--

LOCK TABLES `exhibitions` WRITE;
/*!40000 ALTER TABLE `exhibitions` DISABLE KEYS */;
INSERT INTO `exhibitions` VALUES (1,'Space','2022-10-01','2022-10-30','10:00:00','20:00:00',45.00,0),(2,'Earth','2022-11-01','2022-11-30','10:00:00','20:00:00',40.00,1),(3,'Oceans','2022-12-01','2022-12-30','10:00:00','20:00:00',43.00,1),(4,'Forest','2023-01-01','2023-01-31','09:00:00','18:00:00',34.00,1),(5,'Animals','2023-02-01','2023-02-28','09:00:00','18:00:00',30.00,1),(6,'People','2023-03-01','2023-03-31','09:00:00','18:00:00',28.00,1),(7,'Sky','2023-04-01','2023-04-30','09:00:00','18:00:00',50.00,1),(8,'Mountains','2023-05-01','2023-05-31','09:00:00','18:00:00',32.00,1),(9,'Nature','2023-06-01','2023-06-30','09:00:00','18:00:00',31.00,1),(10,'Rivers','2023-07-01','2023-07-31','09:00:00','18:00:00',47.00,1),(11,'Cities','2023-08-01','2023-08-31','09:00:00','18:00:00',20.00,1),(12,'Big Constructions','2023-09-01','2023-09-30','09:00:00','18:00:00',32.00,1),(13,'Cars','2023-10-01','2023-10-31','09:00:00','18:00:00',35.00,1),(14,'mariarty','2023-05-11','2023-05-19','16:08:00','17:11:00',2.00,1);
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
INSERT INTO `exhibitions_locations` VALUES (1,1),(1,2),(1,4),(2,3),(2,2),(3,4),(3,1),(4,1),(4,3),(4,2),(5,3),(5,1),(6,4),(7,2),(7,1),(8,2),(8,3),(9,3),(10,2),(11,1),(11,2),(11,3),(11,4),(12,2),(12,3),(13,1),(13,4),(13,2),(14,4);
/*!40000 ALTER TABLE `exhibitions_locations` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'HALL A'),(2,'HALL B'),(3,'HALL C'),(4,'HALL D');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `models` (
  `id_model` int NOT NULL AUTO_INCREMENT,
  `name_model` varchar(255) NOT NULL,
  `type_categories` int NOT NULL,
  `scale` int NOT NULL,
  `pub_hous` varchar(255) NOT NULL,
  `discription` varchar(1200) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `od_user_cre` int NOT NULL,
  PRIMARY KEY (`id_model`),
  KEY `id_model` (`id_model`),
  KEY `type_model_idx` (`type_categories`),
  CONSTRAINT `model_cat` FOREIGN KEY (`type_categories`) REFERENCES `categories` (`id_categories`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2023-05-11 17:52:47',2,1),(2,'2023-05-11 17:52:47',2,2),(3,'2023-05-11 17:52:47',1,1),(4,'2023-05-11 17:52:47',1,3),(5,'2023-05-14 12:41:50',2,14),(6,'2023-05-15 11:58:47',2,9),(7,'2023-05-15 11:58:47',2,10),(8,'2023-05-15 11:58:47',2,10),(9,'2023-05-15 11:58:47',2,10);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_model`
--

DROP TABLE IF EXISTS `orders_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_model` (
  `id_model` int NOT NULL,
  `time_end` datetime NOT NULL,
  `id_vont` int NOT NULL,
  KEY `con_mod` (`id_model`),
  KEY `con_exh_idx` (`id_vont`),
  CONSTRAINT `con_exh` FOREIGN KEY (`id_vont`) REFERENCES `exhibitions` (`EXHIBITION_ID`),
  CONSTRAINT `con_mod` FOREIGN KEY (`id_model`) REFERENCES `models` (`id_model`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_model`
--

LOCK TABLES `orders_model` WRITE;
/*!40000 ALTER TABLE `orders_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_model` ENABLE KEYS */;
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
  `FIRST_NAME` varchar(45) NOT NULL,
  `SECOND_NAME` varchar(45) NOT NULL,
  `LOCATION` varchar(90) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$Rs6OCZ1cq2IVVVU0SqUnL.4s3WMDqAf1TgxVavND/NHzLOZfrgWqO','ADMIN',NULL,'','',NULL,NULL),(2,'user','$2a$10$S6bhKvW538VGJt/1U05s/uIdsgxvA09Rv3RT/5B0Zr4PkYDdvn8N2','USER',NULL,'','',NULL,NULL),(3,'admin2','$2a$10$f.FdBr4fwdXT9o8.IxmOxeKpj1xR3.Kgt1/OSv.Y2eMnBxGe2Co0C','USER',NULL,'','',NULL,NULL),(4,'admin3','$2a$10$lqCZOqkE1771BSjWA.RKj.WNEYYFx2vsB022L6wqLAJt.Z2Dttedy','ADMIN',NULL,'','',NULL,NULL),(5,'Organizer','$2a$10$wuHLimGckpyDt.MolBFafu35dLZuL/HGQ0qrjBxP3tL4uAm2Xk7vS','ORGANIZER',NULL,'','',NULL,NULL),(6,'user2','$2a$10$LlMWaHkNieRujc3CUW/Mz.h/hcPEs36YFTSkN53lO/0/XPPr5YZyq','USER',NULL,'','',NULL,NULL),(7,'Uaer3','$2a$10$D4h5YEWBAS2n1WOWYKHZ0./NXpku.vln54NUzT5FUTKiKoecfOWAe','USER',NULL,'','',NULL,NULL);
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

-- Dump completed on 2023-05-19  3:22:09
