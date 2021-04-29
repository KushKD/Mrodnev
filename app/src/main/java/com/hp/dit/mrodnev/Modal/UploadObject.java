package com.hp.dit.mrodnev.Modal;

import com.hp.dit.mrodnev.enums.TaskType;

import java.io.Serializable;

/**
 * @author Kush.Dhawan
 * @project HPePass
 * @Time 03, 05 , 2020
 */
public class UploadObject implements Serializable {

    private String url;
    private TaskType tasktype;
    private String methordName;
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public TaskType getTasktype() {
        return tasktype;
    }

    public void setTasktype(TaskType tasktype) {
        this.tasktype = tasktype;
    }

    public String getMethordName() {
        return methordName;
    }

    public void setMethordName(String methordName) {
        this.methordName = methordName;
    }

    @Override
    public String toString() {
        return "UploadObject{" +
                "url='" + url + '\'' +
                ", tasktype=" + tasktype +
                ", methordName='" + methordName + '\'' +
                ", param='" + param + '\'' +
                '}';
    }
}
