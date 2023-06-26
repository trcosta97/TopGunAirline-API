import './App.css'
import { Outlet } from 'react-router-dom'
import homeLogo from './assets/img/home-logo.png'
import LinkButton from './components/linkButton/LinkButton'


function App() {


  return (

    <div>
        <header className='homeHeader'>
          <img className='homeLogo' src={homeLogo} alt="logo"/>
          <div className='buttons'>
            <LinkButton url="/userRegister">
              User Registration
            </LinkButton>
            <LinkButton url="/flightRegister">
              Flight Registration
            </LinkButton>
            <LinkButton url="/reservationRegister">
              Reservation Registration
            </LinkButton>
            <LinkButton url="/usersList">
              Users
            </LinkButton>
          </div>
          
        </header>
        <Outlet/>
        <footer></footer>
    </div>
  )
}

export default App
