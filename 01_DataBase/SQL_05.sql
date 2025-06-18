--1. 과목유형 테이블(TB_CLASS_TYPE)에 아래와 같은 데이터를 입력하시오.
INSERT INTO TB_CLASS_TYPE VALUES('01,', '전공필수');
INSERT INTO TB_CLASS_TYPE VALUES('02,', '전공선택');
INSERT INTO TB_CLASS_TYPE VALUES('03,', '교양필수');
INSERT INTO TB_CLASS_TYPE VALUES('04,', '교양선택');
INSERT INTO TB_CLASS_TYPE VALUES('05,', '논문지도');

SELECT CLASS_TYPE_NO AS 번호 , CLASS_TYPE_NAME AS 유형이름
FROM TB_CLASS_TYPE;

COMMENT ON COLUMN TB_CLASS_TYPE.CLASS_TYPE_NO IS '번호';
COMMENT ON COLUMN TB_CLASS_TYPE.CLASS_TYPE_NAME IS '유형이름';

--2. 춘 기술대학교 학생들의 정보가 포함되어 있는 학생일반정보
--   테이블을 만들고자 한다. 아래 내용을 참고하여 적절한 SQL문 작성(서브쿼리로 작성)
CREATE TABLE TB_학생일반정보 
            AS(SELECT STUDENT_NO AS "학번" , STUDENT_NAME AS "학생이름" , STUDENT_ADDRESS AS "주소"
               FROM TB_STUDENT);
               
--3. 국어국문학과 학생들의 정보만이 포함되어 있는 학과정보 테이블을 만들고자 한다.
--   아래 내용을 참고하여 적절한 SQL문을 작성하시오. (힌트 : 방법은 다양함 소신껏)
CREATE TABLE TB_국어국문학과
            AS(SELECT STUDENT_NO AS "학번" , STUDENT_NAME AS "학생이름", 
            SUBSTR(STUDENT_SSN,1,2) + 1900 AS "출생년도", PROFESSOR_NAME AS "교수이름"
            FROM TB_STUDENT S
            JOIN TB_PROFESSOR P ON(S.COACH_PROFESSOR_NO = P.PROFESSOR_NO));

--4. 현 학과들의 정원을 10% 증가시키게 되었다. 이에 사용할 SQL문을 작성
--   (단, 반올림을 사용하여 소수점 자릿수는 생기지 않도록 한다)
UPDATE TB_DEPARTMENT
SET CAPACITY = ROUND(CAPACITY * 1.1);

--5. 학번 A413042인 박건우 학생의 주소가 "서울시 종로구 숭인동 181-21"로
--   변경되었다고 한다. 주소지를 정정하기 위해 사용할 SQL문을 작성
UPDATE TB_STUDENT
SET STUDENT_ADDRESS = '서울시 종로구 숭인동 181-21'
WHERE STUDENT_NO = 'A413042';

--6. 주민등록번호 보호법에 따라 학생정보 테이블에서 주민번호 뒷자리를
--   저장하지 않기로 결정하였다. 이 내용을 반영할 적절한 SQL문장을 작성
--   (예. 830530-2124663 => 830530)
UPDATE TB_STUDENT
SET STUDENT_SSN = SUBSTR(STUDENT_SSN,1,6);

--7. 의학과 김명훈 학생은 2005년 1학기에 자신이 수강한 '피부생리학'
--   점수가 잘못되었다는 것을 발견하고는 정정을 요청하였다. 담당 교수의
--   확인 받은 결과 해당 과목의 학점을 3.5로 변경하기로 결정하였다.
UPDATE TB_GRADE
SET POINT = 3.5
WHERE TERM_NO = '200501' 
AND STUDENT_NO IN(SELECT STUDENT_NO
                  FROM TB_STUDENT
                  JOIN TB_CLASS USING(DEPARTMENT_NO)
                  WHERE STUDENT_NAME = '김명훈' AND CLASS_NAME = '피부생리학' AND
                  DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                                   FROM TB_DEPARTMENT
                                   WHERE DEPARTMENT_NAME = '의학과'));
                                   
--8. 성적 테이블(TB_GRADE)에서 휴학생들의 성적항목을 제거하시오.
DELETE FROM TB_GRADE
WHERE STUDENT_NO IN (SELECT STUDENT_NO
                     FROM TB_STUDENT
                     WHERE ABSENCE_YN = 'Y');