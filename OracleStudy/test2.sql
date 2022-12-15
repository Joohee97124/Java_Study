--�� ���� ���� ���̺� ����
CREATE TABLE TBL_OC
( OC_CD     VARCHAR2(10)
, CRS_CD    VARCHAR2(10)        NOT NULL
, CRS_BD    DATE                NOT NULL
, CRS_ED    DATE                NOT NULL
, CRS_RM    VARCHAR2(10)        NOT NULL
, CONSTRAINT TBL_OC_PK PRIMARY KEY (OC_CD)
, CONSTRAINT TBL_IC_FK FOREIGN KEY(CRS_CD)
             REFERENCES TBL_CRS(CRS_CD)
, CONSTRAINT TBL_OC_CK CHECK(CRS_ED > CRS_BD)
);

--�� ���� ���̺� ����
CREATE TABLE TBL_CRS
( CRS_CD    VARCHAR2(10)
, CRS_NM    VARCHAR2(50)    CONSTRAINT CRS_NM_NN NOT NULL
, CONSTRAINT CRS_CD_PK PRIMARY KEY(CRS_CD)
);

--�� ���� ���̺� ����
CREATE TABLE TBL_SUB
( SUB_CD VARCHAR2(10)
, SUB_NM VARCHAR2(50) CONSTRAINT SUB_NM_NN NOT NULL
, CONSTRAINT SUB_CD_PK PRIMARY KEY(SUB_CD)
);

--�� ���� ���̺� ����
CREATE TABLE TBL_BK
( BK_CD VARCHAR2(10)
, BK_NM VARCHAR2(50) CONSTRAINT BK_NM_NN  NOT NULL
, CONSTRAINT BK_CD_PK PRIMARY KEY(BK_CD)
);
--==>> Table TBL_BK��(��) �����Ǿ����ϴ�.
DESC TBL_BK;

--�� �л� ȸ������ ���̺� ����
CREATE TABLE TBL_ST
( ST_ID     VARCHAR2(10)   
, ST_SSN    CHAR(14)       CONSTRAINT ST_SSN_NN NOT NULL
, ST_FN     VARCHAR2(5)    CONSTRAINT ST_FN_NN NOT NULL
, ST_LN     VARCHAR2(5)    CONSTRAINT ST_LN_NN NOT NULL
, ST_DT     DATE           DEFAULT SYSDATE
, ST_PW     VARCHAR2(10)   CONSTRAINT ST_PW_NN NOT NULL
, CONSTRAINT ST_ID_PK PRIMARY KEY(ST_ID) 
);

--�� ������ ���� ���̺� ����
CREATE TABLE TBL_AD 
( AD_ID 	VARCHAR2(10)
, AD_PW 	VARCHAR2(10)	CONSTRAINT AD_PW_NN NOT NULL
, CONSTRAINT AD_ID_PK PRIMARY KEY(AD_ID)
);

--�� ���� ���̺� ����
CREATE TABLE TBL_RAT 
( RAT_CD    VARCHAR2(10)
, RAT_AT    NUMBER(3)       CONSTRAINT RAT_AT_NN NOT NULL
, RAT_WT    NUMBER(3)       CONSTRAINT RAT_WT_NN NOT NULL
, RAT_PT    NUMBER(3)       CONSTRAINT RAT_PT_NN NOT NULL
, CONSTRAINT RAT_CD_PK PRIMARY KEY(RAT_CD)
);


--�� ���� ���̺� ����
CREATE TABLE TBL_PR
( PR_ID     VARCHAR2(10)    
, PR_SSN    CHAR(14)       CONSTRAINT PR_SSN_NN NOT NULL
, PR_FN     VARCHAR2(5)    CONSTRAINT PR_FN_NN NOT NULL
, PR_LN     VARCHAR2(10)    CONSTRAINT PR_LN_NN NOT NULL
, PR_DT     DATE                DEFAULT SYSDATE
, PR_PW     VARCHAR2(10)   CONSTRAINT PR_PW_NN NOT NULL
, CONSTRAINT PR_ID_PK PRIMARY KEY (PR_ID)
);

--�� ���񰳼� ���̺� ����
CREATE TABLE TBL_OS
( OS_CD     VARCHAR2(10)
, OC_CD     VARCHAR2(10) CONSTRAINT OS_OC_CD_NN  NOT NULL
, SUB_CD    VARCHAR2(10) CONSTRAINT OS_SUB_CD_NN NOT NULL
, PR_ID     VARCHAR2(10) CONSTRAINT OS_PR_ID_NN NOT NULL
, BK_CD     VARCHAR2(10)
, RAT_CD    VARCHAR2(10) CONSTRAINT OS_RAT_CD_NN NOT NULL
, SUB_BD    DATE         CONSTRAINT OS_SUB_BD_NN NOT NULL
, SUB_ED    DATE         CONSTRAINT OS_SUB_ED_NN NOT NULL
, CONSTRAINT OS_CD_PK    PRIMARY KEY(OS_CD) 
, CONSTRAINT OS_OC_CD_FK    FOREIGN KEY(OC_CD)  REFERENCES TBL_OC(OC_CD)
, CONSTRAINT OS_SUB_CD_FK   FOREIGN KEY(SUB_CD) REFERENCES TBL_SUB(SUB_CD)
, CONSTRAINT OS_PR_ID_FK    FOREIGN KEY(PR_ID)  REFERENCES TBL_PR(PR_ID)
, CONSTRAINT OS_BK_CD_FK    FOREIGN KEY(BK_CD)  REFERENCES TBL_BK(BK_CD)
, CONSTRAINT OS_RAT_CD_FK   FOREIGN KEY(RAT_CD) REFERENCES TBL_RAT(RAT_CD)
, CONSTRAINT SUB_ED_CK      CHECK(SUB_ED>=SUB_BD)
);

--�� ������û ���̺� ����
CREATE TABLE TBL_REG
( REG_CD    VARCHAR2(10)
, ST_ID     VARCHAR2(10)    CONSTRAINT REG_ST_ID_NN NOT NULL
, OC_CD     VARCHAR2(10)    CONSTRAINT REG_OC_CD_NN NOT NULL
, REG_DT    DATE    DEFAULT SYSDATE    
, CONSTRAINT REG_CD_PK PRIMARY KEY(REG_CD)
, CONSTRAINT REG_ST_ID_FK  FOREIGN KEY(ST_ID)
             REFERENCES TBL_ST(ST_ID)
, CONSTRAINT REG_OC_CD_FK  FOREIGN KEY(OC_CD)
             REFERENCES TBL_OC(OC_CD)
);

--�� ���� �Է� ���̺� ����
CREATE TABLE TBL_SC
( SC_CD     VARCHAR2(10)    
, REG_CD    VARCHAR2(10)    CONSTRAINT SC_REG_CD_NN NOT NULL
, OS_CD     VARCHAR2(10)    CONSTRAINT SC_OS_CD_NN NOT NULL
, SC_AT     NUMBER(3)       CONSTRAINT SC_AT_NN NOT NULL
, SC_WT     NUMBER(3)       CONSTRAINT SC_WT_NN NOT NULL
, SC_PT     NUMBER(3)       CONSTRAINT SC_PT_NN NOT NULL
, CONSTRAINT SC_CD_PK PRIMARY KEY(SC_CD)
, CONSTRAINT SC_REG_CD_FK FOREIGN KEY(REG_CD)
            REFERENCES TBL_REG(REG_CD)
, CONSTRAINT SC_OS_CD_FK FOREIGN KEY(OS_CD)
            REFERENCES TBL_OS(OS_CD)
);

--�� �ߵ�Ż�� ���̺� ����
CREATE TABLE TBL_QT 
( QT_CD 	VARCHAR2(10)
, REG_CD 	VARCHAR2(10)	CONSTRAINT QT_REG_CD_NN NOT NULL
, QT_DT		DATE		    DEFAULT SYSDATE
, CONSTRAINT QT_CD_PK PRIMARY KEY(QT_CD)
, CONSTRAINT QT_REG_CD_FK FOREIGN KEY(REG_CD)
			  REFERENCES TBL_REG(REG_CD)
);






--------------------------------------------------------------[����, ��������]----

--�� ���� ���� ���� ���ν��� (PRC_PR_INSERT)
-- ������ ����
CREATE SEQUENCE SEQ_PRCODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_PRCODE��(��) �����Ǿ����ϴ�.
    
