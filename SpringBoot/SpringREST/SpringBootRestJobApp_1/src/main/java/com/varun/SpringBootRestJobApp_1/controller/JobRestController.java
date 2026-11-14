package com.varun.SpringBootRestJobApp_1.controller;


import com.varun.SpringBootRestJobApp_1.model.JobPost;
import com.varun.SpringBootRestJobApp_1.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class JobRestController {

    public final JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobPost getJob(@PathVariable("id") int postId){
        return jobService.getJob(postId);
    }

    @PostMapping("/jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
//        return jobPost;
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){

        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable("id") int postId){
        jobService.deleteJob(postId);
        return "Deleted Successfully";
    }

    @GetMapping("load")
    public String loadData(){
        jobService.load();
        return "success";
    }
}
