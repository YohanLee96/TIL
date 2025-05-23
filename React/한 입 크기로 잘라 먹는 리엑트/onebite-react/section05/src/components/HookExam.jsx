import { useState } from "react";
import useInput from "../hooks/useInput";

/**
 * 3가지 hook 관련된 팁
 * 1. 함수 컴포넌트, 커스텀 훅 내부에서만 호출 가능
 * 2. hook은 조건부로 호출될 수 없다.
 * 3. 나만의 훅(Custom Hook)을 직접 만들 수 있다.
 */

//함수 외부에서 호출 불가!!
// const state = useState();

/**
 * use 접두사를 사용하는 함수는 react내부에서 커스텀훅으로 인지한다.
 * use 접두사를 사용하지 않을경우 위 1번 팁에 위배되기때문에 에러가 발생한다.
 */

const HookExam = () => {

    const [input, onChange] = useInput();
    //커스텀 훅을 반복해서 사용하는것도 가능.
    const [input2, onChange2] = useInput();
    // const state = useState();
    //조건부 내부에서 호출 불가!!
    // if(true) {
    //     const state = useState();
    // }
    //루프 내부에서 호출 불가!!
    // for(;;) {
    //     const state = useState();
    // }
    return (
        <div>
            <input value={input} onChange={onChange}/>
            <input value={input2} onChange={onChange2}/>
        </div>
    )
}




export default HookExam;