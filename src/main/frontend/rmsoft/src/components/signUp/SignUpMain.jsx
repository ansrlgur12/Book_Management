import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import AxiosApi from '../../axios/AxiosApi';
import styled from 'styled-components';

const SignUpMain = () => {

    const nav = useNavigate();

    const [id, setId] = useState("");
    const [pwd, setPwd] = useState(""); 

    const [isId, setIsId] = useState(true);
    const [isPw, setIsPw] = useState(true);

    const onChangeId = (e) => {
        setId(e.target.value);
        console.log(id);
        setIsId(true);
        if(e.target.value.length<=0){
            setIsId(false);
        }
    }

    const onChangePwd = (e) => {
        setPwd(e.target.value);
        console.log(pwd);
        setIsPw(true);
        if(e.target.value.length<=0){
            setIsPw(false);
        }
    }

    const onClickSignUp = async() => {
        const rsp = await AxiosApi.signUp(id, pwd);
        console.log(rsp);

        if(rsp.status === 201) {
            alert("회원가입 성공!");
            nav("/");
        } else {
            alert("회원가입 실패!");

        }


    }

    return (
        <InputStyle>
            <h3>회원 등록 페이지</h3>
            <input className='inputBox' type="text" onChange={onChangeId} placeholder='아이디'/>
            <input className='inputBox' type="password" onChange={onChangePwd} placeholder='비밀번호'/>
        
            <button className={isId && isPw ? "" : "hide"} onClick={onClickSignUp}>회원가입</button>
            <button onClick={()=>nav(-1)}>뒤로 가기</button>
        </InputStyle>
    );
};

export default SignUpMain;

export const InputStyle = styled.div`

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 20vh;

    input{
        height: 30px;
        width: 40vh;
        margin-bottom: 5vh;
    }

    button{
        height: 30px;
        width: 40vh;
        margin-bottom: 5vh;

    }

    h3{
        margin-bottom: 30px;
    }

    .hide{
        display: none;
        pointer-events: none;
        cursor: not-allowed;
        opacity: 0.5;
        background-color: rgb(70, 69, 69);
    }
`;