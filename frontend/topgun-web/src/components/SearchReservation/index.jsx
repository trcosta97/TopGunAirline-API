import React, { useState } from "react";
import axios from "axios";
import './SearchReservation.css';

function SearchReservation(){
    const [reservationId, setReservationId] = useState('');
    const [reservation, setReservation] = useState(null);

    const handleReservationIdChange = (event) =>{
        setReservationId(event.target.value);
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

    return(
        <div className="mainReservationSearch">
            <h2>FIND RESERVATION</h2>
            <input type="text" value={reservationId} onChange={handleReservationIdChange} placeholder="Ente flight reservation Id" />
            <button onClick={getReservationById}>Search</button>
            {reservation && (
                <div className="searchReservation">
                    <div className="reservationById">
                        <h3>RESERVATION DETAILS</h3>
                        <div className="reservationOutputSection">
                            <p>CUSTOMER NAME <br /> {reservation.user.name}</p>
                            <p>CUSTOMER EMAIL <br /> {reservation.user.email}</p>
                        </div>
                        <div className="reservationOutputSection">
                            <p>RESERVATION DATE <br /> {reservation.date}</p>
                            <p>SEATS <br /> {reservation.numberOfSeats}</p>
                            <p>VALUE <br />{reservation.payment.value}</p>
                        </div>
                        <div className="reservationOutputSection">
                            <p>FLIGHT ID <br />{reservation.flight.id}</p>
                            <p>FLIGHT DATE <br />{reservation.flight.date}</p>
                            <p>FLIGHT ORIGIN <br />{reservation.flight.origin}</p>
                            <p>FLIGHT DESTINATION <br />{reservation.flight.destination}</p>
                        </div>
                    </div>
                </div>
            )}
        </div>
    )
}

export default SearchReservation