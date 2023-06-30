import React, { useState } from "react";
import SearchUser from "../components/SearchUser"

function SearchItem(){
    
    const [selectedOption, setSelectedOption] = useState('');

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
      };
    
    
    return(
        <div>
            <h3>WHAT ARE YOU LOOKING FOR?</h3>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="">Select an option</option>
                <option value="user">User</option>
                <option value="flight">Flight</option>
                <option value="reservation">Reservation</option>
            </select>

            {selectedOption === "user" && <SearchUser/>}
        </div>
    )
}

export default SearchItem;