--○ 과정 개설 테이블 생성
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

--○ 과정 테이블 생성
CREATE TABLE TBL_CRS
( CRS_CD    VARCHAR2(10)
, CRS_NM    VARCHAR2(50)    CONSTRAINT CRS_NM_NN NOT NULL
, CONSTRAINT CRS_CD_PK PRIMARY KEY(CRS_CD)
);

--○ 과목 테이블 생성
CREATE TABLE TBL_SUB
( SUB_CD VARCHAR2(10)
, SUB_NM VARCHAR2(50) CONSTRAINT SUB_NM_NN NOT NULL
, CONSTRAINT SUB_CD_PK PRIMARY KEY(SUB_CD)
);

--○ 교재 테이블 생성
CREATE TABLE TBL_BK
( BK_CD VARCHAR2(10)
, BK_NM VARCHAR2(50) CONSTRAINT BK_NM_NN  NOT NULL
, CONSTRAINT BK_CD_PK PRIMARY KEY(BK_CD)
);
--==>> Table TBL_BK이(가) 생성되었습니다.
DESC TBL_BK;

--○ 학생 회원가입 테이블 생성
CREATE TABLE TBL_ST
( ST_ID     VARCHAR2(10)   
, ST_SSN    CHAR(14)       CONSTRAINT ST_SSN_NN NOT NULL
, ST_FN     VARCHAR2(5)    CONSTRAINT ST_FN_NN NOT NULL
, ST_LN     VARCHAR2(5)    CONSTRAINT ST_LN_NN NOT NULL
, ST_DT     DATE           DEFAULT SYSDATE
, ST_PW     VARCHAR2(10)   CONSTRAINT ST_PW_NN NOT NULL
, CONSTRAINT ST_ID_PK PRIMARY KEY(ST_ID) 
);

--○ 관리자 계정 테이블 생성
CREATE TABLE TBL_AD 
( AD_ID 	VARCHAR2(10)
, AD_PW 	VARCHAR2(10)	CONSTRAINT AD_PW_NN NOT NULL
, CONSTRAINT AD_ID_PK PRIMARY KEY(AD_ID)
);

--○ 배점 테이블 생성
CREATE TABLE TBL_RAT 
( RAT_CD    VARCHAR2(10)
, RAT_AT    NUMBER(3)       CONSTRAINT RAT_AT_NN NOT NULL
, RAT_WT    NUMBER(3)       CONSTRAINT RAT_WT_NN NOT NULL
, RAT_PT    NUMBER(3)       CONSTRAINT RAT_PT_NN NOT NULL
, CONSTRAINT RAT_CD_PK PRIMARY KEY(RAT_CD)
);


--○ 교수 테이블 생성
CREATE TABLE TBL_PR
( PR_ID     VARCHAR2(10)    
, PR_SSN    CHAR(14)       CONSTRAINT PR_SSN_NN NOT NULL
, PR_FN     VARCHAR2(5)    CONSTRAINT PR_FN_NN NOT NULL
, PR_LN     VARCHAR2(10)    CONSTRAINT PR_LN_NN NOT NULL
, PR_DT     DATE                DEFAULT SYSDATE
, PR_PW     VARCHAR2(10)   CONSTRAINT PR_PW_NN NOT NULL
, CONSTRAINT PR_ID_PK PRIMARY KEY (PR_ID)
);

--○ 과목개설 테이블 생성
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

--○ 수강신청 테이블 생성
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

--○ 성적 입력 테이블 생성
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

--○ 중도탈락 테이블 생성
CREATE TABLE TBL_QT 
( QT_CD 	VARCHAR2(10)
, REG_CD 	VARCHAR2(10)	CONSTRAINT QT_REG_CD_NN NOT NULL
, QT_DT		DATE		    DEFAULT SYSDATE
, CONSTRAINT QT_CD_PK PRIMARY KEY(QT_CD)
, CONSTRAINT QT_REG_CD_FK FOREIGN KEY(REG_CD)
			  REFERENCES TBL_REG(REG_CD)
);






--------------------------------------------------------------[교수, 과정개설]----

--● 교수 계정 생성 프로시저 (PRC_PR_INSERT)
-- 시퀀스 생성
CREATE SEQUENCE SEQ_PRCODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_PRCODE이(가) 생성되었습니다.
    
--시퀀스 생성
CREATE SEQUENCE SEQ_PRCODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_PRCODE이(가) 생성되었습니다.

--프로시저 생성
CREATE OR REPLACE PROCEDURE PRC_PR_INSERT
( VPR_SSN    IN TBL_PR.PR_SSN%TYPE
, VPR_FN     IN TBL_PR.PR_FN%TYPE
, VPR_LN     IN TBL_PR.PR_LN%TYPE
, VPR_DT     IN TBL_PR.PR_DT%TYPE    DEFAULT SYSDATE
)
IS
    -- 변수 선언
    VPR_ID  TBL_PR.PR_ID%TYPE;
    VPR_PW  TBL_PR.PR_PW%TYPE;
    
    -- 주민번호 중복 예외 
    PR_SSN_ERROR EXCEPTION;
    
    VCOUNT  NUMBER;
    
BEGIN
    -- 동일한 주민번호가 있는지 체크
    SELECT COUNT(*) INTO VCOUNT
    FROM TBL_PR
    WHERE PR_SSN = VPR_SSN;
    
    -- 동일한 주민번호가 없으면 INSERT 
    IF (VCOUNT =1)
        THEN 
            RAISE PR_SSN_ERROR;
    ELSE 
        -- VPR_PW 연산 (교수 비밀번호)
        VPR_PW := SUBSTR(VPR_SSN,8);
        
        -- VPR_ID 연산 (교수ID)
        VPR_ID := 'PR' || LPAD(SEQ_PRCODE.NEXTVAL,3,'0');      

        -- 교수 정보 INSERT 쿼리문
        INSERT INTO TBL_PR(PR_ID, PR_SSN, PR_FN, PR_LN, PR_PW, PR_DT)
        VALUES(VPR_ID, VPR_SSN, VPR_FN, VPR_LN, VPR_PW, VPR_DT);
        
    END IF;
    
    --커밋
    COMMIT;
    
    --예외처리
    EXCEPTION
        WHEN PR_SSN_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'이미 존재하는 데이터입니다.');
            ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
    
    
END;

--==>> Procedure PRC_PR_INSERT이(가) 컴파일되었습니다.

