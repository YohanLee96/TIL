//구조분해 할당 방법. 기본값 할당가능.
//자식 html요소 전달 시, children 인자로 받을 수 있다.
const Button = ({ children, text, color = "black"}) => {
    
    const onClickButton = e => {
        // 이벤트 객체(Synthetic Base Event > 합성이벤트)
        console.log(e)
        console.log(text)
    }
    return <button 
        // onclick 내부 함수 > 이벤트 핸들러
        // onClick={() => { 
        //     console.log(text)
        // }}
        //함수의 이름만 전달해야함.
        onClick={onClickButton}
        // onMouseEnter={onClickButton}
        style={{ color: color}}>
        {text} - {color.toUpperCase()}
        {children}
    </button>
}

//react 19버전 미만은 아래와같이 사용불가.
// Button.defaultProps = {
//     color: "black"
// }
export default Button;