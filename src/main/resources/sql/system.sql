create user book_ex identified by book_ex
default tablespace users temporary tablespace temp;
-- 계정과 암호생성하고 기본 테이블과 임시 테이블 연결

grant connect, dba to book_ex;

select dbms_xdb.gethttpport() from dual; -- 오라클 포트 확인용
exec dbms_xdb.sethttpport(9999); 