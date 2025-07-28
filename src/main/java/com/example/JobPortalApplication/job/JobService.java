package com.example.JobPortalApplication.job;

import com.example.JobPortalApplication.company.Company;

import java.util.List;

public interface JobService {
    List<Job> findAllJobs();
    void addJob(Job job);
    Job findJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id,Job job);
}
