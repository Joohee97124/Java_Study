SELECT USER
FROM DUAL;
--==>> SCOTT

SET SERVEROUTPUT ON;
--==>> 작업이 완료되었습니다.

--○ SCOTT.TBL_INSA 테이블의 여러 명의 데이터 여러 개를 변수에 저장
--   (은 안되고 반복문 활용 출력하기)

DECLARE
    VINSA TBL_INSA%ROWTYPE;
    VNUM  TBL_INSA.NUM%TYPE := 1001;
BEGIN  
    LOOP
        SELECT NAME, TEL, BUSEO
            INTO VINSA.NAME, VINSA.TEL, VINSA.BUSEO
        FROM TBL_INSA
        WHERE NUM = VNUM;
        
        DBMS_OUTPUT.PUT_LINE(VINSA.NAME || '-' || VINSA.TEL || '-' || VINSA.BUSEO);
        
        EXIT WHEN VNUM >= 1060;
        
        VNUM := VNUM +1;            -- VNUM 을 1만큼 증가
        
    END LOOP;
END;
--==>>
/*
홍길동-011-2356-4528-기획부
이순신-010-4758-6532-총무부
이순애-010-4231-1236-개발부
김정훈-019-5236-4221-영업부
한석봉-018-5211-3542-총무부
이기자-010-3214-5357-개발부
장인철-011-2345-2525-개발부
김영년-016-2222-4444-홍보부
나윤균-019-1111-2222-인사부
김종서-011-3214-5555-영업부
유관순-010-8888-4422-영업부
정한국-018-2222-4242-홍보부
조미숙-019-6666-4444-홍보부
황진이-010-3214-5467-개발부
이현숙-016-2548-3365-총무부
이상헌-010-4526-1234-개발부
엄용수-010-3254-2542-개발부
이성길-018-1333-3333-개발부
박문수-017-4747-4848-인사부
유영희-011-9595-8585-자재부
홍길남-011-9999-7575-개발부
이영숙-017-5214-5282-기획부
김인수--영업부
김말자-011-5248-7789-기획부
우재옥-010-4563-2587-영업부
김숙남-010-2112-5225-영업부
김영길-019-8523-1478-총무부
이남신-016-1818-4848-인사부
김말숙-016-3535-3636-총무부
정정해-019-6564-6752-총무부
지재환-019-5552-7511-기획부
심심해-016-8888-7474-자재부
김미나-011-2444-4444-영업부
이정석-011-3697-7412-기획부
정영희--개발부
이재영-011-9999-9999-자재부
최석규-011-7777-7777-홍보부
손인수-010-6542-7412-영업부
고순정-010-2587-7895-영업부
박세열-016-4444-7777-인사부
문길수-016-4444-5555-자재부
채정희-011-5125-5511-개발부
양미옥-016-8548-6547-영업부
지수환-011-5555-7548-영업부
홍원신-011-7777-7777-영업부
허경운-017-3333-3333-총무부
산마루-018-0505-0505-영업부
이기상--개발부
이미성-010-6654-8854-개발부
이미인-011-8585-5252-홍보부
권영미-011-5555-7548-영업부
권옥경-010-3644-5577-기획부
김싱식-011-7585-7474-자재부
정상호-016-1919-4242-홍보부
정한나-016-2424-4242-영업부
전용재-010-7549-8654-영업부
이미경-016-6542-7546-자재부
김신제-010-2415-5444-기획부
임수봉-011-4151-4154-개발부
김신애-011-4151-4444-개발부


PL/SQL 프로시저가 성공적으로 완료되었습니다.
*/

-----------------------------------------------------------------------------------

--■■■ FUNCTION(함수) ■■■--

-- 1. 함수란 하나 이상의 PL / SQL 문으로 구성된 서브루틴으로
--    코드를 다시 사용할 수 있도록 캡슐화 하는데 사용된다.
--    오라클에서는 오라클에 정의된 기본 제공 함수를 사용하거나
--    직접 스토어드 함수를 만들 수 있다 (→ 사용자 정의 함수)
--    이 사용자 정의 함수는 시스템 함수처럼 쿼리에서 호출하거나
--    저장 프로시저처럼 EXECUTE 문을 통해 실행할 수 있다.

