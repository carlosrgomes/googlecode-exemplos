package br.com.atividade4;

import java.util.List;
import java.util.WeakHashMap;

import org.springframework.stereotype.Component;

@Component
public class TestaWeakHashMap  {

	public WeakHashMap<Integer, Integer>  testaInsert(List<Integer> value) {
		WeakHashMap<Integer, Integer> weakHashMap = new 	WeakHashMap<Integer, Integer>();
		for (Integer integer : value) {
			weakHashMap.put(integer, integer);
		}
		
		return weakHashMap;
	}

	public Integer buscar(Integer value, WeakHashMap<Integer, Integer>  collection) {
		return collection.get(value);
	}

}
