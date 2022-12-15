SELECT USER
FROM DUAL;
--==>> SCOTT

--�� ���̺� ���� (TBL_EXAMPLE1)
CREATE TABLE TBL_EXAMPLE1
( NO    NUMBER
, NAME  VARCHAR2(10)
, ADDR  VARCHAR2(20)
);
--==>> Table TBL_EXAMPLE1��(��) �����Ǿ����ϴ�.

--�� ���̺� ���� (TBL_EXAMPLE2)
CREATE TABLE TBL_EXAMPLE2
( NO    NUMBER
, NAME  VARCHAR2(10)
, ADDR  VARCHAR(20)
) TABLESPACE TBS_EDUA;
--==>> Table TBL_EXAMPLE2��(��) �����Ǿ����ϴ�.
-- TBS_EDUA��� ���̺����̽��� ����ž߶�� �ǹ�

--�� TBS_EXAMPLE1 �� TBL_EXAMPLE2 ���̺���
--   � ���̺����̽��� ����Ǿ� �ִ��� ��ȸ
SELECT TABLE_NAME, TABLESPACE_NAME
FROM USER_TABLES;
--==>>
/*
DEPT	        USERS
EMP	            USERS
BONUS	        USERS
SALGRADE	    USERS
TBL_EXAMPLE1	USERS
TBL_EXAMPLE2	TBS_EDUA
*/

--------------------------------------------------------------------------------

--���� ������ �����ͺ��̽� ����--

-- �����͸� ���̺��� ���·� ������� ���� ��.
-- �׸��� �̵� �� ���̺�� ���� ���踦 �����ϴ� ��.

/*=================================
�� SELECT ���� ó�� (PARSING) ���� ��

    SELECT �÷���   --��
    FROM ���̺��   --��
    WHERE ������    --��
    GROUP BY ��     --��
    HAVING ��       --��
    ORDER BY ��     --��

==================================*/


--�� ���� ���ӵ� ����Ŭ ����� (SCOTT) ������
--   ���̺� (TABLE), �� (VIEW) �� ����� ��ȸ
SELECT *
FROM TAB;
--==>>
/*
BONUS	        TABLE	�� ���ʽ� ���� ���̺�
DEPT	        TABLE	�� DEPARTMENTS (�μ�) ���� ���̺�
EMP	            TABLE	�� EMPLOYESS (���) ���� ���̺�
SALGRADE	    TABLE	�� �޿� (SAL) ���� ���̺�
TBL_EXAMPLE1	TABLE	
TBL_EXAMPLE2	TABLE	
*/


--�� �� ���̺��� ������ ��ȸ
SELECT *
FROM BONUS;
--==>> ENAME, JOB, SAL, COMM�� �÷��� �ְ� �����ʹ� ����
--==>> ������ �������� ����

SELECT *
FROM DEPT;
--==>>
/*
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	    CHICAGO
40	OPERATIONS	BOSTON
*/

SELECT *
FROM EMP;
--==>>
/*
7369	SMITH	CLERK	    7902	80/12/17	800		20
7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	    30
7521	WARD	SALESMAN	7698	81/02/22	1250	500	    30
7566	JONES	MANAGER	    7839	81/04/02	2975		    20
7654	MARTIN	SALESMAN	7698	81/09/28	1250	1400    30
7698	BLAKE	MANAGER	    7839	81/05/01	2850	  	    30
7782	CLARK	MANAGER 	7839	81/06/09	2450		    10
7788	SCOTT	ANALYST	    7566	87/07/13	3000		    20
7839	KING	PRESIDENT		    81/11/17	5000		    10
7844	TURNER	SALESMAN	7698	81/09/08	1500	  0	    30
7876	ADAMS	CLERK	    7788	87/07/13	1100		    20
7900	JAMES	CLERK	    7698	81/12/03	950	    	    30
7902	FORD	ANALYST	    7566	81/12/03	3000		    20
7934	MILLER	CLERK	    7782	82/01/23	1300		    10
*/

SELECT *
FROM SALGRADE;
--==>> 
/*
1	700	    1200
2	1201	1400
3	1401	2000
4	2001	3000
5	3001	9999
*/

--�� DEPT ���̺� �����ϴ� �÷��� ����(����) ��ȸ
DESCRIBE DEPT;
--==>>
/*
�̸�     ��?       ����           
------ -------- ------------ 
DEPTNO NOT NULL NUMBER(2)    
DNAME           VARCHAR2(14) 
LOC             VARCHAR2(13)
*/