-- 2. 형식 및 구조
/*
CREATE [OR REPLACE] FUNCTION 함수명
[(
    매개변수1 자료형
    , 매개변수2 자료형
)]
RETURN 데이터타입
IS
    -- 주요 변수 선언 (지역변수)
BEGIN
    -- 실행문;
    ...
    RETURN 값;
    
    
    [EXCEPTION]
        -- 예외 처리 구문;
END;
*/

--※ 사용자 정의 함수(스토어드 함수)는
--   IN 파라미터(입력 매개변수)만 사용할 수 있으며
--   반드시 반환될 값의 데이터타입을 RETURN 문에 선언해야 하고,
--   FUNCTION 은 반드시 단일 값만 반환한다.


--○ TBL_INSA 테이블을 대상으로 
--   주민번호를 가지고 성별을 조회한다.
SELECT NAME, SSN, DECODE( SUBSTR(SSN, 8, 1), 1, '남자' , 2 ,'여자') "성별"
FROM TBL_INSA;

--○ FUNCTION 생성
-- 함수명 : FN_GENDER()
--                   ↑ SSN(주민등록번호) → 'YYMMDD-NNNNNNN'

CREATE OR REPLACE FUNCTION FN_GENDER
(
    VSSN VARCHAR2       -- 매개변수 : 자릿수(길이) 지정 안함
)
RETURN VARCHAR2         -- 반환자료형 : 자릿수(길이) 지정 안함
IS
    -- 주요 변수 선언
    VRESULT VARCHAR2(20);
BEGIN
    -- 연산 및 처리
    IF (SUBSTR(VSSN,8,1) IN ('1','3'))
        THEN VRESULT := '남자';
    ELSIF (SUBSTR(VSSN,8,1) IN ('2','4'))
        THEN VRESULT := '여자';
    ELSE
        VRESULT := '성별확인불가';
        
    END IF;
    
    -- 최종 결과값 반환
    RETURN VRESULT;
END;
--==>> Function FN_GENDER이(가) 컴파일되었습니다.



--○ 임의의 정수 두 개를 매개변수 (입력 파라미터) 로 넘겨받아
--   A 의 B 승의 값을 반환하는 사용자 정의 함수를 작성한다.
--   함수명 : FN_POW()
/*
사용 예)
SELECT FN_POW(10,3)
FROM DUAL;
--==>> 1000
*/

CREATE OR REPLACE FUNCTION FN_POW
(  
    VNUM1 NUMBER 
    , VNUM2 NUMBER 
)
RETURN NUMBER
IS 
    COUNT NUMBER := 1;
    VNUM3 NUMBER ; 
BEGIN
    VNUM3 := 1;
    FOR COUNT IN 1..VNUM2 LOOP
        VNUM3 := VNUM3 * VNUM1;
    END LOOP;
    
    RETURN VNUM3;
END;
--==>> Function FN_POW이(가) 컴파일되었습니다.

SELECT FN_POW(10,3)
FROM DUAL;
--==>> 1000

----------------------------------[선생님 풀이]---------------------------------

CREATE OR REPLACE FUNCTION FN_POW
(
    A NUMBER                        -- 10
  , B NUMBER                        -- 3
)
RETURN NUMBER
IS 
    VRESULT NUMBER := 1;            -- 누적곱
    VNUM NUMBER;
    
BEGIN
    FOR VNUM IN 1..B LOOP           -- 1 ~ 3
        VRESULT := VRESULT * A ;    -- 1 * 10 * 10 * 10 
    END LOOP;
    
    RETURN VRESULT;
    
END;
--==>> Function FN_POW이(가) 컴파일되었습니다.


-- < 과제 >
--○ TBL_INSA 테이블의 급여 계산 전용 함수를 정의한다.
--   급여는 (기본급*12)+수당 기반으로 연산을 수행한다.
--   함수명 : FN_PAY(기본급, 수당)
CREATE OR REPLACE FUNCTION FN_PAY
(
    V_BASICPAY  IN TBL_INSA.BASICPAY%TYPE
    , V_SUDANG  IN TBL_INSA.SUDANG%TYPE
)
RETURN NUMBER
IS
    V_PAY NUMBER;
    
