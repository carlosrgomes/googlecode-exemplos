package br.com.atividade4;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TestaHashMap  {

	public HashMap<Integer, Integer> testaInsert(List<Integer> value) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		for (Integer integer : value) {
			hashMap.put(integer, integer);
		}
		return hashMap;
	}

	public Integer buscar(Integer value, HashMap<Integer, Integer> hashMap) {
		return hashMap.get(value);
	}

}
