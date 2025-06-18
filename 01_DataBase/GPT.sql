### 서브쿼리 관련 문제  

#### **1. 단일행 서브쿼리 문제**  
- **문제 1-1:**  
  `EMPLOYEE` 테이블에서 가장 높은 급여를 받는 사원의 이름과 급여를 조회하는 SQL문을 작성하세요.  
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE);

- **문제 1-2:**  
  `EMPLOYEE` 테이블에서 평균 급여보다 낮은 급여를 받는 사원들의 이름과 급여를 조회하세요.  
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEE);

#### **2. 다중행 서브쿼리 문제**  
- **문제 2-1:**  
  `EMPLOYEE` 테이블에서 "김철수" 또는 "박영희"와 같은 직급을 가진 사원들의 사번, 이름, 직급 코드를 조회하는 SQL문을 작성하세요. 
  SELECT EMP_ID, EMP_NAME, JOB_CODE
  FROM EMPLOYEE
  WHERE JOB_CODE = (SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '김철수' OR EMP_NAME = '박영희');

- **문제 2-2:**  
  `EMPLOYEE` 테이블에서 "과장" 직급의 사원들 중 최소 급여보다 높은 급여를 받는 "대리" 직급 사원들의 이름과 급여를 조회하세요. 
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME ='대리' AND SALARY > (SELECT MIN(SALARY) FROM EMPLOYEE 
                                    JOIN JOB USING(JOB_CODE) WHERE JOB_NAME = '과장');

#### **3. 다중열 서브쿼리 문제**  
- **문제 3-1:**  
  `EMPLOYEE` 테이블에서 "이지은" 사원과 같은 부서, 같은 직급에 속한 사원들의 이름, 부서 코드, 직급 코드를 조회하는 SQL문을 작성하세요.  
  단, "이지은" 본인은 제외합니다.  
  SELECT EMP_NAME, DEPT_CODE, JOB_CODE
  FROM EMPLOYEE
  WHERE ;

#### **4. 다중행 다중열 서브쿼리 문제**  
- **문제 4-1:**  
  각 직급별 최소 급여를 받는 사원의 사번, 이름, 직급 코드, 급여를 조회하는 SQL문을 작성하세요.  
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE , MIN(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE);

- **문제 4-2:**  
  각 부서별 급여 합계가 전체 급여 총합의 25% 이상인 부서의 부서명과 급여 합계를 조회하세요.  

#### **5. 응용 문제**  
- **문제 5-1:**  
  "홍길동" 사원의 급여보다 높은 급여를 받는 사원들의 이름, 부서명, 급여를 조회하세요.  
  단, 부서명은 `DEPARTMENT` 테이블에서 조회해야 합니다.  

- **문제 5-2:**  
  `EMPLOYEE` 테이블에서 각 부서별 가장 높은 급여를 받는 사원의 이름과 급여를 조회하는 SQL문을 작성하세요.  

---  
서브쿼리에 대한 연습 문제를 100개 만드는 것은 매우 광범위하고 시간이 많이 소요되는 작업입니다. 대신, 다양한 유형의 서브쿼리를 연습할 수 있는 20개의 문제를 제공하겠습니다. 이 문제들은 단일행, 다중행, 다중열, 그리고 다중행 다중열 서브쿼리를 포함하고 있습니다.

## 단일행 서브쿼리

1. 평균 급여보다 많이 받는 사원들의 이름과 급여를 조회하세요. 

2. 가장 오래 근무한 사원의 입사일과 이름을 조회하세요.

3. '김'씨 성을 가진 사원 중 가장 높은 급여를 받는 사원의 이름과 급여를 조회하세요.

4. 직급별 평균 급여 중 가장 높은 평균 급여를 받는 직급코드와 평균 급여를 조회하세요.

5. 부서별 사원 수가 가장 많은 부서의 부서코드와 사원 수를 조회하세요.

    
## 다중행 서브쿼리

6. 급여가 3000000 이상인 사원들과 같은 부서에서 근무하는 사원들의 이름과 급여, 부서코드를 조회하세요.

7. 서울에서 근무하는 사원들의 직급과 같은 직급을 가진 사원들의 이름과 직급, 부서명을 조회하세요.


8. 관리자인 사원들의 부서와 같은 부서에 속한 사원들의 이름과 부서명, 관리자 사번을 조회하세요.

9. 부서별 평균 급여보다 많이 받는 사원들의 이름, 급여, 부서코드를 조회하세요.



