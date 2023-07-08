import React from "react"
import plane from "../../assets/img/plane.png"
import "./HomeContent.css"
function HomeContent() {


  return (

    <div className="homeMain">
        <img src={plane} alt="plane" />
        <div className="homeText">
          <h1>Welcome to TOPGUN Airline!</h1>
          <h2>Use the buttons above to navigate through our website</h2>
        </div>
        
        
        
    </div>
  )
}

export default HomeContent
