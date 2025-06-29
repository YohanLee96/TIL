import './App.css';
import Controller from './components/Controller'
import Viewer from './components/Viewer'
import Even from './components/Even';
import { useState, useEffect, useRef } from 'react';
function App() {
  const [count, setCount] = useState(0);
  const [input, setInput] = useState("");

  const isMount = useRef(false);
  /**
   * useEffect의 2번째인자의 배열을 
   * "의존성 배열"(dependency array = deps)이라 명칭함.
   */
  //1. 마운트 : 탄생
  useEffect(() => {
    console.log("mount")
  }, []) //deps를 빈배열로 전달.
  //2. 업데이트 : 변화, 리렌더링
  useEffect(() => {
    if(!isMount.current) { //최초마운트 시, 실행 방지 팁.
      isMount.current = true;
      return;
    }
    console.log("update")
  }) //2번째 인자인 deps를 전달안하면 됨.
  //3. 언마운트 : 죽음 > Even 컴포넌트 코드 참조.

  
  // useEffect(() => {
  //   console.log(`count: ${count}`)
  //   console.log(`input: ${input}`)
  // }, [count, input])
  const onClickButton = value => {
    setCount(count + value);
    /**
     * hook의 set메소드가 비동기로 실행되기때문에 useEffect를 사용하지 않고
     * 콜백함수내에서 사용을한다면 메소드 실행 후 최종 결과값을 받을수없다.
     */
    // console.log(count);
  }
  return (
    <div className='App'>
      <h1>Simple Counter</h1>
      <section>
        <input 
            value={input} 
            onChange={(e) => {
              setInput(e.target.value)
            }} />
      </section>
      <section>
        <Viewer count={count}/>
        {count % 2 === 0 ? <Even/> : null}
      </section>
      <section>
        <Controller onClickButton={onClickButton}/>
      </section>
    </div>
  )
}

export default App
