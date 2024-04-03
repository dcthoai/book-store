CREATE DATABASE  IF NOT EXISTS `bookstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bookstore`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `media` (
  `mediaID` int NOT NULL AUTO_INCREMENT,
  `mediaName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mediaPath` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mediaType` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mediaSize` int DEFAULT NULL,
  `createdDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `createdBy` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifiedBy` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`mediaID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
INSERT INTO `media` VALUES (1,'comic.png','assets/images/comic.png','image',124,NULL,NULL,NULL,NULL),(2,'science.png','assets/images/science.png','image',235,NULL,NULL,NULL,NULL),(3,'cooking.png','assets/images/cooking.png','image',123,NULL,NULL,NULL,NULL),(4,'post-1.jpg','assets/images/post-1.jpg','image',NULL,NULL,NULL,NULL,NULL),(5,'post-2.jpg','assets/images/post-2.jpg','image',NULL,NULL,NULL,NULL,NULL),(6,'post-3.jpg','assets/images/post-3.jpg','image',NULL,NULL,NULL,NULL,NULL),(7,'kil-bird.jpg','assets/images/kil-bird.jpg','image',NULL,NULL,NULL,NULL,NULL),(8,'hail-mary.jpg','assets/images/hail-mary.jpg','image',NULL,NULL,NULL,NULL,NULL),(9,'caterpillar.jpg','assets/images/caterpillar.jpg','image',NULL,NULL,NULL,NULL,NULL),(10,'doi-thua.jpg','assets/images/doi-thua.jpg','image',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-03 17:01:47