BEGIN
    V_PAY := (V_BASICPAY *12) + V_SUDANG;
    
    RETURN V_PAY;
END;
--==>> Function FN_PAY이(가) 컴파일되었습니다.

-- 확인
SELECT NAME, BASICPAY, SUDANG, FN_PAY(BASICPAY,SUDANG)"급여"
FROM TBL_INSA;
--==>> 
/*
홍길동	2610000	200000	31520000
이순신	1320000	200000	16040000
이순애	2550000	160000	30760000
김정훈	1954200	170000	23620400
한석봉	1420000	160000	17200000
이기자	2265000	150000	27330000
장인철	1250000	150000	15150000
김영년	950000	145000	11545000
나윤균	840000	220400	10300400
김종서	2540000	130000	30610000
유관순	1020000	140000	12380000
정한국	880000	114000	10674000
조미숙	1601000	103000	19315000
황진이	1100000	130000	13330000
이현숙	1050000	104000	12704000
이상헌	2350000	150000	28350000
엄용수	950000	210000	11610000
이성길	880000	123000	10683000
박문수	2300000	165000	27765000
유영희	880000	140000	10700000
홍길남	875000	120000	10620000
이영숙	1960000	180000	23700000
김인수	2500000	170000	30170000
김말자	1900000	170000	22970000
우재옥	1100000	160000	13360000
김숙남	1050000	150000	12750000
김영길	2340000	170000	28250000
이남신	892000	110000	10814000
김말숙	920000	124000	11164000
정정해	2304000	124000	27772000
지재환	2450000	160000	29560000
심심해	880000	108000	10668000
김미나	1020000	104000	12344000
이정석	1100000	160000	13360000
정영희	1050000	140000	12740000
이재영	960400	190000	11714800
최석규	2350000	187000	28387000
손인수	2000000	150000	24150000
고순정	2010000	160000	24280000
박세열	2100000	130000	25330000
문길수	2300000	150000	27750000
채정희	1020000	200000	12440000
양미옥	1100000	210000	13410000
지수환	1060000	220000	12940000
홍원신	960000	152000	11672000
허경운	2650000	150000	31950000
산마루	2100000	112000	25312000
이기상	2050000	106000	24706000
이미성	1300000	130000	15730000
이미인	1950000	103000	23503000
권영미	2260000	104000	27224000
권옥경	1020000	105000	12345000
김싱식	960000	108000	11628000
정상호	980000	114000	11874000
정한나	1000000	104000	12104000
전용재	1950000	200000	23600000
이미경	2520000	160000	30400000
김신제	1950000	180000	23580000
*/


--○ TBL_INSA 테이블의 입사일을 기준으로
--   현재까지의 근무년수를 반환하는 함수를 정의한다.
--   단, 근무년수는 소수점 이하 한자리까지 계산한다.
---  함수명 : FN_WORKYEAR(입사일)
CREATE OR REPLACE FUNCTION FN_WORKYEAR
(
 V_IBSADATE IN TBL_INSA.IBSADATE%TYPE
 
)
RETURN NUMBER
IS
    V_GUNU NUMBER(4,1);      -- 근무년수
BEGIN
    V_GUNU := (MONTHS_BETWEEN(SYSDATE, V_IBSADATE))/12;
    
    RETURN V_GUNU;
END;
--==>> Function FN_WORKYEAR이(가) 컴파일되었습니다

