import React, { useState } from "react";
import axios from "axios";
import { MainSearch } from "../../Styled/MainSearch";
import { SearchedItem } from "../../Styled/SearchedItem";
import { SearchedItemMain } from "../../Styled/SearchedItemMain";

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
        <MainSearch>
            <h2>FIND FLIGHT</h2>
            <input type="text" value={flightId} onChange={handleFlightIdChange} placeholder="Enter flight Id" />
            <button onClick={getFlightById}>Search</button>
            {flight && (
                <SearchedItem>
                    <SearchedItemMain>
                        <h3>FLIGHT DETAILS</h3>
                        <div>
                            <p>DATE <br /> {flight.flightDate}</p>
                        </div>
                        <div>
                            <p>ORIGIN <br /> {flight.origin}</p>
                            <p>DESTINATION <br /> {flight.destination}</p>
                            <p>AVAILABLE SEATS <br /> {flight.availableSeats}</p>                           
                        </div>
                    </SearchedItemMain>
                </SearchedItem>


            )}
        </MainSearch>
    )
}
export default SearchFlight