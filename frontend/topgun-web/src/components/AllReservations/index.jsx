import React, { useState, useEffect } from "react";
import axios from "axios";
import { DataBaseItens } from "../../Styled/DatabaseItens";


function AllReservations() {

    const [reservations, setReservations] = useState([])
    const [selectedOption, setSelectedOption] = useState("user")

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
    };

    useEffect(() => {
        const url = `http://localhost:8080/reservation/${selectedOption}`;
        axios
            .get(url)
            .then((res) => {
                const modifiedData = res.data.map((reservation) => ({
                    id: reservation.id,
                    reservationDate: reservation.reservationDate,
                    user: reservation.user.name,
                    email: reservation.user.email,
                    flightOrigin: reservation.flight.origin,
                    flightDestination: reservation.flight.destination,
                    numberOfSeats: reservation.numberOfSeats,
                    price: reservation.payment.value,
                    typeOfPayment: reservation.payment.typeOfPayment,
                    paymentDate: reservation.payment.payDate,
                    date: reservation.reservationDate
                }));
                setReservations(modifiedData);
            })
            .catch((err) => console.log(err));
    }, [selectedOption]);

    return (
        <DataBaseItens>
            <h1>Registered Reservations</h1>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="user">User</option>
                <option value="flight">Flight</option>
            </select>

            <ul>
                {reservations.map((reservation, index) => (
                    <li key={index}>
                        <h3>Reservation Detail</h3>
                        <div>
                            <p>ID {reservation.id}</p>
                            <p>DATE {reservation.reservationDate}</p>
                        </div>

                        <h3>USER INFORMATION</h3>
                        <div>
                            <p>NAME {reservation.user}</p>
                            <p>EMAIL {reservation.email}</p>
                        </div>

                        <h3>FLIGHT INFORMATION</h3>
                        <div>
                            <p>ORIGIN {reservation.flightOrigin}</p>
                        <p>DESTINATION {reservation.flightDestination}</p>
                        <p>NUMBER OF SEATS {reservation.numberOfSeats}</p>
                        </div>
                        
                        <h3>PAYMENT INFORMATION</h3>
                        <div>

                        <p>PRIVE {reservation.price}</p>
                        <p>PAYMENT {reservation.typeOfPayment}</p>
                        <p>DATE {reservation.paymentDate}</p>
                        </div>
                        
                    </li>
                ))}
            </ul>
        </DataBaseItens>
    );
}


export default AllReservations;