-- 확인
SELECT NAME, IBSADATE, FN_WORKYEAR(IBSADATE)"근무년도"
FROM TBL_INSA;
--==>>
/*
홍길동	1998-10-11	22.5
이순신	2000-11-29	20.4
이순애	1999-02-25	22.1
김정훈	2000-10-01	20.5
한석봉	2004-08-13	16.7
이기자	2002-02-11	19.2
장인철	1998-03-16	23.1
김영년	2002-04-30	18.9
나윤균	2003-10-10	17.5
김종서	1997-08-08	23.7
유관순	2000-07-07	20.8
정한국	1999-10-16	21.5
조미숙	1998-06-07	22.8
황진이	2002-02-15	19.1
이현숙	1999-07-26	21.7
이상헌	2001-11-29	19.4
엄용수	2000-08-28	20.6
이성길	2004-08-08	16.7
박문수	1999-12-10	21.3
유영희	2003-10-10	17.5
홍길남	2001-09-07	19.6
이영숙	2003-02-25	18.1
김인수	1995-02-23	26.1
김말자	1999-08-28	21.6
우재옥	2000-10-01	20.5
김숙남	2002-08-28	18.6
김영길	2000-10-18	20.5
이남신	2001-09-07	19.6
김말숙	2000-09-08	20.6
정정해	1999-10-17	21.5
지재환	2001-01-21	20.2
심심해	2000-05-05	20.9
김미나	1998-06-07	22.8
이정석	2005-09-26	15.5
정영희	2002-05-16	18.9
이재영	2003-08-10	17.7
최석규	1998-10-15	22.5
손인수	1999-11-15	21.4
고순정	2003-12-28	17.3
박세열	2000-09-10	20.6
문길수	2001-12-10	19.3
채정희	2003-10-17	17.5
양미옥	2003-09-24	17.5
지수환	2004-01-21	17.2
홍원신	2003-03-16	18.1
허경운	1999-05-04	21.9
산마루	2001-07-15	19.7
이기상	2001-06-07	19.8
이미성	2000-04-07	21
이미인	2003-06-07	17.8
권영미	2000-06-04	20.8
권옥경	2000-10-10	20.5
김싱식	1999-12-12	21.3
정상호	1999-10-16	21.5
정한나	2004-06-07	16.8
전용재	2004-08-13	16.7
이미경	1998-02-11	23.2
김신제	2003-08-08	17.7
임수봉	2001-10-10	19.5
김신애	2001-10-10	19.5
*/


------------------------------------------------------------------------------------

--※ 참고
-- 1. INSERT, UPDATE, DELETE, (MERGE)
--==>> DML(Data Manipulation Language)
-- COMMIT / ROLLBACK 이 필요하다

-- 2. CREATE, DROP, ALTER, (TRUNCATE)
--==>> DDL (Data Definition Language)
-- 실행하면 자동으로 COMMIT 된다.

-- 3. GRANT, REVOKE
--==>> DCL(Data Control Language)
-- 실행하면 자동으로 COMMIT 된다

-- 4. COMMIT, ROLLBACK
--==>> TCL(Transcation Control Language)


-- 정적 PL/SQL문 → DML문, TCL문만 사용 가능하다
-- 동적 PL/SQL문 → DML문, DDL문, DCL문, TCL문 사용가능하다

--※ 정적 SQL (정적PL/SQL)
--> 기본적으로 사용하는 SQL 구문과
-- PL/SQL 구문 안에 SQL 구문을 직접 삽입하는 방법
--> 작성이 쉽고 성능이 좋다

--※ 동적 SQL (동적PL/SQL)   → EXECUTE, IMMEDIATE
--> 완성되지 않은 SQL 구문을 기반으로
--  실행 중 변경 가능한 문자열 변수 또는 문자열 상수를 통해
--  SQL 구문을 동적으로 완성하여 실행하는 방법
--> 사전에 정의되지 않은 SQL 을 실행할 때 완성/확장하여 실행할 수 있다.
--  DML, TCL 외에도 DDL, DCL, TCL 사용이 가능하다


------------------------------------------------------------------------------------


--■■■ PROCEDURE(프로시저) ■■■--

-- 1. PL/SQL 에서 가장 대표적인 구조인 스토어드 프로시저는
--    개발자가 자주 작성해야 하는 업무의 흐름을
--    미리 작성하여 데이터베이스 내에 저장해 두었다가
--    필요할 때 마다 호출하여 실행할 수 있도록 처리해주는 구문이다.

