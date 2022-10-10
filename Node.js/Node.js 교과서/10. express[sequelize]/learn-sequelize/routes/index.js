var express = require('express');
var router = express.Router();
var User = require('../models').User;

/* GET home page. */
router.get('/', function(req, res, next) {
  User.findAll()
    .then((users) => {
      res.render('sequelize',{users});
    })
    .catch((err) => {
      console.error(err);
      next(err);
    });
});

module.exports = router;
