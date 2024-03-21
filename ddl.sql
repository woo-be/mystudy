-- 회원
DROP TABLE IF EXISTS member RESTRICT;

-- 알림
DROP TABLE IF EXISTS alarm RESTRICT;

-- 여행후기즐겨찾기
DROP TABLE IF EXISTS review_scrap RESTRICT;

-- 여행후기 좋아요
DROP TABLE IF EXISTS review_good RESTRICT;

-- 여행후기게시판댓글
DROP TABLE IF EXISTS review_comment RESTRICT;

-- 여행후기게시판
DROP TABLE IF EXISTS review_board RESTRICT;

-- 여행후기사진
DROP TABLE IF EXISTS review_photo RESTRICT;

-- 관심테마
DROP TABLE IF EXISTS interest_theme RESTRICT;

-- 테마
DROP TABLE IF EXISTS theme RESTRICT;

-- 지역
DROP TABLE IF EXISTS region RESTRICT;

-- 여행멤버모집게시글
DROP TABLE IF EXISTS recruit_board RESTRICT;

-- 여행모집사진
DROP TABLE IF EXISTS recruit_photo RESTRICT;

-- 여행멤버모집게시판댓글
DROP TABLE IF EXISTS recruit_comment RESTRICT;

-- 여행멤버
DROP TABLE IF EXISTS recruit_member RESTRICT;

-- 메시지
DROP TABLE IF EXISTS msg RESTRICT;

-- 여행계획게시물
DROP TABLE IF EXISTS plan_board RESTRICT;

-- 여행계획게시물사진
DROP TABLE IF EXISTS plan_photo RESTRICT;

-- 준비물
DROP TABLE IF EXISTS material RESTRICT;

-- 준비물사진
DROP TABLE IF EXISTS material_photo RESTRICT;

-- 모집즐겨찾기
DROP TABLE IF EXISTS recruit_scrap RESTRICT;

-- 모집좋아요
DROP TABLE IF EXISTS recruit_like RESTRICT;

-- 회원
CREATE TABLE member (
	member_id    INTEGER      NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	email        VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	phone_number VARCHAR(30)  NOT NULL COMMENT '휴대폰번호', -- 휴대폰번호
	password     VARCHAR(100) NOT NULL COMMENT '비밀번호', -- 비밀번호
	name         VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	nickname     VARCHAR(50)  NOT NULL COMMENT '닉네임', -- 닉네임
	birth_date   DATETIME     NOT NULL COMMENT '생년월일', -- 생년월일
	gender       BOOLEAN      NOT NULL COMMENT '성별', -- 성별
	profile      VARCHAR(255) NULL     COMMENT '프로필 사진', -- 프로필 사진
	introduce    TEXT         NOT NULL COMMENT '자기소개' -- 자기소개
)
COMMENT '회원';

-- 회원
ALTER TABLE member
	ADD CONSTRAINT PK_member -- 회원 기본키
	PRIMARY KEY (
	member_id -- 회원 식별번호
	);

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_member
	ON member ( -- 회원
		email ASC -- 이메일
	);

-- 회원 유니크 인덱스2
CREATE UNIQUE INDEX UIX_member2
	ON member ( -- 회원
		phone_number ASC -- 휴대폰번호
	);

ALTER TABLE member
	MODIFY COLUMN member_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원 식별번호';

-- 알림
CREATE TABLE alarm (
	alarm_id  INTEGER NOT NULL COMMENT '알림 식별자', -- 알림 식별자
	member_id INTEGER NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	content   TEXT    NOT NULL COMMENT '내용', -- 내용
	checked     BOOLEAN NOT NULL DEFAULT false COMMENT '읽음여부' -- 읽음여부
)
COMMENT '알림';

-- 알림
ALTER TABLE alarm
	ADD CONSTRAINT PK_alarm -- 알림 기본키
	PRIMARY KEY (
	alarm_id -- 알림 식별자
	);

ALTER TABLE alarm
	MODIFY COLUMN alarm_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '알림 식별자';

-- 여행후기즐겨찾기
CREATE TABLE review_scrap (
	member_id       INTEGER NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	review_board_id INTEGER NOT NULL COMMENT '여행후기게시판번호' -- 여행후기게시판번호
)
COMMENT '여행후기즐겨찾기';

