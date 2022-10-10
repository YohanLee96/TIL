const Sequelize = require('sequelize');
const env = process.env.NODE_ENV || 'development';
const config = require('../config/config')[env];
const db = {};

let sequelize = new Sequelize(
  config.database,config.username,config.password,config
);
db.sequelize = sequelize;
db.Sequelize = Sequelize;

db.User = require('./user')(sequelize,Sequelize);
db.Post = require('./post')(sequelize,Sequelize);
db.Hashtag = require('./hashtag')(sequelize,Sequelize);

//1:N  [ 1 : User 테이블  N : Post 테이블 ]
db.User.hasMany(db.Post); 

//Post 테이블에 외래키가 User테이블에 존재한다.
db.Post.belongsTo(db.User); 

//N:M 괸계. 중간 관계테이블 자동생성. 
//테이블명(through옵션으로 지정)= PostHashtag 
//컬럼이름 : [Hashtag]Id,[PostId]
db.Post.belongsToMany(db.Hashtag,{through : 'PostHashtag'});
db.Hashtag.belongsToMany(db.Post, {through : 'PostHashtag'});


//같은 테이블끼리도 N:M 관계를 가질 수 있음.
//테이블명(through옵션으로 지정)= Follow
//as 옵션 : join 시, 사용. 
db.User.belongsToMany(db.User,{
  foreignKey : 'followingId',
  as : 'Followers',
  through : 'Follow',
});
db.User.belongsToMany(db.User,{
  foreignKey : 'followerId',
  as : 'Followings',
  through : 'Follow',
});

module.exports = db;

