const os = require('os');


console.log(os.arch());
console.log("arch-> os 아키텍쳐를 가져올 수 있음. ex) 32bit,64bit");
console.log(os.platform());
console.log("platform-> os의 플랫폼을 가져옴.");
console.log(os.type());
console.log("type->os의 종류를 가져옴.");
console.log(os.uptime());
console.log("uptime->os 부팅 이후 흐른 시간을 초단위로 보여줌. ");
console.log(os.hostname());
console.log("hostname-> os 별명을 보여줌.");
console.log(os.release());
console.log("release->운영체제의 버전을 보여줌.");
console.log(os.homedir());
console.log("homedir->홈 디렉토리의 경로를 보여줌.(계정 디렉토리)");
console.log(os.tmpdir());
console.log("tmpdir->임시 파일 저장 경로?를 보여준다고함.");
console.log(os.cpus());
console.log("cpus-> 컴퓨터의 코어 정보를 알려줌.(.length를 붙힐 경우, 코어 갯수만 확인할 수 있음.) ");
console.log(os.freemem());
console.log("freemem-> 사용가능한 잔여 메모리(RAM)용량을 보여줌(byte기준)");
console.log(os.totalmem());
console.log("totalmem->전체 메모리 용량을 보여줌.(byte기준)");

