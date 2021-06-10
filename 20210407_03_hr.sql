SELECT USER
FROM DUAL;
--==>> HR


--○ EMPLOYEES 테이블의 직원들 SALARY 를 10% 인상한다.
--   단, 부서명이 'IT' 인 경우로 한정한다.
--  (변경된 결과를 확인 후 ROLLBACK)
SELECT*
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

UPDATE (SELECT*
        FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
        ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
        )
SET SALARY = 1.1 * SALARY
WHERE DEPARTMENT_NAME = 'IT';
--==>> 5개 행 이(가) 업데이트되었습니다.

------------------------------------[선생님풀이]--------------------------------
SELECT FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID, SALARY*1.1
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (DEPARTMENTS 테이블에서 IT부서의 부서ID);

SELECT FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID, SALARY*1.1
FROM EMPLOYEES
WHERE DEPARTMENT_ID = ( SELECT DEPARTMENT_ID
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME = 'IT');
--UPDATE
UPDATE EMPLOYEES
SET SALARY = SALARY*1.1
WHERE DEPARTMENT_ID = ( SELECT DEPARTMENT_ID
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME = 'IT');

-- 확인
SELECT *
FROM EMPLOYEES;
--==>>
/*
Alexander	Hunold  	9900	60
Bruce	    Ernst	    6600	60
David	    Austin	    5280	60
Valli	    Pataballa	5280	60
Diana	    Lorentz 	4620	60
*/

ROLLBACK;
--==>> 롤백 완료.


--○ EMPLOYEES 테이블에서 JOB_TITLE 이 Sales Manager 인 사원들의
--   SALARY 를 해당 직무(직종) 의 최고 급여(MAX_SALARY)로 수정한다
--   단, 입사일이 2006년 이전(해당 년도 제외) 입사자에 한하여
--   적용할 수 있도록 처리한다.
--   (쿼리문 작성하여 결과 확인 후 ROLLBACK)
-- 방법1)
SELECT *
FROM EMPLOYEES E LEFT JOIN JOBS J
ON E.JOB_ID = J.JOB_ID;

UPDATE (SELECT *
         FROM EMPLOYEES E LEFT JOIN JOBS J
         ON E.JOB_ID = J.JOB_ID)
SET SALARY = MAX_SALARY
WHERE JOB_TITLE = 'Sales Manager';

-- 방법2)
UPDATE EMPLOYEES
SET SALARY = (Sales Manager 의 MAX_SALARY)
WHERE JOB_ID = (Sales Manager 의 JOB_ID)
      TO_NUMBER(TO_CHAR(HIRE_DATE,'YYYY')) < 2006;
      
-- (Sales Manager 의 MAX_SALARY)
SELECT MAX_SALARY
FROM JOBS
WHERE JOB_TITLE = 'Sales Manager';
--==>> 20080

-- (Sales Manager 의 JOB_ID)
SELECT JOB_ID
FROM JOBS
WHERE JOB_TITLE = 'Sales Manager';
--==>> SA_MAN

UPDATE EMPLOYEES
SET SALARY = (SELECT MAX_SALARY
              FROM JOBS
              WHERE JOB_TITLE = 'Sales Manager')
WHERE JOB_ID = (SELECT JOB_ID
                FROM JOBS
                WHERE JOB_TITLE = 'Sales Manager')
     AND TO_NUMBER(TO_CHAR(HIRE_DATE,'YYYY')) < 2006;

                
-- 확인
SELECT *
FROM EMPLOYEES;

SELECT *
FROM JOBS;

SELECT *
FROM EMPLOYEES
WHERE JOB_ID = (SELECT JOB_ID
                FROM JOBS
                WHERE JOB_TITLE = 'Sales Manager'
                )
    AND TO_NUMBER(TO_CHAR(HIRE_DATE,'YYYY')) < 2006;

-- 롤백
ROLLBACK;
--==>> 롤백 완료.



