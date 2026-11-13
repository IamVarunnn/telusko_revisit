package com.varun.JobApp_1.controller;

import com.varun.JobApp_1.model.JobPost;
import com.varun.JobApp_1.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping({"/home", "/"})
    public String home(){
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        jobService.addJob(jobPost);
        return "success";
    }


    @GetMapping("viewalljobs")
    public String getAllJobs(Model model){
        List<JobPost> jobPosts = jobService.getAllJobs();

        model.addAttribute("jobPosts", jobPosts);

        return "viewalljobs";
    }
}
