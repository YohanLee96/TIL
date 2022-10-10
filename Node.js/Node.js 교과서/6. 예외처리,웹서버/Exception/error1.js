setInterval( () => {
    console.log('시작');
    try{
        console.log('gogo');
        throw new Error('aa');
    }catch(err){
        console.log('----->>>'+'bb');
        console.error(err);
    }
}, 1000);
