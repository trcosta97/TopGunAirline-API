import { useState } from "react";
import TextInputField from "../components/textInputField";
import Dropdown from "../components/textInputField/dropdown";
import axios from "axios";

function FlightRegister(){
   
    const [flightDate, setFlightDate] = useState('')
    const [origin, setOrigin] = useState('')
    const [destination, setDestination] = useState('')
    const [availableSeats, setAvailableSeats] = useState('')

    const onSave = (event) => {
        event.preventDefault();
        const data = {
            flightDate: flightDate,
            origin: origin,
            destination: destination,
            availableSeats: availableSeats

        };
    
        axios.post("http://localhost:8080/flight", data)
          .then(response => {
            console.log(response.data);
            alert("Flight saved!");
            setFlightDate("");
            setOrigin("");
            sertDestination("");
            setAvailableSeats("");
          })
          .catch(err => {
            console.log(err);
            console.log(data);
          });
      };

      const destinatios =[
        'GRU - Guarulhos International Airport',
        'CGH - Congonhas Airport',
        'BSB - Brasília International Airport',
        'GIG - Galeão International Airport',
        'SDU - Santos Dumont Airport'
      ]

      return(
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
                onChange={event => setOrigin(event.target.value.substring(0,3))}
                itens={destinatios}
            />
            <Dropdown
                value={destination}
                necessary={true}
                label="Destination"
                onChange={event => setDestination(event.target.value.substring(0,3))}
                itens={destinatios}
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

export default FlightRegister;