package com.sy.example.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name= "t_task")
@ApiModel(value = "task info")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "ID")
    private Integer id;

    @Column(length = 32)
    @ApiModelProperty(value = "task title")
    private String title;

    @Column(length = 32)
    @ApiModelProperty(value = "task description")
    private String description;

    @Column(length = 255)
    @ApiModelProperty(value = "task content")
    private String content;

    @Column(length = 32)
    @ApiModelProperty(value = "task owner")
    private String owner;

    @Column(length = 11)
    @ApiModelProperty(value = "task timeSheet")
    private Integer timeSheet;

    @Column(length = 11)
    @ApiModelProperty(value = "task spentTime")
    private Integer spentTime;

    @Column(length = 16)
    @ApiModelProperty(value = "task fromDate")
    private String fromDate;

    @Column(length = 11)
    @ApiModelProperty(value = "task status")
    private String status;

    @Column(length = 11)
    @ApiModelProperty(value = "the task belongs to the project")
    private Integer parentProjectId;

    public Task() {
    }

    public Task(String title, String description, String content, String owner, Integer timeSheet, Integer spentTime, String fromDate, String status, Integer parentProjectId) {
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", owner='" + owner + '\'' +
                ", timeSheet=" + timeSheet +
                ", spentTime=" + spentTime +
                ", fromDate='" + fromDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
