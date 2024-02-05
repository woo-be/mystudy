create table todo1(
    no int primary key auto_increment,
    title varchar(50) not null,
    content text not null,
    deadline date not null,
    overdue boolean not null default 'f'
);

insert into todo1(no,title,content,deadline)
values(1,'미용실 예약','예약할 미용실 찾아보기','2024-02-03'),
(2,'장보기','과일, 채소, 우유 사기','2024-02-04'),
(3,'친구 생일 선물 준비하기','어떤 선물 줄 지 결정하여 구매하기','2024-02-06'),
(4,'책 구매하기','정보처리기사 책 구매하기','2024-02-08');