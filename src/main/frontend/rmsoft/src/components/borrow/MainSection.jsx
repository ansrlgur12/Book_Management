import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import AxiosApi from '../../axios/AxiosApi';
import { ListSytle } from '../book/UpdateBookSection';

const BorrowMainSection = () => {

    const [bookList, setBookList] = useState([]);
    
    const nav = useNavigate();

    useEffect(()=>{
        const getAllBook = async() => {
            const rsp = await AxiosApi.findAllBook();
            setBookList(rsp.data);
            console.log(rsp.data);
        }
        getAllBook();
    },[])

    const onClickReturn = async(id) => {
        const rsp2 = await AxiosApi.return(id);
        console.log(rsp2);
        if(rsp2.data === "반납 성공") {
            alert("도서 반납 완료!");
            nav(-1);
        } else {
            alert("반납 실패!");
        }
    }

    const onClickBorrow = (num) => {
        nav(`/borrow/${num}`);
    }


    return (
        <>
        <h3>도서 목록</h3>
        <ListSytle>
            <div className="block title">책 번호</div>
            <div className="block title">책 이름</div>
            <div className="block title">작가 이름</div>
            <div className="block title">대여 가능 여부</div>
            <div className="block title btn">대여 / 반납</div>
        </ListSytle>
       {bookList && bookList.map((data) => {
            return (
                <>
                <ListSytle key={data.id}>
                   <div className='block'>{data.id}</div>
                   <div className='block'>{data.bookName}</div>
                   <div className='block'>{data.author}</div>
                   <div className='block'>{data.status}</div>
                   {data.status === "Borrowed" ? 
                    <button className="block btn" onClick={()=>onClickReturn(data.id)}>반납하기</button>
                   : 
                   <button className='block btn' onClick={()=>onClickBorrow(data.id)}>대여하기</button>
                   }
                </ListSytle>
                
                </>
            );
        })}
        </>
    );
};

export default BorrowMainSection;