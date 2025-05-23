import './Main.css'
/**
 * JSX 주의사항
 * 1. 중괄호 내부에는 JS 표현식만 넣을 수 있다. ex) if, for문 사용 불가.
 * 2. 숫자, 문자열, 배열 값만 렌더링 된다.
 * 3. 모든 태그는 닫혀있어야 한다.
 * 4. 최상위 태그는 하나이어야 한다. <></>와 같이 빈태그로 설정해도된다.
 */

const Main = () => {
    const user = {
        name : '이요한',
        isLogin: true
    }
    if(user.isLogin) {
        // return <div style={{
        //     //스타일 적용 시, css에서 했던것처럼 케밥케이스가아닌 카멜케이스로 적용해야한다.
        //     backgroundColor: 'red',
        //     borderBottom: "5px solid blue"
        // }}>로그아웃</div>
        //JS의 예약어인 class를 사용할 수 없어서 className으로 사용해야함.
        return <div className='logout'>로그아웃</div>
    } else {
        return <div>로그인</div>
    }
    // return (
    //     <>
    //     {
    //         user.isLogin ? (<div>로그아웃</div>) : (<div>로그인</div>)
    //     }
    //     </>
    // )
}

export default Main;