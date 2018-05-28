DELIMITER //
DROP TRIGGER IF EXISTS `before_update_on_tblAPLNews`//
CREATE TRIGGER `before_update_on_tblAPLNews`
  BEFORE INSERT ON `tblAPLNews`
    FOR EACH ROW
      BEGIN
        SET NEW.UpdatedAt = NOW();
      END//