-- 여행후기즐겨찾기
ALTER TABLE review_scrap
	ADD CONSTRAINT PK_review_scrap -- 여행후기즐겨찾기 기본키
	PRIMARY KEY (
	member_id,       -- 회원 식별번호
	review_board_id  -- 여행후기게시판번호
	);

-- 여행후기 좋아요
CREATE TABLE review_good (
	member_id       INTEGER NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	review_board_id INTEGER NOT NULL COMMENT '여행후기게시판번호' -- 여행후기게시판번호
)
COMMENT '여행후기 좋아요';

-- 여행후기 좋아요
ALTER TABLE review_good
	ADD CONSTRAINT PK_review_good -- 여행후기 좋아요 기본키
	PRIMARY KEY (
	member_id,       -- 회원 식별번호
	review_board_id  -- 여행후기게시판번호
	);

-- 여행후기게시판댓글
CREATE TABLE review_comment (
	review_comment_id INTEGER NOT NULL COMMENT '여행후기게시판댓글번호', -- 여행후기게시판댓글번호
	member_id         INTEGER NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	review_board_id   INTEGER NOT NULL COMMENT '여행후기게시판번호', -- 여행후기게시판번호
	content           TEXT    NOT NULL COMMENT '내용', -- 내용
	created_date      DATETIME    NOT NULL DEFAULT now() COMMENT '작성일' -- 작성일
)
COMMENT '여행후기게시판댓글';

-- 여행후기게시판댓글
ALTER TABLE review_comment
	ADD CONSTRAINT PK_review_comment -- 여행후기게시판댓글 기본키
	PRIMARY KEY (
	review_comment_id -- 여행후기게시판댓글번호
	);

ALTER TABLE review_comment
	MODIFY COLUMN review_comment_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '여행후기게시판댓글번호';

-- 여행후기게시판
CREATE TABLE review_board (
	review_board_id INTEGER      NOT NULL COMMENT '여행후기게시판번호', -- 여행후기게시판번호
	theme_id        INTEGER      NOT NULL COMMENT '테마식별번호', -- 테마식별번호
	member_id       INTEGER      NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	region_id       INTEGER      NOT NULL COMMENT '지역식별자', -- 지역식별자
	title           VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	created_date    DATETIME         NOT NULL DEFAULT now() COMMENT '게시일', -- 게시일
	content         MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	like_count      INTEGER      NOT NULL DEFAULT 0 COMMENT '좋아요수', -- 좋아요수
	latitude        FLOAT        NOT NULL COMMENT '위도', -- 위도
	longitude       FLOAT        NOT NULL COMMENT '경도', -- 경도
	views           INTEGER      NOT NULL DEFAULT 0 COMMENT '조회수' -- 조회수
)
COMMENT '여행후기게시판';

-- 여행후기게시판
ALTER TABLE review_board
	ADD CONSTRAINT PK_review_board -- 여행후기게시판 기본키
	PRIMARY KEY (
	review_board_id -- 여행후기게시판번호
	);

ALTER TABLE review_board
	MODIFY COLUMN review_board_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '여행후기게시판번호';

-- 여행후기사진
CREATE TABLE review_photo (
	review_photo_id INTEGER      NOT NULL COMMENT '여행후기사진번호', -- 여행후기사진번호
	review_board_id INTEGER      NOT NULL COMMENT '여행후기게시판번호', -- 여행후기게시판번호
	photo           VARCHAR(255) NOT NULL COMMENT '사진' -- 사진
)
COMMENT '여행후기사진';

-- 여행후기사진
ALTER TABLE review_photo
	ADD CONSTRAINT PK_review_photo -- 여행후기사진 기본키
	PRIMARY KEY (
	review_photo_id -- 여행후기사진번호
	);

ALTER TABLE review_photo
	MODIFY COLUMN review_photo_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '여행후기사진번호';

-- 관심테마
CREATE TABLE interest_theme (
	theme_id  INTEGER NOT NULL COMMENT '테마식별번호', -- 테마식별번호
	member_id INTEGER NOT NULL COMMENT '회원 식별번호' -- 회원 식별번호
)
COMMENT '관심테마';

