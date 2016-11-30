package jp.i2qi.jersey.resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
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


        try{
        Member mem = this.memberService.get(id);

        return mem.getName();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "";

    }
}
