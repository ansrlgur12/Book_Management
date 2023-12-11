import React, { useEffect, useState } from 'react';
import { ListSytle } from './UpdateBookSection';
import AxiosApi from '../../axios/AxiosApi';
import { useNavigate } from 'react-router-dom';

const BookHistorySection = () => {

    const [bookList, setBookList] = useState([]);
    const nav = useNavigate();

    useEffect(()=> {
        const getAllBook = async() => {
            const rsp = await AxiosApi.findAllBook();
            setBookList(rsp.data);
        }
        getAllBook();

    },[])

    const onClickSearch = (num) => {
        nav(`/history/${num}`);
    }

    return (
        <>
            <h3>도서 목록</h3>
            <ListSytle>
                <div className="block title">책 번호</div>
                <div className="block title">책 이름</div>
                <div className="block title">작가 이름</div>
                <div className="block title">대여 상태</div>
                <div className="block title btn">조회하기</div>
            </ListSytle>
        {bookList && bookList.map((data) => {
            return (
                <>
                <ListSytle key={data.id}>
                   <div className='block'>{data.id}</div>
                   <div className='block'>{data.bookName}</div>
                   <div className='block'>{data.author}</div>
                   <div className='block'>{data.status}</div>
                   <button className='block btn' onClick={()=>onClickSearch(data.id)}>조회</button>
                </ListSytle>
                
                </>
            );
        })}
        </>
    );
};

export default BookHistorySection;