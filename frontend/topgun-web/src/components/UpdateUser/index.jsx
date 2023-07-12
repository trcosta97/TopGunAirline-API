import React, { useState } from "react";
import axios from "axios";
import TextInputField from "../textInputField";
import { Form } from "../../Styled/Form";
import { MainUpdate } from "../../Styled/MainUpdate";
import { KeyInput } from "../../Styled/KeyInput";
import { SendButton } from "../../Styled/SendButton";


function UpdateUser() {
    const [userId, setUserId] = useState("");
    const [userName, setUserName] = useState("");
    const [zipCode, setZipCode] = useState("");
    const [number, setNumber] = useState("");
    const [country, setCountry] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleUserIdChange = (event) => {
        setUserId(event.target.value);
    }

    const onSave = (event) => {
        event.preventDefault();
        const data = {};
        if (userName) {
            data.name = userName;
        }
        if (zipCode || number || country) {
            data.address = {};
            if (zipCode) {
                data.address.zipCode = zipCode;
            }
            if (number) {
                data.address.number = number;
            }
            if (country) {
                data.address.country = country;
            }
        }
        if (email) {
            data.email = email;
        }

        if (password) {
            data.password = password;
        }
        axios
            .put(`http://localhost:8080/user/{id}?id=${userId}`, data)
            .then(response => {
                console.log(response.data);
                alert("User updated!");
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

    }



    return (
        <div>
           <KeyInput type="text" value={userId} onChange={handleUserIdChange} placeholder="Enter user id" />
           <MainUpdate>
            <Form onSubmit={onSave}>
                <h2>USER UPDATE</h2>
                <TextInputField
                    value={userName}
                    necessary={false}
                    label="Name"
                    onChange={event => setUserName(event.target.value)}
                    placeholder=""
                />
                <TextInputField
                    value={zipCode}
                    necessary={false}
                    label="Zip Code"
                    onChange={event => setZipCode(event.target.value)}
                    placeholder=""
                />
                <TextInputField
                    value={number}
                    necessary={false}
                    label="Number"
                    onChange={event => setNumber(event.target.value)}
                    placeholder=""
                />
                <TextInputField
                    value={country}
                    necessary={false}
                    label="Country"
                    onChange={event => setCountry(event.target.value)}
                    placeholder=""
                />
                <TextInputField
                    value={email}
                    necessary={false}
                    label="Email"
                    onChange={event => setEmail(event.target.value)}
                    placeholder=""
                />
                <TextInputField
                    value={password}
                    necessary={false}
                    label="Password"
                    onChange={event => setPassword(event.target.value)}
                    placeholder=""
                />
                <SendButton type="submit">Update</SendButton>
            </Form>
        </MainUpdate> 
        </div>
        
    )



};
export default UpdateUser;