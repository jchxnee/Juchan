--EMPLOYEE테이블에서 부서코드가 D9인 사원들만 조회(모든컬럼)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

--EMPLOYEE에서 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

--EMPLOYEE에서 부서코드가 'D1'이 아닌 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

--월급이 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

--1. 급여가 300만원 이상인 사원들의 사원명, 급여, 입사일, 연봉(별칭 -> 연봉)
SELECT EMP_NAME, SALARY, HIRE_DATE, SALARY * 12 AS 연봉
FROM EMPLOYEE
WHERE SALARY >=3000000;


--2. 연봉이 5천만원 이상인 사원들의 사원명, 급여, 연봉(별칭 -> 연봉), 부서코드 조회
SELECT EMP_NAME, SALARY, SALARY * 12 AS 연봉, DEPT_CODE
FROM EMPLOYEE
WHERE SALARY * 12 >=50000000;

--3. 직급코드가 'J3'가 아닌 사원들의 사번, 사원명, 직급코드, 퇴사여부 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, ENT_YN
FROM EMPLOYEE
WHERE JOB_CODE != 'J3';

--4. 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY >=3500000;

--급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

--입사일이 '90/01/01'이상 '01/01/01'이하인 사원들을 전체 조회
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

--사원들 중에 이름에 중간에 '하'라는 글자가 포함된 사원의 이름, 전화번호 출력
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_%하%_';

--사원들 중에서 전화번호 3번째자리가 1인 사원들의 사번, 사원명, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE SUBSTR(PHONE, 3, 1) = '1';

--부서코드가 D6이거나 D8이거나 D5인 부서원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6','D8','D5');

--이메일 중 _앞글자가 3글자인 사원들의 사번, 이름, 이메일 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE ('___/_%') ESCAPE '/';

--====================================실습============================================
--1. 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '__연';

--2. 전화번호 처음 3자리가 010이 아닌 사원들의 사원명, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE SUBSTR(PHONE, 1,3) != '010';

--3. 이름에 '하'가 포함되어있고 급여가 240만원 이상인 사원들의 사원명, 급여조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >=2400000;

--4. 부서테이블에서 해외영업부인 부서들의 부서코드, 부서명 조회
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '%해외영업%'; 

--5. 사수가 없고 부서배치도 받지 않은 사원들의 사원명, 사번, 부서코드 조회
SELECT EMP_NAME, EMP_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

--6. 연봉(급여 *12)이 3천만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE SALARY * 12 >= 30000000 AND BONUS IS NULL;

--7. 입사일이 '95/01/01'이상이고 부서배치를 받지 않은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE >= '95/01/01' AND DEPT_CODE IS NULL;

--8. 급여가 200만원 이상이고 500만원 이하인 사원 중에서 입사일이 '01/01/01' 이상이고 보너스를 받지 않은 
--   사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 5000000 AND HIRE_DATE >= '01/01/01' AND BONUS IS NULL;

--9. 보너스를 포함 연봉((SALARY + (SALARY * BONUS)) *12)이 NULL이 아니고 이름에 '하'가 포함된 사원들의 
--   사번, 사원명, 급여, 보너스포함연봉 조회
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY + (SALARY*BONUS)) * 12 AS 보너스포함연봉
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND BONUS IS NOT NULL;

--전체 사원들의 사번, 사원명, 부서코드, 부서명
--1. 연결할 두 컬럼명이 다른 경우(EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

--전체 사원들의 사번, 사원명, 부서코드, 부서명
--2. 연결할 두 컬럼명이 동일한 경우
--전체 사원들의 사번, 사원명, 직급코드, 직급명
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

--추가적인 조건제시
--직급이 대리인 사원의 사번, 사원명, 직급명, 급여조회
--1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = 'D1';

--2. DEPARTMENT와 LOCATION테이블을 참고하여 전체 부서의 부서코드, 부서명, 국가코드, 지역명 조회
SELECT DEPT_ID, DEPT_TITLE, NATIONAL_CODE, LOCAL_CODE
FROM DEPARTMENT
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE);

--3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE BONUS IS NOT NULL;

--4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE != '총무부';

--외부조인과 비교할만한 내부조인
-- 사원명, 부서명, 급여, 연봉
-- 부서배치를 받지않은 2명의 사원정보가 누락
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

--직원들의 모든 급여의 합을 구해라
SELECT SUM(SALARY)
FROM EMPLOYEE;
 
--남자사원들의 총 급여
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');

