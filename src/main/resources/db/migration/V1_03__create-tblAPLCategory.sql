CREATE TABLE IF NOT EXISTS tblAPLCategory (
  `CategoryId` INT NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`CategoryId`),
  UNIQUE INDEX `CategoryName_UNIQUE` (`CategoryName` ASC));