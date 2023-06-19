import './App.css'
import { Outlet } from 'react-router-dom'
import homeLogo from './assets/img/home-logo.png'


function App() {


  return (

    <div>
        <header className='homeHeader'>
          <img className='homeLogo' src={homeLogo} alt="logo"/>
        </header>
        <Outlet/>
        <footer></footer>
    </div>
  )
}

export default App