-- 관심테마
ALTER TABLE interest_theme
	ADD CONSTRAINT PK_interest_theme -- 관심테마 기본키
	PRIMARY KEY (
	theme_id,  -- 테마식별번호
	member_id  -- 회원 식별번호
	);

-- 테마
CREATE TABLE theme (
	theme_id   INTEGER     NOT NULL COMMENT '테마식별번호', -- 테마식별번호
	theme_name VARCHAR(50) NOT NULL COMMENT '테마이름' -- 테마이름
)
COMMENT '테마';

-- 테마
ALTER TABLE theme
	ADD CONSTRAINT PK_theme -- 테마 기본키
	PRIMARY KEY (
	theme_id -- 테마식별번호
	);

ALTER TABLE theme
	MODIFY COLUMN theme_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '테마식별번호';

-- 지역
CREATE TABLE region (
	region_id   INTEGER     NOT NULL COMMENT '지역식별자', -- 지역식별자
	region_name VARCHAR(50) NOT NULL COMMENT '지역이름' -- 지역이름
)
COMMENT '지역';

-- 지역
ALTER TABLE region
	ADD CONSTRAINT PK_region -- 지역 기본키
	PRIMARY KEY (
	region_id -- 지역식별자
	);

ALTER TABLE region
	MODIFY COLUMN region_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '지역식별자';

-- 여행멤버모집게시글
CREATE TABLE recruit_board (
	recruit_board_id INTEGER      NOT NULL COMMENT '여행멤버모집게시글번호', -- 여행멤버모집게시글번호
	member_id        INTEGER      NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	region_id        INTEGER      NOT NULL COMMENT '지역식별자', -- 지역식별자
	theme_id         INTEGER      NOT NULL COMMENT '테마식별자', -- 테마식별자
	title            VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	content          MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	start_date       DATETIME     NOT NULL COMMENT '여행시작일', -- 여행시작일
	end_date         DATETIME     NOT NULL COMMENT '여행종료일', -- 여행종료일
	recruit_total    INTEGER      NOT NULL COMMENT '모집인원', -- 모집인원
	deadline         DATETIME     NOT NULL COMMENT '모집마감일자', -- 모집마감일자
	state            BOOLEAN      NOT NULL COMMENT '모집상태', -- 모집상태
	created_date     DATETIME     NOT NULL DEFAULT now() COMMENT '작성일자', -- 작성일자
	latitude         FLOAT        NOT NULL COMMENT '위도', -- 위도
	longitude        FLOAT        NOT NULL COMMENT '경도', -- 경도
	views            INTEGER      NOT NULL DEFAULT 0 COMMENT '조회수' -- 조회수
)
COMMENT '여행멤버모집게시글';

-- 여행멤버모집게시글
ALTER TABLE recruit_board
	ADD CONSTRAINT PK_recruit_board -- 여행멤버모집게시글 기본키
	PRIMARY KEY (
	recruit_board_id -- 여행멤버모집게시글번호
	);

ALTER TABLE recruit_board
	MODIFY COLUMN recruit_board_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '여행멤버모집게시글번호';

-- 여행모집사진
CREATE TABLE recruit_photo (
	recruit_photo_id INTEGER      NOT NULL COMMENT '여행모집사진식별자', -- 여행모집사진식별자
	recruit_id       INTEGER      NOT NULL COMMENT '여행멤버모집게시글번호', -- 여행멤버모집게시글번호
	photo            VARCHAR(255) NOT NULL COMMENT '사진' -- 사진
)
COMMENT '여행모집사진';

-- 여행모집사진
ALTER TABLE recruit_photo
	ADD CONSTRAINT PK_recruit_photo -- 여행모집사진 기본키
	PRIMARY KEY (
	recruit_photo_id -- 여행모집사진식별자
	);

ALTER TABLE recruit_photo
	MODIFY COLUMN recruit_photo_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '여행모집사진식별자';

