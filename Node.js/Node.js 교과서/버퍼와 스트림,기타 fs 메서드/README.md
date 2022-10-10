

## **◎ 버퍼와 스트림**

**버퍼란?**  

주기억 장치에 마련된 임시 저장 공간.  버퍼링은 데이터를 모으는 동작이라고 보면된다.

```javascript
const buffer = Buffer.from('저를 바꿔보셈');
// from(String) : 문자열을 버퍼로 만들 수 있음.
console.log('from():',buffer); 
//length : 버퍼의 길이
console.log('length:',buffer.length); 
// toString(Buffer) : 버퍼를 다시 문자열로 만들 수 있음. 인자에 base64나 hex를 집어넣어서 인코딩을 변경 할 수 있음.
console.log('toString():',buffer.toString());

// concat(array[]) : 배열 안에 든 버퍼를 하나로 합침.
const array = [Buffer.from('띄엄 '),Buffer.from('띄엄 '),Buffer.from('띄어쓰기')];
const buffer2 = Buffer.concat(array);
console.log('concat():', buffer2.toString());


//alloc(byte) : 바이트를 인자로 지정하면 빈 버퍼를 생성 가능.
const buffer3 = Buffer.alloc(5);
console.log('alloc():',buffer3);

```

Buffer 모듈에 내장되있는 기본적인 Method 이다. Buffer 모듈 사용 시,  자주 사용하는 Method 이니까,
꼭 외워두자.



### **#createReadstream**


```javascript
//파일 읽기 예제
const fs = require('fs');

const readStream = fs.createReadStream('./hash.txt',{highWaterMark: 10 });
const data = [];

// readStream.on('readable', () => {
//     console.log('readable : 파일 읽기 시작!');
// });

readStream.on('data',(chunk) => {
    data.push(chunk);
    console.log('data :',chunk,chunk.length);
});

readStream.on('end', () => {
 console.log('end :',Buffer.concat(data).toString());
});

// readStream.on('open', () => {
//     console.log('open : 정상적으로 파일을 읽어왔음.');
// });

// readStream.on('close', () => {
//     console.log('close : 파일을 닫을 경우 발생 .');
// });

readStream.on('error',(err) => {
    console.log('error:',err);
});


```

**createReadStream() 설명**

1번쨰 인자 
-> 읽을 파일 경로.

2번째 인자(옵션 객체) 
-> 옵션을 집어넣을 수 있다. 위 코드 같은 경우, highWaterMark라는 옵션을 집어넣었다.

> highWaterMark란? 전송할 버퍼의 크기를 정할 수 있는 옵션이다. (바이트 단위)
> Ex) 10바이트로 지정했다면, 1000바이트 파일은 총 100번으로 나눠서 읽는다.
> Default값은 64KB 이고,  값을 지정안했다면, 64KB로 전송한다.

**사용가능한 이벤트**

'readable' : 파일이 읽기가 가능한 상태가 되면 발생합니다. 
'open' : 파일이 정상적으로 열린 후 발생합니다. 
'data' : 데이터를 읽어 처리가 될 상태가 되면 발생합니다.
'end' : 데이터의 읽기가 모두 끝났을때 발생합니다. 
'close' : 파일이 정상적으로 닫힌 후 발생합니다. 
'error' : 처리 과정 중에 에러가 발생하면 발생합니다. 



**#createWritestream**

```javascript
const fs =require('fs');

const write = fs.createWriteStream('./test.txt'); //test.txt란 파일명으로 파일 생성.

write.on('finish',() =>{
    console.log('파일 쓰기 완료');
}); //파일 생성을 완료할 경우, 이벤트.

write.write('기모띠\n'); //test.txt에 추가할 문자열
write.write('김김김김기모띠');  //test.txt에 추가할 문자열
write.end(); //종료를 알림.


```

**createWriteStream() 설명**

1번쨰 인자 
-> 읽을 파일 경로.

2번째 인자(옵션 객체)
-> 옵션을 추가할 수 있다.



### #pipe

```javascript
const fs = require('fs');

const read = fs.createReadStream('hash.txt'); 
const write = fs.createWriteStream('test2.txt');

read.pipe(write);
```

**pipe()설명**

-> 파일을 복사 할 수 있는 메소드 

createReadStream()을 사용하여 파일을 읽어와서,  createWriteStream()로 파일을 생성하여,
.pipe()로 연결해주면 된다. 파일 생성 시, 동일한 파일 명이 있을 경우, 파일을 생성하지 않고,
덮어씌워진다.

### **#gzip**

