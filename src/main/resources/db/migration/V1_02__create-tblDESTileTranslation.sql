CREATE TABLE IF NOT EXISTS tblDESTileTranslation (
  `TileTranslationId` INT NOT NULL AUTO_INCREMENT,
  `NewsId` INT NOT NULL,
  `LanguageId` INT NOT NULL,
  `TileTranslation` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`TileTranslationId`),
  UNIQUE INDEX `TileTranslationId_UNIQUE` (`TileTranslationId` ASC));

ALTER TABLE tblDESTileTranslation
  ADD CONSTRAINT tblDECTileTranslation_tblSERLanguage_FK
FOREIGN KEY (LanguageId)
REFERENCES tblSERLanguage(LanguageId)
  ON DELETE CASCADE
  ON UPDATE CASCADE;