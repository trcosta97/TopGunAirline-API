import { useState } from "react";
import TextInputField from "../components/textInputField";
import axios from "axios";


function UserRegister() {
  const [userName, setUserName] = useState("");
  const [zipCode, setZipCode] = useState("");
  const [number, setNumber] = useState("");
  const [country, setCountry] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const onSave = (event) => {
    event.preventDefault();
    const data = {
      name: userName,
      adress: {
        zipCode: zipCode,
        number: number,
        country: country
      },
      email: email,
      password: password
    };

    axios.post("http://localhost:8080/user", data)
      .then(response => {
        console.log(response.data);
        alert("User saved!");
        setUserName("");
        setZipCode("");
        setNumber("");
        setCountry("");
        setEmail("");
        setPassword("");
      })
      .catch(err => {
        console.log(err);
        console.log(data);
      });
  };


  return (
    <section>
      <h2>USER REGISTRATION</h2>
      <form onSubmit={onSave}>
        <TextInputField
          value={userName}
          necessary={true}
          label="Name"
          onChange={event => setUserName(event.target.value)}
          placeholder=""
        />
        <TextInputField
          value={zipCode}
          necessary={true}
          label="Zip Code"
          onChange={event => setZipCode(event.target.value)}
          placeholder=""
        />
        <TextInputField
          value={number}
          necessary={true}
          label="Number"
          onChange={event => setNumber(event.target.value)}
          placeholder=""
        />
        <TextInputField
          value={country}
          necessary={true}
          label="Country"
          onChange={event => setCountry(event.target.value)}
          placeholder=""
        />
        <TextInputField
          value={email}
          necessary={true}
          label="Email"
          onChange={event => setEmail(event.target.value)}
          placeholder=""
        />
        <TextInputField
          value={password}
          necessary={true}
          label="Password"
          onChange={event => setPassword(event.target.value)}
          placeholder=""
        />
        <button type="submit">Send</button>
      </form>
    </section>
  );
}

export default UserRegister
