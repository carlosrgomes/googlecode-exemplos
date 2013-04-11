package br.com.atividade4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.WeakHashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
	
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<Integer>();
		
		for (int i = 0; i <= 30000; i++) {
			integers.add(i);
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration.xml");
		TestaArrayImpl testaArrayImpl = (TestaArrayImpl) context.getBean("testaArrayImpl");
		ArrayList<Integer> lista = 	testaArrayImpl.testaInsert(integers);
		testaArrayImpl.buscar(15000, lista);
		
		TestaLinkedList testaLinkedList = (TestaLinkedList) context.getBean("testaLinkedList");
		LinkedList<Integer> link =   testaLinkedList.testaInsert(integers);
		testaLinkedList.buscar(15000, link);
		
		TestaStack testaStack = (TestaStack) context.getBean("testaStack");
		Stack<Integer> stack = (Stack<Integer>) testaStack.testaInsert(integers);
		testaStack.buscar(15000, stack);
		
		TestaHashSet testaHashSet = (TestaHashSet) context.getBean("testaHashSet");
		HashSet<Integer> hashSet = (HashSet<Integer>) testaHashSet.testaInsert(integers);
		testaHashSet.buscar(1500, hashSet);
		
		TestaHashMap testaHashMap = (TestaHashMap) context.getBean("testaHashMap");
		HashMap<Integer, Integer> hashMap = testaHashMap.testaInsert(integers);
		testaHashMap.buscar(1500, hashMap);
		
		TestaWeakHashMap testaWeakHashMap = (TestaWeakHashMap) context.getBean("testaWeakHashMap");
		WeakHashMap<Integer, Integer> wekMap = testaWeakHashMap.testaInsert(integers);
		testaWeakHashMap.buscar(1500, wekMap);
	
	}
}
