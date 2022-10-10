const local = require('./localStrategy');
const kakao = require('./kakaoStrategy');
const { User } = require('../models');

//serializeUser : 사용자 정보를 세션에 저장하는 과정.
//deserializeUser :  저장한 정보를 세션에서 불러오는 과정.
module.exports = (passport) => {
    passport.serializeUser((user,done) =>{
        done(null,user.id); //첫번째 인자는 에러 발생 시 사용. 두번째 인자가 중요.
    });

    passport.deserializeUser((id,done) => {
        User.findOne({ where : { id}})
            .then(user => done(null,user))
            .catch(err => done(err));
    });

    local(passport);
    kakao(passport);
}
