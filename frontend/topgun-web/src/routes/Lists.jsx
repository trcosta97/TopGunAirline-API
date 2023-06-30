import React, { useState } from "react";
import AllFlights from "../components/AllFlights";
import AllUsers from "../components/AllUsers";
import AllReservations from "../components/AllReservations";

function Lists() {
  const [selectedOption, setSelectedOption] = useState("");

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };

  return (
    <div>
      <h3>WHAT ARE YOU LOOKING FOR?</h3>
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
