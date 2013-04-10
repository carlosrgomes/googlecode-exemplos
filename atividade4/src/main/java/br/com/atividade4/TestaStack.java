package br.com.atividade4;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Component;

@Component
public class TestaStack implements TestaCollections {
	
	

	public Collection<?> testaInsert(List<Integer> value) {
		Stack<Integer> stack = new Stack<Integer>();
		for (Integer integer : value) {
			stack.push(integer);
		}
		return stack;
	}

	public Integer buscar(Integer value, Collection<?> collection) {
		Integer retorno = null;
		Stack<Integer> stack = (Stack<Integer>) collection;
		for (int i = 0; i < stack.size(); i++) {
			retorno = stack.pop();
			if(retorno.equals(value)){
				break;
			}
		}
		
		return retorno;
	}

}
