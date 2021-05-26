SELECT USER
FROM DUAL;
--==>> SCOTT

SELECT *
FROM TAB;


--�� ���� ���̺� ����
DROP TABLE TBL_BOARD PURGE;
--==>> Table TBL_BOARD��(��) �����Ǿ����ϴ�.


--�� TBL_BOARD ���̺� ���� (�Խ��� ���� ���̺� ����)
CREATE TABLE TBL_BOARD
( NUM       NUMBER(9)               NOT NULL    -- �Խù� ��ȣ
, NAME      VARCHAR2(30)            NOT NULL    -- �Խù� �ۼ���
, PWD       VARCHAR2(20)            NOT NULL    -- �Խù� ��ȣ
, EMAIL     VARCHAR2(50)                        -- �ۼ��� �̸���
, SUBJECT   VARCHAR2(100)           NOT NULL    -- �Խù� ����
, CONTENT   VARCHAR2(4000)          NOT NULL    -- �Խù� ����
, IPADDR    VARCHAR2(20)                        -- ������ Ŭ���̾�Ʈ�� IP �ּ�
, HITCOUNT  NUMBER DEFAULT 0        NOT NULL    -- �Խù� ��ȸ��
, CREATED   DATE DEFAULT SYSDATE    NOT NULL    -- �Խù� �ۼ���
, CONSTRAINT BOARD_NUM_PK PRIMARY KEY(NUM)      -- �Խù� ��ȣ�� PK �������� ����
);
--==>> Table TBL_BOARD��(��) �����Ǿ����ϴ�.


--�� �Խù� ��ȣ�� �ִ밪�� ���� ������ ����
SELECT NVL(MAX(NUM),0) AS MAXNUM
FROM TBL_BOARD;
--> �� �� ����
SELECT NVL(MAX(NUM),0) AS MAXNUM FROM TBL_BOARD
;


--�� �Խù� �ۼ� ������ ����
INSERT INTO TBL_BOARD(NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, CREATED)
VALUES(1, '������', '1234', 'joon@test.com', '�ۼ��׽�Ʈ', '���빰�ۼ�', '211.238.142.152', 0, SYSDATE);
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.
--> �� �� ����
INSERT INTO TBL_BOARD(NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, CREATED) VALUES(1, '������', '1234', 'joon@test.com', '�ۼ��׽�Ʈ', '���빰�ۼ�', '211.238.142.152', 0, SYSDATE)
;


--�� DB ���ڵ��� ������ �������� ������ ����
SELECT COUNT(*) AS COUNT
FROM TBL_BOARD;
--==>> 1
--> �� �� �� ��
SELECT COUNT(*) AS COUNT FROM TBL_BOARD
;


--�� Ư�� ������ (���۹�ȣ ~ ����ȣ) �Խù��� ����� �о���� ������ ����

SELECT *
FROM
(
    SELECT ROWNUM RNUM, DATA.*
    FROM
    (
        SELECT NUM, NAME, SUBJECT, HITCOUNT, TO_CHAR(CREATED, 'YYYY-MM-DD') AS CREATED
        FROM TBL_BOARD
        ORDER BY NUM DESC
    )DATA
)
WHERE RNUM >= 1 AND RNUM <=10;

--> �� �� �� ��
SELECT * FROM( SELECT ROWNUM RNUM, DATA.* FROM( SELECT NUM, NAME, SUBJECT, HITCOUNT, TO_CHAR(CREATED, 'YYYY-MM-DD') AS CREATED FROM TBL_BOARD ORDER BY NUM DESC )DATA ) WHERE RNUM >= 1 AND RNUM <=10
;

--------------------------------------------------------------------------------


DELETE
FROM TBL_BOARD;
--==>> 2�� �� ��(��) �����Ǿ����ϴ�.

SELECT *
FROM TBL_BOARD;

COMMIT;
--==>> Ŀ�� �Ϸ�.

SELECT *
FROM TBL_BOARD;



