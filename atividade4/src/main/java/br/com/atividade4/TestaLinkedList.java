package br.com.atividade4;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TestaLinkedList implements TestaCollections {
	

	public LinkedList<Integer> testaInsert(List<Integer> value) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (Integer integer : value) {
			linkedList.add(integer);
		}
		return linkedList;
	}

	public Integer buscar(Integer value, Collection<?> collection) {
		LinkedList<Integer> linkedList = (LinkedList<Integer>) collection;
		Integer retorno = null;
		for (int i = 0; i < linkedList.size(); i++) {
			if(linkedList.get(i).equals(value)){
				retorno = linkedList.get(i);
				break ;
			}
		}
		return retorno;
	}

}
