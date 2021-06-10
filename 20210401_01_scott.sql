SELECT USER
FROM DUAL;
--==>> SCOTT

--���� JOIN (����) ����--

-- 1. SQL 1992 CODE
-- CROSS JOIN
SELECT *
FROM EMP, DEPT;
--> ���п��� ���ϴ� ��ī��Ʈ ��(Catersian Product)
-- �� ���̺��� ��ģ (������) ��� ����� ��

--Equi join : ���� ��Ȯ�� ��ġ�ϴ� �����͵鳢�� �����Ű�� ����
SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

SELECT *
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

-- Non Equi join : ���� �ȿ� ������ �����͵鳢�� �����Ű�� ����
SELECT *
FROM SALGRADE;

SELECT *
FROM EMP;
-->> ���̽� �޿� 800 > 1���

SELECT *
FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;
-->> E���̺��� �޿��� S���̺��� LOSAL HISAL ���̿� 


--Equi join �� ��+�� �� Ȱ���� ���� ���
SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO = D.DEPTNO; 
--> �� 14���� �����Ͱ� ���յǾ� ��ȸ�� ��Ȳ
-- ��, �μ���ȣ�� ���� ���� �����(5��) �� ��� ����~!!!

SELECT *
FROM TBL_EMP;
-->> �츮�� 5�� �߰��ؼ� 19���̾��� ,, 
-->> �μ���ȣ�� ���� 5���� ���տ��� ������

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO = D.DEPTNO(+); 
--> �� 19���� �����Ͱ� ���յǾ� ��ȸ�� ��Ȳ
-- ��, �μ���ȣ�� ���� ���� �����(5��)�� ��� ��ȸ�� ��Ȳ~!!!

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO;
-->> �� 16���� �����Ͱ� ���յǾ� ��ȸ�� ��Ȳ
-- ��, �μ��� �Ҽӵ� ����� �ƹ��� ���� �μ��� ��� ��ȸ�� ��Ȳ~!!! (���ߺ�, OPERATIONS)

--�� (+)�� ���� �� ���̺��� �����͸� ��� �޸𸮿� ������ ��
--   (+)�� �ִ� �� ���̺��� �����͸� �ϳ��ϳ� Ȯ���Ͽ� ���ս�Ű�� ���·�
--   JOIN �� �̷������.

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO(+);
--> ���� ���� ������ �̷��� ������ JOIN ������ �������� �ʴ´�


-- 1. SQL 1999 CODE �� ��JOIN�� Ű���� ���� �� JOIN ���� ���
--                     ���� ������ ��WHERE�� ��� ��ON��

-- CROSS JOIN
SELECT *
FROM EMP CROSS JOIN DEPT;

-- INNER JOIN 
SELECT *
FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO; 
--> Equi join�� ���� ����� ó���� �ȴ� (���ٴ� �ǹ� X)

--�� INNER JOIN �� INNER �� ���� ����
SELECT *
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM EMP E JOIN SALGRADE S
ON E.SAL BETWEEN S.LOSAL AND S.HISAL;
--> Equi + UNEqui ���� ��� INNER JOIN ���� ����

-- OUTER JOIN
--> (+) �ٿ����� �°� OUTER JOIN�� ��
SELECT *
FROM TBL_EMP E LEFT OUTER JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO;

--�� ������ ������ �� ���̺� (��LEFT) �� �����͸� ��� �޸𸮿� ������ ��
--   ������ �������� ���� �� ���̺���� �����͸� ���� Ȯ���Ͽ� ���ս�Ű�� ���·�
--   JOIN �� �̷������.

SELECT *
FROM TBL_EMP E RIGHT OUTER JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM TBL_EMP E FULL OUTER JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO;

--�� OUTER JOIN ���� OUTER �� ���� ����
--> ������ �پ������� OUTER JOIN, ������ ������ INNER JOIN

SELECT *
FROM TBL_EMP E LEFT JOIN TBL_DEPT D         -- OUTER JOIN
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM TBL_EMP E RIGHT JOIN TBL_DEPT D        -- OUTER JOIN
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM TBL_EMP E FULL JOIN TBL_DEPT D         -- OUTER JOIN
ON E.DEPTNO = D.DEPTNO;

SELECT *
FROM TBL_EMP E JOIN TBL_DEPT D              -- INNER JOIN
ON E.DEPTNO = D.DEPTNO;

--------------------------------------------------------------------------------
SELECT *
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;
-- �� ������� ... ������ CLREK �� ����鸸 ��ȸ...

SELECT *
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
AND JOB = 'CLERK';
-- �̷��� �������� �����ص� ��ȸ�ϴµ��� ������ ����.
-- ������ �������� ����! (ON -> �������Ǹ�)

SELECT *
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
WHERE JOB = 'CLERK';
-- ������ �̿� ���� �����Ͽ� ��ȸ�� �� �ֵ��� �����Ѵ�.

--------------------------------------------------------------------------------

--�� EMP ���̺�� DEPT ���̺��� �������
--   ������ MANAGER �� CLERK �� ����鸸
--   �μ���ȣ, �μ���, �����, ������, �޿� �׸��� ��ȸ�Ѵ�.
--  --------   -----  ------  -----  ----
--   DEPTNO    DNAME   ENAME   JOB    SAL
--   ------    -----  ------   ---   ----
--    E,D        D       E      E      E

SELECT E.DEPTNO"�μ���ȣ", D.DNAME"�μ���", E.ENAME"�����", E.JOB"������", E.SAL"�޿�"
FROM EMP E LEFT OUTER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
WHERE JOB IN ('MANAGER', 'CLERK')
ORDER BY 4,1;

