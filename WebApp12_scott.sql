SELECT USER
FROM DUAL;
--==>SCOTT

--�� ���� ���̺� ����
DROP TABLE TBL_MEMBER;
--==>Table TBL_MEMBER��(��) �����Ǿ����ϴ�.

ALTER TABLE TBL_MEMBER
DROP CONSTRAINT MEMBER_SID_PK;

--�� ���̺� ����
CREATE TABLE TBL_MEMBER
(SID    NUMBER
,NAME   VARCHAR2(30) NOT NULL
,TEL    VARCHAR2(40)
, CONSTRAINT MEMBER_SID_PK1 PRIMARY KEY(SID)
);

--==>Table TBL_MEMBER��(��) �����Ǿ����ϴ�.

--�� ���� ������ ����
DROP SEQUENCE MEMBERSEQ;
--==>Sequence MEMBERSEQ��(��) �����Ǿ����ϴ�.

--�� ������ ����
CREATE SEQUENCE MEMBERSEQ
NOCACHE;
--==>Sequence MEMBERSEQ��(��) �����Ǿ����ϴ�.

--�� ���� ������ �Է�
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '�ڳ���', '010-1111-1111');
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '������', '010-2222-2222');
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '��ο�', '010-3333-3333');
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '������', '010-4444-4444');
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '������', '010-5555-5555');
--==>1 �� ��(��) ���ԵǾ����ϴ�.*5

--�� ������ �Է� ����
SELECT SID, NAME, TEL FROM TBL_MEMBER;
--SID	NAME	TEL
--1	�ڳ���	010-1111-1111
--2	������	010-2222-2222
--3	��ο�	010-3333-3333
--4	������	010-4444-4444
--5	������	010-5555-5555

--�� Ŀ��
COMMIT;
--==>Ŀ�� �Ϸ�.

--�� �ο� �� Ȯ��
SELECT COUNT(*) AS COUNT 
FROM TBL_MEMBER;
--==>5

--�� �� �� ����
SELECT COUNT(*) AS COUNT FROM TBL_MEMBER
;



--�� ȸ�� ������ �˻�
SELECT SID,NAME,TEL
FROM TBL_MEMBER
WHERE SID=1; 
--==>1	�ڳ���	010-1111-1111

--�� �� �� ����
SELECT SID,NAME,TEL FROM TBL_MEMBER WHERE SID=1
;

--�� ȸ�� ���� ����
UPDATE TBL_MEMBER
SET NAME = '�ڹڹ�' , TEL='010-1010-0101'
WHERE SID='1';
--==>1 �� ��(��) ������Ʈ�Ǿ����ϴ�.

UPDATE TBL_MEMBER SET NAME = '�ڹڹ�' , TEL='010-1010-0101' WHERE SID='1'

--�� ������ ���� Ȯ��
SELECT *
FROM TBL_MEMBER
;

--�� �ѹ�
ROLLBACK;
--==>�ѹ� �Ϸ�.


-- ������ ����
DELETE 
FROM TBL_MEMBER 
WHERE SID = '1';
--==>1 �� ��(��) �����Ǿ����ϴ�.

--���� �� ����
DELETE FROM TBL_MEMBER WHERE SID = '1'
;

--�� ������ ���� Ȯ��
SELECT *
FROM TBL_MEMBER
;


--�۷ѹ�
ROLLBACK;
--�ѹ� �Ϸ�.

--�� ���̺� ����
DROP TABLE TBL_SCORE;
--==>Table TBL_SCORE��(��) �����Ǿ����ϴ�.

--�� ���̺� ����
CREATE TABLE TBL_MEMBERSCORE
(SID NUMBER
, KOR NUMBER(3)
, ENG NUMBER(3)
, MAT NUMBER(3)
, CONSTRAINT MEMBERSCORE_SID_PK PRIMARY KEY(SID)
, CONSTRAINT MEMBERSCORE_KOR_CK CHECK(KOR BETWEEN 0 AND 100)
, CONSTRAINT MEMBERSCORE_ENG_CK CHECK(ENG BETWEEN 0 AND 100)
, CONSTRAINT MEMBERSCORE_MAT_CK CHECK(MAT BETWEEN 0 AND 100)
, CONSTRAINT MEMBERSCORE_SID_FK FOREIGN KEY(SID)
                            REFERENCES TBL_MEMBER(SID)
);
--Table TBL_MEMBERSCORE��(��) �����Ǿ����ϴ�.

--�ۻ��� ������ �Է�
INSERT INTO TBL_MEMBERSCORE(SID, KOR, ENG, MAT) VALUES(1,20,30,40);
--==> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� ������ �Է� Ȯ��
SELECT *
FROM TBL_MEMBERSCORE;
--==>20	30	40

--�� Ŀ��
COMMIT;
--==>Ŀ�� �Ϸ�.


--�� ���� �Է� ������ ���ڵ� �� Ȯ�� ������ ����
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBERSCORE;
--==>> 1
--> ���� ����
SELECT COUNT(*) AS COUNT FROM TBL_MEMBERSCORE
;


--�� ���� ������ �˻� ������ ���� (SID)
SELECT SID, KOR, ENG, MAT
FROM TBL_MEMBERSCORE
WHERE SID=1;
--==>> 1	20	30	40
--> ���� ����
SELECT SID, KOR, ENG, MAT FROM TBL_MEMBERSCORE WHERE SID=1
;


