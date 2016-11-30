package jp.i2qi.jersey.resource;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Application;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.i2qi.jersey.entity.Member;
import jp.i2qi.jersey.service.MemberService;
import jp.i2qi.jersey.service.MemberServiceMock;

public class MemberResourceTest extends JerseyTest {


	private EntityManagerFactory factory;

	public static class TestBinder extends AbstractBinder{

	    @Override
	    protected void configure() {

	        bind(MemberServiceMock.class).to(MemberService.class);
	    }
	}
    @Before
    public void registerTestData(){

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
    public void getTest(){

        String response = target("member")
                .queryParam("id", 1)
                .request()
                .get(String.class);

        assertEquals("fugafuga", response);



    }

    @After
    public void deleteTestData(){
    	factory = Persistence.createEntityManagerFactory("sample");
    	EntityManager manager = factory.createEntityManager();

    	manager.getTransaction().begin();

    	Member member = manager.find(Member.class, 1);
    	manager.remove(member);

    	manager.getTransaction().commit();

    }

    @Override
    protected Application configure() {
        return new ResourceConfig().register(new TestBinder()).register(MemberResource.class);

    }
}
