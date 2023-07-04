import React, { useState} from "react";
import RegisterUser from "../components/RegisterUser";
import RegisterFlight from "../components/RegisterFlight/index.js";
import RegisterReservation from "../components/RegisterReservation";

function RegisterItem(){

    const [selectedOption, setSelectedOption] = useState('');
    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
      };
    
    
    return(
        <div>
            <h3>WHAT DO YOU WANT TO REGISTER?</h3>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="">Select an option</option>
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