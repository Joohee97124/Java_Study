SELECT USER
FROM DUAL;
--==>SCOTT

--○ 기존 테이블 삭제
DROP TABLE TBL_MEMBER;
--==>Table TBL_MEMBER이(가) 삭제되었습니다.

ALTER TABLE TBL_MEMBER
DROP CONSTRAINT MEMBER_SID_PK;

--○ 테이블 생성
CREATE TABLE TBL_MEMBER
(SID    NUMBER
,NAME   VARCHAR2(30) NOT NULL
,TEL    VARCHAR2(40)
, CONSTRAINT MEMBER_SID_PK1 PRIMARY KEY(SID)
);

--==>Table TBL_MEMBER이(가) 생성되었습니다.

--○ 기존 시퀀스 제거
DROP SEQUENCE MEMBERSEQ;
--==>Sequence MEMBERSEQ이(가) 삭제되었습니다.

--○ 시퀀스 생성
CREATE SEQUENCE MEMBERSEQ
NOCACHE;
--==>Sequence MEMBERSEQ이(가) 생성되었습니다.

--○ 샘플 데이터 입력
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '박나현', '010-1111-1111');
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '한혜림', '010-2222-2222');
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '김민우', '010-3333-3333');
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '선혜연', '010-4444-4444');
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '전혜림', '010-5555-5555');
--==>1 행 이(가) 삽입되었습니다.*5

--○ 데이터 입력 ㄱㅁ
SELECT SID, NAME, TEL FROM TBL_MEMBER;
--SID	NAME	TEL
--1	박나현	010-1111-1111
--2	한혜림	010-2222-2222
--3	김민우	010-3333-3333
--4	선혜연	010-4444-4444
--5	전혜림	010-5555-5555

--○ 커밋
COMMIT;
--==>커밋 완료.

--○ 인원 수 확인
SELECT COUNT(*) AS COUNT 
FROM TBL_MEMBER;
--==>5

--○ 한 줄 구성
SELECT COUNT(*) AS COUNT FROM TBL_MEMBER
;



--○ 회원 데이터 검색
SELECT SID,NAME,TEL
FROM TBL_MEMBER
WHERE SID=1; 
--==>1	박나현	010-1111-1111

--○ 한 줄 구성
SELECT SID,NAME,TEL FROM TBL_MEMBER WHERE SID=1
;

--○ 회원 정보 수정
UPDATE TBL_MEMBER
SET NAME = '박박박' , TEL='010-1010-0101'
WHERE SID='1';
--==>1 행 이(가) 업데이트되었습니다.

UPDATE TBL_MEMBER SET NAME = '박박박' , TEL='010-1010-0101' WHERE SID='1'

--○ 데이터 수정 확인
SELECT *
FROM TBL_MEMBER
;

--○ 롤백
ROLLBACK;
--==>롤백 완료.


-- 데이터 삭제
DELETE 
FROM TBL_MEMBER 
WHERE SID = '1';
--==>1 행 이(가) 삭제되었습니다.

--○한 줄 구성
DELETE FROM TBL_MEMBER WHERE SID = '1'
;

--○ 데이터 삭제 확인
SELECT *
FROM TBL_MEMBER
;


--○롤백
ROLLBACK;
--롤백 완료.

--○ 테이블 삭제
DROP TABLE TBL_SCORE;
--==>Table TBL_SCORE이(가) 삭제되었습니다.

--○ 테이블 생성
CREATE TABLE TBL_MEMBERSCORE
(SID NUMBER
, KOR NUMBER(3)
, ENG NUMBER(3)
, MAT NUMBER(3)
, CONSTRAINT MEMBERSCORE_SID_PK PRIMARY KEY(SID)
, CONSTRAINT MEMBERSCORE_KOR_CK CHECK(KOR BETWEEN 0 AND 100)
, CONSTRAINT MEMBERSCORE_ENG_CK CHECK(ENG BETWEEN 0 AND 100)
, CONSTRAINT MEMBERSCORE_MAT_CK CHECK(MAT BETWEEN 0 AND 100)
, CONSTRAINT MEMBERSCORE_SID_FK FOREIGN KEY(SID)
                            REFERENCES TBL_MEMBER(SID)
);
--Table TBL_MEMBERSCORE이(가) 생성되었습니다.

--○샘플 데이터 입력
INSERT INTO TBL_MEMBERSCORE(SID, KOR, ENG, MAT) VALUES(1,20,30,40);
--==> 1 행 이(가) 삽입되었습니다.

--○ 데이터 입력 확인
SELECT *
FROM TBL_MEMBERSCORE;
--==>20	30	40

--○ 커밋
COMMIT;
--==>커밋 완료.


--○ 성적 입력 데이터 레코드 수 확인 쿼리문 구성
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBERSCORE;
--==>> 1
--> 한줄 구성
SELECT COUNT(*) AS COUNT FROM TBL_MEMBERSCORE
;


--○ 성적 데이터 검색 쿼리문 구성 (SID)
SELECT SID, KOR, ENG, MAT
FROM TBL_MEMBERSCORE
WHERE SID=1;
--==>> 1	20	30	40
--> 한줄 구성
SELECT SID, KOR, ENG, MAT FROM TBL_MEMBERSCORE WHERE SID=1
;


