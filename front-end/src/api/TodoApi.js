import axios from "axios"

const Base_Uri = 'http://localhost:8080/todos/'

class TodoApi {
    
    getAllTodos() {
        return axios.get(Base_Uri)
    }

    getTodoById(todoId) {
        return axios.get(Base_Uri+todoId)
    }

    saveTodo(todo) {
        
        return axios.post(Base_Uri,todo)
    }

    deleteTodo(todoId) {
        return axios.delete(Base_Uri+todoId)
    }

    updateTodo(todo) {
        return axios.put(Base_Uri+'update',todo)
    }
}
export default new TodoApi()

