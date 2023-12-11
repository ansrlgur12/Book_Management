import React from "react";
import styled from "styled-components";
import HomeMainSection from "../components/home/MainSection";
import Title from "../components/home/Title";

export const PageStyle = styled.div`
    width: 90%;
    margin: auto;
`;

const HomePage = () => {
    return(
        <PageStyle>
            <Title title={"도서관리 시스템"} />
            <HomeMainSection />
        </PageStyle>
    );
}

export default HomePage;