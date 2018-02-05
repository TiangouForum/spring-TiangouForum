DROP TABLE IF EXISTS `tiangouforum`.`frmuserinf`;
CREATE TABLE `tiangouforum`.`frmuserinf` (
  `userregnam` VARCHAR(10) NOT NULL,
  `userpasswd` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`userregnam`))
ENGINE = InnoDB
COMMENT = '天狗论坛-用户信息';