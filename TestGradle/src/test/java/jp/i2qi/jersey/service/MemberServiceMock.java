package jp.i2qi.jersey.service;

import jp.i2qi.jersey.entity.Member;

public class MemberServiceMock implements MemberService {

    @Override
    public void register(Integer id, String name) {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void update(Integer id, String name) {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public Member get(Integer id) {
        Member mem = new Member();
        mem.setName("fugafuga");
        return mem;
    }

}
