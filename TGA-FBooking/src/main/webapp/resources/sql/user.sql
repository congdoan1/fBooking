CREATE TABLE `user` (
	`Id` INT(11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL DEFAULT '0' COLLATE 'utf8_general_ci',
	`password` VARCHAR(30) NULL DEFAULT '0' COLLATE 'utf8_general_ci',
	`firstName` VARCHAR(30) NULL DEFAULT '0' COLLATE 'utf8_general_ci',
	`lastName` VARCHAR(30) NOT NULL DEFAULT '0' COLLATE 'utf8_general_ci',
	`facebookId` CHAR(15) NULL DEFAULT '0' COLLATE 'utf8_unicode_ci',
	`facebookUrl` VARCHAR(80) NULL DEFAULT '0' COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`Id`),
	UNIQUE INDEX `username` (`username`)
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;
