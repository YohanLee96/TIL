import { useState, useRef } from "react"

/**
 * 간단한 회원가입 폼
 * 1. 이름
 * 2. 생년월일
 * 3. 국적
 * 4. 자기소개
 */

/**
 * 외부에 선언을 한다면 리렌더링 시, 초기화되는 현상은 해결할 수 있지만
 * 부모 컴포넌트에서 동일 컴포넌트를 여러개 사용할때
 * 모든 컴포넌트가 하나의 변수를 공유해서 문제가 발생할 수 있다.
 */
// let count = 0;


const Register = () => {
    //state를 객체로 묶어서 관리하면 편하다.
    const [input, setInput] = useState({
        name: "",
        birth: "",
        country: "",
        bio: ""
    })

    //state와 다른점은 값이 변경되도 리렌더링되지 않음.
    const countRef = useRef(0)
    const inputRef = useRef();
    let count = 0;
    console.log("Register 렌더링")

    //통합 이벤트 핸들러 구현.
    const onChange = e => {
        countRef.current++;
        // count++;
        console.log(countRef.current)
        //단순 변수를 사용한다면 리렌더링이 될때마다 변수값이 초기화되서 값이 리셋된다.
        // console.log(count)
        setInput({
            ...input,
            //대괄호를 통해 프로퍼티의 키를 설정할 수 있다.
            [e.target.name]: e.target.value
        })
    }

    const onSubmit = () => {
        if(input.name === "") {
            //이름을 입력하는 DOM 요소 포커스
            inputRef.current.focus();
        }
    }

    return (
        <div>
            
            <div>
                <input
                    ref={inputRef}
                    name="name"
                    value={input.name} 
                    onChange={onChange} 
                    placeholder={"이름"} />
            </div>
            <div>
                <input
                    name="birth"
                    value={input.birth}
                    onChange={onChange}
                    type="date"
                />
            </div>
            <div>
                <select name="country" value={input.country} onChange={onChange}>
                    <option value=""></option>
                    <option value="kr">한국</option>
                    <option value="us">미국</option>
                    <option value="uk">영국</option>
                </select>
            </div>
            <div>
                <textarea name="bio" value={input.bio} onChange={onChange}/>
            </div>
            <button onClick={onSubmit}>제출</button>
        </div>
    )
}


export default Register