/*
    *데이터 정의어
    오라클에서 제공하는 객체를 새로 만들고(CREATE), 구조를 변경하고(ALTER), 
    구조자체를 삭제(DROP)하는 언어 즉, 실제 데이터값이 아닌 규칙 자체를 정의하는 언어
    
    오라클에서 객체(구조) : 테이블, 뷰, 시퀀스,
                             인덱스, 패키지, 트리거,
                             프로시저, 함수, 동의어, 사용자
                    
    <CREATE>
    객체를 새로 생성하는 구문
    
*/

/*
    1. 테이블 생성
    테이블이란 : 행과 열로 구성되는 가장 기본적인 데이터베이스 객체
                모든 데이터들은 테이블을 통해 저장된다.
                 (DBMS용어 중 하나로, 데이터를 일종의 표 형태로 표현한 것)
                 
    [표현식]
    CREATE TABLE 테이블명(
    컬럼명 자료형(크기),
    컬럼명 자료형(크기),
    컬럼명 자료형
    ...
    )
    
    *자료형
    -숫자(NUMBER)
    -문자(CHAR(바이트크기) | VARCHAR2(바이트크기)) -> 반드시 크기를 지정해 줘야 함
        -CHAR : 최대 2000바이트까지 지정가능 / 고정길이(고정된 글자수의 데이터가 담길 경우)
        -VARCHAR : 최대 4000바이트까지 지정가능 / 가변길이(몇글자의 데이터가 들어올지 모르는 경우)
    -날짜(DATE)
*/
--회원에 대한 데이터를 담기위한 테이블 MEMBER
CREATE TABLE MEMBER(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20), --user01, alwaysjone
    MEM_PWD VARCHAR2(20),
    MEM_NAME VARCHAR2(20),
    GENDER CHAR(3), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);

SELECT * FROM MEMBER;
--------------------------------------------------------------
/*
   2. 컬럼에 주석달기(컬럼에 대한 간단한 설명)
   
   [표현법]
   COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
*/

COMMENT ON COLUMN MEMBER.MEM_NO IS '회원번호';
COMMENT ON COLUMN MEMBER.MEM_ID IS '회원아이디';
COMMENT ON COLUMN MEMBER.MEM_PWD IS '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEM_NAME IS '회원이름';
COMMENT ON COLUMN MEMBER.GENDER IS '성별(남/여)';
COMMENT ON COLUMN MEMBER.PHONE IS '전화번호';
COMMENT ON COLUMN MEMBER.EMAIL IS '이메일';
COMMENT ON COLUMN MEMBER.MEM_DATE IS '회원가입일';

--테이블을 삭제하고자 할 때 : DROP TABLE 테이블명;
DROP TABLE MEMBER;

--INSERT INTO 테이블명 VALUES(값,값,값...);
INSERT INTO MEMBER 
VALUES(1,'USER1','PASS1','홍길동','남','010-1111-2222','AAA@NAVER.COM','24/12/23');

SELECT * FROM MEMBER;

INSERT INTO MEMBER 
VALUES(1,'USER1','PASS1',NULL,NULL,'010-1111-2222',NULL,NULL);

--------------------------------------------------------------
/*
   <제약조건>
   - 원하는 데이터값(유효한 형식의 값)만 유지하기 위해서 특정 컬럼에 설정하는 제약
   - 데이터 무결성 보장을 목적으로 한다. 
   
   종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
*/

/*
    *NOT NULL
    해당 컬럼에 반드시 값이 존재해야만 하는 경우(즉, 절대 NULL이 들어오면 안되는 경우)
    삽입/수정시 NULL값을 허용하지 않도록 제한
    
    제약조건을 부여하는 방식은 크게 2가지가 있다.(컬럼레벨방식, 테이블레벨방식)
    NOT NULL 제약조건은 무조건 컬럼레벨방식(컬럼 바로 옆에 기재)만 가능하다. 
*/
CREATE TABLE MEMBER(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL, --user01, alwaysjone
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);

INSERT INTO MEMBER 
VALUES(1,'USER1','PASS1','홍길동','남','010-1111-2222','AAA@NAVER.COM','24/12/23');

SELECT * FROM MEMBER;

