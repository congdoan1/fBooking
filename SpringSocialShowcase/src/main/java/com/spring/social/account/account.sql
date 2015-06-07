CREATE TABLE `account` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'ucs2_unicode_ci',
	`password` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'ucs2_unicode_ci',
	`firstName` VARCHAR(50) NULL DEFAULT '0' COLLATE 'ucs2_unicode_ci',
	`lastName` VARCHAR(50) NULL DEFAULT '0' COLLATE 'ucs2_unicode_ci',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `username` (`username`)
)
COLLATE='ucs2_unicode_ci'
ENGINE=InnoDB
;