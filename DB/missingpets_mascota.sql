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
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascota` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(90) DEFAULT NULL,
  `edad` varchar(90) DEFAULT NULL,
  `raza` varchar(90) DEFAULT NULL,
  `detalle` varchar(90) DEFAULT NULL,
  `color` varchar(90) DEFAULT NULL,
  `tamanio` varchar(90) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tipo_id` bigint DEFAULT NULL,
  `estado_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbqvtbhflbdlclgnnrrb08tth` (`tipo_id`),
  KEY `FKfxpnmoqu6mh0as8sxp3knvxkf` (`estado_id`),
  CONSTRAINT `FKbqvtbhflbdlclgnnrrb08tth` FOREIGN KEY (`tipo_id`) REFERENCES `tipo` (`id`),
  CONSTRAINT `FKfxpnmoqu6mh0as8sxp3knvxkf` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`),
  CONSTRAINT `mascota_estado_id_fk` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mascota_tipo_id_fk` FOREIGN KEY (`tipo_id`) REFERENCES `tipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
INSERT INTO `mascota` VALUES (60,'Cormier','3','American Bully','gordo y petizo','marron','mediano',NULL,'img/Cormier 5.jpeg',NULL,NULL,2),(61,'tu vieja','tu vieja','tu vieja','tu vieja','tu vieja','tu vieja',NULL,'img/rex.jpeg',NULL,NULL,2),(62,'Hellboy','30 años','American Bully','gordo y abortero','trichoco','mediano',NULL,'img/american-bully-dog-vector-illustration-white-background-bullie-breed-can-be-used-as-logo-kennel-tattoo-etc-156378364.jpg',NULL,NULL,2),(63,'Cormier','1 año','American Bully','Marron y petzo','Marron','Mediano',NULL,'img/Cormier 7.jpeg',NULL,NULL,2),(64,'Fatiga','7','Callejero','Perezoso','Marron','Normal',NULL,'img/2fatiga.jpg',NULL,NULL,1),(65,'Fatiga2','8','Callejero','Perezoso','marron','Normal',NULL,'img/7fatiga-argento.jpg',NULL,NULL,2),(66,'Fatiga3','8','Callejero','Perezoso','marron','Normal',NULL,'img/9fatiga 3.jpeg',NULL,NULL,1),(67,'Fatiga','8','Callejero','Perezoso','marron','Normal',NULL,'img/1fatiga-argento.jpg',NULL,NULL,2),(68,'Charly','7','Caniche','Petiso','blanco','chico',NULL,'img/5caniche.jpg',NULL,NULL,2),(71,'Riki','7','Dalmata','Sin detalles','Blanco','chico',NULL,'img/3dalmata-t.jpg',NULL,NULL,2),(72,'Carucha','8','Callejero','Sin detalles','marron','chico',NULL,'img/3dalmata2.jpg',NULL,NULL,2),(73,'Morita','4','Salchicha','Larga y Petiza','Marron','chico',NULL,'img/2salchi.jpg',NULL,NULL,2),(74,'Buddy','7','Golden','SuperStar','Amarillo','Normal',NULL,'img/9buddy.png',NULL,NULL,1),(75,'Pluto','7','Animado','Amigo del Pato Donald','marron','Normal',NULL,'img/Pluto.png',NULL,1,1),(76,'Pluto','7','Animado','Amigo del Pato Donald','marron','Normal',NULL,'img/Pluto.png',NULL,1,1),(77,'Gato ','7','con Botas','Amigo de Shrek','Naranja','chico',NULL,'img/gato con botas.jpg',NULL,1,1),(78,'Gato ','7','con Botas','Amigo de Shrek','Naranja','chico',NULL,'img/gato con botas.jpg',NULL,2,1),(79,'Scooby Doo','7','No se','Amigo de Shaggy','marron','Grande',NULL,'img/scooby.jpg',NULL,1,1);
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18  0:27:23
