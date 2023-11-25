--------------------------------------------------------
--  File created - Σάββατο-Νοεμβρίου-25-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CUSTOMER
--------------------------------------------------------

  CREATE TABLE "IEE2019187"."CUSTOMER" 
   (	"ID" VARCHAR2(30 CHAR), 
	"ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ" VARCHAR2(30 CHAR), 
	"ΟΝΟΜΑ" VARCHAR2(30 CHAR), 
	"ΕΠΩΝΥΜΟ" VARCHAR2(30 CHAR), 
	"ΦΥΛΟ" VARCHAR2(30 CHAR), 
	"ΧΩΡΑ_ΔΙΑΜΟΝΗΣ" VARCHAR2(30 CHAR), 
	"ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ" NUMBER(10,0), 
	"ΗΜΕΡΕΣ_ΔΙΑΜΟΝΗΣ" NUMBER(10,0), 
	"ΠΟΣΟ_ΠΛΗΡΩΜΗΣ" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DRIVER
--------------------------------------------------------

  CREATE TABLE "IEE2019187"."DRIVER" 
   (	"ID" NUMBER(10,0), 
	"ΟΝΟΜΑ" VARCHAR2(30 CHAR), 
	"ΕΠΩΝΥΜΟ" VARCHAR2(30 CHAR), 
	"ΗΛΙΚΙΑ" NUMBER(10,0), 
	"ΦΥΛΟ" VARCHAR2(20 CHAR), 
	"ΑΥΤΟΚΙΝΗΤΟ" VARCHAR2(30 CHAR), 
	"ΔΙΑΘΕΣΙΜΟΤΗΤΑ" VARCHAR2(30 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "IEE2019187"."EMPLOYEE" 
   (	"ID" NUMBER(10,0), 
	"ΟΝΟΜΑ" VARCHAR2(30 CHAR), 
	"ΕΠΩΝΥΜΟ" VARCHAR2(30 CHAR), 
	"ΗΛΙΚΙΑ" NUMBER(10,0), 
	"ΦΥΛΟ" VARCHAR2(30 CHAR), 
	"ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ" VARCHAR2(30 CHAR), 
	"ΜΙΣΘΟΣ" NUMBER(10,0), 
	"ΤΗΛΕΦΩΝΟ" NUMBER(10,0), 
	"EMAIL" VARCHAR2(40 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOGIN
--------------------------------------------------------

  CREATE TABLE "IEE2019187"."LOGIN" 
   (	"USERNAME" VARCHAR2(64 CHAR), 
	"PASSWORD" VARCHAR2(150 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ROOM
--------------------------------------------------------

  CREATE TABLE "IEE2019187"."ROOM" 
   (	"ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ" NUMBER(10,0), 
	"ΔΙΑΘΕΣΙΜΟΤΗΤΑ" VARCHAR2(20 CHAR), 
	"ΚΑΘΑΡΙΣΜΟΣ" VARCHAR2(20 CHAR), 
	"ΤΙΜΗ" NUMBER(10,0), 
	"ΑΡΙΘΜΟΣ_ΚΡΕΒΑΤΙΩΝ" VARCHAR2(20 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into IEE2019187.CUSTOMER
SET DEFINE OFF;
Insert into IEE2019187.CUSTOMER (ID,"ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ","ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΦΥΛΟ","ΧΩΡΑ_ΔΙΑΜΟΝΗΣ","ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ","ΗΜΕΡΕΣ_ΔΙΑΜΟΝΗΣ","ΠΟΣΟ_ΠΛΗΡΩΜΗΣ") values ('Ταυτότητα','7','ητραυ','υραυρσ','Άνδρας','θτθταδτ','1','5','200');
Insert into IEE2019187.CUSTOMER (ID,"ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ","ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΦΥΛΟ","ΧΩΡΑ_ΔΙΑΜΟΝΗΣ","ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ","ΗΜΕΡΕΣ_ΔΙΑΜΟΝΗΣ","ΠΟΣΟ_ΠΛΗΡΩΜΗΣ") values ('Ταυτότητα','teaute','utaeduyta','jdtudz','Άνδρας','utdh','2','6','264');
Insert into IEE2019187.CUSTOMER (ID,"ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ","ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΦΥΛΟ","ΧΩΡΑ_ΔΙΑΜΟΝΗΣ","ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ","ΗΜΕΡΕΣ_ΔΙΑΜΟΝΗΣ","ΠΟΣΟ_ΠΛΗΡΩΜΗΣ") values ('Ταυτότητα','hhfsh','fxhfyt','jtdgzjd','Άνδρας','jtdzjtzd','666666','6','4662');
REM INSERTING into IEE2019187.DRIVER
SET DEFINE OFF;
Insert into IEE2019187.DRIVER (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΑΥΤΟΚΙΝΗΤΟ","ΔΙΑΘΕΣΙΜΟΤΗΤΑ") values ('1','hsrHRF','hsrfH','53','Άνδρας','hfs','Διαθέσιμος/η');
Insert into IEE2019187.DRIVER (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΑΥΤΟΚΙΝΗΤΟ","ΔΙΑΘΕΣΙΜΟΤΗΤΑ") values ('44','hdah','hfgdH','54','Άνδρας','hfdzhf','Διαθέσιμος/η');
Insert into IEE2019187.DRIVER (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΑΥΤΟΚΙΝΗΤΟ","ΔΙΑΘΕΣΙΜΟΤΗΤΑ") values ('55','hfsdzh','hfdsHJf','53','Άνδρας','hrsH','Διαθέσιμος/η');
Insert into IEE2019187.DRIVER (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΑΥΤΟΚΙΝΗΤΟ","ΔΙΑΘΕΣΙΜΟΤΗΤΑ") values ('234','dssa','asdad','23','Άνδρας','eqw','Διαθέσιμος/η');
REM INSERTING into IEE2019187.EMPLOYEE
SET DEFINE OFF;
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('111','patatas','patatakias','30','Άνδρας','Σέφ','2222','333123','fgsfg');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('2','fds','dfssdf','34','Άνδρας','Σέφ','112','343','43');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('245','asdas','αδσαδα','66','Άνδρας','Σέφ','4','6','4fds');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('1','GRSH','HRWHR','43','Άνδρας','Σέφ','464236','753','FHDDAH');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('6','HRH','HTAJHT','32','Άνδρας','Σέφ','434','653','GSGH');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('77','hahsr','hrahrs','53','Άνδρας','Σέφ','4654','5642624','hgdash');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('764784','hdshfsh','rshysHY','64','Άνδρας','Σέφ','6436','7537537','gfshy');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('23','fsdf','fghfgh ','45','Άνδρας','Σέφ','454','5454','gfd');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('678','sotos','mpla','24','Άνδρας','Σέφ','657','888767','ppp@gmal.com');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('232','fgdfgd','fghfgh','42','Άνδρας','Προσωπικό Κουζίνας','545','24','767h');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('64','dfssdf','sdfsdf','45','Άνδρας','Σέφ','454','3423','gdf');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('133','d','d','32','Άνδρας','Σέφ','2','232','ddas');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('43','fsdfs','fdsfd','43','Άνδρας','Σέφ','456','3434','gffsd');
Insert into IEE2019187.EMPLOYEE (ID,"ΟΝΟΜΑ","ΕΠΩΝΥΜΟ","ΗΛΙΚΙΑ","ΦΥΛΟ","ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ","ΜΙΣΘΟΣ","ΤΗΛΕΦΩΝΟ",EMAIL) values ('45','sdfsdf','sdfsdf','45','Άνδρας','Σέφ','213','75','fgd');
REM INSERTING into IEE2019187.LOGIN
SET DEFINE OFF;
Insert into IEE2019187.LOGIN (USERNAME,PASSWORD) values ('admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');
REM INSERTING into IEE2019187.ROOM
SET DEFINE OFF;
Insert into IEE2019187.ROOM ("ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ","ΔΙΑΘΕΣΙΜΟΤΗΤΑ","ΚΑΘΑΡΙΣΜΟΣ","ΤΙΜΗ","ΑΡΙΘΜΟΣ_ΚΡΕΒΑΤΙΩΝ") values ('1','Μη διαθέσιμο','Χρησιμοποιείται','40','Μονόκλινο');
Insert into IEE2019187.ROOM ("ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ","ΔΙΑΘΕΣΙΜΟΤΗΤΑ","ΚΑΘΑΡΙΣΜΟΣ","ΤΙΜΗ","ΑΡΙΘΜΟΣ_ΚΡΕΒΑΤΙΩΝ") values ('2','Μη διαθέσιμο','Χρησιμοποιείται','44','Δίκλινο');
Insert into IEE2019187.ROOM ("ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ","ΔΙΑΘΕΣΙΜΟΤΗΤΑ","ΚΑΘΑΡΙΣΜΟΣ","ΤΙΜΗ","ΑΡΙΘΜΟΣ_ΚΡΕΒΑΤΙΩΝ") values ('666666','Μη διαθέσιμο','Χρησιμοποιείται','777','Μονόκλινο');
Insert into IEE2019187.ROOM ("ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ","ΔΙΑΘΕΣΙΜΟΤΗΤΑ","ΚΑΘΑΡΙΣΜΟΣ","ΤΙΜΗ","ΑΡΙΘΜΟΣ_ΚΡΕΒΑΤΙΩΝ") values ('555','Διαθέσιμο','Καθαρό','50','Δίκλινο');
--------------------------------------------------------
--  DDL for Index ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ
--------------------------------------------------------

  CREATE UNIQUE INDEX "IEE2019187"."ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ" ON "IEE2019187"."CUSTOMER" ("ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ
--------------------------------------------------------

  CREATE UNIQUE INDEX "IEE2019187"."ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ" ON "IEE2019187"."ROOM" ("ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "IEE2019187"."ID" ON "IEE2019187"."DRIVER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Procedure ADD_CUSTOMER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "IEE2019187"."ADD_CUSTOMER" ( Cid IN VARCHAR2, CidNum IN VARCHAR2, CName IN VARCHAR2, Surname IN VARCHAR2, Sex IN VARCHAR2, Country IN VARCHAR, RoomNum IN VARCHAR2, CDays IN NUMBER, CPay IN NUMBER)   IS
   BEGIN
	INSERT INTO customer values(Cid,CidNum,CName,Surname,Sex,Country,RoomNum,CDays,CPay);
    UPDATE room SET διαθεσιμοτητα = 'Μη διαθέσιμο' where αριθμοσ_δωματιου = RoomNum;
    UPDATE room SET καθαρισμος = 'Χρησιμοποιείται' where αριθμοσ_δωματιου = RoomNum;
END;

/
--------------------------------------------------------
--  DDL for Procedure ADD_DRIVER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "IEE2019187"."ADD_DRIVER" ( Id IN NUMBER, Name IN VARCHAR2, Surname IN VARCHAR2, Age IN NUMBER, Sex IN VARCHAR2, Car IN VARCHAR2, Availability IN VARCHAR2)   IS
   BEGIN

	INSERT INTO driver values(Id,Name,Surname,Age,Sex,Car,Availability);
END;

/
--------------------------------------------------------
--  DDL for Procedure ADD_EMPLOYEE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "IEE2019187"."ADD_EMPLOYEE" ( id IN NUMBER, name IN VARCHAR2, surname IN VARCHAR2, age IN NUMBER, sex IN VARCHAR2, job IN VARCHAR2, salary IN NUMBER, phone IN NUMBER, email IN VARCHAR2)   IS
   BEGIN

	INSERT INTO employee values(id,name,surname,age,sex,job,salary,phone,email);
END;

/
--------------------------------------------------------
--  DDL for Procedure ADD_ROOM
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "IEE2019187"."ADD_ROOM" ( RoomNum IN NUMBER, Availability IN VARCHAR2, Clean IN VARCHAR2, Price IN NUMBER, BedNum IN VARCHAR2)   IS
   BEGIN

	INSERT INTO room values(RoomNum,Availability,Clean,Price,BedNum);
END;

/
--------------------------------------------------------
--  DDL for Procedure CHECKOUT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "IEE2019187"."CHECKOUT" (CidNum IN VARCHAR2, cur OUT SYS_REFCURSOR) IS 
BEGIN   
   open cur for select * from room inner join customer on room.Αριθμός_δωματίου = customer.Αριθμός_δωματίου WHERE customer.Αριθμός_Εγγράφου = CidNum ;

END;

/
--------------------------------------------------------
--  DDL for Procedure GETCUSTOMERS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "IEE2019187"."GETCUSTOMERS" (
    rec OUT SYS_REFCURSOR
) IS
BEGIN
    -- Open the cursor for the result set
    OPEN rec FOR
        SELECT * FROM customer ;
        
    -- You can add more logic here if needed
END;

/
--------------------------------------------------------
--  DDL for Procedure GETEMPLOYEE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "IEE2019187"."GETEMPLOYEE" (
    rec OUT SYS_REFCURSOR
) IS
BEGIN
    -- Open the cursor for the result set
    OPEN rec FOR
        SELECT * FROM employee ;

    -- You can add more logic here if needed
END;

/
--------------------------------------------------------
--  DDL for Procedure LOGINC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "IEE2019187"."LOGINC" (
    Uname IN VARCHAR2,
    Pass IN VARCHAR2,
    rec OUT SYS_REFCURSOR
) IS
BEGIN
    -- Open the cursor for the result set
    OPEN rec FOR
        SELECT * FROM login WHERE username = Uname AND password = Pass;
        
    -- You can add more logic here if needed
END;

/
--------------------------------------------------------
--  Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "IEE2019187"."EMPLOYEE" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."EMPLOYEE" MODIFY ("ΤΗΛΕΦΩΝΟ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."EMPLOYEE" MODIFY ("ΜΙΣΘΟΣ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."EMPLOYEE" MODIFY ("ΕΙΔΟΣ_ΕΡΓΑΣΙΑΣ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."EMPLOYEE" MODIFY ("ΦΥΛΟ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."EMPLOYEE" MODIFY ("ΗΛΙΚΙΑ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."EMPLOYEE" MODIFY ("ΕΠΩΝΥΜΟ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."EMPLOYEE" MODIFY ("ΟΝΟΜΑ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."EMPLOYEE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOGIN
--------------------------------------------------------

  ALTER TABLE "IEE2019187"."LOGIN" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."LOGIN" MODIFY ("USERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CUSTOMER
--------------------------------------------------------

  ALTER TABLE "IEE2019187"."CUSTOMER" MODIFY ("ΠΟΣΟ_ΠΛΗΡΩΜΗΣ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."CUSTOMER" MODIFY ("ΗΜΕΡΕΣ_ΔΙΑΜΟΝΗΣ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."CUSTOMER" MODIFY ("ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."CUSTOMER" MODIFY ("ΧΩΡΑ_ΔΙΑΜΟΝΗΣ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."CUSTOMER" MODIFY ("ΦΥΛΟ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."CUSTOMER" MODIFY ("ΕΠΩΝΥΜΟ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."CUSTOMER" MODIFY ("ΟΝΟΜΑ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."CUSTOMER" MODIFY ("ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."CUSTOMER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."CUSTOMER" ADD CONSTRAINT "ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ" PRIMARY KEY ("ΑΡΙΘΜΟΣ_ΕΓΓΡΑΦΟΥ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DRIVER
--------------------------------------------------------

  ALTER TABLE "IEE2019187"."DRIVER" MODIFY ("ΔΙΑΘΕΣΙΜΟΤΗΤΑ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."DRIVER" MODIFY ("ΑΥΤΟΚΙΝΗΤΟ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."DRIVER" MODIFY ("ΦΥΛΟ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."DRIVER" MODIFY ("ΗΛΙΚΙΑ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."DRIVER" MODIFY ("ΕΠΩΝΥΜΟ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."DRIVER" MODIFY ("ΟΝΟΜΑ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."DRIVER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."DRIVER" ADD CONSTRAINT "ID" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ROOM
--------------------------------------------------------

  ALTER TABLE "IEE2019187"."ROOM" MODIFY ("ΑΡΙΘΜΟΣ_ΚΡΕΒΑΤΙΩΝ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."ROOM" MODIFY ("ΤΙΜΗ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."ROOM" MODIFY ("ΚΑΘΑΡΙΣΜΟΣ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."ROOM" MODIFY ("ΔΙΑΘΕΣΙΜΟΤΗΤΑ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."ROOM" MODIFY ("ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ" NOT NULL ENABLE);
  ALTER TABLE "IEE2019187"."ROOM" ADD CONSTRAINT "ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ" PRIMARY KEY ("ΑΡΙΘΜΟΣ_ΔΩΜΑΤΙΟΥ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
