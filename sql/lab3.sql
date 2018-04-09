CREATE USER 'Krupenin15'@'localhost' IDENTIFIED BY 'Krupenin';

SHOW GRANTS FOR 'Krupenin'@'localhost';

GRANT ALL ON news_blog.* TO 'flyway'@'localhost';

GRANT GRANT OPTION ON news_blog.* TO 'flyway'@'localhost';

FLUSH PRIVILEGES;

SHOW GRANTS FOR 'flyway'@'localhost';

DROP USER 'Krupenin'@'localhost';