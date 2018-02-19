CREATE TABLE IF NOT EXISTS tblSERTileTranslation (
  `NewsId` INT NOT NULL,
  `LanguageId` INT NOT NULL,
  `TileTranslation` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`TileTranslation`),
  UNIQUE INDEX `TileTranslation_UNIQUE` (`TileTranslation` ASC));

ALTER TABLE tblSERTileTranslation
  ADD CONSTRAINT tblSERTileTranslation_tblAPLNews_FK
FOREIGN KEY (NewsId)
REFERENCES tblAPLNews(NewsId)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE tblSERTileTranslation
  ADD CONSTRAINT tblSERTileTranslation_tblSERLanguage_FK
FOREIGN KEY (LanguageId)
REFERENCES tblSERLanguage(LanguageId)
  ON DELETE CASCADE
  ON UPDATE CASCADE;