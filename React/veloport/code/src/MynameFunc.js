import React from 'react'

// Props 코드
//비구조화 할당
//함수형 컴포넌트 방식
const MynameFunc = ({func, second}) => {
    return (
        <div>
            안녕하세요 제 이름은 <b>{func}, {second}</b> 입니다.
        </div>
    )
}

MynameFunc.defaultProps = {
    func : '함수형',
    second : 'second'
}

export default MynameFunc;
