import { useState } from "react";

const Counter = () => {
  const [count, setCount] = useState(0);
  return (
      <div>
        <h1>{count}</h1>
        {/* 클릭시 리렌더링 */}
        <button onClick={() => {setCount(count + 1)}}>+</button>
      </div>
  )
}

export default Counter;