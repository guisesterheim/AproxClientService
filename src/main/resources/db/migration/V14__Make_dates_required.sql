update client_database.`client` set date_creation = CURRENT_TIMESTAMP where id > 0;
ALTER TABLE `client_database`.`client`
CHANGE COLUMN `date_creation` `date_creation` DATETIME NOT NULL ;

update client_database.`connection` set date_creation = CURRENT_TIMESTAMP where id > 0;
ALTER TABLE `client_database`.`connection`
CHANGE COLUMN `date_creation` `date_creation` DATETIME NOT NULL ;

update client_database.`environment` set date_creation = CURRENT_TIMESTAMP where id > 0;
ALTER TABLE `client_database`.`environment`
CHANGE COLUMN `date_creation` `date_creation` DATETIME NOT NULL ;
