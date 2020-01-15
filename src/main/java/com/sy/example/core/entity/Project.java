package com.sy.example.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_project")
@Getter
@Setter
@ApiModel(description = "project info")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "ID")
    private Integer id;

    @Column(length = 32)
    @ApiModelProperty(value = "project title")
    private String title;

    @Column(length = 40)
    @ApiModelProperty(value = "project description")
    private String description;

    @Column(length = 255)
    @ApiModelProperty(value = "project content")
    private String content;

    @Column(length = 32)
    @ApiModelProperty(value = "project manager")
    private String manager;

    @Column(length = 255)
    @ApiModelProperty(value = "project member")
    private String member;

    @Column(length = 11)
    @ApiModelProperty(value = "project timeSheet")
    private Integer timeSheet;

    @Column(length = 16)
    @ApiModelProperty(value = "project createDate")
    private String createDate;

    public Project() {
    }

    public Project(String title, String description, String content, String manager, String member, Integer timeSheet, String createDate) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.manager = manager;
        this.member = member;
        this.timeSheet = timeSheet;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", manager='" + manager + '\'' +
                ", member='" + member + '\'' +
                ", timeSheet=" + timeSheet +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
