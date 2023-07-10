import React, { useState } from 'react'
import axios from 'axios'
import { MainDelete } from '../../Styled/MainDelete';


function DeleteFlight(){
    const [flightId, SetFlightId] = useState('');
    const [flight, setFlight] = useState('');

    const handleFlgihtIdChange = (event) => {
        SetFlightId(event.target.value);
    }

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

    const deleteUser = () =>{
        axios
            .delete(`http://localhost:8080/flight/{id}?id=${flightId}`)
            .then((res)=>{
                setFlight(res.data);
            })
            .catch((err)=>{
                console.log(err);
                setFligth(null);
            });
    };

    return(
        <MainDelete>
            <h2>DELETE FLIGHT</h2>
            <input type="text" value={flightId} onChange={handleFlgihtIdChange} placeholder='Enter flight id' />
            <button onClick={getFlightById}>Search</button>
            {flight && (
                <div>
                    <p>DATE : <br /> {flight.date}</p>
                    <p>ORIGIN : <br /> {flight.origin}</p>
                    <p>DESTINATION : <br /> {flight.destination}</p>
                    <button onClick={deleteFlight}>Delete</button>
                </div>
            )}
        </MainDelete>
    )
}
export default DeleteFlight;