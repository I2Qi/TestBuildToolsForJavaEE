package jp.i2qi.jersey.service;

import jp.i2qi.jersey.entity.Member;

public interface MemberService {

    public void register( Integer id, String name);

    public void update(Integer id, String name);

    public Member get(Integer id);
}
