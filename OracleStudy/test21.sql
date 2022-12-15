--● 교수 계정 삭제 프로시저 (PRC_PR_DELETE)
CREATE OR REPLACE PROCEDURE PRC_PR_DELETE
( VPR_ID    IN TBL_PR.PR_ID%TYPE
)
IS
    VOS_CD  TBL_OS.OS_CD%TYPE;
    
BEGIN
    -- 자식테이블2인 성적입력 테이블에서 개설과목코드가 VOS_CD인 데이터 모두 삭제
    -- OC_코드 확인
    SELECT OS_CD INTO VOS_CD
    FROM TBL_OS
    WHERE PR_ID = VPR_ID;  
   
    -- 성적 삭제
    DELETE
    FROM TBL_SC
    WHERE OS_CD = VOS_CD;
    
    -- 자식테이블인 개설과목 테이블에서 교수아이디가 VPR_ID인 데이터 모두 삭제
    DELETE
    FROM TBL_OS
    WHERE PR_ID = VPR_ID;    


    -- 교수 정보 삭제
    DELETE
    FROM TBL_PR
    WHERE PR_ID = VPR_ID;
    
    --커밋
    COMMIT;
    
END;

SELECT *
FROM TBL_PR;

EXEC PRC_PR_DELETE('PR001');




--○ 뷰 생성
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

--○ 특정 교수의 개설 과목 성적 조회 프로시저 (교수자입장)
CREATE OR REPLACE PROCEDURE PRC_PR_LOOKUP
(
    V_PR_ID      IN TBL_PR.PR_ID%TYPE   -- 교수아이디
)
IS
    V_SUB_NM     TBL_SUB.SUB_NM%TYPE; -- 배정된 과목명
    V_SUB_BD     TBL_OS.SUB_BD%TYPE;  -- 과목 시작일
    V_SUB_ED     TBL_OS.SUB_ED%TYPE;  -- 과목 종료일
    V_BK_CD      TBL_BK.BK_CD%TYPE;   -- 교재코드
    V_BK_NM      TBL_BK.BK_NM%TYPE;   -- 교재명
    
    V_OS_CD      TBL_OS.OS_CD%TYPE;   -- 과목개설코드
    V_SUB_CD     TBL_SUB.SUB_CD%TYPE; -- 과목코드
    
    V_REG_CD     TBL_REG.REG_CD%TYPE; -- 수강내역코드
    V_ST_ID      TBL_ST.ST_ID%TYPE;   -- 학생 코드 
    
    V_OC_CD      TBL_OC.OC_CD%TYPE;   -- 개설과정코드
    V_CRS_CD     TBL_OC.CRS_CD%TYPE;  -- 과정코드
    VCRS_NM      TBL_CRS.CRS_NM%TYPE; -- 과정명
    
    V_ST_FN      TBL_ST.ST_FN%TYPE;   -- 학생 성
    V_ST_LN      TBL_ST.ST_LN%TYPE;   -- 학생 이름
    
    V_SC_CD      TBL_SC.SC_CD%TYPE;   -- 성적코드
    V_SC_AT      TBL_SC.SC_AT%TYPE;   -- 출결
    V_SC_WT      TBL_SC.SC_WT%TYPE;   -- 필기
    V_SC_PT      TBL_SC.SC_PT%TYPE;   -- 실기
    
    V_SC_TT     NUMBER; --총점
    V_SC_RK     NUMBER; --등수
    
    
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
        
        -- 개설 과정코드 찾기
        SELECT CRS_CD INTO V_CRS_CD
        FROM TBL_OC
        WHERE OC_CD = V_OC_CD;
        
        -- 개설 과정명 찾기
        SELECT CRS_NM INTO VCRS_NM
        FROM TBL_CRS
        WHERE CRS_CD = V_CRS_CD;
        
        
        LOOP
            -- 학생들 번호 생성
            SELECT MIN(ROWNUM),MAX(ROWNUM) INTO V_NUM2,V_ROWNUM2
            FROM TBL_REG
            WHERE OC_CD = V_OC_CD;
            
            -- 수강내역코드 연산
            SELECT REG_CD INTO V_REG_CD
            FROM TBL_REG
            WHERE OC_CD = V_OC_CD;
            
            -- 학생 코드 연산
            SELECT ST_ID INTO V_ST_ID
            FROM TBL_REG
            WHERE REG_CD = V_REG_CD;
            
            -- 학생 성 가져오기
            SELECT ST_FN INTO V_ST_FN
            FROM TBL_ST
            WHERE ST_ID = V_ST_ID;
            
            -- 학생 이름 가져오기
            SELECT ST_LN INTO V_ST_LN
            FROM TBL_ST
            WHERE ST_ID = V_ST_ID;
            
            -- 성적 
            -- 성적 코드 가져오기
            SELECT SC_CD INTO V_SC_CD
            FROM TBL_SC
            WHERE REG_CD = V_REG_CD;
            
            -- 출결
            SELECT SC_AT INTO V_SC_AT
            FROM TBL_SC
            WHERE REG_CD = V_REG_CD;
            
            -- 필기
            SELECT SC_WT INTO V_SC_WT
            FROM TBL_SC
            WHERE REG_CD = V_REG_CD;
            
            -- 실기
            SELECT SC_PT INTO V_SC_PT
            FROM TBL_SC
            WHERE REG_CD = V_REG_CD; 
            
            -- 총점
            SELECT (SC_AT + SC_WT + SC_PT) INTO V_SC_TT
            FROM TBL_SC
            WHERE SC_CD = V_SC_CD;
            
            -- 등수
            SELECT RANK() OVER (ORDER BY (SC_AT + SC_WT + SC_PT) DESC) INTO V_SC_RK
            FROM TBL_SC
            WHERE SC_CD = V_SC_CD;
            
            -- 과목의 학생 성적 정보 출력        
            DBMS_OUTPUT.PUT_LINE(V_NUM || '.');
            DBMS_OUTPUT.PUT_LINE('학생 이름 : ' || V_ST_FN || V_ST_LN );
            DBMS_OUTPUT.PUT_LINE('과정명 : '|| VCRS_NM );
            DBMS_OUTPUT.PUT_LINE('과목명 : ' || V_SUB_NM  );
            DBMS_OUTPUT.PUT_LINE('과목 기간 : ' || V_SUB_BD || '~' || V_SUB_ED );
            DBMS_OUTPUT.PUT_LINE('교재명 : ' || V_BK_NM );
            DBMS_OUTPUT.PUT_LINE('출결 : ' || V_SC_AT );
            DBMS_OUTPUT.PUT_LINE('필기 : ' || V_SC_WT );
            DBMS_OUTPUT.PUT_LINE('실기 : ' || V_SC_PT );
            DBMS_OUTPUT.PUT_LINE('총점 : ' || V_SC_TT );
            DBMS_OUTPUT.PUT_LINE('등수 : ' || V_SC_RK );
        
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