--������ ����
CREATE SEQUENCE SEQ_PRCODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_PRCODE��(��) �����Ǿ����ϴ�.

--���ν��� ����
CREATE OR REPLACE PROCEDURE PRC_PR_INSERT
( VPR_SSN    IN TBL_PR.PR_SSN%TYPE
, VPR_FN     IN TBL_PR.PR_FN%TYPE
, VPR_LN     IN TBL_PR.PR_LN%TYPE
, VPR_DT     IN TBL_PR.PR_DT%TYPE    DEFAULT SYSDATE
)
IS
    -- ���� ����
    VPR_ID  TBL_PR.PR_ID%TYPE;
    VPR_PW  TBL_PR.PR_PW%TYPE;
    
    -- �ֹι�ȣ �ߺ� ���� 
    PR_SSN_ERROR EXCEPTION;
    
    VCOUNT  NUMBER;
    
BEGIN
    -- ������ �ֹι�ȣ�� �ִ��� üũ
    SELECT COUNT(*) INTO VCOUNT
    FROM TBL_PR
    WHERE PR_SSN = VPR_SSN;
    
    -- ������ �ֹι�ȣ�� ������ INSERT 
    IF (VCOUNT =1)
        THEN 
            RAISE PR_SSN_ERROR;
    ELSE 
        -- VPR_PW ���� (���� ��й�ȣ)
        VPR_PW := SUBSTR(VPR_SSN,8);
        
        -- VPR_ID ���� (����ID)
        VPR_ID := 'PR' || LPAD(SEQ_PRCODE.NEXTVAL,3,'0');      

        -- ���� ���� INSERT ������
        INSERT INTO TBL_PR(PR_ID, PR_SSN, PR_FN, PR_LN, PR_PW, PR_DT)
        VALUES(VPR_ID, VPR_SSN, VPR_FN, VPR_LN, VPR_PW, VPR_DT);
        
    END IF;
    
    --Ŀ��
    COMMIT;
    
    --����ó��
    EXCEPTION
        WHEN PR_SSN_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'�̹� �����ϴ� �������Դϴ�.');
            ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
    
    
END;

--==>> Procedure PRC_PR_INSERT��(��) �����ϵǾ����ϴ�.

ALTER TABLE TBL_PR MODIFY PR_LN VARCHAR2(50);
--==>> Table TBL_PR��(��) ����Ǿ����ϴ�.

--�� ������ �Է�
EXEC PRC_PR_INSERT('750910-1123456', '��','ȣ��'); 
EXEC PRC_PR_INSERT('971009-2123456', '��','����'); 
EXEC PRC_PR_INSERT('750610-1234567', '��','����');
EXEC PRC_PR_INSERT('971224-2123456', '��','�ָ�');
EXEC PRC_PR_INSERT('801010-2123456', '��','�');


--�� ������ Ȯ��
SELECT T.ID, T.SSN, T.FN, T.LN, T.DT, T.PW
    , (SELECT OS_CD
        FROM TBL_OS
        WHERE PR_ID = T.ID) "OS_CD"
FROM
(
SELECT PR_ID "ID" , PR_SSN"SSN", PR_FN"FN", PR_LN"LN", PR_DT"DT", PR_PW"PW"
FROM TBL_PR
)T;
--==>>
/*
PR001	750910-1123456	��	ȣ��	21/04/15	1123456	A006
PR005	750610-1234567	��	����	21/04/16	1234567	A014
PR002	971009-2123456	��	����	21/04/15	2123456	A015
PR004	971225-1234567	��	�ָ�	21/04/15	2123456	(null)
PR006	801010-2123456	��	�	21/04/16	2123456	(null)
*/

SELECT *
FROM TBL_OS;

DELETE 
FROM TBL_PR
WHERE PR_ID = 'PR004';

DROP SEQUENCE SEQ_PRCODE;



--�� ���� ���� ���� ���ν��� (PRC_PR_UPDATE)
CREATE OR REPLACE PROCEDURE PRC_PR_UPDATE
( VPR_ID    IN TBL_PR.PR_ID%TYPE
, VPR_SSN   IN TBL_PR.PR_SSN%TYPE
, VPR_FN    IN TBL_PR.PR_FN%TYPE
, VPR_LN    IN TBL_PR.PR_LN%TYPE
, VPR_DT    IN TBL_PR.PR_DT%TYPE
)
IS
    PR_SSN_ERROR EXCEPTION;     -- �ֹι�ȣ�� �ٸ� �ֹ��� ��ġ�� ����ó��
    VCOUNT NUMBER;
    PR_DATE_ERROR   EXCEPTION;  -- DT�� ���ú��� �̷��̸� ����ó��
    
BEGIN
    -- ������ �ֹι�ȣ�� �ִ��� üũ
    SELECT COUNT(*) INTO VCOUNT
    FROM TBL_PR
    WHERE PR_SSN = VPR_SSN;
    
    --������ �ֹι�ȣ�� �ƴϸ� UPDATE
    IF VCOUNT=1
        THEN RAISE PR_SSN_ERROR;
        
    ELSIF ( TO_NUMBER(SYSDATE - VPR_DT)<0 )
        THEN RAISE PR_DATE_ERROR;
    
    ELSE    
    -- ���� ���̺� ����
    UPDATE TBL_PR
    SET PR_SSN = VPR_SSN
    WHERE PR_ID = VPR_ID;
    END IF;
    
    --Ŀ��
    COMMIT;
    
    -- ����ó��
    EXCEPTION
        WHEN PR_SSN_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'�̹� �����ϴ� �������Դϴ�.');
            ROLLBACK;
        WHEN PR_DATE_ERROR 
            THEN RAISE_APPLICATION_ERROR(-20005, '��ȿ���� ���� ��¥�Դϴ�.');
            ROLLBACK; 
        WHEN OTHERS THEN ROLLBACK;
END;

EXEC PRC_PR_UPDATE('PR004','971225-1234767','��','����','2020-07-10');
EXEC PRC_PR_UPDATE('PR004','��','����','2020-07-10');

SELECT *
FROM TBL_PR;

--�� ���� ���� ���� ���ν��� (PRC_PR_DELETE)
CREATE OR REPLACE PROCEDURE PRC_PR_DELETE
( VPR_ID    IN TBL_PR.PR_ID%TYPE
)
IS
BEGIN
    -- ���� ���� ����
    DELETE
    FROM TBL_PR
    WHERE PR_ID = VPR_ID;
    
    --Ŀ��
    COMMIT;
    
END;
--==>> Procedure PRC_PR_DELETE��(��) �����ϵǾ����ϴ�.

EXEC PRC_PR_DELETE('PR003');


--�� ���� ���� ��ȸ (��������) ���ν���
CREATE OR REPLACE VIEW VIEW_PR
AS
SELECT T.*
FROM
(
    SELECT ROWNUM "NUM", PR_ID "PR_ID", PR_SSN "PR_SSN", PR_FN "PR_FN", PR_LN "PR_LN", PR_DT "PR_DT", PR_PW "PR_PW"
    FROM TBL_PR
)T;


--�� Ư�� ������ ��ü ���Ǹ�� ��ȸ
CREATE OR REPLACE PROCEDURE PRC_PR_LOOKUP
(
    V_PR_ID      IN TBL_PR.PR_ID%TYPE   -- �������̵�
)
IS
    V_SUB_NM     TBL_SUB.SUB_NM%TYPE; -- ������ �����
    V_SUB_BD     TBL_OS.SUB_BD%TYPE;  -- ���� ������
    V_SUB_ED     TBL_OS.SUB_ED%TYPE;  -- ���� ������
    V_BK_CD      TBL_BK.BK_CD%TYPE;   -- �����ڵ�
    V_BK_NM      TBL_BK.BK_NM%TYPE;   -- �����
    V_OC_CD      TBL_OC.OC_CD%TYPE;   -- ���ǽ��ڵ�
    V_CRS_RM     TBL_OC.CRS_RM%TYPE;  -- ���ǽ�
    
    V_OS_CD      TBL_OS.OS_CD%TYPE;
    V_SUB_CD     TBL_SUB.SUB_CD%TYPE;
    
    V_ING        VARCHAR(50);         -- ���� ���� ����
    V_DATE1      NUMBER;              -- ��¥ ���� ����
    V_DATE2      NUMBER;
    
    V_NUM        NUMBER;
    V_ROWNUM     NUMBER;
    
    NOT_FOUND_ERROR     EXCEPTION;
    VCOUNT              NUMBER;
    
