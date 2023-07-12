import React, { useState } from 'react'
import axios from 'axios'
import { MainDelete } from '../../Styled/MainDelete';
import { SendButton } from '../../Styled/SendButton';
import { KeyInput } from '../../Styled/KeyInput';


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

    return (
        <MainDelete>
          <h2>Delete User</h2>
          <KeyInput type="text" value={userId} onChange={handleUserIdChange} placeholder='Enter user id' />
          <SendButton onClick={getUserById}>Search</SendButton>
          {user && (
            <div>
              <p>NAME <br /> {user.name}</p>
              <p>EMAIL <br /> {user.email}</p>
              <SendButton onClick={deleteUser}>Delete</SendButton> 
            </div>
            
          )}
        </MainDelete>
      );
      
} 
export default DeleteUser