package no.alirizakeles.aijobmatcher.service;

import no.alirizakeles.aijobmatcher.repository.JobRepository;
import org.springframework.stereotype.Service;
import no.alirizakeles.aijobmatcher.entity.Job;

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
}