import React, { useState } from "react";
import AllFlights from "../components/AllFlights/AllFlights";
import AllUsers from "../components/AllUsers/AllUsers";

function Lists() {
  const [selectedOption, setSelectedOption] = useState("");

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };

  return (
    <div>
      <select value={selectedOption} onChange={handleOptionChange}>
        <option value="">Select an option</option>
        <option value="users">Users</option>
        <option value="flights">Flights</option>
      </select>

      {selectedOption === "users" && <AllUsers />}
      {selectedOption === "flights" && <AllFlights />}
    </div>
  );
}

export default Lists;