SELECT DEPTNO, DNAME, ENAME, JOB, SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;
--==>> ���� �߻�
/*
ORA-00918: column ambiguously defined
00918. 00000 -  "column ambiguously defined"
*Cause:    
*Action:
166��, 8������ ���� �߻�
*/
-->> �÷��� ��ó�� ���ǵǾ� ���� �ʾƼ� ����� ����
-- (DEPTNO�� �� ���̺� ��ο��� �־ ����Ŭ�� �򰥷���)
--> �� ���̺� �� �ߺ��Ǵ� �÷��� ���� �Ҽ� ���̺��� 
--  �������(��������) �Ѵ�

SELECT  DNAME, ENAME, JOB, SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;
--> �� ���̺� �� �ߺ��Ǵ� �÷��� �������� �ʴ� ��ȸ ������
--  ���� �߻����� �ʴ´�
--==>>
/*
ACCOUNTING	CLARK	MANAGER 	2450
ACCOUNTING	KING	PRESIDENT	5000
ACCOUNTING	MILLER	CLERK	    1300
RESEARCH	JONES	MANAGER	    2975
RESEARCH	FORD	ANALYST	    3000
RESEARCH	ADAMS	CLERK	    1100
RESEARCH	SMITH	CLERK	    800
RESEARCH	SCOTT	ANALYST 	3000
SALES	    WARD	SALESMAN	1250
SALES	    TURNER	SALESMAN	1500
SALES	    ALLEN	SALESMAN	1600
SALES	    JAMES	CLERK	    950
SALES	    BLAKE	MANAGER	    2850
SALES	    MARTIN	SALESMAN	1250
*/

SELECT D.DEPTNO, DNAME, ENAME, JOB, SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;
--> �� ���̺� �� �ߺ��Ǵ� �÷��� ���� �Ҽ� ���̺��� ����ϴ� ���
--  �μ�(DEPT), ���(EMP) �� � ���̺��� �����ص�
--  ������ ���࿡ ���� ��� ��ȯ�� ������ ����.

--�� ������...
--   �� ���̺� �� �ߺ��Ǵ� �÷��� ���� �Ҽ� ���̺��� ����ϴ� ���
--   �θ� ���̺��� �÷��� ������ �� �ֵ��� �ؾ��Ѵ�.
SELECT *
FROM DEPT;      -- �θ� ���̺�

SELECT *
FROM EMP;       -- �ڽ� ���̺�

--�� �θ� �ڽ� ���̺� ���踦 ��Ȯ�� ������ �� �ֵ��� �Ѵ�.

--      DEPTNO
-- EMP -------- DEPT

--> DEPT ���̺����� DEPTNO�� 10�� �Ѱ�, 20�� �Ѱ�, 30�� �Ѱ� ...
--> �ݸ� EMP ���̺��� DEPTNO�� 10�� ������.. 20�� ������.. �̷���
--> �������� ���� ���̺��� �ڽ�!!
SELECT D.DEPTNO, DNAME, ENAME, JOB, SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

SELECT D.DEPTNO, DNAME, ENAME, JOB, SAL
FROM EMP E RIGHT JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;

SELECT E.DEPTNO, DNAME, ENAME, JOB, SAL
FROM EMP E RIGHT JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;


-- ���� ����
SELECT D.DEPTNO, D.DNAME, E.ENAME, E.JOB, E.SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;
--> �� ���̺� �� �ߺ��� �÷��� �ƴϴ���....
-- �Ҽ� ���̺��� ����� �� �ֵ��� �����Ѵ�


--�� SELF JOIN (�ڱ� ����)
-- EMP ���̺��� ������ ������ ���� ��ȸ �� �� �ֵ��� �Ѵ�.
--  E         E      E        E           E          E          -- �� �� E1
-- EMPNO    ENAME   JOB      MGR       
--                           EMPNO      ENAME       JOB         -- �� �� E2
--------------------------------------------------------------
-- �����ȣ  �����  ������  �����ڹ�ȣ  �����ڸ�  ������������
--------------------------------------------------------------
--   7369   SMITH   CLERK     7902      FORD      ANALYST
SELECT *
FROM EMP;

SELECT E1.EMPNO"�����ȣ", E1.ENAME"�����", E1.JOB"������"
    , E1.MGR"�����ڹ�ȣ", E2.ENAME"�����ڸ�", E2.JOB"������������"
FROM EMP E1 LEFT JOIN EMP E2
ON E1.MGR = E2.EMPNO;

SELECT EMPNO, ENAME, JOB, MGR
FROM EMP;
-- ��

SELECT EMPNO, ENAME, JOB, MGR
FROM EMP;
-- ��
 
SELECT E1.EMPNO "�����ȣ", E1.ENAME "�����", E1.JOB "������"
    , E1.MGR "�����ڹ�ȣ" -- E2.EMPNO "�����ڹ�ȣ"
    , E2.ENAME "�����ڸ�" , E2.JOB "������������"
FROM EMP E1 JOIN EMP E2
ON E1.MGR = E2.EMPNO;
-->> 13�� ���� (�����ڰ� NULL�� KING�� ������ ����)  INNER JOIN

SELECT E1.EMPNO "�����ȣ", E1.ENAME "�����", E1.JOB "������"
    , E1.MGR "�����ڹ�ȣ" -- E2.EMPNO "�����ڹ�ȣ"
    , E2.ENAME "�����ڸ�" , E2.JOB "������������"
FROM EMP E1 LEFT JOIN EMP E2
ON E1.MGR = E2.EMPNO;
-->> LEFT OUTER JOIN (E1�� �������� E1�� ��� ���� = 14���� ��� ����)

