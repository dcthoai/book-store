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
-- Table structure for table `slide`
--

DROP TABLE IF EXISTS `slide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slide` (
  `slideId` int NOT NULL AUTO_INCREMENT,
  `slideMedia` int NOT NULL,
  `caption` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` varchar(1500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` timestamp NULL DEFAULT NULL,
  `modifiedDate` timestamp NULL DEFAULT NULL,
  `createdBy` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifiedBy` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `slideLink` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`slideId`),
  KEY `FK_Slide_Media` (`slideMedia`),
  CONSTRAINT `FK_Slide_Media` FOREIGN KEY (`slideMedia`) REFERENCES `media` (`mediaID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slide`
--

LOCK TABLES `slide` WRITE;
/*!40000 ALTER TABLE `slide` DISABLE KEYS */;
INSERT INTO `slide` VALUES (1,2,'Khám phá khoa học','Kích thích sự tò mò và khám phá với cuốn sách khoa học đầy màu sắc,\n                                		mang đến những hiểu biết mới mẻ và hấp dẫn cho các trẻ nhỏ!',NULL,NULL,NULL,NULL,NULL),(2,1,'Truyện tranh hấp dẫn','Nhập vai vào thế giới phiêu lưu đầy màu sắc và hài hước với những trang truyện tranh tuyệt vời! \n                                			Khám phá những câu chuyện đầy phép thuật và nhân vật đầy cá tính, sẵn sàng chờ đợi bạn trong những trang sách tranh tuyệt vời!',NULL,NULL,NULL,NULL,NULL),(3,3,'Cùng nhau vào bếp','Khám phá hương vị thế giới và học cách trở thành đầu bếp tài ba với những công thức đơn giản\n                                		và ngon miệng từ cuốn sách nấu ăn độc đáo này! \n                                		Từ món ăn truyền thống đến những món mới lạ, tất cả đều sẽ được tiết lộ bí mật trong từng trang sách, \n                                		mang lại cho bạn trải nghiệm ẩm thực tuyệt vời nhất.',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `slide` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-30 17:02:22
