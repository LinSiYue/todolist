DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(32) DEFAULT NULL ,
  `pass_word` VARCHAR(16) DEFAULT NULL ,
  `phone` VARCHAR(11) DEFAULT NULL ,
  `roles` VARCHAR(11) DEFAULT NULL ,
  `introduction` VARCHAR(32) DEFAULT NULL ,
  `avatar` VARCHAR(255) DEFAULT NULL ,
  PRIMARY KEY (`id`)
)