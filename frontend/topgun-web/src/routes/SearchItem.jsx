import React, { useState } from "react";
import SearchUser from "../components/SearchUser"
import SearchFlight from "../components/SearchFlight";
import SearchReservation from "../components/SearchReservation";

function SearchItem(){
    
    const [selectedOption, setSelectedOption] = useState('user');

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
      };
    
    
    return(
        <div>
            <h3>WHAT ARE YOU LOOKING FOR?</h3>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="user">User</option>
                <option value="flight">Flight</option>
                <option value="reservation">Reservation</option>
            </select>

            {selectedOption === "user" && <SearchUser/>}
            {selectedOption == "flight" && <SearchFlight/>}
            {selectedOption === "reservation" && <SearchReservation/>}
        </div>
    )
}

export default SearchItem;