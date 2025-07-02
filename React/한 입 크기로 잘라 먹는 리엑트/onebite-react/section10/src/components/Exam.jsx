import { useReducer } from "react";


//상태를 실제로 변화시키는 변환기 역할
function reducer(state, action) {
    if(action.type === 'INCREASE') {
        return state + action.data;
    } else if(action.type === 'DECREASE') {
        return state - action.data;
    }

    return state;
}

const Exam = () => {
    //dispatch > 상태 변화가 있어야 한다는 사실을 알리는, 발송하는 함수.
    const [state, dispatch] = useReducer(reducer, 0);
    //useReducer를 사용하면 컴포넌트 내부를 useState()보다 비교적 간결하게 작성할 수 있다.
    const onClickPlus = () => {
        //인수 > 상태가 어떻게 변화되길 원하는지
        dispatch({ //액션 객체
            type : "INCREASE",
            data : 1,
        })
    }
    const onClickMinus =() => {
        dispatch({
            type : "DECREASE",
            data: 1,
        })
    }
    return <div>
        <h1>{state}</h1>
        <button onClick={onClickPlus}>+</button>
        <button onClick={onClickMinus}>-</button>
    </div>
}

export default Exam;