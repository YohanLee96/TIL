# 유용한 node 모듈
nodemon -> 서버 자동 재시작


# Sequelize 사용중 알아야둬야 될것.
hasMany : 1:N 관계
belongsToMany : N:M 관계

## Sequelize 마이그레이션
- sequelize db:create  : DB 생성.
- app.js에서 [sequelize.sync();]를 추가하면 서버 기동시, 자동 마이그레이션 가능.
--> 허나 테이블 DROP 후, CREATE 하는 방식이라 데이터 모두  사용하면 안될듯..


## KAKAO 로그인 구현.
- npm i passport passport-local passport-kakao bcrypt
--> 필요한 모듈 설치.(passport, passport-local, passport-kakao, bcrypt)
--> bcrypt 모듈 설치할 때 이슈발생. -> bcrypt-nodejs 모듈로 대체.


