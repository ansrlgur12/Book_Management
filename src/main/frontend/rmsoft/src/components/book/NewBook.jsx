import React, { useState } from 'react';
import { InputStyle } from '../signUp/SignUpMain';
import { useNavigate } from 'react-router-dom';
import AxiosApi from '../../axios/AxiosApi';

const NewBookSection = () => {

    const nav = useNavigate();

    const [bookName, setBookName] = useState("");
    const [author, setAuthor] = useState("");


    const onChangeBookName = (e) => {
        setBookName(e.target.value);
    
    }

    
    const onChangeAuthor = (e) => {
        setAuthor(e.target.value);

    }

    const submit = async () => {
        try {
            const rsp = await AxiosApi.newBook(bookName, author);
            console.log(rsp);
    
            if (rsp.status === 201) {
                alert("신규 도서 등록 성공!");
                nav(-1);
            }
        } catch (error) {
                alert("도서명과 작가는 필수 입력 항목입니다.");
        }
    };
    
    return (
        <InputStyle>
        <input type="text" placeholder='도서명' onChange={onChangeBookName}/>
        <input type="text" placeholder='작가명' onChange={onChangeAuthor}/>
        <button onClick={submit}>등록</button>
        <button onClick={()=>nav(-1)}>뒤로가기</button>
        </InputStyle>
    );
};

export default NewBookSection;