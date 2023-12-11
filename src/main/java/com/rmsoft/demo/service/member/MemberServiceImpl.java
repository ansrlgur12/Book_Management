package com.rmsoft.demo.service.member;

import com.rmsoft.demo.domain.Member;
import com.rmsoft.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;


    @Override
    @Transactional
    public void insert(Member member) {
        if (StringUtils.isEmpty(member.getMemberId()) || StringUtils.isEmpty(member.getMemberPwd())) {
            throw new IllegalArgumentException("id와 비밀번호를 입력하세요.");
        }
        memberMapper.insert(member);
    }

}
