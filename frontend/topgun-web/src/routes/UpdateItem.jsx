import React, { useState } from "react";
import UserUpdate from "../components/UpdateUser";

function UpdateItem() {
    const [selectedOption, setSelectedOption] = useState("");

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
    };

    return (
        <div>
            <h3>WHAT DO YOU WANT TO UPDATE?</h3>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="">Select an option</option>
                <option value="user">User</option>
                <option value="flight">Flight</option>
                <option value="reservation">Reservation</option>
            </select>

            {selectedOption === "user" && <UserUpdate/>}
        </div>

    )
}

export default UpdateItem;