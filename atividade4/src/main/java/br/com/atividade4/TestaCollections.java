package br.com.atividade4;

import java.util.Collection;
import java.util.List;

public interface TestaCollections {
	
	public Collection<?> testaInsert(List<Integer> value);
	
	public Integer buscar(Integer value, Collection<?> collection);

}
