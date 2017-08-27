package com.boris.getandsend.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by boris on 17.08.17.
 */
@Entity
@Table(name = "main_table")
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private String status = "waiting";


    @Column(name = "create_date")
    private Date createDate = new Date();


    @Column(name = "update_date")
    private Date updateDate = new Date();

    @Column(name = "task_details")
    private String taskDetails;

    public Task() {}

    public Task(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }
}
