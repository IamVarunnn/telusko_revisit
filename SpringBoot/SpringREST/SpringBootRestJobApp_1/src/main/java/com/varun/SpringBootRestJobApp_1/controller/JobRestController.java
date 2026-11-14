package com.varun.SpringBootRestJobApp_1.controller;


import com.varun.SpringBootRestJobApp_1.model.JobPost;
import com.varun.SpringBootRestJobApp_1.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class JobRestController {

    public final JobService jobService;

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }
}
