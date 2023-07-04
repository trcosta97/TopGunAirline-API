import { useState } from "react";
import TextInputField from "../textInputField";
import Dropdown from "../dropdown";
import axios from "axios";

function RegisterFlight() {

  const [flightDate, setFlightDate] = useState('');
  const [origin, setOrigin] = useState('');
  const [destination, setDestination] = useState('');
  const [availableSeats, setAvailableSeats] = useState('');


  const onSave = (event) => {
    event.preventDefault();
    const data = {
      flightDate: flightDate,
      origin: origin,
      destination: destination,
      availableSeats: availableSeats
    };

    axios
      .post("http://localhost:8080/flight", data)
      .then(response => {
        console.log(response.data);
        alert("Flight saved!");
        setFlightDate("");
        setOrigin("");
        setDestination("");
        setAvailableSeats("");
      })
      .catch(err => {
        console.log(err);
        console.log(data);
      });
  };;

  const destinations = [
    'GRU',
    'CGH',
    'BSB',
    'GIG',
    'SDU'
  ]

  return (
    <section>
      <h2>FLIGHT REGISTRATION</h2>
      <form onSubmit={onSave}>
        <TextInputField
          value={flightDate}
          necessary={true}
          label="Flight Date"
          onChange={event => setFlightDate(event.target.value)}
          placeholder="YYYY-MM-DD"
        />
        <Dropdown
          value={origin}
          necessary={true}
          label="Origin"
          onChange={event => setOrigin(event.target.value)}
          items={destinations}
        />
        <Dropdown
          value={destination}
          necessary={true}
          label="Destination"
          onChange={event => setDestination(event.target.value)}
          items={destinations}
        />
        <TextInputField
          value={availableSeats}
          necessary={true}
          label="Available Seats"
          onChange={event => setAvailableSeats(event.target.value)}
          placeholder=""
        />

        <button type="submit">Send</button>
      </form>
    </section>
  )

}

export default RegisterFlight;