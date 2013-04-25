package br.com.exemplo.arquillian.tomcat.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientWs {
	
	
	public void chmarServico(String url){
		Client client = ClientHelper.createClient();
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		String output = response.getEntity(String.class);
		System.out.println(output);
	}

}