--�� �츮�� ���� ������Ʈ ��� ȸ�� ������ ������ ���
--   �ʼ� �Է� ���װ� ���� �Է»����� �ִ�.
--   �ʼ� �Է� �׸��� ID, PW, ����, �ֹι�ȣ, ��ȭ��ȣ...
--   ��� ���� �÷��̸�, �� ������ ȸ������ ������ ����
--   �ݵ�� �ʿ��� (�����ؾ��ϴ�) ���̹Ƿ� NOT NULL �� �Ѵ�.

--   ���� �׸��� ���, ��ȥ����, ������������, Ư��...
--   ��� ���� �÷��̸�, �� ������ ȸ������ ��������
--   �ݵ�� �ʿ��� ���� �ƴϹǷ� (��, �Է����� �ʾƵ� �����ϹǷ�)
--   NULL �̾ ������� ��Ȳ�� �ȴ�.

--   DEPTNO     DNAME       LOC
--   �μ���ȣ   �μ���      �μ���ġ
--   NOT NULL   NULL ���   NULL ���

--Ex)            �λ��     ����         �� ������ �Է� �Ұ�
--     80                   ��õ         �� ������ �Է� ����
--     90                                �� ������ �Է� ����



--���� ����Ŭ�� �ֿ� �ڷ��� (DATA TYPE) ����-- 
/*
cf) MS-SQL ������ ���� ǥ�� Ÿ��
    tintint     0 ~ 255                1Byte
    smallint    -32,768 ~ 32,767       2Byte
    int         -21�� ~ 21��           4Byte
    bigint      ��ûŭ                 8Byte
    
    MS-SQL ������ �Ǽ� ǥ�� Ÿ��
    float, real
    
    MS-SQL ������ ���� ǥ�� Ÿ��
    decimal, numeric
    
    MS-SQL ������ ���� ǥ�� Ÿ��
    char, varchar, Nvarchar
*/

--�� ORACLE ������ ���� ǥ�� Ÿ���� �� ������ ���ϵǾ� �ִ�.
/*
1. ������ NUMBER       �� -10�� 38�� -1 ~ 10�� 38��
          NUMBER(2)    �� -99 ~ 99
          NUMBER(3)    �� -999 ~ 999
          NUMBER(4)    �� -9999 ~ 9999
          NUMBER(4,1)  �� -999.9 ~ 999.9             (4�ڸ� �߿� 1�ڸ��� �Ǽ� ����)
*/


--�� ORACLE ������ ���� ǥ�� Ÿ��
--   CHAR, NCHAR, VARCHAR2, NVARCHAR2
/* 
2. ������ CHAR          - ������ ũ��
    ��)   CHAR(10)      - ������         10Byte �Ҹ�
          CHAR(10) �� '���ǽ�'          6Byte ������ 10Byte �� �Ҹ�
          CHAR(10) �� '����ڹ���'      10Byte �Ҹ�
          CHAR(10) �� 'OH����ڹ���'    10Byte �� �ʰ��ϹǷ� �Է� �Ұ�
    
          VARCHAR2      - ������ ũ��
          VARCHAR(10) �� '���ǽ�'          6Byte �Ҹ�
          VARCHAR(10) �� '����ڹ���'      10Byte �Ҹ�
          VARCHAR(10) �� 'OH����ڹ���'    10Byte �� �ʰ��ϹǷ� �Է� �Ұ�
          
          NCHAR         - �����ڵ� ��� ������ ũ��
          NCHAR(10)     - 10 ���� (10Byte X) 
          
          NVARCHAR2     - �����ڵ� ��� ������ ũ��
          NVARCHAR2(10) - 10 ����

3. ��¥�� DATE
*/

SELECT SYSDATE
FROM DUAL;
--==>> 21/03/25

--�� ��¥ ���Ŀ� ���� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYY-MM-DD HH24:MI:SS';
--==>> Session��(��) ����Ǿ����ϴ�.

SELECT SYSDATE
FROM DUAL;
--==>> 021-03-25 11:35:54



--�� EMP ���̺��� �����ȣ, �����, �޿�, Ŀ�̼� ������ ��ȸ
SELECT *
FROM EMP;
-- EMP ��ü�� ����ϰ� ������ �÷� �̸� ã�� ����

SELECT  �����ȣ, �����, �޿�, Ŀ�̼�
FROM EMP;

SELECT EMPNO, ENAME, SAL, COMM
FROM EMP;
--==>>
/*
7369	SMITH	800	
7499	ALLEN	1600	300
7521	WARD	1250	500
7566	JONES	2975	
7654	MARTIN	1250	1400
7698	BLAKE	2850	
7782	CLARK	2450	
7788	SCOTT	3000	
7839	KING	5000	
7844	TURNER	1500	0
7876	ADAMS	1100	
7900	JAMES	950	
7902	FORD	3000	
7934	MILLER	1300	
*/