INSERT INTO MEMBER 
VALUES(2,'USER2','PASS2','홍길순',NULL,NULL,NULL,NULL);

INSERT INTO MEMBER 
VALUES(3,'USER2','PASS3','홍길삼',NULL,NULL,NULL,NULL);
--아이디가 중복되었음에도 불구하고 잘 추가가된다.

-----------------------------------------------------------
/*
    *UNIQUE 제약조건
    해당 컬럼에 중복값이 들어가서는 안될 경우 사용한다.
    컬럼값에 중복값을 제한하는 제약조건이다.
    삽입/수정시 기존에 있는 데이터값 중 중복값이 있을 경우 오류를 발생시킨다.
*/

CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, --user01, alwaysjone
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    UNIQUE(EMAIL) -- 테이블레벨방식
);

INSERT INTO MEM_UNIQUE 
VALUES(1,'USER1','PASS1','홍길동','남','010-1111-2222','AAA@NAVER.COM','24/12/23');

SELECT * 
FROM MEM_UNIQUE;

INSERT INTO MEM_UNIQUE
VALUES(2,'USER1','PASS2','홍길동','여','010-1111-3333','BBB@NAVER.COM','24/12/23');
--UNIQUE제약조건에 위배되었으므로 INSERT 실패
--> 오류구분을 제약조건명으로 알려준다.
--> 쉽게 어떤 제약조건이 위반인지 알기 어렵다.
--> 제약조건 부여시 제약조건명을 지정할 수 있다.(지정하지 않으면 시스템에서 자동으로 부여함)

-----------------------------------------------------------------------------------
/*
   *제약조건 부여시 제약조건명까지 부여하는 방법
   > 컬럼레벨방식
   CREATE TABLE 테이블명(
         컬럼명 자료형 CONSTRAINT 제약조건명 제약조건
   )
   
   >테이블레벨방식
   CREATE TABLE 테이블명(
         컬럼명 자료형,
         컬럼명 자료형,
         CONSTRAINT 제약조건명 제약조건(컬럼명)
   )
*/

DROP TABLE MEM_UNIQUE;

CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL,
    MEM_ID VARCHAR2(20) CONSTRAINT MEMID_NT NOT NULL, --user01, alwaysjone
    MEM_PWD VARCHAR2(20)CONSTRAINT MEMPWD_NT NOT NULL,
    MEM_NAME VARCHAR2(20) CONSTRAINT MEMNAME_NT NOT NULL,
    GENDER CHAR(3), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    CONSTRAINT MEMID_UQ UNIQUE(MEM_ID) -- 테이블레벨방식
);

INSERT INTO MEM_UNIQUE 
VALUES(1,'USER1','PASS1','홍길동','남','010-1111-2222','AAA@NAVER.COM','24/12/23');

SELECT * FROM MEM_UNIQUE;

INSERT INTO MEM_UNIQUE 
VALUES(2,'USER2','PASS2','홍길순','여',NULL,NULL,NULL);

INSERT INTO MEM_UNIQUE 
VALUES(3,'USER3','PASS3','홍길삼',NULL,NULL,NULL,NULL);

INSERT INTO MEM_UNIQUE 
VALUES(4,'USER3','PASS4','홍길사',NULL,NULL,NULL,NULL);

---------------------------------------------------------------------
/*
    *CHECK(조건식)
    해당 컬럼에 들어올 수 있는 값에 대한 조건을 제시해줄 수 있다.
    해당조건에 만족하는 데이터값만 담길 수 있음.
*/

CREATE TABLE MEM_CHECK(
    MEM_NO NUMBER  NOT NULL,
    MEM_ID VARCHAR2(20)  NOT NULL, --user01, alwaysjone
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    UNIQUE(MEM_ID) -- 테이블레벨방식
);

INSERT INTO MEM_CHECK --CHECK 제약조건은 NULL값 삽입 가능
VALUES(1,'USER1','PASS1','홍길동',NULL,'010-1111-2222','AAA@NAVER.COM','24/12/23');

SELECT * FROM MEM_CHECK;

INSERT INTO MEM_CHECK
VALUES(2,'USER2','PASS2','홍길순','자','010-1111-3333','BBB@NAVER.COM','24/12/23');
--CHECK 제약조건 때문에 예외가 발생한다.
--GENDER컬럼에는 CHECK제약조건을 만족하는 값을 넣어야한다.
--단, NULL은 값이 없다는 뜻이기 때문에 가능하다.

