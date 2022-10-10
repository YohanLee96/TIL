const LocalStrategy = require('passport-local').Strategy;
const bcrypt = require('bcrypt-nodejs');

const { User } = require('../models');

module.exports = (passport) =>{
    passport.use(new LocalStrategy({
        usernameField : 'email',
        passwordField : 'password',
    }, async(email,password,done) =>{
        try{
            const exUser = await User.findOne({where: { email} });
            if(exUser){
                //request로 받은 패스워드를 암호화하여 회원테이블에 저장되있는 패스워드(암호화 되있는상태)와 비교.

                const result = await bcrypt.compareSync(password,exUser.password);  

                console.log("result-->" + result);
                //done : 로직 수행후, 콜백함수.
                // /routes/auth.js에서 passport.authenticate함수 인자값 참고.   
                if(result){
                    done(null,exUser); 
                }else{
                    done(null,false,{message : '비밀번호가 일치하지 않습니다.'});
                }
            }else{
                done(null,false,{message : '가입되지 않은 회원입니다.'});
            }
        }catch(error){
            console.error(error);
            done(error);
        }
    }));
}