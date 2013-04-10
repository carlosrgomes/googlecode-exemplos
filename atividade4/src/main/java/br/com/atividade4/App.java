package br.com.atividade4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
	
	}
}
