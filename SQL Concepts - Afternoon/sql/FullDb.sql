CREATE DATABASE  IF NOT EXISTS `dbkn` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dbkn`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: dbkn
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `CAT_CODE` varchar(5) NOT NULL,
  `CAT_NAME` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`CAT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('C001','drinks'),('C002','chocolates'),('C003','sweets');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CUST_ID` varchar(5) NOT NULL,
  `CUST_NAME` varchar(20) DEFAULT NULL,
  `CUST_DOB` date DEFAULT NULL,
  `CUST_GENDER` char(1) DEFAULT NULL,
  `CUST_MOBILE` varchar(10) DEFAULT NULL,
  `LOC_CODE` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`CUST_ID`),
  KEY `LOC_CODE` (`LOC_CODE`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`LOC_CODE`) REFERENCES `location` (`LOC_CODE`),
  CONSTRAINT `CHECK_CUSTOMER_GENDER` CHECK ((`CUST_GENDER` in (_utf8mb4'M',_utf8mb4'F',_utf8mb4'O')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('C001','hamen','1997-07-11','M','9876543219','L001'),('C002','vini','1995-12-20','F','9862736542','L002');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `last_week_sales`
--

DROP TABLE IF EXISTS `last_week_sales`;
/*!50001 DROP VIEW IF EXISTS `last_week_sales`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `last_week_sales` AS SELECT 
 1 AS `SALE_ID`,
 1 AS `SE_ID`,
 1 AS `CUST_ID`,
 1 AS `DOP`,
 1 AS `LOC_CODE`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `LOC_CODE` varchar(5) NOT NULL,
  `LOC_NAME` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`LOC_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES ('L001','chennai'),('L002','banglore'),('L003','hyderabad'),('L004','mumbai'),('L005','delhi');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `PROD_CODE` varchar(5) NOT NULL,
  `PROD_NAME` varchar(15) DEFAULT NULL,
  `CAT_CODE` varchar(5) DEFAULT NULL,
  `UNIT_PRICE` float(5,3) DEFAULT NULL,
  PRIMARY KEY (`PROD_CODE`),
  KEY `CAT_CODE` (`CAT_CODE`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CAT_CODE`) REFERENCES `category` (`CAT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('P001','coke','C001',25.000),('P002','pepsi','C001',10.000),('P003','diary milk','C002',25.000),('P004','munch','C002',10.000),('P005','gulab jamun','C003',25.000),('P006','gheecake','C003',10.000);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `SALE_ID` varchar(5) NOT NULL,
  `SE_ID` varchar(5) DEFAULT NULL,
  `CUST_ID` varchar(5) DEFAULT NULL,
  `DOP` date DEFAULT NULL,
  `LOC_CODE` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`SALE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES ('S001','SE001','C001','2021-01-07','L001'),('S002','SE002','C001','2021-01-07','L001'),('S003','SE001','C001','2021-01-08','L001'),('S004','SE001','C001','2020-07-18','L002');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_product`
--

DROP TABLE IF EXISTS `sale_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale_product` (
  `SALE_ID` varchar(5) NOT NULL,
  `PROD_CODE` varchar(5) NOT NULL,
  `NOP` int DEFAULT NULL,
  PRIMARY KEY (`SALE_ID`,`PROD_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_product`
--

LOCK TABLES `sale_product` WRITE;
/*!40000 ALTER TABLE `sale_product` DISABLE KEYS */;
INSERT INTO `sale_product` VALUES ('S001','P001',5),('S001','P002',15),('S001','P003',10),('S002','P001',5),('S002','P003',15),('S003','P005',50),('S004','P003',2);
/*!40000 ALTER TABLE `sale_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_exe`
--

DROP TABLE IF EXISTS `sales_exe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_exe` (
  `SE_ID` varchar(5) NOT NULL,
  `SE_NAME` varchar(20) DEFAULT NULL,
  `SE_DOB` date DEFAULT NULL,
  `SE_GENDER` char(1) DEFAULT NULL,
  `SE_MOBILE` varchar(10) DEFAULT NULL,
  `LOC_CODE` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`SE_ID`),
  CONSTRAINT `CHECK_SE_GENDER` CHECK ((`SE_GENDER` in (_utf8mb4'M',_utf8mb4'F',_utf8mb4'O')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_exe`
--

LOCK TABLES `sales_exe` WRITE;
/*!40000 ALTER TABLE `sales_exe` DISABLE KEYS */;
INSERT INTO `sales_exe` VALUES ('SE001','kalai','1995-01-22','M','9263376354','L001'),('SE002','vipin','1987-12-19','M','8736542536','L001'),('SE003','ani','1999-05-26','F','8976543562','L001');
/*!40000 ALTER TABLE `sales_exe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbkn'
--

--
-- Dumping routines for database 'dbkn'
--
/*!50003 DROP PROCEDURE IF EXISTS `MaxProductPerDayLastWeek` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MaxProductPerDayLastWeek`(IN locCode VARCHAR(5))
BEGIN
	-- get all max prodcut sold per day for the last week
	-- call MaxProductPerDayLastWeekCTemp(locCode);
    CREATE TEMPORARY TABLE IF NOT EXISTS  MaxProductPerDayLastWeek2(
		DOP DATE, PROD_CODE VARCHAR(5), SALE_ID VARCHAR(5), TOT_UNITS INT
    );
    CREATE TEMPORARY TABLE IF NOT EXISTS  MaxProductPerDayLastWeek3(
		DOP12 DATE, TOT_UNITS12 INT
    );
    TRUNCATE TABLE MaxProductPerDayLastWeek2;
    TRUNCATE TABLE MaxProductPerDayLastWeek3;
    
    INSERT INTO MaxProductPerDayLastWeek2 SELECT DOP, PROD_CODE, SALE_ID,sum(NOU) AS TOT_UNITS
	FROM (SELECT S.DOP,S.SALE_ID,SP.PROD_CODE,SP.NOU FROM LAST_WEEK_SALES S, SALE_PRODUCT SP WHERE S.SALE_ID=SP.SALE_ID AND LOC_CODE=locCode) AS RES1 
    GROUP BY DOP, PROD_CODE ORDER BY DOP;
    
	INSERT INTO MaxProductPerDayLastWeek3 SELECT RES2.DOP AS DOP12, MAX(RES2.TOT_UNITS) AS TOT_UNITS12 
    FROM MaxProductPerDayLastWeek2 AS RES2 
	GROUP BY RES2.DOP;
    
    SELECT DOP, TOT_UNITS, P.PROD_CODE, P.PROD_NAME FROM MaxProductPerDayLastWeek2 AS RES2
	INNER JOIN MaxProductPerDayLastWeek3 AS RES3
	ON RES3.DOP12=DOP AND RES3.TOT_UNITS12=TOT_UNITS
	,
	PRODUCT P
	WHERE P.PROD_CODE=RES2.PROD_CODE;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `last_week_sales`
--

/*!50001 DROP VIEW IF EXISTS `last_week_sales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `last_week_sales` AS select `sale`.`SALE_ID` AS `SALE_ID`,`sale`.`SE_ID` AS `SE_ID`,`sale`.`CUST_ID` AS `CUST_ID`,`sale`.`DOP` AS `DOP`,`sale`.`LOC_CODE` AS `LOC_CODE` from `sale` where (`sale`.`DOP` between (curdate() - interval 7 day) and curdate()) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-10 15:42:27
