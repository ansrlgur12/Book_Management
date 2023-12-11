import React, { useEffect, useState } from 'react';
import AxiosApi from '../../axios/AxiosApi';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const UpdateBookSection = () => {

    const [bookList, setBookList] = useState([]);
    
    const nav = useNavigate();

    useEffect(()=>{
        console.log("페이지 접근");
        const getAllBook = async() => {
            const rsp = await AxiosApi.findAllBook();
            setBookList(rsp.data);
        }
        getAllBook();
    },[])

    const onClickUpdate = (num) => {
        nav(`/update/${num}`);
    }

    return (
        <>
        <h3>도서 목록</h3>
        <ListSytle>
            <div className="block title">책 번호</div>
            <div className="block title">책 이름</div>
            <div className="block title">작가 이름</div>
            <div className="block title btn">수정하기</div>
        </ListSytle>
       {bookList && bookList.map((data) => {
            return (
                <>
                <ListSytle key={data.id}>
                   <div className='block'>{data.id}</div>
                   <div className='block'>{data.bookName}</div>
                   <div className='block'>{data.author}</div>
                   <button className='block btn' onClick={()=>onClickUpdate(data.id)}>수정</button>
                </ListSytle>
                
                </>
            );
        })}
        </>
    );
};

export default UpdateBookSection;

export const ListSytle = styled.div`
    height: 50px;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;
    border-bottom: 1px solid #ccc;
    .title{
        font-weight: bold;
    }
    .block{
        width: 20%
    }
    .btn{
        width: 100px;
    }
`;