BEGIN
    SELECT COUNT(*) INTO VCOUNT
    FROM TBL_PR
    WHERE PR_ID = V_PR_ID;

    SELECT MIN(ROWNUM),MAX(ROWNUM) INTO V_NUM,V_ROWNUM
    FROM TBL_OS
    WHERE PR_ID = V_PR_ID;
    
    
    IF VCOUNT =1
        THEN
        
        LOOP    
            SELECT OS_CD,SUB_BD,SUB_ED,BK_CD,OC_CD INTO V_OS_CD,V_SUB_BD,V_SUB_ED,V_BK_CD,V_OC_CD
            FROM TBL_OS
            WHERE PR_ID = V_PR_ID;
            
            SELECT SUB_NM INTO V_SUB_NM
            FROM TBL_SUB
            WHERE SUB_CD = (SELECT SUB_CD FROM TBL_OS WHERE OS_CD = V_OS_CD);
            
            SELECT BK_NM INTO V_BK_NM
            FROM TBL_BK
            WHERE BK_CD = V_BK_CD;
    
            SELECT CRS_RM INTO V_CRS_RM
            FROM TBL_OC
            WHERE OC_CD = V_OC_CD;
            
            V_DATE1 := TO_NUMBER(SYSDATE - V_SUB_BD);
            V_DATE2 := TO_NUMBER(SYSDATE - V_SUB_ED);
            
            IF (V_DATE1 > 0 AND V_DATE2 < 0) 
                THEN V_ING := '���� ��';
            ELSIF (V_DATE1 < 0 AND V_DATE2 < 0) 
                THEN V_ING := '���� ����';
            ELSIF (V_DATE1 > 0 AND V_DATE2 > 0)
                THEN V_ING := '���� ����';
            ELSE V_ING := 'Ȯ�κҰ�';
            END IF;
            
            -- ���� ���� ���        
            DBMS_OUTPUT.PUT_LINE(V_NUM || '.');
            DBMS_OUTPUT.PUT_LINE('����ID : ' || V_PR_ID);
            DBMS_OUTPUT.PUT_LINE('������ ����� : ' || V_OS_CD  );
            DBMS_OUTPUT.PUT_LINE('���� �Ⱓ : ' || V_SUB_BD || '~' || V_SUB_ED );
            DBMS_OUTPUT.PUT_LINE('����� : ' || V_BK_NM );
            DBMS_OUTPUT.PUT_LINE('���ǽ� : ' || V_CRS_RM );
            DBMS_OUTPUT.PUT_LINE('���� ���� ���� : ' || V_ING );
            
            V_NUM := V_NUM+1;
            
            EXIT WHEN V_NUM > V_ROWNUM;
        END LOOP;
        
    ELSE RAISE NOT_FOUND_ERROR;
    END IF;
    
    -- Ŀ��
    COMMIT;
    
    EXCEPTION
        WHEN NOT_FOUND_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '�Է��Ͻ� ������ ��ġ�ϴ� �����Ͱ� �����ϴ�.');
            ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
END;

EXEC PRC_PR_LOOKUP ('PR001');

SELECT *
FROM TBL_OS;




--�� ���� ���� ��ȸ (�����ڽ���) ���ν���
CREATE OR REPLACE PROCEDURE PRC_PR_LOOKUP_ADMIN
IS
    V_PR_ID      TBL_PR.PR_ID%TYPE;
    V_NUM        NUMBER := 1;
    V_ROWNUM     NUMBER; 
    
BEGIN
    SELECT COUNT(*) INTO V_NUM
    FROM TBL_PR
    WHERE PR_ID = V_PR_ID;
    
    SELECT MAX(ROWNUM) INTO V_ROWNUM
    FROM TBL_PR;
    
    LOOP
        SELECT PR_ID INTO V_PR_ID
        FROM VIEW_PR
        WHERE NUM = V_NUM;
        
        PRC_PR_LOOKUP(V_PR_ID);
        V_NUM := V_NUM + 1;
        
        EXIT WHEN V_NUM > V_ROWNUM;
    END LOOP;
END;
--==>> Procedure PRC_PR_LOOKUP��(��) �����ϵǾ����ϴ�.
EXEC PRC_PR_LOOKUP_ADMIN;


--�� �������� ���� ���ν���
-- ������ ����
CREATE SEQUENCE SEQ_OC
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_OC��(��) �����Ǿ����ϴ�.

--���ν��� ����
CREATE OR REPLACE PROCEDURE PRC_OC_INSERT
( VCRS_CD   IN TBL_OC.CRS_CD%TYPE
, VCRS_BD   IN TBL_OC.CRS_BD%TYPE
, VCRS_ED   IN TBL_OC.CRS_ED%TYPE
, VCRS_RM   IN TBL_OC.CRS_RM%TYPE
)
IS
    -- �ֿ� ���� ����
    VOC_CD  TBL_OC.OC_CD%TYPE;      
    VCRS_NM TBL_CRS.CRS_NM%TYPE;    
    
    -- ���� ���� ���� (��¥)
    OC_DATE_ERROR   EXCEPTION;   
BEGIN
    -- ���� �߻�
    IF (TO_NUMBER(VCRS_ED - VCRS_BD) < 0)
        THEN RAISE OC_DATE_ERROR;
    END IF;
    
    -- ������ ã�� VCRS_NM
    SELECT CRS_NM INTO VCRS_NM
    FROM TBL_CRS
    WHERE CRS_CD = VCRS_CD;
    
    -- VOC_CD �������� �ڵ�
    VOC_CD := TO_CHAR('A' || '_' || SUBSTR(VCRS_NM,1,2) || LPAD(SEQ_OC.NEXTVAL,3,'0'));
    
    INSERT INTO TBL_OC(OC_CD, CRS_CD, CRS_BD, CRS_ED, CRS_RM)
    VALUES(VOC_CD ,VCRS_CD, VCRS_BD, VCRS_ED, VCRS_RM);
 
    COMMIT;
    
    EXCEPTION
        WHEN OC_DATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20005, '��ȿ���� ���� ��¥�Դϴ�');
                 ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
END;
--==>> Procedure PRC_CRS_INSERT��(��) �����ϵǾ����ϴ�.
-->> �������� �ּ������ϱ�

--�� ������ �Է�
EXEC PRC_OC_INSERT('JA001', '2021-02-01', '2021-03-02' , 'F��');


--�� �������� ���� ���ν���
CREATE OR REPLACE PROCEDURE PRC_OC_UPDATE
( VOC_CD    IN TBL_OC.OC_CD%TYPE
, VCRS_CD   IN TBL_OC.CRS_CD%TYPE
, VCRS_BD   IN TBL_OC.CRS_BD%TYPE
, VCRS_ED   IN TBL_OC.CRS_ED%TYPE
, VCRS_RM   IN TBL_OC.CRS_RM%TYPE
)
IS
    NOT_FOUND_ERROR EXCEPTION;    -- �����ڵ� ��ġX ����
    VCOUNT          NUMBER;       -- �����ڵ� Ȯ�ο�
    OC_DATE_ERROR   EXCEPTION;    -- ��¥ ���� ����
    
BEGIN
    
    -- ������ �����ڵ尡 �ִ��� üũ
    SELECT COUNT(*) INTO VCOUNT
    FROM TBL_CRS
    WHERE CRS_CD = VCRS_CD;
    
    -- ������ �����ڵ尡 ������ �������� ���� UPDATE
    IF VCOUNT =1 
        AND (TO_NUMBER(VCRS_ED - VCRS_BD) > 0)
        THEN
            UPDATE TBL_OC
            SET CRS_CD = VCRS_CD
            , CRS_BD = VCRS_BD
            , CRS_ED = VCRS_ED
            , CRS_RM = VCRS_RM
            WHERE OC_CD = VOC_CD;
    ELSIF (TO_NUMBER(VCRS_ED - VCRS_BD) < 0)
        THEN RAISE OC_DATE_ERROR;
    ELSE RAISE NOT_FOUND_ERROR;
    END IF;
    
    EXCEPTION
        WHEN NOT_FOUND_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '�Է��Ͻ� ������ ��ġ�ϴ� �����Ͱ� �����ϴ�.');
            ROLLBACK;
        WHEN OC_DATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20005, '��ȿ���� ���� ��¥�Դϴ�.');
            ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
    --Ŀ��
    COMMIT;      
