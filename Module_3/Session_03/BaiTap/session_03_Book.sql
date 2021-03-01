-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: session_03
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `Book`
--

DROP TABLE IF EXISTS `Book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Book` (
  `idBook` varchar(20) NOT NULL,
  `nameBook` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `manufacter` varchar(50) NOT NULL,
  `typeBook` varchar(30) DEFAULT NULL,
  `orderNumber` int DEFAULT NULL,
  `studentNumber` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idBook`),
  KEY `typeBook` (`typeBook`),
  KEY `orderNumber` (`orderNumber`),
  KEY `studentNumber` (`studentNumber`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`typeBook`) REFERENCES `Category` (`typeBook`),
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`orderNumber`) REFERENCES `BorrowOrder` (`orderNumber`),
  CONSTRAINT `book_ibfk_3` FOREIGN KEY (`studentNumber`) REFERENCES `Student` (`studentNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Book`
--

LOCK TABLES `Book` WRITE;
/*!40000 ALTER TABLE `Book` DISABLE KEYS */;
INSERT INTO `Book` VALUES ('A1101','Toan 1',15000,'Kim Dong','Toan Hoc',101,'102'),('A1211','Doraemon',20000,'Campus','Truyen Tranh',121,'106'),('B1102','Anh Van 6',25000,'Nhan Dan','Tieng Anh',102,'101'),('C1000','Van Hoc 10',15000,'Jame','Van Hoc',151,'110'),('F1001','Hoa Hoc 12',35000,'Kim Dong1','Hoa Hoc',111,'105');
/*!40000 ALTER TABLE `Book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-01 10:23:07
