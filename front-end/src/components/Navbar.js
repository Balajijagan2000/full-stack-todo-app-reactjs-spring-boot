import React from 'react'
import {FaSun,FaMoon} from 'react-icons/fa'



function Navbar() {
  const toggleDarkMode = () => {
    const sunIcon = document.querySelector('.sun')
    const moonIcon = document.querySelector('.moon')
    const html = document.querySelector('html')
    const body = document.querySelector('body')


    html.classList.toggle('dark')
    sunIcon.classList.toggle('hidden')
    moonIcon.classList.toggle('hidden')
    body.classList.toggle('dark_mode')
  }
  return (
    <header className="bg-primary flex items-center justify-between
                    px-7 py-5 dark:bg-dark_primary">
        <h2 className="text-2xl text-textDark font-bold ">Spring Boot Todo App</h2>

        <div className="mr-10 cursor-pointer" onClick={toggleDarkMode}>
          <FaSun className="sun hidden text-3xl text-yellow-200" />
          <FaMoon className="moon text-3xl text-textLight"/>
        </div>

        
    </header>
  )
}

export default Navbar