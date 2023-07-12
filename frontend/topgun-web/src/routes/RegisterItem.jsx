import React, { useState} from "react";
import RegisterUser from "../components/RegisterUser";
import RegisterFlight from "../components/RegisterFlight";
import RegisterReservation from "../components/RegisterReservation";
import { MainQuestion } from "../Styled/MainQuestion";

function RegisterItem(){

    const [selectedOption, setSelectedOption] = useState('user');
    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
      };
    
    
    return(
        <div>
            <MainQuestion>What do you want to register?</MainQuestion>
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