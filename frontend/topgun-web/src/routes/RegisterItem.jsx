import React, { useState} from "react";
import RegisterUser from "../components/RegisterUser";
import RegisterFlight from "../components/RegisterFlight/index.js";
import RegisterReservation from "../components/RegisterReservation";

function RegisterItem(){

    const [selectedOption, setSelectedOption] = useState('user');
    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
      };
    
    
    return(
        <div>
            <h3>What do you want to register?</h3>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="user">User</option>
                <option value="flight">Flight</option>
                <option value="reservation">Reservation</option>
            </select>

            {selectedOption === "user" && <RegisterUser/>}
            {selectedOption == "flight" && <RegisterFlight/>}
            {selectedOption === "reservation" && <RegisterReservation/>}
        </div>
    )
}

export default RegisterItem;