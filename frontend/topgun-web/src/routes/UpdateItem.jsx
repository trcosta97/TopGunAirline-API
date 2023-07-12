import React, { useState } from "react";
import UpdateFlight from "../components/UpdateFlight";
import UpdateUser from "../components/UpdateUser";
import UpdateReservation from "../components/UpdateReservation";
import { MainQuestion } from "../Styled/MainQuestion";

function UpdateItem() {
    const [selectedOption, setSelectedOption] = useState("user");

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
    };

    return (
        <div>
            <MainQuestion>What do you want to update?</MainQuestion>
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