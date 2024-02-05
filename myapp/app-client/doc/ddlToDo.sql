create table todo(
    no int primary key auto_increment,
    title varchar(50) not null,
    content text not null,
    deadline date not null,
    level int not null
);

insert into todo(no,title,content,deadline,level)
values(1,'미용실 예약','예약할 미용실 찾아보기','2024-02-03',2),
(2,'장보기','과일, 채소, 우유 사기','2024-02-04',1),
(3,'친구 생일 선물 준비하기','어떤 선물 줄 지 결정하여 구매하기','2024-02-06',1),
(4,'책 구매하기','정보처리기사 책 구매하기','2024-02-08',2),
(5,'기차 예매하기','토요일 SRT 열차 예매하기','2024-02-10',3);

create table priority(
    level int primary key,
    priority char(2) not null
);

insert into priority(level,priority)
values
    (1,'높음'),
    (2,'중간'),
    (3,'낮음')
;