import "./List.css";
import TodoItem from "./TodoItem";
import { useState, useMemo } from "react";

const List = ({ todos, onUpdate, onDelete }) => {
  const [search, setSearch] = useState("");
  const onChangeSearch = (e) => {
    setSearch(e.target.value);
  };
  const getFilteredData = () => {
    if (search === "") {
      return todos;
    }
    return todos.filter((todo) =>
      todo.content.toLowerCase().includes(search.toLowerCase())
    );
  };

  /**
   * 2번째 인자 > 의존성배열(deps)
   * deps가 빈배열이라면 최초렌더링이후에 재연산을 하지 않는다.
   * 현재 deps에 todos가 존재하므로, todos가 바뀔때만 재수행한다.
   */
  const { totalCount, doneCount, notDoneCount } = useMemo(() => {
    console.log("getA 호출");
    const totalCount = todos.length;
    const doneCount = todos.filter((todo) => todo.isDone).length;
    const notDoneCount = totalCount - doneCount;
    return {
      totalCount,
      doneCount,
      notDoneCount,
    };
  }, [todos]);

  //   const { totalCount, doneCount, notDoneCount } = getAnalyzedData();

  const filteredTodos = getFilteredData();
  console.log(filteredTodos);
  return (
    <div className="List">
      <h4>✅ Todo List</h4>
      <div>
        <div>total: {totalCount}</div>
        <div>done: {doneCount}</div>
        <div>notDone: {notDoneCount}</div>
      </div>
      <input
        value={search}
        onChange={onChangeSearch}
        placeholder="검색어를 입력하세요"
      />
      <div className="todos_wrapper">
        {filteredTodos.map((todo) => {
          return (
            <TodoItem
              key={todo.id}
              {...todo}
              onUpdate={onUpdate}
              onDelete={onDelete}
            />
          );
        })}
      </div>
    </div>
  );
};

export default List;