--○ 성적 데이터 수정 쿼리문 구성
UPDATE TBL_MEMBERSCORE
SET KOR=91, ENG=81, MAT=71
WHERE SID=1;
--==>>1 행 이(가) 업데이트되었습니다.
-->> 한 줄 구성
UPDATE TBL_MEMBERSCORE SET KOR=91, ENG=81, MAT=71 WHERE SID=1
;


--○ 커밋
COMMIT;
--==>> 커밋 완료.


--○ 성적 데이터 삭제 쿼리문 구성
DELETE
FROM TBL_MEMBERSCORE
WHERE SID=1;
--==>> 1 행 이(가) 업데이트되었습니다.
--> 한 줄 구성
DELETE FROM TBL_MEMBERSCORE WHERE SID=1;


--○ 롤백
ROLLBACK;
--==>> 롤백 완료.


--○ 전체 데이터 조회 쿼리문 구성
SELECT M.SID ,M.NAME, M.TEL
    , S.KOR, S.ENG, S.MAT
FROM TBL_MEMBER M, TBL_MEMBERSCORE S
WHERE M.SID = S.SID;
--==>> 1	박나현	010-1111-1111   91	81	71
--> 한 줄 구 성
SELECT M.SID ,M.NAME, M.TEL FROM TBL_MEMBER M, TBL_MEMBERSCORE S WHERE M.SID = S.SID;


--○ 전체 데이터 조회 쿼리문 구성 → 모든 리스트 조회 가능하도록 개선 → LEFT JOIN
--                              → 데이터 타입 안정화 → NVL
SELECT M.SID ,M.NAME, M.TEL
     , NVL(S.KOR, -1) AS KOR 
     , NVL(S.ENG, -1) AS ENG
     , NVL(S.MAT, -1) AS MAT
FROM TBL_MEMBER M, TBL_MEMBERSCORE S
WHERE M.SID = S.SID(+);
--==>>
/*
1	박나현	010-1111-1111	91	81	71
2	한혜림	010-2222-2222	-1	-1	-1
3	김민우	010-3333-3333	-1	-1	-1
4	선혜연	010-4444-4444	-1	-1	-1
5	전혜림	010-5555-5555	-1	-1	-1
*/
--> 한 줄 구 성
SELECT M.SID ,M.NAME, M.TEL, NVL(S.KOR, -1) AS KOR , NVL(S.ENG, -1) AS ENG, NVL(S.MAT, -1) AS MAT FROM TBL_MEMBER M, TBL_MEMBERSCORE S WHERE M.SID = S.SID(+);


--○ 전체 데이터 조회 전용 뷰 생성(VIEW_MEMBERSCORE) 
CREATE OR REPLACE VIEW VIEW_MEMBERSCORE
AS
SELECT M.SID ,M.NAME, M.TEL
     , NVL(S.KOR, -1) AS KOR 
     , NVL(S.ENG, -1) AS ENG
     , NVL(S.MAT, -1) AS MAT
FROM TBL_MEMBER M, TBL_MEMBERSCORE S
WHERE M.SID = S.SID(+);
--==>> View VIEW_MEMBERSCORE이(가) 생성되었습니다.
--> 한 줄 구 성


--○ 생성한 뷰(VIEW_MEMBERSCORE)를 활용한 리스트 조회 쿼리문 구성
SELECT SID, NAME KOR, ENG, MAT
     , (KOR+ENG+MAT) AS TOT
     , ( (KOR+ENG+MAT/3) ) AS AVG
     , RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK
FROM VIEW_MEMBERSCORE
ORDER BY SID;
--==>>
/*
1	박나현	81	71	243	195.666666666666666666666666666666666667	1
2	한혜림	-1	-1	-3	-2.33333333333333333333333333333333333333	2
3	김민우	-1	-1	-3	-2.33333333333333333333333333333333333333	2
4	선혜연	-1	-1	-3	-2.33333333333333333333333333333333333333	2
5	전혜림	-1	-1	-3	-2.33333333333333333333333333333333333333	2
*/
--> 한 줄 구 성
SELECT SID, NAME KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT, ( (KOR+ENG+MAT/3) ) AS AVG, RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK FROM VIEW_MEMBERSCORE ORDER BY SID;

--○ 생성한 뷰(VIEW_MEMBERSCORE)를 활용한 번호 검색 쿼리문 구성
SELECT SID, NAME, KOR, ENG, MAT
FROM VIEW_MEMBERSCORE
WHERE SID=1;
--==>> 1	박나현	91	81	71
--> 한 줄 구 성
SELECT SID, NAME, KOR, ENG, MAT FROM VIEW_MEMBERSCORE WHERE SID=1
;


--○ 참조데이터 레코드 수  쿼리문 구성
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBERSCORE
WHERE SID=1;
--==>> 1
--==>> 나현이 성적 데이터가 입력되었으면 1 반환, 아니면 0 반환
--> 한 줄 구 성
SELECT COUNT(*) AS COUNT FROM TBL_MEMBERSCORE WHERE SID=1
;



--○ 번호 검색 담당 쿼리문 구성(성적 데이터 입력/수정)
SELECT SID, NAME, KOR, ENG, MAT
FROM VIEW_MEMBERSCORE
WHERE SID=1;
--> 한줄 구성
SELECT SID, NAME, KOR, ENG, MAT FROM VIEW_MEMBERSCORE WHERE SID=1;






