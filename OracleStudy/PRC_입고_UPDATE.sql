--○ TBL_입고 테이블에서 입고수량을 수정(변경)하는 프로시저를 완성한다
--   프로시저명 : PRC_입고_UPDATE(입고번호, 변경할입고수량);
CREATE OR REPLACE PROCEDURE PRC_입고_UPDATE
( V_입고번호    IN TBL_입고.입고번호%TYPE
, V_입고수량    IN TBL_입고.입고수량%TYPE
)
IS  
    V_상품코드 TBL_입고.상품코드%TYPE;
    V_전입고수량 TBL_입고.입고수량%TYPE;
    V_전재고수량 TBL_상품.재고수량%TYPE;
    
    -- 사용자 정의 예외 변수 선언
    USER_DEFINE_ERROR   EXCEPTION;
    
BEGIN
    -- 상품코드 연산
    SELECT 상품코드  INTO V_상품코드
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;
    
    -- 변경전입고수량 연산
    SELECT 입고수량 INTO V_전입고수량
    FROM TBL_입고 
    WHERE 입고번호 = V_입고번호;
    
    -- 변경전재고수량 연산
    SELECT 재고수량 INTO V_전재고수량
    FROM TBL_상품
    WHERE 상품코드 = V_상품코드;
    
    -- 예외 발생
    IF ((V_전재고수량 + V_입고수량 - V_전입고수량) < 0
)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    

    -- UPDATE문 (TBL_입고 T)
    UPDATE TBL_입고
    SET 입고수량 = V_입고수량
    WHERE 입고번호 = V_입고번호;
    
    -- UPDATE문 (TBL_상품 T)
    UPDATE TBL_상품
    SET 재고수량 = 재고수량 - V_전입고수량 + V_입고수량
    WHERE 상품코드 = V_상품코드;
    
    --커밋
    COMMIT;
    
    -- 예외 처리
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20003, '입고처리불가');
            ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
    
END;