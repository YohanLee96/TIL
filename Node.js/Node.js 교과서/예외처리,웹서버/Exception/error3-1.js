const a = "aa";
process.on('uncaughtException',(err)=>{
     console.error('예기치못한 에러',err);
 });


setInterval(() => {
   a--;
},1000);



