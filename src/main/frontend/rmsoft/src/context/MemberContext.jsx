import { createContext, useState } from "react";

export const MemberContext = createContext();

const MemberInfo = (props) => {

    const[memberId, setMemberId] = useState("");
    const[memberNum, setMemberNum] = useState(1);
    const[isLogin, setIsLogin] = useState(false);
    
    return(
       
        <MemberContext.Provider value={{
                memberId, setMemberId,
                memberNum, setMemberNum,
                isLogin, setIsLogin,
            }}>
            {props.children}
        </MemberContext.Provider>

    );
}
export default MemberInfo;