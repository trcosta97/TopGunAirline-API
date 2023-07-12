import React, { useState } from 'react'
import axios from 'axios'
import { MainDelete } from '../../Styled/MainDelete';
import { SendButton } from '../../Styled/SendButton';
import { KeyInput } from '../../Styled/KeyInput';

function DeleteReservation(){
    const [reservationId, setreservationId] = useState('');
    const [reservation, setReservation] = useState('');

    const handleReservationIdChange = (event) =>{
        setreservationId(event.target.value);
    };

    const getReservationById = () =>{
        axios
            .get(`http://localhost:8080/reservation/{id}?id=${reservationId}`)
            .then((res)=>{
                setReservation(res.data);
            })
            .catch((err)=>{
                console.log(err);
                setReservation(null)
            });
    };

    const deleteReservation = () =>{
        axios.
            delete(`http://localhost:8080/reservation/{id}?id=${reservationId}`)
            .then((res)=>{
                setReservation(res.data);
            })
            .catch((err)=>{
                console.log(err);
                setReservation(null);
            })
    };

    return(
        <MainDelete>
            <h2>Delete Reservation</h2>
            <KeyInput type="text" value={reservationId} onChange={handleReservationIdChange} placeholder='Enter reservation id' />
            <SendButton onClick={getReservationById}>Search</SendButton>
            {reservation && (
                <div>
                    <p>USER: <br /> {reservation.user.name} </p>
                    <p>FLIGHT DATE: <br /> {reservation.flight.flightDate}</p>
                    <p>ORIGIN: <br />{reservation.flight.origin}</p>
                    <p>DESTINATION: {reservation.flight.destination}</p>
                    <SendButton onClick={deleteReservation}>Delete</SendButton>
                </div>
            )}
        </MainDelete>
    );
}

    export default DeleteReservation;
