-- MySQL dump 10.13  Distrib 5.5.31, for Linux (x86_64)
--
-- Host: localhost    Database: hackfmi_db
-- ------------------------------------------------------
-- Server version	5.5.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id_course` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id_course`),
  UNIQUE KEY `id_course_UNIQUE` (`id_course`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course_teacher_group`
--

DROP TABLE IF EXISTS `course_teacher_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_teacher_group` (
  `id_course_teacher_group` int(11) NOT NULL AUTO_INCREMENT,
  `id_course` int(11) DEFAULT NULL,
  `id_group` int(11) DEFAULT NULL,
  `id_teacher` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_course_teacher_group`),
  UNIQUE KEY `id_course_teacher_group_UNIQUE` (`id_course_teacher_group`),
  KEY `id_group_idx` (`id_group`),
  KEY `id_teacher_idx` (`id_teacher`),
  KEY `id_course_idx` (`id_course`),
  CONSTRAINT `course_teacher_group_course_fk` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `course_teacher_group_group_fk` FOREIGN KEY (`id_group`) REFERENCES `group` (`id_group`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `course_teacher_group_teacher_fk` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id_teacher`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `id_exam` int(11) NOT NULL AUTO_INCREMENT,
  `day` timestamp NULL DEFAULT NULL,
  `start_hour` timestamp NULL DEFAULT NULL,
  `end_hour` timestamp NULL DEFAULT NULL,
  `id_course_teacher_group` int(11) DEFAULT NULL,
  `proposal` bit(1) DEFAULT NULL,
  `final_exam` bit(1) DEFAULT NULL,
  `room_number` int(11) DEFAULT NULL,
  `description` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id_exam`),
  UNIQUE KEY `id_exam_UNIQUE` (`id_exam`),
  KEY `id_course_idx` (`id_course_teacher_group`),
  CONSTRAINT `id_course_fk` FOREIGN KEY (`id_course_teacher_group`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `id_group` int(11) NOT NULL AUTO_INCREMENT,
  `id_specialty` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_group`),
  UNIQUE KEY `id_group_UNIQUE` (`id_group`),
  KEY `id_specialty_idx` (`id_specialty`),
  CONSTRAINT `id_specialty_fk` FOREIGN KEY (`id_specialty`) REFERENCES `specialty` (`id_specialty`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `specialty`
--

DROP TABLE IF EXISTS `specialty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialty` (
  `id_specialty` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id_specialty`),
  UNIQUE KEY `id_pecialty_UNIQUE` (`id_specialty`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `faculty_number` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `id_group` int(11) DEFAULT NULL,
  PRIMARY KEY (`faculty_number`),
  UNIQUE KEY `faculty_number_UNIQUE` (`faculty_number`),
  KEY `id_group_idx` (`id_group`),
  CONSTRAINT `id_group` FOREIGN KEY (`id_group`) REFERENCES `group` (`id_group`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id_teacher` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id_teacher`),
  UNIQUE KEY `id_teacher_UNIQUE` (`id_teacher`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `family_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `id_vote` int(11) NOT NULL AUTO_INCREMENT,
  `id_student` int(11) DEFAULT NULL,
  `vote` int(11) DEFAULT NULL,
  `id_exam` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_vote`),
  UNIQUE KEY `id_vote_UNIQUE` (`id_vote`),
  KEY `id_exam_idx` (`id_exam`),
  KEY `id_student_idx` (`id_student`),
  CONSTRAINT `vote_exam_fk` FOREIGN KEY (`id_exam`) REFERENCES `exam` (`id_exam`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `vote_student_fk` FOREIGN KEY (`id_student`) REFERENCES `student` (`faculty_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-26 14:11:04