--�� EMP ���̺��� �μ���ȣ�� 20���� �������� ���� ��
--   �����ȣ, �����, ������, �޿�, �μ���ȣ ��ȸ
SELECT *
FROM EMP;

SELECT �����ȣ, �����, ������, �޿�, �μ���ȣ
FROM EMP
WHERE �μ���ȣ�� 20��;

SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO�� 20��;

SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO=20;
--==>>
/*
7369	SMITH	CLERK	800	    20
7566	JONES	MANAGER	2975	20
7788	SCOTT	ANALYST	3000	20
7876	ADAMS	CLERK	1100	20
7902	FORD	ANALYST	3000	20
*/


--�� EMP ���̺��� �÷� ���� Ȯ��
DESCRIBE EMP;
--==>>
/*
�̸�       ��?       ����           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2)   
*/

SELECT *
FROM EMP;


--�� ���̺��� ��ȸ�ϴ� �������� �� �÷��� ��Ī(ALIAS)�� �ο��� �� �ִ�.
SELECT EMPNO AS "�����ȣ", ENAME "�����", JOB ����, SAL "�� ��", DEPTNO"�μ���ȣ"
FROM EMP
WHERE DEPTNO=20;

--�� ���̺� ��ȸ �� ����ϴ� ��Ī(ALIAS) �� �⺻ ������
--   �� AS "��Ī��"�� �� ���·� �ۼ��Ǹ�
--   �� ��,�� AS�� �� ���� �����ϴ�.
--   ����, ��""�� �� ���� �����ϴ�.
--   ������,��""�� �� ������ ��� ��Ī�� ������ ����� �� ����.
--   ������ �ش� �÷��� ������ �ǹ��ϹǷ� ��Ī�� �̸� ���ο� ������ ����� ���
--   ��""�� �� ����Ͽ� ��Ī�� �ο��� �� �ֵ��� ó���ؾ� �Ѵ�.


--�� EMP ���̺��� �μ���ȣ�� 20���� 30�� �������� ���� ��
--   �����ȣ, �����, ������, �޿�, �μ���ȣ �׸��� ��ȸ�Ѵ�.
--   ��, ��Ī(ALIAS)�� ����Ѵ�.
SELECT EMPNO AS "�����ȣ", ENAME AS "�����", JOB AS "����", SAL AS "�޿�", DEPTNO AS "�μ���ȣ"
FROM EMP
WHERE DEPTNO=20 OR DEPTNO=30;
--==>>
/*
7369	SMITH	CLERK	    800	    20
7499	ALLEN	SALESMAN	1600	30
7521	WARD	SALESMAN	1250	30
7566	JONES	MANAGER	    2975	20
7654	MARTIN	SALESMAN	1250	30
7698	BLAKE	MANAGER	    2850	30
7788	SCOTT	ANALYST	    3000	20
7844	TURNER	SALESMAN	1500	30
7876	ADAMS	CLERK	    1100	20
7900	JAMES	CLERK	    950 	30
7902	FORD	ANALYST	    3000	20
*/

SELECT EMPNO AS "�����ȣ", ENAME AS "�����", JOB AS "����", SAL AS "�޿�", DEPTNO AS "�μ���ȣ"
FROM EMP
WHERE DEPTNO IN (20,30);
--> IN �����ڸ� Ȱ���Ͽ� �̿� ���� ó���� �� ������
--  ������ ó���� ������ ���� ����� ��ȯ�ϰ� �ȴ�.



--�� EMP ���̺��� ������ CLERK �� ������� ������ ��� ��ȸ�Ѵ�.
SELECT ��� ��ȸ
FROM EMP
WHERE ������ CLERK �� ���;

SELECT *
FROM EMP
WHERE JOB='CLERK';
--==>>
/*
7369	SMITH	CLERK	7902	980-12-17 00:00:00	800		20
7876	ADAMS	CLERK	7788	987-07-13 00:00:00	1100	20
7900	JAMES	CLERK	7698	981-12-03 00:00:00	950		30
7934	MILLER	CLERK	7782	982-01-23 00:00:00	1300	10
*/

select *
from EMP
Where Job='CLERK';
-- ��

SELECT *
FROM EMP
WHERE JOB='clerk';
-- X

SELECT *
FROM EMP
WHERE JOB='ClERK';
-- X

