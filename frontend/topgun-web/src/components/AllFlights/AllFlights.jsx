import React, { useState, useEffect } from "react";
import axios from "axios";
import "./AllFlights.css"

function AllFlights() {

    const [flights, setFlights] = useState([]);
    const [selectedOption, setSelectedOption] = useState("origin");

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
    };

    useEffect(() => {
        const url = `http://localhost:8080/flight/${selectedOption}`;
        axios
            .get(url)
            .then((res) => {
                const modifiedData = res.data.map((flight) => ({
                    flightDate: flight.flightDate,
                    origin: flight.origin,
                    destination: flight.destination,
                    availableSeats: flight.availableSeats,
                }));
                setFlights(modifiedData);
            })
            .catch((err) => console.log(err));
    }, [selectedOption]);

    return (
        <div>
            <h1>REGISTERED FLIGHTS</h1>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="origin">Origin</option>
                <option value="destination">Destination</option>
            </select>

            <ul className="flights">
                {flights.map((flight, index) => (
                    <li key={index} className="flight">
                        <p>Date: {flight.flightDate}</p>
                        <p>Origin: {flight.origin}</p>
                        <p>Destination: {flight.destination}</p>
                        <p>Available Seats: {flight.availableSeats}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
}


export default AllFlights;