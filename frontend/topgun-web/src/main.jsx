import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom"
import Home from './routes/Home.jsx'
import Register from './routes/Register.jsx'
import  ErrotPage from './routes/ErrorPage.jsx'
import ErrorPage from './routes/ErrorPage.jsx'

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
        path:"/register",
        element:<Register/>
      }
    ]
  }
  
])


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
