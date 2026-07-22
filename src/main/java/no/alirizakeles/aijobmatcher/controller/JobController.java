package no.alirizakeles.aijobmatcher.controller;

import no.alirizakeles.aijobmatcher.entity.Job;
import no.alirizakeles.aijobmatcher.service.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import no.alirizakeles.aijobmatcher.dto.CreateJobRequest;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import no.alirizakeles.aijobmatcher.dto.UpdateJobRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/api/jobs/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }
    @GetMapping("/api/jobs/search")
    public List<Job> searchJobs(@RequestParam String keyword) {
        return jobService.searchJobs(keyword);
    }
    @GetMapping("/api/jobs/search/location")
    public List<Job> searchJobsByLocation(@RequestParam String location) {
        return jobService.searchJobsByLocation(location);
    }
    @PostMapping("/api/jobs")
    public Job createJob(@Valid @RequestBody CreateJobRequest request) {
        return jobService.createJob(request);
    }
    @PutMapping("/api/jobs/{id}")
    public Job updateJob(
            @PathVariable Long id,
            @Valid @RequestBody UpdateJobRequest request) {

        return jobService.updateJob(id, request);
    }
    @DeleteMapping("/api/jobs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }
}