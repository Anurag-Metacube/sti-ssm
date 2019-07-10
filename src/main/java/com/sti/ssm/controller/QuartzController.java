package com.sti.ssm.controller;

import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sti.ssm.quartz.jobs.SampleQuartzJob;


@RestController
public class QuartzController {

	@Autowired
	private Scheduler scheduler;
	
	@RequestMapping(method=RequestMethod.GET, value="/scheduler")
	public void sampleMethd() {
		
		JobDetail jobDetail = buildJobDetail();
        Trigger trigger = buildJobTrigger(jobDetail);
        try {
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}
	
	private JobDetail buildJobDetail() {
        JobDataMap jobDataMap = new JobDataMap();

        jobDataMap.put("jobMessage", "This is Quartz Job");
        jobDataMap.put("jobCounter", 0);

        return JobBuilder.newJob(SampleQuartzJob.class)
                .withIdentity(UUID.randomUUID().toString(), "my-sample-jobs")
                .withDescription("Quartz Job")
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    private Trigger buildJobTrigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), "my-sample-triggers")
                .withDescription("Sample Trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();
    }
}
