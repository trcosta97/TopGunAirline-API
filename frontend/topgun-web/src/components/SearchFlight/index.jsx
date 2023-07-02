import React, { useState } from "react";
import axios from "axios";
import './SearchFlight.css';

function SearchFlight() {
    const [flightId, setFlightId] = useState('');
    const [flight, setFlight] = useState(null);

    const handleFlightIdChange = (event) => {
        setFlightId(event.target.value);
    };

    const getFlightById = () => {
        axios
            .get(`http://localhost:8080/flight/${flightId}`)
            .then((res) => {
                setFlight(res.data);
            })
            .catch((err) => {
                console.log(err);
                setFlight(null);
            });

    };


    return (
        <div className="mainSearchFlight">
            <h2>FIND FLIGHT</h2>
            <input type="text" value={flightId} onChange={handleFlightIdChange} placeholder="Enter flight Id" />
            <button onClick={getFlightById}>Search</button>
            {flight && (
                <div className="searchFlight">
                    <div className="flightById">
                        <h3>FLIGHT DETAILS</h3>
                        <div className="flightOutputSection">
                            <p>DATE <br /> {flight.flightDate}</p>
                        </div>
                        <div className="flightOutputSection">
                            <p>ORIGIN <br /> {flight.origin}</p>
                            <p>DESTINATION <br /> {flight.destination}</p>
                            <p>AVAILABLE SEATS <br /> {flight.availableSeats}</p>                           
                        </div>
                    </div>
                </div>


            )}
        </div>
    )
}
export default SearchFlight