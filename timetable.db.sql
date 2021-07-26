BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "add_location" (
	"ID"	INTEGER NOT NULL,
	"BuildingName"	varchar(30) NOT NULL,
	"RoomName"	varchar(30) NOT NULL,
	"RoomType"	varchar(10) NOT NULL,
	"Capacity"	int(10) NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "lecturers" (
	"id"	INTEGER NOT NULL,
	"name"	varchar(100) NOT NULL,
	"emp_id"	varchar(20) NOT NULL,
	"faculty"	varchar(50) NOT NULL,
	"department"	varchar(50) NOT NULL,
	"center"	varchar(50) NOT NULL,
	"building"	varchar(50) NOT NULL,
	"level"	int(50) NOT NULL,
	"rank"	varchar(50) NOT NULL,
	"monday"	varchar(20) NOT NULL DEFAULT 'N',
	"tuesday"	varchar(20) NOT NULL DEFAULT '-',
	"wednesday"	varchar(20) NOT NULL DEFAULT '-',
	"thursday"	varchar(20) NOT NULL,
	"friday"	varchar(20) NOT NULL,
	"saturday"	varchar(20) NOT NULL,
	"sunday"	varchar(20) NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "manage_session" (
	"ID"	INTEGER NOT NULL,
	"Lecture_1"	varchar(100) NOT NULL,
	"Lecture_2"	varchar(100) NOT NULL,
	"Subject_Code"	varchar(50) NOT NULL,
	"Subject_Name"	varchar(50) NOT NULL,
	"Group_ID"	varchar(10) NOT NULL,
	"Tag"	varchar(20) NOT NULL,
	"Room"	varchar(20) NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "studentgroup" (
	"id"	INTEGER NOT NULL,
	"AcademicYearSemester"	varchar(5) NOT NULL,
	"Programme"	varchar(10) NOT NULL,
	"GroupNumber"	int(2) NOT NULL,
	"SubGroupNumber"	int(2) NOT NULL,
	"GroupID"	varchar(10) NOT NULL,
	"SubGroupID"	varchar(20) NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "subjects" (
	"id"	INTEGER NOT NULL,
	"subject_name"	varchar(100) NOT NULL,
	"subject_code"	varchar(6) NOT NULL,
	"year"	varchar(20) NOT NULL,
	"semester"	varchar(20) NOT NULL,
	"lecture_hours"	varchar(20) NOT NULL,
	"tutorial_hours"	varchar(20) NOT NULL,
	"lab_hours"	varchar(20) NOT NULL,
	"evaluation_hours"	varchar(20) NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "consecutive_sessions" (
	"cID"	INTEGER,
	"s1_lecture1"	VARCHAR(100),
	"s1_lecture2"	VARCHAR(100),
	"s1_subjectcode"	VARCHAR(6),
	"s1_subjectname"	VARCHAR(20),
	"s1_groupid"	VARCHAR(20),
	"s1_tag"	VARCHAR(10),
	"s2_lecture1"	VARCHAR(100),
	"s2_lecture2"	VARCHAR(100),
	"s2_subjectcode"	VARCHAR(6),
	"s2_subjectname"	VARCHAR(20),
	"s2_groupid"	VARCHAR(20),
	"s2_tag"	VARCHAR(10),
	"room"	VARCHAR(100),
	PRIMARY KEY("cID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "overlap_session" (
	"olID"	INTEGER,
	"s1_lecture1"	VARCHAR(100),
	"s1_lecture2"	VARCHAR(100),
	"s1_subjectcode"	VARCHAR(6),
	"s1_subjectname"	VARCHAR(20),
	"s1_groupid"	VARCHAR(20),
	"s1_tag"	VARCHAR(10),
	"s2_lecture1"	VARCHAR(100),
	"s2_lecture2"	VARCHAR(100),
	"s2_subjectcode"	VARCHAR(6),
	"s2_subjectname"	VARCHAR(20),
	"s2_groupid"	VARCHAR(20),
	"s2_tag"	VARCHAR(10),
	PRIMARY KEY("olID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "parellel_session" (
	"pID"	INTEGER,
	"s1_lecture1"	VARCHAR(100),
	"s1_lecture2"	VARCHAR(100),
	"s1_subjectcode"	VARCHAR(6),
	"s1_subjectname"	VARCHAR(20),
	"s1_groupid"	VARCHAR(20),
	"s1_tag"	VARCHAR(10),
	"s2_lecture1"	VARCHAR(100),
	"s2_lecture2"	VARCHAR(100),
	"s2_subjectcode"	VARCHAR(6),
	"s2_subjectname"	VARCHAR(20),
	"s2_groupid"	VARCHAR(20),
	"s2_tag"	VARCHAR(10),
	"room"	VARCHAR(100),
	PRIMARY KEY("pID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "session" (
	"ID"	INTEGER,
	"Lecture_1"	VARCHAR(50),
	"Lecture_2"	VARCHAR(50),
	"Subject_Code"	VARCHAR(6),
	"Subject_Name"	VARCHAR(10),
	"Group_ID"	VARCHAR(20),
	"Tag"	VARCHAR(10),
	"Room"	VARCHAR(20),
	PRIMARY KEY("ID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "tag" (
	"id"	INTEGER,
	"tagName"	VARCHAR(10),
	"tagCode"	INT(10),
	"relatedTag"	VARCHAR(10),
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "notAvailableLocations" (
	"ID"	INTEGER,
	"room"	VARCHAR(20),
	"day"	VARCHAR(20),
	"start"	VARCHAR(20),
	"end"	VARCHAR(20),
	PRIMARY KEY("ID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "workingdays" (
	"id"	INTEGER NOT NULL,
	"workingDays"	VARCHAR(10) NOT NULL,
	"monday"	VARCHAR(20),
	"tuesday"	VARCHAR(20),
	"wednesday"	VARCHAR(20),
	"thursday"	VARCHAR(20),
	"friday"	VARCHAR(20),
	"saturday"	VARCHAR(20),
	"sunday"	VARCHAR(20),
	"workingHours"	VARCHAR(10),
	"workingMiniutes"	VARCHAR(10),
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "sessions" (
	"ID"	INTEGER NOT NULL,
	"Lecturer_1"	varchar(100),
	"Lecturer_2"	varchar(100),
	"Lecturer_3"	varchar(100),
	"Subject_Name"	varchar(50) NOT NULL,
	"Subject_Code"	varchar(50) NOT NULL,
	"Tag"	varchar(20) NOT NULL,
	"Group_ID"	varchar(10) NOT NULL,
	"Students"	varchar(3) NOT NULL,
	"Duration"	varchar(3) NOT NULL,
	"mSessions"	varchar(100) DEFAULT '-',
	"Room"	varchar(20),
	PRIMARY KEY("ID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "notAvailableTimes" (
	"ID"	INTEGER,
	"startTime"	VARCHAR(20),
	"endTime"	VARCHAR(20),
	"lecturer"	VARCHAR(20),
	"groupID"	VARCHAR(20),
	"subGroup"	VARCHAR(20),
	"sessionID"	VARCHAR(20),
	"day"	VARCHAR(20),
	"room"	VARCHAR(20),
	PRIMARY KEY("ID" AUTOINCREMENT)
);
INSERT INTO "add_location" VALUES (10,'IT Faculty Building','301','Lecture',150);
INSERT INTO "add_location" VALUES (11,'Main Building 3rd floor','302','Lab',60);
INSERT INTO "add_location" VALUES (12,'Main Building','Auditorium','Lecture',100);
INSERT INTO "add_location" VALUES (22,'2nd floor','303A','Lecture',400);
INSERT INTO "lecturers" VALUES (9,'Prof.Sarath Bandara','000741','Computing','Computer Science and Software Engineering','Malabe Campus','B',1,'1.000741','08.30 - 5.30','08.30 - 5.30','','08.30 - 5.30','08.30 - 5.30','','');
INSERT INTO "lecturers" VALUES (10,'Dr.Chaminda Perera','000147','Computing','Information Technology','Malabe Campus','C',2,'2.000147','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','','');
INSERT INTO "lecturers" VALUES (11,'Ms.Harshani Silva','000258','Computing','Computer Systems Engineering','Malabe Campus','A',5,'5.000258','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30');
INSERT INTO "lecturers" VALUES (12,'Mr. Sahan Rathnayaka','000852','Computing','Computer Science and Software Engineering','Malabe Campus','E',4,'4.000852','08.30 - 5.30','','','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','');
INSERT INTO "lecturers" VALUES (13,'Prof. Saman Ekanayaka','000963','Computing','Computer Systems Engineering','Malabe Campus','C',1,'1.000963','08.30 - 5.30','','','08.30 - 5.30','08.30 - 5.30','','');
INSERT INTO "lecturers" VALUES (14,'Ms. Samanmali Silva','000369','Computing','Computer Systems Engineering','Malabe Campus','B',4,'4.000369','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','','');
INSERT INTO "lecturers" VALUES (15,'Ms. Kanchana Bandara','000789','Computing','Information Technology','Malabe Campus','B',6,'6.000789','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30');
INSERT INTO "lecturers" VALUES (16,'Dr. Nimal Pathirana','000987','Computing','Computer Science and Software Engineering','Malabe Campus','E',3,'3.000987','08.30 - 5.30','08.30 - 5.30','','','08.30 - 5.30','08.30 - 5.30','08.30 - 5.30');
INSERT INTO "manage_session" VALUES (1,'sdsdsd','sdddd','123','ip','y3s1','sds','Auditorium');
INSERT INTO "studentgroup" VALUES (1,'Y1.S2','SE',2,1,'Y1.S2.SE.2','Y1.S2.SE.2.1');
INSERT INTO "studentgroup" VALUES (2,'Y3.S1','DS',4,1,'Y3.S1.DS.4','Y3.S1.DS.4.1');
INSERT INTO "studentgroup" VALUES (3,'Y2.S2','IT',3,2,'Y2.S2.IT.3','Y2.S2.IT.3.2');
INSERT INTO "subjects" VALUES (15,'IP','IT1010','Year 1','Semester 1','3 Hours/Week','1 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (16,'ICS','IT1020','Year 1','Semester 1','2 Hours/Week','2 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (17,'MC','IT1030','Year 1','Semester 1','2 Hours/Week','2 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (18,'CS','IT1040','Year 1','Semester 1','2 Hours/Week','2 Hours/Week','0 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (19,'OOC','IT1050','Year 1','Semester 2','4 Hours/Week','2 Hours/Week','3 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (20,'ISDM','IT1090','Year 1','Semester 2','2 Hours/Week','2 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (21,'IWT','IT1100','Year 1','Semester 2','2 Hours/Week','2 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (22,'SE','IT2020','Year 2','Semester 1','2 Hours/Week','2 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (23,'OOP','IT2030','Year 2','Semester 1','2 Hours/Week','1 Hours/Week','3 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (24,'CN','IT2050','Year 2','Semester 1','2 Hours/Week','2 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (25,'PS','IT1070','Year 2','Semester 2','3 Hours/Week','2 Hours/Week','0 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (26,'MAD','IT2010','Year 2','Semester 2','2 Hours/Week','2 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (27,'ITP','IT2080','Year 2','Semester 2','0 Hours/Week','0 Hours/Week','0 Hours/Week','2 Hours/Week');
INSERT INTO "subjects" VALUES (28,'ESD','IT2100','Year 2','Semester 2','2 Hours/Week','0 Hours/Week','0 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (29,'NDM','IT3010','Year 3','Semester 1','2 Hours/Week','2 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (30,'PAF','IT3030','Year 3','Semester 1','2 Hours/Week','2 Hours/Week','2 Hours/Week','0 Hours/Week');
INSERT INTO "subjects" VALUES (31,'ITPM','IT3040','Year 3','Semester 1','2 Hours/Week','1 Hours/Week','0 Hours/Week','1 Hours/Week');
INSERT INTO "consecutive_sessions" VALUES (4,'kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture','kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture','Auditorium');
INSERT INTO "consecutive_sessions" VALUES (5,'kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture','rusiru','abishek','IT2020','paf','Y1.S2.IT.2.1','tute','301');
INSERT INTO "overlap_session" VALUES (1,'kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture','rusiru','abishek','IT2020','paf','Y1.S2.IT.2.1','tute');
INSERT INTO "overlap_session" VALUES (3,'kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture','kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture');
INSERT INTO "parellel_session" VALUES (1,'kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture','kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture',NULL);
INSERT INTO "parellel_session" VALUES (2,'rusiru','abishek','IT2020','paf','Y1.S2.IT.2.1','tute','kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture',NULL);
INSERT INTO "session" VALUES (1,'kasun','deeptha','IT1010','ds','Y1.S2.DS.2.1','lecture','Auditorium');
INSERT INTO "session" VALUES (2,'rusiru','abishek','IT2020','paf','Y1.S2.IT.2.1','tute','302');
INSERT INTO "tag" VALUES (1,'lec',1,'Lecture');
INSERT INTO "tag" VALUES (2,'tute',2,'Lecture');
INSERT INTO "notAvailableLocations" VALUES (1,'45','Monday','8.30','9.30');
INSERT INTO "notAvailableLocations" VALUES (4,'301','Monday','8.30','9.30');
INSERT INTO "sessions" VALUES (6,'Mr. Sahan Rathnayaka','Ms.Harshani Silva','Prof.Sarath Bandara','IP','IT1010','Lab','Y1.S1.IT.1.1','60','2','Mr. Sahan Rathnayaka   Ms.Harshani Silva   Prof.Sarath Bandara - IT1010 - IP - Lab - Y1.S1.IT.1.1 - 60 - 2','303A');
INSERT INTO "sessions" VALUES (7,'Ms. Samanmali Silva','Ms.Harshani Silva',' ','IWT','IT1100','Tutorial','Y1.S2.IT.2.1','150','2','Ms. Samanmali Silva   Ms.Harshani Silva     - IT1100 - IWT - Tutorial - Y1.S2.IT.2.1 - 150 - 2',NULL);
INSERT INTO "sessions" VALUES (8,'Prof.Sarath Bandara','Ms. Samanmali Silva','Mr. Sahan Rathnayaka','OOP','IT2030','Lab','Y2.S1.IT.1.1','50','2','Prof.Sarath Bandara   Ms. Samanmali Silva   Mr. Sahan Rathnayaka - IT2030 - OOP - Lab - Y2.S1.IT.1.1 - 50 - 2',NULL);
INSERT INTO "sessions" VALUES (10,'Ms.Harshani Silva','Prof. Saman Ekanayaka',' ','IP','IT1010','Tutorial','Y1.S2.IT.2.1','150','2','Ms.Harshani Silva   Prof. Saman Ekanayaka     - IT1010 - IP - Tutorial - Y1.S2.IT.2.1 - 150 - 2',NULL);
INSERT INTO "sessions" VALUES (11,'Prof. Saman Ekanayaka','Ms.Harshani Silva',' ','MC','IT1030','Lab','Y1.S1.CS.3.4','55','2','Prof. Saman Ekanayaka   Ms.Harshani Silva     - IT1030 - MC - Lab - Y1.S1.CS.3.4 - 55 - 2',NULL);
INSERT INTO "sessions" VALUES (12,'Ms.Harshani Silva','Prof.Sarath Bandara',' ','CS','IT1040','Evalution','Y1.S1.CS.3.4','65','2','Ms.Harshani Silva   Prof.Sarath Bandara     - IT1040 - CS - Evalution - Y1.S1.CS.3.4 - 65 - 2',NULL);
INSERT INTO "sessions" VALUES (14,'Mr. Sahan Rathnayaka','Ms.Harshani Silva','Prof.Sarath Bandara','IP','IT1010','Lab','Y1.S1.IT.1.1','60','2','Mr. Sahan Rathnayaka   Ms.Harshani Silva   Prof.Sarath Bandara - IT1010 - IP - Lab - Y1.S1.IT.1.1 - 60 - 2',NULL);
INSERT INTO "notAvailableTimes" VALUES (4,'8.30','9.30','9','Y1.S2.SE.2','Y1.S2.SE.2.1','1','Monday','301');
COMMIT;
