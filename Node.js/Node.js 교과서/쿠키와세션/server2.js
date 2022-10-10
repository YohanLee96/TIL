const http = require('http');
const fs = require('fs');
const url = require('url');
const qs = require('querystring');

const parseCookie = (cookie = '') =>
cookie
    .split(';')
    .map(v=>v.split('='))
    .map(([k, ...vs]) =>[k,vs.join('=')])
    .reduce((acc,[k,v]) => {
        acc[k.trim()] = decodeURIComponent(v);
        return acc;
    }, {});

const session = {};

http.createServer((req,res) =>{
    const cookies = parseCookie(req.headers.cookie);
    const {query} = url.parse(req.url);
    const {name} = qs.parse(query);
    if(req.url.startsWith('/login')){
        const expires = new Date();
        expires.setMinutes(expires.getMinutes() + 5);
      
        const random = +new Date();
        session[random] = {
            name,
            expires
        };
        res.writeHead(302, {
            Location : '/',
            'Set-Cookie' : `session=${random};Expires=${expires.toGMTString()};HttpOnly;Path=/`,
        });
        res.end();
    }else if(cookies.session && session[cookies.session].expires > new Date()){
        res.writeHead(200,{'Content-Type': 'text/html; charset=utf-8'});
        res.end(`${session[cookies.session].name}님 안녕하세요`);
    }else{
        fs.readFile('./login.html',(err,data) =>{
            if(err){
                throw err;
            }
            res.end(data);
        });
    }
})
    .listen(8081, () =>{
        console.log('8081포트 대기 ');
    });