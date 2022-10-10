const os = require('os');

const total =  os.totalmem();
const kb = total/1024;
const mb = kb/1024;
const gb = mb/1024;
console.log("KB=" + kb);
console.log("MB=" +  mb);
console.log("GB=" +  gb);

