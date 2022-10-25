import React from 'react'
import Todo from './Todo'
function Todos({todos,handleDelete,handleCheck}) {
  return (
    <div className="todos  w-2/3 max-w-md space-y-4 h-100 ">
        

        {
          todos.map((todo) => {
              return <Todo todo={todo} key={todo.todoId} handleDelete={handleDelete} 
              handleCheck={handleCheck} 
              
              
              />
          })
        }
        
        
    </div>
  )
}

export default Todos