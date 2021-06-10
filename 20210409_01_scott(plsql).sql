SELECT USER
FROM DUAL;
--==>> SCOTT

--�� TBL_STUDENT ���̺���
--   ��ȭ��ȣ�� �ּ� �����͸� �����ϴ� (�����ϴ�) ���ν����� �ۼ��Ѵ�.
--   ��, ID �� PW �� ��ġ�ϴ� ��쿡�� ������ ������ �� �ֵ��� �ۼ��Ѵ�.
--   ���ν��� �� : PRC_STUDENTS_UPDATE
/*
���� ��)
EXEC PRC_STUDENTS_UPDATE('superman', 'java006$', '010-9999-9999', '��� �ϻ�');

���ν��� ȣ��� ó���� ��� )
superman	������	010-9999-9999	��� �ϻ�
*/
CREATE OR REPLACE PROCEDURE PRC_STUDENTS_UPDATE
( V_ID      IN TBL_STUDENTS.ID%TYPE
, V_PW      IN TBL_IDPW.PW%TYPE
, V_TEL     IN TBL_STUDENTS.TEL%TYPE
, V_ADDR    IN TBL_STUDENTS.ADDR%TYPE
)
IS
    
BEGIN
/*
    SELECT *
    FROM TBL_STUDENTS S LEFT JOIN TBL_IDPW I 
    ON S.ID = I.ID;
*/
    
    --UPDATE�� 
    UPDATE TBL_STUDENTS
    SET TEL = V_TEL
      , ADDR = V_ADDR
    WHERE ID = V_ID
        AND (SELECT PW
             FROM TBL_IDPW
             WHERE ID = V_ID) = V_PW;
        
    -- Ŀ��
    COMMIT;

END;
--==>> Procedure PRC_STUDENTS_UPDATE��(��) �����ϵǾ����ϴ�.


--------------------[������ Ǯ��] ---------------------------------------------
CREATE OR REPLACE PROCEDURE PRC_STUDENTS_UPDATE
( V_ID      IN TBL_IDPW.ID%TYPE
, V_PW      IN TBL_IDPW.PW%TYPE
, V_TEL     IN TBL_STUDENTS.TEL%TYPE
, V_ADDR    IN TBL_STUDENTS.ADDR%TYPE
)
IS
BEGIN
    -- UPDATE ������ ����
    /*
    UPDATE (SELECT I.ID, I.PW, S.TEL, S.ADDR
    FROM TBL_IDPW I JOIN TBL_STUDENTS S
    ON I.ID = S.ID) T
    SET T.TEL = �Է¹��� ��ȭ��ȣ
      , T.ADDR = �Է¹��� �ּ�
    WHERE T.ID = �Է¹������̵�
      AND T.PW = �Է¹����н�����;
    */
    
    UPDATE (SELECT I.ID, I.PW, S.TEL, S.ADDR
    FROM TBL_IDPW I JOIN TBL_STUDENTS S
    ON I.ID = S.ID) T
    SET T.TEL = V_TEL
      , T.ADDR = V_ADDR
    WHERE T.ID = V_ID
      AND T.PW = V_PW;
      
    --Ŀ��
    COMMIT;

END;
--==>> Procedure PRC_STUDENTS_UPDATE��(��) �����ϵǾ����ϴ�.


