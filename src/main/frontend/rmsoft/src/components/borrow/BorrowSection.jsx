import React, { useState } from 'react';
import { InputStyle } from '../signUp/SignUpMain';
import { useNavigate, useParams } from 'react-router-dom';
import Title from '../home/Title';
import AxiosApi from '../../axios/AxiosApi';

const BorrowSection = () => {

    const {num} = useParams();
    const nav = useNavigate();
    const [memberId, setMemberId] = useState("");
    const [id, setId] = useState(false);

    const borrow = async() => {
        if(memberId.length <= 0) {
            alert("아이디를 입력하세요")
            return;
        }
        const rsp = await AxiosApi.borrow(memberId, num);
        console.log(rsp);
        if(rsp.data === "대출 성공") {
            alert("대여 완료!");
            nav(-1);
        } else {
            alert("대여 실패!");
        }

    }

    const onChangeId = (e) => {
        setMemberId(e.target.value);
        setId(true);
        if(e.target.value.length <= 0) {
            setId(false);
        }
    }   

    return (
        <>
        <Title title={"도서 대여"} />
        <InputStyle>
            <input type="text" placeholder='아이디' onChange={onChangeId}/>
            <button className={id ? "" : "hide"} onClick={borrow}>대여</button>
            <button onClick={()=> nav(-1)}>뒤로 가기</button>
        </InputStyle>
        </>
    );
};

export default BorrowSection;