import { useState } from 'react'

const Bulb = () => {
  //구조분해 할당
  /**
   * 자식 컴포넌트에 종속되있는 state를 부모에서 관리할 경우, state가 변경될때마다 전체렌더링되므로
   * 자식 컴포넌트에서 관리하는게 좋다.
   */
  const [light, setLight] = useState("OFF");
  console.log(light)
  return <div>{light === 'ON' ? (
    <h1 style={{backgroundColor: "orange"}}>ON</h1>
  ) : (
    <h1 style={{backgroundColor:"gray"}}>OFF</h1>
  )}
  <button onClick={() => {
      setLight(light === 'ON' ? 'OFF' : 'ON')
    }}>
      {light === 'ON' ? '끄기' : '켜기'}
    </button>
  </div>
}

export default Bulb