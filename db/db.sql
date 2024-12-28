# 방구석 코딩 JDBC 자바 텍스트 게시판 구현 강좌(https://github.com/SangWon7242)
# 데이터 베이스  삭제/생성/선택
DROP DATABASE IF EXISTS text_board;
CREATE DATABASE text_board;
USE text_board;

# JDBC 접속을 위행
GRANT ALL PRIVILEGES on *.* TO 'root'@'%' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO root IDENTIFIED BY 'mariadb';

# article 테이블 생성
CREATE TABLE article (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	`subject` CHAR(100) NOT NULL,
	content TEXT NOT NULL
);

