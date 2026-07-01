package no.alirizakeles.aijobmatcher.service;

import no.alirizakeles.aijobmatcher.repository.JobRepository;
import org.springframework.stereotype.Service;
import no.alirizakeles.aijobmatcher.entity.Job;
import no.alirizakeles.aijobmatcher.dto.CreateJobRequest;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    public Job createJob(CreateJobRequest request) {

        Job job = new Job();

        job.setTitle(request.getTitle());
        job.setCompanyName(request.getCompanyName());
        job.setLocation(request.getLocation());
        job.setDescription(request.getDescription());
        job.setUrl(request.getUrl());
        job.setEmploymentType(request.getEmploymentType());

        return jobRepository.save(job);
    }
}