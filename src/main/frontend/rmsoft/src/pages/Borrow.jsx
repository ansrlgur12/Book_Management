import React from 'react';
import BorrowMainSection from '../components/borrow/MainSection';
import Title from '../components/home/Title';
import { PageStyle } from './Home';

const BorrowPage = () => {
    return (
        <PageStyle>
        <Title title ={"대여/반납 페이지"} />
        <BorrowMainSection />
        </PageStyle>
    );
};

export default BorrowPage;