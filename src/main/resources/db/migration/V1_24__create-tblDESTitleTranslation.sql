CREATE TABLE IF NOT EXISTS tblDESTitleTranslation (
  `TitleTranslationId` INT NOT NULL AUTO_INCREMENT,
  `NewsId` INT NOT NULL,
  `LanguageId` INT NOT NULL,
  `TitleTranslation` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`TitleTranslationId`),
  UNIQUE INDEX `TitleTranslationId_UNIQUE` (`TitleTranslationId` ASC));

ALTER TABLE tblDESTitleTranslation
  ADD CONSTRAINT tblDECTitleTranslation_tblSERLanguage_FK
FOREIGN KEY (LanguageId)
REFERENCES tblSERLanguage(LanguageId)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE tblDESTitleTranslation
  ADD CONSTRAINT tblDECTitleTranslation_tblAPLNews_FK
FOREIGN KEY (NewsId)
REFERENCES tblAPLNews(NewsId)
  ON DELETE CASCADE
  ON UPDATE CASCADE;