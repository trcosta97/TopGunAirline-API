import React, { useState } from "react";
import axios from "axios";
import { MainSearch } from "../../Styled/MainSearch";
import { SearchedItem } from "../../Styled/SearchedItem";
import { SearchedItemMain } from "../../Styled/SearchedItemMain";

function SearchUser() {
    const [email, setEmail] = useState('');
    const [user, setUser] = useState(null);

    const handleUserEmailChange = (event) => {
        setEmail(event.target.value);
    };

    const getUserByEmail = () => {
        axios
            .get(`http://localhost:8080/user/email?email=${email}`)
            .then((res) => {
                setUser(res.data);
            })
            .catch((err) => {
                console.log(err);
                setUser(null);
            });

    };


    return (
        <MainSearch>
            <h2>FIND USER</h2>
            <input type="text" value={email} onChange={handleUserEmailChange} placeholder="Enter user email" />
            <button onClick={getUserByEmail}>Search</button>
            {user && (
                <SearchedItem>
                    <SearchedItemMain>
                        <h3>USER DETAILS</h3>
                        <div>
                            <p>NAME: <br />{user.name}</p>
                            
                            <p> EMAIL: <br /> {user.email}</p>
                        </div>
                        <h3>ADDRESS INFORMATION</h3>
                        <div>
                            <p>NUMBER: <br /> {user.address.number}</p>
                            <p>ZIP CODE: <br /> {user.address.zipCode}</p>
                            <p>COUNTRY: <br /> {user.address.country}</p>
                        </div>
                    </SearchedItemMain>
                </SearchedItem>
            )}
        </MainSearch>
    )
}
export default SearchUser