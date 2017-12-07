package com.otipc.monitor.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chaoguo.cui on 2017/12/7.
 */
public class TestJob {

    public final Logger log = LoggerFactory.getLogger(this.getClass());

    public void doTest(){
        System.out.println("this is testjob.test");
    }
}
