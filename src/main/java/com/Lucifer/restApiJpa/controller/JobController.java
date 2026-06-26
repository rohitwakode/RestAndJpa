package com.Lucifer.restApiJpa.controller;

import com.Lucifer.restApiJpa.model.JobPost;
import com.Lucifer.restApiJpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/job")
    public List<JobPost>getAllJob(){
        return jobService.getAllJobs();
    }

    @GetMapping("/job/{PostId}")
    public JobPost getJobById(@PathVariable int PostId){
        return jobService.getJobById(PostId);
    }

    @PostMapping("/job")
    public JobPost addJob(@RequestBody JobPost jobPost){
         jobService.addJob(jobPost);
         return jobService.getJobById(jobPost.getPostId());
    }

    @PutMapping("/job")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJobById(jobPost.getPostId());
    }

    @DeleteMapping("/job")
    public String deleteJob(@PathVariable int id){
        return jobService.deleteJob(id);
    }

//    @GetMapping("/search")
//    public List<JobPost> search(
//            @RequestParam String keyword) {
//
//        return jobService.search(keyword);
//    }


    @GetMapping("/job/search/{keyword}")
    public List<JobPost> search(@PathVariable String keyword) {
        return jobService.searchByKeyword(keyword);
    }


}