END;
--==>> Procedure PRC_OR_UPDATE��(��) �����ϵǾ����ϴ�.

EXEC PRC_OC_UPDATE('A_SW001','SW001','2021-01-02','2021-02-10','A��');

SELECT*
FROM TBL_OC;


--�� �������� ���� ���ν���
CREATE OR REPLACE PROCEDURE PRC_OC_DELETE
( VOC_CD    IN TBL_OC.OC_CD%TYPE
)
IS
BEGIN
        DELETE
        FROM TBL_OC
        WHERE OC_CD = VOC_CD;
    
    -- Ŀ��
    COMMIT;
           
END;
--==>> Procedure PRC_OR_DELETE��(��) �����ϵǾ����ϴ�.
-->> �������� �ּ� ����

EXEC PRC_OC_DELETE('A_SW001','SW002');

SELECT *
FROM TBL_OC;


--�� �������� ��ȸ ���ν���

--�� �������񰳼� ��ȸ ���ν����� VIEW ����
CREATE OR REPLACE VIEW VIEW_OS
AS
SELECT T.*
FROM
(
    SELECT ROWNUM "NUM", OS_CD "OS_CD", OC_CD "OC_CD", SUB_CD "SUB_CD", PR_ID "PR_ID"
          ,BK_CD "BK_CD", RAT_CD "RAT_CD", SUB_BD "SUB_BD", SUB_ED "SUB_ED"
    FROM TBL_OS
)T;


--�� ���񰳼� ��ü ��ȸ ���ν��� ����













---------------------------------[������ �Է� ����]--------------------------------------------
-- �� ���� ���̺� ������ �Է�
--�� ���� ���� ���� ���ν��� (PRC_PR_INSERT)
-- ������ ����
CREATE SEQUENCE SEQ_PRCODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_PRCODE��(��) �����Ǿ����ϴ�.
    
CREATE OR REPLACE PROCEDURE PRC_PR_INSERT
( VPR_SSN    IN TBL_PR.PR_SSN%TYPE
, VPR_FN     IN TBL_PR.PR_FN%TYPE
, VPR_LN     IN TBL_PR.PR_LN%TYPE
)
IS
    -- ���� ����
    VPR_ID  TBL_PR.PR_ID%TYPE;
    VPR_PW  TBL_PR.PR_PW%TYPE;
    
BEGIN
    -- VPR_PW ���� (���� ��й�ȣ)
    VPR_PW := SUBSTR(VPR_SSN,8);
    
    -- VPR_ID ���� (����ID)
    VPR_ID := 'PR' || LPAD(SEQ_PRCODE.NEXTVAL,3,'0');     

    -- ���� ���� INSERT ������
    INSERT INTO TBL_PR(PR_ID, PR_SSN, PR_FN, PR_LN, PR_PW)
        VALUES(VPR_ID, VPR_SSN, VPR_FN, VPR_LN, VPR_PW);
        
    --Ŀ��
    COMMIT;
END;
--==>> Procedure PRC_PR_INSERT��(��) �����ϵǾ����ϴ�.

--�� ������ �Է�
EXEC PRC_PR_INSERT('750910-1123456', '��','ȣ��'); 
EXEC PRC_PR_INSERT('971009-2123456', '��','����'); 
EXEC PRC_PR_INSERT('750610-1234567', '��','����');
EXEC PRC_PR_INSERT('971224-2123456', '��','�ָ�');
EXEC PRC_PR_INSERT('801010-2123456', '��','�');


--�� ������ Ȯ��
SELECT *
FROM TBL_PR;


--�� �л� ���̺� ������ �Է�
--�� �л� ���� ���� ���ν��� (PRC_ST_INSERT)
-- �л��ڵ� ������ ���� 
CREATE SEQUENCE SEQ_ST_CODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_ST_CODE��(��) �����Ǿ����ϴ�

--�� �л� �Է� ���ν��� �ۼ�
CREATE OR REPLACE PROCEDURE PRC_ST_INSERT
(
  V_ST_SSN  IN TBL_ST.ST_SSN%TYPE
, V_ST_FN   IN TBL_ST.ST_FN%TYPE
, V_ST_LN   IN TBL_ST.ST_LN%TYPE
, V_ST_DT   IN TBL_ST.ST_DT%TYPE    DEFAULT SYSDATE
)
IS
    V_ST_PW         VARCHAR2(10);
    V_ST_ID         VARCHAR2(10);
    V_COUNT         NUMBER;
    DUPLICATE_ERROR EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO V_COUNT
    FROM TBL_ST
    WHERE ST_SSN = V_ST_SSN;
    
    IF V_COUNT = 0
        THEN
        -- �л� ���̵� ���� 
        V_ST_ID := 'ST' || LPAD(SEQ_ST_CODE.NEXTVAL,3,'0');     
        V_ST_PW := SUBSTR(V_ST_SSN,8);   
         -- ���̺� ������ �Է� 
        INSERT INTO TBL_ST(ST_ID, ST_SSN, ST_FN, ST_LN, ST_PW)
        VALUES (V_ST_ID, V_ST_SSN, V_ST_FN, V_ST_LN, V_ST_PW);
        
    ELSE RAISE DUPLICATE_ERROR;
    END IF;
    
    COMMIT;
    
    EXCEPTION
        WHEN DUPLICATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'�̹� �����ϴ� �������Դϴ�.');
                 ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
END;
--==>> Procedure PRC_ST_INSERT��(��) �����ϵǾ����ϴ�.

--�� ������ �Է�
EXEC PRC_ST_INSERT('951102-2234567', '��', '����');
EXEC PRC_ST_INSERT('971224-2234568', '��', '����');
EXEC PRC_ST_INSERT('980709-2233445', '��', '����'); 
EXEC PRC_ST_INSERT('930308-2323232', '��', '�ƺ�'); 

--���̵�, �ֹι�ȣ, ��, �̸�, ��¥, ��й�ȣ
INSERT INTO TBL_ST(ST_ID, ST_SSN, ST_FN, ST_LN, ST_DT, ST_PW) 
       VALUES ('ST001','971006-2234567','��','����',SYSDATE,'2234567');


--�� ������ Ȯ��
SELECT *
FROM TBL_ST;

ALTER TABLE TBL_ST MODIFY ST_LN VARCHAR2(50);
--==>> Table TBL_ST��(��) ����Ǿ����ϴ�.
--==>> ������ -> �� ���ְ� �ٽ� ������ �ϱ�!


--�� ���� ���̺� ������ �Է�
--�� ���� ���� ���ν��� (PRC_CRS_INSERT)
-- ������ ����
CREATE SEQUENCE SEQ_CRS
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==> Sequence SEQ_CRS��(��) �����Ǿ����ϴ�.


--�� PRC_��������  PRC_CRS_INSERT (�ڵ� ������ ����)
--�� ���� �Է� ���ν����� SEQUENCE ����
CREATE SEQUENCE SEQ_CRS
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;


--�� ���� �Է� ���ν��� ����
CREATE OR REPLACE PROCEDURE PRC_CRS_INSERT 
(
    V_CRS_NM    IN  TBL_CRS.CRS_NM%TYPE
)
IS
    V_CRS_CD    TBL_CRS.CRS_CD%TYPE;
    V_DUP_CHAR  CHAR(1);
    V_DUP_NUM   VARCHAR2(3);
    V_CD_ASCII  NUMBER;
    V_COUNT     NUMBER;
    CREATE_CODE_ERROR EXCEPTION;
    DUPLICATE_ERROR   EXCEPTION;
