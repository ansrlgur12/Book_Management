import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { InputStyle } from '../signUp/SignUpMain';
import AxiosApi from '../../axios/AxiosApi';

const UpdateBook = () => {

    
    const {num} = useParams()
    const [bookName, setBookName] = useState("");
    const [author, setAuthor] = useState("");

    useEffect(()=>{
        const getBook = async() => {
            const rsp = await AxiosApi.getBook(num);
            setBookName(rsp.data.bookName);
            setAuthor(rsp.data.author);
        }
        getBook();

    },[num])

    const nav = useNavigate();

    const onChangeTitle = (e) => {
        setBookName(e.target.value)
    }
    
    const onChangeAuthor = (e) => {
        setAuthor(e.target.value)
    }

    const submit = async() => {
        const rsp2 = await AxiosApi.updateBook(num, bookName, author);
        console.log(rsp2);
        if(rsp2.status === 201) {
            alert("도서 수정 완료!");
            nav(-1);
        } else {
            alert("수정 실패!");
        }

    }

    return (
        <>
         <InputStyle>
            <h3>도서 수정</h3>
            <input value={bookName} type="text" placeholder='도서명' onChange={onChangeTitle}/>
            <input value={author} type="text" placeholder='작가명' onChange={onChangeAuthor}/>
            <button onClick={submit}>수정 완료</button>
            <button onClick={()=>nav(-1)}>뒤로 가기</button>
         </InputStyle>
        </>
    );
};

export default UpdateBook;