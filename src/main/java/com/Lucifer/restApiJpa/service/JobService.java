package com.Lucifer.restApiJpa.service;

import com.Lucifer.restApiJpa.model.JobPost;
import com.Lucifer.restApiJpa.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobPost> getAllJobs(){
        return jobRepo.findAll();
    }

    public JobPost getJobById(int id){
        return jobRepo.findById(id).orElse(null);
    }

    public JobPost addJob(JobPost jobPost){
        return jobRepo.save(jobPost);
    }

    public JobPost updateJob(JobPost jobPost){
        return jobRepo.save(jobPost);
    }

    public String deleteJob(int id){
        jobRepo.deleteById(id);
        return "job Deleted SuccessFully";

    }

//    public List<JobPost> search(String keyword) {
//        return jobRepo.findByNameContainingIgnoreCase(keyword);
//    }
    public String search(String keyword) {
        return keyword;
    }

    public List<JobPost>searchByKeyword(String keyword){
        return jobRepo.findByPostProfileContainingOrPostDeskContaining(keyword, keyword);
    }


}