ALTER TABLE TBL_PR MODIFY PR_LN VARCHAR2(50);
--==>> Table TBL_PR이(가) 변경되었습니다.

--○ 데이터 입력
EXEC PRC_PR_INSERT('750910-1123456', '김','호진'); 
EXEC PRC_PR_INSERT('971009-2123456', '한','혜림'); 
EXEC PRC_PR_INSERT('750610-1234567', '김','후진');
EXEC PRC_PR_INSERT('971224-2123456', '정','주리');
EXEC PRC_PR_INSERT('801010-2123456', '김','어별');


--○ 데이터 확인
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
PR001	750910-1123456	김	호진	21/04/15	1123456	A006
PR005	750610-1234567	김	후진	21/04/16	1234567	A014
PR002	971009-2123456	한	혜림	21/04/15	2123456	A015
PR004	971225-1234567	정	주리	21/04/15	2123456	(null)
PR006	801010-2123456	김	어별	21/04/16	2123456	(null)
*/

SELECT *
FROM TBL_OS;

DELETE 
FROM TBL_PR
WHERE PR_ID = 'PR004';

DROP SEQUENCE SEQ_PRCODE;



--● 교수 계정 수정 프로시저 (PRC_PR_UPDATE)
CREATE OR REPLACE PROCEDURE PRC_PR_UPDATE
( VPR_ID    IN TBL_PR.PR_ID%TYPE
, VPR_SSN   IN TBL_PR.PR_SSN%TYPE
, VPR_FN    IN TBL_PR.PR_FN%TYPE
, VPR_LN    IN TBL_PR.PR_LN%TYPE
, VPR_DT    IN TBL_PR.PR_DT%TYPE
)
IS
    PR_SSN_ERROR EXCEPTION;     -- 주민번호가 다른 주번과 겹치면 예외처리
    VCOUNT NUMBER;
    PR_DATE_ERROR   EXCEPTION;  -- DT가 오늘보다 미래이면 예외처리
    
BEGIN
    -- 동일한 주민번호가 있는지 체크
    SELECT COUNT(*) INTO VCOUNT
    FROM TBL_PR
    WHERE PR_SSN = VPR_SSN;
    
    --동일한 주민번호가 아니면 UPDATE
    IF VCOUNT=1
        THEN RAISE PR_SSN_ERROR;
        
    ELSIF ( TO_NUMBER(SYSDATE - VPR_DT)<0 )
        THEN RAISE PR_DATE_ERROR;
    
    ELSE    
    -- 교수 테이블 수정
    UPDATE TBL_PR
    SET PR_SSN = VPR_SSN
    WHERE PR_ID = VPR_ID;
    END IF;
    
    --커밋
    COMMIT;
    
    -- 예외처리
    EXCEPTION
        WHEN PR_SSN_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'이미 존재하는 데이터입니다.');
            ROLLBACK;
        WHEN PR_DATE_ERROR 
            THEN RAISE_APPLICATION_ERROR(-20005, '유효하지 않은 날짜입니다.');
            ROLLBACK; 
        WHEN OTHERS THEN ROLLBACK;
END;

EXEC PRC_PR_UPDATE('PR004','971225-1234767','정','주희','2020-07-10');
EXEC PRC_PR_UPDATE('PR004','정','주희','2020-07-10');

SELECT *
FROM TBL_PR;

--● 교수 계정 삭제 프로시저 (PRC_PR_DELETE)
CREATE OR REPLACE PROCEDURE PRC_PR_DELETE
( VPR_ID    IN TBL_PR.PR_ID%TYPE
)
IS
BEGIN
    -- 교수 정보 삭제
    DELETE
    FROM TBL_PR
    WHERE PR_ID = VPR_ID;
    
    --커밋
    COMMIT;
    
END;
--==>> Procedure PRC_PR_DELETE이(가) 컴파일되었습니다.

EXEC PRC_PR_DELETE('PR003');


--● 교수 계정 조회 (교수시점) 프로시저
CREATE OR REPLACE VIEW VIEW_PR
AS
SELECT T.*
FROM
(
    SELECT ROWNUM "NUM", PR_ID "PR_ID", PR_SSN "PR_SSN", PR_FN "PR_FN", PR_LN "PR_LN", PR_DT "PR_DT", PR_PW "PR_PW"
    FROM TBL_PR
)T;


--○ 특정 교수의 전체 강의목록 조회
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
    V_OC_CD      TBL_OC.OC_CD%TYPE;   -- 강의실코드
    V_CRS_RM     TBL_OC.CRS_RM%TYPE;  -- 강의실
    
    V_OS_CD      TBL_OS.OS_CD%TYPE;
    V_SUB_CD     TBL_SUB.SUB_CD%TYPE;
    
    V_ING        VARCHAR(50);         -- 강의 진행 여부
    V_DATE1      NUMBER;              -- 날짜 연산 변수
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
                THEN V_ING := '강의 중';
            ELSIF (V_DATE1 < 0 AND V_DATE2 < 0) 
                THEN V_ING := '강의 예정';
            ELSIF (V_DATE1 > 0 AND V_DATE2 > 0)
                THEN V_ING := '강의 종료';
            ELSE V_ING := '확인불가';
            END IF;
            
            -- 교수 정보 출력        
            DBMS_OUTPUT.PUT_LINE(V_NUM || '.');
            DBMS_OUTPUT.PUT_LINE('교수ID : ' || V_PR_ID);
            DBMS_OUTPUT.PUT_LINE('배정된 과목명 : ' || V_OS_CD  );
            DBMS_OUTPUT.PUT_LINE('과목 기간 : ' || V_SUB_BD || '~' || V_SUB_ED );
            DBMS_OUTPUT.PUT_LINE('교재명 : ' || V_BK_NM );
            DBMS_OUTPUT.PUT_LINE('강의실 : ' || V_CRS_RM );
            DBMS_OUTPUT.PUT_LINE('강의 진행 여부 : ' || V_ING );
            
            V_NUM := V_NUM+1;
            
            EXIT WHEN V_NUM > V_ROWNUM;
        END LOOP;
        
    ELSE RAISE NOT_FOUND_ERROR;
    END IF;
    
    -- 커밋
    COMMIT;
    
    EXCEPTION
        WHEN NOT_FOUND_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '입력하신 정보와 일치하는 데이터가 없습니다.');
            ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
END;

EXEC PRC_PR_LOOKUP ('PR001');

SELECT *
FROM TBL_OS;




