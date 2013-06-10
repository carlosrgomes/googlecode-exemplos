package br.com.teste.batch.web;

import java.util.HashMap;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("run")
public class ControllerExampleJob {
	
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier("job1")
	private Job job;
	
	@Autowired
	@Qualifier("job2")
	private Job job2;
	
	@RequestMapping(value="/job1/{tentativa}",method = RequestMethod.GET)
	@ResponseBody
	public String job1(@PathVariable Long tentativa) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{
		JobParameter jobParameter = new JobParameter(tentativa);
		HashMap<String, JobParameter> map = new HashMap<String, JobParameter>();
		map.put("parameter", jobParameter);
		JobParameters parameter = new JobParameters(map);
		JobExecution execution = jobLauncher.run(job, parameter);
		return execution.getStatus().toString();
	}
	
	@RequestMapping(value="/job2/{tentativa}",method = RequestMethod.GET)
	@ResponseBody
	public String job2(@PathVariable Long tentativa) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{
		JobParameter jobParameter = new JobParameter(tentativa);
		HashMap<String, JobParameter> map = new HashMap<String, JobParameter>();
		map.put("parameter", jobParameter);
		JobParameters parameter = new JobParameters(map);
		JobExecution execution = jobLauncher.run(job2, parameter);
		return execution.getStatus().toString();
	}

}
