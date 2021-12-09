CREATE DATABASE  IF NOT EXISTS `missingpets` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `missingpets`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: missingpets
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `publicacion`
--

DROP TABLE IF EXISTS `publicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publicacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `finalizado` tinyint(1) DEFAULT NULL,
  `fechaPublicacion` date DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  `mascota_id` bigint DEFAULT NULL,
  `localidad_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsmafswujolnyojwb2rq31ax48` (`mascota_id`),
  KEY `FKrfbxv3finr62x94rulf1mm5mp` (`usuario_id`),
  KEY `FKmgpby4kddnjf46wiahl18r2gi` (`localidad_id`),
  CONSTRAINT `FKmgpby4kddnjf46wiahl18r2gi` FOREIGN KEY (`localidad_id`) REFERENCES `localidad` (`id`),
  CONSTRAINT `FKrfbxv3finr62x94rulf1mm5mp` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKsmafswujolnyojwb2rq31ax48` FOREIGN KEY (`mascota_id`) REFERENCES `mascota` (`id`),
  CONSTRAINT `publicacion_mascota_id_fk` FOREIGN KEY (`mascota_id`) REFERENCES `mascota` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `publicacion_usuario_id_fk` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicacion`
--

LOCK TABLES `publicacion` WRITE;
/*!40000 ALTER TABLE `publicacion` DISABLE KEYS */;
INSERT INTO `publicacion` VALUES (81,0,'2021-12-09',6,135,9),(82,0,'2021-12-09',6,136,8),(83,0,'2021-12-09',7,137,12),(84,0,'2021-12-09',7,138,5),(85,0,'2021-12-09',8,139,11),(86,0,'2021-12-09',8,140,3);
/*!40000 ALTER TABLE `publicacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-08 22:44:55