--�� TBL_INSA ���̺��� ������� �ű� ������ �Է� ���ν����� �ۼ��Ѵ�.
--   NUM, NAME, SSN, IBSADATE, CITY, TEL, BUSEO, JIKWI, BASICPAY, SUDANG 
--   ������ ���� �ִ� ��� ���̺� ������ �Է� ��
--   NUM �׸�(�����ȣ)�� ����
--   ���� �ο��� �����ȣ ������ ��ȣ�� �� ���� ��ȣ��
--   �ڵ����� �Է� ó�� �� �� �ִ� ���ν����� �����Ѵ�
--   ���ν��� �� : PRC_INSA_INSERT(NAME, SSN, IBSADATE, CITY, TEL, BUSEO, JIKWI, BASICPAY, SUDANG )
/*
���� ��)
EXEC PRC_INSA_INSERT('������', '971006-2234567',SYSDATE , '����', '010-5555-5555
                    , '������', '�븮', 50000000, 5000000 );

���ν��� ȣ��� ó���� ��� )
1061 ������ 971006-2234567 SYSDATE ���� 010-5555-5555 ������ �븮 50000000 5000000

*/
--[������ Ǯ��]
CREATE OR REPLACE PROCEDURE PRC_INSA_INSERT
( V_NAME        TBL_INSA.NAME%TYPE
, V_SSN         TBL_INSA.SSN%TYPE
, V_IBSADATE    TBL_INSA.IBSADATE%TYPE
, V_CITY        TBL_INSA.CITY%TYPE
, V_TEL         TBL_INSA.TEL%TYPE
, V_BUSEO       TBL_INSA.BUSEO%TYPE
, V_JIKWI       TBL_INSA.JIKWI%TYPE
, V_BASICPAY    TBL_INSA.BASICPAY%TYPE
, V_SUDANG      TBL_INSA.SUDANG%TYPE
)
IS
    -- INSERT ������ ���࿡ �ʿ��� ���� �߰� ����
    -- �� V_NUM
    V_NUM     NUMBER;   --TBL_INSA.NUM%TYPE;
    
BEGIN

    -- ������ ����(V_NUM)�� �� ��Ƴ���
    SELECT MAX(NUM) + 1 INTO V_NUM
    FROM TBL_INSA;
    
    -- INSERT ����
    INSERT INTO TBL_INSA(NUM, NAME, SSN, IBSADATE, CITY, TEL, BUSEO, JIKWI, BASICPAY, SUDANG)
    VALUES (V_NUM,V_NAME, V_SSN, V_IBSADATE, V_CITY, V_TEL, V_BUSEO, V_JIKWI, V_BASICPAY, V_SUDANG);
    
    
    -- COMMIT
    COMMIT;
           
END;
--==> Procedure PRC_INSA_INSERT��(��) �����ϵǾ����ϴ�.



--�� TBL_��ǰ, TBL_�԰� ���̺��� �������...
--   TBL_�԰� ���̺� ������ �Է� �� (��, �԰� �̺�Ʈ �߻� ��)
--   TBL_��ǰ ���̺��� �������� �Բ� ������ �� �ִ� ����� ����
--   ���ν����� �ۼ��Ѵ�.
--   ��, �� �������� �԰��ȣ�� �ڵ� ���� ó���ȴ� (������ ��� X)
--   TBL_�԰� ���̺� ���� �÷�
--   �� �԰��ȣ, ��ǰ�ڵ�, �԰�����, �԰����, �԰�ܰ�
--   ���ν����� : PRC_�԰�_INSERT(��ǰ�ڵ�, �԰����, �԰�ܰ�)

--�� TBL_�԰� ���̺� �԰� �̺�Ʈ �߻� ��...
--   ���� ���̺��� ����Ǿ��� �ϴ� ����
--   �� INSERT �� TBL_�԰�
--      INSERT INTO TBL_�԰�(�԰��ȣ, ��ǰ�ڵ�, �԰�����, �԰����, �԰�ܰ�)
--      VALUES(1, 'H001', SYSDATE, 20, 900)
--   �� UPDATE �� TBL_��ǰ
--      UPDATE TBL_��ǰ
--      SET ������ = ���������� + 20 (�� �԰����)
--      WHERE ��ǰ�ڵ� = 'H001';

CREATE OR REPLACE PROCEDURE PRC_�԰�_INSERT
( V_��ǰ�ڵ�    IN TBL_��ǰ.��ǰ�ڵ�%TYPE
, V_�԰����    IN TBL_�԰�.�԰����%TYPE
, V_�԰�ܰ�    IN TBL_�԰�.�԰�ܰ�%TYPE
)
IS
  -- �Ʒ��� �������� �����ϱ� ���� �ʿ��� ������ ������ ����
  V_�԰��ȣ         TBL_�԰�.�԰��ȣ%TYPE    := 0;
  V_�԰�����         TBL_�԰�.�԰�����%TYPE    := SYSDATE;
  
