ALTER TABLE `client_database`.`connection`
    DROP FOREIGN KEY `fk_environment_1`,
    DROP FOREIGN KEY `fk_environment_2`;
    ALTER TABLE `client_database`.`connection`
    CHANGE COLUMN `environment_a_id` `environmenta_id` INT(11) NOT NULL ,
    CHANGE COLUMN `environment_b_id` `environmentb_id` INT(11) NOT NULL ;
    ALTER TABLE `client_database`.`connection`
    ADD CONSTRAINT `fk_environment_1`
    FOREIGN KEY (`environmenta_id`)
    REFERENCES `client_database`.`environment` (`id`),
    ADD CONSTRAINT `fk_environment_2`
    FOREIGN KEY (`environmentb_id`)
    REFERENCES `client_database`.`environment` (`id`);