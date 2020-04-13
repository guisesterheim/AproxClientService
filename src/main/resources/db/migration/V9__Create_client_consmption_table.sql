CREATE TABLE `client_database`.`client_consumption` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `client_id` INT NOT NULL,
  `consumption_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_client_idx` (`client_id` ASC),
  INDEX `fk_consumption_idx` (`consumption_id` ASC),
  CONSTRAINT `fk_client`
    FOREIGN KEY (`client_id`)
    REFERENCES `client_database`.`client` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_consumption`
    FOREIGN KEY (`consumption_id`)
    REFERENCES `client_database`.`consumption` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
