CREATE SCHEMA IF NOT EXISTS `lojainformatica`;

USE `lojainformatica`;

CREATE TABLE IF NOT EXISTS `lojainformatica`.`computador` (
  `IdComputador` INT NOT NULL AUTO_INCREMENT,
  `processador` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `hd` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`IdComputador`)
);

INSERT INTO computador (processador, marca, hd ) VALUES ("Processador","Marca","HD");

SELECT * FROM lojainformatica.computador;