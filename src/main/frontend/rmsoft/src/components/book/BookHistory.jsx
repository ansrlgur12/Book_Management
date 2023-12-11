import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import AxiosApi from '../../axios/AxiosApi';
import Title from '../home/Title';
import { ListSytle } from './UpdateBookSection';
import { PageStyle } from '../../pages/Home';



const BookHistory = () => {

    const {num} = useParams();

    const [historyData, setHistoryData] = useState([]);

    useEffect(()=>{
        const getHistory = async() => {
            const rsp = await AxiosApi.borrowHistory(num);
            setHistoryData(rsp.data);
        }
        getHistory();

    },[num])

    return (
        <PageStyle>
        <Title title={"대출 이력"} />
        <ListSytle>
                   <div className='block'>책 이름</div>
                   <div className='block'>대여 회원</div>
                   <div className='block'>대여 날짜</div>
                   <div className='block'>반납 날짜</div>
                </ListSytle>
        {historyData.length !== 0 ? historyData.map((data) => {
            return(
                <>
                <ListSytle key={data.id}>
                   <div className='block'>{data.bookName}</div>
                   <div className='block'>{data.memberIdStr}</div>
                   <div className='block'>{data.borrowDate}</div>
                   <div className='block'>{data.returnDate ? data.returnDate : "not returned"}</div>
                </ListSytle>
                
                </>
            )
        }) : 
            <h3>기록 없음</h3>
        }
        </PageStyle>
    );
};

export default BookHistory;