-- 여행멤버모집게시판댓글
CREATE TABLE recruit_comment (
	recruit_comment_id INTEGER NOT NULL COMMENT '여행후기게시판댓글번호', -- 여행후기게시판댓글번호
	recruit_board_id   INTEGER NOT NULL COMMENT '여행멤버모집게시글번호', -- 여행멤버모집게시글번호
	member_id          INTEGER NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	content            TEXT    NOT NULL COMMENT '내용', -- 내용
	created_date       DATETIME    NOT NULL DEFAULT now() COMMENT '작성일' -- 작성일
)
COMMENT '여행멤버모집게시판댓글';

-- 여행멤버모집게시판댓글
ALTER TABLE recruit_comment
	ADD CONSTRAINT PK_recruit_comment -- 여행멤버모집게시판댓글 기본키
	PRIMARY KEY (
	recruit_comment_id -- 여행후기게시판댓글번호
	);

ALTER TABLE recruit_comment
	MODIFY COLUMN recruit_comment_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '여행후기게시판댓글번호';

-- 여행멤버
CREATE TABLE recruit_member (
	recruit_board_id INTEGER NOT NULL COMMENT '여행멤버모집게시글번호', -- 여행멤버모집게시글번호
	member_id        INTEGER NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	state            BOOLEAN NOT NULL DEFAULT false COMMENT '상태' -- 상태
)
COMMENT '여행멤버';

-- 여행멤버
ALTER TABLE recruit_member
	ADD CONSTRAINT PK_recruit_member -- 여행멤버 기본키
	PRIMARY KEY (
	recruit_board_id, -- 여행멤버모집게시글번호
	member_id         -- 회원 식별번호
	);

-- 메시지
CREATE TABLE msg (
	msg_id           INTEGER  NOT NULL COMMENT '메시지식별자', -- 메시지식별자
	recruit_board_id INTEGER  NOT NULL COMMENT '여행멤버모집게시글번호', -- 여행멤버모집게시글번호
	member_id        INTEGER  NOT NULL COMMENT '회원 식별번호', -- 회원 식별번호
	content          TEXT     NOT NULL COMMENT '채팅내용', -- 채팅내용
	time             DATETIME NOT NULL DEFAULT now() COMMENT '보낸시간' -- 보낸시간
)
COMMENT '메시지';

-- 메시지
ALTER TABLE msg
	ADD CONSTRAINT PK_msg -- 메시지 기본키
	PRIMARY KEY (
	msg_id -- 메시지식별자
	);

ALTER TABLE msg
	MODIFY COLUMN msg_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '메시지식별자';

-- 여행계획게시물
CREATE TABLE plan_board (
	plan_board_id    INTEGER      NOT NULL COMMENT '여행계획게시물식별자', -- 여행계획게시물식별자
	recruit_board_id INTEGER      NOT NULL COMMENT '여행멤버모집게시글번호', -- 여행멤버모집게시글번호
	title            VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	content          MEDIUMTEXT   NULL     COMMENT '내용', -- 내용
	trip_date        DATETIME     NOT NULL COMMENT '여행일자', -- 여행일자
	trip_order       INTEGER      NOT NULL COMMENT '여행루트순서', -- 여행루트순서
	latitude         FLOAT        NOT NULL COMMENT '위도', -- 위도
	longitude        FLOAT        NOT NULL COMMENT '경도' -- 경도
)
COMMENT '여행계획게시물';

-- 여행계획게시물
ALTER TABLE plan_board
	ADD CONSTRAINT PK_plan_board -- 여행계획게시물 기본키
	PRIMARY KEY (
	plan_board_id -- 여행계획게시물식별자
	);

ALTER TABLE plan_board
	MODIFY COLUMN plan_board_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '여행계획게시물식별자';

-- 여행계획게시물사진
CREATE TABLE plan_photo (
	plan_photo_id INTEGER      NOT NULL COMMENT '여행계획게시물사진번호', -- 여행계획게시물사진번호
	plan_board_id INTEGER      NOT NULL COMMENT '여행계획게시물식별자', -- 여행계획게시물식별자
	photo         VARCHAR(255) NOT NULL COMMENT '사진' -- 사진
)
COMMENT '여행계획게시물사진';

-- 여행계획게시물사진
ALTER TABLE plan_photo
	ADD CONSTRAINT PK_plan_photo -- 여행계획게시물사진 기본키
	PRIMARY KEY (
	plan_photo_id -- 여행계획게시물사진번호
	);