--○ EMPLOYEES 테이블에서 SALARY 를
--   각 부서의 이름별로 다른 인상률을 적용하여 수정할 수 있도록 한다.
--   Finance → 10%
--   Executive → 15%
--   Accounting → 20%
--   나머지 → 0%
--  (쿼리문 작성하여 결과 확인 후 ROLLBACK)  
SELECT *
FROM DEPARTMENTS;

SELECT *
FROM EMPLOYEES;

-- 방법1) CASE + WHERE(X)
UPDATE EMPLOYEES 
SET SALARY = CASE DEPARTMENT_ID WHEN ('Finance'의 부서아이디)
                                THEN SALARY * 1.1
                                WHEN ('Executive'의 부서아이디)
                                THEN SALARY * 1.15
                                WHEN ('Accounting'의 부서아이디)
                                THEN SALARY * 1.2
                                
                                ELSE SALARY
             END ;

-- ('Finance'의 부서아이디)
SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'Finance';
--==>> 100

-- ('Executive'의 부서아이디)
SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'Executive';
--==>> 90

-- ('Accounting'의 부서아이디)
SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'Accounting';
--==>> 110

UPDATE EMPLOYEES
SET SALARY = (
        CASE WHEN DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                                   FROM DEPARTMENTS
                                   WHERE DEPARTMENT_NAME = 'Finance') 
             THEN 1.1*SALARY
             
             WHEN DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                                   FROM DEPARTMENTS
                                   WHERE DEPARTMENT_NAME = 'Executive') 
             THEN 1.15*SALARY
             
             WHEN DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                                   FROM DEPARTMENTS
                                   WHERE DEPARTMENT_NAME = 'Accounting') 
            THEN 1.2*SALARY
            
            ELSE SALARY
        END
            );


-- 방법2) DECODE
UPDATE EMPLOYEES
SET SALARY = (
        DECODE(DEPARTMENT_ID, (SELECT DEPARTMENT_ID
                               FROM DEPARTMENTS
                               WHERE DEPARTMENT_NAME = 'Finance'), 1.1*SALARY
                            ,(SELECT DEPARTMENT_ID
                              FROM DEPARTMENTS
                              WHERE DEPARTMENT_NAME = 'Executive') , 1.15*SALARY
                            , (SELECT DEPARTMENT_ID
                               FROM DEPARTMENTS
                               WHERE DEPARTMENT_NAME = 'Accounting') , 1.2*SALARY
                            , SALARY)
              );

-- 방법3) CASE + WHERE(O)
UPDATE EMPLOYEES
SET SALARY = (
        CASE WHEN DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                                   FROM DEPARTMENTS
                                   WHERE DEPARTMENT_NAME = 'Finance') 
             THEN 1.1*SALARY
             
             WHEN DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                                   FROM DEPARTMENTS
                                   WHERE DEPARTMENT_NAME = 'Executive') 
             THEN 1.15*SALARY
             
             WHEN DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                                   FROM DEPARTMENTS
                                   WHERE DEPARTMENT_NAME = 'Accounting') 
            THEN 1.2*SALARY
            
            ELSE SALARY
        END
            )
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME IN ('Finance', 'Executive', 'Accounting'));
--==>> 11개 행이(가) 업데이트 되었습니다.

-- 롤백
ROLLBACK;




--■■■ DELETE ■■■--

-- 1. 테이블에서 지정된 행(레코드)을 삭제하는데 사용하는 구문.

-- 2. 형식 및 구조
-- DELETE [FROM] 테이블명
-- [WHERE 조건절];

SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID=198;

DELETE
FROM EMPLOYEES
WHERE EMPLOYEE_ID=198;
--==>> 1 행 이(가) 삭제되었습니다.

ROLLBACK;
--==>> 롤백 완료.



--○ EMPLOYEES 테이블에서 직원들의 정보를 삭제한다.
--   단, 부서명이 'IT' 인 경우로 한정한다.

