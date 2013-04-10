package br.com.atividade4;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnaliseDePerformace {
	
	long inicio = 0;
	long fim = 0;
	
	@Before("execution(* *.*(..)) ")
	public void logBefore(JoinPoint joinPoint){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS.s");
		System.out.println("---------------------------------- "+ simpleDateFormat.format(new Date()) +" ------------------------------------------------");
		inicio = System.currentTimeMillis();  
		System.out.println("Iniciou a execução do teste, classe: "+joinPoint.getSignature().getDeclaringType().getName()
				+ " Método: " +joinPoint.getSignature().getName() 
				);
	}
	
	@After("execution(* *.*(..)) ")
	public void logAfter(JoinPoint joinPoint){
		fim = System.currentTimeMillis();  
		System.out.println("Finalizou a execução do teste, classe: "+joinPoint.getSignature().getDeclaringType().getName()
				+ " Método: " +joinPoint.getSignature().getName() 
				+ "\n Tempo de Execução: " + (fim - inicio) +" Milisegundos"
				);
	}
	
	@AfterReturning("execution(* *.*(..)) ")
	public void logReturn(JoinPoint joinPoint){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS.s");
		System.out.println("---------------------------------- "+ simpleDateFormat.format(new Date()) +" ------------------------------------------------");
	}
	
	

}
