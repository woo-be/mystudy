-- members 테이블 데이터
insert into members(member_no,email,name,password,created_date)
  values(101,'user1@test.com','user1',sha2('1111',256),'2024-1-1');
insert into members(member_no,email,name,password,created_date)
  values(102,'user2@test.com','user2',sha2('1111',256),'2024-2-2');
insert into members(member_no,email,name,password,created_date)
  values(103,'user3@test.com','user3',sha2('1111',256),'2024-3-3');
insert into members(member_no,email,name,password,created_date)
  values(104,'user4@test.com','user4',sha2('1111',256),'2024-4-4');
insert into members(member_no,email,name,password,created_date)
  values(105,'user5@test.com','user5',sha2('1111',256),'2024-5-5');

-- boards 테이블 데이터
insert into boards(board_no,title,content,writer,category) values
  (1, '제목1','내용1',101, 1),
  (2, '제목2','내용2',101, 1),
  (3, '제목3','내용3',101, 1),
  (4, '제목4','내용4',101, 1),
  (5, '제목5','내용5',101, 1),
  (6, '제목6','내용6',102, 1),
  (7, '제목7','내용7',102, 1),
  (8, '제목8','내용8',102, 1),
  (9, '제목9','내용9',102, 1),
  (10, '제목10','내용10',103, 1),
  (11, '제목11','내용11',103, 1),
  (12, '제목12','내용12',104, 1),
  (13, '제목13','내용13',104, 1),
  (14, '제목14','내용14',104, 1),
  (15, '제목15','내용15',105, 1),
  (16, '제목16','내용16',105, 1),
  (17, '제목17','내용17',101, 1),
  (18, '제목18','내용18',101, 1),
  (19, '제목19','내용19',103, 1),
  (20, '제목20','내용20',103, 1),
  (21, '제목21','내용21',104, 1),
  (22, '제목22','내용22',104, 1);


-- board_files 테이블 데이터
insert into board_files(file_no,file_path,board_no) values
  (1,'a1.gif', 1), (2,'a2.gif', 1), (3,'a3.gif', 1),
  (4,'b1.gif', 2), (5,'b2.gif', 2),
  (6,'c1.gif', 4), (7,'c2.gif', 4), (8,'c3.gif', 4), (9,'c4.gif', 4),
  (10,'d1.gif', 5);



-- assignments 테이블 데이터
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


