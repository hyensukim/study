# DDL(Data Definition Language)
- 데이터 정의어
- 테이블 구조를 만드는 SQL

## CREATE문
- CREATE DATABASE DB명; : 데이터베이스 생성.
- SHOW DATABASES; : 데이터베이스 목록 조회.
- CREATE TABLE : 테이블 생성.
    - 기본구조
        ```
        [ ] : 생략가능, | : 선택옵션, { } : 반복가능 
        CREATE TABLE 테이블명(
            {속성명 데이터자료형 [제약조건 : NULL | NOT NULL | UNIQUE | DEFAULT 기본값 | CHECK 체크 조건]}
            [PRIMARY KEY(속성명)]
            [FOREIGN KEY(속성명) REFERENCES 테이블명(속성명)]
            [ON DELETE CASCADE | SET NULL | NO ACTION] -- 외래키 제약 조건
        );

        CREATE TABLE 테이블명(
            속성명 속성타입 제약조건,
            속성명 속성타입 제약조건,...

            PRIMARY KEY(속성명), // 기본키 설정
            FOREIGN KEY(속성명) REFERENCES 테이블명(속성명) [ON DELETE [CASCADE | SET NULL | NO ACTION]] // 제약조건
        );
        ```
- DESCRIBE 테이블명; : 테이블 내부 조회

## ALTER문
- 생성된 테이블의 속성과 속성에 대한 제약조건을 변경한다.
- 기본구조
    ```
    [ ] : 생략가능, | : 선택옵션, { } : 반복가능 
    ALTER TABLE 테이블명
        [ADD 속성이름 데이터타입]
        [DROP COLUMN 속성명]
        [MODIFY COLUMN 속성명 테이터 타입] -- 타입 변경
        [MODIFY COLUMN 송성명 [NULL|NOT NULL]] -- NOT NULL 제약조건
        [ADD PRIMARY KEY(속성명)] -- 기본키 설정
        [[ADD|DROP] 제약명]

    ``` 

## DROP문
- 테이블 구조와 데이터 모두 삭제한다.
- 기본구조  
    `DROP TABLE 테이블명`
- 참고로, 외래키 제약조건이 있는 테이블의 경우 자식 테이블부터 삭제 후 부모테이블을 삭제해야 한다.