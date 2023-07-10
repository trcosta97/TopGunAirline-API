import { styled } from "styled-components";

export const DataBaseItens = styled.div`
    
    ul{
        justify-content: center;
        align-items: center;
        display: flex;
        flex-direction: column;
    }

    li{
        background-color: rgb(247,230,196);
        color:rgba(53, 65, 50, 0.726);
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        border-radius: 10px 100px / 120px 100px;
        width: 60%;
        font-weight: 1000;
        margin-bottom:2% ;
        list-style: none; 
    }

    select{
        padding: 15px;
    }

`