package br.com.atividade4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TestaArrayImpl implements TestaCollections {
	
	

	public ArrayList<Integer> testaInsert(List<Integer> value) {
	 ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (Integer integer : value) {
			arrayList.add(integer);
		}
		return arrayList;

	}

	public Integer buscar(Integer value, Collection<?> collection) {
		ArrayList<Integer> arrayList =  (ArrayList<Integer>) collection;
		Integer retorno = null;
		for (Integer integer : arrayList) {
			if(integer.equals(value)){
				retorno = integer;
				break;
			}
			
		}
		return retorno;
	}

}
