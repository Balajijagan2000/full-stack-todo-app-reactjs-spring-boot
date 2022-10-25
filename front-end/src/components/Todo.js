import React from 'react'
import {TiTick} from 'react-icons/ti'
import {BsTrashFill} from 'react-icons/bs'

function Todo({todo,handleDelete,handleCheck}) {
  const todoId = `todo-${todo.todoId}`
  let textClass = 'text-2xl font-bold text-textDark  dark:text-dark_light transition-all '
  let trashBtnClass = 'w-5 h-5 text-primaryDark text-4xl cursor-pointer'
  textClass = todo.completed ? textClass+'line-through' : textClass
  
  
  
  return (
    <div className="todo bg-secondary dark:bg-dark_secondary p-3   min-w-full  rounded rounded-md  border-gray-500 shadow-xl"
      id={todoId}>
        <div className="task-container flex 
          items-center justify-evenly gap-3">


            <div className="">
              <TiTick
                  className={todo.completed ? "text-green-400 text-4xl cursor-pointer":"text-red-400 text-4xl cursor-pointer"}  
                  onClick={() => handleCheck(todo)}
                />
            </div>

            <div className="task-box  w-full  flex justify-evenly items-center">
                <div className="task flex flex-col flex-wrap w-2/3">
                  <h3 className={textClass}>
                      {todo.task}
                    </h3>
                  <p className="text-textLight font-bold">{todo.createdAt}</p>
                </div>
                <div>
                  
                  
                  <BsTrashFill 
                    className={trashBtnClass}  
                    onClick={(e) => handleDelete(todo.todoId)}
                  
                  />
                 
                </div>

            </div>


            
        </div>












    </div>
  )
}

export default Todo