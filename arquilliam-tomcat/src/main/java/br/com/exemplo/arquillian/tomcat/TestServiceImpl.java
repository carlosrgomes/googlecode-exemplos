package br.com.exemplo.arquillian.tomcat;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;


@Service
@Path("testService")
public class TestServiceImpl implements TesteService{
	
	
	
	@GET
	@Path("findAll")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String findAll() {
		return "teste";
	}

	
	
}
