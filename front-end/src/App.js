import './App.css';
import Navbar from './components/Navbar';
import {useState,useEffect} from 'react'
import TodoApi from './api/TodoApi';
import Todos from './components/Todos';
import {IoIosAddCircle} from 'react-icons/io' 
import AddTodo from './components/AddTodo';

function App() {
  //Funtion to convert yyyy-mm-dd to dd mmmm yyyy
  const formatDate = () => {
    const dateString = new Date()
    return dateString.toISOString().split('T')[0]
  }
  const [todo,setTodo] = useState(
    {
        "task":'',
        "completed":false,
        "createdAt": formatDate()
    }
  )
  //State to store all todos
  const [todos,setTodos] = useState([])
  const [filteredTodos,setFilteredTodos] = useState([])
  const [filterState,setFilterState] = useState('0')
  //Function to fetch all todos
  const fetchTodos = () => {
    TodoApi.getAllTodos()
    .then( (response) => {
      setTodos(response.data)
      setFilteredTodos(response.data)


      
    } ) 
  }

  //Fetches todos on page load
  useEffect(
    () => {
      fetchTodos()

    }
    
  ,[])
  
  const filterTodos = (todos_to_filter) => {
    let filterInput = false
 
    if(filterState === '1') {
      filterInput = true
    } else if(filterState === '2') {
      filterInput = false
    } else {
      setFilteredTodos([...todos_to_filter])
    }
    if(filterState !== '0') {
      const newFilteredTodos = todos_to_filter.filter( 
        (cur_todo) => {
          return cur_todo.completed === filterInput
        }
       )
       
       setFilteredTodos([...newFilteredTodos])
  
    }
  
    
    
  }


  //Function to remove todo
  const handleDelete = (todoId) => {

  const curTodo = document.querySelector('#todo-'+todoId) 
  
  
  TodoApi.deleteTodo(todoId)
  .then((response) => {

    if(response.status === 200) {

      curTodo.classList.toggle('todo-anim')
      setTimeout(() => {
        const newTodos = todos.filter( (t) => {
          return t.todoId !== response.data.todoId
        })
        
        setTodos([...newTodos])
        filterTodos(newTodos)
        
      }, 400);
      
    }
      


    })
  }

  //Function to toggle the add todo ui
  const toggleAddTodo = () => {
    const addTodoForm = document.querySelector('.add-todo')
    const todos_constainer = document.querySelector('.todos')
    const addCircleBtn = document.querySelector('.add-circle')

    addTodoForm.classList.toggle('hidden')
    addTodoForm.classList.toggle('anim')
    addCircleBtn.classList.toggle('add-circle-anim')
    todos_constainer.classList.toggle('blur')

 }

 //Function to toggle check
 const handleCheck = (oldTodo) => {

    const updatedTodo = {...oldTodo,"completed":!oldTodo.completed}
    TodoApi.updateTodo(updatedTodo)
    .then( (response) => {
      if(response.status === 201) {
        const newTodos = todos.map( (newTodo) => {
          if(newTodo.todoId === updatedTodo.todoId) {
            return {...newTodo,"completed":updatedTodo.completed}
          } else {
            return newTodo
          }
      })
      setTodos([...newTodos])
      filterTodos(newTodos)
      } 
    })
    
 }


 //Add todo form handling
 const handleSubmit = (e) => {
  e.preventDefault()


  if(todo.task === '' ) {
    alert('Task should not be empty')
    return
  }
  const newTodo = {
      ...todo,
      "createdAt": formatDate()
  }

  setTodo({...newTodo})



  TodoApi.saveTodo(todo)
  .then( (response) => {
    if(response.status === 201) {
      setTodos([...todos,response.data])
      
      setTodo( {
        "task":'',
        "completed":false,
        "createdAt": formatDate()
    })

      toggleAddTodo()
      filterTodos([...todos,response.data])
    
    }
  })
}

const handleChange = (e) => {

  const value = e.target.value
  setTodo({...todo,[e.target.name]:value})
}
const handleFilter = (e) => {
  let filterInput = false
 
  if(e.target.value === '1') {
    filterInput = true
  } else if(e.target.value === '2') {
    filterInput = false
  } else {
    setFilteredTodos([...todos])
  }
  if(e.target.value !== '0') {
    const newFilteredTodos = todos.filter( 
      (cur_todo) => {
        return cur_todo.completed === filterInput
      }
     )
     
     setFilteredTodos([...newFilteredTodos])

  }

  setFilterState(e.target.value)
  
}


  return (
    <>
        <Navbar />
      
        <AddTodo handleChange={handleChange} handleSubmit={handleSubmit} todo={todo} />

        <div className="min-h-screen  p-2 mx-auto todo-container container 
          flex flex-col items-center contents-center">


        <div className="flex container w-2/3 mx-2 my-3 items-center justify-between">
              <IoIosAddCircle className="add-circle w-11 h-11 text-blue-800 text-primaryDark z-50 transition-all" onClick={toggleAddTodo} />
              <select name="filter" onChange={handleFilter}
                className="w-100 px-3 bg-primary  text-textDark text-xl rounded 
                focus:outline-none dark:bg-dark_primary text-textLight">
                <option value="0">All</option>
                <option value="1">Completed</option>
                <option value="2">Pending</option>
              </select>
        </div>

            <Todos 
                todos={filteredTodos} 
                handleDelete={handleDelete} 
                handleCheck={handleCheck} 
                
            />

        </div>
        

    </>
  );
}

export default App;

