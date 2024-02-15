-- DDL(Data Definition Language)

drop table if exists boards restrict;
drop table if exists board_files restrict;
drop table if exists assignments restrict;
drop table if exists members restrict;

create table boards(
  board_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  created_date datetime null default now(),
  category int not null
);

insert into boards(board_no,title,content,writer,category)
  values(1, '제목1','내용1','홍길동',1);
insert into boards(board_no,title,content,writer,category)
  values(2, '제목2','내용2','임꺽정',1);
insert into boards(board_no,title,content,writer,category)
  values(3, '제목3','내용3','유관순',2);
insert into boards(board_no,title,content,writer,category)
  values(4, '제목4','내용4','안중근',2);
insert into boards(board_no,title,content,writer,category)
  values(5, '제목5','내용5','윤봉길',2);

create table board_files(
  file_no int not null,
  file_path varchar(255) not null,
  board_no int not null
);

alter table board_files
  add constraint primary key (file_no),
  modify column file_no int not null auto_increment,
  add constraint board_files_fk foreign key (board_no) references boards(board_no);

-- board_files 테이블 데이터
insert into board_files(file_no,file_path,board_no) values
  (1,'a1.gif', 1), (2,'a2.gif', 1), (3,'a3.gif', 1),
  (4,'b1.gif', 2), (5,'b2.gif', 2),
  (6,'c1.gif', 4), (7,'c2.gif', 4), (8,'c3.gif', 4), (9,'c4.gif', 4),
  (10,'d1.gif', 5);


create table assignments(
  assignment_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  deadline date not null
);

insert into assignments(assignment_no,title,content,deadline) 
  values(1,'과제1','내용1','2024-1-1');
insert into assignments(assignment_no,title,content,deadline) 
  values(2,'과제2','내용2','2024-2-2');
insert into assignments(assignment_no,title,content,deadline) 
  values(3,'과제3','내용3','2024-3-3');
insert into assignments(assignment_no,title,content,deadline) 
  values(4,'과제4','내용4','2024-4-4');
insert into assignments(assignment_no,title,content,deadline) 
  values(5,'과제5','내용5','2024-5-5');


create table members(
  member_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(255) not null,
  password varchar(100) not null,
  created_date datetime null default now()
);

insert into members(email,name,password,created_date)
  values('user1@test.com','user1',sha2('1111',256),'2024-1-1');
insert into members(email,name,password,created_date)
  values('user2@test.com','user2',sha2('1111',256),'2024-2-2');
insert into members(email,name,password,created_date)
  values('user3@test.com','user3',sha2('1111',256),'2024-3-3');
insert into members(email,name,password,created_date)
  values('user4@test.com','user4',sha2('1111',256),'2024-4-4');
insert into members(email,name,password,created_date)
  values('user5@test.com','user5',sha2('1111',256),'2024-5-5');

