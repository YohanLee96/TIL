var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var session = require('express-session');
var flash = require('connect-flash');
var logger = require('morgan'); //쉘화면에 로그를 담당.

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

// app.use(function(req,res,next){
//   next(createError(400));
// });


app.use(logger('dev'));
app.use(express.static(path.join(__dirname, 'public')));  //정적파일을 내포한 디렉토리 경로 지정.
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());

app.use(cookieParser('abc'));
app.use(session({
  resave : false,
  saveUninitialized : false,
  secret : 'abc',
  cookie: {
    httpOnly : true,
    secure : false,
  },
}));
app.use(flash());

app.use('/', indexRouter);
app.use('/users', usersRouter);



// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
