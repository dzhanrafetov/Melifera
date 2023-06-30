-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: beeshop
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
-- Table structure for table `advertisement`
--

DROP TABLE IF EXISTS `advertisement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advertisement` (
  `id` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `category_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `is_archived` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsth93a2mbq8clgjxvpr3rcg37` (`category_id`),
  KEY `FK6l68mvl7eypahv3tmaf7ndwie` (`user_id`),
  CONSTRAINT `FK6l68mvl7eypahv3tmaf7ndwie` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKsth93a2mbq8clgjxvpr3rcg37` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisement`
--

LOCK TABLES `advertisement` WRITE;
/*!40000 ALTER TABLE `advertisement` DISABLE KEYS */;
INSERT INTO `advertisement` VALUES ('2a67d5f4-95e9-40ea-95d9-16fd463c53aa','сд','2023-04-17 16:24:37','дс','2023-04-24 22:15:39',32.00,2,26,_binary ''),('5dba6cbd-49cd-4ad3-ae32-c38fb9416c61','probvame','2023-04-17 16:44:09','dfgsdfgs','2023-04-24 22:15:41',32.00,2,27,_binary ''),('908c1119-8d29-42a1-8327-5cdcab951d4b','rfsdg','2023-04-17 17:08:04','fdsgsdf','2023-04-24 22:15:42',4.00,2,26,_binary ''),('c187c501-25dc-4c1f-a514-43dd86888e4f','sdgfdsg','2023-05-22 20:34:28','dfgsdfg','2023-05-25 10:31:32',43.00,2,65,_binary ''),('cfc323b5-fe1a-4c36-9f20-5616be0e480b','Spring Boot – How to reload the changes without restarting the server?','2023-04-17 20:24:12','dsfsSpring Boot – How to reload the changes without restarting the server?\r\n','2023-04-25 22:37:42',43.00,2,27,_binary ''),('dd277c24-df22-476a-83d7-1b32c9fc823b','Пчелни кошери по НПП ','2023-04-24 22:18:12','Фирма \"МАРИАМ 2016 ЕООД\"\r\n','2023-04-24 22:26:08',85.00,2,27,_binary '\0'),('e222a450-0d7f-45be-a7c7-672e145dcc97','sss','2023-04-17 18:39:19','sss','2023-04-24 22:15:43',3.00,2,26,_binary ''),('ee239a81-5c8b-42e1-bb9e-72864826330a','Пчелна Майка Карпатка','2023-04-25 22:16:57','Оплодени Пчелни Майки! СЪС ЗАПИСВАНЕ!\r\nПредимството на Карпатските майки е че те са много по-издръжливи през Зимата, по-едри са, снасят повече, носят повече мед и не са агресивни.','2023-04-25 22:16:57',25.00,8,26,_binary '\0');
/*!40000 ALTER TABLE `advertisement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (2,'Пчелни Кошери'),(8,'Пчелни Майки');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmation_token`
--

DROP TABLE IF EXISTS `confirmation_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `confirmation_token` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhjrtky9wbd6lbk7mu9tuddqgn` (`user_id`),
  CONSTRAINT `FKhjrtky9wbd6lbk7mu9tuddqgn` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmation_token`
--

LOCK TABLES `confirmation_token` WRITE;
/*!40000 ALTER TABLE `confirmation_token` DISABLE KEYS */;
INSERT INTO `confirmation_token` VALUES (40,'6942ba9d-22e2-4a26-afbb-39106a708a5e',64),(41,'d901e55b-0c3f-45e8-9e42-ad19743846e9',65),(43,'1fb580da-7efb-411f-aa3e-15b22911b2bb',69),(44,'6a1f87fa-bd8d-4bce-a5fc-9a7013ca4f03',70),(45,'279c55ca-8523-48ef-9371-81551d15d6f0',71);
/*!40000 ALTER TABLE `confirmation_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `advertisement_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiggidj4uiunuw3pmpmyy22eg4` (`advertisement_id`),
  CONSTRAINT `FKiggidj4uiunuw3pmpmyy22eg4` FOREIGN KEY (`advertisement_id`) REFERENCES `advertisement` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (43,'f.png','/images/uploads/26-user/2a67d5f4-95e9-40ea-95d9-16fd463c53aa/f.png','2a67d5f4-95e9-40ea-95d9-16fd463c53aa'),(48,'Screenshot 2023-04-17 at 15.13.30.png','/images/uploads/27-admin/5dba6cbd-49cd-4ad3-ae32-c38fb9416c61/Screenshot 2023-04-17 at 15.13.30.png','5dba6cbd-49cd-4ad3-ae32-c38fb9416c61'),(51,'Screenshot 2023-04-17 at 15.13.30.png','/images/uploads/26-user/908c1119-8d29-42a1-8327-5cdcab951d4b/Screenshot 2023-04-17 at 15.13.30.png','908c1119-8d29-42a1-8327-5cdcab951d4b'),(56,'Screenshot 2023-04-17 at 20.04.45.png','/images/uploads/26-user/e222a450-0d7f-45be-a7c7-672e145dcc97/Screenshot 2023-04-17 at 20.04.45.png','e222a450-0d7f-45be-a7c7-672e145dcc97'),(58,'Screenshot 2023-04-17 at 15.13.30.png','/images/uploads/27-admin/cfc323b5-fe1a-4c36-9f20-5616be0e480b/Screenshot 2023-04-17 at 15.13.30.png','cfc323b5-fe1a-4c36-9f20-5616be0e480b'),(60,'asd.webp','/images/uploads/27-admin/dd277c24-df22-476a-83d7-1b32c9fc823b/asd.webp','dd277c24-df22-476a-83d7-1b32c9fc823b'),(61,'about_04-1024x768.jpeg','/images/uploads/26-user/ee239a81-5c8b-42e1-bb9e-72864826330a/about_04-1024x768.jpeg','ee239a81-5c8b-42e1-bb9e-72864826330a'),(62,'Screenshot 2023-05-21 at 17.38.13.png','/images/uploads/65-dzhan/c187c501-25dc-4c1f-a514-43dd86888e4f/Screenshot 2023-05-21 at 17.38.13.png','c187c501-25dc-4c1f-a514-43dd86888e4f');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6sou31qus5dnws6dwfu61e71v` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (26,'user','$2a$10$C/ly1DGAB7173sohmRf2J.XEUEB7t2qN1m0vOE/iKd1AT2z5RZlLy','canrafet0@gmail.com','2023-03-07 06:41:04',_binary '','ROLE_USER'),(27,'admin','$2a$10$C/ly1DGAB7173sohmRf2J.XEUEB7t2qN1m0vOE/iKd1AT2z5RZlLy','novuserr@abv.bg','2023-03-07 20:20:02',_binary '','ROLE_ADMIN'),(64,'nov432','$2a$10$dB8K5jsONzTsU8ym56VtBeplPYqP.RCQrFpiNPS2R01zx53M7XE1q','dzhanrafet3ov@gmail.com','2023-04-24 21:50:40',_binary '\0','ROLE_USER'),(65,'dzhan','$2a$10$OfT9A9Ho8EpF2kSn.TvCqOI/7LBbcmOJTXkRZUTo1y9wDyZ7HhRaK','18510@uktc-bg.com','2023-05-22 07:52:49',_binary '','ROLE_USER'),(68,'proba','$2a$10$d2LcjkOuGSun9UCD2/Sktul18sNVumHqzIIw1.tY3nSLRqd57bEr2','dsfaffff@abv.bg','2023-05-22 08:02:25',_binary '\0','ROLE_USER'),(69,'proba','$2a$10$hd3y/DimD.RmOlsY0C37zuQdHuop2fY658rFBi/C7DV6cj0azufU6','proba@abv.bg','2023-05-22 11:35:41',_binary '\0','ROLE_USER'),(70,'dasfas','$2a$10$mYHfdLtxdh7Q1uCsPECDE.ZCjJs2.OQtN.BFUe4p2JuorZ/A4AcRO','sdfasdf@abv.bg','2023-05-22 11:37:10',_binary '\0','ROLE_USER'),(71,'petko','$2a$10$mQQPgnv93/bZM8MHajEM6eJ7DBy.qO6UQGthQkGlz9rDO52FYloOK','18520@uktc-bg.com','2023-05-29 10:50:30',_binary '\0','ROLE_USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetails`
--

DROP TABLE IF EXISTS `userdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdetails` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `user_details_id` bigint NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfywexyuyxal9l1905aojtgqll` (`user_details_id`),
  CONSTRAINT `FKfywexyuyxal9l1905aojtgqll` FOREIGN KEY (`user_details_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetails`
--

LOCK TABLES `userdetails` WRITE;
/*!40000 ALTER TABLE `userdetails` DISABLE KEYS */;
INSERT INTO `userdetails` VALUES (24,'dasfMd','София','Bulgaria','7800',27,'+359897758062','София'),(25,'dasfMd','Zlatna panega','Bulgaria','7800',26,'+359897758062','Sofia'),(27,'dsfa','sadfas','dsfasd','sdafasd',26,'dsaf','sdafasd'),(28,'ddddddd','ddddddd','ddddddd','vddddddd',26,'ddddddd','ddddddd'),(29,'dsdafa','dsaf','dasfasdfa','sadfasd',26,'asdfasd','asdfasdf'),(30,'dfsadsaf','sadfasdf','sadfasd','asdfasdf',26,'asdfasd','asdfasdf'),(31,'asdfasd','fdsafas','adfsasdf','asdfa',26,'dasfasd','dfadsf'),(32,'sadfasdf','fasdfas','sadfasd','asdfasdf',26,'adsfasd','fadsfa'),(33,'adsfa','fasdf','asdf','sadfasd',26,'sadfas','sadfasdf'),(34,'Marko Nikolov 45','Popovo','Bulgaria','7800',26,'0897758062','sadasdas'),(35,'dasfMd','Zlatna panega','Bulgaria','7800',65,'+359897758062','Sofia'),(37,'Marko Nikolov 45','Popovo','Bulgaria','7800',27,'0897758062','df'),(38,'Marko Nikolov 45','Popovo','Bulgaria','7800',27,'0897758062','dsf');
/*!40000 ALTER TABLE `userdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `v1_image`
--

DROP TABLE IF EXISTS `v1_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `v1_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `advertisement_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1srxo4bffthbdhwlmqsmixug7` (`url`),
  KEY `FKqubu9iuxl7q2bufiae1f5w993` (`advertisement_id`),
  CONSTRAINT `FKqubu9iuxl7q2bufiae1f5w993` FOREIGN KEY (`advertisement_id`) REFERENCES `advertisement` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `v1_image`
--

LOCK TABLES `v1_image` WRITE;
/*!40000 ALTER TABLE `v1_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `v1_image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-30 11:19:27

