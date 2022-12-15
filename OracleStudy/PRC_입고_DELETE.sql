--○ TBL_입고 테이블에서 입고수량을 삭제하는 프로시저를 작성한다
--   프로시저명 : PRC_입고_DELETE(입고번호);
CREATE OR REPLACE PROCEDURE PRC_입고_DELETE
( V_입고번호    IN TBL_입고.입고번호%TYPE
)
IS
    V_상품코드  TBL_입고.상품코드%TYPE;
    V_입고수량  TBL_입고.입고수량%TYPE;
    
BEGIN
    -- 상품코드 연산
    SELECT 상품코드 INTO V_상품코드
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;
    
    -- 입고수량 연산
    SELECT 입고수량 INTO V_입고수량
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;
    
    -- DELETE 입고 T
    DELETE 
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;

    -- 입고T NUM 바꿔주기
    
    -- UPDATE 상품 T
    UPDATE TBL_상품
    SET 재고수량 = 재고수량 - V_입고수량
    WHERE 상품코드 = V_상품코드;
    
    
END;