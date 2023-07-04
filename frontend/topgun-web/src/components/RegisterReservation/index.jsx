import { useState } from "react";
import TextInputField from "../textInputField";
import Dropdown from "../dropdown";
import axios from "axios";

function RegisterReservation(){
    const [flightId, setFlightId] = useState("");
    const [userId, setUserId] = useState("");
    const [numberOfSeats, setNumberOfSeats] = useState("");
    const [value, setValue] = useState("");
    const [paymentType, setPaymentType] = useState("");

    const onSave = (event) => {
        event.preventDefault();
        const data = {
          flightId: flightId,
          userId: userId,
          numberOfSeats: numberOfSeats,
          payment: {
            userId: userId,
            value: value,
            typeOfPayment: paymentType
          },
        };
    
        axios.post("http://localhost:8080/reservation", data)
          .then(response => {
            console.log(response.data);
            alert("Reservation made!");
            setFlightId("");
            setUserId("");
            setNumberOfSeats("");
            setValue("");
            setPaymentType("");
          })
          .catch(err => {
            console.log(err);
            console.log(data);
          });
      };

        const paymentTypes = [
            'CREDIT',
            'CASH',
            'TRANSFER'
        ]

      return (
        <section>
          <h2>RESERVATION REGISTRATION</h2>
          <form onSubmit={onSave}>
            <TextInputField
              value={flightId}
              necessary={true}
              label="Flight"
              onChange={event => setFlightId(event.target.value)}
              placeholder=""
            />
            <TextInputField
              value={userId}
              necessary={true}
              label="User"
              onChange={event => setUserId(event.target.value)}
              placeholder=""
            />
            <TextInputField
              value={numberOfSeats}
              necessary={true}
              label="Number of Seats"
              onChange={event => setNumberOfSeats(event.target.value)}
              placeholder=""
            />
            <TextInputField
              value={value}
              necessary={true}
              label="Value"
              onChange={event => setValue(event.target.value)}
              placeholder=""
            />
            <Dropdown
              value={paymentType}
              necessary={true}
              label="Payment Type"
              onChange={event => setPaymentType(event.target.value)}
              items={paymentTypes}
            />
        
            <button type="submit">Send</button>
          </form>
        </section>
      );
    }

    export default RegisterReservation;