CREATE TABLE IF NOT EXISTS tblAPLNews (
  `NewsId` INT NOT NULL AUTO_INCREMENT,
  `CategoryId` INT NOT NULL,
  `CreatedAt` DATETIME NOT NULL,
  `UpdatedAt` DATETIME NOT NULL,
  `CreatedBy` INT NOT NULL,
  `TitleId` INT NOT NULL,
  `htmlArchitecture` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`NewsId`),
  UNIQUE INDEX `NewsId_UNIQUE` (`NewsId` ASC));

ALTER TABLE tblAPLNews
  ADD CONSTRAINT tblAPLNews_tblAPLCategory_FK
FOREIGN KEY (CategoryId)
REFERENCES tblAPLCategory(CategoryId)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE tblAPLNews
  ADD CONSTRAINT tblAPLNews_tblSECUser_FK
FOREIGN KEY (CreatedBy)
REFERENCES tblSECUser(UserId)
  ON DELETE NO ACTION
  ON UPDATE CASCADE;
