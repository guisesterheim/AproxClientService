CREATE TABLE `client_database`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(100) NOT NULL,
  `cnpj` VARCHAR(14) NOT NULL,
  `representative_first_name` VARCHAR(100) NULL,
  `representative_last_name` VARCHAR(100) NULL,
  `phone1` VARCHAR(20) NULL,
  `phone2` VARCHAR(20) NULL,
  PRIMARY KEY (`id`));