BEGIN
  -- ������ ����(V_�԰��ȣ)�� �� ��Ƴ���
  SELECT NVL(MAX(�԰��ȣ),0) INTO V_�԰��ȣ
  FROM TBL_�԰�;
    
  -- ������ ����
  -- �� INSERT �� TBL_�԰�
  INSERT INTO TBL_�԰�(�԰��ȣ, ��ǰ�ڵ�, �԰����, �԰�ܰ�)
  VALUES ((V_�԰��ȣ+1), V_��ǰ�ڵ�, V_�԰����, V_�԰�ܰ�);
  --> �԰����ڴ� DEFAULT �� SYSDATE �� �����Ǿ��ֱ� ������ ���� ��
  
  -- �� UPDATE ���� �� TBL_��ǰ
  UPDATE TBL_��ǰ
  SET ������ = ������ + V_�԰����
  WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;

  
  --Ŀ��
  COMMIT;

  -- ����ó��
  EXCEPTION
        WHEN OTHERS THEN ROLLBACK;
END;



--���� ���ν��� �������� ���� ó�� ����--

--�� �ǽ� ���̺� ���� (TBL_MEMBER) �� 20210409_02_scott.sql ���� ����

--�� TBL_MEMBER ���̺� �����͸� �Է��ϴ� ���ν����� ����
--   ��, �� ���ν����� ���� �����͸� �Է��� ���
--   CITY (����) �׸� '����', '���', '��õ' �� �Է��� �����ϵ��� �����Ѵ�
--   �� ���� ���� ������ ���ν��� ȣ���� ���� �Է��Ϸ��� ���
--   ���� ó���� �Ϸ��� �Ѵ�
--   ���ν����� : PRC_MEMBER_INSERT(�̸�, ��ȭ��ȣ, ����)

CREATE OR REPLACE PROCEDURE PRC_MEMBER_INSERT
( V_NAME    IN TBL_MEMBER.NAME%TYPE
, V_TEL     IN TBL_MEMBER.TEL%TYPE
, V_CITY    IN TBL_MEMBER.CITY%TYPE
)
IS
    -- ���� ������ ���� ������ ���� �ʿ��� ������ ���� ����
    V_NUM   TBL_MEMBER.NUM%TYPE;
    
    -- ����� ���� ���ܿ� ���� ���� ����~!!! CHECK~!!!!
    USER_DEFINE_ERROR EXCEPTION;
    
BEGIN
    --���ν����� ���� �Է� ó���� ���������� �����ؾ� �� ����������
    -- �ƴ����� ���θ� ���� ���� Ȯ���� �� �ֵ��� �ڵ� ����
    IF (V_CITY NOT IN ('����' ,'���', '��õ') )  -- '����' ,'���', '��õ' �� �ϳ��� ������� �ʴٸ�...
        -- ���� �߻� ~!!! CHECK~!!!
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    
    -- ������ ������ �� ��Ƴ���
    SELECT NVL(MAX(NUM), 0) INTO V_NUM  -- 0 OR �ִ밪
    FROM TBL_MEMBER;
    
    -- INSERT ������ ����
    INSERT INTO TBL_MEMBER(NUM, NAME, TEL, CITY)
    VALUES ((V_NUM+1), V_NAME, V_TEL, V_CITY);
    
    --Ŀ��
    COMMIT;
    
    
    -- ����ó��
    /*
    EXCEPTION
        WHEN �̷� ���ܶ��..
            THEN �̷��� ó���ϰ�
        WHEN ���� ���ܶ��
            THEN ������ ó���ض�...
    */
    
    /*
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-�����ڵ�, ��������);
        WHEN ���� ���ܶ��
            THEN ������ ó���ض�..
    */
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001, '����,��õ,��⸸ �Է� �����մϴ�.');
                 ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
END;
--==>> Procedure PRC_MEMBER_INSERT��(��) �����ϵǾ����ϴ�.


