var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  console.log('세션-->' +req.session);
  res.render('index', { title: 'Express' });
});

module.exports = router;
