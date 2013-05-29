--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `fathers_name` varchar(100) DEFAULT NULL,
  `family_name` varchar(100) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id_course` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_course`),
  UNIQUE KEY `id_course_UNIQUE` (`id_course`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `specialty`
--

CREATE TABLE `specialty` (
  `id_specialty` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_specialty`),
  UNIQUE KEY `id_specialty_UNIQUE` (`id_specialty`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id_teacher` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  CONSTRAINT `group_user_fk` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (`id_teacher`),
  UNIQUE KEY `id_teacher_UNIQUE` (`id_teacher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `group`
--

CREATE TABLE `group` (
  `id_group` int(11) NOT NULL AUTO_INCREMENT,
  `id_specialty` int(11) NOT NULL,
  `year` int(4) NOT NULL,
  `number` int(4) NOT NULL,
  PRIMARY KEY (`id_group`),
  UNIQUE KEY `id_group_UNIQUE` (`id_group`),
  KEY `group_id_specialty_idx` (`id_specialty`),
  CONSTRAINT `group_id_specialty_fk` FOREIGN KEY (`id_specialty`) REFERENCES `specialty` (`id_specialty`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `relation`
-- Table 'relation' replaces table 'course_teacher_grouop'
--

CREATE TABLE `relation` (
  `id_rel` int(11) NOT NULL AUTO_INCREMENT,
  `id_course` int(11) NOT NULL,
  `id_group` int(11) NOT NULL,
  `id_teacher` int(11) NOT NULL,
  PRIMARY KEY (`id_rel`),
  UNIQUE KEY `id_rel_UNIQUE` (`id_rel`),
  KEY `rel_id_group_idx` (`id_group`),
  KEY `rel_id_teacher_idx` (`id_teacher`),
  KEY `rel_id_course_idx` (`id_course`),
  CONSTRAINT `rel_course_fk` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rel_group_fk` FOREIGN KEY (`id_group`) REFERENCES `group` (`id_group`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rel_teacher_fk` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id_teacher`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `id_exam` int(11) NOT NULL AUTO_INCREMENT,
  `start_hour` timestamp NULL DEFAULT NULL,
  `end_hour` timestamp NULL DEFAULT NULL,
  `id_rel` int(11) DEFAULT NULL,
  `proposal` bit(1) DEFAULT NULL,
  `final_exam` bit(1) DEFAULT NULL,
  `room_number` varchar(64) DEFAULT NULL,
  `description` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id_exam`),
  UNIQUE KEY `id_exam_UNIQUE` (`id_exam`),
  KEY `exam_id_course_idx` (`id_rel`),
  CONSTRAINT `exam_id_course_fk` FOREIGN KEY (`id_rel`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id_student` int(11) NOT NULL AUTO_INCREMENT,
  `faculty_number` varchar(8) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_group` int(11) NOT NULL,
  PRIMARY KEY (`id_student`),
  UNIQUE KEY `id_student_UNIQUE` (`id_student`),
  UNIQUE KEY `faculty_number_UNIQUE` (`faculty_number`),
  KEY `student_id_group_idx` (`id_group`),
  CONSTRAINT `student_id_group` FOREIGN KEY (`id_group`) REFERENCES hackfmi_db.group (`id_group`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `student_id_user_idx` (`id_user`),
  CONSTRAINT `student_user_fk` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `vote`
--

CREATE TABLE `vote` (
  `id_vote` int(11) NOT NULL AUTO_INCREMENT,
  `id_student` int(11) DEFAULT NULL,
  `vote_count` int(4) DEFAULT 0,
  `id_exam` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_vote`),
  UNIQUE KEY `id_vote_UNIQUE` (`id_vote`),
  KEY `vote_id_exam_idx` (`id_exam`),
  KEY `vote_id_student_idx` (`id_student`),
  CONSTRAINT `vote_exam_fk` FOREIGN KEY (`id_exam`) REFERENCES `exam` (`id_exam`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `vote_student_fk` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
