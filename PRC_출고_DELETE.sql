--○ TBL_출고 테이블에서 출고수량을 삭제하는 프로시저를 작성한다
--   프로시저명 : PRC_출고_DELETE(출고번호);
CREATE OR REPLACE PROCEDURE PRC_출고_DELETE
( V_출고번호 IN TBL_출고.출고번호%TYPE
)
IS
     V_상품코드  TBL_출고.상품코드%TYPE;
     V_출고수량  TBL_출고.출고수량%TYPE;
     
BEGIN
    -- 상품코드 연산
    SELECT 상품코드 INTO V_상품코드
    FROM TBL_출고
    WHERE 출고번호 = V_출고번호;
    
    -- 출고수량 연산
    SELECT 출고수량 INTO V_출고수량
    FROM TBL_출고
    WHERE 출고번호 = V_출고번호;


    -- DELETE 출고T
    DELETE
    FROM TBL_출고
    WHERE 출고번호 = V_출고번호;
    
    -- 출고T NUM 바꿔주기
    
    -- UPDATE 상품 T (재고수량)
    UPDATE TBL_상품
    SET 재고수량 = 재고수량 - V_출고수량
    WHERE 상품코드 = V_상품코드;
    
END;