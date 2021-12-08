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
-- Table structure for table `chatusuario`
--

DROP TABLE IF EXISTS `chatusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chatusuario` (
  `publicacion_id` int DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `mensaje` varchar(500) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FKgndrv8tnmbbi59r9okeyubu9s` (`usuario_id`),
  KEY `chatusuario_publicacion_id_fk` (`publicacion_id`),
  CONSTRAINT `chatusuario_publicacion_id_fk` FOREIGN KEY (`publicacion_id`) REFERENCES `publicacion` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKgndrv8tnmbbi59r9okeyubu9s` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKs72vmai9b141v3qda7a2jhy0u` FOREIGN KEY (`publicacion_id`) REFERENCES `publicacion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatusuario`
--

LOCK TABLES `chatusuario` WRITE;
/*!40000 ALTER TABLE `chatusuario` DISABLE KEYS */;
INSERT INTO `chatusuario` VALUES (45,1,'2021-12-08 00:42:16','Hola a todos, ese es mi perro, Se me perdio el dia 07 de diciembre por la zona de Castelar, si alguno lo ve por favor aviseme en esta publicacion.\nMuchas Gracias!',23),(45,3,'2021-12-08 00:43:39','Buenas, lo encontre cerca de mi casa. Vivo en la calle French 454, Moron, si queres pasame tu contacto asi hablamos por WhatsApp',24),(45,1,'2021-12-10 00:46:17','Perfecto, mi numero es 01159489724, nos hablamos por ahi, muchas gracias!',25),(45,3,'2021-12-10 00:48:45','Buenisimo, por favor no te olvides de poner mi mail al finalizar para que me sume los puntos',26),(67,1,'2021-12-08 14:45:45','Buenas Tardes! Ayer me encontre a este gato solo en la calle. Quien sea el dueÃ±o por favor escribame en la publicacion  asi nos contactamos para devolverlo',27),(67,3,'2021-12-08 14:45:47','Ese gatito es mio, muchas gracias por publicarlo, ahora te paso mi numero asi lo voy a buscar',28);
/*!40000 ALTER TABLE `chatusuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-08 11:55:11
