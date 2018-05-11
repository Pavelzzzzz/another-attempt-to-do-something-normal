DELIMITER //
DROP FUNCTION IF EXISTS maxTextIdFromTblDESTextTranslation//
CREATE FUNCTION maxTextIdFromTblDESTextTranslation ()
RETURNS INT
BEGIN
    RETURN (SELECT CONVERT(MAX(TextId), SIGNED INTEGER) from tblDESTextTranslation);
END//

DROP PROCEDURE IF EXISTS create_tblDESTextTranslationEntity//
CREATE PROCEDURE `create_tblDESTextTranslationEntity` (
  IN textId INT,
  IN languageId INT,
  IN textTranslation MEDIUMTEXT,
  OUT appointedTextId INT)
  BEGIN
    IF textId = -1 THEN
      SET textId = IFNULL((SELECT maxTextIdFromTblDESTextTranslation()), 0) + 1;
    END IF ;

  INSERT INTO `tblDESTextTranslation` (`TextId`, `LanguageId`, `TextTranslation`)
    VALUES (textId, languageId, textTranslation);
    SET appointedTextId = textId;
END//