package jp.i2qi.jersey.entity;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMember {

	private EntityManagerFactory factory;

	@Before
	public void setUp(){

		factory = Persistence.createEntityManagerFactory("sample");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		Member mem = new Member();
		mem.setId(1);
		mem.setName("hogehoge");

		manager.persist(mem);

		manager.getTransaction().commit();

		manager.close();

	}

	@Test
	public void checkMember(){

		EntityManager manager = this.factory.createEntityManager();

		Query q = manager.createQuery("select m from Member m");

		assertTrue(q.getResultList().size() == 1);


	}


	@After
	public void after(){
		factory = Persistence.createEntityManagerFactory("sample");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		Member member = manager.find(Member.class, 1);
		manager.remove(member);

		manager.getTransaction().commit();

	}

}