--�� ����Ŭ����... �Էµ� ������(��) ��ŭ��
--   ��.��.�� �롤�ҹ��� ������ �Ѵ�.
-- �������� ��ҹ��� ���X, ���� ��ҹ��� �߿�!


--�� EMP ���̺��� ������ CLERK �� ����� ��
--   20�� �μ��� �ٹ��ϴ� �������
--   �����ȣ, �����, ������, �޿�, �μ���ȣ �׸��� ��ȸ�Ѵ�.
SELECT EMPNO "�����ȣ", ENAME "�����", JOB AS "����", SAL AS "�޿�", DEPTNO AS "�μ���ȣ"
FROM EMP
WHERE JOB='CLERK' AND DEPTNO=20;
--==>>
/*
7369	SMITH	CLERK	800	    20
7876	ADAMS	CLERK	1100	20
*/


--�� EMP ���̺��� 10�� �μ��� �ٹ��ϴ� ������ ��
--   �޿��� 2500 �̻��� �������
--   �����, ������, �޿�, �μ���ȣ �׸��� ��ȸ�Ѵ�.
SELECT ENAME "�����", JOB "����", SAL "�޿�", DEPTNO "�μ���ȣ"
FROM EMP
WHERE DEPTNO = 10 AND SAL >= 2500;
--==>> 
/*
KING	PRESIDENT	5000	10
*/



--�� ���̺� ����
--> ���������� ��� ���̺� �ȿ� �ִ� ������ ���븸 �����ϴ� ����

--�� EMP ���̺��� ������ Ȯ���Ͽ� 
--   �̿� �Ȱ��� �����Ͱ� ����ִ� EMPCOPY ���̺��� �����Ѵ�. (������...)


DESCRIBE EMP;
DESC EMP;
--==>>
/*
�̸�       ��?       ����           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2)
*/

CREATE TABLE EMPCOPY1
( EMPNO NUMBER(4)
, ENAME VARCHAR2(10)
, JOB   VARCHAR(9)
, MGR   NUMBER(4)
, HIREDATE  DATE
, SAL   NUMBER(7,2)
, COMM  NUMBER(7,2)
, DEPTNO    NUMBER(2)
);
--==>> Table EMPCOPY1��(��) �����Ǿ����ϴ�.

SELECT*
FROM EMPCOPY1;
--==>> �����Ͱ� �ϳ��� ����

INSERT INTO EMPCOPY1 VALUES(... ... ... );
--==>> �̷��� �����͸� �־����

CREATE TABLE TBL_EMP
AS
SELECT *
FROM EMP;
--==>> Table TBL_EMP��(��) �����Ǿ����ϴ�.
--     EMP ���̺��ϰ� �Ȱ��� ������ּ��� (=TBL_EMP)

--�� ������ ���̺� Ȯ��
SELECT*
FROM TBL_EMP;


--�� ��¥ ���� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
--==>> Session��(��) ����Ǿ����ϴ�.


--�� ���̺� ����
CREATE TABLE TBL_DEPT
AS
SELECT *
FROM DEPT;
--==>> Table TBL_DEPT��(��) �����Ǿ����ϴ�.


--�� ������ ���̺� Ȯ��
SELECT*
FROM TBL_EMP;
SELECT*
FROM TBL_DEPT;
--==>>
/*
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON
*/


--�� ���̺��� Ŀ��Ʈ ���� Ȯ��
SELECT *
FROM USER_TAB_COMMENTS;
--==>>
/*
SALGRADE	    TABLE	
TBL_EXAMPLE1	TABLE	
EMP	            TABLE	
TBL_EXAMPLE2	TABLE	
BONUS	        TABLE	
EMPCOPY1    	TABLE	
TBL_DEPT    	TABLE	
TBL_EMP     	TABLE	
*/  


--�� ���̺��� Ŀ��Ʈ ���� �Է� (TBL_EMP �� ���������)
COMMENT ON TABLE TBL_EMP IS '���������';
--==>> Comment��(��) �����Ǿ����ϴ�.

--�� Ŀ��Ʈ ���� �Է� ���� �ٽ� Ȯ��
SELECT *
FROM USER_TAB_COMMENTS;
--==>>
/*
TBL_DEPT	        TABLE	
TBL_EMP	            TABLE	���������
EMPCOPY1	        TABLE	
TBL_EXAMPLE2	    TABLE	
TBL_EXAMPLE1	    TABLE	
SALGRADE	        TABLE	
BONUS	            TABLE	
EMP	                TABLE	
DEPT	            TABLE	
*/


