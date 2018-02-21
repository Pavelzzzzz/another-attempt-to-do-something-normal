CREATE TABLE IF NOT EXISTS tblDESTextTranslation (
  `TextId` INT NOT NULL,
  `LanguageId` INT NOT NULL,
  `TextTranslation` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`TextId`));

ALTER TABLE tblDESTextTranslation
  ADD CONSTRAINT tblDESTextTranslation_tblSERLanguage_FK
FOREIGN KEY (LanguageId)
REFERENCES tblSERLanguage(LanguageId)
  ON DELETE CASCADE
  ON UPDATE CASCADE;