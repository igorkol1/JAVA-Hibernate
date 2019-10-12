insert into Category(name,description) values ('Test Category 1','Test Category 1 desc.');
insert into Category(name,description) values ('Test Category 2','Test Category 2 desc.');
insert into Category(name,description) values ('Test Category 3','Test Category 3 desc.');
insert into Category(name,description) values ('Test Category 4','Test Category 4 desc.');
insert into Category(name,description) values ('Test Category 5','Test Category 5 desc.');

insert into Author(firstName, lastName) VALUES ('First Name 1','Last Name 1');
insert into Author(firstName, lastName) VALUES ('First Name 2','Last Name 2');
insert into Author(firstName, lastName) VALUES ('First Name 3','Last Name 3');
insert into Author(firstName, lastName) VALUES ('First Name 4','Last Name 4');
insert into Author(firstName, lastName) VALUES ('First Name 5','Last Name 5');

insert into Article(content, created, title, updated, author_id) VALUES ('Test Content 1',now(),'Test Title 1',now(),1);
insert into Article(content, created, title, updated, author_id) VALUES ('Test Content 2',now(),'Test Title 2',now(),2);
insert into Article(content, created, title, updated, author_id) VALUES ('Test Content 3',now(),'Test Title 3',now(),3);
insert into Article(content, created, title, updated, author_id) VALUES ('Test Content 4',now(),'Test Title 4',now(),4);
insert into Article(content, created, title, updated, author_id) VALUES ('Test Content 5',now(),'Test Title 5',now(),5);

insert into Article_Category(article_id, categories_id) VALUES (1,1);
insert into Article_Category(article_id, categories_id) VALUES (1,2);
insert into Article_Category(article_id, categories_id) VALUES (3,1);
insert into Article_Category(article_id, categories_id) VALUES (4,1);
insert into Article_Category(article_id, categories_id) VALUES (5,1);
insert into Article_Category(article_id, categories_id) VALUES (2,1);