```javascript
const zlib = require('zlib');
const fs = require('fs');


const read = fs.createReadStream('./test2.txt');
const zlibStream = zlib.createGzip();
const write = fs.createWriteStream('./Bandi.txt.gz');

//read로 파일을 읽으면서 pipe로 zlibStream을 연결하여 압축을 거친 후, 
//파일을 쓴다.
read.pipe(zlibStream).pipe(write);

```

노드는 zlib이라는 압축파일을 생성할 수 있는 모듈을 지원한다.
버퍼데이터를 읽는와중에 압축을 거친 후, 파일이 생성된다.
유의점은 write 변수에서 .gz전에 지정한 파일명은 꼭 해당 파일의 확장자까지 붙혀줘야 파일이 손상되어 압축이 된다.



## ◎ 기타 fs 메소드



### #폴더 생성 후, 파일 생성하고 파일이름 수정

```javascript
const fs = require('fs');

fs.access('./folder',fs.constants.F_OK | fs.constants.R_OK | fs.constants.W_OK,(err) => {
    if(err){
        if(err.code ==='ENOENT'){ //에러코드가 폴더 부재에대한 코드일 경우..
            console.log('폴더 없음');
            fs.mkdir('./folder',(err) =>{ //폴더 만들기
                if(err){
                    throw err;
                }
                console.log('폴더 만들기 성공');
                fs.open('./folder/file.js','w',(err,fd) => { 
                    //빈 파일 만들고, 쓰기 권한을 준 후, 파일 아이디 가져오기.
                    if(err){
                        throw err;
                    }
                    console.log('빈 파일 만들기 성공',fd);
                    fs.rename('./folder/file.js','./folder/newfile.js',(err) =>{
                        if(err){
                            throw err;
                        }
                        console.log('이름 바꾸기 성공');
                    });
                });
            });
        }else{
            throw err;
        }
    }else{
        console.log('이미 폴더 있음');
    }
});
```

폴더나 파일에 접근할 수 있는 권한을 체크 후, 파일을 만들고 쓰기권한을 줘서 빈파일을 만든 후 파일이름을 수정하는
프로그램이다. 해당 코드를 프로미스방식으로 만들고 싶어, 만들어 봤으나 파일이름을 바꿀 때 에러가난다. 에러가 나는 
이유를 찾아봤는데 못찾았다..

아래 코드가 내가 프로미스방식으로 바꾼 코드다.

```javascript
const fs = require('fs');

const fsPromise  = fs.promises;

fsPromise.access('./folder',fs.constants.F_OK | fs.constants.R_OK |fs.constants.W_OK)
.then(() => console.log('폴더 이미 있지롱~'))
.catch(() => 
    function(err){
        if(err.code=='ENOENT'){
            console.log('폴더없음')
        }else{
           exit();
        }
    },
    fs.mkdir('./folder',(err) =>{
        if(err){
            throw err;
        }
        console.log('폴더 만들기 성공')
    }),
    fs.open('./folder/file.js','w',(err,fd) =>{
        if(err){
            throw err;
        }
        console.log('빈 파일 만들기 성공',fd);
    }),
    fs.rename('./folder/file.js','./folder/newfile.js',(err) =>{
        if(err){
            console.log('안바뀜 ㅜㅜ'); //여기서 걸린다 ㅜ
            throw err;
        }
        console.log('이름 바꾸기 성공');
    })
 );
    
    


```

에러가 나는 이유는 .open메소드로 파일을 만들기 전에 .rename 메소드로 파일이름을 바꿀려고 시도해서 걸리는거 같다.





### #폴더,파일삭제

```javascript
const fs = require('fs');

fs.readdir('./folder',(err,dir) => { //폴더 안에 파일내용물을 배열로 담는다.
    if(err){
        throw err;
    }
    console.log('폴더 내용 확인',dir);

    fs.unlink('./folder/newFile.js',(err) =>{ //파일 지워버리기~~
        if(err){
            throw err;
        }
        console.log('파일 삭제 성공');

        fs.rmdir('./folder',(err) =>{ //폴더도 지워버리기~~
            if(err){
                throw err;
            }
            console.log('폴더 삭제 성공');
        });
    });
});
```

폴더,파일을 삭제하는 코드이다. 코드가 그리 복잡하지 않아서, 이만 생략.



### #파일 복사

```javascript
const fs = require('fs');

fs.copyFile('./copy/copy1.txt','./copy/copy2.txt',(error) =>{
    if(error){
        return console.error(error);
    }

    console.log('복사 완료');
});
```

fs.copyfile()
-> 첫번째 인자 : 복사할 파일경로 
-> 두번째 인자 : 복사될 경로

createWritestream,createReadstream메소드를 pipe메소드로 연결시킬 필요 없이  간단하게 파일복사를 할 수 있는 
메소드이다.  노드 8.5버전부터 추가된 기능이니, 파일 복사를 할 경우, 해당 메소드를 쓰자!!



