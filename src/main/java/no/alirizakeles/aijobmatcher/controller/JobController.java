package no.alirizakeles.aijobmatcher.controller;

import no.alirizakeles.aijobmatcher.entity.Job;
import no.alirizakeles.aijobmatcher.repository.JobRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("/api/jobs")
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}