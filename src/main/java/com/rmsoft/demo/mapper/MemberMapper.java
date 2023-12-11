package com.rmsoft.demo.mapper;

import com.rmsoft.demo.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("SELECT id FROM MEMBER WHERE member_id = #{id}")
    Long findByMemberId(String id);

    @Insert("INSERT INTO MEMBER(member_id, member_pwd) VALUES(#{memberId}, #{memberPwd})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert (Member member);

    @Select("SELECT COUNT(*) FROM MEMBER WHERE member_id = #{param1} AND member_pwd = #{param2}")
    boolean login(@Param("memberId") String memberId, @Param("memberPwd") String memberPwd);


}
