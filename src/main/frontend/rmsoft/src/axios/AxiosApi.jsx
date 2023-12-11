import React from 'react';
import axios from "axios";

export const domain = "";

const AxiosApi = {
  
    login : async(id, pwd) => {
        const loginData = {
            memberId : id,
            memberPwd : pwd
        };
        return await axios.post(domain + "/member/login", loginData)
    },

    signUp : async(id, pwd) => {
        const signUpData = {
            memberId : id,
            memberPwd : pwd
        };
        return await axios.post(domain + "/member/insert", signUpData)
    },

    newBook : async(bookName, author) => {
        const bookData = {
            bookName : bookName,
            author : author
        };
        return await axios.post(domain + "/book/insert", bookData)
    },

    findAllBook : async() => {
        return await axios.get(domain + "/book/findAll");
    },

    getBook : async(id) => {
        return await axios.get(domain + `/book/findById/${id}`);
    },

    updateBook : async(id, bookName, author) => {
        const updateData = {
            id : id,
            bookName : bookName,
            author : author
        }
        return await axios.post(domain + "/book/update", updateData)
    },

    borrowHistory : async(id) => {
        return await axios.get(domain + `/borrow/borrowHistory/${id}`);
    },

    return : async(id) => {
        return await axios.get(domain + `/borrow/return/${id}`);
    },

    borrow : async(memberId, bookId) => {
        const borrowData = {
            memberIdStr : memberId,
            bookId : bookId
        };

        return await axios.post(domain + "/borrow/insert", borrowData)
    }

};
export default AxiosApi;