--�� ���̺� ������ Ŀ��Ʈ ���� �Է� (TBL_DEPT �� �μ�������)
COMMENT ON TABLE TBL_DEPT IS '�μ�������';
--==>> Comment��(��) �����Ǿ����ϴ�.

--�� Ŀ��Ʈ ���� �Է� ���� �ٽ� Ȯ��
SELECT *
FROM USER_TAB_COMMENTS;
--==>>
/*
TBL_DEPT	    TABLE	�μ�������
TBL_EMP 	    TABLE	���������
EMPCOPY1	    TABLE	
TBL_EXAMPLE2	TABLE	
TBL_EXAMPLE1	TABLE	
SALGRADE	    TABLE	
BONUS	        TABLE	
EMP         	TABLE	
DEPT	        TABLE	
*/



--�� �÷� ������ Ŀ��Ʈ ���� Ȯ��
SELECT *
FROM USER_COL_COMMENTS;
--==>>
/*
TBL_EXAMPLE1	NO	
DEPT	        DNAME	
SALGRADE	    HISAL	
EMP	            HIREDATE	
EMPCOPY1	    DEPTNO	
TBL_EXAMPLE2	NAME	
EMP         	MGR	
TBL_EXAMPLE1	NAME	
TBL_EMP     	EMPNO	
EMP	            COMM	
BONUS	        SAL	
TBL_DEPT	    DEPTNO	
EMP	            JOB	
TBL_DEPT	    DNAME	
TBL_EXAMPLE2	NO	
EMP	            ENAME	
TBL_EMP	        COMM	
TBL_DEPT	    LOC	
EMPCOPY1	    COMM	
BONUS	        COMM	
TBL_EXAMPLE2	ADDR	
EMPCOPY1	    JOB	
DEPT	        DEPTNO	
TBL_EXAMPLE1	ADDR	
EMPCOPY1    	EMPNO	
EMP     	    SAL	
TBL_EMP	        JOB	
TBL_EMP 	    SAL	
EMP	            EMPNO	
SALGRADE	    LOSAL	
BONUS	        ENAME	
TBL_EMP 	    DEPTNO	
BONUS	        JOB	
EMP	            DEPTNO	
TBL_EMP 	    MGR	
TBL_EMP	        ENAME	
EMPCOPY1	    HIREDATE	
DEPT	        LOC	
TBL_EMP	        HIREDATE	
EMPCOPY1	    ENAME	
EMPCOPY1	    MGR	
SALGRADE	    GRADE	
EMPCOPY1	    SAL	
*/
--> SCOTT �� ���� ���� ���̺�� �� �÷��� COMMENTS ���� �� ����


SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME = 'TBL_DEPT';
--=>>
/*
TBL_DEPT	DEPTNO	
TBL_DEPT	DNAME	
TBL_DEPT	LOC	
*/
--> TBL_DEPT�� �÷� COMMENTS Ȯ��


--�� ���̺� �Ҽӵ�(���Ե�) �÷� ������ Ŀ��Ʈ ���� �Է�(����)
COMMENT ON COLUMN TBL_DEPT.DEPTNO IS '�μ���ȣ';
--==>> Comment��(��) �����Ǿ����ϴ�.
--> (DEPT���̺��� DEPTNO) �÷��� COMMENT ������ ����ϰڴ�

COMMENT ON COLUMN TBL_DEPT.DNAME IS '�μ���';
--==>> Comment��(��) �����Ǿ����ϴ�.

COMMENT ON COLUMN TBL_DEPT.LOC IS '�μ���ġ';
--==>> Comment��(��) �����Ǿ����ϴ�.

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME = 'TBL_DEPT';
--==>> 
/*
TBL_DEPT	DEPTNO	�μ���ȣ
TBL_DEPT	DNAME	�μ���
TBL_DEPT	LOC	    �μ���ġ
*/


DESC TBL_EMP;

--�� TBL_EMP ���̺� �Ҽӵ�(���Ե�)
--   �÷��� ���� Ŀ��Ʈ ������ �Է�(����)�Ѵ�.
COMMENT ON COLUMN TBL_EMP.EMPNO IS '�����ȣ';
COMMENT ON COLUMN TBL_EMP.ENAME IS '�����';
COMMENT ON COLUMN TBL_EMP.JOB IS '������';
COMMENT ON COLUMN TBL_EMP.MGR IS '�����ڻ����ȣ';
COMMENT ON COLUMN TBL_EMP.HIREDATE IS '�Ի���';
COMMENT ON COLUMN TBL_EMP.SAL IS '�޿�';
COMMENT ON COLUMN TBL_EMP.COMM IS '����';
COMMENT ON COLUMN TBL_EMP.DEPTNO IS '�μ���ȣ';
--==>> Comment��(��) �����Ǿ����ϴ�. * 8

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME = 'TBL_EMP';
--==>>
/*
TBL_EMP	EMPNO	    �����ȣ
TBL_EMP	ENAME	    �����
TBL_EMP	JOB	        ������
TBL_EMP	MGR	        �����ڻ����ȣ
TBL_EMP	HIREDATE	�Ի���
TBL_EMP	SAL	        �޿�
TBL_EMP	COMM	    ����
TBL_EMP	DEPTNO	    �μ���ȣ
*/



