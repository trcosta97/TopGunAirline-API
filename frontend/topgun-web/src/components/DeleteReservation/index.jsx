import React, { useState } from 'react'
import axios from 'axios'
import { MainDelete } from '../../Styled/MainDelete';

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
            <h2>DELETE RESERVATION</h2>
            <input type="text" value={reservationId} onChange={handleReservationIdChange} placeholder='Enter reservation id' />
            <button onClick={getReservationById}>Search</button>
            {reservation && (
                <div>
                    <p>USER: <br /> {reservation.user.name} </p>
                    <p>FLIGHT DATE: <br /> {reservation.flight.flightDate}</p>
                    <p>ORIGIN: <br />{reservation.flight.origin}</p>
                    <p>DESTINATION: {reservation.flight.destination}</p>
                    <button onClick={deleteReservation}>Delete</button>
                </div>
            )}
        </MainDelete>
    )}

    export default DeleteReservation;
