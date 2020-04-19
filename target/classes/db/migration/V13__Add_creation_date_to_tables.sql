ALTER TABLE `client_database`.`client`
ADD COLUMN `date_creation` DATETIME AFTER `phone2`;

ALTER TABLE `client_database`.`environment`
ADD COLUMN `date_creation` DATETIME AFTER `password`;

ALTER TABLE `client_database`.`connection`
ADD COLUMN `date_creation` DATETIME AFTER `description`;
