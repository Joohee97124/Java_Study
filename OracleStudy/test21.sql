--�� ���� ���� ���� ���ν��� (PRC_PR_DELETE)
CREATE OR REPLACE PROCEDURE PRC_PR_DELETE
( VPR_ID    IN TBL_PR.PR_ID%TYPE
)
IS
    VOS_CD  TBL_OS.OS_CD%TYPE;
    
BEGIN
    -- �ڽ����̺�2�� �����Է� ���̺��� ���������ڵ尡 VOS_CD�� ������ ��� ����
    -- OC_�ڵ� Ȯ��
    SELECT OS_CD INTO VOS_CD
    FROM TBL_OS
    WHERE PR_ID = VPR_ID;  
   
    -- ���� ����
    DELETE
    FROM TBL_SC
    WHERE OS_CD = VOS_CD;
    
    -- �ڽ����̺��� �������� ���̺��� �������̵� VPR_ID�� ������ ��� ����
    DELETE
    FROM TBL_OS
    WHERE PR_ID = VPR_ID;    


    -- ���� ���� ����
    DELETE
    FROM TBL_PR
    WHERE PR_ID = VPR_ID;
    
    --Ŀ��
    COMMIT;
    
END;

SELECT *
FROM TBL_PR;

EXEC PRC_PR_DELETE('PR001');




--�� �� ����
CREATE OR REPLACE VIEW VIEW_PR_SC
AS
SELECT T.*
FROM
(
    SELECT ROWNUM "NUM", PR_ID "PR_ID", PR_SSN "PR_SSN", PR_FN "PR_FN", PR_LN "PR_LN", PR_DT "PR_DT", PR_PW "PR_PW"
    FROM TBL_PR
)T;

CREATE OR REPLACE VIEW VIEW_SC_PR
AS
SELECT T.*
FROM
(
    SELECT ROWNUM "NUM2", REG_CD"REG_CD", ST_ID"ST_ID", OC_CD"OC_CD", REG_DT "REG_DT"
    FROM TBL_REG
)T;

--�� Ư�� ������ ���� ���� ���� ��ȸ ���ν��� (����������)
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
    
    V_OS_CD      TBL_OS.OS_CD%TYPE;   -- ���񰳼��ڵ�
    V_SUB_CD     TBL_SUB.SUB_CD%TYPE; -- �����ڵ�
    
    V_REG_CD     TBL_REG.REG_CD%TYPE; -- ���������ڵ�
    V_ST_ID      TBL_ST.ST_ID%TYPE;   -- �л� �ڵ� 
    
    V_OC_CD      TBL_OC.OC_CD%TYPE;   -- ���������ڵ�
    V_CRS_CD     TBL_OC.CRS_CD%TYPE;  -- �����ڵ�
    VCRS_NM      TBL_CRS.CRS_NM%TYPE; -- ������
    
    V_ST_FN      TBL_ST.ST_FN%TYPE;   -- �л� ��
    V_ST_LN      TBL_ST.ST_LN%TYPE;   -- �л� �̸�
    
    V_SC_CD      TBL_SC.SC_CD%TYPE;   -- �����ڵ�
    V_SC_AT      TBL_SC.SC_AT%TYPE;   -- ���
    V_SC_WT      TBL_SC.SC_WT%TYPE;   -- �ʱ�
    V_SC_PT      TBL_SC.SC_PT%TYPE;   -- �Ǳ�
    
    V_SC_TT     NUMBER; --����
    V_SC_RK     NUMBER; --���
    
    
    V_NUM        NUMBER;
    V_ROWNUM     NUMBER;
    V_NUM2       NUMBER;
    V_ROWNUM2    NUMBER;
    