--● 교수 계정 조회 (관리자시점) 프로시저
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
--==>> Procedure PRC_PR_LOOKUP이(가) 컴파일되었습니다.
EXEC PRC_PR_LOOKUP_ADMIN;


--● 과정개설 생성 프로시저
-- 시퀀스 생성
CREATE SEQUENCE SEQ_OC
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_OC이(가) 생성되었습니다.

--프로시저 생성
CREATE OR REPLACE PROCEDURE PRC_OC_INSERT
( VCRS_CD   IN TBL_OC.CRS_CD%TYPE
, VCRS_BD   IN TBL_OC.CRS_BD%TYPE
, VCRS_ED   IN TBL_OC.CRS_ED%TYPE
, VCRS_RM   IN TBL_OC.CRS_RM%TYPE
)
IS
    -- 주요 변수 선언
    VOC_CD  TBL_OC.OC_CD%TYPE;      
    VCRS_NM TBL_CRS.CRS_NM%TYPE;    
    
    -- 예외 변수 선언 (날짜)
    OC_DATE_ERROR   EXCEPTION;   
BEGIN
    -- 예외 발생
    IF (TO_NUMBER(VCRS_ED - VCRS_BD) < 0)
        THEN RAISE OC_DATE_ERROR;
    END IF;
    
    -- 과정명 찾기 VCRS_NM
    SELECT CRS_NM INTO VCRS_NM
    FROM TBL_CRS
    WHERE CRS_CD = VCRS_CD;
    
    -- VOC_CD 개설과정 코드
    VOC_CD := TO_CHAR('A' || '_' || SUBSTR(VCRS_NM,1,2) || LPAD(SEQ_OC.NEXTVAL,3,'0'));
    
    INSERT INTO TBL_OC(OC_CD, CRS_CD, CRS_BD, CRS_ED, CRS_RM)
    VALUES(VOC_CD ,VCRS_CD, VCRS_BD, VCRS_ED, VCRS_RM);
 
    COMMIT;
    
    EXCEPTION
        WHEN OC_DATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20005, '유효하지 않은 날짜입니다');
                 ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
END;
--==>> Procedure PRC_CRS_INSERT이(가) 컴파일되었습니다.
-->> 오류나면 주석삭제하기

--○ 데이터 입력
EXEC PRC_OC_INSERT('JA001', '2021-02-01', '2021-03-02' , 'F반');


--● 과정개설 수정 프로시저
CREATE OR REPLACE PROCEDURE PRC_OC_UPDATE
( VOC_CD    IN TBL_OC.OC_CD%TYPE
, VCRS_CD   IN TBL_OC.CRS_CD%TYPE
, VCRS_BD   IN TBL_OC.CRS_BD%TYPE
, VCRS_ED   IN TBL_OC.CRS_ED%TYPE
, VCRS_RM   IN TBL_OC.CRS_RM%TYPE
)
IS
    NOT_FOUND_ERROR EXCEPTION;    -- 과정코드 일치X 예외
    VCOUNT          NUMBER;       -- 과정코드 확인용
    OC_DATE_ERROR   EXCEPTION;    -- 날짜 관련 예외
    
BEGIN
    
    -- 동일한 과정코드가 있는지 체크
    SELECT COUNT(*) INTO VCOUNT
    FROM TBL_CRS
    WHERE CRS_CD = VCRS_CD;
    
    -- 동일한 과목코드가 있으면 과정개설 수정 UPDATE
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
            THEN RAISE_APPLICATION_ERROR(-20002, '입력하신 정보와 일치하는 데이터가 없습니다.');
            ROLLBACK;
        WHEN OC_DATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20005, '유효하지 않은 날짜입니다.');
            ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
    --커밋
    COMMIT;      
END;
--==>> Procedure PRC_OR_UPDATE이(가) 컴파일되었습니다.

EXEC PRC_OC_UPDATE('A_SW001','SW001','2021-01-02','2021-02-10','A반');

SELECT*
FROM TBL_OC;


--● 과정개설 삭제 프로시저
CREATE OR REPLACE PROCEDURE PRC_OC_DELETE
( VOC_CD    IN TBL_OC.OC_CD%TYPE
)
IS
BEGIN
        DELETE
        FROM TBL_OC
        WHERE OC_CD = VOC_CD;
    
    -- 커밋
    COMMIT;
           
END;
--==>> Procedure PRC_OR_DELETE이(가) 컴파일되었습니다.
-->> 오류나면 주석 삭제

EXEC PRC_OC_DELETE('A_SW001','SW002');

SELECT *
FROM TBL_OC;


--● 과정개설 조회 프로시저

--○ 과정과목개설 조회 프로시저용 VIEW 생성
CREATE OR REPLACE VIEW VIEW_OS
AS
SELECT T.*
FROM
(
    SELECT ROWNUM "NUM", OS_CD "OS_CD", OC_CD "OC_CD", SUB_CD "SUB_CD", PR_ID "PR_ID"
          ,BK_CD "BK_CD", RAT_CD "RAT_CD", SUB_BD "SUB_BD", SUB_ED "SUB_ED"
    FROM TBL_OS
)T;


--○ 과목개설 전체 조회 프로시저 생성













---------------------------------[데이터 입력 시작]--------------------------------------------
-- ① 교수 테이블 데이터 입력
--● 교수 계정 생성 프로시저 (PRC_PR_INSERT)
-- 시퀀스 생성
CREATE SEQUENCE SEQ_PRCODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_PRCODE이(가) 생성되었습니다.
    
CREATE OR REPLACE PROCEDURE PRC_PR_INSERT
( VPR_SSN    IN TBL_PR.PR_SSN%TYPE
, VPR_FN     IN TBL_PR.PR_FN%TYPE
, VPR_LN     IN TBL_PR.PR_LN%TYPE
)
IS
    -- 변수 선언
    VPR_ID  TBL_PR.PR_ID%TYPE;
    VPR_PW  TBL_PR.PR_PW%TYPE;
    
BEGIN
    -- VPR_PW 연산 (교수 비밀번호)
    VPR_PW := SUBSTR(VPR_SSN,8);
    
    -- VPR_ID 연산 (교수ID)
    VPR_ID := 'PR' || LPAD(SEQ_PRCODE.NEXTVAL,3,'0');     

    -- 교수 정보 INSERT 쿼리문
    INSERT INTO TBL_PR(PR_ID, PR_SSN, PR_FN, PR_LN, PR_PW)
        VALUES(VPR_ID, VPR_SSN, VPR_FN, VPR_LN, VPR_PW);
        
    --커밋
    COMMIT;