--※ 실제로는 EMPLOYEES 테이블의 데이터가 (삭제하고자 하는 대상)
--   다른 테이블 (혹은 자기 자신 테이블) 에 의해 참조당하고 있는 경우
--   삭제되지 않을 수 있다는 사실을 염두해야 하며...
--   그에 대한 이유도 알아야 한다.
SELECT*
FROM EMPLOYEES
WHERE DEPARTMENT_ID = ('IT'의 부서번호);

-- ('IT'의 부서번호);
SELECT DEPARTMENT_ID 
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'IT'

SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = ( SELECT DEPARTMENT_ID 
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME = 'IT');

DELETE
FROM EMPLOYEES
WHERE DEPARTMENT_ID = ( SELECT DEPARTMENT_ID 
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME = 'IT');
--==>> 에러 발생
/*
ORA-02292: integrity constraint (HR.DEPT_MGR_FK) violated - child record found
>> 참조되어있는 곳들이 있어서 제거할 수 없다는 의미
*/

SELECT *
FROM EMPLOYEES;



--■■■ 뷰(VIEW) ■■■--

-- 1. 뷰(VIEW)란 이미 특정한 데이터베이스 내에 존재하는
--    하나 이상의 테이블에서 사용자가 얻기 원하는 데이터들만을
--    정확하고 편하게 가져오기 위하여 사전에 원하는 컬럼들만 모아서
--    만들어놓은 가상의 테이블로 편의성 및 보안에 목적이 있다.

--    가상의 테이블이란 뷰가 실제로 존재하는 테이블(객체)이 아니라
--    하나 이상의 테이블에서 파생된 또 다른 정보를 볼 수 있는 방법이며
--    그 정보를 추출해내는 SQL 문장이라고 볼 수 있다.

-- 2. 형식 및 구조
-- CREATE [OR REPLACE] VIEW 뷰이름
-- [(ALIAS[, ALIAS, ...])]
-- AS
-- 서브쿼리(SUBQUERY)
-- [WITH CHECK OPTION]      옵션확인
-- [WITH READ ONLY];        읽기전용 


--○ 뷰 생성
CREATE OR REPLACE VIEW VIEW_EMPLOYEES
AS
SELECT E.FIRST_NAME, E.LAST_NAME
     , D.DEPARTMENT_NAME, L.CITY
     , C.COUNTRY_NAME, R.REGION_NAME
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
  AND D.LOCATION_ID = L.LOCATION_ID(+)
  AND L.COUNTRY_ID = C.COUNTRY_ID(+)
  AND C.REGION_ID = R.REGION_ID(+);
--==>> View VIEW_EMPLOYEES이(가) 생성되었습니다.


--○ 뷰(VIEW) 조회
SELECT *
FROM VIEW_EMPLOYEES;

--○ 뷰(VIEW) 구조 확인 (DESC의 대상이 된다)
DESC VIEW_EMPLOYEES;
--==>>
/*
이름              널?       유형           
--------------- -------- ------------ 
FIRST_NAME               VARCHAR2(20) 
LAST_NAME       NOT NULL VARCHAR2(25) 
DEPARTMENT_NAME          VARCHAR2(30) 
CITY                     VARCHAR2(30) 
COUNTRY_NAME             VARCHAR2(40) 
REGION_NAME              VARCHAR2(25)
*/

--○ 뷰(VIEW) 소스 확인                   -- CHECK~!!!
SELECT VIEW_NAME, TEXT                   -- TEXT
FROM USER_VIEWS                          -- USER_VIEWS
WHERE VIEW_NAME = 'VIEW_EMPLOYEES';
--==>>
/*
"SELECT E.FIRST_NAME, E.LAST_NAME
     , D.DEPARTMENT_NAME, L.CITY
     , C.COUNTRY_NAME, R.REGION_NAME
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
  AND D.LOCATION_ID = L.LOCATION_ID(+)
  AND L.COUNTRY_ID = C.COUNTRY_ID(+)
  AND C.REGION_ID = R.REGION_ID(+)"
*/


















