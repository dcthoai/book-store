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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `bookID` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `author` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `publisher` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `size` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descriptions` text COLLATE utf8mb4_unicode_ci,
  `categoryID` int DEFAULT NULL,
  `thumbnail` int DEFAULT NULL,
  `languageID` int DEFAULT NULL,
  `voucherID` int DEFAULT NULL,
  `pages` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `price` bigint NOT NULL,
  `releaseDate` date DEFAULT NULL,
  `createdDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `createdBy` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifiedBy` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`bookID`),
  KEY `FK_Book_Category` (`categoryID`),
  KEY `FK_Book_Languages` (`languageID`),
  KEY `FK_Book_Media` (`thumbnail`),
  KEY `FK_Book_Voucher` (`voucherID`),
  CONSTRAINT `FK_Book_Category` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_Book_Languages` FOREIGN KEY (`languageID`) REFERENCES `languages` (`languageID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_Book_Media` FOREIGN KEY (`thumbnail`) REFERENCES `media` (`mediaID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_Book_Voucher` FOREIGN KEY (`voucherID`) REFERENCES `voucher` (`voucherID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `book_chk_2` CHECK ((`pages` > 0)),
  CONSTRAINT `book_chk_3` CHECK ((`weight` > 0)),
  CONSTRAINT `book_chk_4` CHECK ((`discount` between 0 and 100)),
  CONSTRAINT `book_chk_5` CHECK ((`price` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Đời thừa','Nam Cao','Văn Học','12 x 20 cm','Một truyện ngắn của Nam Cao',1,10,1,1,23,12,5.3,45700,'2019-02-03',NULL,NULL,NULL,NULL),(3,'To Kill a Mockingbird','Harper Lee','HarperCollins','12 x 20 cm','A coming-of-age story that explores themes of racial prejudice in the American South.',2,7,2,NULL,250,500,0,121200,'2002-02-01',NULL,NULL,NULL,NULL),(4,'Project Hail Mary','Andy Weir','Random House','12 x 20 cm','An amnesiac astronaut wakes up on a spaceship millions of miles from Earth with no memory of his mission or how he got there.',3,8,2,NULL,399,122,10,23100,'2021-05-04',NULL,NULL,NULL,NULL),(5,'The Very Hungry Caterpillar','Eric Carle','Penguin Random House','12 x 20 cm','A colorful and engaging story about a hungry caterpillar who eats his way through the week.',5,9,2,NULL,122,340,0,97000,'1969-03-20',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