END;
--==>> Procedure PRC_PR_INSERT이(가) 컴파일되었습니다.

--○ 데이터 입력
EXEC PRC_PR_INSERT('750910-1123456', '김','호진'); 
EXEC PRC_PR_INSERT('971009-2123456', '한','혜림'); 
EXEC PRC_PR_INSERT('750610-1234567', '김','후진');
EXEC PRC_PR_INSERT('971224-2123456', '정','주리');
EXEC PRC_PR_INSERT('801010-2123456', '김','어별');


--○ 데이터 확인
SELECT *
FROM TBL_PR;


--② 학생 테이블 데이터 입력
--● 학생 계정 생성 프로시저 (PRC_ST_INSERT)
-- 학생코드 시퀀스 생성 
CREATE SEQUENCE SEQ_ST_CODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_ST_CODE이(가) 생성되었습니다

--○ 학생 입력 프로시저 작성
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
        -- 학생 아이디 생성 
        V_ST_ID := 'ST' || LPAD(SEQ_ST_CODE.NEXTVAL,3,'0');     
        V_ST_PW := SUBSTR(V_ST_SSN,8);   
         -- 테이블에 데이터 입력 
        INSERT INTO TBL_ST(ST_ID, ST_SSN, ST_FN, ST_LN, ST_PW)
        VALUES (V_ST_ID, V_ST_SSN, V_ST_FN, V_ST_LN, V_ST_PW);
        
    ELSE RAISE DUPLICATE_ERROR;
    END IF;
    
    COMMIT;
    
    EXCEPTION
        WHEN DUPLICATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'이미 존재하는 데이터입니다.');
                 ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
END;
--==>> Procedure PRC_ST_INSERT이(가) 컴파일되었습니다.

--○ 데이터 입력
EXEC PRC_ST_INSERT('951102-2234567', '선', '혜연');
EXEC PRC_ST_INSERT('971224-2234568', '정', '주희');
EXEC PRC_ST_INSERT('980709-2233445', '장', '서현'); 
EXEC PRC_ST_INSERT('930308-2323232', '김', '아별'); 

--아이디, 주민번호, 성, 이름, 날짜, 비밀번호
INSERT INTO TBL_ST(ST_ID, ST_SSN, ST_FN, ST_LN, ST_DT, ST_PW) 
       VALUES ('ST001','971006-2234567','한','혜림',SYSDATE,'2234567');


--○ 데이터 확인
SELECT *
FROM TBL_ST;

ALTER TABLE TBL_ST MODIFY ST_LN VARCHAR2(50);
--==>> Table TBL_ST이(가) 변경되었습니다.
--==>> 컴파일 -> 얘 해주고 다시 컴파일 하기!


--③ 과정 테이블 데이터 입력
--● 과정 생성 프로시저 (PRC_CRS_INSERT)
-- 시퀀스 생성
CREATE SEQUENCE SEQ_CRS
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==> Sequence SEQ_CRS이(가) 생성되었습니다.


--○ PRC_과정생성  PRC_CRS_INSERT (코드 시퀀스 버전)
--○ 과정 입력 프로시저용 SEQUENCE 생성
CREATE SEQUENCE SEQ_CRS
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;


--○ 과정 입력 프로시저 생성
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
    --과정명 중복 여부 확인
    SELECT COUNT(*) INTO V_COUNT
    FROM TBL_CRS
    WHERE CRS_NM = V_CRS_NM;
    
    --중복시 에러 발생
    IF V_COUNT >= 1
        THEN RAISE DUPLICATE_ERROR;
    END IF;
    
    --첫 두 글자가 알파벳 대문자 두 글자인지 확인
    V_CD_ASCII := TO_NUMBER(ASCII(SUBSTR(V_CRS_NM,1,1))) + TO_NUMBER(ASCII(SUBSTR(V_CRS_NM,2,1)));
    
    IF (V_CD_ASCII >= 130 AND V_CD_ASCII <= 180)
        THEN
            V_CRS_CD := SUBSTR(V_CRS_NM,1,2) || LPAD(SEQ_CRS.NEXTVAL,3,'0');
            INSERT INTO TBL_CRS(CRS_CD, CRS_NM) VALUES (V_CRS_CD, V_CRS_NM);
    ELSE
        RAISE CREATE_CODE_ERROR;
    END IF;
    
    -- 커밋
    COMMIT;
    
    EXCEPTION
        WHEN DUPLICATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001, '이미 존재하는 데이터입니다.');
                 ROLLBACK;
        WHEN CREATE_CODE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20007,'유효하지 않은 과정명입니다.');
                 ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
END;
--==> Procedure PRC_CRS_INSERT이(가) 컴파일되었습니다.

--○ 데이터 입력
EXEC PRC_CRS_INSERT('SW 자바 풀스택 양성과정');
EXEC PRC_CRS_INSERT('SW 자바 프론트앤드 양성과정');
EXEC PRC_CRS_INSERT('BD 빅데이터와 AI');
EXEC PRC_CRS_INSERT('BD 빅데이터와 파이썬');
EXEC PRC_CRS_INSERT('IS 정보시스템 전문가 양성과정 ');
EXEC PRC_CRS_INSERT('IS 정보시스템 구축 및 모의해킹');
EXEC PRC_CRS_INSERT('DC 스마트 콘텐츠 웹 애플리케이션 개발');
EXEC PRC_CRS_INSERT('CC 클라우드 컴퓨팅 엔지니어 양성과정');


ALTER TABLE TBL_CRS MODIFY CRS_NM VARCHAR2(100);
--==>> Table TBL_CRS이(가) 변경되었습니다.
--==>> 생성프로시저 컴파일 -> 얘 실행 -> 다시 생성프로시저 컴파일 후 데이터 입력하기

-- 테이블 확인
SELECT *
FROM TBL_CRS;


--④ 과목 테이블 데이터 입력
--● 과목 등록 프로시저(시퀀스 VER.)
-- 시퀀스 : SEQUENCE SEQ_SUB_CODE
CREATE SEQUENCE SEQ_SUB_CODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_SUB_CODE이(가) 생성되었습니다.

