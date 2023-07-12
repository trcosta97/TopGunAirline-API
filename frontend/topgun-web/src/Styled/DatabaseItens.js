import { styled } from "styled-components";

export const DataBaseItens = styled.div`
  background-color: #AFD3E2;
  display: flex;
  flex-direction: column;
  align-items: center;
    ul{
        background-color: #19A7CE;
        padding: 2%;
        border-radius: 10px;
        margin-bottom: 2rem;
        margin-top: 2rem;
        color: #F6F1F1;
        display: flex;
        flex-direction: row;
        padding: 2rem;
        
    }

    li{
        display: flex;
        flex-direction: column;
        justify-content: center;

    }

    li div{
     display: flex;
     flex-direction: row;
     
    }

    p{
        margin: 1rem;
    }

    select{
        padding: 15px;
    }

`