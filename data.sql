-- member
insert into member(member_id,email,phone_number,password,name,nickname,birth_date,gender,profile,introduce)
  values(1,'user1@test.com','010-1111-1111',sha2('1111',256),'user1','nick1','2024-04-01 00:00:00',true,'사진1','자기소개1');
insert into member(member_id,email,phone_number,password,name,nickname,birth_date,gender,profile,introduce)
  values(2,'user2@test.com','010-2222-2222',sha2('2222',256),'user2','nick2','2024-04-02 00:00:00',true,'사진2','자기소개2');
insert into member(member_id,email,phone_number,password,name,nickname,birth_date,gender,profile,introduce)
  values(3,'user3@test.com','010-3333-3333',sha2('3333',256),'user3','nick3','2024-04-03 00:00:00',false,'사진3','자기소개3');
insert into member(member_id,email,phone_number,password,name,nickname,birth_date,gender,profile,introduce)
  values(4,'user4@test.com','010-4444-4444',sha2('4444',256),'user4','nick4','2024-04-04 00:00:00',false,'사진4','자기소개4');
insert into member(member_id,email,phone_number,password,name,nickname,birth_date,gender,profile,introduce)
  values(5,'user5@test.com','010-5555-5555',sha2('5555',256),'user5','nick5','2024-04-05 00:00:00',false,'사진5','자기소개5');

insert into member
  values('user6@test.com','010-6666-6666',sha2('6666',256),'user6','nick6','2024-04-06 00:00:00',false,'사진6','자기소개6');

-- theme
insert into theme(theme_id,theme_name)
  values(1,'힐링');
insert into theme(theme_id,theme_name)
  values(2,'캠핑');
insert into theme(theme_id,theme_name)
  values(3,'액티비티');
insert into theme(theme_id,theme_name)
  values(4,'집콕');
insert into theme(theme_id,theme_name)
  values(5,'바다');
  
-- interest_theme
insert into interest_theme(theme_id,member_id)
  values(1,1);