--   프로시저: PRC_SUB_INSERT(과목명)
CREATE OR REPLACE PROCEDURE PRC_SUB_INSERT
(
   V_SUB_NM    IN  TBL_SUB.SUB_NM%TYPE  
)
IS
    V_SUB_CD                    TBL_SUB.SUB_CD%TYPE;
    V_COUNT                     NUMBER;
    ALREADY_REGISTERED_ERROR    EXCEPTION;

BEGIN
    --과목코드 생성
    V_SUB_CD := SUBSTR(V_SUB_NM, 1, 1) || LPAD(SEQ_SUB_CODE.NEXTVAL,3,'0');
    
    --동일한 과목코드이 있는지 체크
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
             THEN RAISE_APPLICATION_ERROR(-20001, '이미 존재하는 데이터입니다.');
             ROLLBACK;
        WHEN OTHERS
             THEN ROLLBACK;
END;

--○ 데이터 입력
EXEC PRC_SUB_INSERT('JAVA');
EXEC PRC_SUB_INSERT('JAVA');
EXEC PRC_SUB_INSERT('JAVA');
EXEC PRC_SUB_INSERT('ORACLE');
EXEC PRC_SUB_INSERT('HTML');

-- 확인
SELECT *
FROM TBL_SUB;



--⑤ 배점 테이블 데이터 입력
-- 시퀀스 생성
CREATE SEQUENCE SEQ_RAT
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==> Sequence SEQ_RAT이(가) 생성되었습니다.



--○ PRC_배점입력 PRC_RAT_INSERT
CREATE OR REPLACE PROCEDURE PRC_RAT_INSERT
( V_RAT_AT      TBL_RAT.RAT_AT%TYPE
, V_RAT_WT      TBL_RAT.RAT_WT%TYPE
, V_RAT_PT      TBL_RAT.RAT_PT%TYPE
)

IS
    V_RAT_CD    TBL_RAT.RAT_CD%TYPE;
    PROPORTION_ERROR    EXCEPTION;
    
BEGIN
    
    -- 배점코드 생성
    V_RAT_CD := 'RT' || LPAD(SEQ_RAT.NEXTVAL,3,'0');
    
    -- 전체 비율이 100이 넘지 않을 경우 INSERT
    IF ( (V_RAT_AT + V_RAT_WT + V_RAT_PT) = 100 )
     THEN INSERT INTO TBL_RAT (RAT_CD, RAT_AT, RAT_WT, RAT_PT) 
          VALUES (V_RAT_CD,V_RAT_AT, V_RAT_WT, V_RAT_PT);
    -- 나머지 경우는 에러 발생
    ELSE RAISE PROPORTION_ERROR;
        
    END IF;
    
    
    -- 커밋
    COMMIT;
    
    
    -- 에러 처리
    EXCEPTION
        WHEN PROPORTION_ERROR
            THEN RAISE_APPLICATION_ERROR(-20006, '총 배점은 100점 만점 기준입니다.');
                ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;    
END;
--==>> Procedure PRC_RAT_INSERT이(가) 컴파일되었습니다.

--○ 데이터 입력
EXEC PRC_RAT_INSERT(20,30,50);
EXEC PRC_RAT_INSERT(10,40,50);

-- 확인
SELECT *
FROM TBL_RAT;


--⑥ 교재 테이블 데이터 입력
--● 교재테이블(TBL_BK) 생성 프로시저 
--○ 교재등록 시퀀스 : SEQUENCE SEQ_SUB_CODE
CREATE SEQUENCE SEQ_SUB_CODE2
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_SUB_CODE이(가) 생성되었습니다.

--○ 교재 등록 프로시저 PRC_BK_INSERT(교재명)
--○ 교재등록 시퀀스 : SEQUENCE SEQ_BK_CODE
CREATE SEQUENCE SEQ_BK_CODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_BK_CODE이(가) 생성되었습니다.

--○ 교재 등록 프로시저 PRC_BK_INSERT(교재명)
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
             THEN RAISE_APPLICATION_ERROR(-20001, '이미 존재하는 데이터입니다.');
             ROLLBACK;
        WHEN OTHERS
             THEN ROLLBACK;
END;
--==>> Procedure PRC_BK_INSERT이(가) 컴파일되었습니다.

-- 데이터입력
EXEC PRC_BK_INSERT('자바의 정석');
EXEC PRC_BK_INSERT('자바의 정석');
EXEC PRC_BK_INSERT('오라클의 정석');

-- 확인
SELECT *
FROM TBL_BK;



--⑦ 과정개설 테이블 데이터 입력
--● 과정개설 생성 프로시저
-- 시퀀스 생성
CREATE SEQUENCE SEQ_OC
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_OC이(가) 생성되었습니다.

CREATE OR REPLACE PROCEDURE PRC_OC_INSERT
( VCRS_CD   IN TBL_OC.CRS_CD%TYPE
, VCRS_BD   IN TBL_OC.CRS_BD%TYPE
, VCRS_ED   IN TBL_OC.CRS_ED%TYPE
, VCRS_RM   IN TBL_OC.CRS_RM%TYPE
)
IS
    -- 주요 변수 선언
    VOC_CD  TBL_OC.OC_CD%TYPE;      
    VCRS_NM TBL_CRS.CRS_NM%TYPE;    
    
    -- 예외 변수 선언 (날짜)
    OC_DATE_ERROR   EXCEPTION;
        
BEGIN
/*
    -- 예외 발생
    IF (TO_NUMBER(SYSDATE - VCRS_BD) < 0)
        THEN RAISE OC_DATE_ERROR;
    ELSIF (TO_NUMBER(SYSDATE - VCRS_ED) < 0)
        THEN RAISE OC_DATE_ERROR;
    END IF;
*/   
    -- 과정명 찾기 VCRS_NM
    SELECT CRS_NM INTO VCRS_NM
    FROM TBL_CRS
    WHERE CRS_CD = VCRS_CD;
    
    -- VOC_CD 개설과정 코드
     VOC_CD := TO_CHAR('A' || '_' || SUBSTR(VCRS_NM,1,2) || LPAD(SEQ_OC.NEXTVAL,3,'0'));
    
  
    INSERT INTO TBL_OC(OC_CD, CRS_CD, CRS_BD, CRS_ED, CRS_RM)
    VALUES(VOC_CD ,VCRS_CD, VCRS_BD, VCRS_ED, VCRS_RM);
    
    
    COMMIT;
    
/*  
    EXCEPTION
        WHEN OC_DATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20005, '유효하지 않은 날짜입니다');
                 ROLLBACK;
        WHEN OTHERS THEN ROLLBACK;
*/    
    