--부서코드가 D5인 부서 사람들의 총 연봉
SELECT SUM(SALARY * 12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';


--전체 사원 수
SELECT COUNT(*)
FROM EMPLOYEE;

--보너스를 받는 사원의 수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

--현재 사원들이 총 몇개의 부서에 분포되어 있는지를 구해라
SELECT  COUNT(DISTINCT(DEPT_CODE))
FROM EMPLOYEE;

--사번, 사원명, 주민등록번호, 성별
SELECT EMP_ID, EMP_NAME, EMP_NO, 
DECODE(SUBSTR(EMP_NO, 8, 1), '1','남','2','여','3','남','4','여') AS 성별
FROM EMPLOYEE;

--직원의 성명, 기존급여, 인상된 급여 조회(각 직급별로 차등인상)
-- J7 직급은 급여를 10%인상(SALARY * 1.1)
-- J6 직급은 급여를 15%인상(SALARY * 1.15)
-- J5 직급은 급여를 20%인상(SALARY * 1.2)
-- 그 외 직급은 급여를 5% 인상(SALARY * 1.05)
SELECT EMP_NAME, SALARY, 
       NVL(DECODE(JOB_CODE, 'J7', SALARY * 1.1,
              'J6' , SALARY * 1.15,
              'J5' , SALARY * 1.2), SALARY * 1.05) AS 인상된급여
FROM EMPLOYEE;              
              
--사원들의 이름, 입사날짜(0000년 00월 00일) 조회
--사원의 사원명, 입사년도, 입사월, 입사일 조회
--사원들 중 남자사원들만 EMP_NAME, EMP_NO를 조회
--사원들 중 여사원들만 EMP_NAME, EMP_NO를 조회

---------------------------2024-12-19------------------

--1. JOB 테이블의 모든 정보 조회
SELECT *
FROM JOB;

--2 JOB 테이블의 직급 이름 조회
SELECT JOB_NAME
FROM JOB;

--3. DEPARTMENT 테이블의 모든 정보 조회
SELECT *
FROM DEPARTMENT;

--4. EMPLOYEE테이블의 직원명, 이메일, 전화번호, 고용일 조회 
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE
FROM EMPLOYEE;

--5. EMPLOYEE테이블의 고용일, 사원 이름, 월급 조회 
SELECT HIRE_DATE, EMP_NAME, SALARY
FROM EMPLOYEE;

--6.EMPLOYEE테이블에서 이름, 연봉, 총수령액(보너스포함), 실수령액(총수령액 - (연봉*세금 3%)) 조회 
SELECT EMP_NAME, SALARY * 12 AS 연봉, (SALARY+(SALARY * NVL(BONUS,0))) * 12 AS 총수령액 , 
       (SALARY+(SALARY * NVL(BONUS,0))) * 12 - ((SALARY * 12) * 0.03) AS 실수령액
       FROM EMPLOYEE;
       
-- 7.EMPLOYEE테이블에서 SAL_LEVEL이 S1인 사원의 이름, 월급, 고용일, 연락처 조회    *********
SELECT EMP_NAME, SALARY, HIRE_DATE, PHONE
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL)
WHERE SAL_LEVEL = 'S1';

--8. EMPLOYEE테이블에서 실수령액(6번 참고)이 5천만원 이상인 사원의 이름, 월급, 실수령액, 고용일 조회
SELECT EMP_NAME, SALARY, (SALARY+(SALARY * BONUS)) * 12 - ((SALARY * 12) * 0.03) AS 실수령액 ,HIRE_DATE
FROM EMPLOYEE
WHERE (SALARY+(SALARY * BONUS)) * 12 - ((SALARY * 12) * 0.03) >= 50000000;

--9. EMPLOYEE테이블에 월급이 4000000이상이고 JOB_CODE가 J2인 사원의 전체 컬럼 조회 
SELECT *
FROM EMPLOYEE
WHERE SALARY >=4000000 AND JOB_CODE ='J2';

--10. EMPLOYEE테이블에 DEPT_CODE가 D9이거나 D5인 사원 중
--고용일이 02년 1월 1일보다 빠른 사원의 이름, 부서코드, 고용일 조회 
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D9','D5') AND HIRE_DATE < '02/01/01';

--11. EMPLOYEE테이블에 고용일이 90/01/01 ~ 01/01/01인 사원의 전체 내용을 조회
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

--12. EMPLOYEE테이블에서 이름 끝이 '연'으로 끝나는 사원의 이름 조회 
SELECT EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

--13. EMPLOYEE테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 조회 
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE SUBSTR(PHONE, 1, 3) != 010;

--14.  EMPLOYEE테이블에서 메일주소 '_'의 앞이 4자이면서 DEPT_CODE가 D9 또는 D6이고  
--고용일이 90/01/01 ~ 00/12/01이고, 급여가 270만 이상인 사원의 전체를 조회 
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____/_%' ESCAPE '/' AND DEPT_CODE='D9' OR DEPT_CODE = 'D6'
AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01' AND SALARY >= 2700000;
    

