package com.otipc.monitor.controller;

import com.alibaba.fastjson.JSON;
import com.otipc.monitor.domain.ScheduleJob;
import com.otipc.monitor.job.TestJob;
import com.otipc.monitor.service.JobTaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class JobTaskController {

    public final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JobTaskService taskService;


    @RequestMapping("/add")
    public String add() {

        try {
            ScheduleJob job = new ScheduleJob();
            job.setBeanClass(TestJob.class.getName());
            job.setCreateTime(new Date());
            job.setCronExpression("0/30 * * * * ?");
            job.setJobGroup("test");
            job.setMethodName("doTest");
            job.setJobId(121L);
            job.setJobName("test-job-name");


            taskService.startJob(job, "start");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "error";
    }

    @RequestMapping("/getList")
    public String getList() {
        try {
            List<ScheduleJob> list = taskService.getAllJob();
            return JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";

    }

    @RequestMapping("/getRunningList")
    public String getRunningList() {
        try {
            List<ScheduleJob> list = taskService.getRunningJob();
            return JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/pauseJob")
    public String pauseJob() {
        ScheduleJob job = new ScheduleJob();
        job.setBeanClass(TestJob.class.getName());
        job.setCreateTime(new Date());
        job.setCronExpression("0/30 * * * * ?");
        job.setJobGroup("test");
        job.setMethodName("doTest");
        job.setJobId(121L);
        job.setJobName("test-job-name");
        try {
            taskService.pauseJob(job);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/resumeJob")
    public String resumeJob() {
        ScheduleJob job = new ScheduleJob();
        job.setBeanClass(TestJob.class.getName());
        job.setCreateTime(new Date());
        job.setCronExpression("0/30 * * * * ?");
        job.setJobGroup("test");
        job.setMethodName("doTest");
        job.setJobId(121L);
        job.setJobName("test-job-name");
        try {
            taskService.resumeJob(job);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/runAJobNow")
    public String runAJobNow() {
        ScheduleJob job = new ScheduleJob();
        job.setBeanClass(TestJob.class.getName());
        job.setCreateTime(new Date());
        job.setCronExpression("0/30 * * * * ?");
        job.setJobGroup("test");
        job.setMethodName("doTest");
        job.setJobId(122L);
        job.setJobName("test-job-name");
        try {
            taskService.runAJobNow(job);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