END;

--○ 데이터입력
EXEC PRC_OC_INSERT('SW001', '2021-02-01', '2021-07-09' , 'F반');
EXEC PRC_OC_INSERT('SW002', '2021-03-13', '2021-08-15' , 'H반');

--확인
SELECT *
FROM TBL_OC;


--⑧ 과목 개설 테이블 데이터입력
--● 과목개설등록 시퀀스 : SEQUENCE SEQ_OS_CODE
CREATE SEQUENCE SEQ_OS_CODE
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==>> Sequence SEQ_OS_CODE이(가) 생성되었습니다.

--과목개설등록 프로시저 : PRC_OS_INSERT
-- 예외처리 수정 후
--○ 과목개설등록 프로시저 : PRC_OS_INSERT
-- PRC_OS_INSERT(과정개설코드, 과목코드, 교수아이디, 교재코드, 배점코드, 과목시작날짜, 과목종료날짜)
-- PRC_OS_INSERT(과정개설코드, 과목코드, 교수아이디, 교재코드, 배점코드, NULL, NULL)
-- PRC_OS_INSERT(과정개설코드, 과목코드, 교수아이디, NULL, 배점코드, NULL, NULL)
CREATE OR REPLACE PROCEDURE PRC_OS_INSERT
(
    V_OC_CD     IN  TBL_OC.OC_CD%TYPE   -- 과정명
,   V_SUB_CD    IN  TBL_SUB.SUB_CD%TYPE -- 과목명
,   V_PR_ID     IN  TBL_PR.PR_ID%TYPE   -- 교수자 명
,   V_BK_CD     IN  TBL_BK.BK_CD%TYPE   -- 교재명
,   V_RAT_CD    IN  TBL_RAT.RAT_CD%TYPE -- 배점
,   V_SUB_BD    IN  TBL_OS.SUB_BD%TYPE  -- 과목시작날짜 (NULL 가능)
,   V_SUB_ED    IN  TBL_OS.SUB_ED%TYPE  -- 과목종료날짜 (NULL 가능)
)
IS

    TEMP                        TBL_OS.OS_CD%TYPE;
    V_OS_CD                     TBL_OS.OS_CD%TYPE;
    V_COUNT                      NUMBER; -- 개설과목 중복 체크
    V_COUNT1                     NUMBER; -- FK1 개설과정코드 체크
    V_COUNT2                     NUMBER; -- FK2 과목코드 체크  
    V_COUNT3                     NUMBER; -- FK3 교수아이디 체크
    V_COUNT4                     NUMBER; -- FK4 교재코드 체크
    V_COUNT5                     NUMBER; -- FK5 배점코드 체크
    
    ALREADY_REGISTERED_ERROR    EXCEPTION; -- 중복데이터 
    NOT_FOUND_ERROR             EXCEPTION; -- 외래키 참조시 부모테이블에 일치하는 값이 없을 때
    
BEGIN
    
    -- 과목 테이블의 과목코드를 담아서 EX) J001
    SELECT SUB_CD INTO TEMP
    FROM TBL_SUB
    WHERE SUB_CD = V_SUB_CD;

    -- 앞에 E 를 붙여서 과목개설 테이블의 개설과목코드로 만든다 EX) EJ001
    V_OS_CD := 'E' || TEMP;

    --동일한 개설과목코드이 있는지 체크
    SELECT COUNT(*) INTO V_COUNT
    FROM TBL_OS
    WHERE OS_CD = V_OS_CD;

    --FK1 개설과정코드 체크
    SELECT COUNT(*) INTO V_COUNT1
    FROM TBL_OC
    WHERE OC_CD = V_OC_CD;

    --FK2 과목코드 체크
    SELECT COUNT(*) INTO V_COUNT2
    FROM TBL_SUB
    WHERE SUB_CD = V_SUB_CD;
    
    --FK3 교수아이디 체크
    SELECT COUNT(*) INTO V_COUNT3
    FROM TBL_PR
    WHERE PR_ID = V_PR_ID;
    
    --FK4 교재명 체크
    SELECT COUNT(*) INTO V_COUNT4
    FROM TBL_BK
    WHERE BK_CD = V_BK_CD;
    
    --FK5 배점코드 체크
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
             THEN RAISE_APPLICATION_ERROR(-20001, '이미 존재하는 데이터입니다.');
             ROLLBACK;
        WHEN NOT_FOUND_ERROR
             THEN RAISE_APPLICATION_ERROR(-20002, '존재하지 않는 데이터가 포함되어있습니다.');
        WHEN OTHERS
             THEN ROLLBACK;
END;
--==>> Procedure PRC_OS_INSERT이(가) 컴파일되었습니다.


--○ 데이터 입력
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

--⑨ 수강내역 테이블 
-- 시퀀스 생성
CREATE SEQUENCE SEQ_REG
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--==> Sequence SEQ_REG이(가) 생성되었습니다.


--○ PRC_수강내역입력 PRC_REG_INSERT
CREATE OR REPLACE PROCEDURE PRC_REG_INSERT
( V_ST_ID   TBL_ST.ST_ID%TYPE   -- 학생 아이디
, V_OC_CD   TBL_OC.OC_CD%TYPE   -- 개설과정 코드
, V_REG_DT  TBL_REG.REG_DT%TYPE  DEFAULT SYSDATE
)
IS
    V_REG_CD    TBL_REG.REG_CD%TYPE; --수강내역 코드
    V_COUNT_ID     NUMBER;
    V_COUNT_CD     NUMBER;
    INCORRECT_ERROR  EXCEPTION;
    
BEGIN
    
    SELECT COUNT(*) INTO V_COUNT_ID -- 학생아이디가 일치하면
    FROM TBL_ST
    WHERE V_ST_ID = ST_ID;
    
    
    SELECT COUNT(*) INTO V_COUNT_CD -- 개설과정코드가 일치하면
    FROM TBL_OC
    WHERE V_OC_CD = OC_CD;
    
    IF ( (V_COUNT_ID = 1) AND (V_COUNT_CD = 1) )
        THEN
            -- 수강내역코드 생성
            V_REG_CD := 'RG' || LPAD(SEQ_REG.NEXTVAL,3,'0');
            
            -- TBL_REG 테이블에 데이터 입력
            INSERT INTO TBL_REG(REG_CD, ST_ID, OC_CD) 
            VALUES (V_REG_CD, V_ST_ID, V_OC_CD);
        
        -- 학생아이디나 개설과정코드가 없을 경우 에러 발생
        ELSE RAISE INCORRECT_ERROR;
    END IF;
    
        
    -- 커밋
    COMMIT;

    
    -- 예외처리
    EXCEPTION
        WHEN INCORRECT_ERROR
            THEN RAISE_APPLICATION_ERROR(-20004, '아이디나 개설과정코드가 일치하지 않습니다.');
                ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
