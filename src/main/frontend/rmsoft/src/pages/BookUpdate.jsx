import React from 'react';
import Title from '../components/home/Title';
import UpdateBookSection from '../components/book/UpdateBookSection';
import { PageStyle } from './Home';

const UpdateBookPage = () => {
    return (
        <PageStyle>
        <Title title = {"도서수정 페이지"} />
        <UpdateBookSection />
        </PageStyle>
        );
};

export default UpdateBookPage;
