/****************\ SEMESTERS /****************/
INSERT INTO semesters() VALUES ();
INSERT INTO semesters() VALUES ();
INSERT INTO semesters() VALUES ();

/****************\ PROFESSORS /****************/
INSERT INTO professors (name, email, phone, section, office) 
    VALUES ('Cartalis Constantinos', 'Cartalis@uClass.com', 2107276926, 'ENVIRONMENTAL PHYSICS', '1st Floor');
INSERT INTO professors (name, email, phone, section, office) 
    VALUES ('Varotsos Constantinos', 'Varotsos@uClass.com', 2107276929, 'ENVIRONMENTAL PHYSICS', '1st Floor');
INSERT INTO professors (name, email, phone, section, office) 
    VALUES ('Floca Helena', 'Floca@uClass.com', 2107276706, 'ENVIRONMENTAL PHYSICS', '1st Floor');
INSERT INTO professors (name, email, phone, section, office) 
    VALUES ('Assimakopoulou Margarita - Niki', 'Assimakopoulou@uClass.com', 2107276836, 'ENVIRONMENTAL PHYSICS', '1st Floor');
INSERT INTO professors (name, email, phone, section, office) 
    VALUES ('Giannakaki Eleni', 'Giannakaki@uClass.com', 2107276928, 'ENVIRONMENTAL PHYSICS', '1st Floor');


/****************\ STUDENTS /****************/
INSERT INTO students(name) VALUES ('Notis');
INSERT INTO students(name) VALUES ('Filippas');
INSERT INTO students(name) VALUES ('Grigoris');
INSERT INTO students(name) VALUES ('Nikos');


/****************\ ACCOUNTS /****************/
INSERT INTO accounts(username, password, role) VALUES ('Notis', '656456', 'ROLE_STUDENT');
INSERT INTO accounts(username, password, role) VALUES ('Filippas', '656456', 'ROLE_STUDENT');
INSERT INTO accounts(username, password, role) VALUES ('Grigoris', '656456', 'ROLE_STUDENT');
INSERT INTO accounts(username, password, role) VALUES ('Nikos', '656456', 'ROLE_STUDENT');

INSERT INTO accounts(username, password, role) VALUES ('Cartalis Constantinos', '656456', 'ROLE_PROFESSOR');
INSERT INTO accounts(username, password, role) VALUES ('Varotsos Constantinos', '656456', 'ROLE_PROFESSOR');
INSERT INTO accounts(username, password, role) VALUES ('Floca Helena', '656456', 'ROLE_PROFESSOR');
INSERT INTO accounts(username, password, role) VALUES ('Assimakopoulou Margarita - Niki', '656456', 'ROLE_PROFESSOR');
INSERT INTO accounts(username, password, role) VALUES ('Giannakaki Eleni', '656456', 'ROLE_PROFESSOR');


/****************\ STUDENT ACCOUNTS /****************/
INSERT INTO student_account(account_id, student_id) VALUES (1, 1);
INSERT INTO student_account(account_id, student_id) VALUES (2, 2);
INSERT INTO student_account(account_id, student_id) VALUES (3, 3);
INSERT INTO student_account(account_id, student_id) VALUES (4, 4);


/****************\ PROFESSOR ACCOUNTS /****************/
INSERT INTO professor_account(account_id, professor_id) VALUES (5, 1);
INSERT INTO professor_account(account_id, professor_id) VALUES (6, 2);
INSERT INTO professor_account(account_id, professor_id) VALUES (7, 3);
INSERT INTO professor_account(account_id, professor_id) VALUES (8, 4);
INSERT INTO professor_account(account_id, professor_id) VALUES (9, 5);


/****************\ COURCES /****************/
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Atmospheric Physics', 1, 1);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Dynamics of Geophysical Fluids', 2, 1);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Data Analysis Methods', 3, 1);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Numerical Methods - Applications to Geophysical Fluids', 4, 1);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Atmospheric Physics and Chemistry', 5, 1);

INSERT INTO courses(name, professor_id, semester_id) VALUES ('Atmospheric Dynamics', 1, 2);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Environmental Measurement Methods and Instruments', 2, 2);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Physical Oceanography', 3, 2);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Applied Energy Planning', 4, 2);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Cloud Physics and Mesoscale Phenomena', 5, 2);

