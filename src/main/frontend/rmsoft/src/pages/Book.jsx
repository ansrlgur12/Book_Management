import React from 'react';
import BookMainSection from '../components/book/MainSection';
import Title from '../components/home/Title';
import { PageStyle } from './Home';

const BookPage = () => {
    return (
        <PageStyle>
        <Title title={"도서관리 페이지"} />
        <BookMainSection />
        </PageStyle>
    );
};

export default BookPage;