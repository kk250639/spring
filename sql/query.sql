# sql 주석(ctrl+/)
# ctrl enter 쿼리 실행

# 쿼리는 대소문자 구분x
# 키워드는 대문자
# 테이블, 컬렴명은 소문자
# 숫자에는 따옴표x

# SELECT : 열을 선택
# FROM : 테이블 지정
# WHERE : 행을 선택(filter), 행(레코드, 데이터, record, row)를 선택

# 비교연산자
# !=, <> : 같지 않다.
# >, >=, <, <=

# 논리연산자
# AND, OR, NOT

# IN
# BETWEEN AND

# ORDER BY : 조회 결과 순서 결정
# 기본 오름차순 (ASCENDING, ASC)
# 내림차순 (DESCENDING, DESC)
# GROUP BY : 특정 컬럼값 기준으로 결과를 나눔

# DISTINCT : 조회 결과에서 중복 제거

# LIMIT : 조회 레코드(행) 수 제한

# LIMIT SIZE : 몇개 행
# LIMIT OFFSET, SIZE : OFFSET부터 SIZE개 row(행) (OFFSET은 0부터 시작)

# LIKE (~같은)
# % _ : wildcard

# % : 0개이상 아무거나
# _ : 1개 아무거나

# aggregate function(group function) : 집계함수 (그룹함수)

# SUM(), COUNT() 조회 결과 수, MIN(), MAX(), AVG()

# HAVING : 집계함수 사용 후 결과 FILTERING

# AS : 컬럼(또는 TABLE)의 별칭

# ALIAS (AS) : 컬럼이나 테이블에 별칭 주기, (생략가능)

# DELETE : 기존 데이터(record, row) 삭제

# UPDATE : 기존 데이터 수집, WHERE없이 쓰면 전체 적용 주의 *

# IFNULL : NULL 인 경우 다른 값으로 조회

# DATABASE : 테이블을 모아놓은 공간

# CREATE DATABASE/TABLE : 데이터베이스/테이블 만들기

# database(schema) 사용하기 ((ex) USE JAQ)

# DROP TABLE : 테이블 삭제하기 (매우 주의)

# STRING/VARCHAR(길이)

# NUMBER
# INTEGER(소숫점없는) DECIMAL.(총길이, 소숫점이하길이))

# DATE, TIME (날짜,시간)
# DATETIME : 날짜시간전부

# NOT NULL : NULL 허용X
# UNIQUE : 중복 허용 안함
# DEFAULT : 값 안주면 기본값

# PRIMARY KEY : 주기(PK), 키
# FOREIGN KEY : 외래키(FK), 참조키

# ALTER TABLE : 테이블 수정

# NORMALIZATION

# FIRST NORMAL FORM (1NF): 제1정규화(형)

# 1NF
# 모든 레코드가 유일해야하고 PRIMARY KEY(NOT NULL UNIQUE)컬럼이 적어도 하나 있어야함
# 모든 데이터는 atomic(원자적) 해야한다.

# SECOND NORMAL FOMR (2NF): 2정규형
# THIRD NORMAL FORM (3NF): 3정규화

# Key : 각 레코드를 구분하는 컬럼(들)
# Primary key : 대표키, 주요키, 주키, PK
##