INSERT INTO MEM_CHECK
VALUES(2,'USER2','PASS2','홍길순','여','010-1111-3333','BBB@NAVER.COM','24/12/23');

----------------------------------------------------------------------------
/*
    PRIMARY KEY(기본키) 제약조건
    테이블에서 각 행(ROW)를 식별하기 위해 사용될 컬럼에 부여하는 제약조건(식별자 역할)
    
    EX) 회원번호, 학번, 군번, 부서코드, 직급코드, 주민등록번호, 택배운송장번호, 예약번호...
    PRIMARY KEY -> NOT NULL + UNIQUE
    
    한 테이블당 오직 한개만 설정 가능
*/

CREATE TABLE MEM_PRI(
    MEM_NO NUMBER CONSTRAINT MEMNO_PK PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL, --user01, alwaysjone
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    UNIQUE(MEM_ID) -- 테이블레벨방식
);

INSERT INTO MEM_PRI 
VALUES(1,'USER1','PASS1','홍길동',NULL,'010-1111-2222','AAA@NAVER.COM','24/12/23');

INSERT INTO MEM_PRI
VALUES(1,'USER2','PASS2','홍길순',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23');
--기본키에 중복값을 담으려고할 때(UNIQUE 제약조건 위반)

INSERT INTO MEM_PRI
VALUES(NULL,'USER2','PASS2','홍길순',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23');
--기본키에 NULL을 담으려고할 때(NOT NULL 제약조건 위배)

INSERT INTO MEM_PRI
VALUES(2,'USER2','PASS2','홍길순',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23');

CREATE TABLE MEM_PRI2(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL, --user01, alwaysjone
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);
--복합키 : 두개의 컬럼을 동시에 하나의 PRIMARY KEY로 지정하는 것이다.

INSERT INTO MEM_PRI2 
VALUES(1,'USER1','PASS1','홍길순',NULL,'010-1111-2222','AAA@NAVER.COM','24/12/23');
INSERT INTO MEM_PRI2
VALUES(2,'USER2','PASS2','홍길동',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23');
INSERT INTO MEM_PRI2
VALUES(3,'USER3','PASS3','홍길삼',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23');
INSERT INTO MEM_PRI2
VALUES(4,'USER4','PASS4','홍길사',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23');

--복합키 사용 예(어떤 회원이 어떤 상품을 찜했는지에 대한 데이터를 보관하는 테이블 )
CREATE TABLE TB_LIKE(
    MEM_NO NUMBER,
    PRODUCT_NAME VARCHAR2(20),
    LIKE_DATE DATE,
    PRIMARY KEY(MEM_NO, PRODUCT_NAME)
    );

-- 회원4명(1,2,3,4번)
-- 상품2개(자전거A, 자전거B)

INSERT INTO TB_LIKE VALUES(1,'자전거A', SYSDATE); -- 홍길순이 자전거A 좋아요 누름
INSERT INTO TB_LIKE VALUES(1,'자전거B', SYSDATE);
INSERT INTO TB_LIKE VALUES(1,'자전거A', SYSDATE); -- 복합키(번호,상품명을 기본키)로 제어
INSERT INTO TB_LIKE VALUES(2,'자전거A', SYSDATE);

----------------------------------------------------------------------------------
--회원 등급에 대한 데이터를 보관하는 테이블
CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL    
);

INSERT INTO MEM_GRADE VALUES(10,'일반회원');
INSERT INTO MEM_GRADE VALUES(20,'우수회원');
INSERT INTO MEM_GRADE VALUES(30,'특별회원');
INSERT INTO MEM_GRADE VALUES(40,'VIP');

SELECT * FROM MEM_GRADE;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL, --user01, alwaysjone
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    GRADE_ID NUMBER
);

INSERT INTO MEM
VALUES(1,'USER1','PASS1','홍길순',NULL,'010-1111-2222','AAA@NAVER.COM','24/12/23',NULL);

INSERT INTO MEM
VALUES(2,'USER2','PASS2','홍길동',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23',10);

INSERT INTO MEM
VALUES(3,'USER3','PASS3','홍길삼',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23',30);

INSERT INTO MEM
VALUES(4,'USER4','PASS4','홍길사',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23',20);

--유효하지않은 회원등급번호(50)가 정상적으로 INSERT된다.
INSERT INTO MEM
VALUES(5,'USER5','PASS5','홍길오',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23',50);
/*
   FOREIGN_KEY(외래키) 제약조건   
   다른 테이블에 존재하는 값만 들어와야되는데 특정 컬럼에 부여하는 제약조건
    -> 다른 테이블을 참조한다고 표현
    -> 주로 FOREIGN KEY 제약조건으로 인해 테이블간 관계가 형성된다.
    
    >컬럼레벨방식
    컬럼명 자료형 REFERENCES 참조할 테이블명[참조할 컬럼명]
    
    >테이블레벨방식
    FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명[참조할 컬럼명]
    
    -> 참조할 컬럼명 생략시 참조할 테이블의 PRIMARY KEY로 지정된 컬럼이 매칭된다.
*/
DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL, --user01, alwaysjone
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE)
);

INSERT INTO MEM
VALUES(1,'USER1','PASS1','홍길순',NULL,'010-1111-2222','AAA@NAVER.COM','24/12/23',NULL);

INSERT INTO MEM
VALUES(2,'USER2','PASS2','홍길동',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23',10);

INSERT INTO MEM
VALUES(3,'USER3','PASS3','홍길삼',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23',30);

INSERT INTO MEM
VALUES(4,'USER4','PASS4','홍길사',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23',20);

INSERT INTO MEM
VALUES(5,'USER5','PASS5','홍길오',NULL,'010-1111-3333','AAA@NAVER.COM','24/12/23',50);
-- PARENT KEY를 찾을 수 없다는 오류가 발생

SELECT * FROM MEM;
-- MEM_GRADE(부모테이블) -|---------<-MEM(자식테이블)
-- 1:N 관계 1쪽이 부모테이블 N이 자식테이블

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;
--MEM테이블에서 10이라는 값을 사용하고 있기 때문에 삭제가 안됨.

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 40;
--MEM테이블에서 40이라는 값을 사용하고있지 않기 때문에 삭제가 된다.

--자식테이블에서 이미 사용하고 있는 값이 있을 경우
--부모테이블로부터 무조건 삭제가 안되는 "삭제제한" 옵션이 걸려있다.

--------------------------------------------------------------------------------
/*
   자식테이블 생성시 외래키 제약조건 부여할 때 삭제옵션 지정가능
   *삭제옵션 : 부모테이블의 데이터 삭제시 그 데이터를 사용하고 있는 자식테이블의 값을 어떻게 할것인가?
   -ON DELETE RESTRICTED(기본값) : 삭제제한옵션, 자식데이터로부터 쓰이는 부모데이터는 삭제가 안됨!
   -ON DELETE SET NULL : 부모데이터 삭제시 해당 데이터를 사용하고 있는 자식데이터의 값을 NULL로 변경
   -ON DELETE CASCADE : 부모데이터 삭제시 해당 데이터를 사용하고 있는 자식데이터도 모두 삭제.  
*/

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL, --user01, alwaysjone
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE SET NULL
);

INSERT INTO MEM VALUES(1,'USER1','PASS1','홍길순',NULL,NULL,NULL,NULL,NULL);
INSERT INTO MEM VALUES(2,'USER2','PASS2','홍길동',NULL,NULL,NULL,NULL,10);
INSERT INTO MEM VALUES(3,'USER3','PASS3','홍길삼',NULL,NULL,NULL,NULL,30);
INSERT INTO MEM VALUES(4,'USER4','PASS4','홍길사',NULL,NULL,NULL,NULL,20);

DELETE FROM MEM_GRADE WHERE GRADE_CODE = 10;

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL, --user01, alwaysjone
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남', '여')), --남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE CASCADE
);

INSERT INTO MEM VALUES(1,'USER1','PASS1','홍길순',NULL,NULL,NULL,NULL,NULL);
INSERT INTO MEM VALUES(2,'USER2','PASS2','홍길동',NULL,NULL,NULL,NULL,10);
INSERT INTO MEM VALUES(3,'USER3','PASS3','홍길삼',NULL,NULL,NULL,NULL,30);
INSERT INTO MEM VALUES(4,'USER4','PASS4','홍길사',NULL,NULL,NULL,NULL,20);

DELETE FROM MEM_GRADE WHERE GRADE_CODE = 10;
--> GRADE_CODE가 10을 가진 사람의 튜플을 아예 삭제

------------------------------------------------------------
/*
    <DEFAULT 기본값> *제약조건은 아니다.
    컬럼을 선정하지않고 INSERT시에 NULL이 아닌 기본값을 INSERT하고자한다.
    미리 값을 세팅해 둘 수 있다.
    
    컬럼값 자료형 DEFAULT 기본값
*/

DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_NAME VARCHAR2(20) NOT NULL,
    MEM_AGE NUMBER,
    HOBBY VARCHAR2(20) DEFAULT '없음',
    ENROLL_DATE DATE DEFAULT SYSDATE
    );

--INSERT INTO 테이블명 VALUES(값1, 값2, 값3 ...)
INSERT INTO MEMBER VALUES(1,'빵빵이', 20, '운동','20/01/01');
INSERT INTO MEMBER VALUES(2,'옥지', 20, NULL,NULL);
INSERT INTO MEMBER VALUES(3,'최지원', 19, DEFAULT,DEFAULT);

--INSERT INTO 테이블명(컬럼1,컬럼2,...) VALUES(값1, 값2...)
INSERT INTO MEMBER(MEM_NO, MEM_NAME) VALUES(4,'최지투');
--> 선택되지 않은 컬럼에는 기본적으로 NULL이 적용됨
-->단, 해당 컬럼에 DEFAULT값이 부여되어 있을 경우 NULL이 아닌 DEFAULT값이 들어감

------------------------------------------------------------------
--관리자계정으로 생성
CREATE USER C##KH IDENTIFIED BY KH;

GRANT CONNECT,RESOURCE TO C##KH;

ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
--KH계정으로 전환
------------------------------------------------------------------
--테이블을 복제할 수 있다. 여기서부터 KH계정 이용
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE);

DROP TABLE EMPLOYEE_COPY

--테이블 구조만 복사
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE WHERE 1=0);

------------------------------------------------------------------
/*
    테이블이 다 생성된 후에 제약조건을 추가하는 방법
    ALTER TABLE 테이블명 변경할 내용
    
    -PRIMARY KEY : ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명);
    -FOREIGN KEY : ALTER TABLE 테이블명 ADD FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명(컬럼명);
    -UNIQUE : ALTER TABLE 테이블명 ADD UNIQUE(컬럼명);
    -CHECK : ALTER TABLE 테이블명 ADD CHECK(컬럼에 대한 조건식);
    -NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
*/

--EMPLOYEE COPY테이블에 PRIMARY KEY 제약조건 추가(EMP_ID)
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);

--EMPLOYEE테이블에 DEPT_CODE에 외래키 제약조건 추가
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT;

--EMPLOYEE테이블에 JOB_CODE에 외래키 제약조건 추가
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(JOB_CODE) REFERENCES JOB;

--DEPARTMENT테이블에 LOCATION_ID에 외래키 제약조건 추가
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION;

--실습문제 --
--도서관리 프로그램을 만들기 위한 테이블들 만들기--
--이때, 제약조건에 이름을 부여할 것
--   각 컬럼에 주석달기

DROP TABLE TB_MEMBER;
DROP TABLE TB_BOOK;
DROP TABLE TB_PUBLISHER;

/*
    1. 출판사들에 대한 데이터를 담기위한 출판사 테이블(TB_PUBLISHER)
    컬럼 : PUB_NO(출판사 번호) - 기본키(PUBLISHER_PK)
          PUB_NAME(출판사명) -- NOT NULL(PUBLISHER_NN)
          PHONE(출판사전화번호) -- 제약조건없음
*/
CREATE TABLE TB_PUBLISHER (
       PUB_NO NUMBER CONSTRAINT PUBLISHER_PK PRIMARY KEY,
       PUB_NAME VARCHAR2(20) CONSTRAINT PUBLISHER_NN NOT NULL,
       PHONE VARCHAR2(15)       
       );

COMMENT ON COLUMN TB_PUBLISHER.PUB_NO IS '출판사 번호';
COMMENT ON COLUMN TB_PUBLISHER.PUB_NAME IS '출판사명';
COMMENT ON COLUMN TB_PUBLISHER.PHONE IS '출판사전화번호';
       
--샘플 3개정도 생성
INSERT INTO TB_PUBLISHER VALUES(123123, '황인태', '13131313');
INSERT INTO TB_PUBLISHER VALUES(456456, '남재현', '24242424');
INSERT INTO TB_PUBLISHER VALUES(789789, '백경흠', '35353535');
/*
    2. 도서들에 대한 데이터를 담기위한 도서 테이블(TB_BOOK)
    컬럼 : BK_NO(도서번호)--기본키(BOOK_PK)
          BK_TITLE(도서명)--NOT NULL(BOOK__NN_TITLE)
          BK_AUTHOR(저자명)--NOT NULL(BOOK__NN_AUTHOR)
          BK_PRICE(가격)-- 제약조건없음
          BK_PUB_NO(출판사 번호)--외래키(BOOK_FK)(TB_PUBLISHER테이블을 참조)
                                이때 참조하고 있는 부모데이터 삭제시 자식데이터도 삭제 되도록 옵션지정
                                
*/

CREATE TABLE TB_BOOK (
      BK_NO NUMBER CONSTRAINT BOOK_PK PRIMARY KEY,
      BK_TITLE VARCHAR2(10) CONSTRAINT BOOK__NN_TITLE NOT NULL,
      BK_AUTHOR VARCHAR2(10) CONSTRAINT BOOK__NN_AUTHOR NOT NULL,
      BK_PRICE NUMBER,
      BK_PUB_NO NUMBER CONSTRAINT BOOK_FK REFERENCES TB_PUBLISHER(PUB_NO) ON DELETE CASCADE
      );

COMMENT ON COLUMN TB_BOOK.BK_NO IS '도서번호';
COMMENT ON COLUMN TB_BOOK.BK_TITLE IS '도서명';
COMMENT ON COLUMN TB_BOOK.BK_AUTHOR IS '저자명';
COMMENT ON COLUMN TB_BOOK.BK_PRICE IS '가격';
COMMENT ON COLUMN TB_BOOK.BK_PUB_NO IS '출판사번호';

--5개 정도의 샘플 데이터 추가하기
INSERT INTO TB_BOOK VALUES(1234567, '낫샤이', '있지', 20000, 123123);
INSERT INTO TB_BOOK VALUES(1345678, '세비지', '에스파', 15000, 123123);
INSERT INTO TB_BOOK VALUES(1456789, '매그틱', '아일릿', 30000, 456456);
INSERT INTO TB_BOOK VALUES(1567891, '별별별', '엔믹스', 25000, 456456);
INSERT INTO TB_BOOK VALUES(1671234, '쿠키', '뉴진스', 19000, 789789);

/*
    3. 회원에 대한 데이터를 담기위한 회원 테이블(TB_MEMBER)
    컬럼명 : MEMBER_NO(회원번호) -- 기본키(MEMBER_PK)
            MEMBER_ID(아이디) -- 중복금지(MEMBER_UQ_ID)
            MEMBER_PWD(비밀번호) -- NOT NULL(MEMBER_NN_PWD)
            MEMBER_NAME(회원명) -- NOT NULL(MEMBER_NN_NAME)
            GENDER(성별) -- M또는 F로 입력되도록 제한(MEMBER_CK_GEN)
            ADDRESS(주소) -- 제약조건없음
            PHONE(연락처)-- 제약조건없음
            STATUS(탈퇴여부) -- 기본값을 N으로 지정, 그리고 N또는 Y만 입력되도록 제약조건 설정(MEMBER_CK_STA)
            ENROLL_DATE(가입일) -- 기본값으로 SYSDATE, NOT NULL 제약조건(MEMBER_NN_EN)
*/
CREATE TABLE TB_MEMBER(
       MEMBER_NO NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
       MEMBER_ID VARCHAR2(15) CONSTRAINT MEMBER_UQ_ID UNIQUE,
       MEMBER_PWD VARCHAR2(15) CONSTRAINT MEMBER_NN_PWD NOT NULL,
       MEMBER_NAME VARCHAR2(10) CONSTRAINT MEMBER_NN_NAME NOT NULL,
       GENDER VARCHAR2(3) CONSTRAINT MEMBER_CK_GEN CHECK(GENDER IN('M','F')),
       ADDRESS VARCHAR2(30),
       PHONE VARCHAR2(18),
       STATUS VARCHAR2(3) DEFAULT 'N' CONSTRAINT MEMBER_CK_STA CHECK(STATUS IN('N','Y')),
       ENROLL_DATE DATE DEFAULT SYSDATE CONSTRAINT MEMBER_NN_EN NOT NULL 
       );

COMMENT ON COLUMN TB_MEMBER.MEMBER_NO IS '회원번호';
COMMENT ON COLUMN TB_MEMBER.MEMBER_ID IS '아이디';
COMMENT ON COLUMN TB_MEMBER.MEMBER_PWD IS '비밀번호';
COMMENT ON COLUMN TB_MEMBER.MEMBER_NAME IS '회원명';
COMMENT ON COLUMN TB_MEMBER.GENDER IS '성별';
COMMENT ON COLUMN TB_MEMBER.ADDRESS IS '주소';
COMMENT ON COLUMN TB_MEMBER.PHONE IS '연락처';
COMMENT ON COLUMN TB_MEMBER.STATUS IS '탈퇴여부';
COMMENT ON COLUMN TB_MEMBER.ENROLL_DATE IS '가입일';      
--5개 정도의 샘플 데이터 추가하기
INSERT INTO TB_MEMBER VALUES(123, 'ABC', 'ABC', '윈터', 'M', '성수동', '2929','Y', '20/11/15');
INSERT INTO TB_MEMBER VALUES(456, 'DEF', 'DEF', '민지', 'F', '연희동', '1313','N', '15/12/11');
INSERT INTO TB_MEMBER VALUES(789, 'GHI', 'GHI', '설윤', 'F', '대치동', '1515','N', '18/06/24');
INSERT INTO TB_MEMBER VALUES(912, 'JKL', 'JKL', '유나', 'M', '삼성동', '1919','Y', '19/01/16');
INSERT INTO TB_MEMBER VALUES(345, 'MNO', 'MNO', '하니', 'M', '청담동', '3939','N', '16/05/10');

/*
    4.어떤 회원이 어떤 도서를 대여했는지에 대한 대여목록 테이블(TB_RENT)
    컬럼명 : RENT_NO(대여번호)-- 기본키(RENT_PK)
            RENT_MEM_NO(대여회원번호)-- 외래키(RENT_FK_MEM) TB_MEMBER와 참조하도록
                                        이때 부모 데이터 삭제시 자식데이터 값이 NULL이 되도록 지정
            RENT_BOOK_NO(대여도서번호)-- 외래키(RENT_FK_BOOK) TB_BOOK와 참조하도록
                                        이때 부모 데이터 삭제시 자식데이터 값이 NULL이 되도록 지정
            RENT_DATE(대여일) -- 기본값 SYSDATE
*/
CREATE TABLE TB_RENT(
       RENT_NO NUMBER CONSTRAINT RENT_PK PRIMARY KEY,
       RENT_MEM_NO NUMBER CONSTRAINT RENT_FK_MEM REFERENCES TB_MEMBER(MEMBER_NO) ON DELETE SET NULL,
       RENT_BOOK_NO NUMBER CONSTRAINT RENT_FK_BOOK REFERENCES TB_BOOK(BK_NO) ON DELETE SET NULL,
       RENT_DATE DATE DEFAULT SYSDATE);
       
COMMENT ON COLUMN TB_RENT.RENT_NO IS '대여번호';
COMMENT ON COLUMN TB_RENT.RENT_MEM_NO IS '대여회원번호';
COMMENT ON COLUMN TB_RENT.RENT_BOOK_NO IS '대여도서번호';
COMMENT ON COLUMN TB_RENT.RENT_DATE IS '대여일';

--3개 정도의 샘플 데이터 추가하기
INSERT INTO TB_RENT VALUES(10001, 123, 1234567, '23/03/18');
INSERT INTO TB_RENT VALUES(10006, 456, 1671234, '17/08/28');
INSERT INTO TB_RENT VALUES(10003, 789, 1456789, '19/09/13');

