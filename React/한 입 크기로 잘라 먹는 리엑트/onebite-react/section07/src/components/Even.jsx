import { useEffect } from "react";
const Even = () => {
    //3. 언마운트
    // - 1번째 인자 > 콜백함수 전달
    // - 2번째 인자 > 빈배열 전달(마운트랑 동일)
    useEffect(() => {
        return () => {
            console.log("unmount")
        }
    }, [])
    return <div>짝수입니다.</div>;
}

export default Even;