import "./TodoItem.css";
import { memo } from "react";

const TodoItem = ({ id, isDone, content, date, onUpdate, onDelete }) => {
  const onChangeCheckbox = () => {
    onUpdate(id);
  };
  const onClickDel = () => {
    onDelete(id);
  };
  return (
    <div className="TodoItem">
      <input
        onChange={onChangeCheckbox}
        readOnly
        checked={isDone}
        type="checkbox"
      />
      <div className="content">{content}</div>
      <div className="date">{new Date(date).toLocaleDateString()}</div>
      <button onClick={onClickDel}>삭제</button>
    </div>
  );
};

/**
 * memo는 "얕은 비교"만 함. 그래서 객체의 주소값이 다르면 props가 바뀌었다고 인식.
 * 2번째인자는 메모이제이션함수를 커스터마이징할 수 있음.
 */
// export default memo(TodoItem, (prevProps, nextProps) => {
//   //객체 내부 값검증을 통해 메모이제이션 함수 커스터마이징.
//   if (prevProps.id !== nextProps.id) return false;
//   if (prevProps.isDone !== nextProps.isDone) return false;
//   if (prevProps.content !== nextProps.content) return false;
//   if (prevProps.date !== nextProps.date) return false;

//   return true;
// });

export default memo(TodoItem);