10. 직급별 최소 급여를 받는 사원들의 이름, 직급코드, 급여를 조회하세요.
SELECT EMP_NAME, JOB_CODE, SALARY AS 최소급여
FROM EMPLOYEE  
WHERE (JOB_CODE,SALARY) IN 
(SELECT JOB_CODE,MIN(SALARY) 
 FROM EMPLOYEE 
 GROUP BY JOB_CODE);
                  

## 다중열 서브쿼리

11. '이'씨 성을 가진 사원과 같은 부서, 같은 직급에 해당하는 사원들의 이름, 부서코드, 직급코드를 조회하세요.
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN 
(SELECT DEPT_CODE, JOB_CODE 
 FROM EMPLOYEE 
 WHERE SUBSTR(EMP_NAME, 1, 1) = '이');

12. 부서별 최고 급여를 받는 사원들의 이름, 부서코드, 급여를 조회하세요.
SELECT EMP_NAME, DEPT_CODE, SALARY AS최고급여
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN 
(SELECT DEPT_CODE, MAX(SALARY) 
FROM EMPLOYEE 
GROUP BY DEPT_CODE)
ORDER BY DEPT_CODE;


13. 직급별 최저 급여를 받는 사원들의 이름, 직급코드, 급여, 입사일을 조회하세요.
SELECT EMP_NAME, JOB_CODE, SALARY AS 최저급여, HIRE_DATE
FROM EMPLOYEE
WHERE (JOB_CODE,SALARY) IN 
(SELECT JOB_CODE, MIN(SALARY)
 FROM EMPLOYEE
 GROUP BY JOB_CODE)
 ORDER BY JOB_CODE;
 
14. 각 부서별로 가장 최근에 입사한 사원의 이름, 부서코드, 입사일을 조회하세요.
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, HIRE_DATE) IN 
(SELECT DEPT_CODE, MAX(HIRE_DATE) 
FROM EMPLOYEE 
GROUP BY DEPT_CODE);

15. 급여와 보너스를 합친 금액이 가장 많은 사원의 이름, 급여, 보너스를 조회하세요.
SELECT EMP_NAME, SALARY , NVL(BONUS,0)
FROM EMPLOYEE
WHERE SALARY+(SALARY * NVL(BONUS,0)) IN (SELECT MAX(SALARY+(SALARY * NVL(BONUS,0))) FROM EMPLOYEE);

## 다중행 다중열 서브쿼리

16. 각 직급별 평균 급여를 받는 사원들의 이름, 직급코드, 급여를 조회하세요.
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE (JOB_CODE,SALARY) IN (SELECT JOB_CODE, AVG(SALARY) 
                 FROM EMPLOYEE 
                 GROUP BY JOB_CODE);
17. 각 부서별로 가장 높은 급여와 가장 낮은 급여를 받는 사원들의 이름, 부서코드, 급여를 조회하세요.
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY) 
                              FROM EMPLOYEE 
                              GROUP BY DEPT_CODE) 
                              OR
                             (DEPT_CODE, SALARY) IN
                             (SELECT DEPT_CODE, MIN(SALARY) 
                              FROM EMPLOYEE 
                              GROUP BY DEPT_CODE);

18. 입사년도별 평균 급여보다 많이 받는 사원들의 이름, 입사일, 급여를 조회하세요.
SELECT EMP_NAME, ROUND(EXTRACT(YEAR FROM HIRE_DATE)), SALARY
FROM EMPLOYEE E
WHERE SALARY > (SELECT ROUND(AVG(SALARY))
                    FROM EMPLOYEE
                    GROUP BY EXTRACT(YEAR FROM HIRE_DATE))
                    AND
                    (SELECT ROUND(EXTRACT(YEAR FROM HIRE_DATE)) 
                     FROM EMPLOYEE J
                     WHERE E.ROUND(EXTRACT(YEAR FROM HIRE_DATE)) = J.ROUND(EXTRACT(YEAR FROM HIRE_DATE)));
                     

19. 각 부서별로 가장 오래 근무한 사원의 이름, 부서코드, 입사일을 조회하세요.
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE,HIRE_DATE) IN 
(SELECT DEPT_CODE, MIN(HIRE_DATE) 
FROM EMPLOYEE 
GROUP BY DEPT_CODE)
ORDER BY DEPT_CODE;

20. 직급별, 부서별 평균 급여보다 많이 받는 사원들의 이름, 직급코드, 부서코드, 급여를 조회하세요.
SELECT E.EMP_NAME, E.JOB_CODE, E.DEPT_CODE, E.SALARY
FROM EMPLOYEE E
JOIN EMPLOYEE 

이 데이터베이스 구조와 내용을 바탕으로 다음과 같은 문제를 만들어볼 수 있습니다:

---

