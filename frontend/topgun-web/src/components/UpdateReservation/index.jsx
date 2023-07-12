import React, { useState } from "react";
import axios from "axios";
import TextInputField from "../textInputField";
import { Form } from "../../Styled/Form";
import { MainUpdate } from "../../Styled/MainUpdate";
import { KeyInput } from "../../Styled/KeyInput";
import { SendButton } from "../../Styled/SendButton";

function updateReservation(){
    const [reservationId, setReservationId] = useState('')
    const [numberOfSeats, setNumberOfSeats] = useState('')

    const handleUserIdChange = (event) => {
        setReservationId(event.target.value);
    }

    const onSave = (event) => {
        event.preventDefault();
        const data = {};
        if (numberOfSeats) {
            data.numberOfSeats = numberOfSeats;
        }
        
        axios
            .put(`http://localhost:8080/reservation/{id}?id=${reservationId}`, data)
            .then(response => {
                console.log(response.data);
                alert("Reservation updated!");
                setNumberOfSeats("");

            })
            .catch(err => {
                console.log(err);
                console.log(data);
            });

    }

    return(
        <div>
          <KeyInput type="text" value={reservationId} onChange={handleUserIdChange} placeholder="Enter reservation id" />
            <MainUpdate>
                <Form onSubmit={onSave}>
                    <h2>RESERVATION UPDATE</h2>
                    <TextInputField
                    value={numberOfSeats}
                    necessary={false}
                    label="Number of seats"
                    onChange={event => setNumberOfSeats(event.target.value)}
                    placeholder=""
                />
                <SendButton type="submit">Update</SendButton>
                </Form>
            </MainUpdate>  
        </div>
    )


}
export default updateReservation