BEGIN
    --������ �ߺ� ���� Ȯ��
    SELECT COUNT(*) INTO V_COUNT
    FROM TBL_CRS
    WHERE CRS_NM = V_CRS_NM;
    
    --�ߺ��� ���� �߻�
    IF V_COUNT >= 1
        THEN RAISE DUPLICATE_ERROR;
    END IF;
    
    --ù �� ���ڰ� ���ĺ� �빮�� �� �������� Ȯ��
    V_CD_ASCII := TO_NUMBER(ASCII(SUBSTR(V_CRS_NM,1,1))) + TO_NUMBER(ASCII(SUBSTR(V_CRS_NM,2,1)));
    
    IF (V_CD_ASCII >= 130 AND V_CD_ASCII <= 180)
        THEN
            V_CRS_CD := SUBSTR(V_CRS_NM,1,2) || LPAD(SEQ_CRS.NEXTVAL,3,'0');
            INSERT INTO TBL_CRS(CRS_CD, CRS_NM) VALUES (V_CRS_CD, V_CRS_NM);
    ELSE
        RAISE CREATE_CODE_ERROR;
    END IF;
    
    -- Ŀ��
    COMMIT;
    
    EXCEPTION
        WHEN DUPLICATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001, '�̹� �����ϴ� �������Դϴ�.');
                 ROLLBACK;
        WHEN CREATE_CODE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20007,'��ȿ���� ���� �������Դϴ�.');
                 ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
END;
--==> Procedure PRC_CRS_INSERT��(��) �����ϵǾ����ϴ�.

--�� ������ �Է�
EXEC PRC_CRS_INSERT('SW �ڹ� Ǯ���� �缺����');
EXEC PRC_CRS_INSERT('SW �ڹ� ����Ʈ�ص� �缺����');
EXEC PRC_CRS_INSERT('BD �����Ϳ� AI');
EXEC PRC_CRS_INSERT('BD �����Ϳ� ���̽�');
EXEC PRC_CRS_INSERT('IS �����ý��� ������ �缺���� ');
EXEC PRC_CRS_INSERT('IS �����ý��� ���� �� ������ŷ');
EXEC PRC_CRS_INSERT('DC ����Ʈ ������ �� ���ø����̼� ����');
EXEC PRC_CRS_INSERT('CC Ŭ���� ��ǻ�� �����Ͼ� �缺����');


ALTER TABLE TBL_CRS MODIFY CRS_NM VARCHAR2(100);
--==>> Table TBL_CRS��(��) ����Ǿ����ϴ�.
--==>> �������ν��� ������ -> �� ���� -> �ٽ� �������ν��� ������ �� ������ �Է��ϱ�

-- ���̺� Ȯ��
SELECT *
FROM TBL_CRS;


--�� ���� ���̺� ������ �Է�
--�� ���� ��� ���ν���(������ VER.)
-- ������ : SEQUENCE SEQ_SUB_CODE
CREATE SEQUENCE SEQ_SUB_CODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_SUB_CODE��(��) �����Ǿ����ϴ�.

--   ���ν���: PRC_SUB_INSERT(�����)
CREATE OR REPLACE PROCEDURE PRC_SUB_INSERT
(
   V_SUB_NM    IN  TBL_SUB.SUB_NM%TYPE  
)
IS
    V_SUB_CD                    TBL_SUB.SUB_CD%TYPE;
    V_COUNT                     NUMBER;
    ALREADY_REGISTERED_ERROR    EXCEPTION;

BEGIN
    --�����ڵ� ����
    V_SUB_CD := SUBSTR(V_SUB_NM, 1, 1) || LPAD(SEQ_SUB_CODE.NEXTVAL,3,'0');
    
    --������ �����ڵ��� �ִ��� üũ
    SELECT COUNT(*) INTO V_COUNT
    FROM TBL_SUB
    WHERE SUB_CD = V_SUB_CD;
    
    IF (V_COUNT > 0)
        THEN RAISE ALREADY_REGISTERED_ERROR;
    ELSE
        INSERT INTO TBL_SUB(SUB_CD, SUB_NM) VALUES(V_SUB_CD, V_SUB_NM);
    END IF; 
    
    COMMIT;
     
    EXCEPTION
        WHEN ALREADY_REGISTERED_ERROR
             THEN RAISE_APPLICATION_ERROR(-20001, '�̹� �����ϴ� �������Դϴ�.');
             ROLLBACK;
        WHEN OTHERS
             THEN ROLLBACK;
END;

--�� ������ �Է�
EXEC PRC_SUB_INSERT('JAVA');
EXEC PRC_SUB_INSERT('JAVA');
EXEC PRC_SUB_INSERT('JAVA');
EXEC PRC_SUB_INSERT('ORACLE');
EXEC PRC_SUB_INSERT('HTML');

-- Ȯ��
SELECT *
FROM TBL_SUB;



--�� ���� ���̺� ������ �Է�
-- ������ ����
CREATE SEQUENCE SEQ_RAT
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==> Sequence SEQ_RAT��(��) �����Ǿ����ϴ�.



--�� PRC_�����Է� PRC_RAT_INSERT
CREATE OR REPLACE PROCEDURE PRC_RAT_INSERT
( V_RAT_AT      TBL_RAT.RAT_AT%TYPE
, V_RAT_WT      TBL_RAT.RAT_WT%TYPE
, V_RAT_PT      TBL_RAT.RAT_PT%TYPE
)

IS
    V_RAT_CD    TBL_RAT.RAT_CD%TYPE;
    PROPORTION_ERROR    EXCEPTION;
    
BEGIN
    
    -- �����ڵ� ����
    V_RAT_CD := 'RT' || LPAD(SEQ_RAT.NEXTVAL,3,'0');
    
    -- ��ü ������ 100�� ���� ���� ��� INSERT
    IF ( (V_RAT_AT + V_RAT_WT + V_RAT_PT) = 100 )
     THEN INSERT INTO TBL_RAT (RAT_CD, RAT_AT, RAT_WT, RAT_PT) 
          VALUES (V_RAT_CD,V_RAT_AT, V_RAT_WT, V_RAT_PT);
    -- ������ ���� ���� �߻�
    ELSE RAISE PROPORTION_ERROR;
        
    END IF;
    
    
    -- Ŀ��
    COMMIT;
    
    
    -- ���� ó��
    EXCEPTION
        WHEN PROPORTION_ERROR
            THEN RAISE_APPLICATION_ERROR(-20006, '�� ������ 100�� ���� �����Դϴ�.');
                ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;    
END;
--==>> Procedure PRC_RAT_INSERT��(��) �����ϵǾ����ϴ�.

--�� ������ �Է�
EXEC PRC_RAT_INSERT(20,30,50);
EXEC PRC_RAT_INSERT(10,40,50);

-- Ȯ��
SELECT *
FROM TBL_RAT;


--�� ���� ���̺� ������ �Է�
--�� �������̺�(TBL_BK) ���� ���ν��� 
--�� ������ ������ : SEQUENCE SEQ_SUB_CODE
CREATE SEQUENCE SEQ_SUB_CODE2
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_SUB_CODE��(��) �����Ǿ����ϴ�.

--�� ���� ��� ���ν��� PRC_BK_INSERT(�����)
--�� ������ ������ : SEQUENCE SEQ_BK_CODE
CREATE SEQUENCE SEQ_BK_CODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_BK_CODE��(��) �����Ǿ����ϴ�.

--�� ���� ��� ���ν��� PRC_BK_INSERT(�����)
CREATE OR REPLACE PROCEDURE PRC_BK_INSERT
(
   V_BK_NM    IN  TBL_BK.BK_NM%TYPE  
)
IS
    V_BK_CD                     TBL_BK.BK_CD%TYPE;
    V_COUNT                     NUMBER;
    ALREADY_REGISTERED_ERROR    EXCEPTION;

BEGIN

    V_BK_CD := 'B' || LPAD(SEQ_BK_CODE.NEXTVAL,3,'0');
    

    SELECT COUNT(*) INTO V_COUNT
    FROM TBL_BK
    WHERE BK_CD = V_BK_CD;
    
    IF (V_COUNT > 0)
        THEN RAISE ALREADY_REGISTERED_ERROR;
    ELSE
        INSERT INTO TBL_BK(BK_CD, BK_NM) VALUES(V_BK_CD, V_BK_NM);
    END IF; 
    
    COMMIT;
     
    EXCEPTION
        WHEN ALREADY_REGISTERED_ERROR
             THEN RAISE_APPLICATION_ERROR(-20001, '�̹� �����ϴ� �������Դϴ�.');
             ROLLBACK;
        WHEN OTHERS
             THEN ROLLBACK;
END;
--==>> Procedure PRC_BK_INSERT��(��) �����ϵǾ����ϴ�.

