package com.sti.ssm.quartz.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SampleQuartzJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		 
        String jobMessage = dataMap.getString("jobMessage");
        Integer counter = dataMap.getInt("jobCounter");
        System.out.println("Job message: " + jobMessage + counter);
        counter++;
        dataMap.put("jobCounter" , counter);
	}


}
