/**
 * vite를 사용할 경우 ESM 사용시 꼭 붙여야하는 확장자를 생략해도 괜찮다. 
 */
import './App.css'
import HookExam from './components/HookExam';

/**
   * state방식이 단순 변수할당과 다른점
   * 변수 > 값이 변경된다고 리렌더링되지 않는다.
   * state방식으로 변경 > 값이 변경될 시 감지하여 리렌더링한다.
*/
function App() {
  return (
    <>
      <HookExam/>
    </>
  )
}





//함수 컴포넌트는 무조건 첫글자가 대문자여야됨. 그래야 리엑트에서 컴포넌트로 인식함.
//App Component
// function App() { //부모 컴포넌트
//   const buttonProps = {
//     text: "메일",
//     color: "red",
//     a: 1,
//     b: 2,
//     c: 3
//   }
  
//   return (
//     <>
//     {/* 스프레드연산자를 이용한 props 방법  */}
//       <Button {...buttonProps} />
//       <Button text={"카페"} />
//       <Button text={"블로그"}>
//         <div>자식 요소</div>
//         {/* HTML요소뿐만 아니라 컴포넌트도 전달 가능. */}
//         {/* <Header/> */}
//       </Button>
//     </>
//   )
// }

export default App;
