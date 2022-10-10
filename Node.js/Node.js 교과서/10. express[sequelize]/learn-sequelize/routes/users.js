var express = require('express');
var router = express.Router();
var User =  require('../models').User;

/* GET users listing. */
router.get('/', async function(req, res, next) {
    try{
      let users =  await User.findAll();
      res.json(users);
    }catch(err){
      console.error(err);
      next(err);
    }
});

router.post('/', async function(req,res,next){
  
  try{
    let result = await User.create({
      name : req.body.name,
      age :req.body.age,
      married : req.body.married,
    })
    console.log(result);
    res.status(201).json(result);
  }catch(err){
    console.error(err);
    next(err);
  }
});

module.exports = router;
