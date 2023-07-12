import { useState } from "react";
import TextInputField from "../textInputField";
import axios from "axios";
import { Form } from "../../Styled/Form";
import { MainRegister } from "../../Styled/mainRegister";
import { SendButton } from "../../Styled/SendButton";


function RegisterUser() {
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
    <MainRegister>
      
      <Form onSubmit={onSave}>
        <h2>USER REGISTRATION</h2>
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
        <SendButton type="submit">Send</SendButton>
      </Form>
    </MainRegister>
  );
}

export default RegisterUser
