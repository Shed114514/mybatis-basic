package com.shed.mapper;

import com.shed.domain.Member;

import java.util.List;

public interface MemberMapper {

    int insert(Member member);

    int deleteByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Member member);

    List<Member> selectAll();
}