--�� TBL_��� ���̺� ������ �Է� �� (��, ��� �̺�Ʈ �߻� ��)
--   TBL_��ǰ ���̺��� �������� �����Ǵ� ���ν����� �ۼ��Ѵ�.
--   ��, ����ȣ�� �԰��ȣ�� ���������� �ڵ� ����,
--   ����, ��� ������ ���������� ���� ���...
--   ��� �׼��� ����� �� �ֵ��� ó���Ѵ�.
--   ���ν����� : PRC_���_INSERT(��ǰ�ڵ�, ������, ���ܰ�)
CREATE OR REPLACE PROCEDURE PRC_���_INSERT
( V_��ǰ�ڵ�    IN TBL_���.��ǰ�ڵ�%TYPE
, V_������    IN TBL_���.������%TYPE
, V_���ܰ�    IN TBL_���.���ܰ�%TYPE
)
IS 
    -- �ֿ� ���� ����
    V_����ȣ  TBL_���.����ȣ%TYPE;
    V_������  TBL_��ǰ.������%TYPE;
    Z_������  TBL_��ǰ.������%TYPE;   -- ���� �������� ������ ����
    
    -- ����� ���� ���ܿ� ���� ���� ����
    USER_DEFINE_ERROR   EXCEPTION;
    
BEGIN
    -- ���ν����� ���� �Է�ó���� ���������� �����ؾ� �� ���������� 
    -- �ƴ��� ���θ� ���� ���� Ȯ���� �� �ֵ��� �ڵ� ����
    SELECT ������ INTO Z_������
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    IF (V_������ > V_������)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;

    -- V_����ȣ ���� ó��
    SELECT NVL(MAX(����ȣ),0) INTO V_����ȣ
    FROM TBL_���;

    -- INSERT ������ �ۼ� (TBL_���)
    INSERT INTO TBL_���(����ȣ, ��ǰ�ڵ�, ������, ���ܰ�)
    VALUES ((V_����ȣ+1), V_��ǰ�ڵ�, V_������, V_���ܰ�);
    
    -- V_������ ���� ó��
    SELECT ������ - V_������ INTO V_������
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
   -- V_������ := Z_������ - V_������;
    
    -- UPDATE ������ �ۼ� (TBL_��ǰ)
    UPDATE TBL_��ǰ
    SET ������ = V_������
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;

    EXCEPTION 
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '�������� ���������� �����ϴ�');
                 ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
        
END;
--==>> Procedure PRC_���_INSERT��(��) �����ϵǾ����ϴ�.

-----------------------------[������ Ǯ��]--------------------------------------
CREATE OR REPLACE PROCEDURE PRC_���_INSERT
( V_��ǰ�ڵ�    IN TBL_���.��ǰ�ڵ�%TYPE
, V_������    IN TBL_���.������%TYPE
, V_���ܰ�    IN TBL_���.���ܰ�%TYPE
)
IS
    -- �ֿ� ���� ����
    V_����ȣ TBL_���.����ȣ%TYPE;
    V_������ TBL_��ǰ.������%TYPE;
    
    USER_DEFINE_ERROR EXCEPTION;        -- ����� ���� ����
    
BEGIN
    -- ������ ���� ������ ���� ���� Ȯ�� �� ���� ��� Ȯ�� �� ��� ������ ��
    SELECT ������ INTO V_������
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    -- ��� ���������� ������ �� �������� ���� ���� Ȯ��
    -- (�ľ��� ���������� �������� ������... ���� �߻�)
    IF (V_������ > V_������)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    
    -- ������ ������ �� ��Ƴ���
    SELECT NVL(MAX(����ȣ),0) INTO V_����ȣ
    FROM TBL_���;

    -- ������ ���� (INSERT �� TBL_���)
    INSERT INTO TBL_���(����ȣ, ��ǰ�ڵ�, ������, ���ܰ�)
    VALUES ((V_����ȣ+1), V_��ǰ�ڵ�, V_������, V_���ܰ�);
    
    
    -- ������ ���� (UPDATE �� TBL_��ǰ)
    UPDATE TBL_��ǰ
    SET ������ = ������ - V_������
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    -- Ŀ��
    COMMIT;
    
    --���� ó��
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002,'������~!!!');
                 ROLLBACK;
        WHEN OTHERS
             THEN ROLLBACK;
           
END;
--==>> Procedure PRC_���_INSERT��(��) �����ϵǾ����ϴ�.


