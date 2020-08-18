create table questions
(
	id int primary key auto_increment,
    question nvarchar(250) not null,
    correct_answer nvarchar(250) not null
);

create table answers
(
	id int primary key auto_increment,
    answer nvarchar(250) not null,
    question_id int not null,
    constraint FK_QuestionAnswer
    foreign key (question_id)
    references questions(id)
);