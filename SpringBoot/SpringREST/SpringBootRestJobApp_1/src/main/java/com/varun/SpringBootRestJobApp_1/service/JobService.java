package com.varun.SpringBootRestJobApp_1.service;

import com.varun.SpringBootRestJobApp_1.model.JobPost;
import com.varun.SpringBootRestJobApp_1.repository.JobRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobService {

    private final JobRepo jobRepo;

    public void addJob(JobPost jobPost){

        jobRepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){

        return jobRepo.getAllJobs();
    }

    public JobPost getJob(int postId) {

        return jobRepo.getJob(postId);
    }

    public JobPost updateJob(JobPost jobPost) {

        jobRepo.updateJob(jobPost);
        return jobRepo.getJob(jobPost.getPostId());
    }

    public void deleteJob(int postId) {
        jobRepo.deleteJob(postId);
    }
}
