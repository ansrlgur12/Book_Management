import React from 'react';
import Title from '../components/home/Title';
import { PageStyle } from './Home';
import BookHistorySection from '../components/book/BookHistorySection';

const BookHistoryPage = () => {
    return (
        <PageStyle>
        <Title title={"대출 이력"} />
        <BookHistorySection />
        </PageStyle>
    );
};

export default BookHistoryPage;