-- �������Է�
EXEC PRC_BK_INSERT('�ڹ��� ����');
EXEC PRC_BK_INSERT('�ڹ��� ����');
EXEC PRC_BK_INSERT('����Ŭ�� ����');

-- Ȯ��
SELECT *
FROM TBL_BK;



--�� �������� ���̺� ������ �Է�
--�� �������� ���� ���ν���
-- ������ ����
CREATE SEQUENCE SEQ_OC
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_OC��(��) �����Ǿ����ϴ�.

CREATE OR REPLACE PROCEDURE PRC_OC_INSERT
( VCRS_CD   IN TBL_OC.CRS_CD%TYPE
, VCRS_BD   IN TBL_OC.CRS_BD%TYPE
, VCRS_ED   IN TBL_OC.CRS_ED%TYPE
, VCRS_RM   IN TBL_OC.CRS_RM%TYPE
)
IS
    -- �ֿ� ���� ����
    VOC_CD  TBL_OC.OC_CD%TYPE;      
    VCRS_NM TBL_CRS.CRS_NM%TYPE;    
    
    -- ���� ���� ���� (��¥)
    OC_DATE_ERROR   EXCEPTION;
        
BEGIN
/*
    -- ���� �߻�
    IF (TO_NUMBER(SYSDATE - VCRS_BD) < 0)
        THEN RAISE OC_DATE_ERROR;
    ELSIF (TO_NUMBER(SYSDATE - VCRS_ED) < 0)
        THEN RAISE OC_DATE_ERROR;
    END IF;
*/   
    -- ������ ã�� VCRS_NM
    SELECT CRS_NM INTO VCRS_NM
    FROM TBL_CRS
    WHERE CRS_CD = VCRS_CD;
    
    -- VOC_CD �������� �ڵ�
     VOC_CD := TO_CHAR('A' || '_' || SUBSTR(VCRS_NM,1,2) || LPAD(SEQ_OC.NEXTVAL,3,'0'));
    
  
    INSERT INTO TBL_OC(OC_CD, CRS_CD, CRS_BD, CRS_ED, CRS_RM)
    VALUES(VOC_CD ,VCRS_CD, VCRS_BD, VCRS_ED, VCRS_RM);
    
    
    COMMIT;
    
/*  
    EXCEPTION
        WHEN OC_DATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20005, '��ȿ���� ���� ��¥�Դϴ�');
                 ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
*/    
    
END;

--�� �������Է�
EXEC PRC_OC_INSERT('SW001', '2021-02-01', '2021-07-09' , 'F��');
EXEC PRC_OC_INSERT('SW002', '2021-03-13', '2021-08-15' , 'H��');

--Ȯ��
SELECT *
FROM TBL_OC;


--�� ���� ���� ���̺� �������Է�
--�� ���񰳼���� ������ : SEQUENCE SEQ_OS_CODE
CREATE SEQUENCE SEQ_OS_CODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_OS_CODE��(��) �����Ǿ����ϴ�.

--���񰳼���� ���ν��� : PRC_OS_INSERT
-- ����ó�� ���� ��
--�� ���񰳼���� ���ν��� : PRC_OS_INSERT
-- PRC_OS_INSERT(���������ڵ�, �����ڵ�, �������̵�, �����ڵ�, �����ڵ�, ������۳�¥, �������ᳯ¥)
-- PRC_OS_INSERT(���������ڵ�, �����ڵ�, �������̵�, �����ڵ�, �����ڵ�, NULL, NULL)
-- PRC_OS_INSERT(���������ڵ�, �����ڵ�, �������̵�, NULL, �����ڵ�, NULL, NULL)
CREATE OR REPLACE PROCEDURE PRC_OS_INSERT
(
    V_OC_CD     IN  TBL_OC.OC_CD%TYPE   -- ������
,   V_SUB_CD    IN  TBL_SUB.SUB_CD%TYPE -- �����
,   V_PR_ID     IN  TBL_PR.PR_ID%TYPE   -- ������ ��
,   V_BK_CD     IN  TBL_BK.BK_CD%TYPE   -- �����
,   V_RAT_CD    IN  TBL_RAT.RAT_CD%TYPE -- ����
,   V_SUB_BD    IN  TBL_OS.SUB_BD%TYPE  -- ������۳�¥ (NULL ����)
,   V_SUB_ED    IN  TBL_OS.SUB_ED%TYPE  -- �������ᳯ¥ (NULL ����)
)
IS

    TEMP                        TBL_OS.OS_CD%TYPE;
    V_OS_CD                     TBL_OS.OS_CD%TYPE;
    V_COUNT                      NUMBER; -- �������� �ߺ� üũ
    V_COUNT1                     NUMBER; -- FK1 ���������ڵ� üũ
    V_COUNT2                     NUMBER; -- FK2 �����ڵ� üũ  
    V_COUNT3                     NUMBER; -- FK3 �������̵� üũ
    V_COUNT4                     NUMBER; -- FK4 �����ڵ� üũ
    V_COUNT5                     NUMBER; -- FK5 �����ڵ� üũ
    
    ALREADY_REGISTERED_ERROR    EXCEPTION; -- �ߺ������� 
    NOT_FOUND_ERROR             EXCEPTION; -- �ܷ�Ű ������ �θ����̺� ��ġ�ϴ� ���� ���� ��
    
BEGIN
    
    -- ���� ���̺��� �����ڵ带 ��Ƽ� EX) J001
    SELECT SUB_CD INTO TEMP
    FROM TBL_SUB
    WHERE SUB_CD = V_SUB_CD;

    -- �տ� E �� �ٿ��� ���񰳼� ���̺��� ���������ڵ�� ����� EX) EJ001
    V_OS_CD := 'E' || TEMP;

    --������ ���������ڵ��� �ִ��� üũ
    SELECT COUNT(*) INTO V_COUNT
    FROM TBL_OS
    WHERE OS_CD = V_OS_CD;

    --FK1 ���������ڵ� üũ
    SELECT COUNT(*) INTO V_COUNT1
    FROM TBL_OC
    WHERE OC_CD = V_OC_CD;

    --FK2 �����ڵ� üũ
    SELECT COUNT(*) INTO V_COUNT2
    FROM TBL_SUB
    WHERE SUB_CD = V_SUB_CD;
    
    --FK3 �������̵� üũ
    SELECT COUNT(*) INTO V_COUNT3
    FROM TBL_PR
    WHERE PR_ID = V_PR_ID;
    
    --FK4 ����� üũ
    SELECT COUNT(*) INTO V_COUNT4
    FROM TBL_BK
    WHERE BK_CD = V_BK_CD;
    
    --FK5 �����ڵ� üũ
    SELECT COUNT(*) INTO V_COUNT5
    FROM TBL_RAT
    WHERE RAT_CD = V_RAT_CD;
    
    
    IF ((V_COUNT = 0) AND (V_COUNT1 = 1) AND (V_COUNT2 = 1) 
        AND (V_COUNT3 = 1) AND (V_COUNT4 = 1) AND (V_COUNT5 = 1))
        THEN
            INSERT INTO TBL_OS(OS_CD, OC_CD, SUB_CD, PR_ID, BK_CD, RAT_CD, SUB_BD, SUB_ED) 
            VALUES(V_OS_CD, V_OC_CD, V_SUB_CD, V_PR_ID, V_BK_CD, V_RAT_CD, V_SUB_BD, V_SUB_ED);
            
    ELSIF (V_COUNT > 0)
        THEN RAISE ALREADY_REGISTERED_ERROR;
    ELSE
        RAISE NOT_FOUND_ERROR;
    END IF; 
    
    COMMIT;
     
    EXCEPTION
        WHEN ALREADY_REGISTERED_ERROR
             THEN RAISE_APPLICATION_ERROR(-20001, '�̹� �����ϴ� �������Դϴ�.');
             ROLLBACK;
        WHEN NOT_FOUND_ERROR
             THEN RAISE_APPLICATION_ERROR(-20002, '�������� �ʴ� �����Ͱ� ���ԵǾ��ֽ��ϴ�.');
        WHEN OTHERS
             THEN ROLLBACK;
END;
--==>> Procedure PRC_OS_INSERT��(��) �����ϵǾ����ϴ�.


