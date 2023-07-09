import './App.css'
import { Outlet } from 'react-router-dom'
import LinkButton from './components/linkButton/LinkButton'



function App() {


  return (

    <div>
      <header className='homeHeader'>

        <div className='homeMain'>
          <div className='homeLogo'>
            <h1>TOPGUN</h1>
            <p>Airline</p>
          </div>
          <div className='buttons'>
            <LinkButton url="/">
              Home
            </LinkButton>
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
        </div>


      </header>
      <Outlet />
      <footer className='homeFooter'>
        <p>Site created by Thiago Ribeiro</p>
        <div className='homeLinks'>
          <a href="https://www.linkedin.com/in/trcosta97/">Linkedin</a>
          <a href="https://github.com/trcosta97/">GitHub</a>
        </div>

      </footer>
    </div>
  )
}

export default App