-- 2. 형식 및 구조
/*
CREATE [OR REPLACE] PROCEDURE 프로시저명
[( 매개변수 IN 데이터타입
    , 매개변수 OUT 데이터타입
    , 매개변수 INOUT 데이터타입
)]
IS
    [-- 주요변수 선언;]
BEGIN
    -- 실행 구문;
    ...
    [EXCEPTION
        -- 예외 처리 구문;]
END;
*/


--※ FUNCTION 과 비교했을 때...
--   『RETURN 반환자료형』 부분이 존재하지 않으며,
--   『RETURN』문 자체도 존재하지 않으며,
--   프로시저 실행 시 넘겨주게 되는 매개변수의 종류는 
--   IN, OUT, INOUT 으로 구분된다.


-- 3. 실행(호출)
/*
EXEC[UTE] 프로시저명[(인수1, 인수2)];
*/


--○ INSERT 쿼리 실행을 프로시저로 작성 (INSERT 프로시저)

-- 실습 테이블 생성 (TBL_STUDENTS) → 20210408_04_scott.sql 참조
-- 실습 테이블 생성(TBL_IDPW) → 20210408_04_scott.sql 참조

-- 프로시저 생성
-- 프로시저명 : PRC_STUDENTS_INSERT(아이디, 패스워드, 이름, 전화번호, 주소)

CREATE OR REPLACE PROCEDURE PRC_STUDENTS_INSERT
( V_ID      IN TBL_STUDENTS.ID%TYPE         --IN TBL_IDPW.ID%TYPE
, V_PW      IN TBL_IDPW.PW%TYPE    
, V_NAME    IN TBL_STUDENTS.NAME%TYPE
, V_TEL     IN TBL_STUDENTS.TEL%TYPE
, V_ADDR    IN TBL_STUDENTS.ADDR%TYPE
)
IS
    -- 주요 변수 선언 -> 필요 X
BEGIN
    -- TBL_IDPW 테이블에 데이터 입력
    INSERT INTO TBL_IDPW(ID,PW)
    VALUES(V_ID, V_PW);
    
    -- TBL_STUDENTS 테이블에 데이터 입력
    INSERT INTO TBL_STUDENTS(ID, NAME, TEL, ADDR)
    VALUES(V_ID, V_NAME, V_TEL, V_ADDR);
    
    -- 커밋
    COMMIT;
    
END;
--==>> Procedure PRC_STUDENTS_INSERT이(가) 컴파일되었습니다.




-- 실습 테이블 생성(TBL_SUNGJUK) → 20210408_04_scott.sql 참조
--○ 데이터 입력 시
--   특정 항목의 데이터 (학번, 이름, 국어점수, 영어점수, 수학점수) 만 입력하면
--   내부적으로 총점, 평균, 등급 항목이 함께 입력 처리 될 수 있도록 하는
--   프로시저를 작성한다. (생성한다)
--   프로시저명 : PRC_SUNJUK_INSERT()
/*
실행 예)
EXEC PRC_SUNGJUK_INSERT(1,'조은선',90,80,70);

프로시저 호출로 처리된 결과 )
학번  이름  국어점수    영어점수    수학점수    총점  평균  등급
 1    조은선   90          80          70      240    80   B
*/


CREATE OR REPLACE PROCEDURE PRC_SUNGJUK_INSERT
(
    V_HAKBUN    IN  TBL_SUNGJUK.HAKBUN%TYPE
    , V_NAME    IN  TBL_SUNGJUK.NAME%TYPE
    , V_KOR     IN  TBL_SUNGJUK.KOR%TYPE
    , V_ENG     IN  TBL_SUNGJUK.ENG%TYPE
    , V_MAT     IN  TBL_SUNGJUK.MAT%TYPE
)
IS
    -- INSERT 쿼리문을 수행하는데 필요한 주요 변수 선언
    V_TOT      TBL_SUNGJUK.TOT%TYPE;
    V_AVG      TBL_SUNGJUK.AVG%TYPE;
    V_GRADE    TBL_SUNGJUK.GRADE%TYPE;