--�� ������ �Է�
EXEC PRC_OS_INSERT('A_SW001','J001','PR001','B001','RT001','21/02/01','21/03/01');
EXEC PRC_OS_INSERT('A_SW002','O004','PR005','B002','RT002','21/07/01','21/08/01');
EXEC PRC_OS_INSERT('A_SW001','J002','PR002','B002','RT001','21/05/01','21/07/12');
EXEC PRC_OS_INSERT('A_SW002','J003','PR003','B001','RT002','2021-05-01','2021-07-12');
EXEC PRC_OS_INSERT('A_SW001','J001','PR004','B001','RT001','2021-03-21', '2021-05-05');

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

SELECT *
FROM TBL_OS;

SELECT *
FROM TBL_BK;

--�� �������� ���̺� 
-- ������ ����
CREATE SEQUENCE SEQ_REG
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==> Sequence SEQ_REG��(��) �����Ǿ����ϴ�.


--�� PRC_���������Է� PRC_REG_INSERT
CREATE OR REPLACE PROCEDURE PRC_REG_INSERT
( V_ST_ID   TBL_ST.ST_ID%TYPE   -- �л� ���̵�
, V_OC_CD   TBL_OC.OC_CD%TYPE   -- �������� �ڵ�
, V_REG_DT  TBL_REG.REG_DT%TYPE  DEFAULT SYSDATE
)
IS
    V_REG_CD    TBL_REG.REG_CD%TYPE; --�������� �ڵ�
    V_COUNT_ID     NUMBER;
    V_COUNT_CD     NUMBER;
    INCORRECT_ERROR  EXCEPTION;
    
BEGIN
    
    SELECT COUNT(*) INTO V_COUNT_ID -- �л����̵� ��ġ�ϸ�
    FROM TBL_ST
    WHERE V_ST_ID = ST_ID;
    
    
    SELECT COUNT(*) INTO V_COUNT_CD -- ���������ڵ尡 ��ġ�ϸ�
    FROM TBL_OC
    WHERE V_OC_CD = OC_CD;
    
    IF ( (V_COUNT_ID = 1) AND (V_COUNT_CD = 1) )
        THEN
            -- ���������ڵ� ����
            V_REG_CD := 'RG' || LPAD(SEQ_REG.NEXTVAL,3,'0');
            
            -- TBL_REG ���̺� ������ �Է�
            INSERT INTO TBL_REG(REG_CD, ST_ID, OC_CD) 
            VALUES (V_REG_CD, V_ST_ID, V_OC_CD);
        
        -- �л����̵� ���������ڵ尡 ���� ��� ���� �߻�
        ELSE RAISE INCORRECT_ERROR;
    END IF;
    
        
    -- Ŀ��
    COMMIT;

    
    -- ����ó��
    EXCEPTION
        WHEN INCORRECT_ERROR
            THEN RAISE_APPLICATION_ERROR(-20004, '���̵� ���������ڵ尡 ��ġ���� �ʽ��ϴ�.');
                ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
END;
--==> Procedure PRC_REG_INSERT��(��) �����ϵǾ����ϴ�.

--�� ������ �Է�
EXEC PRC_REG_INSERT('ST001','A_SW001');
EXEC PRC_REG_INSERT('ST011','A_SW001');
EXEC PRC_REG_INSERT('ST013','A_SW002');
-->> �ڽ��� ���� �л����� ��ȣ�� �ٲ��ֱ�

-- Ȯ��
SELECT *
FROM TBL_REG;


--�� PRC_����������ȸ  PRC_REG_LOOKUP
-- �л� �̸�, ������, ��������, �������� ����
CREATE OR REPLACE PROCEDURE PRC_REG_LOOKUP
(
    V_ST_ID     IN TBL_ST.ST_ID%TYPE    -- �л����̵�
)
IS
    V_ST_FN       TBL_ST.ST_FN%TYPE;   -- �л� ��
    V_ST_LN       TBL_ST.ST_LN%TYPE;   -- �л� �̸�
    V_CRS_NM      TBL_CRS.CRS_NM%TYPE; -- ������
    V_SUB_NM      TBL_SUB.SUB_NM%TYPE; -- �����
    V_SC_AT       TBL_SC.SC_AT%TYPE;   -- ���
    V_SC_WT       TBL_SC.SC_WT%TYPE;   -- �ʱ�
    V_SC_PT       TBL_SC.SC_PT%TYPE;   -- �Ǳ�

    V_OC_CD       TBL_OC.OC_CD%TYPE;   -- ���������ڵ�
    V_CRS_CD      TBL_CRS.CRS_CD%TYPE;  -- �����ڵ�
    V_SUB_CD      TBL_SUB.SUB_CD%TYPE;  -- �����ڵ�
    V_REG_CD      TBL_REG.REG_CD%TYPE; -- ������û�ڵ�
    
    V_SC_TOT        NUMBER;             -- �������� ����
    
    V_MINNUM        NUMBER;
    V_MAXNUM        NUMBER;
    
BEGIN

    SELECT MIN(ROWNUM),MAX(ROWNUM) INTO V_MINNUM,V_MAXNUM
    FROM TBL_REG
    WHERE ST_ID = V_ST_ID;
    
    -- ��������-���������ڵ�, �������� - ������û�ڵ�
    SELECT OC_CD, REG_CD INTO V_OC_CD, V_REG_CD
    FROM TBL_REG
    WHERE ST_ID = V_ST_ID;
    
    LOOP
    
        -- �л� �̸�
        SELECT ST_FN, ST_LN INTO V_ST_FN, V_ST_LN
        FROM TBL_ST
        WHERE ST_ID = V_ST_ID;
        
        -- �������� - ���������ڵ� / �������� - ���������ڵ� �� �����ڵ�
        SELECT CRS_CD INTO V_CRS_CD
        FROM TBL_OC
        WHERE OC_CD = V_OC_CD;
        
        -- ���� - �����ڵ� / �������� - �����ڵ� �� ������
        SELECT CRS_NM INTO V_CRS_NM
        FROM TBL_CRS
        WHERE CRS_CD = V_CRS_CD;
        
        -- ���񰳼� - ���������ڵ� / �������� - ���������ڵ� �� �����ڵ�
        SELECT SUB_CD INTO V_SUB_CD
        FROM TBL_OS
        WHERE OC_CD = V_OC_CD;
        
        -- ���� - �����ڵ� / ���񰳼� - �����ڵ� �� �����
        SELECT SUB_NM INTO V_SUB_NM
        FROM TBL_SUB
        WHERE SUB_CD = V_SUB_CD;
        
        -- �����Է� - ������û�ڵ� / �������� - ������û�ڵ� �� ����
        SELECT SC_AT, SC_WT, SC_PT INTO V_SC_AT, V_SC_WT, V_SC_PT
        FROM TBL_SC
        WHERE REG_CD = V_REG_CD;
        
        
        V_SC_TOT := (V_SC_AT + V_SC_WT + V_SC_PT);   --����
        
    
        -- �л� �̸�, ������, ��������, �������� ����
        -- �л� ���� ���
        DBMS_OUTPUT.PUT_LINE(V_MINNUM || '.');
        DBMS_OUTPUT.PUT_LINE('�л�ID : ' || V_ST_ID);
        DBMS_OUTPUT.PUT_LINE('������ : ' || V_CRS_NM);
        DBMS_OUTPUT.PUT_LINE('�������� : ' || V_SUB_NM);
        DBMS_OUTPUT.PUT_LINE('�������� ���� : ' || V_SC_TOT);
        
        
        V_MINNUM := V_MINNUM+1;
        
        EXIT WHEN V_MINNUM > V_MAXNUM;
    
    END LOOP;
END;

