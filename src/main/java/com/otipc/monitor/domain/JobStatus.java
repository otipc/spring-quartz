package com.otipc.monitor.domain;

/**
 * Created by chaoguo.cui on 2017/12/7.
 */
public enum JobStatus {
    RUNNING(1),
    NOT_RUNNING(0),
    CONCURRENT_IS(1),
    CONCURRENT_NOT(0);

    private int code;

    private int getCode() {
        return this.code;
    }

    JobStatus(int code) {
        this.code = code;
    }

}
