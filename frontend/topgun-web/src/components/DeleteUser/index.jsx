import React, { useState } from 'react'
import axios from 'axios'
import { MainDelete } from '../../Styled/MainDelete';

function DeleteUser(){
    const [userId, setUserId] = useState('');
    const [user, setUser] = useState('');

    const handleUserIdChange = (event) => {
        setUserId(event.target.value);
    };

    const getUserById = () => {
        axios
            .get(`http://localhost:8080/user/{id}?id=${userId}`)
            .then((res) => {
                setUser(res.data);
            })
            .catch((err) => {
                console.log(err);
                setUser(null);
            });

    };

    const deleteUser = () => {
        axios
            .delete(`http://localhost:8080/user/{id}?id=${userId}`)
            .then((res)=>{
                setUser(res.data);
            })
            .catch((err)=>{
                console.log(err);
                setUser(null);
            });
    };

    return(
        <MainDelete>
            <h2>DELETE USER</h2>
            <input type="text" value={userId} onChange={handleUserIdChange} placeholder='Enter user id' />
            <button onClick={getUserById}>Search</button>
            {user && (
                <div>
                    <p>NAME : <br /> {user.name}</p>
                    <p>EMAIL : <br /> {user.email}</p>
                    <button onClick={deleteUser}>Delete</button>
                </div>
            )}
        </MainDelete>
    )
} 
export default DeleteUser