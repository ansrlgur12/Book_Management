package com.rmsoft.demo.controller;

import com.rmsoft.demo.domain.Member;
import com.rmsoft.demo.mapper.MemberMapper;
import com.rmsoft.demo.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
//@CrossOrigin(origins = "http://localhost:3000")

public class MemberController {


    @Autowired
    private MemberService memberService;


    @PostMapping("/insert")
    public ResponseEntity<String> registerMember(@RequestBody Member member) {
        try {
            memberService.insert(member);
            return new ResponseEntity<>("새로운 회원 등록 성공", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("id와 비밀번호를 입력하세요", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity<>("이미 등록된 회원입니다", HttpStatus.CONFLICT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("새로운 회원 등록 실패: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
