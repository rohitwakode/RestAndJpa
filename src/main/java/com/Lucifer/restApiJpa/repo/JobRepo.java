package com.Lucifer.restApiJpa.repo;

import com.Lucifer.restApiJpa.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostProfileContainingOrPostDeskContaining(
            String postProfile,
            String postDesk
    );

}
