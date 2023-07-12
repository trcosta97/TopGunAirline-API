import React, { useState } from "react";
import SearchUser from "../components/SearchUser"
import SearchFlight from "../components/SearchFlight";
import SearchReservation from "../components/SearchReservation";
import { MainQuestion } from "../Styled/MainQuestion";

function SearchItem(){
    
    const [selectedOption, setSelectedOption] = useState('user');

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
      };
    
    
    return(
        <div>
            <MainQuestion>What are you looking for?</MainQuestion>
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