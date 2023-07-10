import React, { useState, useEffect } from "react";
import axios from "axios";
import { DataBaseItens } from "../../Styled/DatabaseItens";


function AllReservations(){

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
            <h1>REGISTERED RESERVATIONS</h1>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="user">User</option>
                <option value="flight">Flight</option>
            </select>

            <ul>
                {reservations.map((reservation, index) => (
                    <li key={index}>
                        <p>ID: {reservation.id}</p>
                        <p>Date: {reservation.reservationDate}</p>
                        <p>USER INFORMATION</p>
                        <p>Name: {reservation.user}</p>
                        <p>Email: {reservation.email}</p>
                        <p>FLIGHT INFORMATION</p>
                        <p>Origin: {reservation.flightOrigin}</p>
                        <p>Destination: {reservation.flightDestination}</p>
                        <p>Number of Seats: {reservation.numberOfSeats}</p>
                        <p>PAYMENT INFORMATION</p>
                        <p>Total Price: {reservation.price}</p>
                        <p>Type of Payment: {reservation.typeOfPayment}</p>
                        <p>Payment Date: {reservation.paymentDate}</p>
                    </li>
                ))}
            </ul>
        </DataBaseItens>
    );
}


export default AllReservations;


