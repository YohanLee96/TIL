const express = require('express');
const passport = require('passport');
const bcrypt = require('bcrypt-nodejs');
const {isLoggedIn, isNotLoggedIn} = require('./middlewares'); //로그인 여부 판별
const {User} = require('../models');    //회원테이블 모델.

const router = express.Router();

//컨트롤러 로직 시작.

/**
 * 회원가입
 */
router.post('/join',isNotLoggedIn,async(req,res,next) =>{
    const {email, nick, password} = req.body;
    try{
        const exUser = await User.findOne({where : {email}});
        
        if(exUser) {    //중복 이메일이 있는지 체크..
            req.flash('joinError','이미 가입된 이메일입니다. ');
            return res.redirect('/join');
        }

        let salt = bcrypt.genSaltSync(12);  //salt값 생성.
        const hash = await bcrypt.hashSync(password,salt,null);    


        if(hash ==undefined){
          throw('해쉬값 안넘어옴..');
        }

        await User.create({ //Insert 작업 시작.
            email,
            nick,
            password:hash,
        });
        return res.redirect('/');
    }catch(error){
        console.error(error);
        return next(error);
    }
});

/**
 * 로그인
 */
router.post('/login',isNotLoggedIn,(req,res,next) =>{
    passport.authenticate('local',(authError,user,info) =>{
        if(authError){ // authenticate 콜백함수에 authError가 있을 경우, 실패
            console.error(authError);
            return next(authError);
        }

        if(!user){  //user인자가 리턴될 경우, 성공한거라고 보면 됨.
            req.flash('loginError',info.message);
            return res.redirect('/');
        }

        return req.login(user, (loginError) => {
            if(loginError){ //로그인 오류 시...
                console.error(loginError);
                return next(loginError);
            }

            return res.redirect('/');
        });
    })(req,res,next); // 미들웨어 내의 미들웨어에는 (req,res,next)를 붙입니다.
});

router.get('/logout',isLoggedIn,(req,res) => {
    req.logout();
    req.session.destroy();
    res.redirect('/');
});

router.get('/kakao',passport.authenticate('kakao'));

router.get('/kakao/callback',passport.authenticate('kakao',{
    failureRedirect : '/',
}), (req,res) => {
    res.redirect('/');
});

module.exports = router;