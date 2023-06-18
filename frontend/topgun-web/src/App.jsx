import './App.css'
import { Outlet } from 'react-router-dom'


function App() {


  return (

    <div>
        <header>
          <h1>TopGun Airline</h1>
        </header>
        <Outlet/>
        <footer></footer>
    </div>
  )
}

export default App
