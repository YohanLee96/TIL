var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  console.log('세션-->' +req.session);
  res.send('respond');
 
});
/* GET users listing. */
router.get('/flash', function(req, res) {
  req.session.message = '세션 메시지';
  req.flash('message','flash 메시지');
  /**
   * 참고 : flash기능은 console 찍어도 소멸됨.
   */

  res.redirect('/users/flash/result');
});

router.get('/flash/result',function(req,res){
  res.send(`${req.session.message} ${req.flash('message')}`);
});

module.exports = router;
