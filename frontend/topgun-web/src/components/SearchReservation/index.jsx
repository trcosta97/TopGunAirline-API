import React, { useState } from "react";
import axios from "axios";
import { MainSearch } from "../../Styled/MainSearch";
import { SearchedItem } from "../../Styled/SearchedItem";
import { SearchedItemMain } from "../../Styled/SearchedItemMain";
import { KeyInput } from "../../Styled/KeyInput";
import { SendButton } from "../../Styled/SendButton";

function SearchReservation() {
    const [reservationId, setReservationId] = useState('');
    const [reservation, setReservation] = useState(null);

    const handleReservationIdChange = (event) => {
        setReservationId(event.target.value);
    };

    const getReservationById = () => {
        axios
            .get(`http://localhost:8080/reservation/${reservationId}`)
            .then((res) => {
                setReservation(res.data);
            })
            .catch((err) => {
                console.log(err);
                setReservation(null)
            });
    };

    return (

        <MainSearch>

                <h2>Find Reservation</h2>
                <KeyInput type="text" value={reservationId} onChange={handleReservationIdChange} placeholder="Ente flight reservation Id" />
                <SendButton onClick={getReservationById}>Search</SendButton>
                {reservation && (
                    <SearchedItem>
                        <SearchedItemMain>
                            <h3>RESERVATION DETAILS</h3>
                            <div>
                                <p>CUSTOMER NAME <br /> {reservation.user.name}</p>
                                <p>CUSTOMER EMAIL <br /> {reservation.user.email}</p>
                            </div>
                            <div>
                                <p>RESERVATION DATE <br /> {reservation.date}</p>
                                <p>SEATS <br /> {reservation.numberOfSeats}</p>
                                <p>VALUE <br />{reservation.payment.value}</p>
                            </div>
                            <div>
                                <p>FLIGHT ID <br />{reservation.flight.id}</p>
                                <p>FLIGHT DATE <br />{reservation.flight.date}</p>
                                <p>FLIGHT ORIGIN <br />{reservation.flight.origin}</p>
                                <p>FLIGHT DESTINATION <br />{reservation.flight.destination}</p>
                            </div>
                        </SearchedItemMain>
                    </SearchedItem>
                )}



        </MainSearch>
    )
}

export default SearchReservation