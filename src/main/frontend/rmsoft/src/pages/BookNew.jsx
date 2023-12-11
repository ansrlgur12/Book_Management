import React from 'react';
import Title from '../components/home/Title';
import NewBookSection from '../components/book/NewBook';
import { PageStyle } from './Home';

const NewBookPage = () => {
    return (
        <PageStyle>
        <Title title={"신규 도서 페이지"} />
        <NewBookSection />
        </PageStyle>
    );
};

export default NewBookPage;