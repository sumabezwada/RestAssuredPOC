package com.qa.data;

public class Users {

    String name ;
    String job;
    String id;
    String CreatedAt;

    public Users()
    {

    }

    public Users(String name,String job)
    {
        this.name=name;
        this.job=job;

    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }
    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.CreatedAt = createdAt;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
