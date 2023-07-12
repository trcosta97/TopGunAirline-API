import { useState } from "react";
import TextInputField from "../textInputField";
import Dropdown from "../dropdown";
import axios from "axios";
import { MainRegister } from "../../Styled/mainRegister";
import { Form } from "../../Styled/Form";
import { SendButton } from "../../Styled/SendButton";


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
    <MainRegister>
      
      <Form onSubmit={onSave}>
        <h2>FLIGHT REGISTRATION</h2>
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

        <SendButton type="submit">Send</SendButton>
      </Form>
    </MainRegister>
  )

}

export default RegisterFlight;