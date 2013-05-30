package br.com.sulamerica.syncdependency.web.mb;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.sulamerica.syncdependency.dao.DependencyDAO;
import br.com.sulamerica.syncdependency.web.bean.Dependency;

@ManagedBean
@ViewScoped
@Controller
public class DependencyMB {
		
	private String nameJar;
	private List<Dependency> listJars;
	private Dependency[] selectedDependency;
	
	
	@Autowired
	private DependencyDAO dependencyDAO;
	
	@PostConstruct
	public void init(){
		this.listJars = dependencyDAO.findAll();
	}
	
	public Dependency[] getSelectedDependency() {
		return selectedDependency;
	}
	
	public void setSelectedDependency(Dependency[] selectedDependency) {
		this.selectedDependency = selectedDependency;
	}

	public String getNameJar() {
		return nameJar;
	}

	public void setNameJar(String nameJar) {
		this.nameJar = nameJar;
	}
	
	
	public void salvar(ActionEvent actionEvent){
		Dependency dependency = new Dependency();
		dependency.setDateCreate(new Date());
		dependency.setName(this.nameJar);
		dependencyDAO.insert(dependency);
		this.listJars = dependencyDAO.findAll();
	}
	
	public List<Dependency> getListJars() {
		return listJars;
	}
	
	public void delete(ActionEvent actionEvent){
		dependencyDAO.delete(selectedDependency);
		this.listJars = dependencyDAO.findAll();
	}
	
	
	
}
