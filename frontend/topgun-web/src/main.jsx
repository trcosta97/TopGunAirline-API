import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom"
import Home from './routes/Home.jsx'
import UserRegister from './routes/UserRegister.jsx'
import ErrorPage from './routes/ErrorPage.jsx'
import ReservationRegister from './routes/ReservationRegister.jsx'
import FlightRegister from './routes/FlightRegister.jsx'
import Lists from './routes/Lists.jsx'
import SearchItem from './routes/SearchItem.jsx'



const router = createBrowserRouter([
  {
    path:"/",
    element:<App/>,
    errorElement: <ErrorPage/>,
    children:[
      {
        path:"/",
        element:<Home/>
      },
      {
        path:"/userRegister",
        element:<UserRegister/>
      },
      {
        path:"/reservationRegister",
        element:<ReservationRegister/>
      },
      {
        path:"/flightRegister",
        element:<FlightRegister/>
      },
      {
        path:"/lists",
        element:<Lists/>
      },
      {
        path:"/search",
        element: <SearchItem/>
      }
    ]
  }
  
])


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