--�� ���� ������ ���� ������ ����
UPDATE TBL_MEMBERSCORE
SET KOR=91, ENG=81, MAT=71
WHERE SID=1;
--==>>1 �� ��(��) ������Ʈ�Ǿ����ϴ�.
-->> �� �� ����
UPDATE TBL_MEMBERSCORE SET KOR=91, ENG=81, MAT=71 WHERE SID=1
;


--�� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.


--�� ���� ������ ���� ������ ����
DELETE
FROM TBL_MEMBERSCORE
WHERE SID=1;
--==>> 1 �� ��(��) ������Ʈ�Ǿ����ϴ�.
--> �� �� ����
DELETE FROM TBL_MEMBERSCORE WHERE SID=1;


--�� �ѹ�
ROLLBACK;
--==>> �ѹ� �Ϸ�.


--�� ��ü ������ ��ȸ ������ ����
SELECT M.SID ,M.NAME, M.TEL
    , S.KOR, S.ENG, S.MAT
FROM TBL_MEMBER M, TBL_MEMBERSCORE S
WHERE M.SID = S.SID;
--==>> 1	�ڳ���	010-1111-1111   91	81	71
--> �� �� �� ��
SELECT M.SID ,M.NAME, M.TEL FROM TBL_MEMBER M, TBL_MEMBERSCORE S WHERE M.SID = S.SID;


--�� ��ü ������ ��ȸ ������ ���� �� ��� ����Ʈ ��ȸ �����ϵ��� ���� �� LEFT JOIN
--                              �� ������ Ÿ�� ����ȭ �� NVL
SELECT M.SID ,M.NAME, M.TEL
     , NVL(S.KOR, -1) AS KOR 
     , NVL(S.ENG, -1) AS ENG
     , NVL(S.MAT, -1) AS MAT
FROM TBL_MEMBER M, TBL_MEMBERSCORE S
WHERE M.SID = S.SID(+);
--==>>
/*
1	�ڳ���	010-1111-1111	91	81	71
2	������	010-2222-2222	-1	-1	-1
3	��ο�	010-3333-3333	-1	-1	-1
4	������	010-4444-4444	-1	-1	-1
5	������	010-5555-5555	-1	-1	-1
*/
--> �� �� �� ��
SELECT M.SID ,M.NAME, M.TEL, NVL(S.KOR, -1) AS KOR , NVL(S.ENG, -1) AS ENG, NVL(S.MAT, -1) AS MAT FROM TBL_MEMBER M, TBL_MEMBERSCORE S WHERE M.SID = S.SID(+);


--�� ��ü ������ ��ȸ ���� �� ����(VIEW_MEMBERSCORE) 
CREATE OR REPLACE VIEW VIEW_MEMBERSCORE
AS
SELECT M.SID ,M.NAME, M.TEL
     , NVL(S.KOR, -1) AS KOR 
     , NVL(S.ENG, -1) AS ENG
     , NVL(S.MAT, -1) AS MAT
FROM TBL_MEMBER M, TBL_MEMBERSCORE S
WHERE M.SID = S.SID(+);
--==>> View VIEW_MEMBERSCORE��(��) �����Ǿ����ϴ�.
--> �� �� �� ��


--�� ������ ��(VIEW_MEMBERSCORE)�� Ȱ���� ����Ʈ ��ȸ ������ ����
SELECT SID, NAME KOR, ENG, MAT
     , (KOR+ENG+MAT) AS TOT
     , ( (KOR+ENG+MAT/3) ) AS AVG
     , RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK
FROM VIEW_MEMBERSCORE
ORDER BY SID;
--==>>
/*
1	�ڳ���	81	71	243	195.666666666666666666666666666666666667	1
2	������	-1	-1	-3	-2.33333333333333333333333333333333333333	2
3	��ο�	-1	-1	-3	-2.33333333333333333333333333333333333333	2
4	������	-1	-1	-3	-2.33333333333333333333333333333333333333	2
5	������	-1	-1	-3	-2.33333333333333333333333333333333333333	2
*/
--> �� �� �� ��
SELECT SID, NAME KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT, ( (KOR+ENG+MAT/3) ) AS AVG, RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK FROM VIEW_MEMBERSCORE ORDER BY SID;

--�� ������ ��(VIEW_MEMBERSCORE)�� Ȱ���� ��ȣ �˻� ������ ����
SELECT SID, NAME, KOR, ENG, MAT
FROM VIEW_MEMBERSCORE
WHERE SID=1;
--==>> 1	�ڳ���	91	81	71
--> �� �� �� ��
SELECT SID, NAME, KOR, ENG, MAT FROM VIEW_MEMBERSCORE WHERE SID=1
;


--�� ���������� ���ڵ� ��  ������ ����
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBERSCORE
WHERE SID=1;
--==>> 1
--==>> ������ ���� �����Ͱ� �ԷµǾ����� 1 ��ȯ, �ƴϸ� 0 ��ȯ
--> �� �� �� ��
SELECT COUNT(*) AS COUNT FROM TBL_MEMBERSCORE WHERE SID=1
;



--�� ��ȣ �˻� ��� ������ ����(���� ������ �Է�/����)
SELECT SID, NAME, KOR, ENG, MAT
FROM VIEW_MEMBERSCORE
WHERE SID=1;
--> ���� ����
SELECT SID, NAME, KOR, ENG, MAT FROM VIEW_MEMBERSCORE WHERE SID=1;






