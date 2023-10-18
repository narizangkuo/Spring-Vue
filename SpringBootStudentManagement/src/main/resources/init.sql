CREATE TABLE `ibatis_department` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_TIME` datetime NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `MANAGER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `ibatis_login_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_TIME` datetime NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `RGRENDER` varchar(255) DEFAULT NULL,
  `LOGIN_NAME` varchar(255) NOT NULL,
  `MOBILE` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `DEPARTMENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LOGIN_NAME` (`LOGIN_NAME`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;



INSERT INTO `ibatis_department` VALUES (1, '2023-3-7 14:51:36', 'DP1', 'Department for test', 1);
INSERT INTO `ibatis_department` VALUES (2, '2023-3-7 14:51:37', 'DP2', 'Department for test', 2);

INSERT INTO `ibatis_login_user` VALUES (1, '2023-3-7 16:22:29', NULL, NULL, 'peter', NULL, 'peter', '123', 1);
INSERT INTO `ibatis_login_user` VALUES (2, '2023-3-7 16:22:29', NULL, NULL, 'peter1', NULL, 'peter1', '123', 1);
INSERT INTO `ibatis_login_user` VALUES (3, '2023-3-8 11:07:51', NULL, NULL, 'peter2', NULL, 'peter2', '123', 2);

ALTER TABLE `ibatis_login_user` ADD FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `ibatis_department` (`ID`);
ALTER TABLE `ibatis_department` ADD FOREIGN KEY (`MANAGER_ID`) REFERENCES `ibatis_login_user` (`ID`);

