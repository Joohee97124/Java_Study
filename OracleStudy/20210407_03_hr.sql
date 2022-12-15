SELECT USER
FROM DUAL;
--==>> HR


--�� EMPLOYEES ���̺��� ������ SALARY �� 10% �λ��Ѵ�.
--   ��, �μ����� 'IT' �� ���� �����Ѵ�.
--  (����� ����� Ȯ�� �� ROLLBACK)
SELECT*
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

UPDATE (SELECT*
        FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
        ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
        )
SET SALARY = 1.1 * SALARY
WHERE DEPARTMENT_NAME = 'IT';
--==>> 5�� �� ��(��) ������Ʈ�Ǿ����ϴ�.

------------------------------------[������Ǯ��]--------------------------------
SELECT FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID, SALARY*1.1
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (DEPARTMENTS ���̺��� IT�μ��� �μ�ID);

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

-- Ȯ��
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
--==>> �ѹ� �Ϸ�.


--�� EMPLOYEES ���̺��� JOB_TITLE �� Sales Manager �� �������
--   SALARY �� �ش� ����(����) �� �ְ� �޿�(MAX_SALARY)�� �����Ѵ�
--   ��, �Ի����� 2006�� ����(�ش� �⵵ ����) �Ի��ڿ� ���Ͽ�
--   ������ �� �ֵ��� ó���Ѵ�.
--   (������ �ۼ��Ͽ� ��� Ȯ�� �� ROLLBACK)
-- ���1)
SELECT *
FROM EMPLOYEES E LEFT JOIN JOBS J
ON E.JOB_ID = J.JOB_ID;

UPDATE (SELECT *
         FROM EMPLOYEES E LEFT JOIN JOBS J
         ON E.JOB_ID = J.JOB_ID)
SET SALARY = MAX_SALARY
WHERE JOB_TITLE = 'Sales Manager';

-- ���2)
UPDATE EMPLOYEES
SET SALARY = (Sales Manager �� MAX_SALARY)
WHERE JOB_ID = (Sales Manager �� JOB_ID)
      TO_NUMBER(TO_CHAR(HIRE_DATE,'YYYY')) < 2006;
      
-- (Sales Manager �� MAX_SALARY)
SELECT MAX_SALARY
FROM JOBS
WHERE JOB_TITLE = 'Sales Manager';
--==>> 20080

-- (Sales Manager �� JOB_ID)
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

                
-- Ȯ��
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

-- �ѹ�
ROLLBACK;
--==>> �ѹ� �Ϸ�.



--�� EMPLOYEES ���̺��� SALARY ��
--   �� �μ��� �̸����� �ٸ� �λ���� �����Ͽ� ������ �� �ֵ��� �Ѵ�.
--   Finance �� 10%
--   Executive �� 15%
--   Accounting �� 20%
--   ������ �� 0%
--  (������ �ۼ��Ͽ� ��� Ȯ�� �� ROLLBACK)  
SELECT *
FROM DEPARTMENTS;

SELECT *
FROM EMPLOYEES;

-- ���1) CASE + WHERE(X)
UPDATE EMPLOYEES 
SET SALARY = CASE DEPARTMENT_ID WHEN ('Finance'�� �μ����̵�)
                                THEN SALARY * 1.1
                                WHEN ('Executive'�� �μ����̵�)
                                THEN SALARY * 1.15
                                WHEN ('Accounting'�� �μ����̵�)
                                THEN SALARY * 1.2
                                
                                ELSE SALARY
             END ;

-- ('Finance'�� �μ����̵�)
SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'Finance';
--==>> 100

-- ('Executive'�� �μ����̵�)
SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'Executive';
--==>> 90

-- ('Accounting'�� �μ����̵�)
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


-- ���2) DECODE
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

-- ���3) CASE + WHERE(O)
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
--==>> 11�� ����(��) ������Ʈ �Ǿ����ϴ�.

-- �ѹ�
ROLLBACK;




--���� DELETE ����--

-- 1. ���̺��� ������ ��(���ڵ�)�� �����ϴµ� ����ϴ� ����.

-- 2. ���� �� ����
-- DELETE [FROM] ���̺��
-- [WHERE ������];

SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID=198;

DELETE
FROM EMPLOYEES
WHERE EMPLOYEE_ID=198;
--==>> 1 �� ��(��) �����Ǿ����ϴ�.

ROLLBACK;
--==>> �ѹ� �Ϸ�.



--�� EMPLOYEES ���̺��� �������� ������ �����Ѵ�.
--   ��, �μ����� 'IT' �� ���� �����Ѵ�.

--�� �����δ� EMPLOYEES ���̺��� �����Ͱ� (�����ϰ��� �ϴ� ���)
--   �ٸ� ���̺� (Ȥ�� �ڱ� �ڽ� ���̺�) �� ���� �������ϰ� �ִ� ���
--   �������� ���� �� �ִٴ� ����� �����ؾ� �ϸ�...
--   �׿� ���� ������ �˾ƾ� �Ѵ�.
SELECT*
FROM EMPLOYEES
WHERE DEPARTMENT_ID = ('IT'�� �μ���ȣ);

-- ('IT'�� �μ���ȣ);
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
--==>> ���� �߻�
/*
ORA-02292: integrity constraint (HR.DEPT_MGR_FK) violated - child record found
>> �����Ǿ��ִ� ������ �־ ������ �� ���ٴ� �ǹ�
*/

SELECT *
FROM EMPLOYEES;



--���� ��(VIEW) ����--

-- 1. ��(VIEW)�� �̹� Ư���� �����ͺ��̽� ���� �����ϴ�
--    �ϳ� �̻��� ���̺��� ����ڰ� ��� ���ϴ� �����͵鸸��
--    ��Ȯ�ϰ� ���ϰ� �������� ���Ͽ� ������ ���ϴ� �÷��鸸 ��Ƽ�
--    �������� ������ ���̺�� ���Ǽ� �� ���ȿ� ������ �ִ�.

--    ������ ���̺��̶� �䰡 ������ �����ϴ� ���̺�(��ü)�� �ƴ϶�
--    �ϳ� �̻��� ���̺��� �Ļ��� �� �ٸ� ������ �� �� �ִ� ����̸�
--    �� ������ �����س��� SQL �����̶�� �� �� �ִ�.

-- 2. ���� �� ����
-- CREATE [OR REPLACE] VIEW ���̸�
-- [(ALIAS[, ALIAS, ...])]
-- AS
-- ��������(SUBQUERY)
-- [WITH CHECK OPTION]      �ɼ�Ȯ��
-- [WITH READ ONLY];        �б����� 


--�� �� ����
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
--==>> View VIEW_EMPLOYEES��(��) �����Ǿ����ϴ�.


--�� ��(VIEW) ��ȸ
SELECT *
FROM VIEW_EMPLOYEES;

--�� ��(VIEW) ���� Ȯ�� (DESC�� ����� �ȴ�)
DESC VIEW_EMPLOYEES;
--==>>
/*
�̸�              ��?       ����           
--------------- -------- ------------ 
FIRST_NAME               VARCHAR2(20) 
LAST_NAME       NOT NULL VARCHAR2(25) 
DEPARTMENT_NAME          VARCHAR2(30) 
CITY                     VARCHAR2(30) 
COUNTRY_NAME             VARCHAR2(40) 
REGION_NAME              VARCHAR2(25)
*/

--�� ��(VIEW) �ҽ� Ȯ��                   -- CHECK~!!!
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


















