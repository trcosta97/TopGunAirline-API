import React, {useState, useEffect} from "react";
import axios from "axios";
import { DataBaseItens } from "../../Styled/DatabaseItens";




function AllUsers(){
    
    const [users, setUsers] = useState([])
    
    useEffect(() => {
        axios
          .get("http://localhost:8080/user/all")
          .then((res) => {
            const modifiedData = res.data.map((user) => ({
              id: user.id,
              name: user.name,
              address: user.address,
              email: user.email
            }));
            setUsers(modifiedData);
          })
          .catch((err) => console.log(err));
      }, []);
    

      return (
        <DataBaseItens>
          <h1>REGISTERED USERS</h1>
          <ul>
            {users.map((user, index) => (
              <li key={index}>
                <p className="name">{user.name}</p>
                <div className="email_address">
                  <p>ID: {user.id} <br /></p>
                  <p>Email: {user.email} || </p>
                  <p>Address: {user.address.zipCode}, Number {user.address.number} - {user.address.country} </p>

                </div>
                
              </li>
            ))}
          </ul>
        </DataBaseItens>
      );
    }
    
    export default AllUsers;