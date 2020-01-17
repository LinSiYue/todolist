package com.sy.example.core.dto;

import com.sy.example.core.entity.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class TaskDTO {

    private Integer id;

    private String title;

    private String description;

    private String content;

    private String[] owner;

    private Integer timeSheet;

    private Integer spentTime;

    private String fromDate;

    private String status;

    private Integer parentProjectId;

    public TaskDTO(Integer id, String title, String description, String content, String[] owner, Integer timeSheet, Integer spentTime, String fromDate, String status, Integer parentProjectId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.owner = owner;
        this.timeSheet = timeSheet;
        this.spentTime = spentTime;
        this.fromDate = fromDate;
        this.status = status;
        this.parentProjectId = parentProjectId;
    }

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.content = task.getContent();
        this.timeSheet = task.getTimeSheet();
        this.spentTime = task.getSpentTime();
        this.fromDate = task.getFromDate();
        this.status = task.getStatus();
        this.parentProjectId = task.getParentProjectId();
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", owner=" + Arrays.toString(owner) +
                ", timeSheet=" + timeSheet +
                ", spentTime=" + spentTime +
                ", fromDate='" + fromDate + '\'' +
                ", status='" + status + '\'' +
                ", parentProjectId=" + parentProjectId +
                '}';
    }
}
