SELECT USER
FROM DUAL;
--==>> SCOTT

SELECT *
FROM TAB;


--○ 기존 테이블 제거
DROP TABLE TBL_BOARD PURGE;
--==>> Table TBL_BOARD이(가) 삭제되었습니다.


--○ TBL_BOARD 테이블 생성 (게시판 전용 테이블 생성)
CREATE TABLE TBL_BOARD
( NUM       NUMBER(9)               NOT NULL    -- 게시물 번호
, NAME      VARCHAR2(30)            NOT NULL    -- 게시물 작성자
, PWD       VARCHAR2(20)            NOT NULL    -- 게시물 암호
, EMAIL     VARCHAR2(50)                        -- 작성자 이메일
, SUBJECT   VARCHAR2(100)           NOT NULL    -- 게시물 제목
, CONTENT   VARCHAR2(4000)          NOT NULL    -- 게시물 내용
, IPADDR    VARCHAR2(20)                        -- 접속한 클라이언트의 IP 주소
, HITCOUNT  NUMBER DEFAULT 0        NOT NULL    -- 게시물 조회수
, CREATED   DATE DEFAULT SYSDATE    NOT NULL    -- 게시물 작성일
, CONSTRAINT BOARD_NUM_PK PRIMARY KEY(NUM)      -- 게시물 번호에 PK 제약조건 설정
);
--==>> Table TBL_BOARD이(가) 생성되었습니다.


--○ 게시물 번호의 최대값을 얻어내는 쿼리문 구성
SELECT NVL(MAX(NUM),0) AS MAXNUM
FROM TBL_BOARD;
--> 한 줄 구성
SELECT NVL(MAX(NUM),0) AS MAXNUM FROM TBL_BOARD
;


--○ 게시물 작성 쿼리문 구성
INSERT INTO TBL_BOARD(NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, CREATED)
VALUES(1, '박정준', '1234', 'joon@test.com', '작성테스트', '내용물작성', '211.238.142.152', 0, SYSDATE);
--==>> 1 행 이(가) 삽입되었습니다.
--> 한 줄 구성
INSERT INTO TBL_BOARD(NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, CREATED) VALUES(1, '박정준', '1234', 'joon@test.com', '작성테스트', '내용물작성', '211.238.142.152', 0, SYSDATE)
;


--○ DB 레코드의 갯수를 가져오는 쿼리문 구성
SELECT COUNT(*) AS COUNT
FROM TBL_BOARD;
--==>> 1
--> 한 줄 구 성
SELECT COUNT(*) AS COUNT FROM TBL_BOARD
;


--○ 특정 영역의 (시작번호 ~ 끝번호) 게시물의 목록을 읽어오는 쿼리문 구성

SELECT *
FROM
(
    SELECT ROWNUM RNUM, DATA.*
    FROM
    (
        SELECT NUM, NAME, SUBJECT, HITCOUNT, TO_CHAR(CREATED, 'YYYY-MM-DD') AS CREATED
        FROM TBL_BOARD
        ORDER BY NUM DESC
    )DATA
)
WHERE RNUM >= 1 AND RNUM <=10;

--> 한 줄 구 성
SELECT * FROM( SELECT ROWNUM RNUM, DATA.* FROM( SELECT NUM, NAME, SUBJECT, HITCOUNT, TO_CHAR(CREATED, 'YYYY-MM-DD') AS CREATED FROM TBL_BOARD ORDER BY NUM DESC )DATA ) WHERE RNUM >= 1 AND RNUM <=10
;

--------------------------------------------------------------------------------


DELETE
FROM TBL_BOARD;
--==>> 2개 행 이(가) 삭제되었습니다.

SELECT *
FROM TBL_BOARD;

COMMIT;
--==>> 커밋 완료.

SELECT *
FROM TBL_BOARD;