--15. EMPLOYEE테이블에서 사원 명과 직원의 주민번호를 이용하여 생년, 생월, 생일 조회 
SELECT EMP_NAME, 
SUBSTR(EMP_NO,1,2) AS 생년, 
SUBSTR(EMP_NO,3,2) AS 생월, 
SUBSTR(EMP_NO,5,2) AS 생일
FROM EMPLOYEE;

--701011-1234567
--16. EMPLOYEE테이블에서 사원명, 주민번호 조회 (단, 주민번호는 생년월일만 보이게 하고, 
-- '-'다음 값은 '*'로 바꾸기)  **********************
SELECT EMP_NAME, SUBSTR(EMP_NO,1,7) || '*******'
FROM EMPLOYEE;

--17. EMPLOYEE테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회 
--(단, 각 별칭은 근무일수1, 근무일수2가 되도록 하고 모두 정수(내림), 양수가 되도록 처리)
SELECT EMP_NAME, FLOOR(ABS(HIRE_DATE - SYSDATE)) AS 근무일수1 , FLOOR(SYSDATE - HIRE_dATE) AS 근무일수2
FROM EMPLOYEE;

--18 EMPLOYEE테이블에서 사번이 홀수인 직원들의 정보 모두 조회  --> 자동형변환 해줌
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID,2) != 0;

--19. EMPLOYEE테이블에서 근무 년수가 20년 이상인 직원 정보 조회 ********************
SELECT *
FROM EMPLOYEE
--WHERE ((SYSDATE - HIRE_DATE) / 365) >= 20;
--WHERE ADD_MONTHS(HIRE_DATE,240) < SYSDATE;
WHERE MONTHS_BETWEEN(SYSDATE,HIRE_DATE) > 240;

-- 20. EMPLOYEE 테이블에서 사원명, 급여 조회 (단, 급여는 '9,000,000' 형식으로 표시) *************
SELECT EMP_NAME, TO_CHAR(SALARY, '9,000,000')
FROM EMPLOYEE;

-- 21. EMPLOYEE테이블에서 직원 명, 부서코드, 생년월일, 나이(만) 조회  ****************
--(단, 생년월일은 주민번호에서 추출해서 00년 00월 00일로 출력되게 하며  
--나이는 주민번호에서 출력해서 날짜데이터로 변환한 다음 계산) 
SELECT EMP_NAME, DEPT_CODE, SUBSTR(EMP_NO,1,2) || '년' || SUBSTR(EMP_NO,3,2) || '월' || 
       SUBSTR(EMP_NO,4,2) || '일' AS 생년월일,
       EXTRACT(YEAR FROM SYSDATE) -
       CASE
       WHEN SUBSTR(EMP_NO,1,2) >= 50 THEN 1900 + SUBSTR(EMP_NO,1,2)
       ELSE 2000 + SUBSTR(EMP_NO,1,2)
       END AS 나이
--SUBSTR(EMP_NO,1,6), (SUBSTR(SYSDATE,1,2) + 100) - SUBSTR(EMP_NO,1,2)
FROM EMPLOYEE;

-- 22. EMPLOYEE테이블에서 부서코드가 D5, D6, D9인 사원만 조회하되 D5면 총무부, D6면 기획부, D9면 영업부로 처리 
--(단, 부서코드 오름차순으로 정렬) 
SELECT EMP_NAME, DECODE(DEPT_CODE,'D5','총무부','D6','총무부','D9','영업부')
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5' , 'D6', 'D9')
ORDER BY DEPT_CODE; 

-- 23. EMPLOYEE테이블에서 사번이 201번인 사원의 사원명, 주민번호 앞자리, 주민번호 뒷자리,  
--주민번호 앞자리와 뒷자리의 합 조회 
SELECT EMP_NAME, SUBSTR(EMP_NO,1,6) AS 주민번호앞자리 , SUBSTR(EMP_NO,8) AS 주민번호뒷자리, 
TO_NUMBER(SUBSTR(EMP_NO,1,6)) + TO_NUMBER(SUBSTR(EMP_NO,8))
FROM EMPLOYEE
WHERE EMP_ID = '201';

--24. EMPLOYEE테이블에서 부서코드가 D5인 직원의 보너스 포함 연봉 합 조회 
SELECT SUM((SALARY+(SALARY * NVL(BONUS,0))) * 12) AS 보너스포함연봉
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

