package com.qa.data;

public class Users {

    String name ;
    String job;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
