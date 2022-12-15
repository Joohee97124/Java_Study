SELECT USER
FROM DUAL;
--==>>SCOTT

--○ TBL_STUDENT 테이블 생성
CREATE TABLE TBL_STUDENT
( SID   NUMBER         
, NAME  VARCHAR2(30)
, TEL   VARCHAR2(30)
, CONSTRAINT STUDENT_SID_PK PRIMARY KEY(SID)
);
--==>> Table TBL_STUDENT이(가) 생성되었습니다.


--○ 시퀀스 추가
CREATE SEQUENCE STUDENTSEQ
NOCACHE;
--==>> Sequence STUDENTSEQ이(가) 생성되었습니다.

--○ 데이터 추가
INSERT INTO TBL_STUDENT(SID, NAME, TEL)
VALUES(STUDENTSEQ.NEXTVAL, '정주희', '010-1111-1111');

INSERT INTO TBL_STUDENT(SID, NAME, TEL)
VALUES(STUDENTSEQ.NEXTVAL, '안정미', '010-3333-3333');

INSERT INTO TBL_STUDENT(SID, NAME, TEL)
VALUES(STUDENTSEQ.NEXTVAL, '소서현', '010-2222-2222');

INSERT INTO TBL_STUDENT(SID, NAME, TEL)
VALUES(STUDENTSEQ.NEXTVAL, '김서현', '010-3333-3333');



--==>>> 1 행 이(가) 삽입되었습니다.

--○ 데이터 조회문
SELECT SID, NAME, TEL
FROM TBL_STUDENT
ORDER BY SID;
--==>> 1	정주희	010-1111-1111




--○ TBL_GRADE 테이블 생성
CREATE TABLE TBL_GRADE
( SID   NUMBER         
, SUB1  NUMBER(3)
, SUB2  NUMBER(3)
, SUB3  NUMBER(3)
, CONSTRAINT GRADE_SID_PK PRIMARY KEY(SID)
, CONSTRAINT GRADE_SID_FK FOREIGN KEY(SID)
             REFERENCES TBL_STUDENT(SID)

, CONSTRAINT GRADE_SUB_CH1 CHECK(SUB1 BETWEEN 0 AND 100)
, CONSTRAINT GRADE_SUB_CH2 CHECK(SUB2 BETWEEN 0 AND 100)
, CONSTRAINT GRADE_SUB_CH3 CHECK(SUB3 BETWEEN 0 AND 100)

);
--==>> Table TBL_GRADE이(가) 생성되었습니다.

DROP TABLE TBL_GRADE;

--○ 데이터 추가
INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3) VALUES(1, '90', '80', '90');
INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3) VALUES(2, '70', '80', '90');
INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3) VALUES(3, '50', '40', '30');
INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3) VALUES(4, '90', '80', '30');
--==>> 1 행 이(가) 삽입되었습니다.

--○ 커밋
COMMIT;

--○ 조회
SELECT SID, SUB1, SUB2, SUB3
FROM TBL_GRADE;
--==>> 1	90	80	90


--○ STUDENTVIEW 뷰 생성
CREATE OR REPLACE VIEW STUDENTVIEW
AS
SELECT SID, NAME, TEL, 
    (SELECT COUNT(*) 
    FROM TBL_GRADE 
    WHERE SID = S.SID) AS SUB
FROM TBL_STUDENT S;
--==>> View STUDENTVIEW이(가) 생성되었습니다.
-- SUB : STUDENT 데이터 삭제 가능여부 확인


--○ GRADEVIEW 뷰 생성 
CREATE OR REPLACE VIEW GRADEVIEW
AS
SELECT S.SID AS SID
    , S.NAME AS NAME
    , G.SUB1 AS SUB1
    , G.SUB2 AS SUB2
    , G.SUB3 AS SUB3
    , (G.SUB1 + G.SUB2 + G.SUB3) AS TOT
    , (G.SUB1 + G.SUB2 + G.SUB3)/3 AS AVG
    , (CASE WHEN ((G.SUB1 + G.SUB2 + G.SUB3)/3<60) THEN '불합격'
            WHEN (G.SUB1<40) OR (G.SUB2<40) OR (G.SUB3<40) THEN '과락'
            ELSE '합격'
            END   ) AS CH
FROM TBL_STUDENT S JOIN TBL_GRADE G
ON S.SID = G.SID;

/*
-- 내가 만든 뷰
CREATE OR REPLACE VIEW GRADEVIEW
AS
SELECT SID
    , (SELECT NAME
        FROM TBL_STUDENT
        WHERE SID = G.SID) AS NAME
    , SUB1, SUB2, SUB3
    , (SUB1 + SUB2 + SUB3) AS TOT
    , ((SUB1+SUB2+ SUB3)/3) AS AVG
    , CASE WHEN ((SUB1+SUB2+ SUB3)/3) >= 90 THEN '합격'
            WHEN ((SUB1+SUB2+ SUB3)/3) >= 60 THEN '과락'
            ELSE '탈락'
        END CH
FROM TBL_GRADE G;
*/
--==>> View GRADEVIEW이(가) 생성되었습니다.

--○ 인원수 확인
SELECT COUNT(*) AS COUNT
FROM TBL_STUDENT;

--○ 확인
SELECT SID, NAME, TEL, SUB
FROM STUDENTVIEW;

SELECT *
FROM GRADEVIEW;

/*
GRADERESULT
1 합격
2 불합격
3 과락
--==>> 이렇게 만들면 안돼!
*/


--○ 커밋
COMMIT;