--�� TBL_��� ���̺��� ��� ������ ����(����)�ϴ� ���ν����� �ۼ��Ѵ�
--   ���Τ����� �� : PRC_���_UPDATE(����ȣ, ������ ����);

CREATE OR REPLACE PROCEDURE PRC_���_UPDATE
( V_����ȣ    IN TBL_���.����ȣ%TYPE
, �����Ҽ���    IN TBL_���.������%TYPE
)
IS
    -- ���� ����
    ������1   TBL_��ǰ.������%TYPE;   -- ���� �� ������
    ������1   TBL_���.������%TYPE;   -- ���� �� ������
    ������2   TBL_��ǰ.������%TYPE;   -- ������ ���� �� ������
    
    V_��ǰ�ڵ�  TBL_���.��ǰ�ڵ�%TYPE;
    
     -- ����� ���� ���ܿ� ���� ���� ����
    USER_DEFINE_ERROR   EXCEPTION;
    
BEGIN
    -- ���� ���(������ ���� ��) < �ٲ� ������ �� �� ����ó��
    IF (������2 < �����Ҽ���)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    
    
    -- ���� (������1, ������1 �ʱ�ȭ)
    SELECT ������ INTO ������1
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    SELECT ������ INTO ������1
    FROM TBL_���
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    SELECT CASE WHEN ������1 > �����Ҽ���
                 THEN ������ + (������1 - �����Ҽ���)
                WHEN ������1 < �����Ҽ���
                  THEN ������ - (�����Ҽ��� - ������1)
                        ELSE 0
                    END  
            INTO ������2
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    -- V_��ǰ�ڵ� ����ó��
    SELECT ��ǰ�ڵ� INTO V_��ǰ�ڵ�
    FROM TBL_���;


    -- UPDATE ������ (TBL_���)
    UPDATE TBL_���
    SET ������ = �����Ҽ���
    WHERE ����ȣ = V_����ȣ;
    
    -- UPDATE ������ (TBL_��ǰ)
    UPDATE TBL_��ǰ
    SET ������ = (CASE WHEN ������1 > �����Ҽ���
                                THEN ������ + (������1 - �����Ҽ���)
                         WHEN ������1 < �����Ҽ���
                                THEN ������ - (�����Ҽ��� - ������1)
                        ELSE 0
                    END)
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    --����ó��
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RASIE_APPLICATION_ERROR(-20003, '������!!');
                 ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
        
    --Ŀ��
    COMMIT;
    
END;

---------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE PRC_���_UPDATE
(V_����ȣ     IN TBL_���.����ȣ%TYPE
, V_�������    IN TBL_��ǰ.������%TYPE
)
IS 
    USER_DEFINE_ERROR EXCEPTION;
    V_��ǰ�ڵ� TBL_���.��ǰ�ڵ�%TYPE;
    V_��������� TBL_��ǰ.������%TYPE;
    V_��������� TBL_���.������%TYPE;

BEGIN
    -- ����ȣ�� ��ġ�ϴ� ��ǰ�ڵ�
    SELECT ��ǰ�ڵ� INTO V_��ǰ�ڵ�
    FROM TBL_���
    WHERE ����ȣ=V_����ȣ;

    -- ������ ������
    SELECT ������ INTO V_���������
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    -- ���� �� ������
    SELECT ������ INTO V_���������
    FROM TBL_���
    WHERE ����ȣ=V_����ȣ;
    
    -- ���� �������-���������� > �������̶�� ��������� ��Ȳ�̴�.
    IF V_������� - V_��������� > V_���������
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    


    -- TBL_��� TBL_��ǰ ������Ʈ

        UPDATE TBL_���
        SET ������=V_�������
        WHERE ����ȣ=V_����ȣ;
        
        UPDATE TBL_��ǰ
        SET ������ = ������ + (V_��������� - V_�������)
        WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    
    
    
    EXCEPTION
    WHEN USER_DEFINE_ERROR
        THEN RAISE_APPLICATION_ERROR(-20003, '�������� �����մϴ�');
        ROLLBACK;
    WHEN OTHERS
        THEN ROLLBACK;
        
    -- Ŀ��
    COMMIT;    
    
END;



