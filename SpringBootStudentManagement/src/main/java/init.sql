CREATE SCHEMA spring_exam;

CREATE TABLE `school` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
	`NAME` varchar(50) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
	`DELETE` INT NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
insert into school value(1, '软件学院', '2020-01-01', 0);
insert into school value(2, '软件与微电子学院', '2010-01-01', 1);
insert into school value(3, '数学学院', '2010-01-01', 0);
insert into school value(4, '计算机学院', '2010-01-01', 0);
insert into school value(5, '电气学院', '2010-01-01', 0);