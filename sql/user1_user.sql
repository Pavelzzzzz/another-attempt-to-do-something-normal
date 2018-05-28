CREATE USER 'user1'@'localhost' IDENTIFIED BY 'user1';

GRANT SELECT ON news_blog.* TO 'user1'@'localhost';

FLUSH PRIVILEGES;

DROP USER 'user1'@'localhost';

SELECT User,Host FROM mysql.user;