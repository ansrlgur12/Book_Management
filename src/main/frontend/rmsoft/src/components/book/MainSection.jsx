import React from 'react';
import { MainSectionStyle } from '../home/MainSection';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const BookMainSection = () => {

    const nav = useNavigate();

    return (
        <MainSectionStyle>
                <button onClick={()=> nav("/newBook")}>신규 도서 등록</button>
                <button onClick={()=> nav("/updateBook")}>기존 도서 수정</button>
                <button onClick={()=> nav("/bookHistory")}>대출 이력 확인</button>
        </MainSectionStyle>
    );
};
export default BookMainSection;

