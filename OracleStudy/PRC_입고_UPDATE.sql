--�� TBL_�԰� ���̺��� �԰������ ����(����)�ϴ� ���ν����� �ϼ��Ѵ�
--   ���ν����� : PRC_�԰�_UPDATE(�԰��ȣ, �������԰����);
CREATE OR REPLACE PROCEDURE PRC_�԰�_UPDATE
( V_�԰��ȣ    IN TBL_�԰�.�԰��ȣ%TYPE
, V_�԰����    IN TBL_�԰�.�԰����%TYPE
)
IS  
    V_��ǰ�ڵ� TBL_�԰�.��ǰ�ڵ�%TYPE;
    V_���԰���� TBL_�԰�.�԰����%TYPE;
    V_�������� TBL_��ǰ.������%TYPE;
    
    -- ����� ���� ���� ���� ����
    USER_DEFINE_ERROR   EXCEPTION;
    
BEGIN
    -- ��ǰ�ڵ� ����
    SELECT ��ǰ�ڵ�  INTO V_��ǰ�ڵ�
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    -- �������԰���� ����
    SELECT �԰���� INTO V_���԰����
    FROM TBL_�԰� 
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    -- ������������ ����
    SELECT ������ INTO V_��������
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    -- ���� �߻�
    IF ((V_�������� + V_�԰���� - V_���԰����) < 0
)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    

    -- UPDATE�� (TBL_�԰� T)
    UPDATE TBL_�԰�
    SET �԰���� = V_�԰����
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    -- UPDATE�� (TBL_��ǰ T)
    UPDATE TBL_��ǰ
    SET ������ = ������ - V_���԰���� + V_�԰����
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    --Ŀ��
    COMMIT;
    
    -- ���� ó��
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20003, '�԰�ó���Ұ�');
            ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
    
END;