INSERT INTO courses(name, professor_id, semester_id) VALUES ('Built Environment Physics', 1, 3);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Climate - Climatic Fluctuations', 2, 3);
INSERT INTO courses(name, professor_id, semester_id) VALUES ('Atmospheric Circulation Models', 3, 3);


/****************\ REGISTERED COURSES /****************/
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 1);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 2);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 3);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 4);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 5);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 6);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 7);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 8);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 9);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 10);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 11);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 12);
INSERT INTO registered_courses(student_id, course_id) VALUES (1, 13);

INSERT INTO registered_courses(student_id, course_id) VALUES (2, 1);
INSERT INTO registered_courses(student_id, course_id) VALUES (2, 2);
INSERT INTO registered_courses(student_id, course_id) VALUES (2, 3);
INSERT INTO registered_courses(student_id, course_id) VALUES (2, 4);
INSERT INTO registered_courses(student_id, course_id) VALUES (2, 5);
INSERT INTO registered_courses(student_id, course_id) VALUES (2, 6);
INSERT INTO registered_courses(student_id, course_id) VALUES (2, 7);
INSERT INTO registered_courses(student_id, course_id) VALUES (2, 8);
INSERT INTO registered_courses(student_id, course_id) VALUES (2, 9);
INSERT INTO registered_courses(student_id, course_id) VALUES (2, 10);

INSERT INTO registered_courses(student_id, course_id) VALUES (3, 1);
INSERT INTO registered_courses(student_id, course_id) VALUES (3, 2);
INSERT INTO registered_courses(student_id, course_id) VALUES (3, 3);
INSERT INTO registered_courses(student_id, course_id) VALUES (3, 4);
INSERT INTO registered_courses(student_id, course_id) VALUES (3, 5);

/****************\ PASSED COURSES /****************/
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 1);
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 2);
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 3);
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 4);
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 5);
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 6);
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 7);
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 8);
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 9);
INSERT INTO passed_courses(student_id, course_id) VALUES (1, 10);

INSERT INTO passed_courses(student_id, course_id) VALUES (2, 2);
INSERT INTO passed_courses(student_id, course_id) VALUES (2, 3);
INSERT INTO passed_courses(student_id, course_id) VALUES (2, 4);
INSERT INTO passed_courses(student_id, course_id) VALUES (2, 5);

INSERT INTO passed_courses(student_id, course_id) VALUES (3, 1);


/****************\ ANNOUNCEMENTS /****************/
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Welcome to uClass', 'bkjbkbkbkjbjbl.kj', 
PARSEDATETIME('15-08-2020', 'dd-MM-yyyy'), 1);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 1st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 1);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 1st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 2);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 1st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 3);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 1st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 4);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 1st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 5);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 3st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 5);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 3st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 5);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 4st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 5);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 5st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 5);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 6st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 5);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 7st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 5);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 8st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 5);
INSERT INTO announcements(title, content, date, professor_id) VALUES ('Beginning of the 9st semester', 'hbvbvvvlvli bkjbkj', 
PARSEDATETIME('18-08-2021', 'dd-MM-yyyy'), 5);


/****************\ EVENTS /****************/
INSERT INTO events(date, content, announcement_id) VALUES(PARSEDATETIME('28-10-2022', 'dd-MM-yyyy'), 'Exam', 1);

INSERT INTO events(date, content, announcement_id) VALUES(PARSEDATETIME('17-10-2022', 'dd-MM-yyyy'), 'Exam', 1);
INSERT INTO events(date, content, announcement_id) VALUES(PARSEDATETIME('17-10-2022', 'dd-MM-yyyy'), 'Exam', 2);


/****************\ ANSWERS /****************/
INSERT INTO answers(content) VALUES (
'After entering the platform with your credentials, click on College and then Courses. 
Your schools courses are displayed, grouped by semester. Choose the semester you are interested in and 
click on Register in the top right corner.
Your registration has been completed.'
);

INSERT INTO answers(content) VALUES (
'Search for the course by giving its title in "Search.." at the top left.'
);


/****************\ QUESTIONS /****************/
INSERT INTO questions(content, answer_id) VALUES (
'How do I register for the courses I am interested in?', 1);

INSERT INTO questions(content, answer_id) VALUES (
'The course I am interested in enrolling in is not in the semester.', 2);