END;
--==> Procedure PRC_REG_INSERT이(가) 컴파일되었습니다.

--○ 데이터 입력
EXEC PRC_REG_INSERT('ST001','A_SW001');
EXEC PRC_REG_INSERT('ST011','A_SW001');
EXEC PRC_REG_INSERT('ST013','A_SW002');
-->> 자신이 가진 학생들의 번호로 바꿔주기

-- 확인
SELECT *
FROM TBL_REG;


--○ PRC_수강내역조회  PRC_REG_LOOKUP
-- 학생 이름, 과정명, 수강과목, 수강과목 총점
CREATE OR REPLACE PROCEDURE PRC_REG_LOOKUP
(
    V_ST_ID     IN TBL_ST.ST_ID%TYPE    -- 학생아이디
)
IS
    V_ST_FN       TBL_ST.ST_FN%TYPE;   -- 학생 성
    V_ST_LN       TBL_ST.ST_LN%TYPE;   -- 학생 이름
    V_CRS_NM      TBL_CRS.CRS_NM%TYPE; -- 과정명
    V_SUB_NM      TBL_SUB.SUB_NM%TYPE; -- 과목명
    V_SC_AT       TBL_SC.SC_AT%TYPE;   -- 출결
    V_SC_WT       TBL_SC.SC_WT%TYPE;   -- 필기
    V_SC_PT       TBL_SC.SC_PT%TYPE;   -- 실기

    V_OC_CD       TBL_OC.OC_CD%TYPE;   -- 개설과정코드
    V_CRS_CD      TBL_CRS.CRS_CD%TYPE;  -- 과정코드
    V_SUB_CD      TBL_SUB.SUB_CD%TYPE;  -- 과목코드
    V_REG_CD      TBL_REG.REG_CD%TYPE; -- 수강신청코드
    
    V_SC_TOT        NUMBER;             -- 수강과목 총점
    
    V_MINNUM        NUMBER;
    V_MAXNUM        NUMBER;
    
BEGIN

    SELECT MIN(ROWNUM),MAX(ROWNUM) INTO V_MINNUM,V_MAXNUM
    FROM TBL_REG
    WHERE ST_ID = V_ST_ID;
    
    -- 수강내역-개설과정코드, 수강내역 - 수강신청코드
    SELECT OC_CD, REG_CD INTO V_OC_CD, V_REG_CD
    FROM TBL_REG
    WHERE ST_ID = V_ST_ID;
    
    LOOP
    
        -- 학생 이름
        SELECT ST_FN, ST_LN INTO V_ST_FN, V_ST_LN
        FROM TBL_ST
        WHERE ST_ID = V_ST_ID;
        
        -- 과정개설 - 개설과정코드 / 수강내역 - 개설과정코드 → 과정코드
        SELECT CRS_CD INTO V_CRS_CD
        FROM TBL_OC
        WHERE OC_CD = V_OC_CD;
        
        -- 과정 - 과정코드 / 과정개설 - 과정코드 → 과정명
        SELECT CRS_NM INTO V_CRS_NM
        FROM TBL_CRS
        WHERE CRS_CD = V_CRS_CD;
        
        -- 과목개설 - 개설과정코드 / 수강내역 - 개설과정코드 → 과목코드
        SELECT SUB_CD INTO V_SUB_CD
        FROM TBL_OS
        WHERE OC_CD = V_OC_CD;
        
        -- 과목 - 과목코드 / 과목개설 - 과목코드 → 과목명
        SELECT SUB_NM INTO V_SUB_NM
        FROM TBL_SUB
        WHERE SUB_CD = V_SUB_CD;
        
        -- 성적입력 - 수강신청코드 / 수강내역 - 수강신청코드 → 성적
        SELECT SC_AT, SC_WT, SC_PT INTO V_SC_AT, V_SC_WT, V_SC_PT
        FROM TBL_SC
        WHERE REG_CD = V_REG_CD;
        
        
        V_SC_TOT := (V_SC_AT + V_SC_WT + V_SC_PT);   --총점
        
    
        -- 학생 이름, 과정명, 수강과목, 수강과목 총점
        -- 학생 정보 출력
        DBMS_OUTPUT.PUT_LINE(V_MINNUM || '.');
        DBMS_OUTPUT.PUT_LINE('학생ID : ' || V_ST_ID);
        DBMS_OUTPUT.PUT_LINE('과정명 : ' || V_CRS_NM);
        DBMS_OUTPUT.PUT_LINE('수강과목 : ' || V_SUB_NM);
        DBMS_OUTPUT.PUT_LINE('수강과목 총점 : ' || V_SC_TOT);
        
        
        V_MINNUM := V_MINNUM+1;
        
        EXIT WHEN V_MINNUM > V_MAXNUM;
    
    END LOOP;
END;

CREATE OR REPLACE PROCEDURE PRC_REG_LOOKUP
(
    V_ST_ID     IN TBL_ST.ST_ID%TYPE    -- 학생아이디
)
IS
    V_ST_FN       TBL_ST.ST_FN%TYPE;   -- 학생 성
    V_ST_LN       TBL_ST.ST_LN%TYPE;   -- 학생 이름
    V_CRS_NM      TBL_CRS.CRS_NM%TYPE; -- 과정명
    V_SUB_NM      TBL_SUB.SUB_NM%TYPE; -- 과목명
    V_SC_AT       TBL_SC.SC_AT%TYPE;   -- 출결
    V_SC_WT       TBL_SC.SC_WT%TYPE;   -- 필기
    V_SC_PT       TBL_SC.SC_PT%TYPE;   -- 실기

    V_OC_CD       TBL_OC.OC_CD%TYPE;   -- 개설과정코드
    V_CRS_CD      TBL_CRS.CRS_CD%TYPE;  -- 과정코드
    V_SUB_CD      TBL_SUB.SUB_CD%TYPE;  -- 과목코드
    V_REG_CD      TBL_REG.REG_CD%TYPE; -- 수강신청코드
    
    V_SC_TOT        NUMBER;             -- 수강과목 총점
    
    V_MINNUM        NUMBER;
    V_MAXNUM        NUMBER;
    
