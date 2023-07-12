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
          <h1>Registered Users</h1>
          <ul>
            {users.map((user, index) => (
              <li key={index}>
                <h3>User Detail</h3>
                <div>
                                <p>NAME <br />{user.name}</p>

                                <p> EMAIL <br /> {user.email}</p>
                            </div>
                            <h3>Address Info</h3>
                            <div>
                                <p>NUMBER <br /> {user.address.number}</p>
                                <p>ZIP CODE <br /> {user.address.zipCode}</p>
                                <p>COUNTRY <br /> {user.address.country}</p>
                            </div>
              </li>
            ))}
          </ul>
        </DataBaseItens>
      );
    }
    
    export default AllUsers;