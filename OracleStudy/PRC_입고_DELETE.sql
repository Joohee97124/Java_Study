--�� TBL_�԰� ���̺��� �԰������ �����ϴ� ���ν����� �ۼ��Ѵ�
--   ���ν����� : PRC_�԰�_DELETE(�԰��ȣ);
CREATE OR REPLACE PROCEDURE PRC_�԰�_DELETE
( V_�԰��ȣ    IN TBL_�԰�.�԰��ȣ%TYPE
)
IS
    V_��ǰ�ڵ�  TBL_�԰�.��ǰ�ڵ�%TYPE;
    V_�԰����  TBL_�԰�.�԰����%TYPE;
    
BEGIN
    -- ��ǰ�ڵ� ����
    SELECT ��ǰ�ڵ� INTO V_��ǰ�ڵ�
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    -- �԰���� ����
    SELECT �԰���� INTO V_�԰����
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    -- DELETE �԰� T
    DELETE 
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;

    -- �԰�T NUM �ٲ��ֱ�
    
    -- UPDATE ��ǰ T
    UPDATE TBL_��ǰ
    SET ������ = ������ - V_�԰����
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    
END;