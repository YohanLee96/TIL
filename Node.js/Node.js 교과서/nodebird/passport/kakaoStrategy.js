const KakaoStrategy = require('passport-kakao').Strategy;

const { User } = require('../models');

module.exports = (passport) => {
    passport.use(new KakaoStrategy({
        clientID : process.env.KAKAO_ID,    //카카오에서 발급해주는 ID
        callbackURL : '/auth/kakao/callback',   //카카오로부터 인증 결과를 받을 URL
    }, async(accessToken,refreshToken,profile,done)  =>{    //profile = 인증자 정보.
        try{
            const exUser = await User.findOne({where : {snsId: profile.id, provider: 'kakao'} });
            if(exUser){ //카카오로 로그인한 이력(회원가입)이 있는지 체킹..
                done(null,exUser);
            }else{  //없다면 회원가입 진행.
                const newUser = await User.create({
                    email : profile._json && profile._json.kaccount_email,
                    nick : profile.displayName,
                    snsId : profile.id,
                    provider: 'kakao',
                });
                done(null,newUser);
            }
        }catch(error){
            console.error(error);
            done(error);
        }
    }));
};