var express = require('express');
var {User,Comment} = require('../models');

var router = express.Router();

router.get('/:id',async function(req,res,next){
    try{
        let comments = await Comment.findAll({
            include : {
                model : User,
                where : {id : req.params.id},
            },
        });

        console.log(comments);
        res.json(comments);
    }catch(err){
        console.error(err);
        next(err);
    }
});

router.post('/',async function(req,res,next){
    try{
        let result = await Comment.create({
            commenter : req.body.id,
            comment : req.body.comment,
        });

        console.log(result);
        res.status(201).json(result);
    }catch(err){
        console.error(err);
        next(err);
    }
});

router.patch('/:id',async function(req,res,next){
    try{
        let result = await Comment.update({
            comment : req.body.comment,            
        },
        {
            where : {
                id : req.params.id
            }
        });
        console.log('서치되나요?');
        res.json(result);
    }catch(error){
        console.error(error);
        next(error);
    }
});

router.delete('/:id',async function(req,res,next){
        try{
            let result = await Comment.destroy({
                where : {id : req.params.id}
            });
            res.json(result);
        }catch(err){
            console.error(err);
            next(err);
        }
});


module.exports = router;