CREATE TABLE `client_database`.`environment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `application_name` VARCHAR(100) NOT NULL,
  `env_connection_description` VARCHAR(500) NULL,
  `connection_string` VARCHAR(500) NOT NULL,
  `connection_port` VARCHAR(4) NOT NULL,
  `connection_protocol` VARCHAR(40) NULL,
  `user` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `client_database`.`connection` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `environment_a_id` INT NOT NULL,
  `environment_b_id` INT NOT NULL,
  `description` VARCHAR(500) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_environment_1_idx` (`environment_a_id` ASC),
  INDEX `fk_environment_2_idx` (`environment_b_id` ASC),
  CONSTRAINT `fk_environment_1`
    FOREIGN KEY (`environment_a_id`)
    REFERENCES `client_database`.`environment` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_environment_2`
    FOREIGN KEY (`environment_b_id`)
    REFERENCES `client_database`.`environment` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);

CREATE TABLE `client_database`.`connection_environment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `connection_id` INT NOT NULL,
  `environment_id` INT NOT NULL,
  PRIMARY KEY (`id`));
