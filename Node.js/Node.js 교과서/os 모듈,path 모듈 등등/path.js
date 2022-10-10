const path = require('path');

const string = "C:\\test\\test.txt";

console.log(path.sep);
console.log("sep-> sep 경로의 구분자 입니다. Window -> \ Linux -> / ");
enter();
console.log(path.delimiter);
console.log("delimiter-> delimiter 환경 변수의 구분자입니다. Window -> ; Linux-> : ");
enter();
console.log(process.env.PATH);
console.log("-> process.env.PATH 해당 명령어로 node의 delimiter의 객체가 어떻게 표시되는지 확인 할 수 있습니다.");
enter();
console.log(path.dirname(string));

console.log("dirname-> dirname 파일이 위치한 경로를 보여줍니다.")
enter();
console.log(path.extname(string));
console.log("extname-> extname 파일의 확장자를 보여줍니다.");
enter();
console.log(path.basename(string,path.extname(string)));
console.log("basename->파일의 이름(확장자 포함)을 보여줍니다. 파일의 이름만 표시하고 싶을땐, 두번째 인자에 확장자 써주면됩니다.");
enter();
console.log(path.parse(string));
console.log('parse-> root,dir,base,ext,name으로 분리하여 보여줍니다.');
console.log(path.format({
    dir: 'C:\\test',
    name: 'TestYohan',
    ext: '.txt'
}));
enter();
console.log(path.normalize('C://test\\\\TestYohan.txt'));
console.log('-> 경로 구분자 잘못 쓸 경우, 정상적인경로로 변환해줍니다.')
enter();
console.log(path.isAbsolute('C:\\test\\'));
console.log('->해당경로가 절대경로인지 상대경로인지 유무를 boolean형식으로 보여줌.')
enter();
console.log(path.relative('C:\\test\\TestYohan.txt','D:\\'));
console.log('->첫번째 경로 인자값에서 두번째 경로 인자값으로 어떻게 갈 수 있는지 알려줍니다,')
enter();
console.log('현재 경로->' + __dirname);
console.log(path.join(__dirname,'\\abc','def','\\ghi','qwe'));
console.log('-> 여러 인자경로값들을 받아서, 파일경로를 맞춰줍니다.')
enter();
console.log(path.resolve(__dirname,'\\abc','\\def','\\ghi','D:\\qwe\\wef'));
console.log('->join과 기능은 비슷하나 방식이조금다름.')
enter();


function enter(){
    console.log("");
}