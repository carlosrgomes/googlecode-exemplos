package br.com.sulamerica.syncdependency.scheduller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskSchedulerDeploy {
	
	private final AtomicInteger counter = new AtomicInteger();
	
	@Autowired
	private FindJar findJar;
	
	@Scheduled(cron="0 */1 * * * *")
	public void process() throws IOException, InterruptedException{
		System.out.println("Contador :"+counter.incrementAndGet());
		findJar.process();
	}

}
