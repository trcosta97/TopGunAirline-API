import React, { useState } from 'react'
import axios from 'axios'
import { MainDelete } from '../../Styled/MainDelete';
import { SendButton } from '../../Styled/SendButton';
import { KeyInput } from '../../Styled/KeyInput';


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

    const deleteFlight = () =>{
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
            
            <h2>Delete Flight</h2>
            <KeyInput type="text" value={flightId} onChange={handleFlgihtIdChange} placeholder='Enter flight id' />
            <SendButton onClick={getFlightById}>Search</SendButton>
            {flight && (
                <div>
                    <p>DATE : <br /> {flight.date}</p>
                    <p>ORIGIN : <br /> {flight.origin}</p>
                    <p>DESTINATION : <br /> {flight.destination}</p>
                    <SendButton onClick={deleteFlight}>Delete</SendButton>
                </div>
            )}
        </MainDelete>
    )
}
export default DeleteFlight;