--���� �÷� ������ �߰� �� ���� ����--
SELECT *
FROM TBL_EMP;

--�� TBL_EMP ���̺� �ֹε�Ϲ�ȣ ������ ���� �� �ִ� �÷� �߰�
ALTER TABLE TBL_EMP 
ADD SSN CHAR(13);
--==> Table TBL_EMP��(��) ����Ǿ����ϴ�.
-- ADD �÷��̸� ����������

--�� �� �տ� 0�� ���� ���ɼ��� �ִ� ���ڰ� ���յ� �����Ͷ��
--   �������� �ƴ� ���������� ������Ÿ���� ó���ؾ� �Ѵ� ~!!!
SELECT 0012123
FROM DUAL;
--==>> 12123

SELECT '0012123'
FROM DUAL;
--==>> 0012123


--�� Ȯ��
SELECT *
FROM TBL_EMP;


DESC TBL_EMP;
--==>> SSN �÷��� ���������� �߰��� ��Ȳ���� Ȯ��
 
SELECT EMPNO, ENAME, SSN, JOB
FROM TBL_EMP;
--> ���̺� ������ �÷��� ������ ���������� �ǹ� ����


--�� TBL_EMP ���̺��� �߰��� SSN (�ֹε�Ϲ�ȣ) �÷� ����
ALTER TABLE TBL_EMP
DROP COLUMN SSN; 
--==>> Table TBL_EMP��(��) ����Ǿ����ϴ�.


-- �� Ȯ��
SELECT*
FROM TBL_EMP;

DESC TBL_EMP;
-->> SSN (�ֹε�Ϲ�ȣ) Į���� ���������� ���ŵǾ����� Ȯ��

SELECT *
FROM TBL_EMP
WHERE EMPNO=7369;
--==>> SMITH
--> 7369�� 

DELETE TBL_EMP
WHERE EMPNO=7369;
--==>> 1 �� ��(��) �����Ǿ����ϴ�

SELECT *
FROM TBL_EMP;


SELECT *
FROM TBL_EMP
WHERE EMPNO = 7654;
--==>> 7654	MARTIN	SALESMAN	7698	1981-09-28	1250	1400	30

DELETE TBL_EMP
WHERE EMPNO = 7654;
--==>> 1 �� ��(��) �����Ǿ����ϴ�.


DELETE 
FROM TBL_EMP
WHERE DEPTNO=20;
--==>> 4�� �� ��(��) �����Ǿ����ϴ�.


DELETE TBL_EMP      -- �������� ����

DELETE
FROM TBL_EMP;       -- ����


--�� Ȯ��
SELECT *
FROM TBL_EMP;
--==>> ��ȸ ��� ����
--> ���̺��� ������ �״�� �����ִ� ���¿���
--  ������ ��� �ҽ� (����) �� ��Ȳ���� Ȯ��


--�� ���̺��� ���������� ����
DROP TABLE TBL_EMP;
--==>> Table TBL_EMP��(��) �����Ǿ����ϴ�.

--�� Ȯ��
SELECT *
FROM TBL_EMP;
--==>> ���� �߻�
/*
ORA-00942: table or view does not exist
00942. 00000 -  "table or view does not exist"
*Cause:    
*Action:
745��, 6������ ���� �߻�
*/

--�� ���̺� �ٽ� ���� (����)
CREATE TABLE TBL_EMP
AS
SELECT *
FROM EMP;
--==>> Table TBL_EMP��(��) �����Ǿ����ϴ�.

-------------------------------------------------------------------------------

--���� NULL�� ó�� ����--

SELECT 2, 10+2, 10-2, 10*2, 10/2
FROM DUAL;
--==> 2	12	8	20	5

SELECT NULL, NULL+2, NULL-2, NULL*2, NULL/2, 10+NULL, 10-NULL, 10*NULL, 10/NULL
FROM DUAL;
--==>> (null) (null) (null) (null) (null) (null) (null) (null) (null)

