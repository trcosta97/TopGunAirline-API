import React, { useState} from "react";
import DeleteUser from "../components/DeleteUser";
import DeleteFlight from "../components/DeleteFlight";
import DeleteReservation from "../components/DeleteReservation";

function DeleteItem(){
    const [selectedOption, setSelectedOption] = useState('');
    
    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
      };

      return(
        <div>
            <h3>WHAT DO YOU WANT TO DELETE?</h3>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="">Select an option</option>
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