package com.varun.SpringBootRestJobApp_1.repository;


import com.varun.SpringBootRestJobApp_1.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {


    List<JobPost> jobs = new ArrayList<>(List.of(
            new JobPost(
                    1,
                    "Java Developer",
                    "Responsible for developing scalable backend applications using Java, Spring Boot, and REST APIs.",
                    2,
                    List.of("Java", "Spring Boot", "Hibernate", "MySQL")
            ),
            new JobPost(
                    2,
                    "Frontend Developer",
                    "Responsible for building responsive and user-friendly web applications.",
                    1,
                    List.of("HTML", "CSS", "JavaScript", "React")
            ),
            new JobPost(
                    3,
                    "Full Stack Developer",
                    "Develop and maintain both frontend and backend components of web applications.",
                    3,
                    List.of("Java", "Spring Boot", "React", "MongoDB")
            ),
            new JobPost(
                    4,
                    "Python Developer",
                    "Build backend services, REST APIs, and automation solutions using Python.",
                    2,
                    List.of("Python", "Django", "Flask", "PostgreSQL")
            ),
            new JobPost(
                    5,
                    "DevOps Engineer",
                    "Manage cloud infrastructure, automate deployments, and maintain CI/CD pipelines.",
                    4,
                    List.of("AWS", "Docker", "Kubernetes", "Jenkins")
            ),
            new JobPost(
                    6,
                    "Android Developer",
                    "Design, develop, and maintain Android mobile applications.",
                    2,
                    List.of("Java", "Kotlin", "Android Studio", "Firebase")
            )
    ));

    public List<JobPost> getAllJobs(){

        return jobs;
    }

    public void addJob(JobPost jobPost){
        jobs.add(jobPost);
    }
}