--�� ���� ���
--   NULL �� ������ ���� �ǹ��ϸ�, ���� �������� �ʴ� ���̱� ������
--   �̷��� NULL �� ���꿡 ���Ե� ���... �� ����� ������ NULL �̴�.


--�� TBL_EMP ���̺��� Ŀ�̼�(COMM, ����)�� NULL �� ������
--   �����, ������, �޿�, Ŀ�̼� �׸��� ��ȸ�Ѵ�.
SELECT *
FROM TBL_EMP;

SELECT ENAME "�����", JOB "������", SAL "�޿�", COMM "����"
FROM TBL_EMP
WHERE COMM = NULL;
--==>> ��ȸ ��� ����

SELECT ENAME "�����", JOB "������", SAL "�޿�", COMM "����"
FROM TBL_EMP
WHERE COMM = (null);
--==>> ��ȸ ��� ���� (���� ������ ����)

SELECT ENAME "�����", JOB "������", SAL "�޿�", COMM "����"
FROM TBL_EMP
WHERE COMM = 'NULL';
--==>> ���� �߻�

DESC TBL_EMP;
--==>>
/*
:
COMM        NUMBER(7,2) 
:
*/
--> COMM �÷��� ������ ������ Ÿ���� ���ϰ� ������ Ȯ��
--> �����������Ϳ� ���ڿ��� �־ �߻��� ����

--�� NULL �� ���� �������� �ʴ� ���̱� ������ �Ϲ����� �����ڸ� Ȱ���Ͽ� ���� �� ����.
--   ��, ������� �� ������ ������ �� ���ٴ� �ǹ��̴�.
--   NULL �� ������� ����� �� ���� �����ڵ�...
--   >=, <=, >, <, =, !=, ^=, <>


SELECT ENAME "�����", JOB "������", SAL "�޿�", COMM "����"
FROM TBL_EMP
WHERE COMM IS NULL;
--==>>
/*
SMITH	CLERK	     800	(null)
JONES	MANAGER 	2975	(null)
BLAKE	MANAGER 	2850	(null)
CLARK	MANAGER	    2450	(null)
SCOTT	ANALYST 	3000	(null)
KING	PRESIDENT	5000	(null)
ADAMS	CLERK	    1100	(null)
JAMES	CLERK	     950	(null)
FORD	ANALYST	    3000	(null)
MILLER	CLERK	    1300	(null)
*/


--�� TBL_EMP ���̺��� 20�� �μ��� �ٹ����� �ʴ� ��������
--   �����, ������, �μ���ȣ �׸��� ��ȸ�Ѵ�.
SELECT ENAME "�����", JOB "������", DEPTNO "�μ���ȣ"
FROM TBL_EMP
WHERE DEPTNO != 20;

SELECT ENAME "�����", JOB "������", DEPTNO "�μ���ȣ"
FROM TBL_EMP
WHERE DEPTNO ^= 20;

SELECT ENAME "�����", JOB "������", DEPTNO "�μ���ȣ"
FROM TBL_EMP
WHERE DEPTNO <> 20;
--==>>
/*
ALLEN	SALESMAN	30
WARD	SALESMAN	30
MARTIN	SALESMAN	30
BLAKE	MANAGER 	30
CLARK	MANAGER	    10
KING	PRESIDENT	10
TURNER	SALESMAN	30
JAMES	CLERK	    30
MILLER	CLERK	    10
*/


--�� TBL_EMP ���̺��� Ŀ�̼��� NULL�� �ƴ� �������� 
--   �����, ������, �޿�, Ŀ�̼� �׸��� ��ȸ�Ѵ�.
SELECT ENAME "�����", JOB "������", SAL "�޿�", COMM "Ŀ�̼�"
FROM TBL_EMP
WHERE COMM IS NOT NULL;

SELECT ENAME "�����", JOB "������", SAL "�޿�", COMM "Ŀ�̼�"
FROM TBL_EMP
WHERE NOT COMM IS NULL;
--==>>
/*
ALLEN	SALESMAN	1600	300
WARD	SALESMAN	1250	500
MARTIN	SALESMAN	1250	1400
TURNER	SALESMAN	1500	0
*/


--�� TBL_EMP ���̺��� ��� ������� -> WHERE �Ⱦ� 
--   �����, �����ȣ, �޿�, Ŀ�̼�, ���� �׸��� ��ȸ�Ѵ�.
--   ��, �޿�(SAL) �� �ſ� �����Ѵ�.
--   ����, ����(COMM) �� �ų� �����Ѵ�.

SELECT *
FROM TBL_EMP;

SELECT ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", SAL*12+COMM "����"
FROM TBL_EMP;

