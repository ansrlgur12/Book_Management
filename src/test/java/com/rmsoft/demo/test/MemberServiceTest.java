package com.rmsoft.demo.test;

import com.rmsoft.demo.domain.Member;
import com.rmsoft.demo.mapper.MemberMapper;
import com.rmsoft.demo.service.member.MemberService;
import com.rmsoft.demo.service.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MemberServiceTest {

    @Mock
    private MemberMapper memberMapper;

    @InjectMocks
    private MemberServiceImpl memberService;


    @Test
    void insert() {
        Member member = new Member();
        member.setMemberId("testId");
        member.setMemberPwd("12312");

        memberService.insert(member);
    }

    @Test
    void insert2() {
        Member member = new Member();
        member.setMemberId("");
        member.setMemberPwd("");
        assertThrows(IllegalArgumentException.class, () -> memberService.insert(member));
    }
}