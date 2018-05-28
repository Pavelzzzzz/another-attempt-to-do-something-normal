CREATE USER 'flyway'@'localhost' IDENTIFIED BY 'flyway';

GRANT ALL ON news_blog.* TO 'flyway'@'localhost';

GRANT GRANT OPTION ON news_blog.* TO 'flyway'@'localhost';

FLUSH PRIVILEGES;

SHOW GRANTS FOR 'flyway'@'localhost';

DROP USER 'flyway'@'localhost';