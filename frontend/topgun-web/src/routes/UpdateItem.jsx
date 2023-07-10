import React, { useState } from "react";
import UpdateFlight from "../components/UpdateFlight";
import UpdateUser from "../components/UpdateUser";
import UpdateReservation from "../components/UpdateReservation";

function UpdateItem() {
    const [selectedOption, setSelectedOption] = useState("user");

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
    };

    return (
        <div>
            <h3>WHAT DO YOU WANT TO UPDATE?</h3>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="user">User</option>
                <option value="flight">Flight</option>
                <option value="reservation">Reservation</option>
            </select>

            {selectedOption === "user" && <UpdateUser/>}
            {selectedOption === "flight" && <UpdateFlight/>}
            {selectedOption === "reservation" && <UpdateReservation/>}
        </div>

    )
}

export default UpdateItem;