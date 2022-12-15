SELECT USER
FROM DUAL;
--==> SCOTT


--■■■ UNION / UNION ALL ■■■

--○ 실습 테이블 생성(TBL_JUMUN)
CREATE TABLE TBL_JUMUN              -- 주문 테이블 생성
( JUNO      NUMBER                  -- 주문 번호
, JECODE    VARCHAR2(30)            -- 주문된 제품 코드
, JUSU      NUMBER                  -- 주문 수량
, JUDAY     DATE DEFAULT SYSDATE    -- 주문 일자
);
--==> Table TBL_JUMUN이(가) 생성되었습니다.
--> 고객의 주문이 발생했을 경우 주문 내용에 대한 데이터가 입력될 수 있는 테이블


--○ 데이터 입력 → 고객의 주문 발생 / 접수
INSERT INTO TBL_JUMUN VALUES
(1, '쫀득초코칩', 20, TO_DATE('2001-11-01 09:05:12', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN VALUES
(2, '와클', 10, TO_DATE('2001-11-01 09:23:37', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN VALUES
(3, '꼬북칩', 30, TO_DATE('2001-11-01 11:41:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN VALUES
(4, '칙촉', 12, TO_DATE('2001-11-02 10:22:12', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN VALUES
(5, '홈런볼', 50, TO_DATE('2001-11-03 15:50:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN VALUES
(6, '바나나킥', 40, TO_DATE('2001-11-04 11:10:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN VALUES
(7, '눈을감자', 10, TO_DATE('2001-11-10 10:10:10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN VALUES
(8, '포카칩', 40, TO_DATE('2001-11-13 09:41:14', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN VALUES
(9, '감자칩', 20, TO_DATE('2001-11-14 14:20:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TBL_JUMUN VALUES
(10, '칸쵸', 20, TO_DATE('2001-11-20 14:17:00', 'YYYY-MM-DD HH24:MI:SS'));
--==> 1 행 이(가) 삽입되었습니다. * 10


ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--==> Session이(가) 변경되었습니다.


--○ 확인
SELECT *
FROM TBL_JUMUN;
--==>
/*
1	쫀득초코칩	20	2001-11-01 09:05:12
2	와클	    10	2001-11-01 09:23:37
3	꼬북칩	    30	2001-11-01 11:41:00
4	칙촉	    12	2001-11-02 10:22:12
5	홈런볼	    50	2001-11-03 15:50:00
6	바나나킥	40	2001-11-04 11:10:00
7	눈을감자	10	2001-11-10 10:10:10
8	포카칩	    40	2001-11-13 09:41:14
9	감자칩	    20	2001-11-14 14:20:00
10	칸쵸	    20	2001-11-20 14:17:00
*/

--○ 커밋
COMMIT;
--==> 커밋 완료.


--○ 데이터 추가 입력 → 2001 년 부터 시작된 주문이 현재(2021년)까지 계속 발생~!!!
INSERT INTO TBL_JUMUN VALUES (938765, '홈런볼', 10, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938766, '빈츠', 10, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938767, '와클', 10, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938768, '홈런볼', 50, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938769, '꼬북칩', 30, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938770, '꼬북칩', 20, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938771, '꼬북칩', 10, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938772, '포카칩', 40, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938773, '포카칩', 20, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938774, '칸쵸', 20, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938775, '칸쵸', 10, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
INSERT INTO TBL_JUMUN VALUES (938776, '바나나킥', 10, SYSDATE);
--==> 1 행 이(가) 삽입되었습니다.
        


--○ 확인
SELECT *
FROM TBL_JUMUN;
--==>
/*
1	    쫀득초코칩	20	2001-11-01 09:05:12
2	    와클	    10	2001-11-01 09:23:37
3	    꼬북칩	    30	2001-11-01 11:41:00
4	    칙촉	    12	2001-11-02 10:22:12
5	    홈런볼	    50	2001-11-03 15:50:00
6	    바나나킥	40	2001-11-04 11:10:00
7	    눈을감자	10	2001-11-10 10:10:10
8	    포카칩	    40	2001-11-13 09:41:14
9	    감자칩	    20	2001-11-14 14:20:00
10	    칸쵸	    20	2001-11-20 14:17:00
                     :
                     :
938765	홈런볼	    10	2021-04-01 14:23:22
938766	빈츠	    10	2021-04-01 14:24:14
938767	와클	    10	2021-04-01 14:24:58
938768	홈런볼	    50	2021-04-01 14:25:26
938769	꼬북칩	    30	2021-04-01 14:25:48
938770	꼬북칩	    20	2021-04-01 14:26:36
938771	꼬북칩	    10	2021-04-01 14:26:57
938772	포카칩	    40	2021-04-01 14:27:38
938773	포카칩	    20	2021-04-01 14:27:56
938774	칸쵸	    20	2021-04-01 14:28:26
938775	칸쵸	    10	2021-04-01 14:28:42
938776	바나나킥	10	2021-04-01 14:29:02
*/


--※ 유림이가 2001년도 부터 과자 쇼핑몰 운영중...
--   TBL_JUMUN 테이블이 너무 무거워진 상황
--   어플리케이션과의 연동으로 인해 주문 내역을 다른 테이블에 저장할 수 있도록
--   만드는 것은 힘든 상황
--   기존의 모든 데이터를 덮어놓고 지우는 것도 불가능한 상황
--   → 결과적으로 현재까지 누적된 주문 데이터 중
--      금일 발생한 주문 내역을 제외하고
--      나머지를 다른 테이블(TBL_JUMUNBACKUP)로 
--      데이터 이관을 수행할 계획



--○ 위의 조회 결과로 TBL_JUMUNBACKUP 테이블 생성
CREATE TABLE TBL_JUMUNBACKUP
AS
SELECT *
FROM TBL_JUMUN
WHERE TO_CHAR(JUDAY,'YYYY-MM-DD') != TO_CHAR(SYSDATE, 'YYYY-MM-DD');
--==> Table TBL_JUMUNBACKUP이(가) 생성되었습니다.

-- 확인
SELECT *
FROM TBL_JUMUNBACKUP;
--==>
/*
1	쫀득초코칩	20	2001-11-01 09:05:12
2	와클	    10	2001-11-01 09:23:37
3	꼬북칩	    30	2001-11-01 11:41:00
4	칙촉	    12	2001-11-02 10:22:12
5	홈런볼	    50	2001-11-03 15:50:00
6	바나나킥	40	2001-11-04 11:10:00
7	눈을감자	10	2001-11-10 10:10:10
8	포카칩	    40	2001-11-13 09:41:14
9	감자칩	    20	2001-11-14 14:20:00
10	칸쵸	    20	2001-11-20 14:17:00
*/
--> TBL_JUMUN 테이블의 데이터들 중
--  금일 주문내역 이외의 데이터는 모두 TBL_JUMUNBACKUP 테이블에 백업을 마친 상태.

--○ TBL_JUMUN 테이블의 데이터들 중
--  금일 주문내역 이외의 데이터는 모두 삭제.
DELETE
FROM TBL_JUMUN
WHERE TO_CHAR(JUDAY,'YYYY-MM-DD') != TO_CHAR(SYSDATE, 'YYYY-MM-DD');
--==> 10개 행 이(가) 삭제되었습니다. → 938764 건의 데이터 삭제~!!!

-- 아직 제품 발송이 완료되지 않은 금일 주문 데이터를 제외하고
-- 이전의 모든 주문 데이터들이 삭제된 상황이므로
-- 테이블은 행(레코드)의 갯수가 줄어들어 매우 가벼워진 상황


--○ 확인
SELECT *
FROM TBL_JUMUN;
--==>
/*
938765	홈런볼	    10	2021-04-01 14:23:22
938766	빈츠	        10	2021-04-01 14:24:14
938767	와클	        10	2021-04-01 14:24:58
938768	홈런볼	    50	2021-04-01 14:25:26
938769	꼬북칩	    30	2021-04-01 14:25:48
938770	꼬북칩	    20	2021-04-01 14:26:36
938771	꼬북칩	    10	2021-04-01 14:26:57
938772	포카칩	    40	2021-04-01 14:27:38
938773	포카칩	    20	2021-04-01 14:27:56
938774	칸쵸	        20	2021-04-01 14:28:26
938775	칸쵸	        10	2021-04-01 14:28:42
938776	바나나킥    	10	2021-04-01 14:29:02
*/


--○ 커밋
COMMIT;
--==> 커밋 완료.

-- 그런데, 지금까지 주문받은 내역에 대한 정보를
-- 제품별 총 주문량으로 나타내야 할 상황이 발생하게 되었다.
-- 그렇다면 TBL_JUMUNBACKUP 테이블의 레코드(행)와
-- TBL_JUMUN 테이블의 레코드(행)를 합쳐서
-- 하나의 테이블을 조회하는 것과 같은
-- 결과를 확인할 수 있도록 조회해야 한다.

-- 컬럼과 컬럼의 관계를 고려하여 테이블을 결합하고자 하는 경우 JOIN 을 사용하지만
-- 레코드(행)와 레코드(행)을 결합하고자 하는 경우 UNION / UNION ALL 을 사용할 수 있다.

SELECT *
FROM TBL_JUMUNBACKUP;
SELECT *
FROM TBL_JUMUN;
--> 질의 결과 따로따로

SELECT *
FROM TBL_JUMUNBACKUP
UNION
SELECT *
FROM TBL_JUMUN;
--> 질의 결과 하나에 같이


SELECT *
FROM TBL_JUMUNBACKUP
UNION ALL
SELECT *
FROM TBL_JUMUN;
--> 위와 같은 결과

---------------------------------

SELECT *
FROM TBL_JUMUN
UNION
SELECT *
FROM TBL_JUMUNBACKUP;
--> 결합 후 첫번째 컬럼을 기준으로 정렬해서 출력

SELECT *
FROM TBL_JUMUN
UNION ALL
SELECT *
FROM TBL_JUMUNBACKUP;
--> 결합시킨 순서대로 출력

--기능 UNION > UNION ALL
--성능 UNION < UNION ALL
-- UNION 중복된 값 있으면 한개만 나오고, UNION ALL 은 중복돼도 다 나옴
--> UNION 정렬기능, 중복값 제거 기능 갖고 있음


-- ※ UNION 은 항상 결과물의 첫 번째 컬럼을 기준으로
--    오름차순 정렬을 수행한다.
--    UNION ALL 은 결합된 순서대로 조회한 결과를 반환한다. (정렬 없음)
--    이로 인해 UNION 의 부하가 더 크다.
--    또한, UNION 은 결과물에서 중복된 행이 존재할 경우
--    중복을 제거하고 1개의 행만 조회된 결과를 반환하게 된다.



--○ 지금까지 주문받은 모든 데이터를 통해
--   제품별 총 주문량을 조회하는 쿼리문을 구성한다.
/*
----------------------------------
    제품코드       총 주문량
----------------------------------
    ........           XX
    ........           XX

*/
-- 내풀이
SELECT T.제품코드
    , SUM(T.주문량) "총 주문량"
FROM 
(
    SELECT JECODE "제품코드", JUSU "주문량" 
    FROM TBL_JUMUNBACKUP
    UNION ALL
    SELECT JECODE "제품코드", JUSU "주문량"
    FROM TBL_JUMUN
)T
GROUP BY T.제품코드;

-- 선생님풀이 (같은 흐름)
SELECT JECODE"제품코드", SUM(JUSU)"총주문량"
FROM
(
    SELECT JECODE, JUSU
    FROM TBL_JUMUNBACKUP
    UNION ALL
    SELECT JECODE, JUSU
    FROM TBL_JUMUN
)T
GROUP BY T.JECODE;
--==>>
/*
쫀득초코칩	20
꼬북칩	    90
와클	20
칙촉	12
포카칩	100
바나나킥	50
눈을감자	10
홈런볼	110
감자칩	20
빈츠	10
칸쵸	50
*/


SELECT JECODE"제품코드", SUM(JUSU)"총주문량"
FROM
(
    SELECT JECODE, JUSU
    FROM TBL_JUMUNBACKUP
    UNION
    SELECT JECODE, JUSU
    FROM TBL_JUMUN
)T
GROUP BY T.JECODE;
--==>>
/*
꼬북칩	60
쫀득초코칩	20
와클	10
칙촉	12
포카칩	60
눈을감자	10
바나나킥	50
감자칩	20
빈츠	10
홈런볼	60
칸쵸	30
*/
-->> 중복데이터 제외


--○ INTERSECT / MINUS (→ 교집합 / 차집합)

-- TBL_JUMUNBACKUP 테이블과 TBL_JUMUN 테이블에서
-- 제품코드와 주문량의 값이 똑같은 행만 추출하고자 한다.
SELECT JECODE, JUSU
FROM TBL_JUMUNBACKUP
INTERSECT
SELECT JECODE, JUSU
FROM TBL_JUMUN;
--==>> 
/*
꼬북칩	30
와클	    10
칸쵸  	20
포카칩	40
홈런볼	50
*/
-->> 교집합만 찾음 (JUMUN 테이블과 JUMUNBACKUP 테이블 둘 다에 얘네가 있다)


--○ TBL_JUMUNBACKUP 테이블과 TBL_JUMUN 테이블에서
--   제품코드와 주문량의 값이 똑같은 행의 정보를 
--   주문번호, 제품코드, 주문수량, 주문일자 항목으로 조회한다.



SELECT *
FROM TBL_JUMUN;






