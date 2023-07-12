import React, { useState } from "react";
import AllFlights from "../components/AllFlights";
import AllUsers from "../components/AllUsers";
import AllReservations from "../components/AllReservations";
import { MainQuestion } from "../Styled/MainQuestion";

function Lists() {
  const [selectedOption, setSelectedOption] = useState("");

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };

  return (
    <div>
      <MainQuestion>What are you looking for?</MainQuestion>
      <select value={selectedOption} onChange={handleOptionChange}>
        <option value="">Select an option</option>
        <option value="users">Users</option>
        <option value="flights">Flights</option>
        <option value="reservations">Reservations</option>
      </select>

      {selectedOption === "users" && <AllUsers />}
      {selectedOption === "flights" && <AllFlights />}
      {selectedOption === "reservations" && <AllReservations />}
    </div>
  );
}

export default Lists;
