-- 할일
DROP TABLE IF EXISTS todo RESTRICT;

-- 우선순위
DROP TABLE IF EXISTS priority RESTRICT;

-- 회원
DROP TABLE IF EXISTS members RESTRICT;

-- 할일첨부파일
DROP TABLE IF EXISTS todo_files RESTRICT;

-- 할일
CREATE TABLE todo (
	todo_no     INTEGER     NOT NULL COMMENT '할일 번호', -- 할일 번호
	priority_no INTEGER     NOT NULL COMMENT '우선순위 번호', -- 우선순위 번호
	member_no   INTEGER     NOT NULL COMMENT '회원 번호', -- 회원 번호
	title       VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
	content     TEXT        NOT NULL COMMENT '내용', -- 내용
	deadline    DATE        NOT NULL COMMENT '기한' -- 기한
)
COMMENT '할일';


insert into


-- 할일
ALTER TABLE todo
	ADD CONSTRAINT PK_todo -- 할일 기본키
	PRIMARY KEY (
	todo_no -- 할일 번호
	);

ALTER TABLE todo
	MODIFY COLUMN todo_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '할일 번호';

ALTER TABLE todo
	AUTO_INCREMENT = 1001;

-- 우선순위
CREATE TABLE priority (
	priority_no INTEGER     NOT NULL COMMENT '우선순위 번호', -- 우선순위 번호
	priority    VARCHAR(50) NOT NULL COMMENT '우선순위' -- 우선순위
)
COMMENT '우선순위';

-- 우선순위
ALTER TABLE priority
	ADD CONSTRAINT PK_priority -- 우선순위 기본키
	PRIMARY KEY (
	priority_no -- 우선순위 번호
	);

-- 우선순위 유니크 인덱스
CREATE UNIQUE INDEX UIX_priority
	ON priority ( -- 우선순위
		priority ASC -- 우선순위
	);

-- 회원
CREATE TABLE members (
	member_no    INTEGER      NOT NULL COMMENT '회원 번호', -- 회원 번호
	name         VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	email        VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	password     VARCHAR(255) NOT NULL COMMENT '비밀번호', -- 비밀번호
	created_date DATETIME     NULL     DEFAULT now() COMMENT '생성일' -- 생성일
)
COMMENT '회원';

-- 회원
ALTER TABLE members
	ADD CONSTRAINT PK_members -- 회원 기본키
	PRIMARY KEY (
	member_no -- 회원 번호
	);

ALTER TABLE members
	MODIFY COLUMN member_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원 번호';

ALTER TABLE members
	AUTO_INCREMENT = 101;

-- 할일첨부파일
CREATE TABLE todo_files (
	file_no   INTEGER     NOT NULL COMMENT '첨부파일 번호', -- 첨부파일 번호
	todo_no   INTEGER     NOT NULL COMMENT '할일 번호', -- 할일 번호
	file_path VARCHAR(50) NOT NULL COMMENT '파일 경로' -- 파일 경로
)
COMMENT '할일첨부파일';

-- 할일첨부파일
ALTER TABLE todo_files
	ADD CONSTRAINT PK_todo_files -- 할일첨부파일 기본키
	PRIMARY KEY (
	file_no -- 첨부파일 번호
	);

ALTER TABLE todo_files
	MODIFY COLUMN file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '첨부파일 번호';

ALTER TABLE todo_files
	AUTO_INCREMENT = 2001;

-- 할일
ALTER TABLE todo
	ADD CONSTRAINT FK_priority_TO_todo -- 우선순위 -> 할일
	FOREIGN KEY (
	priority_no -- 우선순위 번호
	)
	REFERENCES priority ( -- 우선순위
	priority_no -- 우선순위 번호
	);

-- 할일
ALTER TABLE todo
	ADD CONSTRAINT FK_members_TO_todo -- 회원 -> 할일
	FOREIGN KEY (
	member_no -- 회원 번호
	)
	REFERENCES members ( -- 회원
	member_no -- 회원 번호
	);

-- 할일첨부파일
ALTER TABLE todo_files
	ADD CONSTRAINT FK_todo_TO_todo_files -- 할일 -> 할일첨부파일
	FOREIGN KEY (
	todo_no -- 할일 번호
	)
	REFERENCES todo ( -- 할일
	todo_no -- 할일 번호
	);