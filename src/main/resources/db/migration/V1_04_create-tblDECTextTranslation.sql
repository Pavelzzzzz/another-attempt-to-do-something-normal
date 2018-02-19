CREATE TABLE IF NOT EXISTS tblDECTextTranslation (
  `TextId` INT NOT NULL,
  `LanguageId` INT NOT NULL,
  `TextTranslation` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`TextId`));

ALTER TABLE tblDECTextTranslation
  ADD CONSTRAINT tblDECTextTranslation_tblSERLanguage_FK
FOREIGN KEY (LanguageId)
REFERENCES tblSERLanguage(LanguageId)
  ON DELETE CASCADE
  ON UPDATE CASCADE;