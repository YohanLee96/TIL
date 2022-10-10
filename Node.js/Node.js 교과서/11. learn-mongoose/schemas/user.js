const mongoose = require('mongoose');

const {Schema} = mongoose;
const userSchema = new Schema({
    name : {
        type: String,
        required : true,    //필수값 유무
        unique : true,      //유니크값 유무
    },
    age : {
        type: Number,
        required : true,
    },
    married : {
        type : Boolean,
        required : true,
    },
    comment : String,
    createdAt: {
        type: Date,
        default : Date.now,
    }
});

module.exports = mongoose.model('user',userSchema);