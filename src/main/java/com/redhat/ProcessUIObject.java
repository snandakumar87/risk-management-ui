package com.redhat;

import java.util.List;
import java.util.Map;

public class ProcessUIObject {
    String svg;
    Map processVariables;
    List<TaskInstance> taskList;

    public List<TaskInstance> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskInstance> taskList) {
        this.taskList = taskList;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    public Map getProcessVariables() {
        return processVariables;
    }

    public void setProcessVariables(Map processVariables) {
        this.processVariables = processVariables;
    }
}
