CREATE TABLE `client_database`.`usage` (
  `id` INT NOT NULL,
  `client_id` INT NOT NULL,
  `month` DATE NULL,
  `request_count` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_client_usage_idx` (`client_id` ASC),
  CONSTRAINT `fk_client_usage`
    FOREIGN KEY (`client_id`)
    REFERENCES `client_database`.`client` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);