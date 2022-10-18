import React from 'react'


function AddTodo({handleChange,handleSubmit,todo}) {
    

    


  return (
    <div className="add-todo hidden p-5 bg-primary rounded rounded-md shadow-xl">

            <form onSubmit={handleSubmit}>
                <div className="form-group">
                        <label className="task text-slate-600 font-bold">
                            Task
                        </label>
                        <br />
                        <input type="text" id="task" 
                        className="task w-80 rounded rounded-md px-2 py-1 my-2
                        focus:outline-none" 
                        placeholder="give the task"
                        value={todo.task}
                        name="task"
                        onChange={handleChange}
                        />
                </div>
                <div className="form-group">
                    <input type="submit" 
                        value="Add"
                        className="bg-blue-800 px-4 py-1 text-slate-300 font-bold rounded rounded-md
                        cursor-pointer"
                    />
                </div>
            </form>

    </div>
  )
}

export default AddTodo