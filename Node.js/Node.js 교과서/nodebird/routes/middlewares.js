/**
 * 로그인,비로그인 판별 로직. 
 */

exports.isLoggedIn = (req,res,next) =>{
    if(req.isAuthenticated()){
        next();
    }else{
        res.status(403).send('로그인 필요');
    }
};

exports.isNotLoggedIn = (req,res,next) =>{
    if(!req.isAuthenticated()){
        next();
    } else{
        res.redirect('/');
    }
};