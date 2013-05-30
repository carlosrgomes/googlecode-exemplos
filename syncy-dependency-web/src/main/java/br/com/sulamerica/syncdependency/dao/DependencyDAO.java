package br.com.sulamerica.syncdependency.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import br.com.sulamerica.syncdependency.web.bean.Dependency;

@Repository
public class DependencyDAO {
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	public void insert(Dependency dependency){
		mongoTemplate.insert(dependency);
	}
	
	public List<Dependency> findAll(){
		return mongoTemplate.findAll(Dependency.class);
	}

	public void delete(Dependency[] selectedDependency) {
		for (Dependency dependency : selectedDependency) {
			mongoTemplate.remove(dependency);
		}
		
	}
	
}
