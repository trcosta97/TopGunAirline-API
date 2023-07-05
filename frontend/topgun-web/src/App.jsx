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
            <LinkButton url="/registration">
              Register
            </LinkButton>
            <LinkButton url="/search">
              Search
            </LinkButton>
            <LinkButton url='/update'>
              Update
            </LinkButton>
            <LinkButton url='/delete'>
              Delete
            </LinkButton>
            <LinkButton url="/lists">
              Database
            </LinkButton>
          </div>
          
        </header>
        <Outlet/>
        <footer></footer>
    </div>
  )
}

export default App
