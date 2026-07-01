package no.alirizakeles.aijobmatcher.controller;

import no.alirizakeles.aijobmatcher.entity.Job;
import no.alirizakeles.aijobmatcher.service.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import no.alirizakeles.aijobmatcher.dto.CreateJobRequest;

import java.util.List;

@RestController
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/api/jobs")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
    @PostMapping("/api/jobs")
    public Job createJob(@RequestBody CreateJobRequest request) {
        return jobService.createJob(request);
    }
}