BEGIN
    SELECT MIN(ROWNUM),MAX(ROWNUM) INTO V_NUM,V_ROWNUM
    FROM TBL_OS
    WHERE PR_ID = V_PR_ID;

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
        
        -- ���� �����ڵ� ã��
        SELECT CRS_CD INTO V_CRS_CD
        FROM TBL_OC
        WHERE OC_CD = V_OC_CD;
        
        -- ���� ������ ã��
        SELECT CRS_NM INTO VCRS_NM
        FROM TBL_CRS
        WHERE CRS_CD = V_CRS_CD;
        
        
        LOOP
            -- �л��� ��ȣ ����
            SELECT MIN(ROWNUM),MAX(ROWNUM) INTO V_NUM2,V_ROWNUM2
            FROM TBL_REG
            WHERE OC_CD = V_OC_CD;
            
            -- ���������ڵ� ����
            SELECT REG_CD INTO V_REG_CD
            FROM TBL_REG
            WHERE OC_CD = V_OC_CD;
            
            -- �л� �ڵ� ����
            SELECT ST_ID INTO V_ST_ID
            FROM TBL_REG
            WHERE REG_CD = V_REG_CD;
            
            -- �л� �� ��������
            SELECT ST_FN INTO V_ST_FN
            FROM TBL_ST
            WHERE ST_ID = V_ST_ID;
            
            -- �л� �̸� ��������
            SELECT ST_LN INTO V_ST_LN
            FROM TBL_ST
            WHERE ST_ID = V_ST_ID;
            
            -- ���� 
            -- ���� �ڵ� ��������
            SELECT SC_CD INTO V_SC_CD
            FROM TBL_SC
            WHERE REG_CD = V_REG_CD;
            
            -- ���
            SELECT SC_AT INTO V_SC_AT
            FROM TBL_SC
            WHERE REG_CD = V_REG_CD;
            
            -- �ʱ�
            SELECT SC_WT INTO V_SC_WT
            FROM TBL_SC
            WHERE REG_CD = V_REG_CD;
            
            -- �Ǳ�
            SELECT SC_PT INTO V_SC_PT
            FROM TBL_SC
            WHERE REG_CD = V_REG_CD; 
            
            -- ����
            SELECT (SC_AT + SC_WT + SC_PT) INTO V_SC_TT
            FROM TBL_SC
            WHERE SC_CD = V_SC_CD;
            
            -- ���
            SELECT RANK() OVER (ORDER BY (SC_AT + SC_WT + SC_PT) DESC) INTO V_SC_RK
            FROM TBL_SC
            WHERE SC_CD = V_SC_CD;
            
            -- ������ �л� ���� ���� ���        
            DBMS_OUTPUT.PUT_LINE(V_NUM || '.');
            DBMS_OUTPUT.PUT_LINE('�л� �̸� : ' || V_ST_FN || V_ST_LN );
            DBMS_OUTPUT.PUT_LINE('������ : '|| VCRS_NM );
            DBMS_OUTPUT.PUT_LINE('����� : ' || V_SUB_NM  );
            DBMS_OUTPUT.PUT_LINE('���� �Ⱓ : ' || V_SUB_BD || '~' || V_SUB_ED );
            DBMS_OUTPUT.PUT_LINE('����� : ' || V_BK_NM );
            DBMS_OUTPUT.PUT_LINE('��� : ' || V_SC_AT );
            DBMS_OUTPUT.PUT_LINE('�ʱ� : ' || V_SC_WT );
            DBMS_OUTPUT.PUT_LINE('�Ǳ� : ' || V_SC_PT );
            DBMS_OUTPUT.PUT_LINE('���� : ' || V_SC_TT );
            DBMS_OUTPUT.PUT_LINE('��� : ' || V_SC_RK );
        
        V_NUM2 := V_NUM2+1;
        
        EXIT WHEN V_NUM2 > V_ROWNUM2;
        END LOOP;
        
        V_NUM := V_NUM+1;
        
        EXIT WHEN V_NUM > V_ROWNUM;
    END LOOP;
END;



EXEC PRC_PR_LOOKUP('PR002');

SELECT *
FROM TBL_PR;

SELECT *
FROM TBL_OS;

