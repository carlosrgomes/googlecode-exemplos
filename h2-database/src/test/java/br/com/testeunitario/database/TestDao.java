package br.com.testeunitario.database;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;



public class TestDao {
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private EmbeddedDatabase db;
	
	@Before
	public void init(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.H2);
	    db = builder.addScript("db-schema.sql").build();
	    dataSource = db;
	    
	}
	
	@Test
	public void testDao() throws SQLException{
		ServicoDaoImpl servicoDaoImpl = new ServicoDaoImpl(db);
		Servico servico = servicoDaoImpl.buscarServico(1, 544);
		Assert.assertEquals(1, servico.getCodServico());
		Assert.assertEquals("descricao abreviada", servico.getDescricao());
		 
		 
	}
	
	
	
	
	@After
	public void closeConecction(){
		db.shutdown();
	}

}
