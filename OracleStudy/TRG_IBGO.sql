--�� TBL_��ǰ, TBL_�԰�, TBL_��� �� ���迡��
--   �԰����, �������� Ʈ����� ó���� �̷���� �� �ֵ���
--   TRG_IBGO Ʈ���Ÿ� �����Ѵ�.
CREATE OR REPLACE TRIGGER TRG_IBGO
    AFTER
    INSERT OR UPDATE OR DELETE ON TBL_�԰�
    FOR EACH ROW

BEGIN 
    IF (INSERTING)
        THEN UPDATE TBL_��ǰ
             SET ������ = ������ + :NEW.�԰����
             WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
    ELSIF (UPDATING)
        THEN UPDATE TBL_��ǰ
             SET ������ = ������ - :OLD.�԰���� + :NEW.�԰����
             WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;
    ELSIF (DELETING)
        THEN UPDATE TBL_��ǰ
             SET ������ = ������ - :OLD.�԰����
             WHERE ��ǰ�ڵ� = :OLD.��ǰ�ڵ�;
    END IF;
END;