BEGIN

    SELECT MIN(ROWNUM),MAX(ROWNUM) INTO V_MINNUM,V_MAXNUM
    FROM TBL_REG
    WHERE ST_ID = V_ST_ID;
    
    
    
    LOOP
        --수강신청코드, 개설과정코드
        SELECT OC_CD, REG_CD INTO V_OC_CD, V_REG_CD
        FROM TBL_REG
        WHERE ST_ID = V_ST_ID;
        
        -- 학생 이름
        SELECT ST_FN, ST_LN INTO V_ST_FN, V_ST_LN
        FROM TBL_ST
        WHERE ST_ID = V_ST_ID;
        
        
        -- 과정 - 과정코드 / 과정개설 - 과정코드 → 과정명
        SELECT CRS_NM INTO V_CRS_NM
        FROM TBL_CRS
        WHERE CRS_CD = (SELECT CRS_CD
                        FROM TBL_OC
                        WHERE OC_CD = V_OC_CD);
         
        
        -- 과목 - 과목코드 / 과목개설 - 과목코드 → 과목명
        SELECT SUB_NM INTO V_SUB_NM
        FROM TBL_SUB
        WHERE SUB_CD = (SELECT SUB_CD 
                        FROM TBL_OS
                        WHERE OC_CD = V_OC_CD);
        
        
        -- 성적입력 - 수강신청코드 / 수강내역 - 수강신청코드 → 성적
        SELECT SC_AT, SC_WT, SC_PT INTO V_SC_AT, V_SC_WT, V_SC_PT
        FROM TBL_SC
        WHERE REG_CD = V_REG_CD;
        
        
        V_SC_TOT := (V_SC_AT + V_SC_WT + V_SC_PT);   --총점
        
    
        -- 학생 이름, 과정명, 수강과목, 수강과목 총점
        -- 학생 정보 출력
        DBMS_OUTPUT.PUT_LINE(V_MINNUM || '.');
        DBMS_OUTPUT.PUT_LINE('학생이름 : ' || V_ST_FN || V_ST_LN);
        DBMS_OUTPUT.PUT_LINE('과정명 : ' || V_CRS_NM);
        DBMS_OUTPUT.PUT_LINE('수강과목 : ' || V_SUB_NM);
        DBMS_OUTPUT.PUT_LINE('수강과목 총점 : ' || V_SC_TOT);
        
        
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

--⑩ 중도탈락 테이블 데이터입력
--○ 중도탈락코드 생성용 시퀀스 생성
CREATE SEQUENCE SEQ_QUIT
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;


--○ 중도탈락 입력 프로시저 생성
CREATE OR REPLACE PROCEDURE PRC_QUIT_INSERT
(   V_REG_CD    IN TBL_QT.REG_CD%TYPE
,   V_QT_DT     IN TBL_QT.QT_DT%TYPE   DEFAULT SYSDATE
)
IS
    V_QT_CD             VARCHAR2(10);
    V_COUNT             NUMBER;
    DUPLICATE_ERROR     EXCEPTION;
BEGIN
    --수강신청코드 중복 여부 확인
    SELECT COUNT(*) INTO V_COUNT
    FROM TBL_QT
    WHERE REG_CD = V_REG_CD;
    
    --중복이 아닐 경우 데이터 입력
    IF V_COUNT = 0
        THEN
            --중도탈락코드 생성
            V_QT_CD := 'Q' || LPAD(SEQ_QUIT.NEXTVAL,3,'0');
            --TBL_REG 테이블에 데이터 입력
            INSERT INTO TBL_QT(QT_CD,REG_CD) VALUES(V_QT_CD,V_REG_CD);
    --중복일 경우 에러 발생
    ELSE RAISE DUPLICATE_ERROR;
    END IF;
    
    --커밋
    COMMIT;
    
    --예외처리
    EXCEPTION
        WHEN DUPLICATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'이미 존재하는 데이터입니다.');
                 ROLLBACK;
        WHEN OTHERS
            THEN ROLLBACK;
END;

--○ 데이터입력
EXEC PRC_QUIT_INSERT('RG001',SYSDATE);
EXEC PRC_QUIT_INSERT('RG002',SYSDATE);

-- 확인
SELECT *
FROM TBL_QT;



--⑪ 성적 테이블 데이터 입력
--○ 성적 입력 프로시저 작성
CREATE OR REPLACE PROCEDURE PRC_SC_INSERT
(
    V_REG_CD    IN TBL_REG.REG_CD%TYPE   -- 수강신청 코드 
,   V_OS_CD     IN TBL_OS.OS_CD%TYPE    -- 개설과목 코드 
,   V_SC_AT     IN TBL_SC.SC_AT%TYPE    -- 출결 
,   V_SC_WT     IN TBL_SC.SC_WT%TYPE    -- 필기 
,   V_SC_PT     IN TBL_SC.SC_PT%TYPE    -- 실기 
)
IS
    V_SC_CD             TBL_SC.SC_CD%TYPE;      -- 성적 코드 
    V_COUNT_RCD         NUMBER;                 -- 수강신청 코드 카운트
    V_COUNT_OCD         NUMBER;                 -- OS_CD의 줄임말 = 과목개설코드 카운트
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

         -- 테이블에 데이터 입력 
    INSERT INTO TBL_SC(SC_CD, REG_CD, OS_CD, SC_AT, SC_WT, SC_PT)
    VALUES (V_SC_CD, V_REG_CD, V_OS_CD, V_SC_AT, V_SC_WT, V_SC_PT);
    
    COMMIT;
    
   EXCEPTION
        WHEN DUPLICATE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'이미 존재하는 데이터입니다.');
                 ROLLBACK;
        WHEN TOTAL_SC_ERROR
            THEN RAISE_APPLICATION_ERROR(-20003,'배점 비율을 고려하여 입력하여 주십시오.');
        WHEN OTHERS
            THEN ROLLBACK;
END;
--==> Procedure PRC_SC_INSERT이(가) 컴파일되었습니다.

--○ 데이터 입력
EXEC PRC_SC_INSERT('RG001', 'A006', 5,10,20);
EXEC PRC_SC_INSERT('RG002', 'A006', 10,10,10);

SELECT *
FROM TBL_SC;