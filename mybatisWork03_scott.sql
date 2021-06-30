SELECT USER
FROM DUAL;
--==>>SCOTT

--�� TBL_STUDENT ���̺� ����
CREATE TABLE TBL_STUDENT
( SID   NUMBER          PRIMARY KEY
, NAME  VARCHAR2(30)
, TEL   VARCHAR2(30)
);
--==>> Table TBL_STUDENT��(��) �����Ǿ����ϴ�.

--�� ������ �߰�
CREATE SEQUENCE STUDENTSEQ
NOCACHE;
--==>> Sequence STUDENTSEQ��(��) �����Ǿ����ϴ�.

--�� ������ �߰�
INSERT INTO TBL_STUDENT(SID, NAME, TEL)
VALUES(STUDENTSEQ.NEXTVAL, '������', '010-1111-1111');
--==>>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� ������ ��ȸ��
SELECT SID, NAME, TEL
FROM TBL_STUDENT;
--==>> 1	������	010-1111-1111




--�� TBL_GRADE ���̺� ����
CREATE TABLE TBL_GRADE
( SID   NUMBER         REFERENCES TBL_STUDENT(SID)
, SUB1  NUMBER(3)
, SUB2  NUMBER(3)
, SUB3  NUMBER(3)
, CONSTRAINT GRADE_SID_PK PRIMARY KEY(SID)
);
--==>> Table TBL_GRADE��(��) �����Ǿ����ϴ�.

--�� ������ �߰�
INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3) VALUES(1, '90', '80', '90');
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� ��ȸ
SELECT SID, SUB1, SUB2, SUB3
FROM TBL_GRADE;
--==>> 1	90	80	90


--�� STUDENTVIEW �� ����
CREATE OR REPLACE VIEW STUDENTVIEW
AS
SELECT SID, NAME, TEL, 
    (SELECT COUNT(*) 
    FROM TBL_GRADE 
    WHERE SID = S.SID) AS SUB
FROM TBL_STUDENT S;
--==>> View STUDENTVIEW��(��) �����Ǿ����ϴ�.
-- SUB : STUDENT ������ ���� ���ɿ��� Ȯ��


--�� GRADEVIEW �� ���� 
CREATE OR REPLACE VIEW GRADEVIEW
AS
SELECT SID
    , (SELECT NAME
        FROM TBL_STUDENT
        WHERE SID = G.SID) AS NAME
    , SUB1, SUB2, SUB3
    , (SUB1 + SUB2 + SUB3) AS TOT
    , ((SUB1+SUB2+ SUB3)/3) AS AVG
    , CASE WHEN ((SUB1+SUB2+ SUB3)/3) >= 90 THEN '�հ�'
            WHEN ((SUB1+SUB2+ SUB3)/3) >= 60 THEN '����'
            ELSE 'Ż��'
        END CH
FROM TBL_GRADE G;
--==>> View GRADEVIEW��(��) �����Ǿ����ϴ�.