BEGIN
    -- 아래의 쿼리문을 실행하기 위해서는
    -- 선언한 변수들에 값을 담아내야 한다 (V_TOT, V_AVG, V_GRADE)
    V_TOT := V_KOR+V_ENG+V_MAT;
    V_AVG := V_TOT/3;
    
    IF V_AVG >= 90
        THEN V_GRADE := 'A';
    ELSIF V_AVG >= 80
        THEN V_GRADE := 'B';
    ELSIF V_AVG >= 70 
        THEN V_GRADE := 'C';
    ELSE
        V_GRADE := 'F';
    END IF;
    
    -- 삽입 구문
    INSERT INTO TBL_SUNGJUK(HAKBUN, NAME, KOR, ENG, MAT, TOT, AVG, GRADE)
    VALUES(V_HAKBUN, V_NAME, V_KOR, V_ENG, V_MAT, V_TOT, V_AVG, V_GRADE);
    
    --커밋
    COMMIT;
    
END;
--==>> Procedure PRC_SUNGJUK_INSERT이(가) 컴파일되었습니다.




--○ TBL_SUNGJUK 테이블에서
--   특정 학생의 점수 (학번, 국어점수, 영어점수, 수학점수)
--   데이터 수정 시 총점, 평균, 등급까지 수정하는 프로시저를 작성한다
--   프로시저명 : PRC_SUNGJUK_UPDATE
/*
실행 예)
EXEC PRC_SUNGJUK_UPDATE(1,50,50,50);

프로시저 호출로 처리된 결과)
학번  이름  국어점수    영어점수    수학점수    총점  평균  등급
 1    조은선   50          50          50      150    50   F
*/

CREATE OR REPLACE PROCEDURE PRC_SUNGJUK_UPDATE
(
    V_HAKBUN    IN TBL_SUNGJUK.HAKBUN%TYPE
    , V_KOR       IN TBL_SUNGJUK.KOR%TYPE
    , V_ENG       IN TBL_SUNGJUK.ENG%TYPE
    , V_MAT       IN TBL_SUNGJUK.MAT%TYPE
)
IS
    V_TOT   TBL_SUNGJUK.TOT%TYPE;
    V_AVG   TBL_SUNGJUK.AVG%TYPE;
    V_GRADE TBL_SUNGJUK.GRADE%TYPE;
    
BEGIN
    -- 연산
    V_TOT := V_KOR + V_ENG + V_MAT;
    V_AVG := V_TOT/3 ;
    
    IF V_AVG >= 90
        THEN V_GRADE := 'A';
    ELSIF V_AVG >= 80
        THEN V_GRADE := 'B';
    ELSIF V_AVG >= 70 
        THEN V_GRADE := 'C';
    ELSE
        V_GRADE := 'F';
    END IF;
    
    --UPDATE문
    UPDATE TBL_SUNGJUK
    SET KOR = V_KOR
        ,ENG = V_ENG
        , MAT = V_MAT
        , TOT = V_TOT
        , AVG = V_AVG
        , GRADE = V_GRADE
    WHERE HAKBUN = V_HAKBUN;
    
    -- 커밋
    COMMIT;
END;
--==>> Procedure PRC_SUNGJUK_UPDATE이(가) 컴파일되었습니다.



--○ TBL_STUDENT 테이블에서
--   전화번호와 주소 데이터를 수정하는 (변경하는) 프로시저를 작성한다.
--   단, ID 와 PW 가 일치하는 경우에만 수정을 진행할 수 있도록 작성한다.
--   프로시저 명 : PRC_STUDENTS_UPDATE
/*
실행 예)
EXEC PRC_STUDENTS_UPDATE('superman', 'java006$', '010-9999-9999', '경기 일산');

프로시저 호출로 처리된 결과 )
superman	박정준	010-9999-9999	경기 일산
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
    
    --UPDATE문 
    UPDATE TBL_STUDENTS
    SET TEL = V_TEL
      , ADDR = V_ADDR
    WHERE ID = V_ID
        AND (SELECT PW
             FROM TBL_IDPW
             WHERE ID = V_ID) = V_PW;
        
    -- 커밋
    COMMIT;

END;
--==>> Procedure PRC_STUDENTS_UPDATE이(가) 컴파일되었습니다.










