DROP TABLE IF EXISTS `t_user`;
DROP TABLE IF EXISTS `t_project`;
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_user`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL ,
  `pass_word` VARCHAR(16) NOT NULL ,
  `phone` VARCHAR(11) NOT NULL ,
  `roles` VARCHAR(11) NOT NULL ,
  `introduction` VARCHAR(32) DEFAULT NULL ,
  `avatar` VARCHAR(255) DEFAULT NULL ,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_project`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(32) NOT NULL ,
  `description` VARCHAR(40) DEFAULT NULL ,
  `content` VARCHAR(255) DEFAULT NULL ,
  `manager` VARCHAR(32) NOT NULL ,
  `member` VARCHAR(255) DEFAULT NULL ,
  `time_sheet` INT(11) DEFAULT NULL ,
  `create_date` VARCHAR(16) NOT NULL ,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_task`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(32) NOT NULL ,
  `description` VARCHAR(40) DEFAULT NULL ,
  `content` VARCHAR(255) DEFAULT NULL ,
  `owner` VARCHAR(32) NOT NULL ,
  `time_sheet` INT(11) DEFAULT NULL ,
  `spent_time` INT(11) DEFAULT NULL ,
  `from_date` VARCHAR(16) NOT NULL ,
  `status` VARCHAR(11) NOT NULL ,
  `parent_project_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
)