ALTER TABLE plan_photo
	MODIFY COLUMN plan_photo_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '여행계획게시물사진번호';

-- 준비물
CREATE TABLE material (
	material_id      INTEGER     NOT NULL COMMENT '준비물식별자', -- 준비물식별자
	recruit_board_id INTEGER     NOT NULL COMMENT '여행멤버모집게시글번호', -- 여행멤버모집게시글번호
	name             VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
	content          MEDIUMTEXT  NOT NULL COMMENT '내용', -- 내용
	count            INTEGER     NOT NULL COMMENT '수량', -- 수량
	state            BOOLEAN     NOT NULL DEFAULT false COMMENT '상태' -- 상태
)
COMMENT '준비물';

-- 준비물
ALTER TABLE material
	ADD CONSTRAINT PK_material -- 준비물 기본키
	PRIMARY KEY (
	material_id -- 준비물식별자
	);

ALTER TABLE material
	MODIFY COLUMN material_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '준비물식별자';

-- 준비물사진
CREATE TABLE material_photo (
	material_photo_id INTEGER      NOT NULL COMMENT '준비물사진식별자', -- 준비물사진식별자
	material_id       INTEGER      NOT NULL COMMENT '준비물식별자', -- 준비물식별자
	material_photo    VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '준비물사진';

-- 준비물사진
ALTER TABLE material_photo
	ADD CONSTRAINT PK_material_photo -- 준비물사진 기본키
	PRIMARY KEY (
	material_photo_id -- 준비물사진식별자
	);

ALTER TABLE material_photo
	MODIFY COLUMN material_photo_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '준비물사진식별자';

-- 모집즐겨찾기
CREATE TABLE recruit_scrap (
	recruit_board_id INTEGER NOT NULL COMMENT '여행멤버모집게시글번호', -- 여행멤버모집게시글번호
	member_id        INTEGER NOT NULL COMMENT '회원 식별번호' -- 회원 식별번호
)
COMMENT '모집즐겨찾기';

-- 모집즐겨찾기
ALTER TABLE recruit_scrap
	ADD CONSTRAINT PK_recruit_scrap -- 모집즐겨찾기 기본키
	PRIMARY KEY (
	recruit_board_id, -- 여행멤버모집게시글번호
	member_id         -- 회원 식별번호
	);

-- 모집좋아요
CREATE TABLE recruit_like (
	recruit_board_id INTEGER NOT NULL COMMENT '여행멤버모집게시글번호', -- 여행멤버모집게시글번호
	member_id        INTEGER NOT NULL COMMENT '회원 식별번호' -- 회원 식별번호
)
COMMENT '모집좋아요';

-- 모집좋아요
ALTER TABLE recruit_like
	ADD CONSTRAINT PK_recruit_like -- 모집좋아요 기본키
	PRIMARY KEY (
	recruit_board_id, -- 여행멤버모집게시글번호
	member_id         -- 회원 식별번호
	);

-- 알림
ALTER TABLE alarm
	ADD CONSTRAINT FK_member_TO_alarm -- 회원 -> 알림
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 여행후기즐겨찾기
ALTER TABLE review_scrap
	ADD CONSTRAINT FK_member_TO_review_scrap -- 회원 -> 여행후기즐겨찾기
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 여행후기즐겨찾기
ALTER TABLE review_scrap
	ADD CONSTRAINT FK_review_board_TO_review_scrap -- 여행후기게시판 -> 여행후기즐겨찾기
	FOREIGN KEY (
	review_board_id -- 여행후기게시판번호
	)
	REFERENCES review_board ( -- 여행후기게시판
	review_board_id -- 여행후기게시판번호
	);

-- 여행후기 좋아요
ALTER TABLE review_good
	ADD CONSTRAINT FK_member_TO_review_good -- 회원 -> 여행후기 좋아요
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 여행후기 좋아요
ALTER TABLE review_good
	ADD CONSTRAINT FK_review_board_TO_review_good -- 여행후기게시판 -> 여행후기 좋아요
	FOREIGN KEY (
	review_board_id -- 여행후기게시판번호
	)
	REFERENCES review_board ( -- 여행후기게시판
	review_board_id -- 여행후기게시판번호
	);

-- 여행후기게시판댓글
ALTER TABLE review_comment
	ADD CONSTRAINT FK_member_TO_review_comment -- 회원 -> 여행후기게시판댓글
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 여행후기게시판댓글
ALTER TABLE review_comment
	ADD CONSTRAINT FK_review_board_TO_review_comment -- 여행후기게시판 -> 여행후기게시판댓글
	FOREIGN KEY (
	review_board_id -- 여행후기게시판번호
	)
	REFERENCES review_board ( -- 여행후기게시판
	review_board_id -- 여행후기게시판번호
	);

-- 여행후기게시판
ALTER TABLE review_board
	ADD CONSTRAINT FK_member_TO_review_board -- 회원 -> 여행후기게시판
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 여행후기게시판
ALTER TABLE review_board
	ADD CONSTRAINT FK_theme_TO_review_board -- 테마 -> 여행후기게시판
	FOREIGN KEY (
	theme_id -- 테마식별번호
	)
	REFERENCES theme ( -- 테마
	theme_id -- 테마식별번호
	);

-- 여행후기게시판
ALTER TABLE review_board
	ADD CONSTRAINT FK_region_TO_review_board -- 지역 -> 여행후기게시판
	FOREIGN KEY (
	region_id -- 지역식별자
	)
	REFERENCES region ( -- 지역
	region_id -- 지역식별자
	);

-- 여행후기사진
ALTER TABLE review_photo
	ADD CONSTRAINT FK_review_board_TO_review_photo -- 여행후기게시판 -> 여행후기사진
	FOREIGN KEY (
	review_board_id -- 여행후기게시판번호
	)
	REFERENCES review_board ( -- 여행후기게시판
	review_board_id -- 여행후기게시판번호
	);

-- 관심테마
ALTER TABLE interest_theme
	ADD CONSTRAINT FK_theme_TO_interest_theme -- 테마 -> 관심테마
	FOREIGN KEY (
	theme_id -- 테마식별번호
	)
	REFERENCES theme ( -- 테마
	theme_id -- 테마식별번호
	);

-- 관심테마
ALTER TABLE interest_theme
	ADD CONSTRAINT FK_member_TO_interest_theme -- 회원 -> 관심테마
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 여행멤버모집게시글
ALTER TABLE recruit_board
	ADD CONSTRAINT FK_region_TO_recruit_board -- 지역 -> 여행멤버모집게시글
	FOREIGN KEY (
	region_id -- 지역식별자
	)
	REFERENCES region ( -- 지역
	region_id -- 지역식별자
	);

-- 여행멤버모집게시글
ALTER TABLE recruit_board
	ADD CONSTRAINT FK_theme_TO_recruit_board -- 테마 -> 여행멤버모집게시글
	FOREIGN KEY (
	theme_id -- 테마식별자
	)
	REFERENCES theme ( -- 테마
	theme_id -- 테마식별번호
	);

-- 여행멤버모집게시글
ALTER TABLE recruit_board
	ADD CONSTRAINT FK_member_TO_recruit_board -- 회원 -> 여행멤버모집게시글
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 여행모집사진
ALTER TABLE recruit_photo
	ADD CONSTRAINT FK_recruit_board_TO_recruit_photo -- 여행멤버모집게시글 -> 여행모집사진
	FOREIGN KEY (
	recruit_id -- 여행멤버모집게시글번호
	)
	REFERENCES recruit_board ( -- 여행멤버모집게시글
	recruit_board_id -- 여행멤버모집게시글번호
	);

-- 여행멤버모집게시판댓글
ALTER TABLE recruit_comment
	ADD CONSTRAINT FK_recruit_board_TO_recruit_comment -- 여행멤버모집게시글 -> 여행멤버모집게시판댓글
	FOREIGN KEY (
	recruit_board_id -- 여행멤버모집게시글번호
	)
	REFERENCES recruit_board ( -- 여행멤버모집게시글
	recruit_board_id -- 여행멤버모집게시글번호
	);

-- 여행멤버모집게시판댓글
ALTER TABLE recruit_comment
	ADD CONSTRAINT FK_member_TO_recruit_comment -- 회원 -> 여행멤버모집게시판댓글
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 여행멤버
ALTER TABLE recruit_member
	ADD CONSTRAINT FK_recruit_board_TO_recruit_member -- 여행멤버모집게시글 -> 여행멤버
	FOREIGN KEY (
	recruit_board_id -- 여행멤버모집게시글번호
	)
	REFERENCES recruit_board ( -- 여행멤버모집게시글
	recruit_board_id -- 여행멤버모집게시글번호
	);

-- 여행멤버
ALTER TABLE recruit_member
	ADD CONSTRAINT FK_member_TO_recruit_member -- 회원 -> 여행멤버
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 메시지
ALTER TABLE msg
	ADD CONSTRAINT FK_recruit_member_TO_msg -- 여행멤버 -> 메시지
	FOREIGN KEY (
	recruit_board_id, -- 여행멤버모집게시글번호
	member_id         -- 회원 식별번호
	)
	REFERENCES recruit_member ( -- 여행멤버
	recruit_board_id, -- 여행멤버모집게시글번호
	member_id         -- 회원 식별번호
	);

-- 여행계획게시물
ALTER TABLE plan_board
	ADD CONSTRAINT FK_recruit_board_TO_plan_board -- 여행멤버모집게시글 -> 여행계획게시물
	FOREIGN KEY (
	recruit_board_id -- 여행멤버모집게시글번호
	)
	REFERENCES recruit_board ( -- 여행멤버모집게시글
	recruit_board_id -- 여행멤버모집게시글번호
	);

-- 여행계획게시물사진
ALTER TABLE plan_photo
	ADD CONSTRAINT FK_plan_board_TO_plan_photo -- 여행계획게시물 -> 여행계획게시물사진
	FOREIGN KEY (
	plan_board_id -- 여행계획게시물식별자
	)
	REFERENCES plan_board ( -- 여행계획게시물
	plan_board_id -- 여행계획게시물식별자
	);

-- 준비물
ALTER TABLE material
	ADD CONSTRAINT FK_recruit_board_TO_material -- 여행멤버모집게시글 -> 준비물
	FOREIGN KEY (
	recruit_board_id -- 여행멤버모집게시글번호
	)
	REFERENCES recruit_board ( -- 여행멤버모집게시글
	recruit_board_id -- 여행멤버모집게시글번호
	);

-- 준비물사진
ALTER TABLE material_photo
	ADD CONSTRAINT FK_material_TO_material_photo -- 준비물 -> 준비물사진
	FOREIGN KEY (
	material_id -- 준비물식별자
	)
	REFERENCES material ( -- 준비물
	material_id -- 준비물식별자
	);

-- 모집즐겨찾기
ALTER TABLE recruit_scrap
	ADD CONSTRAINT FK_recruit_board_TO_recruit_scrap -- 여행멤버모집게시글 -> 모집즐겨찾기
	FOREIGN KEY (
	recruit_board_id -- 여행멤버모집게시글번호
	)
	REFERENCES recruit_board ( -- 여행멤버모집게시글
	recruit_board_id -- 여행멤버모집게시글번호
	);

-- 모집즐겨찾기
ALTER TABLE recruit_scrap
	ADD CONSTRAINT FK_member_TO_recruit_scrap -- 회원 -> 모집즐겨찾기
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);

-- 모집좋아요
ALTER TABLE recruit_like
	ADD CONSTRAINT FK_recruit_board_TO_recruit_like -- 여행멤버모집게시글 -> 모집좋아요
	FOREIGN KEY (
	recruit_board_id -- 여행멤버모집게시글번호
	)
	REFERENCES recruit_board ( -- 여행멤버모집게시글
	recruit_board_id -- 여행멤버모집게시글번호
	);

-- 모집좋아요
ALTER TABLE recruit_like
	ADD CONSTRAINT FK_member_TO_recruit_like -- 회원 -> 모집좋아요
	FOREIGN KEY (
	member_id -- 회원 식별번호
	)
	REFERENCES member ( -- 회원
	member_id -- 회원 식별번호
	);