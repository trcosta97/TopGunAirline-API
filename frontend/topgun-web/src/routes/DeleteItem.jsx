import React, { useState} from "react";
import DeleteUser from "../components/DeleteUser";
import DeleteFlight from "../components/DeleteFlight";
import DeleteReservation from "../components/DeleteReservation";
import { MainQuestion } from "../Styled/MainQuestion";

function DeleteItem(){
    const [selectedOption, setSelectedOption] = useState('user');
    
    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
      };

      return(
        <div>
            <MainQuestion>What do you want to delete?</MainQuestion>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="user">User</option>
                <option value="flight">Flight</option>
                <option value="reservation">Reservation</option>
            </select>
            {selectedOption == 'user' && <DeleteUser/>}
            {selectedOption == 'flight' && <DeleteFlight/>}
            {selectedOption == 'reservation' && <DeleteReservation/>}

        </div>
      )
    
}

export default DeleteItem;