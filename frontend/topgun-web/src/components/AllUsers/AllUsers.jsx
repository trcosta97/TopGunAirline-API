import React, {useState, useEffect} from "react";
import axios from "axios";
import "./AllUsers.css"

function AllUsers(){
    
    const [users, setUsers] = useState([])
    
    useEffect(() => {
        axios
          .get("http://localhost:8080/user/all")
          .then((res) => {
            const modifiedData = res.data.map((user) => ({
              name: user.name,
              address: user.address,
              email: user.email
            }));
            setUsers(modifiedData);
          })
          .catch((err) => console.log(err));
      }, []);
    

      return (
        <div>
          <h1>REGISTERED USERS</h1>
          <ul className="users">
            {users.map((user, index) => (
              <li key={index} className="user">
                <p>Name: {user.name}</p>
                <p>Email: {user.email}</p>
                <p>Address: {user.address.number}, {user.address.zipCode} - {user.address.country} </p>
              </li>
            ))}
          </ul>
        </div>
      );
    }
    
    export default AllUsers;