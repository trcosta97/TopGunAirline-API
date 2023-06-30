import React, { useState, useEffect } from "react";
import axios from "axios";
import './SearchUser.css';

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
        <div>
            <h2>FIND USER</h2>
            <input type="text" value={email} onChange={handleUserEmailChange} placeholder="Enter user email" />
            <button onClick={getUserByEmail}>Search</button>
            {user && (
                <div className="searchUser">
                    <div className="userByEmail">
                        <h3>USER DETAILS</h3>
                        <p>ID: {user.id}</p>
                        <p>NAME: {user.name}</p>
                        <p>EMAIL: {user.email}</p>
                        <h3>ADDRESS INFORMATION</h3>
                        <p>NUMBER: {user.address.number}</p>
                        <p>ZIP CODE: {user.address.zipCode}</p>
                        <p>COUNTRY: {user.address.country}</p>
                    </div>
                </div>


            )}
        </div>
    )
}
export default SearchUser