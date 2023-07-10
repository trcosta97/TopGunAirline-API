import { styled } from "styled-components";

export const MainDelete = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;

    button{
        background-color: rgb(247,230,196);
        width: 20%;
        margin-top: 2%;
        margin-bottom:2% ;
        padding: 1%;
        color:rgba(53, 65, 50, 0.726);
        font-weight: bold;
    }   
    
    input{
        width: 20%;
        padding: 1%;
    }
    
    div{
        display: flex;
        flex-direction: row;
        justify-content: center;    
    }

`