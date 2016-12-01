package jp.i2qi.jersey.service;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import jp.i2qi.jersey.entity.Member;

@Dependent
public class MemberServiceImpl implements MemberService{


	@PersistenceContext(unitName="sample")
	EntityManager entityManager;

	@Transactional
	public void register( Integer id, String name){

		Member mem = new Member();
		mem.setId(id);
		mem.setName(name);

		entityManager.persist(mem);

	}


	@Transactional
	public void update(Integer id, String name){

		Member mem = entityManager.find(Member.class, id);
		mem.setName(name);

		entityManager.persist(mem);
	}

	public Member get(Integer id){
		return entityManager.find(Member.class, id);

	}


}
