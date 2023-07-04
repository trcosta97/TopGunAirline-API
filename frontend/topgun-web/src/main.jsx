import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom"
import Home from './routes/Home.jsx'
import ErrorPage from './routes/ErrorPage.jsx'
import Lists from './routes/Lists.jsx'
import SearchItem from './routes/SearchItem.jsx'
import RegisterItem from './routes/RegisterItem.jsx'
import UpdateItem from './routes/UpdateItem.jsx'



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
        path:"/registration",
        element:<RegisterItem/>
      },
      {
        path:"/lists",
        element:<Lists/>
      },
      {
        path:"/search",
        element: <SearchItem/>
      },
      {
        path:"/update",
        element: <UpdateItem/>
      }
    ]
  }
  
])


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
