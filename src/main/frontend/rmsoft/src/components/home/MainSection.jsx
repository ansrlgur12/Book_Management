import React from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";


const HomeMainSection = () => {

    const nav = useNavigate();

    return(
    <MainSectionStyle>
        <button onClick={()=> nav("/signUp")}>회원 등록</button> 
        <button onClick={()=> nav("/borrow")}>대여 / 반납</button> 
        <button onClick={()=> nav("/book")}>도서 관리</button> 
    </MainSectionStyle>
    );
}

export default HomeMainSection;

export const MainSectionStyle = styled.div`
    display: flex;
    height: 50vh;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;

    button{
        width: 260px;
        height: 260px;
        background-color: white;
        border: 1px solid #7a7a7a;
        border-radius: 15px;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: .9em;
    }
    button:active{
        background-color: beige;
    }

`;