--25. EMPLOYEE테이블에서 직원들의 입사일로부터 년도만 가지고 각 년도별 입사 인원수 조회 *************
--전체 직원 수, 2001년, 2002년, 2003년, 2004년
SELECT COUNT(*) AS "전체직원수" ,
COUNT(DECODE(EXTRACT(YEAR FROM HIRE_DATE), 2001,1,NULL)) AS "2001년",
COUNT(DECODE(EXTRACT(YEAR FROM HIRE_DATE), 2002,1,NULL)) AS "2002년",
COUNT(DECODE(EXTRACT(YEAR FROM HIRE_DATE), 2003,1,NULL)) AS "2003년",
COUNT(DECODE(EXTRACT(YEAR FROM HIRE_DATE), 2004,1,NULL)) AS "2004년"
FROM EMPLOYEE;

--1. 70년대 생(1970~1979) 중 여자이면서 전씨인 사원의 이름과 주민번호, 부서 명, 직급 조회
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE  SUBSTR(EMP_NO,1,2) BETWEEN 69 AND 80 AND 
SUBSTR(EMP_NO,8,1) IN ('2','4') AND EMP_NAME LIKE '전%';

--2. 이름에 ‘형’이 들어가는 사원의 사원 코드, 사원 명, 직급 조회  
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE EMP_NAME LIKE '%형%';

--3. 부서코드가 D5이거나 D6인 사원의 사원 명, 직급 명, 부서 코드, 부서 명 조회
SELECT EMP_NAME, JOB_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE DEPT_CODE IN ('D5','D6');

--4. 보너스를 받는 사원의 사원 명, 부서 명, 지역 명 조회
SELECT EMP_NAME, DEPT_TITLE , LOCAL_NAME
FROM EMPLOYEE 
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE BONUS IS NOT NULL;

--5. 사원 명, 직급 명, 부서 명, 지역 명 조회
SELECT EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE);

--6. 한국이나 일본에서 근무 중인 사원의 사원 명, 부서 명, 지역 명, 국가 명 조회
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME IN ('한국', '일본');

--7. 같은 부서에서 일하는 다른 사원의 이름을 조회하시오.
--단, 모든 사원이 자신의 부서에서 함께 일하는 다른 사원의 이름을 확인할 수 있어야 합니다.
--(예: 사원 A가 속한 부서에서 다른 사원 B의 이름을 조회)
SELECT E.EMP_NAME AS 부서원1 , E.DEPT_CODE, J.EMP_NAME AS 부서원2, J.DEPT_CODE
FROM EMPLOYEE E
JOIN EMPLOYEE J ON(E.DEPT_CODE = J.DEPT_CODE)
WHERE E.EMP_ID != J.EMP_ID
ORDER BY E.DEPT_CODE;
 
--8. 보너스가 없고 직급 코드가 J4이거나 J7인 사원의 이름, 직급 명, 급여 조회(NVL 이용)
SELECT EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE   
JOIN JOB USING(JOB_CODE)
WHERE NVL(BONUS,0) = 0 AND JOB_CODE IN('J4' , 'J7')
ORDER BY SALARY;

--9. 부서 명과 부서별 급여 합계 조회
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_CODE, DEPT_TITLE
ORDER BY SUM(SALARY);

--10. 부서 별 급여 합계가 전체 급여 총 합의 20%보다 많은 부서의 부서 명, 부서 별 급여 합계 조회
SELECT DEPT_TITLE, SUM(SALARY) 
FROM EMPLOYEE 
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY) * 0.2 FROM EMPLOYEE);



--11. 나이 상 가장 막내의 사원 코드, 사원 명, 나이, 부서 명, 직급 명 조회
SELECT EMP_ID, EMP_NAME,  
EXTRACT(YEAR FROM SYSDATE) -
CASE
WHEN SUBSTR(EMP_NO,1,2) >= 50 THEN 1900 + SUBSTR(EMP_NO,1,2 )
ELSE 2000 + SUBSTR(EMP_NO,1,2) 
END AS 나이 ,DEPT_TITLE, JOB_NAME

FROM EMPLOYEE

JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)

WHERE EXTRACT(YEAR FROM SYSDATE) -
CASE
WHEN SUBSTR(EMP_NO,1,2) >= 50 THEN 1900 + SUBSTR(EMP_NO,1,2 )
ELSE 2000 + SUBSTR(EMP_NO,1,2) 
END  = (SELECT(MIN(EXTRACT(YEAR FROM SYSDATE) -
       CASE
       WHEN SUBSTR(EMP_NO,1,2) >= 50 THEN 1900 + SUBSTR(EMP_NO,1,2)
       ELSE 2000 + SUBSTR(EMP_NO,1,2) 
       END)) FROM EMPLOYEE);
       
--------------------------------------------------------------------------       
SELECT *
FROM(SELECT EMP_ID, EMP_NAME, 
       FLOOR((SYSDATE - TO_DATE(SUBSTR(EMP_NO,1,6), 'RR/MM/DD'))/365) AS "나이"
       , DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
ORDER BY 나이)
WHERE ROWNUM =1;







