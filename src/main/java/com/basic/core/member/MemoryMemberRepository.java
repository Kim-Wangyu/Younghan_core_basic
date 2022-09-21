package com.basic.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //실무에서는 동시성 Issue때문에 동시성Concurency를 써야함
        //해당 Map, HashMap은 DB연동이 아닌 메모리 멤버레포지에 값을 넣어야할 때
        //키값, Value값을 매칭해줄 수 방법으로 사용
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
