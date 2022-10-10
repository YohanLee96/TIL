const express = require('express');
const cookieParser = require('cookie-parser');
const morgan = require('morgan');
const path = require('path');
const session = require('express-session');
const flash = require('connect-flash');
const passport = require('passport');
require('dotenv').config();

const pageRouter = require('./routes/page');
const authRouter = require('./routes/auth');
const { sequelize } = require('./models');  //시퀄라이즈 모델 연결.

//passport 모듈. 
// ./passport/index.js와 같음. require 시, [/index.js] 생략가능.
const passportconfig = require('./passport')    

const app = express();
sequelize.sync(); //마이그레이션 실행.
passportconfig(passport);   //로그인 관련 모듈

app.set('views', path.join(__dirname,'views'));
app.set('view engine','pug');
app.set('port',process.env.PORT || 8080);

app.use(morgan('dev'));
app.use(express.static(path.join(__dirname,'public')));
app.use(express.json());
app.use(express.urlencoded({extended:false}));
app.use(cookieParser(process.env.COOKIE_SECRET));
app.use(session({
    resave : false,
    saveUninitialized : false,
    secret : process.env.COOKIE_SECRET,
    cookie : {
        httpOnly : true,
        secure : false,
    },
}));

app.use(flash());
app.use(passport.initialize()); //매 request 요청에 passport 설정을 심는 부분.

//request.session 객체에 passport 정보를 저장하기위해 작성. 
//이러한 이유로 express-session 미들웨어보다 뒤에 작성되어야 한다.
app.use(passport.session());    

app.use('/',pageRouter);
app.use('/auth',authRouter);


app.use((req,res,next) =>{
    const err = new Error('Not Found');
    err.status = 404;
    next(err);
});

app.use((err,req,res,next) =>{
    res.locals.message = err.message;
    res.locals.error = res.app.get('env') === 'development' ? err : {};
    res.status(err.status || 500);
    res.render('error');
});

app.listen(app.get('port'), () =>{
    console.log(app.get('port'),'번 포트에서 대기중');
});