ALTER TABLE tblDESTileTranslation
  ADD CONSTRAINT tblDECTileTranslation_tblAPLNews_FK
FOREIGN KEY (NewsId)
REFERENCES tblAPLNews(NewsId)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