### 1. **DEPARTMENT 테이블 관련 문제**
1. `DEPARTMENT` 테이블의 모든 데이터를 조회하는 SQL문을 작성하세요.
2. `LOCATION_ID`가 `L1`인 부서의 `DEPT_TITLE`을 조회하는 SQL문을 작성하세요.
3. `DEPARTMENT` 테이블에 `DEPT_ID`가 `D10`, `DEPT_TITLE`이 `신규개발부`, `LOCATION_ID`가 `L6`인 데이터를 삽입하는 SQL문을 작성하세요.

---

### 2. **EMPLOYEE 테이블 관련 문제**
1. `EMPLOYEE` 테이블의 모든 데이터를 조회하는 SQL문을 작성하세요.
2. `SALARY`가 3,000,000 이상인 직원들의 `EMP_NAME`과 `SALARY`를 조회하는 SQL문을 작성하세요.
3. `DEPT_CODE`가 `D5`이고 `BONUS`가 없는 직원의 `EMP_NAME`과 `SALARY`를 조회하는 SQL문을 작성하세요.
4. 신규 직원으로 `EMP_ID: 223, EMP_NAME: 이성재, EMP_NO: 930515-1234567, EMAIL: lee_sj@C##SERVER.or.kr, PHONE: 01098765432, DEPT_CODE: D7, JOB_CODE: J5, SALARY: 4500000, BONUS: 0.2`를 추가하는 SQL문을 작성하세요.

---

### 3. **JOIN 문제**
1. `EMPLOYEE`와 `DEPARTMENT` 테이블을 조인하여, 직원의 이름(`EMP_NAME`), 부서명(`DEPT_TITLE`), 급여(`SALARY`)를 조회하는 SQL문을 작성하세요.
SELECT EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
2. `DEPARTMENT`의 `LOCATION_ID`가 `L1`인 부서에 소속된 모든 직원의 이름과 부서명을 조회하는 SQL문을 작성하세요.
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCAL_CODE = LOCATION_ID)
WHERE LOCAL_CODE = 'L1';
---

### 4. **데이터 수정 및 삭제 문제**
1. `EMPLOYEE` 테이블에서 `EMP_ID`가 `215`인 직원의 `SALARY`를 4,000,000으로 업데이트하는 SQL문을 작성하세요.
2. `EMPLOYEE` 테이블에서 `EMP_ID`가 `218`인 데이터를 삭제하는 SQL문을 작성하세요.

---

### 5. **제약조건 문제**
1. `EMPLOYEE` 테이블의 `EMP_ID`는 어떤 제약조건을 가지고 있나요? SQL문을 통해 확인하세요.
2. `DEPARTMENT` 테이블의 `DEPT_ID`에 대해 설정된 제약조건을 설명하고, 이를 조회하는 SQL문을 작성하세요.

---

### 6. **복합 문제**
1. `EMPLOYEE` 테이블에서 퇴직 여부(`ENT_YN`)가 `Y`인 직원들의 이름과 퇴직일(`ENT_DATE`)을 조회하는 SQL문을 작성하세요.
2. `SALARY`의 평균값과 총합을 계산하는 SQL문을 작성하세요.

---

1. 초급: 특정 부서의 평균 급여보다 높은 직원 조회
문제:
EMPLOYEE 테이블에서 'D1' 부서의 평균 급여보다 높은 급여를 받는 직원의 이름과 급여를 조회하시오.


. 중급: 특정 지역에 있는 부서의 직원 정보 조회
문제:
DEPARTMENT 테이블에서 'L1' 지역에 위치한 부서에 소속된 직원의 이름과 부서명을 조회하시오.

3. 중급: 가장 높은 급여를 받는 직원 정보 조회
문제:
EMPLOYEE 테이블에서 가장 높은 급여를 받는 직원의 이름, 급여, 부서명을 조회하시오.

4. 고급: 부서별 급여 합계와 평균 보너스를 계산하여 특정 조건 조회
문제:
각 부서의 급여 합계가 10,000,000 이상인 부서의 이름과 해당 부서의 평균 보너스를 조회하시오.
단, 보너스 값이 NULL일 경우 0으로 계산하시오.

5. 고급: 퇴사자 수가 가장 많은 부서 조회
문제:
EMPLOYEE 테이블에서 퇴사 여부(ENT_YN)가 'Y'인 직원 수가 가장 많은 부서의 이름과 퇴사자 수를 조회하시오.

6. 고급: 중첩된 서브쿼리를 사용한 특정 부서 제외 직원 조회
문제:
EMPLOYEE 테이블에서 'D3' 부서의 직원과 동일한 직급을 가진 직원 중 'D3' 부서를 제외한 직원의 이름, 부서명, 직급을 조회하시오.