--�� NVL()
SELECT NULL "��", NVL(NULL,10) "��", NVL(10,20) "��"
FROM DUAL;
--==>> (null)	10	10
--> ù ��° �Ķ���� ���� NULL �̸�, �� ��° �Ķ���� ���� ��ȯ�Ѵ�.
--  ù ���� �Ķ���� ���� NULL�� �ƴϸ�, �� �� (ù ���� �Ķ����) �� �״�� ��ȯ�Ѵ�.

SELECT COMM "��", NVL(COMM, 0) "��"
FROM TBL_EMP
WHERE EMPNO=7369;
--==>> (null)	0

SELECT ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", SAL*12 + NVL(COMM,0) "����"
FROM TBL_EMP;
--==>>
/*
SMITH	800		9600
ALLEN	1600	300	    19500
WARD	1250	500	    15500
JONES	2975		    35700
MARTIN	1250	1400	16400
BLAKE	2850		    34200
CLARK	2450		    29400
SCOTT	3000		    36000
KING	5000		    60000
TURNER	1500	0	    18000
ADAMS	1100		    13200
JAMES	950		        11400
FORD	3000	    	36000
*/

--�� NVL2()                       ____
--> ù ��° �Ķ���� ���� NULL �� �ƴ� ���, �� ��° �Ķ���� ���� ��ȯ�ϰ�,
--  ù ���� �Ķ���� ���� NULL �� ���, �� ��° �Ķ���� ���� ��ȯ�Ѵ�.
SELECT ENAME, COMM, NVL2(COMM, 'û��÷�', '���÷�') "Ȯ��"
FROM TBL_EMP;

SELECT ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", SAL*12 + NVL2(COMM, SAL*12+COMM, SAL*12 ) "����"
FROM TBL_EMP;
--==>>
/*
SMITH	800		9600
ALLEN	1600	300	    19500
WARD	1250	500	    15500
JONES	2975		    35700
MARTIN	1250	1400	16400
BLAKE	2850		    34200
CLARK	2450		    29400
SCOTT	3000		    36000
KING	5000		    60000
TURNER	1500	0	    18000
ADAMS	1100		    13200
JAMES	950		        11400
FORD	3000	    	36000
*/


--�� COALESCE()
-->  �Ű����� ������ ���� ���·� �����ϰ� Ȱ���Ѵ�.
--   �� �տ� �ִ� �Ű��������� ���ʷ� NULL���� �ƴ��� Ȯ���Ͽ�
--   NULL �� �ƴ� ��� ����(��ȯ, ó��) �ϰ�
--   NULL �� ��쿡�� �� ���� �Ű����� ������ ���� (��ȯ, ó��) �Ѵ�.
--   NVL() �̳� NVL2() �� ���Ͽ�... ��~~�� ����� ���� ����� �� �մ� Ư¡�� ���� �ִ�.

SELECT NULL "�⺻Ȯ��"
    , COALESCE(NULL, NULL, NULL, 30) "�Լ� Ȯ��1"
    , COALESCE(NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100) "�Լ� Ȯ��2"
    , COALESCE(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100) "�Լ� Ȯ��3"
    , COALESCE(NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100) "�Լ� Ȯ��4"
FROM DUAL;


--�� �ǽ��� ���� ������ �Է�
INSERT INTO TBL_EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO)
VALUES(8000, '���ִ�', 'SALESMAN', 7839, SYSDATE, 10);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

INSERT INTO TBL_EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, COMM, DEPTNO)
VALUES(8001, '������', 'SALESMAN', 7839, SYSDATE, 100, 10);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� Ȯ��
SELECT *
FROM TBL_EMP;


--�� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.

--
SELECT ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", SAL*12 + NVL(COMM,0) "����"
FROM TBL_EMP;

SELECT ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", SAL*12 + NVL2(COMM, SAL*12+COMM, SAL*12 ) "����"
FROM TBL_EMP;


SELECT ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", COALESCE ( (SAL*12+COMM), (SAL*12), COMM, 0 ) "����"
FROM TBL_EMP;
--==>>
/*
SMITH	800		9600
ALLEN	1600	300	    19500
WARD	1250	500	    15500
JONES	2975		    35700
MARTIN	1250	1400	16400
BLAKE	2850		    34200
CLARK	2450		    29400
SCOTT	3000		    36000
KING	5000		    60000
TURNER	1500	0	    18000
ADAMS	1100		    13200
JAMES	950		        11400
FORD	3000		    36000
MILLER	1300		    15600
���ִ�			0
������		    100 	100
*/





















