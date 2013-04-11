package br.com.atividade4;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TestaHashSet implements TestaCollections {

	public Collection<?> testaInsert(List<Integer> value) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		for (Integer integer : value) {
			hashSet.add(integer);
		}
		return hashSet;
	}

	public Integer buscar(Integer value, Collection<?> collection) {
		HashSet<Integer> hashSet = (HashSet<Integer>) collection;
		Integer valueReturn = null;
		for (Integer integer : hashSet) {
			if (integer.equals(value)) {
				valueReturn = integer;
			}
			break;
		}
		return valueReturn;
	}

}
