import React from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

export const TitleStyle = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    height: 20vh;
    border-bottom: 1px solid #ccc;
    position: relative;

    .back{
        position: absolute;
        left: 0;
    }
`;

const Title = (props) => {

    const {title} = props;
    const nav = useNavigate();

    return(
        <TitleStyle>
            <h1>{title}</h1>
            {title === "도서관리 시스템" ? "" : <button className="back" onClick={()=>nav(-1)}>뒤로가기</button>}
        </TitleStyle>
    );
}

export default Title;