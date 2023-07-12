import React, { useState, useEffect } from "react";
import axios from "axios";
import { DataBaseItens } from "../../Styled/DatabaseItens";

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
        <DataBaseItens>
            <h1>Registered Flight</h1>
            <select value={selectedOption} onChange={handleOptionChange}>
                <option value="origin">Origin</option>
                <option value="destination">Destination</option>
            </select>

            <ul>
                {flights.map((flight, index) => (
                    <li key={index}>
                        <div>
                            <p>DATE {flight.flightDate}</p>
                            <p>SEATS {flight.availableSeats}</p>
                        </div>
                        <div>
                            <p>ORIGIN {flight.origin}</p>
                            <p>DESTINATION {flight.destination}</p>
                        </div>
                    </li>
                ))}
            </ul>
        </DataBaseItens>
    );
}


export default AllFlights;