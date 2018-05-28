DELIMITER //
DROP TRIGGER IF EXISTS `before_insert_on_tblAPLNews`//
CREATE TRIGGER `before_insert_on_tblAPLNews`
  BEFORE INSERT ON `tblAPLNews`
    FOR EACH ROW
      BEGIN
        SET NEW.CreatedAt = NOW();
        SET NEW.UpdatedAt = NOW();
      END//
