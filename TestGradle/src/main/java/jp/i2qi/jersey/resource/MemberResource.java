package jp.i2qi.jersey.resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jp.i2qi.jersey.entity.Member;
import jp.i2qi.jersey.service.MemberService;

@Path("member")
@RequestScoped
public class MemberResource {

    @Inject
    MemberService memberService;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(
            @QueryParam("id") Integer id )throws Exception{


        Member mem = this.memberService.get(id);

        return mem.getName();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(
            @FormParam("id") Integer id, @FormParam("name") String name)throws Exception{


        this.memberService.register(id, name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(
            @FormParam("id") Integer id, @FormParam("name") String name)throws Exception{

        this.memberService.update(id, name);
    }
}
