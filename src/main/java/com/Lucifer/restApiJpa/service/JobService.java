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

//    public Employee getEmployeeById(int id) {
//        return repository.findById(id)
//                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found"));
//    }

    public JobPost updateJob(int id, JobPost jobPost) {

        //if not throw exception not found
        JobPost existingJob = getJobById(id);

        if (jobPost.getPostProfile()!= null && !jobPost.getPostProfile().trim().isEmpty()) {
            existingJob.setPostProfile(jobPost.getPostProfile());
        }

        if (jobPost.getPostDesk()!=null && !jobPost.getPostDesk().trim().isEmpty()) {
            existingJob.setPostDesk(jobPost.getPostDesk());
        }

        if (jobPost.getReqExperience()!=null) {
            existingJob.setReqExperience(jobPost.getReqExperience());
        }
        if (jobPost.getPostTechStack()!=null&& !jobPost.getPostTechStack().isEmpty()) {
            existingJob.setPostTechStack(jobPost.getPostTechStack());
        }
        return jobRepo.save(existingJob);
    }

    public String deleteJob(int id){
        jobRepo.deleteById(id);
        return "job Deleted SuccessFully";

    }

    public String search(String keyword) {
        return keyword;
    }

    public List<JobPost>searchByKeyword(String keyword){
        return jobRepo.findByPostProfileContainingOrPostDeskContaining(keyword, keyword);
    }


}