CREATE OR REPLACE PROCEDURE PRC_REG_LOOKUP
(
    V_ST_ID     IN TBL_ST.ST_ID%TYPE    -- �л����̵�
)
IS
    V_ST_FN       TBL_ST.ST_FN%TYPE;   -- �л� ��
    V_ST_LN       TBL_ST.ST_LN%TYPE;   -- �л� �̸�
    V_CRS_NM      TBL_CRS.CRS_NM%TYPE; -- ������
    V_SUB_NM      TBL_SUB.SUB_NM%TYPE; -- �����
    V_SC_AT       TBL_SC.SC_AT%TYPE;   -- ���
    V_SC_WT       TBL_SC.SC_WT%TYPE;   -- �ʱ�
    V_SC_PT       TBL_SC.SC_PT%TYPE;   -- �Ǳ�

    V_OC_CD       TBL_OC.OC_CD%TYPE;   -- ���������ڵ�
    V_CRS_CD      TBL_CRS.CRS_CD%TYPE;  -- �����ڵ�
    V_SUB_CD      TBL_SUB.SUB_CD%TYPE;  -- �����ڵ�
    V_REG_CD      TBL_REG.REG_CD%TYPE; -- ������û�ڵ�
    
    V_SC_TOT        NUMBER;             -- �������� ����
    
    V_MINNUM        NUMBER;
    V_MAXNUM        NUMBER;
    
BEGIN

    SELECT MIN(ROWNUM),MAX(ROWNUM) INTO V_MINNUM,V_MAXNUM
    FROM TBL_REG
    WHERE ST_ID = V_ST_ID;
    
    
    
    LOOP
        --������û�ڵ�, ���������ڵ�
        SELECT OC_CD, REG_CD INTO V_OC_CD, V_REG_CD
        FROM TBL_REG
        WHERE ST_ID = V_ST_ID;
        
        -- �л� �̸�
        SELECT ST_FN, ST_LN INTO V_ST_FN, V_ST_LN
        FROM TBL_ST
        WHERE ST_ID = V_ST_ID;
        
        
        -- ���� - �����ڵ� / �������� - �����ڵ� �� ������
        SELECT CRS_NM INTO V_CRS_NM
        FROM TBL_CRS
        WHERE CRS_CD = (SELECT CRS_CD
                        FROM TBL_OC
                        WHERE OC_CD = V_OC_CD);
         
        
        -- ���� - �����ڵ� / ���񰳼� - �����ڵ� �� �����
        SELECT SUB_NM INTO V_SUB_NM
        FROM TBL_SUB
        WHERE SUB_CD = (SELECT SUB_CD 
                        FROM TBL_OS
                        WHERE OC_CD = V_OC_CD);
        
        
        -- �����Է� - ������û�ڵ� / �������� - ������û�ڵ� �� ����
        SELECT SC_AT, SC_WT, SC_PT INTO V_SC_AT, V_SC_WT, V_SC_PT
        FROM TBL_SC
        WHERE REG_CD = V_REG_CD;
        
        
        V_SC_TOT := (V_SC_AT + V_SC_WT + V_SC_PT);   --����
        
    
        -- �л� �̸�, ������, ��������, �������� ����
        -- �л� ���� ���
        DBMS_OUTPUT.PUT_LINE(V_MINNUM || '.');
        DBMS_OUTPUT.PUT_LINE('�л��̸� : ' || V_ST_FN || V_ST_LN);
        DBMS_OUTPUT.PUT_LINE('������ : ' || V_CRS_NM);
        DBMS_OUTPUT.PUT_LINE('�������� : ' || V_SUB_NM);
        DBMS_OUTPUT.PUT_LINE('�������� ���� : ' || V_SC_TOT);
        
        
        V_MINNUM := V_MINNUM+1;
        
        EXIT WHEN V_MINNUM > V_MAXNUM;
    
    END LOOP;
    

END;

EXEC PRC_REG_LOOKUP('ST001');

SELECT *
FROM TBL_REG;

SELECT *
FROM TBL_OC;

EXEC PRC_REG_LOOKUP('ST011');

SELECT *
FROM TBL_ST;

--�� �ߵ�Ż�� ���̺� �������Է�
--�� �ߵ�Ż���ڵ� ������ ������ ����
CREATE SEQUENCE SEQ_QUIT
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;


--�� �ߵ�Ż�� �Է� ���ν��� ����
CREATE OR REPLACE PROCEDURE PRC_QUIT_INSERT
(   V_REG_CD    IN TBL_QT.REG_CD%TYPE
,   V_QT_DT     IN TBL_QT.QT_DT%TYPE   DEFAULT SYSDATE
)
IS
    V_QT_CD             VARCHAR2(10);
    V_COUNT             NUMBER;
    DUPLICATE_ERROR     EXCEPTION;
BEGIN
    --������û�ڵ� �ߺ� ���� Ȯ��
    SELECT COUNT(*) INTO V_COUNT
    FROM TBL_QT
    WHERE REG_CD = V_REG_CD;
    
    --�ߺ��� �ƴ� ��� ������ �Է�
    IF V_COUNT = 0
        THEN
            --�ߵ�Ż���ڵ� ����
            V_QT_CD := 'Q' || LPAD(SEQ_QUIT.NEXTVAL,3,'0');
            --TBL_REG ���̺� ������ �Է�
            INSERT INTO TBL_QT(QT_CD,REG_CD) VALUES(V_QT_CD,V_REG_CD);
    --�ߺ��� ��� ���� �߻�
    ELSE RAISE DUPLICATE_ERROR;
    END IF;
    
    --Ŀ��
    COMMIT;
    
    --����ó��
    EXCEPTION
        WHEN DUPLICATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'�̹� �����ϴ� �������Դϴ�.');
                 ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
END;

--�� �������Է�
EXEC PRC_QUIT_INSERT('RG001',SYSDATE);
EXEC PRC_QUIT_INSERT('RG002',SYSDATE);

-- Ȯ��
SELECT *
FROM TBL_QT;



--�� ���� ���̺� ������ �Է�
--�� ���� �Է� ���ν��� �ۼ�
CREATE OR REPLACE PROCEDURE PRC_SC_INSERT
(
    V_REG_CD    IN TBL_REG.REG_CD%TYPE   -- ������û �ڵ� 
,   V_OS_CD     IN TBL_OS.OS_CD%TYPE    -- �������� �ڵ� 
,   V_SC_AT     IN TBL_SC.SC_AT%TYPE    -- ��� 
,   V_SC_WT     IN TBL_SC.SC_WT%TYPE    -- �ʱ� 
,   V_SC_PT     IN TBL_SC.SC_PT%TYPE    -- �Ǳ� 
)
IS
    V_SC_CD             TBL_SC.SC_CD%TYPE;      -- ���� �ڵ� 
    V_COUNT_RCD         NUMBER;                 -- ������û �ڵ� ī��Ʈ
    V_COUNT_OCD         NUMBER;                 -- OS_CD�� ���Ӹ� = ���񰳼��ڵ� ī��Ʈ
    DUPLICATE_ERROR     EXCEPTION;
    TOTAL_SC_ERROR      EXCEPTION;
    
BEGIN
    SELECT COUNT(*) INTO V_COUNT_RCD
    FROM TBL_REG
    WHERE REG_CD = V_REG_CD;     
    
    SELECT COUNT(*) INTO V_COUNT_OCD
    FROM TBL_OS
    WHERE OS_CD = V_OS_CD;     

    
    IF (V_COUNT_RCD = 1) AND (V_COUNT_OCD = 1)
        THEN
        V_SC_CD := 'SC' || LPAD(SEQ_ST_CODE.NEXTVAL,3,'0');     
           
    ELSE RAISE DUPLICATE_ERROR;
    END IF;
     
    IF (V_SC_AT + V_SC_WT + V_SC_PT) > 100
            THEN RAISE TOTAL_SC_ERROR;
    END IF;

         -- ���̺� ������ �Է� 
    INSERT INTO TBL_SC(SC_CD, REG_CD, OS_CD, SC_AT, SC_WT, SC_PT)
    VALUES (V_SC_CD, V_REG_CD, V_OS_CD, V_SC_AT, V_SC_WT, V_SC_PT);
    
    COMMIT;
    
   EXCEPTION
        WHEN DUPLICATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'�̹� �����ϴ� �������Դϴ�.');
                 ROLLBACK;
        WHEN TOTAL_SC_ERROR
            THEN RAISE_APPLICATION_ERROR(-20003,'���� ������ ����Ͽ� �Է��Ͽ� �ֽʽÿ�.');
        WHEN OTHERS
            THEN ROLLBACK;
END;
--==> Procedure PRC_SC_INSERT��(��) �����ϵǾ����ϴ�.

--�� ������ �Է�
EXEC PRC_SC_INSERT('RG001', 'A006', 5,10,20);
EXEC PRC_SC_INSERT('RG002', 'A006', 10,10,10);

SELECT *
FROM TBL_SC;