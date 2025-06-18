package com.kh.boot.service;

import com.kh.boot.domain.vo.Member;
import com.kh.boot.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;


    @Override
    public Member loginMember(String userId) {
        return memberMapper.loginMember(userId);
    }

    @Override
    public int insertMember(Member m) {
        return memberMapper.insertMember(m);
    }

    @Override
    public int idCheck(String userId) {
        return memberMapper.idCheck(userId);
    }
}
